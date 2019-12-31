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
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufGrammProLiter;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufMolar;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufNormal;


public class Konz_lsg_verd_Activity_4 extends Activity
{
    // *************************************************************************************************
    // ************* Variablendeklaration **************************************************************
    // *************************************************************************************************

    View v;
    TextView tv;
    TextView tv2;
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
    String strVerdGehaltneu;
    String strVerdGehaltEinheit = "g/l";
    String strVerdMenge;
    String strVerdMengeEinheit = "ml";
    String strVerdDichte;
    String strVerdKonzMol;
    String strStoWert;

    double dblKonzGehalt;
    double dblKonzDichte;
    double dblKonzMenge;
    double dblMolmasse;
    double dblVerdGehalt;
    double dblVerdDichte;
    double dblVerdMenge;
    double dblVerdKonzMol;
    double dblStoWert;


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
        strStoWert = prefs.getString("Wertigkeit_"+strAuswahl, strStoWert);

        // *************************************************************************************************
        // ******* Anzeige auf dem Bildschirm **************************************************************
        // *************************************************************************************************

        // Konz. Lösung

        tv = (TextView) findViewById(R.id.tvAcidBase);                      // Überschrift mit der Konz. Lösung
        tv.setText(strKonzAuswahl + " " + strKonzGehalt + strKonzGehaltEinheit);

        View b = findViewById(R.id.tvBerechnungKonz);                      // "Berechnung Button" der Konz unsichtbar machen
        b.setVisibility(View.GONE);

        // Verdünnung

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld % bei dem Gehalt der Verdünnung
        tv.setText("%");

        tv = (TextView) findViewById(R.id.tvNameVerd);                      // Textfeld Volumen bei der Verdünnung
        tv.setText("Volumen in");

