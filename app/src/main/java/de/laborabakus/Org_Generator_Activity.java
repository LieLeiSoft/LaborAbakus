package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Org_Generator_Activity extends Activity {
    private static final String TAG = "Org_Generator_Activity";

    static int constZeile_max  = 12;
    static int constSpalte_max = 6;

    String[][] arrGitter = new String[constZeile_max][constSpalte_max]; // 12 Zeilen (0..11), 6 Spalten (0..5)

    List<String> arrElementePos = new ArrayList<String>(); // String-List, um die Positionsangaben (Zeile/Spalte) der verwendeten Felder im Gitter aufzunehmen


    String strZeile;  // beginnend ab 1!
    String strSpalte; // beginnend ab 1!

    int resIdFeld;

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

    public void btnFeld(View v)
    {
        resIdFeld = v.getId();
        String strZellenname = getResources().getResourceEntryName(resIdFeld);  // Zellenname (String) zur ID ermitteln (Bsp.: "ibtFeld_011")

        // Zeile/Spalte aus Feldnamen der aktuellen Zelle (resIdFeld) ermitteln (=strZeile/strSpalte)
        strZeile  = strZellenname.substring( 8,10);   // Beispiel: ibtFeld_115 => 11
        strSpalte = strZellenname.substring(10,11);   // Beispiel: ibtFeld_115 => 5

        int intZeile  = Integer.parseInt(strZeile );
        int intSpalte = Integer.parseInt(strSpalte);

        int arrFilter[] = new int[4];

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
        String strZellinhalt;

        // Prüfen, ob Nachbarzelle auf 12 Uhr vorhanden ist und ggf. deren Bindungseigenschaft auf 6 Uhr auswerten
        intZeile_Gitter  = intZeile  - 1;
        intSpalte_Gitter = intSpalte - 1;
        if (intZeile > 1) {
            intZeile_Gitter = intZeile_Gitter - 1;
            strZellinhalt = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strZellinhalt == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[0] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strZellinhalt.substring(4, 5));
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
            strZellinhalt = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strZellinhalt == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[1] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strZellinhalt.substring(5, 6));
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
            strZellinhalt = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strZellinhalt == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[2] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strZellinhalt.substring(2, 3));
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
            strZellinhalt = arrGitter[intZeile_Gitter][intSpalte_Gitter]; // Bsp.: an1010a56_108
            if (strZellinhalt == null) {
                // keine Nachbarzelle vorhanden
                arrFilter[3] = 0; // alles erlaubt
            } else {
                intBindung = Integer.parseInt(strZellinhalt.substring(3, 4));
                if (intBindung == 0) {
                    arrFilter[3] = 9;
                } else {
                    arrFilter[3] = intBindung;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            Log.d(TAG, "arrFilter["+i+"]="+arrFilter[i]);
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

            arrElementePos.remove(arrElementePos.size() - 1);
            setzeFelder();
        }
    } // btnLoeschen

    public boolean checkGitter()
    {
        int arrBindung[] = new int[4];
        int intZeile_max;
        int intSpalte_max;
        int intBindung_Nachbarzelle;
        String strZellinhalt;
        String strMsg;

        intZeile_max = arrGitter.length - 1;
        for (int intZeile = 0; intZeile < arrGitter.length; intZeile++) {
            for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++) {
                intSpalte_max = arrGitter[intZeile].length - 1;
                if (arrGitter[intZeile][intSpalte] != null) {
                    strZellinhalt = arrGitter[intZeile][intSpalte]; // Bsp.: an1010a56_108
                    // Bindungseigenschaften in Array speichern
                    for (int b = 0; b < 4; b++) {
                        int intPos = 2 + b;
                        arrBindung[b] = Integer.parseInt(strZellinhalt.substring(intPos, intPos+1));
                    }
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
                                strZellinhalt = arrGitter[intZeile - 1][intSpalte]; // Bsp.: an1010a56_108
                                // 6 Uhr-Bindung der Zelle eine Zeile über dem aktuellen Element prüfen
                                int intPos = 4;
                                intBindung_Nachbarzelle = Integer.parseInt(strZellinhalt.substring(intPos, intPos + 1));
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
                                    strZellinhalt = arrGitter[intZeile][intSpalte + 1]; // Bsp.: an1010a56_108
                                    // 9 Uhr-Bindung der Zelle eine Spalte neben dem aktuellen Element prüfen
                                    int intPos = 5;
                                    intBindung_Nachbarzelle = Integer.parseInt(strZellinhalt.substring(intPos, intPos + 1));
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
                                    strZellinhalt = arrGitter[intZeile + 1][intSpalte]; // Bsp.: an1010a56_108
                                    // 12 Uhr-Bindung der Zelle eine Spalte unter dem aktuellen Element prüfen
                                    int intPos = 2;
                                    intBindung_Nachbarzelle = Integer.parseInt(strZellinhalt.substring(intPos, intPos + 1));
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
                                    strZellinhalt = arrGitter[intZeile][intSpalte - 1]; // Bsp.: an1010a56_108
                                    // 3 Uhr-Bindung der Zelle eine Spalte unter dem aktuellen Element prüfen
                                    int intPos = 3;
                                    intBindung_Nachbarzelle = Integer.parseInt(strZellinhalt.substring(intPos, intPos + 1));
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
        String strZellinhalt;
        String strZellenname;
        int intResId;
        boolean bEnabled;
        int arrBindung[] = new int[4];

        for (int intZeile = 0; intZeile < arrGitter.length; intZeile++) {
            for (int intSpalte = 0; intSpalte < arrGitter[intZeile].length; intSpalte++) {
                if (arrGitter[intZeile][intSpalte] == null) {
                    // Name des ImageButtons aus Zeile und Spalte bilden
                    strZellenname = "ibtFeld_" + new DecimalFormat("00").format((intZeile+1)) + (intSpalte+1);

                    // ResId des ImageButtons ermitteln
                    intResId = getResources().getIdentifier(strZellenname, "id", getPackageName());

                    ImageButton btn = (ImageButton) findViewById(intResId);

                    int arrFilter[] = new int[4];

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

                    if (bEnabled)
                        btn.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.weiss));
                    else
                        btn.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.grau));
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
    public boolean checkNachbarzellen(int pZeile, int pSpalte, int pFilter[])
    {
        int arrBindung[] = new int[4];
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
                    for (int b = 0; b < 4; b++) {
                        int intPos = 2 + b;
                        arrBindung[b] = Integer.parseInt(strBilddateiname.substring(intPos, intPos+1));
                    }
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

} // class Org_Generator

