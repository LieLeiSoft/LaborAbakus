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


public class Konz_lsg_verd_Activity_2 extends Activity
{
    View v;
    TextView tv;
    EditText et;
    TableRow tr;
    String strAuswahl;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strVerdMengeEinheit = "ml";
    String strKonzDichte;
    String strKonzMolmasse;
    String strKonzMenge;
    String strKonzMengeEinheit;
    String strVerdGehalt;
    String strVerdGehaltneu;
    String strVerdGehaltEinheit = "mol/l";
    String strVerdMenge;
    String strVerdDichte;
    String strVerdKonzMol;

    double dblKonzGehalt;
    double dblKonzDichte;
    double dblKonzMenge;
    double dblMolmasse;
    double dblVerdGehalt;
    double dblVerdDichte;
    double dblVerdMenge;
    double dblVerdKonzMol;


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

        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);            // Eingabefeld Masse der Konzentrierten Lösung unsichtbar machen
        et.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.tvNameKonz);                      // Textfeld "ist gesucht" sichtbar machen
        tv.setText("Volumen in ");

        tv = (TextView) findViewById(R.id.textView5);                       // Textfeld "ist gesucht" sichtbar machen
        tv.setVisibility(View.VISIBLE);

        // Verdünnung

        View b = findViewById(R.id.tvBerechnungKonz5);                      // "Berechnung Button" der Verdünnung unsichtbar machen
        b.setVisibility(View.INVISIBLE);

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld % bei dem Gehalt der Verdünnung
        tv.setText("mol/l");

        tv = (TextView) findViewById(R.id.tvNameVerd);                      // Textfeld Masse bei der Verdünnung
        tv.setText("Volumen");

        tv = (TextView) findViewById(R.id.tvEinheitVerd);                   // Textfeld g bei Masse der Verdünnung
        tv.setText("ml");

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld % verschwinden lassen
        tv.setVisibility(View.GONE);

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
         *** Nur der DoubleWert vom Konz Gehalt wird hier auf mol/l umgerechnet ***********************************
         **********************************************************************************************************/

        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        dblKonzDichte = Double.parseDouble(strKonzDichte);
        dblMolmasse = Double.parseDouble(strKonzMolmasse);

        switch (strKonzGehaltEinheit)
        {
            case "%":

                dblKonzGehalt = (dblKonzGehalt * dblKonzDichte * 10) / dblMolmasse;   // % wird auf mol/l umgerechnet

                break;
            case "g/l":

                dblKonzGehalt = dblKonzGehalt / dblMolmasse;                          // g/l wird auf mol/l umgerechnet

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

        if (strKonzMengeEinheit.equals("g") == true)                        // Wenn das Feld auf g steht ...
        {
            strKonzMengeEinheit = "ml";                                     // ...umschalten auf ml

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzMengeEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Volumen in");
        }
        else
        {
            strKonzMengeEinheit = "g";                                      // ...umschalten auf g

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzMengeEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Masse in");
        }
    } // btn g / ml

    /* *********************************************************************************************
     ***************** Button g/l oder mol/l der Verdünnung ****************************************
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

            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);                                  // Umwandeln in double
                dblVerdGehalt = dblVerdGehalt * dblMolmasse;                                        // ...mol/l auf g/l umrechnen
                strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                strVerdGehalt = strVerdGehalt.replace(",", ".");                   // Komma in Punkt umwandeln - wichtig für double
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
            }
        }
        else
        {
            strVerdGehaltEinheit = "mol/l";                                                         // ...umschalten auf mol/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            tv.setText(strVerdGehaltEinheit);

            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Eingabefeld vom Gehalt der Verdünnung auslesen.
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)                                                  // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);                                  // Umwandeln in double
                dblVerdGehalt = dblVerdGehalt / dblMolmasse;                                        // ...mol/l auf g/l umrechnen
                strVerdGehalt = ActivityTools.fktSignifikanteStellen(dblVerdGehalt, 4); // 4 Stellen
                strVerdGehalt = strVerdGehalt.replace(",", ".");                    // Komma in Punkt umwandeln - wichtig für double
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);                                                          // ... und neuen Wert ins Eingabefeld schreiben
                et.setSelection(et.getText().length());                                             // Cursor nach rechts setzen
            }
        }
    } // btn g/l / mol/l

    /***********************************************************************************************
     ***************** Button Verdünnung g oder ml *************************************************
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
            if (strVerdGehaltEinheit.equals("g/l") == true)      //Wenn die Einheit der Konzentration der Verdünnung g/l ist
            {
                dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                dblVerdKonzMol = dblVerdKonzMol / dblMolmasse;   // ...g/l auf mol/l umrechnen
                strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
            }
            else                                                    //Wenn die EInheit der Konzentration der Verdünnung mol/l ist
            {
                strVerdKonzMol = strVerdGehalt;                     // bei mol/l keine Umrechnung
                dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
            }

            if (dblKonzGehalt <= dblVerdKonzMol)                 // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
            {
                fktAusgabeKonzVerdZuHoch ();                    // Funktion Warnmeldung
            }
            else
            {
                if(strVerdMengeEinheit.equals("ml") == true)         // Wenn das Feld auf g steht ...
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity_2.this);
                    builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);
                    builder.setMessage("Die Masse der verdünnten " + strKonzAuswahl + " kann nicht direkt berechnet werden! " +
                            "Man kann jedoch die Dichte der entsprechnenden Konzentration mit einer Tabelle ermitteln, interpolieren und " +
                            "dann die Masse auf das Volumen umgerechnen! Soll die Tabelle angewendet werden?");
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
                                            tv.setText("Masse");

                                            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                                // Das Volumen der Verdünnung wird ausgelesen
                                            strVerdMenge = et.getText().toString();

                                            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Das Eingabefeld für das Volumen der Verdünnung verschwindet
                                            et.setVisibility(View.GONE);

                                            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);                        // Der Button "mol/l - g/l" der Verdünnung verschwindet
                                            tv.setVisibility(View.GONE);

                                            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);                                 // ... und das Textfeld mit dem Gehalt wird sichtbar gemacht.
                                            tv.setVisibility(View.VISIBLE);                                                         // der Gehalt kann jetzt nicht mehr geändert werden.
                                            tv.setText(strVerdGehaltEinheit);

                                            tv = (TextView) findViewById(R.id.tvGehaltVerd);                                        // ... und das Textfeld mit dem Gehalt wird sichtbar gemacht.
                                            tv.setVisibility(View.VISIBLE);                                                         // der Gehalt kann jetzt nicht mehr geändert werden.
                                            tv.setText(strVerdGehalt);

                                            double dblDummy = 0;
                                            if (strVerdGehaltEinheit.equals("g/l") == true)
                                            {
                                                strVerdGehaltneu = Double.toString((Double.parseDouble(strVerdGehalt)) / dblMolmasse);
                                            }
                                            else
                                            {
                                                strVerdGehaltneu = strVerdGehalt;
                                            }
                                            dblVerdDichte = fktDichtetabellen(strKonzAuswahl, dblDummy, dblKonzMenge, dblVerdMenge, strVerdGehaltneu, strVerdGehaltEinheit); // Aufruf der Funktion Dichtetabelle
                                            // Dichte wurde ermittelt

                                            tr = (TableRow) findViewById(R.id.trDichteVerd);                                        // TableRow für die Dichte wird sichtbar gemacht.
                                            tr.setVisibility(View.VISIBLE);
                                            strVerdDichte = ActivityTools.fktSignifikanteStellen(dblVerdDichte, 5);     // 3 Stellen
                                            tv = (TextView) findViewById(R.id.tvDichteVerd);
                                            tv.setText(strVerdDichte);

                                            if (strVerdMenge.equals("") == false)                                                   // Nur wenn das Feld voll ist, dann ...
                                            {
                                                dblVerdMenge = Double.parseDouble(strVerdMenge);                                // ... wird von der eingegebenen Menge ein Double erzeugt, ...

                                                dblVerdMenge = dblVerdMenge * dblVerdDichte;                                    // ... schon gleich das Volumen auf die Masse umgerechnet.

                                                strVerdMenge = ActivityTools.fktSignifikanteStellen(dblVerdMenge, 4); // Auf 4 signifiknte Stellen gerundet, ...

                                                strVerdMenge = strVerdMenge.replace(",", ".");                  // ... Komma durch Punkt ersetzt ...

                                                et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                        // ... und im Eingabefeld angezeigt.
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
                else                                                                    // wenn der Button auf g steht,
                {
                    strVerdMengeEinheit = "ml";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);     // Buttonbeschriftung umschalten auf ml
                    tv.setText(strVerdMengeEinheit);

                    tv = (TextView) findViewById(R.id.tvNameVerd);                      // und das Textfeld wieder auf Volumen umgeschaltet
                    tv.setText("Volumen");

                    et = (EditText) findViewById(R.id.etAnpassungMasseVerd);            // Das Masse-Eingabefeld wird geleert
                    et.setText("");

                    tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);    // Den Button für die Einheit vom Gehalt der Verdünnung wieder sichtbar gemacht
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


    // ************************** bis hier !!!!!!!!!!!!!!!

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
                if (strVerdMengeEinheit.equals("g") == true)  // generell auf ml umrechnen (mol/l!!!)
                {
                    dblVerdMenge = dblVerdMenge / dblVerdDichte;
                }

                tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
                strKonzMengeEinheit = tv.getText().toString();

                if (strKonzMengeEinheit.equals("g") == true)  // generell auf ml umrechnen (mol/l!!!)
                {
                    dblKonzMenge = dblKonzMenge / dblKonzDichte;
                }

                if (strVerdGehaltEinheit.equals("g/l") == true)      //Wenn die EInheit der Konzentration der Verdünnung g/l ist
                {
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                    dblVerdKonzMol = dblVerdKonzMol / dblMolmasse;   // ...g/l auf mol/l umrechnen
                    strVerdKonzMol = Double.toString(dblVerdKonzMol); // für die Funktion Dichtetabelle
                }
                else                                                    //Wenn die EInheit der Konzentration der Verdünnung mol/l ist
                {
                    strVerdKonzMol = strVerdGehalt;                     // bei mol/l keine Umrechnung
                    dblVerdKonzMol = Double.parseDouble(strVerdGehalt);
                }

                if (dblKonzGehalt <= dblVerdKonzMol)                 // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
                {
                    fktAusgabeKonzVerdZuHoch ();                    // Funktion Warnmeldung
                }
                else
                {
                    /* **************************************************************************************
                     ***************** Berechnung Konz Menge ************************************************
                     ****************************************************************************************/
                    dblKonzMenge = (dblVerdMenge * dblVerdKonzMol) / dblKonzGehalt;

                    if (strKonzMengeEinheit.equals("g") == true)                               // Wenn die Einheit der Konz Lösung g ist
                    {                                                                           // (Also wenn die Berechnung in g gewünscht ist...)
                        dblKonzMenge = dblKonzMenge * dblKonzDichte;                            // ... die Konz Menge auf g umrechnen
                    }

                    /* **************************************************************************************
                     ***************** Anzeige im neuen Display (Layout) ************************************
                     ****************************************************************************************/

                    strKonzMenge = ActivityTools.fktSignifikanteStellen(dblKonzMenge, 4); // 4 Stellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);

                    Spannable span = new SpannableString(strKonzMenge + strKonzMengeEinheit);
                    span.setSpan(new StyleSpan(BOLD), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    CharSequence finalText = TextUtils.concat("Für den Ansatz einer " + strKonzAuswahl +
                            " " + strVerdGehalt + strVerdGehaltEinheit +
                            ", benötigt man " , span , " einer " +
                            strKonzAuswahl + " " + strKonzGehalt + " " +
                            strKonzGehaltEinheit + ", die zusammen mit Wasser zu " + strVerdMenge +
                            strVerdMengeEinheit +" verdünnt werden muss.");

                    tv.setText(finalText);
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
        Toast Meldung = Toast.makeText(Konz_lsg_verd_Activity_2.this, text, Toast.LENGTH_LONG);
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