        tv = (TextView) findViewById(R.id.tvEinheitVerd);                   // Textfeld ml bei Volumen der Verdünnung
        tv.setText("ml");

        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);     // Textfeld ml bei Volumen der Verdünnung
        tv.setText("ml");

        tv = (TextView) findViewById(R.id.textView6);                       // Textfeld "ist gesucht" sichtbar machen
        tv.setVisibility(View.VISIBLE);

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld % verschwinden lassen
        tv.setVisibility(View.GONE);

        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);            // Eingabefeld Masse Verdünnung verschwinden lassen
        et.setVisibility(View.GONE);

        // Spezieller Menge Button (g / ml) für die Dichtetabelle nur bei folgenden Säuren
        if(strKonzAuswahl.equals("Salzsäure") || strKonzAuswahl.equals("Schwefelsäure") ||
                strKonzAuswahl.equals("Salpetersäure") || strKonzAuswahl.equals("Phosphorsäure")
                || strKonzAuswahl.equals("Essigsäure")|| strKonzAuswahl.equals("Natronlauge")||
                strKonzAuswahl.equals("Wasserstoffperoxid") || strKonzAuswahl.equals("Kalilauge")
                || strKonzAuswahl.equals("Ammoniaklösung") == true)
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
         *** Nur der DoubleWert vom Konz Gehalt wird hier auf mol/l umgerechnet *********************************
         **********************************************************************************************************/

        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        dblKonzDichte = Double.parseDouble(strKonzDichte);
        dblMolmasse = Double.parseDouble(strKonzMolmasse);
        dblStoWert = Double.parseDouble(strStoWert);

        dblKonzGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblKonzDichte);                 // ...mol/l auf g/l umrechnen

    } // onResume

    @Override
    public void onPause() {
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
                strKonzMenge = ActivityTools.fktSignifikanteStellen(dblKonzMenge, 5); // 4 Stellen
                strKonzMenge = strKonzMenge.replace(",", ".");
                et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
                et.setText(strKonzMenge);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }

        }
    } // btn g / ml


    /* *********************************************************************************************
     ***************** Button g/l / mol/l / M oder N der Verdünnung  ***************************************
     ***********************************************************************************************/

    public void btnEinheitVerdGehalt(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strVerdGehaltEinheit = tv.getText().toString();                                             // Buttoninhalt auslesen (mol/l oder g/l)

        switch (strVerdGehaltEinheit)
        {
            case "mol/l":                                                                               // Wenn das Feld auf mol/l steht ...

                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
                strVerdGehalt = et.getText().toString();

                if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
                {
                    dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                    dblVerdGehalt = fktGehaltUmrechnenAufGrammProLiter(dblVerdGehalt, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);                 // ...mol/l auf g/l umrechnen
                    strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                    strVerdGehalt = strVerdGehalt.replace(",", ".");                   // Komma in Punkt umwandeln - wichtig für double
                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                    et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                    et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
                }

                strVerdGehaltEinheit = "g/l";                                                             // ...umschalten auf N

                tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);                        // ... und N auf Button schreiben
                tv.setText(strVerdGehaltEinheit);
                break;

            case "M":                                                                               // Wenn das Feld auf mol/l steht ...

                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
                strVerdGehalt = et.getText().toString();

                if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
                {
                    dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                    dblVerdGehalt = fktGehaltUmrechnenAufNormal(dblVerdGehalt, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);                 // ...mol/l auf g/l umrechnen
                    strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                    strVerdGehalt = strVerdGehalt.replace(",", ".");                   // Komma in Punkt umwandeln - wichtig für double
                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                    et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                    et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
                }

                strVerdGehaltEinheit = "N";                                                           // ...umschalten auf g/l

                tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);                        // ... und N auf Button schreiben
                tv.setText(strVerdGehaltEinheit);
                break;

            case "N":

                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
                strVerdGehalt = et.getText().toString();

                if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
                {
                    dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                    dblVerdGehalt = fktGehaltUmrechnenAufGrammProLiter(dblVerdGehalt, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);                 // ...mol/l auf g/l umrechnen
                    strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                    strVerdGehalt = strVerdGehalt.replace(",", ".");                    // Komma in Punkt umwandeln - wichtig für double
                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                    et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                    et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
                }

                strVerdGehaltEinheit = "g/l";                                                           // ...umschalten auf g/l

                tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
                tv.setText(strVerdGehaltEinheit);
                break;

            case "g/l":

                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
                strVerdGehalt = et.getText().toString();

                if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
                {
                    dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                    dblVerdGehalt = fktGehaltUmrechnenAufMolar(dblVerdGehalt, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);                 // ...mol/l auf g/l umrechnen
                    strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                    strVerdGehalt = strVerdGehalt.replace(",", ".");                    // Komma in Punkt umwandeln - wichtig für double
                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                    et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                    et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
                }

                if (strStoWert.equals("1") == true)
                {
                    strVerdGehaltEinheit = "mol/l";                                                       // ...umschalten auf mol/l
                }
                else
                {
                    strVerdGehaltEinheit = "M";                                                         // ...umschalten auf M
                }

                tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
                tv.setText(strVerdGehaltEinheit);
                break;
        }

    } // btn g/l / mol/l / N



    /***********************************************************************************************
     ***************** Button Verdünnung g oder ml => Dichtetabelle ********************************
     *** dieser Button erscheint nur bei Salz-, Schwefel- oder Salpetersäure ************ ***********
     ***********************************************************************************************/

    public void btnEinheitVerdMenge(View v)
    {
        tv = (TextView) v;
        strVerdMengeEinheit = tv.getText().toString();          // Auslesen der aktuellen Einheit Menge der Verdünnung g oder ml
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        strVerdGehalt = et.getText().toString();                // Auslesen des Gehaltes der Verdünnung in %

        if (strVerdGehalt.equals("") == false)                  // Nur wenn das Feld voll ist, dann ...
        {
            switch (strVerdGehaltEinheit)
            {
                case "g/l":                                 //Wenn die Einheit der Konzentration der Verdünnung g/l ist
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    dblVerdKonzMol = fktGehaltUmrechnenAufMolar(dblVerdKonzMol, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);
                    strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
                    break;
                case "mol/l":                               // bei mol/l keine Umrechnung
                    strVerdKonzMol = strVerdGehalt;
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    break;
                case "M":                                   // bei M  keine Umrechnung
                    strVerdKonzMol = strVerdGehalt;
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    break;
                case "N":
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    dblVerdKonzMol = fktGehaltUmrechnenAufMolar(dblVerdKonzMol, strAuswahl, strVerdGehaltEinheit, dblStoWert, dblMolmasse, dblVerdDichte);
                    strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
                    break;
            }

            if (dblKonzGehalt <= dblVerdKonzMol)                 // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
            {
                fktAusgabeKonzVerdZuHoch ();                    // Funktion Warnmeldung
            }
            else
            {
                if(strVerdMengeEinheit.equals("ml") == true)         // Wenn das Feld auf ml steht ...
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity_4.this);
                    builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);
                    builder.setMessage("Die Masse der verdünnten " + strKonzAuswahl + " kann nicht direkt berechnet werden! " +
                            "Man kann jedoch die Dichte der entsprechnenden Konzentration mit einer Tabelle ermitteln, interpolieren und " +
                            "zum Schluß die Masse auf das Volumen umgerechnen! Soll die Tabelle angewendet werden?");
                    builder.setPositiveButton
                            ("Ja",
                                    new DialogInterface.OnClickListener()
                                    {
                                        public void onClick(DialogInterface dialog, int id)
                                        {
                                            strVerdMengeEinheit = "g";
                                            TextView tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);                // Buttonbeschriftung umschalten auf g
                                            tv.setText(strVerdMengeEinheit);

                                            tv = (TextView) findViewById(R.id.tvNameVerd);                                          // und das Textfeld auf Masse umgeschaltet
                                            tv.setText("Masse in");

                                            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                                // Das Volumen der Verdünnung wird ausgelesen
                                            strVerdMenge = et.getText().toString();

                                            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Das Eingabefeld für den Gehalt der Verdünnung verschwindet
                                            et.setVisibility(View.GONE);

                                            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);                        // Der Button "mol/l - g/l" der Verdünnung verschwindet
                                            tv.setVisibility(View.GONE);

                                            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);                                 // Das Textfeld mit der Einheit Gehalt wieder unsichtbar machen.
                                            tv.setVisibility(View.VISIBLE);
                                            tv.setText(strVerdGehaltEinheit);

                                            tv = (TextView) findViewById(R.id.tvGehaltVerd);                                        // ... und das Textfeld mit dem Gehalt wird sichtbar gemacht.
                                            tv.setVisibility(View.VISIBLE);                                                         // der Gehalt kann jetzt nicht mehr geändert werden.
                                            tv.setText(strVerdGehalt);

                                            double dblDummy = 0;

                                            dblVerdDichte = fktDichtetabellen(strKonzAuswahl, dblDummy, dblKonzMenge, dblVerdMenge, strVerdKonzMol, strVerdGehaltEinheit); // Aufruf der Funktion Dichtetabelle
                                            // Dichte wurde ermittelt

                                            tr = (TableRow) findViewById(R.id.trDichteVerd);                                        // TableRow für die Dichte wird sichtbar gemacht.
                                            tr.setVisibility(View.VISIBLE);
                                            strVerdDichte = ActivityTools.fktSignifikanteStellen(dblVerdDichte, 5);     // 5 Stellen
                                            tv = (TextView) findViewById(R.id.tvDichteVerd);
                                            tv.setText(strVerdDichte);

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
                else                                                                    // wenn der Button auf g steht,
                {
                    strVerdMengeEinheit = "ml";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);     // Buttonbeschriftung umschalten auf ml
                    tv.setText(strVerdMengeEinheit);

                    tv = (TextView) findViewById(R.id.tvNameVerd);                      // und das Textfeld wieder auf Volumen umgeschaltet
                    tv.setText("Volumen in");

                    tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);    // Der Button "mol/l - g/l" der Verdünnung wird wieder sichtbar gemacht
                    tv.setVisibility(View.VISIBLE);

                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);           // Das Eingabefeld für den Gehalt der Verdünnung wieder sichtbar gemacht
                    et.setVisibility(View.VISIBLE);
                    et.setText("");
                    et.requestFocus();                                                  // Cursor in den Focus setzen

                    tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Das Textfeld mit der Einheit Gehalt wieder unsichtbar machen.
                    tv.setVisibility(View.GONE);

                    tv = (TextView) findViewById(R.id.tvGehaltVerd);                    // ... und das Textfeld (nur Anzeige) mit dem Gehalt wieder unsichtbar gemacht.
                    tv.setVisibility(View.GONE);

                    tr = (TableRow) findViewById(R.id.trDichteVerd);                    // TableRow für die Dichte wird wieder unsichtbar gemacht.
                    tr.setVisibility(View.GONE);
                }
            }
        }
        else
        {
            String text = "\nBitte zuerst den Gehalt der Verdünnung eingeben!\n";
            Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
            Meldung.setGravity(Gravity.TOP, 0, 0);
            Meldung.show();
        }
    } // btn Verdünnung g / ml


    /* *********************************************************************************************
     ***************** Button Berechnung Verd Menge ************************************************
     ***********************************************************************************************/

    public void btnBerechneKonz(View v)
    {
        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);                           // Auslesen der Menge der Konz. Lösung in g oder ml
        strKonzMenge = et.getText().toString();
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);                          // Auslesen der Einheit der Menge der Konze. Lösung in g oder ml
        strKonzMengeEinheit = tv.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                           // Auslesen des Gehaltes der Verdünnung in %
        strVerdGehalt = et.getText().toString();
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);                     // Auslesen der Einheit der Menge der Konzentration in g oder ml
        strVerdMengeEinheit = tv.getText().toString();

        if ((strKonzMenge.equals("") == false) && (strVerdGehalt.equals("") == false))      // Wenn beide Felder voll sind ...
        {
            dblKonzMenge = Double.parseDouble(strKonzMenge);                                // Aus String ein Double erzeugen
            dblVerdGehalt = Double.parseDouble(strVerdGehalt);                              // Aus String ein Double erzeugen

            if ((dblKonzMenge != 0) && (dblVerdGehalt != 0))                                // Wenn eines der Felder <> 0 ist, dann ...
            {
                if (strKonzMengeEinheit.equals("g") == true)                               // Wenn die Einheit der Verdünnung g ist
                {
                    dblKonzMenge = dblKonzMenge / dblKonzDichte;                            // ... auf ml umrechnen (für die Berechung!!!)
                }                                                                           // (dies betrifft nur den Doublewert der String bleibt für die Anzeige unverändert)

                switch (strVerdGehaltEinheit)
                {
                    case "g/l":
                        dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                        dblVerdKonzMol = dblVerdKonzMol / dblMolmasse;   // ...g/l auf mol/l umrechnen
                        strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
                        break;

                    case "mol/l":
                        strVerdKonzMol = strVerdGehalt;                     // bei mol/l keine Umrechnung
                        dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                        break;

                    case "M":
                        strVerdKonzMol = strVerdGehalt;                     // bei mol/l keine Umrechnung
                        dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                        break;

                    case "N":
                        dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                        dblVerdKonzMol = dblVerdKonzMol / dblStoWert;     // bei N umrechnen auf mol/l M
                        strVerdKonzMol = Double.toString(dblVerdKonzMol);
                        break;
                }

                /*if (strVerdGehaltEinheit.equals("g/l") == true)      //Wenn die EInheit der Konzentration der Verdünnung g/l ist
                {
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    dblVerdKonzMol = dblVerdKonzMol / dblMolmasse;   // ...g/l auf mol/l umrechnen
                    strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
                }
                else                                                    //Wenn die EInheit der Konzentration der Verdünnung mol/l ist
                {
                    strVerdKonzMol = strVerdGehalt;                     // bei mol/l keine Umrechnung
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                }*/

                if (dblKonzGehalt <= dblVerdKonzMol)                                         // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
                {
                    fktAusgabeKonzVerdZuHoch ();                                            // Funktion Warnmeldung
                }
                else
                {
                    /* **************************************************************************************
                     ***************** Berechnung Verd Menge ************************************************
                     ****************************************************************************************/
                    dblVerdMenge = (dblKonzMenge * dblKonzGehalt) / dblVerdKonzMol;

                    if (strVerdMengeEinheit.equals("g") == true)                     // Wenn die Einheit der Verd Lösung g ist
                    {                                                                 // (Also, wenn die Berechnung in g gewünscht ist...)
                        dblVerdMenge = dblVerdMenge * dblVerdDichte;                  // ... die Verd Menge auf g umrechnen
                    }

                    /* **************************************************************************************
                     ***************** Anzeige im neuen Display (Layout) ************************************
                     ****************************************************************************************/

                    strVerdMenge = ActivityTools.fktSignifikanteStellen(dblVerdMenge, 4); // 4 Stellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);

                    Spannable span = new SpannableString(strVerdMenge + strVerdMengeEinheit);
                    span.setSpan(new StyleSpan(BOLD), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    CharSequence finalText = TextUtils.concat("Um aus " + strKonzMenge + strKonzMengeEinheit +
                            " einer " + strKonzAuswahl + " (" + strKonzGehalt + strKonzGehaltEinheit +
                            ") eine Verdünnung " + strVerdGehalt + strVerdGehaltEinheit +" herzustellen," +
                            " muss man die konzentrierte " + strKonzAuswahl + " zusammen mit Wasser zu "
                            , span , " verdünnen.");

                    tv.setText(finalText);

                    tv2 = (TextView) findViewById(R.id.tvKonzErgebnis2);
                    tv2.setTextSize(getResources().getDimension(R.dimen.textsize_3sp));
                    tv2.setText(strKonzAuswahl + " " + strKonzGehalt+strKonzGehaltEinheit +
                            " \n Dichte = " + strKonzDichte + " g/ml \n" +
                            " Molmasse = " + strKonzMolmasse + " mol/l \n " +
                            " Stöchiometrische Wertigkeit = " + strStoWert);
                }
            }
        }
    }  // btnBerechneMasseKonz

    /********************************************
     ************** Funktionen ******************
     ********************************************/

    private void fktAusgabeKonzVerdZuHoch ()
    {
        String text = "\nDie Konzentration der Verdünnung " + strVerdGehalt + strVerdGehaltEinheit + " ist nicht kleiner, als die" +
                " Konzentration der " + strKonzAuswahl +" "+ strKonzGehalt + strKonzGehaltEinheit + ". Eine Verdünnung " +
                "ist nicht möglich!\n";
        Toast Meldung = Toast.makeText(Konz_lsg_verd_Activity_4.this, text, Toast.LENGTH_LONG);
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

