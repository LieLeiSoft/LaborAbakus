package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Typeface.BOLD;
import static de.laborabakus.Konz_lsg_Gegeben_Activity.fktDichtetabellen;


public class Konz_lsg_verd_Activity_6 extends Activity /*implements OnFocusChangeListener */
{
    // *************************************************************************************************
    // ************* Variablendeklaration **************************************************************
    // *************************************************************************************************

    View v;
    TextView tv;
    TableRow tr;
    EditText et;
    String strAuswahl;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strKonzDichte;
    String strKonzMolmasse;
    String strKonzMenge;
    String strKonzMengeEinheit;
    String strVerdGehalt;
    String strVerdGehaltEinheit = "mol/l";
    String strVerdMenge;
    String strVerdMengeEinheit = "ml";
    String strVerdDichte = "";

    double dblKonzGehalt;
    double dblKonzDichte;
    double dblKonzMenge;
    double dblMolmasse;
    double dblVerdGehalt;
    double dblVerdDichte;
    double dblVerdMenge;



    /** wird ausgef?hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_verd);

        // Activity registrieren, damit sie sp?ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);

        // *************************************************************************************************
        // ******* Auslesen von gespeicherten Konfig-Dateinen **********************************************
        // *************************************************************************************************

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        strKonzDichte = prefs.getString("Dichte_"+strAuswahl, strKonzDichte);
        strKonzMolmasse = prefs.getString("Molmasse_"+strAuswahl, strKonzMolmasse);

        // *************************************************************************************************
        // ******* Anzeige auf dem Bildschirm **************************************************************
        // *************************************************************************************************

        // Konz. Lösung

        tv = (TextView) findViewById(R.id.tvAcidBase);                      // Überschrift mit der Konz. Lösung
        tv.setText(strKonzAuswahl + " " + strKonzGehalt + strKonzGehaltEinheit);

        View b = findViewById(R.id.tvBerechnungKonz);                      // "Berechnung Button" der Konz unsichtbar machen
        b.setVisibility(View.GONE);


        // Verdünnung

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld bei dem Gehalt der Verdünnung verschwinden lassen
        tv.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.tvNameVerd);                      // Textfeld Masse bei der Verdünnung
        tv.setText("Masse");

        tv = (TextView) findViewById(R.id.tvEinheitVerd);                   // Textfeld g bei Masse der Verdünnung
        tv.setText("g");

        tv = (TextView) findViewById(R.id.textView7);                       // Textfeld "ist gesucht" sichtbar machen
        tv.setVisibility(View.VISIBLE);

        //tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);    // Button mol/l / g/l verschwinden lassen
        //tv.setVisibility(View.GONE);

        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);            // Eingabefeld Gehalt Verdünnung verschwinden lassen
        et.setVisibility(View.GONE);

        // Spezieller Menge Button (g / ml) für die Dichtetabelle nur bri folgenden Säuren
        if(strKonzAuswahl.equals("Salzsäure") || strKonzAuswahl.equals("Schwefelsäure") ||
                strKonzAuswahl.equals("Salpetersäure") || strKonzAuswahl.equals("Phosphorsäure")
                || strKonzAuswahl.equals("Essigsäure")|| strKonzAuswahl.equals("Natronlauge") == true)
        {
            // Menge Button der Verdünnung sichtbar machen
            b = findViewById(R.id.tvAnpassungEinheitVerdMenge);
            b.setVisibility(View.VISIBLE);
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);
            tv.setText(strVerdMengeEinheit);

            // Textfeld "g" für alle Konz Lösungen mit Dichte Tabelle unsichtbar machen
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setVisibility(View.GONE);
        }
    } // onCreate

    /** wird ausgef?hrt, wenn Activicty angezeigt wird */

    @Override
    public void onResume() {
        super.onResume();

        /**********************************************************************************************************
         *** Nur der DoubleWert vom Konz Gehalt wird hier auf Prozent umgerechnet *********************************
         **********************************************************************************************************/

        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        dblKonzDichte = Double.parseDouble(strKonzDichte);
        dblMolmasse = Double.parseDouble(strKonzMolmasse);

        switch (strKonzGehaltEinheit)
        {
            case "%":

                dblKonzGehalt = (dblKonzGehalt * 10 * dblKonzDichte) / dblMolmasse;   // % wird auf mol/l umgerechnet

                break;
            case "g/l":

                dblKonzGehalt = dblKonzGehalt / dblMolmasse;                   // g/l wird auf mol/l umgerechnet

                break;
            case "mol/l":

                // keine Umrechnung notwendig

                break;
        }
    } // onResume

    @Override
    protected void onPause() {
        super.onPause();

    } // onPause


    /* *********************************************************************************************
     ***************** Button Konz g / ml **********************************************************
     ***********************************************************************************************/

