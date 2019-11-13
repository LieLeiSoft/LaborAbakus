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


public class Konz_lsg_verd_Activity_1 extends Activity
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
    String strVerdGehaltEinheit = "%";
    String strVerdMenge;
    String strVerdMengeEinheit = "g";
    String strVerdDichte;

    double dblKonzGehalt;
    double dblKonzDichte;
    double dblKonzMenge;
    double dblMolmasse;
    double dblVerdGehalt;
    double dblVerdDichte;
    double dblVerdMenge;
    double dblDummy = 0;


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

        tv = (TextView) findViewById(R.id.tvNameKonz);                       // Textfeld "ist gesucht" sichtbar machen
        tv.setText("Volumen in ");

        tv = (TextView) findViewById(R.id.textView5);                       // Textfeld "ist gesucht" sichtbar machen
        tv.setVisibility(View.VISIBLE);

        // Verdünnung

        View b = findViewById(R.id.tvBerechnungKonz5);                      // "Berechnung Button" der Verdünnung unsichtbar machen
        b.setVisibility(View.INVISIBLE);

        tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);             // Textfeld % bei dem Gehalt der Verdünnung
        tv.setText("%");

        tv = (TextView) findViewById(R.id.tvNameVerd);                      // Textfeld Masse bei der Verdünnung
        tv.setText("Masse");

        tv = (TextView) findViewById(R.id.tvEinheitVerd);                   // Textfeld g bei Masse der Verdünnung
        tv.setText("g");

        tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);    // Button mol/l / g/l verschwinden lassen
        tv.setVisibility(View.GONE);

        // Spezieller Menge Button (g / ml) für die Dichtetabelle nur bri folgenden Säuren
        if(strKonzAuswahl.equals("Salzsäure") || strKonzAuswahl.equals("Schwefelsäure") || strKonzAuswahl.equals("Salpetersäure") == true)
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
                        // keine Umrechnung notwendig
                break;
            case "g/l":

                dblKonzGehalt = dblKonzGehalt / (10 * dblKonzDichte);                   // g/l wird auf % umgerechnet

                break;
            case "mol/l":

                dblKonzGehalt = (dblKonzGehalt * dblMolmasse) / (10 * dblKonzDichte);   // mol/l wird auf % umgerechnet

                break;
        }

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
            tv.setText("Volumen in");
        }
        else
        {
            strKonzMengeEinheit = "g";                 // ...umschalten auf g

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzMengeEinheit);

            tv = (TextView) findViewById(R.id.tvNameKonz);
            tv.setText("Masse in");
        }
    } // btn g / ml



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
            dblVerdGehalt = Double.parseDouble(strVerdGehalt);
            if (dblKonzGehalt <= dblVerdGehalt)                 // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
            {
                fktAusgabeKonzVerdZuHoch ();                    // Funktion Warnmeldung
            }
            else
            {
                if(strVerdMengeEinheit.equals("g") == true)         // Wenn das Feld auf g steht ...
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_verd_Activity_1.this);
                    builder.setTitle("Dichtetabelle\n" + strKonzAuswahl);
                    builder.setMessage("Das Volumen der verdünnten " + strKonzAuswahl + " kann nicht direkt berechnet werden! " +
                            "Man kann jedoch die Dichte der entsprechnenden Konzentration mit einer Tabelle ermitteln, interpolieren und " +
                            "dann das Volumen auf die Masse umgerechnen! Soll die Tabelle angewendet werden?");
                    builder.setPositiveButton
                            ("Ja",
                                    new DialogInterface.OnClickListener()
                                    {
                                        public void onClick(DialogInterface dialog, int id)
                                        {
                                            strVerdMengeEinheit = "ml";
                                            TextView tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);                // Buttonbeschriftung umschalten auf ml
                                            tv.setText(strVerdMengeEinheit);

                                            tv = (TextView) findViewById(R.id.tvNameVerd);                                          // und das Textfeld auf Volumen umgeschaltet
                                            tv.setText("Volumen");

                                            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                                // Die Masse der Verdünnung wird ausgelesen
                                            strVerdMenge = et.getText().toString();

                                            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                               // Das Eingabefeld für den Gehalt der Verdünnung verschwindet
                                            et.setVisibility(View.GONE);

                                            tv = (TextView) findViewById(R.id.tvGehaltVerd);                                        // ... und das Textfeld mit dem Gehalt wird sichtbar gemacht.
                                            tv.setVisibility(View.VISIBLE);                                                         // der Gehalt kann jetzt nicht mehr geändert werden.
                                            tv.setText(strVerdGehalt);

                                            double dblDummy = 0;
                                            dblVerdDichte = fktDichtetabellen(strKonzAuswahl, dblDummy, dblKonzMenge, dblVerdMenge, strVerdGehalt, strVerdGehaltEinheit); // Aufruf der Funktion Dichtetabelle
                                                // Dichte wurde ermittelt

                                            tr = (TableRow) findViewById(R.id.trDichteVerd);                                        // TableRow für die Dichte wird sichtbar gemacht.
                                            tr.setVisibility(View.VISIBLE);
                                            strVerdDichte = ActivityTools.fktSignifikanteStellen(dblVerdDichte, 5);     // 3 Stellen
                                            tv = (TextView) findViewById(R.id.tvDichteVerd);
                                            tv.setText(strVerdDichte);

                                        if (strVerdMenge.equals("") == false)                                                   // Nur wenn das Feld voll ist, dann ...
                                            {
                                                dblVerdMenge = Double.parseDouble(strVerdMenge);                                // ... wird von der eingegebenen Menge ein Double erzeugt, ...

                                                dblVerdMenge = dblVerdMenge / dblVerdDichte;                                    // ... schon gleich die Masse auf das Volumen umgerechnet.

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
                else                                                                    // wenn der Button auf ml steht,
                {
                    strVerdMengeEinheit = "g";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdMenge);     // Buttonbeschriftung umschalten auf g
                    tv.setText(strVerdMengeEinheit);

                    tv = (TextView) findViewById(R.id.tvNameVerd);                      // und das Textfeld wieder auf Masse umgeschaltet
                    tv.setText("Masse");

                    et = (EditText) findViewById(R.id.etAnpassungMasseVerd);            // Das Masse-Eingabefeld wird geleert
                    et.setText("");

                    et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);           // Das Eingabefeld für den Gehalt der Verdünnung wieder sichtbar gemacht
                    et.setVisibility(View.VISIBLE);
                    et.setText("");
                    et.requestFocus();                                                  // Cursor in den Focus setzen

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
     ***************** Button Berechnung Konz Menge ************************************************
     ***********************************************************************************************/

    public void btnBerechneMasseKonz(View v)
    {
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);                            // Auslesen der aktuellen Menge der Verdünnung
        strVerdMenge = et.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);                           // Auslesen des Gehaltes der Verdünnung in %
        strVerdGehalt = et.getText().toString();
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);                          // Auslesen der Einheit der Menge der Konzentration in g oder ml
        strKonzMengeEinheit = tv.getText().toString();;

        if ((strVerdMenge.equals("") == false) && (strVerdGehalt.equals("") == false))      // Wenn beide Felder voll sind ...
        {
            dblVerdMenge = Double.parseDouble(strVerdMenge);                                // Aus String ein Double erzeugen
            dblVerdGehalt = Double.parseDouble(strVerdGehalt);                              // Aus String ein Double erzeugen

            if ((dblVerdMenge != 0) && (dblVerdGehalt != 0))                                // Wenn eines der Felder <> 0 ist, dann ...
            {
                if (strVerdMengeEinheit.equals("ml") == true)                               // Wenn die Einheit der Verdünnung ml ist
                {
                    dblVerdMenge = dblVerdMenge * dblVerdDichte;                            // ... auf g umrechnen (für die Berechung!!!)
                }                                                                           // (dies betrifft nur den Doublewert der String bleibt für die Anzeige unverändert)

                dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                if (dblKonzGehalt <= dblVerdGehalt)                                         // Wenn die Gehalt der Verdünnung größer ist als die Konz Lösung
                {
                    fktAusgabeKonzVerdZuHoch ();                                            // Funktion Warnmeldung
                }
                else
                {
                    /* **************************************************************************************
                     ***************** Berechnung Konz Menge ************************************************
                     ****************************************************************************************/
                    dblKonzMenge = (dblVerdMenge * dblVerdGehalt) / dblKonzGehalt;

                    if (strKonzMengeEinheit.equals("ml") == true)                               // Wenn die Einheit der Konz Lösung ml ist
                    {                                                                           // (Also wenn die Berechnung in ml gewünscht ist...)
                        dblKonzMenge = dblKonzMenge / dblKonzDichte;                            // ... die Konz Menge auf ml umrechnen
                    }

                    /* **************************************************************************************
                     ***************** Anzeige im neuen Display (Layout) ************************************
                     ****************************************************************************************/

                    strKonzMenge = ActivityTools.fktSignifikanteStellen(dblKonzMenge, 4); // 3 Stellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);

                    Spannable span = new SpannableString(strKonzMenge + strKonzMengeEinheit);
                    span.setSpan(new StyleSpan(BOLD), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    CharSequence finalText = TextUtils.concat("Für den Ansatz einer " + strKonzAuswahl + " "
                            + strVerdGehalt + strVerdGehaltEinheit +
                            ", benötigt man ", span , " einer " + strKonzAuswahl + " " + strKonzGehalt + " " +
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
        String text = "\nDie Konzentration der " + strVerdGehalt + "%igen Verdünnung ist nicht kleiner, als die" +
                " Konzentration der " + strKonzAuswahl +" "+ strKonzGehalt + strKonzGehaltEinheit + ". Eine Verdünnung " +
                "ist nicht möglich!\n";
        Toast Meldung = Toast.makeText(Konz_lsg_verd_Activity_1.this, text, Toast.LENGTH_LONG);
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

