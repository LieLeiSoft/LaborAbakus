package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Konz_lsg_verd_Activity extends Activity /*implements OnFocusChangeListener */
{
    View v;
    TextView tv;
    EditText et;
    String strVerdMenge;
    String strVerdMengeEinheit;
    String strVerdGehalt;
    String strVerdGehaltEinheit ="mol/l";
    String strAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strKonzEinheit = "ml";
    String strKonzAuswahl;
    String strErgebnis;
    String strDichte;
    String strMolmasse;
    String strBerechnung_ueber;
    double dblKonzMasse;
    double dblVerdMenge;
    double dblVerdGehalt;
    double dblVerdKonzMol;
    double dblVerdDichte;
    double dblKonzGehalt;
    double dblKonzDichte;
    double dblMolmasse;
    double dblErgebnis;


    /** wird ausgef?hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_verd);

        // Activity registrieren, damit sie sp?ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strBerechnung_ueber = prefs.getString("Berechnung_ueber", "Proz");
        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        dblKonzDichte = Double.parseDouble(strDichte);
        strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
        dblMolmasse = Double.parseDouble(strMolmasse);


        if(strBerechnung_ueber.equals("Proz") == true)
        {
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setText("g");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
            tv.setText("%");

            tv = (TextView) findViewById(R.id.tvNameVerd);
            tv.setText("Masse");

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);  // Button verschwinden lassen
            tv.setVisibility(View.GONE);

            strVerdMengeEinheit = "g";
        }
        else // Berechnung über mol/l g/l
        {
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setText("ml");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
            tv.setText("mol/l");

            tv = (TextView) findViewById(R.id.tvNameVerd);
            tv.setText("Volumen");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt); // Textfeld % verschwinden lassen
            tv.setVisibility(View.GONE);

            strVerdMengeEinheit = "ml";
        }

        if(strKonzAuswahl.equals("Salzsäure") || strKonzAuswahl.equals("Schwefelsäure") || strKonzAuswahl.equals("Salpetersäure") == true)
        {
            // Menge Button der Verdünnung sichtbar machen
            View b = findViewById(R.id.tvAnpassungEinheitVerdMenge);
            b.setVisibility(View.VISIBLE);
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
            tv.setText(strVerdMengeEinheit);

            // Textfeld "g" für alle Konz Lösungen mit Dichte Tabelle unsichtbar machen
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setVisibility(View.GONE);
        }

        tv = (TextView) findViewById(R.id.tvAcidBase);
        tv.setText(strKonzAuswahl + " " + strKonzGehalt + strKonzGehaltEinheit);

        // Eingabefeld Masse der Konzentrierten Lösung unsichtbar machen
        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
        et.setVisibility(View.GONE);
        tv = (TextView) findViewById(R.id.textView5);
        tv.setVisibility(View.VISIBLE);
        // Berechnung Button der Verdünnung unsichtbar machen
        View b = findViewById(R.id.tvBerechnungKonz5);
        b.setVisibility(View.INVISIBLE);

    } // onCreate

    /** wird ausgef?hrt, wenn Activicty angezeigt wird */

    @Override
    public void onResume() {
        super.onResume();

    } // onResume

    @Override
    protected void onPause() {
        super.onPause();

    } // onPause

    /* *********************************************************************************************
     ***************** Button Verdünnung g oder ml ************************************************
     ***********************************************************************************************/

    public void btnEinheitVerdMenge(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strVerdMengeEinheit = tv.getText().toString();

        if (strBerechnung_ueber.equals("Proz") == true)
        {
            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                if (dblKonzGehalt <= dblVerdGehalt)
                {
                    strErgebnis = Double.toString(dblKonzGehalt);
                    String text = "\nDie Konzentration der " + strVerdGehalt + " %igen Verdünnung ist nicht kleiner, als die" +
                            " Konzentration der " + strKonzAuswahl +" "+ strErgebnis + strKonzGehaltEinheit + ". Eine Verdünnung " +
                            "ist nicht möglich!\n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                    Meldung.setGravity(Gravity.TOP, 0, 0);
                    Meldung.show();
                }
                else
                {
                    if(strVerdMengeEinheit.equals("g") == true)         // Wenn das Feld auf g steht ...
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity.this);
                        builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);
                        builder.setMessage("Das Volumen der verdünnten " + strKonzAuswahl + " kann nicht direkt berechnet werden! " +
                                "Mithilfe einer Tabelle wird die Dichte der entsprechnenden Konzentration jedoch ermittelt, interpoliert und " +
                                "auf das Volumen umgerechnet werden! Soll die Tabelle angewendet werden?");
                        builder.setPositiveButton
                                ("Ja",
                                        new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id)
                                            {
                                                strVerdMengeEinheit = "ml";             // ...umschalten auf ml

                                                TextView tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
                                                tv.setText(strVerdMengeEinheit);

                                                tv = (TextView) findViewById(R.id.tvNameVerd);
                                                tv.setText("Volumen");

                                                tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
                                                strVerdGehaltEinheit = tv.getText().toString();

                                                //dblVerdDichte = fktDichtetabellen(strKonzAuswahl, strVerdMengeEinheit, strVerdGehalt, strVerdGehaltEinheit);

                                                et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                                                strVerdMenge = et.getText().toString();

                                                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                                                et.setVisibility(View.GONE);

                                                tv = (TextView) findViewById(R.id.tvGehaltVerd);
                                                tv.setVisibility(View.VISIBLE);
                                                tv.setText(strVerdGehalt);

                                                if (strVerdMenge.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
                                                {
                                                    dblVerdMenge = Double.parseDouble(strVerdMenge);

                                                    dblVerdMenge = dblVerdMenge / dblVerdDichte;

                                                    strVerdMenge = ActivityTools.fktSignifikanteStellen(dblVerdMenge, 4); // 4 Nachkommastellen

                                                    strVerdMenge = strVerdMenge.replace(",", ".");

                                                    et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                                                    et.setText(strVerdMenge);
                                                }


                                                dialog.dismiss();
                                            }
                                        }
                                );

                        builder.setNegativeButton
                                ("Nein",
                                        new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id)
                                            {
                                                dialog.dismiss();
                                            }
                                        }
                                );
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else
                    {
                        strVerdMengeEinheit = "g";                 // ...umschalten auf g

                        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
                        tv.setText(strVerdMengeEinheit);

                        tv = (TextView) findViewById(R.id.tvNameVerd);
                        tv.setText("Masse");

                        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                        et.setText("");

                        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                        et.setVisibility(View.VISIBLE);
                        et.setText("");

                        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                        et.setVisibility(View.VISIBLE);

                        tv = (TextView) findViewById(R.id.tvGehaltVerd);
                        tv.setVisibility(View.GONE);
                    }
                }
            }
            else
            {
                String text = "\nBitte den Gehalt der Verdünnung eingeben!\n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }




        }
        else           // Bei mol/l oder g/l
        {
            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            strVerdGehalt = et.getText().toString();

            dblVerdGehalt = Double.parseDouble(strVerdGehalt);

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            strVerdGehaltEinheit = tv.getText().toString();

            if (strVerdGehaltEinheit.equals("g/l") == true)      //
            {
                dblVerdKonzMol = dblVerdGehalt / dblMolmasse;   // ...g/l auf mol/l umrechnen
                strVerdGehalt = Double.toString(dblVerdKonzMol);
            }
            else
            {
                dblVerdKonzMol = dblVerdGehalt;
            }

            if (strVerdGehalt.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                if (dblKonzGehalt <= dblVerdKonzMol)
                {
                    strErgebnis = Double.toString(dblKonzGehalt);
                    String text = "\nDie Konzentration der " + strVerdGehalt + " %igen Verdünnung ist nicht kleiner, als die" +
                            " Konzentration der " + strKonzAuswahl +" "+ strErgebnis + strKonzGehaltEinheit + ". Eine Verdünnung " +
                            "ist nicht möglich!\n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                    Meldung.setGravity(Gravity.TOP, 0, 0);
                    Meldung.show();
                }
                else
                {
                    if(strVerdMengeEinheit.equals("ml") == true)         // Wenn das Feld auf g steht ...
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity.this);
                        builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);
                        builder.setMessage("Die Masse der verdünnten " + strKonzAuswahl + " kann nicht direkt berechnet werden! " +
                                "Mithilfe einer Tabelle kann die Dichte der entsprechnenden Konzentration ermittelt, interpoliert werden. " +
                                "Jetzt kann das Volumen auf die Masse umgerechnet werden! Soll die Tabelle angewendet werden?");
                        builder.setPositiveButton
                                ("Ja",
                                        new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id)
                                            {
                                                strVerdMengeEinheit = "g";                 // ...umschalten auf g

                                                TextView tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
                                                tv.setText(strVerdMengeEinheit);

                                                tv = (TextView) findViewById(R.id.tvNameVerd);
                                                tv.setText("Masse");

                                                tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
                                                strVerdGehaltEinheit = tv.getText().toString();

                                                //dblVerdDichte = fktDichtetabellen(strKonzAuswahl, strVerdMengeEinheit, strVerdGehalt, strVerdGehaltEinheit);

                                                et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                                                strVerdMenge = et.getText().toString();

                                                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                                                et.setVisibility(View.GONE);

                                                tv = (TextView) findViewById(R.id.tvGehaltVerd);
                                                tv.setVisibility(View.VISIBLE);
                                                tv.setText(strVerdGehalt);

                                                if (strVerdMenge.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
                                                {
                                                    dblVerdMenge = Double.parseDouble(strVerdMenge);

                                                    dblVerdMenge = dblVerdMenge * dblVerdDichte;

                                                    strVerdMenge = ActivityTools.fktSignifikanteStellen(dblVerdMenge, 5); // 1 Nachkommastellen

                                                    strVerdMenge = strVerdMenge.replace(",", ".");

                                                    et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                                                    et.setText(strVerdMenge);
                                                }

                                                dialog.dismiss();

                                            }
                                        }
                                );

                        builder.setNegativeButton
                                ("Nein",
                                        new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id)
                                            {
                                                dialog.dismiss();
                                            }
                                        }
                                );
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else
                    {
                        strVerdMengeEinheit = "ml";             // ...umschalten auf ml

                        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
                        tv.setText(strVerdMengeEinheit);

                        tv = (TextView) findViewById(R.id.tvNameVerd);
                        tv.setText("Volumen");

                        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
                        et.setText("");

                        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                        et.setVisibility(View.VISIBLE);
                        et.setText("");

                        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                        et.setVisibility(View.VISIBLE);

                        tv = (TextView) findViewById(R.id.tvGehaltVerd);
                        tv.setVisibility(View.GONE);
                    }
                }
            }
            else
            {
                String text = "\nBitte den Gehalt der Verdünnung eingeben!\n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }
        }
    } // btn g / ml


    /* *********************************************************************************************
     ***************** Button % oder g/l oder mol/l ************************************************
     ***********************************************************************************************/

    public void btnEinheitVerdGehalt(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strVerdGehaltEinheit = tv.getText().toString();

        if (strVerdGehaltEinheit.equals("g/l") == true)   // Wenn das Feld auf g/l steht ...
        {
            strVerdGehaltEinheit = "mol/l";             // ...umschalten auf mol/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            tv.setText(strVerdGehaltEinheit);

            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                dblVerdKonzMol = dblVerdGehalt / dblMolmasse;   // ...g/l auf mol/l umrechnen
                strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdKonzMol, 4); // 2 Nachkommastellen
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen

                tv = (TextView) findViewById(R.id.tvGehaltVerd);
                tv.setText(strVerdGehalt);
            }

        }
        else
        {
            strVerdGehaltEinheit = "g/l";                 // ...umschalten auf g/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            tv.setText(strVerdGehaltEinheit);

            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                dblVerdKonzMol = dblVerdGehalt;
                dblVerdGehalt = dblVerdGehalt * dblMolmasse;   // ...mol/l auf g/l umrechnen
                strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 2 Nachkommastellen
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen

                tv = (TextView) findViewById(R.id.tvGehaltVerd);
                tv.setText(strVerdGehalt);
            }

        }
    } // btn g/l / mol/l

    /* *********************************************************************************************
     ***************** Button g / ml ***************************************************************
     ***********************************************************************************************/

    public void btnEinheitKonz(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strKonzEinheit = tv.getText().toString();

        if (strKonzEinheit.equals("g") == true)   // Wenn das Feld auf g steht ...
        {
            strKonzEinheit = "ml";             // ...umschalten auf ml

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Volumen");
        }
        else
        {
            strKonzEinheit = "g";                 // ...umschalten auf g

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Masse");
        }
    } // btn g / ml

    /* *********************************************************************************************
     ***************** Button Berechnung ************************************************************
     ***********************************************************************************************/

    public void btnBerechneMasseKonz(View v)
    {
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
        strVerdMenge = et.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        strVerdGehalt = et.getText().toString();

        if ((strVerdMenge.equals("") == false) && (strVerdGehalt.equals("") == false)) // Wenn beide Felder voll sind ...
        {
            dblVerdMenge = Double.parseDouble(strVerdMenge);
            dblVerdGehalt = Double.parseDouble(strVerdGehalt);

            if ((dblVerdMenge != 0) && (dblVerdGehalt != 0)) // Wenn eines der Felder <> 0 ist ...
            {
                //InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                //imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                /*******************************************************************
                 ****** Berechnung der Masse Konz über prozentuale Verdünnung ******
                 *******************************************************************/

                if(strBerechnung_ueber.equals("Proz") == true)    // Wenn Einheit der Verd % ist
                {
                    switch (strKonzGehaltEinheit)
                    {
                        case "%":

                            dblErgebnis = dblKonzGehalt;                                    // keine Umrechnung notwendig

                            break;
                        case "g/l":

                            dblErgebnis = dblKonzGehalt / (10 * dblKonzDichte); // wird auf % umgerechnet

                            break;
                        case "mol/l":

                            dblErgebnis = (dblKonzGehalt * dblMolmasse) / (10 * dblKonzDichte); // wird auf % umgerechnet

                            break;
                    }

                    if (strVerdMengeEinheit.equals("ml") == true)  // generell auf g umrechnen (proz!!!)
                    {
                        dblVerdMenge = dblVerdMenge * dblVerdDichte;
                    }

                    dblKonzMasse = (dblVerdMenge * dblVerdGehalt) / dblErgebnis;

                    strErgebnis = Double.toString(dblErgebnis);

                    if (strKonzEinheit.equals("ml") == true)  // generell auf g umrechnen (proz!!!)
                    {
                        dblKonzMasse = dblKonzMasse / dblKonzDichte;
                    }

                    if (dblErgebnis <= dblVerdGehalt)
                    {
                        String text = "\nDie Konzentration der " + strVerdGehalt + " %igen Verdünnung ist nicht kleiner, als die" +
                                " Konzentration der " + strKonzAuswahl +" "+ strErgebnis + strKonzGehaltEinheit + ". Eine Verdünnung " +
                                "ist nicht möglich!\n";
                        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                        Meldung.setGravity(Gravity.TOP, 0, 0);
                        Meldung.show();
                    }
                    else
                    {
                        strErgebnis = ActivityTools.fktDoubleToStringFormat(dblKonzMasse, 2); // 1 Nachkommastellen

                        setContentView(R.layout.konz_lsg_ergebnis);

                        tv = (TextView) findViewById(R.id.tvKonzErgebnis);

                        tv.setText("Für den Ansatz einer " + strKonzAuswahl + " " + strVerdGehalt + " %" +
                                ", benötigt man " + strErgebnis + " " + strKonzEinheit + " einer " + strKonzAuswahl + " " + strKonzGehalt + " " +
                                strKonzGehaltEinheit + ", die zusammen mit Wasser zu " + strVerdMenge + " " + strVerdMengeEinheit+ " verdünnt werden muss.");
                    }
                }

                /***************************************************************************
                 ********* Berechnung der Masse Konz über Verdünnung mol/l oder g/l ********
                 ***************************************************************************/
                else
                {
                    switch (strKonzGehaltEinheit)
                    {
                        case "%":

                            dblErgebnis = (dblKonzGehalt * dblKonzDichte * 1000) / (100 * dblMolmasse);  //wird auf mol/l umgerechnet
                            strErgebnis = Double.toString(dblKonzGehalt);

                            break;
                        case "g/l":

                            dblErgebnis = dblKonzGehalt / dblMolmasse;                               // wird auf mol/l umgerechnet
                            strErgebnis = Double.toString(dblKonzGehalt);

                            break;
                        case "mol/l":

                            dblErgebnis = dblKonzGehalt;                                              // keine Umrechnung notwendig
                            strErgebnis = Double.toString(dblKonzGehalt);

                            break;
                    }

                    if (strVerdGehaltEinheit.equals("g/l") == true)                                    // Wenn das Feld auf g/l steht ...
                    {
                        dblVerdGehalt = dblVerdGehalt / dblMolmasse;                               // Umrechnung auf mol/l
                    }

                    dblKonzMasse = (dblVerdMenge * dblVerdGehalt) / dblErgebnis;



                    if (strKonzEinheit.equals("g") == true)
                    {
                        dblKonzMasse = dblKonzMasse * dblKonzDichte;
                    }

                    if (dblErgebnis <= dblVerdGehalt)
                    {
                        String text = "\nDie Konzentration der Verdünnung (" + strVerdGehalt + strVerdGehaltEinheit + ") ist nicht kleiner, als die" +
                                " Konzentration der " + strKonzAuswahl +" "+ strErgebnis + strKonzGehaltEinheit + ". Eine Verdünnung " +
                                "ist nicht möglich!\n";
                        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                        Meldung.setGravity(Gravity.TOP, 0, 0);
                        Meldung.show();
                    }
                    else
                    {
                        strErgebnis = ActivityTools.fktDoubleToStringFormat(dblKonzMasse, 2); // 1 Nachkommastellen

                        setContentView(R.layout.konz_lsg_ergebnis);

                        tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                        tv.setText("Für den Ansatz einer " + strKonzAuswahl + " " + strVerdGehalt + " " + strVerdGehaltEinheit +
                                ", benötigt man " + strErgebnis + " " + strKonzEinheit + " einer " + strKonzAuswahl + " " + strKonzGehalt + " " +
                                strKonzGehaltEinheit + ", die zusammen mit Wasser zu " + strVerdMenge + " ml verdünnt werden muss.");
                    }
                }

            }
            else
            {
                String text = "\nBitte keine 0 eingeben!\n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }
        }
        else
        {
            String text = "\nBitte Masse und Gehalt der Verdünnung eingeben!\n";
            Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
            Meldung.setGravity(Gravity.TOP, 0, 0);
            Meldung.show();
        }
    }


    /********************************************
     ************** Menue Button ****************
     ********************************************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId())
        {
            case R.id.menu_Hilfe:
                intent = new Intent(this, HilfeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("Kapitel", "Konz_Lsg_Eingabe");
                startActivity(intent);
                return true;

            case R.id.menu_Menue:
                ActivityRegistry.finishAll();
                intent = new Intent(this, HauptmenueActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                return true;

            case R.id.menu_Aus:
                ActivityRegistry.finishAll();
                finish();
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    } // onOptionsItemSelected
} // class Activity