    public void btnEinheitKonz(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strKonzMengeEinheit = tv.getText().toString();

        if (strKonzMengeEinheit.equals("g") == true)   // Wenn das Feld auf g steht ...
        {
            strKonzMengeEinheit = "ml";             // ...umschalten auf ml

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzMengeEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Volumen");

            et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
            strKonzMenge = et.getText().toString();

            if (strKonzMenge.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblKonzMenge = Double.parseDouble(strKonzMenge);
                dblKonzMenge = dblKonzMenge / dblKonzDichte;   // ...die Masse auf Volumen umrechnen
                strKonzMenge = ActivityTools.fktSignifikanteStellen(dblKonzMenge, 5); // 4 Stellen
                strKonzMenge = strKonzMenge.replace(",", ".");
                et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
                et.setText(strKonzMenge);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }

        }
        else
        {
            strKonzMengeEinheit = "g";                 // ...umschalten auf g

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzMengeEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Masse");

            et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
            strKonzMenge = et.getText().toString();

            if (strKonzMenge.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblKonzMenge = Double.parseDouble(strKonzMenge);
                dblKonzMenge = dblKonzMenge * dblKonzDichte;   // ...das Volumen auf Masse umrechnen
                strKonzMenge = ActivityTools.fktSignifikanteStellen(dblKonzMenge, 5); // 2 Stellen
                strKonzMenge = strKonzMenge.replace(",", ".");
                et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
                et.setText(strKonzMenge);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }

        }
    } // btn g / ml

    /* *********************************************************************************************
     ***************** Button g/l oder mol/l der Verdünnung  ***************************************
     ***********************************************************************************************/

    public void btnEinheitVerdGehalt(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strVerdGehaltEinheit = tv.getText().toString();                                             // Buttoninhalt auslesen (mol/l oder g/l)

        if (strVerdGehaltEinheit.equals("mol/l") == true)                                           // Wenn das Feld auf mol/l steht ...
        {
            strVerdGehaltEinheit = "g/l";                                                           // ...umschalten auf g/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);                        // ... und g/l auf Button schreiben
            tv.setText(strVerdGehaltEinheit);
        }
        else
        {
            strVerdGehaltEinheit = "mol/l";                                                         // ...umschalten auf mol/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            tv.setText(strVerdGehaltEinheit);
        }
    } // btn g/l / mol/l

    /***********************************************************************************************
     ***************** Button Verdünnung g oder ml *************************************************
     *** dieser Button erscheint nur bei Salz-, Schwefel- oder Salpetersäure ************ ***********
     ***********************************************************************************************/

    public void btnEinheitVerdMenge(View v)
    {
        if(strVerdMengeEinheit.equals("ml") == true)         // Wenn das Feld auf ml steht ...
        {
            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                            // Auslesen der aktuellen Menge der Verdünnung
            strVerdMenge = et.getText().toString();

            AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity_6.this);
            builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);

            if(strVerdMenge.equals("") == true)
            {
                builder.setMessage("Mit der Masse der verdünnten " + strKonzAuswahl + " kann nicht direkt gerechnet werden! " +
                        "Man kann jedoch bei der Berechnung der Konzentration die entsprechende Dichte mit einer Tabelle ermitteln, interpolieren und " +
                        "dann das Volumen auf die Masse umrechnen! Soll die Tabelle angewendet werden?");
            }
            else
            {
                builder.setMessage("Das Volumen der verdünnten " + strKonzAuswahl + " kann nicht direkt auf die Masse ungerechnet werden! " +
                        "Man kann jedoch nach Berechnung der Konzentration die entsprechende Dichte mit einer Tabelle ermitteln, interpolieren und " +
                        "dann das Volumen auf die Masse umrechnen! Soll die Tabelle angewendet werden?");
            }
            builder.setPositiveButton
                    ("Ja",
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    strVerdMengeEinheit = "g";
                                    TextView tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);                // Buttonbeschriftung umschalten auf g
                                    tv.setText(strVerdMengeEinheit);

                                    et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                                // Eingabefeld löschen
                                    et.setText("");
                                    et.requestFocus();

