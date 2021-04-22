package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Org_Generator_Activity extends Activity {
    private static final String TAG = "Org_Generator_Activity";

    static int constZeile_max  = 12;
    static int constSpalte_max = 6;

    static tEndpunkte[] arrEndpunkte = new tEndpunkte[1];
    static tElemente[]  arrElemente  = new tElemente[1];
    static tKetten[]    arrKetten    = new tKetten[1];

    String[][] arrGitter = new String[constZeile_max][constSpalte_max]; // 12 Zeilen (0..11), 6 Spalten (0..5)

    List<String> arrElementePos = new ArrayList<String>(); // String-List, um die Positionsangaben (Zeile/Spalte) der verwendeten Felder im Gitter aufzunehmen

    String strZeile;  // beginnend ab 1!
    String strSpalte; // beginnend ab 1!

    int resIdFeld;
    int intAnzahlAktiveZellen;
    int intKEYCODE_BACK_Counter;
    float fltMolmasse = 0;

    // Objekt vom Typ "Org_GeneratorTools" instanzieren, damit Konstruktor ausgeführt wird
    Org_GeneratorTools objOrg_GeneratorTools = new Org_GeneratorTools();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_generator);

        // Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);
    } // onCreate

    @Override
    public void onDestroy() {
        super.onDestroy();

        // alle Activities AUSSER "HauptmenueActivity" schliessen
        ActivityRegistry.finishAll("HauptmenueActivity");
    } // onDestroy

    @Override
    public void onResume()
    {
        super.onResume();

        intKEYCODE_BACK_Counter = 0;

        if(resIdFeld == 0) {
            // Es wurde noch kein Element (in "Org_Strukturformeln_Activity") ausgewählt
            // Toast anzeigen
            String text = "\n   Zum Starten beliebige Zelle antippen.   \n";
            Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
            Meldung.setGravity(Gravity.BOTTOM, 0, 0);
            Meldung.show();
        }
        else
        {
            // Es wurde wurde bereits ein Element (in "Org_Strukturformeln_Activity") ausgewählt
            ImageButton ibt;

            // In der Activity "Org_Strukturformeln_Activity.java" werden in der Methode "btnZelle"
            // die Schlüssel "Strukturformel-Zellenname" und "Strukturformel-ResId" gesetzt.
            // Die Werte sind abhängig von dem Bild, das man im Layout "org_strukturformeln.xml" angetippt hat.
            // Diese Schlüssel können nun hier gelesen / ausgewertet werden
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

            int intResId = prefs.getInt("Strukturformel-ResId", 0);
            if(intResId != 0) {
                ibt = (ImageButton) findViewById(resIdFeld);

                // strZellenname aus Preferences lesen ("Strukturformel-Zellenname")
                String strZellenname = prefs.getString("Strukturformel-Zellenname", "");

                int intZeile  = Integer.parseInt(strZeile ) - 1;
                int intSpalte = Integer.parseInt(strSpalte) - 1;

                arrGitter[intZeile][intSpalte] = strZellenname;

                if (checkGitter() == true) {
                    ibt.setImageResource(intResId);

                    if (arrElementePos != null && !arrElementePos.isEmpty()) {
                        // es wurde bereits mind. 1 Element platziert
                        // Sicherheitshalber ein möglicherweise vorhandens Element aus der Liste entfernen.
                        // Wichtig, falls ein Element überschrieben wurde und anschließend entfernt werden soll.
                        arrElementePos.remove(strZeile+strSpalte);
                    }

                    arrElementePos.add(strZeile+strSpalte);

                    setzeFelder();
                }
                else {
                    arrGitter[intZeile][intSpalte]= null;
                }
            }
        }
    } // onResume

    @Override
    public void onPause() {
        super.onPause();
    } // onPause

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            intKEYCODE_BACK_Counter++;
            switch (intKEYCODE_BACK_Counter) {
                case 1: {
                    String text = "\n   Zum Beenden erneut drücken.   \n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                    Meldung.setGravity(Gravity.BOTTOM, 0, 0);
                    Meldung.show();

                    break;
                }
                case 2: {
                    ActivityRegistry.finishAll();
                    Intent intent = new Intent(this, HauptmenueActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    return true;
                }
            } // switch
        }
        return true;
    } // onKeyDown

    public void btnFeld(View v)
    {
        resIdFeld = v.getId();
        String strZellenname = getResources().getResourceEntryName(resIdFeld);  // Zellenname (String) zur ID ermitteln (Bsp.: "ibtFeld_011")

        // Zeile/Spalte aus Feldnamen der aktuellen Zelle (resIdFeld) ermitteln (=strZeile/strSpalte)
        strZeile  = strZellenname.substring( 8,10);   // Beispiel: ibtFeld_115 => 11
        strSpalte = strZellenname.substring(10,11);   // Beispiel: ibtFeld_115 => 5

        int intZeile  = Integer.parseInt(strZeile );
        int intSpalte = Integer.parseInt(strSpalte);

        int[] arrFilter = new int[4];

        if (intZeile == 1) {
            // in Zeile 1 keine Bindung auf 12 Uhr zulassen
            arrFilter[0] = 9;
        }
        else if (intZeile == constZeile_max) {
            // in letzter Zeile keine Bindung auf 6 Uhr zulassen
            arrFilter[2] = 9;
        }
        if (intSpalte == 1) {
            // in Spalte 1 keine Bindung auf 9 Uhr zulassen
            arrFilter[3] = 9;
        }
        else if (intSpalte == constSpalte_max) {
            // in letzter Spalte keine Bindung auf 3 Uhr zulassen
            arrFilter[1] = 9;
        }

        // Bindungseigenschaften der 4 Nachbarzellen auswerten
        int intZeile_Gitter;  // Zeile für Gitter fängt bei 0 an!
        int intSpalte_Gitter; // Spalte für Gitter fängt bei 0 an!
        int intBindung;
        String strBilddateiname;

        // Prüfen, ob Nachbarzelle auf 12 Uhr vorhanden ist und ggf. deren Bindungseigenschaft auf 6 Uhr auswerten
        intZeile_Gitter  = intZeile  - 1;
        intSpalte_Gitter = intSpalte - 1;
        if (intZeile > 1) {
            intZeile_Gitter = intZeile_Gitter - 1;
            strBilddateiname = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strBilddateiname == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[0] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strBilddateiname.substring(4, 5));
                if (intBindung == 0) {
                    arrFilter[0] = 9;
                } else {
                    arrFilter[0] = intBindung;
                }
            }
        }

        // Prüfen, ob Nachbarzelle auf 3 Uhr vorhanden ist und ggf. deren Bindungseigenschaft auf 9 Uhr auswerten
        intZeile_Gitter  = intZeile  - 1;
        intSpalte_Gitter = intSpalte - 1;
        if (intSpalte < constSpalte_max) {
            intSpalte_Gitter = intSpalte_Gitter + 1;
            strBilddateiname = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strBilddateiname == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[1] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strBilddateiname.substring(5, 6));
                if (intBindung == 0) {
                    arrFilter[1] = 9;
                } else {
                    arrFilter[1] = intBindung;
                }
            }
        }

        // Prüfen, ob Nachbarzelle auf 6 Uhr vorhanden ist und ggf. deren Bindungseigenschaft auf 12 Uhr auswerten
        intZeile_Gitter  = intZeile  - 1;
        intSpalte_Gitter = intSpalte - 1;
        if (intZeile < constZeile_max) {
            intZeile_Gitter = intZeile_Gitter + 1;
            strBilddateiname = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strBilddateiname == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[2] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strBilddateiname.substring(2, 3));
                if (intBindung == 0) {
                    arrFilter[2] = 9;
                } else {
                    arrFilter[2] = intBindung;
                }
            }
        }

        // Prüfen, ob Nachbarzelle auf 9 Uhr vorhanden ist und ggf. deren Bindungseigenschaft auf 3 Uhr auswerten
        intZeile_Gitter  = intZeile  - 1;
        intSpalte_Gitter = intSpalte - 1;
        if (intSpalte > 1) {
            intSpalte_Gitter = intSpalte_Gitter - 1;
            strBilddateiname = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strBilddateiname == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[3] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strBilddateiname.substring(3, 4));
                if (intBindung == 0) {
                    arrFilter[3] = 9;
                } else {
                    arrFilter[3] = intBindung;
                }
            }
        }

        Intent myIntent = new Intent(Org_Generator_Activity.this, Org_Strukturformeln_Activity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        myIntent.putExtra("Filter", arrFilter);
        Log.d(TAG, "startActivity");
        startActivity(myIntent);
    } // btnFeld

    public void btnLoeschen(View v)
    {
        String strPos;
        String strZellenname;
        int intResId;

        if (arrElementePos != null && !arrElementePos.isEmpty()) {
            // es wurde bereits mind. 1 Element platziert
            strPos = arrElementePos.get(arrElementePos.size() - 1);

            int intZeile  = Integer.parseInt(strPos.substring(0, 2)) - 1;
            int intSpalte = Integer.parseInt(strPos.substring(2, 3)) - 1;

            arrGitter[intZeile][intSpalte] = null;

            // Name des ImageButtons aus Positionsangabe (Zeile und Spalte) bilden
            strZellenname = "ibtFeld_" + strPos;

            // ResId des ImageButtons ermitteln
            intResId = getResources().getIdentifier(strZellenname, "id", getPackageName());

            ImageButton btn = (ImageButton) findViewById(intResId);

            btn.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.weiss));

            // Letztes Element der Liste löschen
            arrElementePos.remove(arrElementePos.size() - 1);
            setzeFelder();
        }
    } // btnLoeschen

    public void btnBestimmeFormel(View v)
    {
        String strMsg = "";
        int intAnzahlEndpunkte;
        int intKettenlaenge_max;
        int intEndpunkt_Index = 0;
        int intKennz_Ringverbindung = 0;

        if (arrElementePos.isEmpty()) {
            // Es ist kein Element eingetragen bzw. alle bisher eingetragenen Elemente wurden (über "btnLoeschen") gelöscht.
            intAnzahlAktiveZellen = -1;
        }

        switch (intAnzahlAktiveZellen) {
            case -1:
                strMsg = "\n   Geben Sie zuerst eine Formel ein.   \n";
                break;
            case 0:
                // Hier muss jetzt "nur noch" die Formel bestimmt werden... ;-)
                break;
            default:
                strMsg = "\n   Formel unvollständig. Anzahl freie Enden: "+ intAnzahlAktiveZellen + "   \n";
                break;
        }

        if (strMsg.equals("")) {
            intAnzahlEndpunkte = Endpunkte_finden();
            if (intAnzahlEndpunkte == 0) {
                strMsg = "\nFormel enthält keinen einzigen Endpunkt (C-Atom mit genau EINER Bindung zu einem anderen C-Atom)!\n";
            }
        }

        if (strMsg.equals("")) {
            intKettenlaenge_max = Kettenlaenge_ermitteln();

            for (de.laborabakus.tKetten tKetten : arrKetten) {
                if (tKetten.Kettenlaenge == intKettenlaenge_max) {
                    intEndpunkt_Index       = tKetten.Endpunkt_Index;
                    intKennz_Ringverbindung = tKetten.Kennz_Ringverbindung;
                    break;
                }
            }

            strMsg = "Endpunkt "+(intEndpunkt_Index+1)+": Z"+(arrEndpunkte[intEndpunkt_Index].StartPos.Zeile+1)+"S"+(arrEndpunkte[intEndpunkt_Index].StartPos.Spalte+1)
                                                       +"-Z"+(arrEndpunkte[intEndpunkt_Index].ZielPos.Zeile +1)+"S"+(arrEndpunkte[intEndpunkt_Index].ZielPos.Spalte +1)
                    +", Bindung auf "+arrEndpunkte[intEndpunkt_Index].Bindung+" Uhr"
                    +", Kettenlänge "+arrEndpunkte[intEndpunkt_Index].Kettenlaenge
                    +", Kettenname " +Org_GeneratorTools.fktKettenname(intKettenlaenge_max)
                    +"\nMolmasse " + fltMolmasse;
            if (intKennz_Ringverbindung > 0) {
                strMsg = strMsg+"\nRINGVERBINDUNG";
            }
            switch (intKennz_Ringverbindung) {
                case 1:
                    strMsg = strMsg+" mit einem Endpunkt!";
                    break;
                case 2:
                    strMsg = strMsg+" mit mehr als einem Endpunkt!";
                    break;
            } // switch (intKennz_Ringverbindung)
            Log.d(TAG, "***");
            Log.d(TAG, strMsg);
        }

        if (!strMsg.equals("")) {
            Toast Meldung = Toast.makeText(this, strMsg, Toast.LENGTH_LONG);
            Meldung.setGravity(Gravity.BOTTOM, 0, 0);
            Meldung.show();
        }

    } // btnBestimmeFormel

    public boolean checkGitter()
    {
        int[] arrBindung;
        int intZeile_max;
        int intSpalte_max;
        int intBindung_Nachbarzelle;
        String strBilddateiname;
        String strMsg;

        intZeile_max = arrGitter.length - 1;
        for (int intZeile = 0; intZeile < arrGitter.length; intZeile++) {
            for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++) {
                intSpalte_max = arrGitter[intZeile].length - 1;
                if (arrGitter[intZeile][intSpalte] != null) {
                    strBilddateiname = arrGitter[intZeile][intSpalte]; // Bsp.: an1010a56_108
                    // Bindungseigenschaften in Array speichern
                    arrBindung = Org_GeneratorTools.fktBindung2Array(strBilddateiname);
                    strMsg = "";

                    if ((arrBindung[0] > 0) && (intZeile == 0)) {                                   // intZeile => Zeile, wo das Element platziert werden soll.
                        // Bindung auf 12 Uhr in oberster Zeile nicht zulässig                      // arrBindung => Bindungsrichtung des zu platzierenden Elementes
                        strMsg = "Bindung auf 12 Uhr in oberster Zeile nicht zulässig!";
                    }
                    else if ((arrBindung[1] > 0) && (intSpalte == intSpalte_max)) {
                        // Bindung auf 3 Uhr in letzter Spalte nicht zulässig
                        strMsg = "Bindung auf 3 Uhr in letzter Spalte nicht zulässig!";
                    }
                    else if ((arrBindung[2] > 0) && (intZeile == intZeile_max)) {
                        // Bindung auf 6 Uhr in letzter Zeile nicht zulässig
                        strMsg = "Bindung auf 6 Uhr in letzter Zeile nicht zulässig!";
                    }
                    else if ((arrBindung[3] > 0) && (intSpalte == 0)) {
                        // Bindung auf 9 Uhr in erster Spalte nicht zulässig
                        strMsg = "Bindung auf 9 Uhr in erster Spalte nicht zulässig!";
                    }
                    else {
                        // prüfen, ob Bindungseigenschaften des aktuellen Elements mit denen der 4 umliegenenden Zellen
                        // (12, 3, 6 und 9 Uhr) zusammenpassen
                        // 12 Uhr-Bindung prüfen
                        int b = 0;
                        if (intZeile > 0) {
                            if (arrGitter[intZeile - 1][intSpalte] != null) {
                                // Nachbarzelle ist gefüllt
                                strBilddateiname = arrGitter[intZeile - 1][intSpalte]; // Bsp.: an1010a56_108
                                // 6 Uhr-Bindung der Zelle eine Zeile über dem aktuellen Element prüfen
                                int intPos = 4;
                                intBindung_Nachbarzelle = Integer.parseInt(strBilddateiname.substring(intPos, intPos + 1));
                                if ((arrBindung[b] > 0) && (arrBindung[b] != intBindung_Nachbarzelle)) {
                                    strMsg = "Bindung auf 12 Uhr passt nicht zur Nachbarzelle!";
                                } else if ((arrBindung[b] == 0) && (intBindung_Nachbarzelle > 0)) {
                                    strMsg = "Fehlende Bindung auf 12 Uhr passt nicht zur Nachbarzelle!";
                                }
                            }
                        }

                        if (strMsg.equals("")) {
                            // 3 Uhr-Bindung prüfen
                            b = 1;
                            if (intSpalte < intSpalte_max) {
                                if (arrGitter[intZeile][intSpalte + 1] != null) {
                                    // Nachbarzelle ist gefüllt
                                    strBilddateiname = arrGitter[intZeile][intSpalte + 1]; // Bsp.: an1010a56_108
                                    // 9 Uhr-Bindung der Zelle eine Spalte neben dem aktuellen Element prüfen
                                    int intPos = 5;
                                    intBindung_Nachbarzelle = Integer.parseInt(strBilddateiname.substring(intPos, intPos + 1));
                                    if ((arrBindung[b] > 0) && (arrBindung[b] != intBindung_Nachbarzelle)) {
                                        strMsg = "Bindung auf 3 Uhr passt nicht zur Nachbarzelle!";
                                    } else if ((arrBindung[b] == 0) && (intBindung_Nachbarzelle > 0)) {
                                        strMsg = "Fehlende Bindung auf 3 Uhr passt nicht zur Nachbarzelle!";
                                    }
                                }
                            }
                        }

                        if (strMsg.equals("")) {
                            // 6 Uhr-Bindung prüfen
                            b = 2;
                            if (intZeile < intZeile_max) {
                                if (arrGitter[intZeile + 1][intSpalte] != null) {
                                    // Nachbarzelle ist gefüllt
                                    strBilddateiname = arrGitter[intZeile + 1][intSpalte]; // Bsp.: an1010a56_108
                                    // 12 Uhr-Bindung der Zelle eine Spalte unter dem aktuellen Element prüfen
                                    int intPos = 2;
                                    intBindung_Nachbarzelle = Integer.parseInt(strBilddateiname.substring(intPos, intPos + 1));
                                    if ((arrBindung[b] > 0) && (arrBindung[b] != intBindung_Nachbarzelle)) {
                                        strMsg = "Bindung auf 6 Uhr passt nicht zur Nachbarzelle!";
                                    } else if ((arrBindung[b] == 0) && (intBindung_Nachbarzelle > 0)) {
                                        strMsg = "Fehlende Bindung auf 6 Uhr passt nicht zur Nachbarzelle!";
                                    }
                                }
                            }
                        }

                        if (strMsg.equals("")) {
                            // 9 Uhr-Bindung prüfen
                            b = 3;
                            if (intSpalte > 0) {
                                if (arrGitter[intZeile][intSpalte - 1] != null) {
                                    // Nachbarzelle ist gefüllt
                                    strBilddateiname = arrGitter[intZeile][intSpalte - 1]; // Bsp.: an1010a56_108
                                    // 3 Uhr-Bindung der Zelle eine Spalte unter dem aktuellen Element prüfen
                                    int intPos = 3;
                                    intBindung_Nachbarzelle = Integer.parseInt(strBilddateiname.substring(intPos, intPos + 1));
                                    if ((arrBindung[b] > 0) && (arrBindung[b] != intBindung_Nachbarzelle)) {
                                        strMsg = "Bindung auf 9 Uhr passt nicht zur Nachbarzelle!";
                                    } else if ((arrBindung[b] == 0) && (intBindung_Nachbarzelle > 0)) {
                                        strMsg = "Fehlende Bindung auf 9 Uhr passt nicht zur Nachbarzelle!";
                                    }
                                }
                            }
                        }
                    }

                    if (strMsg != "") {
                        strMsg = "\n   " + strMsg + "   \n";
                        Toast Meldung = Toast.makeText(this, strMsg, Toast.LENGTH_LONG);
                        Meldung.setGravity(Gravity.BOTTOM, 0, 0);
                        Meldung.show();
                        return false;
                    }
                } // if (arrGitter[intZeile][intSpalte] != null)
            } // for (int intZeile = 0; intZeile < arrGitter.length; intZeile++)
        } // for (int intZeile = 0; intZeile < arrGitter.length; intZeile++)

        return true;
    } // checkGitter

    // Alle Felder durchgehen und entweder weiß (aktiv) oder grau (inaktiv) setzen
    public boolean setzeFelder()
    {
        String strZellenname;
        int intResId;
        boolean bEnabled;

        intAnzahlAktiveZellen = 0;

        for (int intZeile = 0; intZeile < arrGitter.length; intZeile++) {
            for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++) {
                if (arrGitter[intZeile][intSpalte] == null) {
                    // Name des ImageButtons aus Zeile und Spalte bilden
                    strZellenname = "ibtFeld_" + new DecimalFormat("00").format((intZeile+1)) + (intSpalte+1);

                    // ResId des ImageButtons ermitteln
                    intResId = getResources().getIdentifier(strZellenname, "id", getPackageName());

                    ImageButton btn = (ImageButton) findViewById(intResId);

                    int[] arrFilter = new int[4];

                    if (intZeile == 0) {
                        // in oberster Zeile keine Bindung auf 12 Uhr zulassen
                        arrFilter[0] = 9;
                    }
                    else if (intZeile+1 == constZeile_max) {
                        // in letzter Zeile keine Bindung auf 6 Uhr zulassen
                        arrFilter[2] = 9;
                    }
                    if (intSpalte == 0) {
                        // in erster Spalte keine Bindung auf 9 Uhr zulassen
                        arrFilter[3] = 9;
                    }
                    else if (intSpalte+1 == constSpalte_max) {
                        // in letzter Spalte keine Bindung auf 3 Uhr zulassen
                        arrFilter[1] = 9;
                    }

                    if (arrElementePos.isEmpty()) {
                        // Es ist kein Element eingetragen bzw. alle bisher eingetragenen Elemente wurden (über "btnLoeschen") gelöscht.
                        // Um zu erreichen, dass wieder alle Zellen weiß und aktiv werden, wird hier explizit bEnabled auf true gesetzt.
                        bEnabled = true;
                    }
                    else {
                        bEnabled = checkNachbarzellen(intZeile, intSpalte, arrFilter);
                    }

                    if (bEnabled) {
                        btn.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.weiss));
                        intAnzahlAktiveZellen = intAnzahlAktiveZellen+1;
                    }
                    else {
                        btn.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.grau));
                    }
                    btn.setEnabled(bEnabled);
                } // if (arrGitter[intZeile][intSpalte] == null)

            } // for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++)
        } // for (int intZeile = 0; intZeile < arrGitter.length; intZeile++)

        return true;
    } // setzeFelder

    // In dieser Funktion werden die 4 Nachbarzellen der übergebenen Position (Zeile / Spalte) geprüft.
    // Rückgabewert der Funktion:
    //   true:  eine der Nachbarzellen hat eine Bindungsmöglichkeit zur übergebenen Position (Zeile / Spalte)
    //   false: keine der Nachbarzellen hat eine Bindungsmöglichkeit zur übergebenen Position (Zeile / Spalte)
    public boolean checkNachbarzellen(int pZeile, int pSpalte, int[] pFilter)
    {
        int[] arrBindung;
        String strBilddateiname;
        boolean bReturn;

        bReturn = false;

        for (int i = 0; i < 4; i++) {
            if (pFilter[i] == 0) {
                strBilddateiname = null;
                switch (i) {
                    case 0: // Nachbarzelle auf 12 Uhr prüfen
                        strBilddateiname = arrGitter[pZeile-1][pSpalte];
                        break;
                    case 1: // Nachbarzelle auf 3 Uhr prüfen
                        strBilddateiname = arrGitter[pZeile][pSpalte+1];
                        break;
                    case 2: // Nachbarzelle auf 6 Uhr prüfen
                        strBilddateiname = arrGitter[pZeile+1][pSpalte];
                        break;
                    case 3: // Nachbarzelle auf 9 Uhr prüfen
                        strBilddateiname = arrGitter[pZeile][pSpalte-1];
                        break;
                } // switch (i)

                if (strBilddateiname != null) {
                    // Bindungseigenschaften in Array speichern
                    arrBindung = Org_GeneratorTools.fktBindung2Array(strBilddateiname);
                    /*
                        i bezieht sich auf ZIELZELLE!
                        i = 0 ==> 12 Uhr - erfordert Nachbarzelle mit Bindungsmöglichkeit aus  6 Uhr
                        i = 1 ==>  3 Uhr - erfordert Nachbarzelle mit Bindungsmöglichkeit aus  9 Uhr
                        i = 2 ==>  6 Uhr - erfordert Nachbarzelle mit Bindungsmöglichkeit aus 12 Uhr
                        i = 3 ==>  9 Uhr - erfordert Nachbarzelle mit Bindungsmöglichkeit aus  3 Uhr
                    */
                    switch (i) {
                        case 0: // prüfen, ob Nachbarzelle eine Bindung auf 6 Uhr zulässt
                            if (arrBindung[2] > 0) {
                                bReturn = true;
                            }
                            break;
                        case 1: // prüfen, ob Nachbarzelle eine Bindung auf 9 Uhr zulässt
                            if (arrBindung[3] > 0) {
                                bReturn = true;
                            }
                            break;
                        case 2: // prüfen, ob Nachbarzelle eine Bindung auf 12 Uhr zulässt
                            if (arrBindung[0] > 0) {
                                bReturn = true;
                            }
                            break;
                        case 3: // prüfen, ob Nachbarzelle eine Bindung auf 3 Uhr zulässt
                            if (arrBindung[1] > 0) {
                                bReturn = true;
                            }
                            break;
                    } // switch (i)
                } // if (strBilddateiname != null)
            } // if (parrFilter[i] == 0)

            if (bReturn == true) {
                // eine einzige Bindungsmöglichkeit genügt, damit die Zelle aktiv wird bzw bleibt
                break;
            }
        } // for (int i = 0; i < 4; i++)

        return bReturn;
    } // checkNachbarzellen

    public int Endpunkte_finden()
    {
        int[] arrBindung;
        int intBindung = 0;
        int intAnzahlEndpunkte = 0;
        int intAnzahlBindungen; // Zähler für die Anzahl Bindungen zu einem C-Atom
        int intKettenlaenge; // Länge der Kohlenstoffatome

        String strBilddateiname;
        tKoordinaten NaechstesElementPos = new tKoordinaten();
        tKoordinaten ZielPos = new tKoordinaten();

        fltMolmasse = 0;

        for (int intZeile = 0; intZeile < arrGitter.length; intZeile++) {
            for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++) {
                if (arrGitter[intZeile][intSpalte] != null) {
                    intAnzahlBindungen = 0;
                    strBilddateiname = arrGitter[intZeile][intSpalte]; // Bsp.: an1010a56_108
                    fltMolmasse = fltMolmasse + Org_GeneratorTools.fktMolmasse(strBilddateiname);
                    Log.d(TAG,strBilddateiname);
                    if (Org_GeneratorTools.fktIstKohlenstoff(strBilddateiname)) {
                        // Element enthält Kohlenstoff
                        intKettenlaenge = Org_GeneratorTools.fktAnzahl_C_Atome(strBilddateiname);

                        // Bindungseigenschaften in Array speichern
                        arrBindung = Org_GeneratorTools.fktBindung2Array(strBilddateiname);
                        for (int i = 0; i < arrBindung.length; i++) {
                            if (arrBindung[i] > 0) {
                                // Bindung zum Nachbarelement untersuchen
                                // Zeile/Spalte des Nachbarelements ermitteln (Initialwerte sind erst einmal die Koordinaten des aktuellen Elements)
                                NaechstesElementPos.Zeile  = intZeile;
                                NaechstesElementPos.Spalte = intSpalte;

                                switch (i) {
                                    case 0: // Bindung auf 12 Uhr
                                        NaechstesElementPos.Zeile--;
                                        break;
                                    case 1: // Bindung auf 3 Uhr
                                        NaechstesElementPos.Spalte++;
                                        break;
                                    case 2: // Bindung auf 6 Uhr
                                        NaechstesElementPos.Zeile++;
                                        break;
                                    case 3: // Bindung auf 9 Uhr
                                        NaechstesElementPos.Spalte--;
                                        break;
                                } // switch (i)

                                strBilddateiname = arrGitter[NaechstesElementPos.Zeile][NaechstesElementPos.Spalte]; // Bsp.: an1010a56_108
                                if (Org_GeneratorTools.fktIstKohlenstoff(strBilddateiname)) {
                                    intAnzahlBindungen++;
                                    // Koordinaten und Bindung merken, für Erstellung eines Eintrags in "arrEndpunkte" (s.u.)
                                    ZielPos.Zeile  = NaechstesElementPos.Zeile;
                                    ZielPos.Spalte = NaechstesElementPos.Spalte;
                                    switch (i) {
                                        case 0: // Bindung auf 12 Uhr
                                            intBindung = 12;
                                            break;
                                        case 1: // Bindung auf 3 Uhr
                                            intBindung = 3;
                                            break;
                                        case 2: // Bindung auf 6 Uhr
                                            intBindung = 6;
                                            break;
                                        case 3: // Bindung auf 9 Uhr
                                            intBindung = 9;
                                            break;
                                    } // switch (i)
                                }
                            } // if (arrBindung[i] > 0)
                        } // for (i = 0; i < arrBindung.length; i++)

                        if (intAnzahlBindungen == 1) {
                            if (intAnzahlEndpunkte == 0) {
                                // Endpunkte-Array initialisieren
                                arrEndpunkte = new tEndpunkte[1];
                                arrEndpunkte[0] = new tEndpunkte();
                            } else {
                                arrEndpunkte = Org_GeneratorTools.fktEndpunkteArray_vergr(arrEndpunkte);
                            }
                            arrEndpunkte[intAnzahlEndpunkte].StartPos.Zeile  = intZeile;
                            arrEndpunkte[intAnzahlEndpunkte].StartPos.Spalte = intSpalte;
                            arrEndpunkte[intAnzahlEndpunkte].ZielPos.Zeile   = ZielPos.Zeile;
                            arrEndpunkte[intAnzahlEndpunkte].ZielPos.Spalte  = ZielPos.Spalte;
                            arrEndpunkte[intAnzahlEndpunkte].Bindung         = intBindung;
                            arrEndpunkte[intAnzahlEndpunkte].Kettenlaenge    = intKettenlaenge;
                            intAnzahlEndpunkte++;
                        } // if (intAnzahlBindungen == 1)
                    } // if (Org_GeneratorTools.fktIstKohlenstoff(strBilddateiname))
                } // if (arrGitter[intZeile][intSpalte] != null)
            } // for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++)
        } // for (int intZeile = 0; intZeile < arrGitter.length; intZeile++)

        return intAnzahlEndpunkte;
    } // Endpunkte_finden

    public int Kettenlaenge_ermitteln()
    {
        int[] arrBindung;
        int intElement_Index;
        int intKettenelement_Index;
        int intKettenlaenge_akt;
        int intKettenlaenge_max = 0;
        int intKetten_Index_max = 0;
        int intKetten_Index_akt;
        int intAnzahl_C_Atome;
        int intBindung = 0;
        int intBindung_Vorgaenger;
        int intZeile, intSpalte;
        int intAnzahl_Elemente;
        int intIdx;
        String strBilddateiname;
        String strMsg;
        tKoordinaten NaechstesElementPos = new tKoordinaten();
        tKettenelement Kettenelement;
        tKettenelement Kettenelement2;
        boolean bRingverbindung;
        boolean bElementGefunden;

        // Schleife über alle Endpunkte
        for (int i = 0; i < arrEndpunkte.length; i++) {
            Log.d(TAG, "***");
            Log.d(TAG, "Endpunkt "+i+": Z"+arrEndpunkte[i].StartPos.Zeile+"S"+arrEndpunkte[i].StartPos.Spalte);

            if (i == 0) {
                // Ketten-Array initialisieren
                arrKetten = new tKetten[1];
                arrKetten[0] = new tKetten();
            } else {
                // Ketten-Array vergrößern
                arrKetten = Org_GeneratorTools.fktKettenArray_vergr(arrKetten);
                intKetten_Index_max++;
            }

            // Elemente-Array initialisieren
            arrElemente = new tElemente[1];
            arrElemente[0] = new tElemente();

            // Ersten Eintrag in Array für Elemente schreiben
            arrElemente[0].Koordinaten.Zeile  = arrEndpunkte[i].ZielPos.Zeile;
            arrElemente[0].Koordinaten.Spalte = arrEndpunkte[i].ZielPos.Spalte;
            // Uhrzeit der Bindung umkehren, da sie jetzt aus Sicht des Nachbarelements gesehen werden muss
            // (d.h. Bindung des Nachbarelements zum Endpunkt)
            arrElemente[0].Bindung_Vorgaenger = Org_GeneratorTools.fktBindungUmkehren(arrEndpunkte[i].Bindung);
            arrElemente[0].Kettenlaenge       = arrEndpunkte[i].Kettenlaenge;
            arrElemente[0].Ketten_Index       = intKetten_Index_max;

            // je Endpunkt wird mind. 1 Kette angelegt
            // erstes Kettenelement ist der Endpunkt
            intZeile  = arrEndpunkte[i].StartPos.Zeile;
            intSpalte = arrEndpunkte[i].StartPos.Spalte;
            strBilddateiname = arrGitter[intZeile][intSpalte]; // Bsp.: an1010a56_108
            arrKetten[intKetten_Index_max].Endpunkt_Index   = i;
            arrKetten[intKetten_Index_max].Kettenlaenge     = arrEndpunkte[i].Kettenlaenge;

            Kettenelement = new tKettenelement();
            Kettenelement.Bilddateiname      = strBilddateiname;
            Kettenelement.Koordinaten_Zeile  = intZeile;
            Kettenelement.Koordinaten_Spalte = intSpalte;
            Kettenelement.Bindung_Vorgaenger = -1; // erstes Kettenelement hat keinen Vorgänger
            Kettenelement.Bindung_Nachfolger = arrEndpunkte[i].Bindung;
            intKettenelement_Index = arrKetten[intKetten_Index_max].Kettenelemente.size();
            arrKetten[intKetten_Index_max].Kettenelemente.put(intKettenelement_Index, Kettenelement);

            // Schleife, bis Elemente-Array leer
            do {
                intKetten_Index_akt = arrElemente[0].Ketten_Index;
                intKettenlaenge_akt = arrElemente[0].Kettenlaenge;

                // Bilddateiname ermitteln
                intZeile  = arrElemente[0].Koordinaten.Zeile;
                intSpalte = arrElemente[0].Koordinaten.Spalte;
                strBilddateiname = arrGitter[intZeile][intSpalte]; // Bsp.: an1010a56_108

                Log.d(TAG, "***");
                Log.d(TAG, "Untersuche Element '"+strBilddateiname+"' (Z"+intZeile+"S"+intSpalte+"), Ketten-Index "+arrElemente[0].Ketten_Index);

                // Prüfen, ob aktuelles Element bereits in der Kette vorhanden ist (==> Ringverbindung)
                bRingverbindung = false;
                for (int key : arrKetten[intKetten_Index_akt].Kettenelemente.keySet()) {
                    tKettenelement value = arrKetten[intKetten_Index_akt].Kettenelemente.get(key);
                    if (   (value.Koordinaten_Zeile  == arrElemente[0].Koordinaten.Zeile)
                        && (value.Koordinaten_Spalte == arrElemente[0].Koordinaten.Spalte)) {
                        // Koordinaten des Elements sind bereits in Kette vorhanden (==> Ringverbindung)
                        arrKetten[intKetten_Index_akt].Kennz_Ringverbindung = 1;
                        Log.d(TAG, "Kettenindex "+intKetten_Index_akt+ " ist eine Ringverbindung!");
                        bRingverbindung = true;
                        break;
                    }
                }

                if (bRingverbindung == false) {
                    // Element mit mind. 1 Kohlenstoffatom
                    intAnzahl_C_Atome = Org_GeneratorTools.fktAnzahl_C_Atome(strBilddateiname);
                    intKettenlaenge_akt = intKettenlaenge_akt + intAnzahl_C_Atome;

                    if (arrEndpunkte[i].Kettenlaenge < intKettenlaenge_akt) {
                        // aktuelle Kettenlänge ist größer als die bisher zu diesem Endpunkt ermittelte Kettenlänge
                        arrEndpunkte[i].ZielPos.Zeile = intZeile;
                        arrEndpunkte[i].ZielPos.Spalte = intSpalte;
                        arrEndpunkte[i].Kettenlaenge = intKettenlaenge_akt;
                        //Log.d(TAG, "arrEndpunkte[" + i + "].ZielPos.Zeile  = " + arrEndpunkte[i].ZielPos.Zeile);
                        //Log.d(TAG, "arrEndpunkte[" + i + "].ZielPos.Spalte = " + arrEndpunkte[i].ZielPos.Spalte);

                        if (intKettenlaenge_max < intKettenlaenge_akt) {
                            // aktuelle Kettenlänge ist größer als die bisher zu irgendeinem Endpunkt ermittelte Kettenlänge
                            intKettenlaenge_max = intKettenlaenge_akt;
                        }
                    } // if (arrEndpunkte[i].Kettenlaenge < intKettenlaenge_akt)

                    arrKetten[intKetten_Index_akt].Kettenlaenge = arrKetten[intKetten_Index_akt].Kettenlaenge + intAnzahl_C_Atome;

                    Kettenelement = new tKettenelement();
                    Kettenelement.Bilddateiname      = strBilddateiname;
                    Kettenelement.Koordinaten_Zeile  = arrElemente[0].Koordinaten.Zeile;
                    Kettenelement.Koordinaten_Spalte = arrElemente[0].Koordinaten.Spalte;

                    // Alle Bindungen zu C-Atomen mit Ausnahme der Herkunftsbindung in Elemente-Array eintragen (Koordinaten, Herkunftsbindung, Akt-Kettenlänge)
                    // Bindungseigenschaften in Array speichern
                    arrBindung = Org_GeneratorTools.fktBindung2Array(strBilddateiname);
                    intAnzahl_Elemente = 0;
                    for (int j = 0; j < arrBindung.length; j++) {
                        if (arrBindung[j] > 0) {
                            // Bindung zum Nachbarelement untersuchen
                            // Zeile/Spalte des Nachbarelements ermitteln (Initialwerte sind erst einmal die Koordinaten des aktuellen Elements)
                            NaechstesElementPos.Zeile  = intZeile;
                            NaechstesElementPos.Spalte = intSpalte;

                            switch (j) {
                                case 0: // Bindung auf 12 Uhr
                                    NaechstesElementPos.Zeile--;
                                    intBindung = 12; // gesehen vom aktuellen C-Atom
                                    break;
                                case 1: // Bindung auf 3 Uhr
                                    NaechstesElementPos.Spalte++;
                                    intBindung = 3;
                                    break;
                                case 2: // Bindung auf 6 Uhr
                                    NaechstesElementPos.Zeile++;
                                    intBindung = 6;
                                    break;
                                case 3: // Bindung auf 9 Uhr
                                    NaechstesElementPos.Spalte--;
                                    intBindung = 9;
                                    break;
                            } // switch (j)

                            if (intBindung != arrElemente[0].Bindung_Vorgaenger) {
                                // Nächstes Element ist nicht der Vorgänger
                                strBilddateiname = arrGitter[NaechstesElementPos.Zeile][NaechstesElementPos.Spalte]; // Bsp.: an1010a56_108
                                if (Org_GeneratorTools.fktIstKohlenstoff(strBilddateiname)) {
                                    intAnzahl_Elemente++;

                                    // Elemente-Array vergrößern
                                    arrElemente = Org_GeneratorTools.fktElementeArray_vergr(arrElemente);
                                    // Nächsten Eintrag in Array für Elemente schreiben
                                    intElement_Index = arrElemente.length - 1;
                                    arrElemente[intElement_Index].Koordinaten.Zeile = NaechstesElementPos.Zeile;
                                    arrElemente[intElement_Index].Koordinaten.Spalte = NaechstesElementPos.Spalte;
                                    // Uhrzeit der Bindung umkehren, da sie jetzt aus Sicht des Nachbarelements gesehen werden muss
                                    // (d.h. Bindung des Nachbarelements zum Vorgänger)
                                    intBindung_Vorgaenger = Org_GeneratorTools.fktBindungUmkehren(intBindung);
                                    arrElemente[intElement_Index].Bindung_Vorgaenger = intBindung_Vorgaenger;
                                    arrElemente[intElement_Index].Kettenlaenge = intKettenlaenge_akt;
                                    arrElemente[intElement_Index].Ketten_Index = arrElemente[0].Ketten_Index;

                                    if (intAnzahl_Elemente == 1) {
                                        Kettenelement.Bindung_Vorgaenger = arrElemente[0].Bindung_Vorgaenger;
                                        Kettenelement.Bindung_Nachfolger = intBindung;
                                        intKettenelement_Index = arrKetten[intKetten_Index_akt].Kettenelemente.size();
                                        arrKetten[intKetten_Index_akt].Kettenelemente.put(intKettenelement_Index, Kettenelement);
                                        Log.d(TAG, "Neues Kettenelement: intKetten_Index_akt="+intKetten_Index_akt+", intKettenelement_Index="+intKettenelement_Index);
                                        strMsg = "->Z"+Kettenelement.Koordinaten_Zeile+"S"+Kettenelement.Koordinaten_Spalte;
                                        if (Kettenelement.Bindung_Vorgaenger > 0) {
                                            strMsg = strMsg + ", Bindung zum Vorgänger auf " + Kettenelement.Bindung_Vorgaenger + " Uhr";
                                        }
                                        if (Kettenelement.Bindung_Nachfolger > 0) {
                                            strMsg = strMsg + ", Bindung zum Nachfolger auf " + Kettenelement.Bindung_Nachfolger + " Uhr";
                                        }
                                        Log.d(TAG, strMsg);
                                    } else {
                                        // mehr als ein Element, somit eine Verzweigung, d.h. zusätzliche Kette
                                        arrKetten = Org_GeneratorTools.fktKettenArray_vergr(arrKetten);
                                        intKetten_Index_max = arrKetten.length - 1;
                                        // neue Kette mit Werten aus aktueller Kette vorbelegen
                                        // intKetten_Index_akt: neue Kette
                                        // intKetten_Index_max: aktuelle Kette
                                        Log.d(TAG, "***");
                                        Log.d(TAG, "Verzweigung! Neue Kette mit Werten aus aktueller Kette vorbelegen.");
                                        Log.d(TAG, "intKetten_Index_akt (aktuelle Kette) = "+intKetten_Index_akt);
                                        Log.d(TAG, "intKetten_Index_max (neue Kette)     = "+intKetten_Index_max);

                                        arrKetten[intKetten_Index_max].Endpunkt_Index = arrKetten[intKetten_Index_akt].Endpunkt_Index;
                                        arrKetten[intKetten_Index_max].Kettenlaenge   = arrKetten[intKetten_Index_akt].Kettenlaenge;

                                        // Schleifenkonstrukt, damit die Kettenelemente der neuen Kette NICHT die gleiche Speicheradresse haben,
                                        // wie die Kettenelemente der aktuellen Kette!
                                        // .putall erstellt nur "shallow copy" (nicht "deep copy") :-(
                                        for (int key : arrKetten[intKetten_Index_akt].Kettenelemente.keySet()) {
                                            tKettenelement value = arrKetten[intKetten_Index_akt].Kettenelemente.get(key);

                                            tKettenelement tmp = new tKettenelement();
                                            tmp.Bilddateiname      = value.Bilddateiname;
                                            tmp.Koordinaten_Zeile  = value.Koordinaten_Zeile;
                                            tmp.Koordinaten_Spalte = value.Koordinaten_Spalte;
                                            tmp.Bindung_Vorgaenger = value.Bindung_Vorgaenger;
                                            tmp.Bindung_Nachfolger = value.Bindung_Nachfolger;

                                            arrKetten[intKetten_Index_max].Kettenelemente.put(key, tmp);
                                        }

                                        Log.d(TAG, "Bindung des letzten Elements korrigieren auf "+intBindung);
                                        intIdx = arrKetten[intKetten_Index_max].Kettenelemente.size() - 1;
                                        tKettenelement value = arrKetten[intKetten_Index_max].Kettenelemente.get(intIdx);
                                        value.Bindung_Nachfolger = intBindung;

                                        arrElemente[intElement_Index].Ketten_Index = intKetten_Index_max;
                                    }

                                    /*
                                    Log.d(TAG, "Neues Element '"+strBilddateiname+"' (Z"+arrElemente[intElement_Index].Koordinaten.Zeile
                                                                                          +"S"+arrElemente[intElement_Index].Koordinaten.Spalte
                                                                                          +"), Ketten-Index "+arrElemente[intElement_Index].Ketten_Index);

                                    */
                                }
                            }
                        } // if (arrBindung[j] > 0)
                    } // for (j = 0; j < arrBindung.length; j++)

                    if (intAnzahl_Elemente == 0) {
                        // Kettenabschluss
                        Kettenelement.Bindung_Vorgaenger = arrElemente[0].Bindung_Vorgaenger;
                        Kettenelement.Bindung_Nachfolger = -1;

                        intKettenelement_Index = arrKetten[intKetten_Index_akt].Kettenelemente.size();
                        arrKetten[intKetten_Index_akt].Kettenelemente.put(intKettenelement_Index, Kettenelement);
                        Log.d(TAG, "Kettenabschluss: intKetten_Index_akt="+intKetten_Index_akt+", intKettenelement_Index="+intKettenelement_Index);
                        strMsg = "->Z"+Kettenelement.Koordinaten_Zeile+"S"+Kettenelement.Koordinaten_Spalte;
                        if (Kettenelement.Bindung_Vorgaenger > 0) {
                            strMsg = strMsg + ", Bindung zum Vorgänger auf " + Kettenelement.Bindung_Vorgaenger + " Uhr";
                        }
                        if (Kettenelement.Bindung_Nachfolger > 0) {
                            strMsg = strMsg + ", Bindung zum Nachfolger auf " + Kettenelement.Bindung_Nachfolger + " Uhr";
                        }
                        Log.d(TAG, strMsg);
                        Log.d(TAG, "***");
                    }
                } // if (bRingverbindung == false) {

                // Ersten Eintrag (Index [0]) aus "Array-Elemente" entfernen
                arrElemente = Org_GeneratorTools.fktElementeArray_verkl(arrElemente);

            } while (arrElemente.length > 0);

        } // for (int i = 0; i < arrEndpunkte.length; i++)

        // Prüfen, ob Ringverbindung mit mehr als 1 Endpunkt vorkommt
        // Schleifenvariablen:
        // i: Ketten
        // j: Kettenelemente
        // b: Bindungen eines Kettenelements
        for (de.laborabakus.tKetten tKetten : arrKetten) {
            if (tKetten.Kennz_Ringverbindung == 1) {
                // bei jedem Kettenelement prüfen, ob es eine Bindung zu einem C-Atom gibt, das NICHT zum Kettenverlauf gehört
                for (int j = 0; j < tKetten.Kettenelemente.size(); j++) {
                    tKettenelement value = tKetten.Kettenelemente.get(j);
                    strBilddateiname = value.Bilddateiname;
                    arrBindung = Org_GeneratorTools.fktBindung2Array(strBilddateiname);
                    for (int b = 0; b < arrBindung.length; b++) {
                        if (arrBindung[b] > 0) {
                            // Bindung zum Nachbarelement untersuchen
                            // Zeile/Spalte des Nachbarelements ermitteln (Initialwerte sind erst einmal die Koordinaten des aktuellen Elements)
                            NaechstesElementPos.Zeile = value.Koordinaten_Zeile;
                            NaechstesElementPos.Spalte = value.Koordinaten_Spalte;

                            switch (b) {
                                case 0: // Bindung auf 12 Uhr
                                    NaechstesElementPos.Zeile--;
                                    intBindung = 12; // gesehen vom aktuellen C-Atom
                                    break;
                                case 1: // Bindung auf 3 Uhr
                                    NaechstesElementPos.Spalte++;
                                    intBindung = 3;
                                    break;
                                case 2: // Bindung auf 6 Uhr
                                    NaechstesElementPos.Zeile++;
                                    intBindung = 6;
                                    break;
                                case 3: // Bindung auf 9 Uhr
                                    NaechstesElementPos.Spalte--;
                                    intBindung = 9;
                                    break;
                            } // switch (j)

                            if ((intBindung != value.Bindung_Vorgaenger) &&
                                    (intBindung != value.Bindung_Nachfolger)) {
                                // Nächstes Element ist weder Vorgänger noch Nachfolger
                                strBilddateiname = arrGitter[NaechstesElementPos.Zeile][NaechstesElementPos.Spalte]; // Bsp.: an1010a56_108
                                // Prüfen, ob Element Teil der Kette ist
                                bElementGefunden = false;
                                for (int k = 0; k < tKetten.Kettenelemente.size(); k++) {
                                    tKettenelement value2 = tKetten.Kettenelemente.get(k);
                                    if ((value2.Koordinaten_Zeile == NaechstesElementPos.Zeile) &&
                                            (value2.Koordinaten_Spalte == NaechstesElementPos.Spalte)) {
                                        // Koordinaten des Elements sind bereits in Kette vorhanden
                                        bElementGefunden = true;
                                        break;
                                    }
                                }
                                if (bElementGefunden == false) {
                                    if (Org_GeneratorTools.fktIstKohlenstoff(strBilddateiname)) {
                                        // Ringverbindung hat mehr als 1 Endpunkt
                                        tKetten.Kennz_Ringverbindung = 2;
                                    }
                                }
                            }
                        }
                    } // for (int k = 0; k < arrBindung.length; k++)
                } // for (int j = 0; j < arrKetten[i].Bilddateinamen.size(); j++)

            } // if (arrKetten[i].Kennz_Ringverbindung == 1)
        } // for (int i = 0; i < arrKetten.length; i++)

        // Kette zum Endpunkt mit der längsten C-Kette suchen
        //Log.d(TAG, "Endpunkte mit der längste C-Kette:");
        for (int i = 0; i < arrKetten.length; i++) {
            //if (arrKetten[i].Kettenlaenge == intKettenlaenge_max) {
                if (i > 0) {Log.d(TAG, "***");}
                Log.d(TAG, "Informationen zu Kette "+(i+1));
                strMsg = "Kettenlaenge         = " + arrKetten[i].Kettenlaenge;
                if (arrKetten[i].Kettenlaenge == intKettenlaenge_max) {
                    strMsg = strMsg + " (=MAX)";
                }
                Log.d(TAG, strMsg);
                Log.d(TAG, "Kennz_Ringverbindung = " + arrKetten[i].Kennz_Ringverbindung);
                Log.d(TAG, "Endpunkt_Index       = " + arrKetten[i].Endpunkt_Index);

                Log.d(TAG, "Kettenverlauf:");
                for(int key : arrKetten[i].Kettenelemente.keySet()) {
                    tKettenelement value = arrKetten[i].Kettenelemente.get(key);
                    Log.d(TAG, "Element "+(key+1)+": "+value.Bilddateiname+" (Zeile "+(value.Koordinaten_Zeile+1)+", Spalte "+(value.Koordinaten_Spalte+1)+")");
                    if (value.Bindung_Vorgaenger > 0) {
                        Log.d(TAG, "           Bindung zum Vorgänger auf "+value.Bindung_Vorgaenger+" Uhr");
                    }
                    if (value.Bindung_Nachfolger > 0) {
                        Log.d(TAG, "           Bindung zum Nachfolger auf "+value.Bindung_Nachfolger+" Uhr");
                    }
                }
        } // for (int i = 0; i < arrKetten.length; i++)
        return intKettenlaenge_max;
    } // Kettenlaenge_ermitteln

    public boolean Zelle_hervorheben(int pZeile, int pSpalte, int pBindung_Vorgaenger, int Bindung_Nachfolger)
    {
        String strZellenname;
        int intResId;
        int intTop    = 10;
        int intLeft   = 10;
        int intRight  = 10;
        int intBottom = 10;

        // Name des ImageButtons aus Positionsangabe (Zeile und Spalte) bilden
        strZellenname = "ibtFeld_" + new DecimalFormat("00").format((pZeile+1)) + (pSpalte+1);

        // ResId des ImageButtons ermitteln
        intResId = getResources().getIdentifier(strZellenname, "id", getPackageName());

        // Variable für ImageButton deklarieren
        ImageButton btn = (ImageButton) findViewById(intResId);

        // Bindung zum vorherigen Element auswerten
        switch (pBindung_Vorgaenger) {
            case 12: // Bindung auf 12 Uhr
                intTop = 0;
                break;
            case 3: // Bindung auf 3 Uhr
                intRight = 0;
                break;
            case 6: // Bindung auf 6 Uhr
                intBottom = 0;
                break;
            case 9: // Bindung auf 9 Uhr
                intLeft = 0;
                break;
        } // switch (pBindung_Vorgaenger)

        // Bindung zum nachfolgenden Element auswerten
        switch (Bindung_Nachfolger) {
            case 12: // Bindung auf 12 Uhr
                intTop = 0;
                break;
            case 3: // Bindung auf 3 Uhr
                intRight = 0;
                break;
            case 6: // Bindung auf 6 Uhr
                intBottom = 0;
                break;
            case 9: // Bindung auf 9 Uhr
                intLeft = 0;
                break;
        } // switch (Bindung_Nachfolger)

        // https://stackoverflow.com/questions/9373026/changing-imagebutton-margins-in-code
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) btn.getLayoutParams();
        params.setMargins(intLeft, intTop, intRight, intBottom);
        //btn.setLayoutParams(params);
        //btn.setBackgroundColor(Color.YELLOW);

        return true;
    } // Zelle_markieren

} // class Org_Generator

