package de.laborabakus;

import android.app.Activity;
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


public class Konz_lsg_verd_Activity_3 extends Activity /*implements OnFocusChangeListener */
{
    View v;
    TextView tv;
    EditText et;
    String strVerdMenge;
    String strVerdGehaltEinheit ="mol/l";
    String strAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strKonzMengeEinheit = "ml";
    String strKonzMenge;
    String strKonzAuswahl;
    String strErgebnis;
    String strDichte;
    String strMolmasse;
    String strBerechnung_ueber;
    double dblKonzMenge;
    double dblVerdMenge;
    double dblKonzGehalt;
    double dblDichte;
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

    } // onCreate

    /** wird ausgef?hrt, wenn Activicty angezeigt wird */

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strBerechnung_ueber = prefs.getString("Berechnung_ueber", "Proz");
        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        dblDichte = Double.parseDouble(strDichte);
        strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
        dblMolmasse = Double.parseDouble(strMolmasse);

        if(strBerechnung_ueber.equals("Masse") == true)
        {
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setText("g");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
            tv.setText("%");

            tv = (TextView) findViewById(R.id.tvNameVerd);
            tv.setText("Masse");

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);  // Button verschwinden lassen
            tv.setVisibility(View.GONE);
        }
        else
        {
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setText("ml");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
            tv.setText("mol/l");

            tv = (TextView) findViewById(R.id.tvNameVerd);
            tv.setText("Volumen");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt); // Textfeld % verschwinden lassen
            tv.setVisibility(View.GONE);
        }

        tv = (TextView) findViewById(R.id.tvAcidBase);
        tv.setText(strKonzAuswahl + " " + strKonzGehalt + strKonzGehaltEinheit);

        // Eingabefeld Konzentration der Verdünnung unsichtbar machen
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        et.setVisibility(View.GONE);
        tv = (TextView) findViewById(R.id.textView7);
        tv.setVisibility(View.VISIBLE);
        // Berechnung Button der Konzentrierten Lösung unsichtbar machen
        View b = findViewById(R.id.tvBerechnungKonz);
        b.setVisibility(View.INVISIBLE);


    } // onResume

    @Override
    protected void onPause() {
        super.onPause();
    } // onPause



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
        }
        else
        {
            strVerdGehaltEinheit = "g/l";                 // ...umschalten auf g/l

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitVerdGehalt);
            tv.setText(strVerdGehaltEinheit);
        }
    } // btn g/l / mol/l


    /* *********************************************************************************************
     ***************** Button g / ml ***************************************************************
     ***********************************************************************************************/

    public void btnEinheitKonz(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strKonzMengeEinheit = tv.getText().toString();

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("");    // Beim Wechsel von g auf ml oder umgekehrt, das Ergebnisfeld löschen

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
                dblKonzMenge = dblKonzMenge / dblDichte;   // ...die Masse auf Volumen umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblKonzMenge, 2); // 2 Nachkommastellen
                strKonzMenge = Double.toString(dblErgebnis);
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
                dblKonzMenge = dblKonzMenge * dblDichte;   // ...die Volumen auf Masse umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblKonzMenge, 2); // 2 Nachkommastellen
                strKonzMenge = Double.toString(dblErgebnis);
                et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
                et.setText(strKonzMenge);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }
        }
    } // btn g / ml

    // *********** bis hier kontrolliert *************

    /* *********************************************************************************************
     ***************** Button Berechnung ************************************************************
     ***********************************************************************************************/

    public void btnBerechneKonz(View v)
    {
        // Die eingegebenen Felder werden ausgelesen
        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
        strKonzMenge = et.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
        strVerdMenge = et.getText().toString();


        if ((strKonzMenge.equals("") == false) && (strVerdMenge.equals("") == false)) // Wenn beide Felder voll sind ...
        {
            dblKonzMenge = Double.parseDouble(strKonzMenge);
            dblVerdMenge = Double.parseDouble(strVerdMenge);

            if ((dblKonzMenge != 0) && (dblVerdMenge != 0) == true) // Wenn eines der Felder <> 0 ist ...
            {
                // *************************************************************
                // ********* Berechnung Gehalt % der Verdünnung ****************
                // *************************************************************

                if(strBerechnung_ueber.equals("Masse") == true)       // Wenn Einheit der Verd g ist
                {
                    if(strKonzMengeEinheit.equals("ml"))                   // Wenn Einheit der Konz ml ist
                    {                                                 // generell auf g umrechnen (Masse!!!)
                        dblKonzMenge = dblKonzMenge * dblDichte;      // wird auf g umgerechnet
                    }

                    // ********************************************************************
                    // ********* generell Umrechnung Gehalt der Konz auf % ****************
                    // ********************************************************************

                    switch (strKonzGehaltEinheit)
                    {
                        case "g/l":

                            dblKonzGehalt = dblKonzGehalt / (10 * dblDichte);                 // wird auf % umgerechnet

                            break;
                        case "mol/l":

                            dblKonzGehalt = (dblKonzGehalt * dblMolmasse) / (10 * dblDichte); // wird auf % umgerechnet

                            break;
                    }

                    dblErgebnis = (dblKonzMenge * dblKonzGehalt) / dblVerdMenge;

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    strErgebnis = ActivityTools.fktDoubleToStringFormat(dblErgebnis, 3);   // 2 Nachkommastellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Wenn man " + strKonzMenge + strKonzMengeEinheit + " einer " + strKonzAuswahl +
                            " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                            " zu " + strVerdMenge + "g verdünnt, erhält man eine verdünnte " +
                            strKonzAuswahl +" mit einem Gehalt von "
                            + strErgebnis + " %");
                }

                // **************************************************************************
                // ********* Berechnung Gehalt mol/l oder g/l der Verdünnung ****************
                // **************************************************************************

                else                                                  // Wenn Einheit der Verd ml ist
                {
                    if(strKonzMengeEinheit.equals("g"))                    // Wenn Einheit der Konz g ist
                    {                                                 // generell auf ml umrechnen (Masse!!!)
                        dblKonzMenge = dblKonzMenge / dblDichte;      // wird auf ml umgerechnet
                    }

                    // ************************************************************************
                    // ********* generell Umrechnung Gehalt der Konz auf mol/l ****************
                    // ************************************************************************

                    switch (strKonzGehaltEinheit)
                    {
                        case "%":

                            dblKonzGehalt = (dblKonzGehalt * dblDichte * 10) / dblMolmasse;            //wird auf mol/l umgerechnet

                            break;
                        case "g/l":

                            dblKonzGehalt = dblKonzGehalt / dblMolmasse;                               // wird auf mol/l umgerechnet

                            break;
                    }

                    dblErgebnis = (dblKonzMenge * dblKonzGehalt) / dblVerdMenge;

                    if(strVerdGehaltEinheit.equals("g/l") == true)
                    {
                        dblErgebnis = dblErgebnis * dblMolmasse;
                    }

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    strErgebnis = ActivityTools.fktDoubleToStringFormat(dblErgebnis, 3);   // 2 Nachkommastellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Wenn man " + strKonzMenge + strKonzMengeEinheit + " einer " + strKonzAuswahl +
                            " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                            " zu " + strVerdMenge + "ml verdünnt, erhält man eine verdünnte " +
                            strKonzAuswahl +" mit einem Gehalt von "
                            + strErgebnis + " " + strVerdGehaltEinheit);
                }
/*
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                strErgebnis = ActivityTools.fktDoubleToStringFormat(dblVerdGehalt, 3);   // 2 Nachkommastellen

                setContentView(R.layout.konz_lsg_ergebnis);

                if(strBerechnung_ueber.equals("Masse") == true)    // Wenn Einheit der Verd g und % ist
                {
                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Wenn man " + strKonzMenge +"g einer " + strKonzAuswahl +
                            " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                            " zu " + strVerdMenge + "g verdünnt, erhält man eine verdünnte " +
                            strKonzAuswahl +" mit einem Gehalt von "
                            + strErgebnis + " %");
                }
                else                                               // Wenn Einheit der Verd ml und mol/l ist
                {
                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Wenn man " + strKonzMenge +"mL einer " + strKonzAuswahl +
                            " (" +strKonzGehalt + strKonzGehaltEinheit + ") mit Wasser" +
                            " zu " + strVerdMenge + "ml verdünnt, erhält man eine verdünnte " +
                            strKonzAuswahl +" mit einem Gehalt von "
                            + strErgebnis + " " + strVerdGehaltEinheit);
                }
                */
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
            String text = "\nBitte die Masse der konzentrierten " + strKonzAuswahl +" und die Masse der Verdünnung eingeben!\n";
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