                                    tv = (TextView) findViewById(R.id.tvNameVerd);                                          // und das Textfeld auf Volumen umgeschaltet
                                    tv.setText("Masse");
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
        else                                                                    // wenn der Button auf g steht,
        {
            strVerdMengeEinheit = "ml";
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);     // Buttonbeschriftung umschalten auf g
            tv.setText(strVerdMengeEinheit);

            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);            // Eingabefeld löschen
            et.setText("");
            et.requestFocus();

            tv = (TextView) findViewById(R.id.tvNameVerd);                      // und das Textfeld wieder auf Masse umgeschaltet
            tv.setText("Volumen");
        }
    } // btn Verdünnung g / ml

    /* *********************************************************************************************
     ***************** Button Berechnung Konz Gehalt in mol/l **************************************
     ***********************************************************************************************/

    public void btnBerechneKonz(View v)
    {
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                            // Auslesen der aktuellen Menge der Verdünnung
        strVerdMenge = et.getText().toString();
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);                     // Auslesen der Einheit der Menge der Verdünnung in g oder ml
        strVerdMengeEinheit = tv.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);                            // Auslesen der aktuellen Menge der Konz. Lösung
        strKonzMenge = et.getText().toString();
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);                          // Auslesen der Einheit der Menge der Konzentration in g oder ml
        strKonzMengeEinheit = tv.getText().toString();

        if ((strVerdMenge.equals("") == false) && (strKonzMenge.equals("") == false))      // Wenn beide Felder voll sind ...
        {
            dblKonzMenge = Double.parseDouble(strKonzMenge);                                // Aus String ein Double erzeugen

            if (strKonzMengeEinheit.equals("g") == true)                                // Wenn die Einheit der Konz Lösung g ist
            {
                dblKonzMenge = dblKonzMenge / dblKonzDichte;                            // ... die Konz Menge auf ml umrechnen (für die Berechung!!!)
            }

            if (strVerdMengeEinheit.equals("g") == true)                                   // Wenn die Einheit der Verdünnung ml ist
            {
                dblVerdMenge = Double.parseDouble(strVerdMenge);                                // Aus String ein Double erzeugen

                dblVerdDichte = fktDichtetabellen(strKonzAuswahl, dblKonzGehalt, dblKonzMenge, dblVerdMenge, strVerdGehalt, strVerdGehaltEinheit); // Aufruf der Funktion Dichtetabelle
                // Dichte wurde ermittelt
                strVerdDichte = ActivityTools.fktSignifikanteStellen(dblVerdDichte, 5);     // 3 Stellen

                dblVerdMenge = dblVerdMenge / dblVerdDichte;                                // ... auf ml umrechnen (für die Berechung!!!)
            }
            else
            {
                dblVerdMenge = Double.parseDouble(strVerdMenge);                                // Aus String ein Double erzeugen
            }

            if ((dblVerdMenge != 0) && (dblKonzMenge != 0))                                // Wenn eines der Felder <> 0 ist, dann ...
            {
                if (dblKonzMenge >= dblVerdMenge)                                            // Wenn die Menge der Verdünnung kleiner ist als die Konz Lösung
                {
                    fktAusgabeMengeVerdZuHoch ();                                            // Funktion Warnmeldung
                }
                else
                {
                    /* **************************************************************************************
                     ***************** Berechnung des Gehaltes in mol/l der Verdünnung **********************
                     ****************************************************************************************/
                    dblVerdGehalt = (dblKonzMenge * dblKonzGehalt) / dblVerdMenge;

                    /* **************************************************************************************
                     ***************** Umrechnung des Gehaltes auf g/l der Verdünnung ************************
                     ****************************************************************************************/
                    if(strVerdGehaltEinheit.equals("g/l") == true)
                    {
                        dblVerdGehalt = dblVerdGehalt * dblMolmasse;
                    }

                    /* **************************************************************************************
                     ***************** Anzeige im neuen Display (Layout) ************************************
                     ****************************************************************************************/

                    strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 3 Stellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);

                    Spannable span = new SpannableString(strVerdGehalt + strVerdGehaltEinheit);
                    span.setSpan(new StyleSpan(BOLD), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    if (strVerdDichte.equals("") == false)
                    {
                        CharSequence finalText = TextUtils.concat("Wenn man " + strKonzMenge
                                + strKonzMengeEinheit + " einer " + strKonzAuswahl +
                                " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                                " zu " + strVerdMenge + strVerdMengeEinheit +" verdünnt, erhält man eine verdünnte " +
                                strKonzAuswahl +" mit einem Gehalt von "
                                , span , ". Die interpolierte Dichte der verdünnten "
                                + strKonzAuswahl + " aus der Tabelle ist "  + strVerdDichte + "g/ml.");

                        tv.setText(finalText);
                    }
                    else
                    {
                        CharSequence finalText = TextUtils.concat("Wenn man " + strKonzMenge
                                + strKonzMengeEinheit + " einer " + strKonzAuswahl +
                                " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                                " zu " + strVerdMenge + strVerdMengeEinheit +" verdünnt, erhält man eine verdünnte " +
                                strKonzAuswahl +" mit einem Gehalt von "
                                , span , ".");

                        tv.setText(finalText);
                    }
                }
            }
        }
    }  // btnBerechneMasseKonz

    /********************************************
     ************** Funktionen ******************
     ********************************************/

    private void fktAusgabeMengeVerdZuHoch ()
    {
        String text = "\nDie Menge der Verdünnung ist nicht kleiner, als die" +
                " Menge der " + strKonzAuswahl +" "+ strKonzGehalt + strKonzGehaltEinheit + ". Eine Verdünnung " +
                "ist nicht möglich!\n";
        Toast Meldung = Toast.makeText(Konz_lsg_verd_Activity_6.this, text, Toast.LENGTH_LONG);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
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

