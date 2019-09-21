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


public class Konz_lsg_verd_Activity_2 extends Activity /*implements OnFocusChangeListener */
{
    View v;
    TextView tv;
    EditText et;
    String strVerdGehalt;
    String strVerdGehaltEinheit ="mol/l";
    String strAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strKonzEinheit = "ml";
    String strKonzMenge;
    String strKonzAuswahl;
    String strErgebnis;
    String strDichte;
    String strMolmasse;
    String strBerechnung_ueber;
    double dblKonzMenge;
    double dblVerdMenge;
    double dblVerdGehalt;
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

        // Eingabefeld Masse der Verdünnung unsichtbar machen
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
        et.setVisibility(View.GONE);
        tv = (TextView) findViewById(R.id.textView6);
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

            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            strVerdGehalt = et.getText().toString();

            if (strVerdGehalt.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);
                dblVerdGehalt = dblVerdGehalt / dblMolmasse;   // ...g/l auf mol/l umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblVerdGehalt, 3); // 2 Nachkommastellen
                strVerdGehalt = Double.toString(dblErgebnis);
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
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
                dblVerdGehalt = dblVerdGehalt * dblMolmasse;   // ...mol/l auf g/l umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblVerdGehalt, 3); // 2 Nachkommastellen
                strVerdGehalt = Double.toString(dblErgebnis);
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strVerdGehalt);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
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

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("");    // Beim Wechsel von g auf ml oder umgekehrt, das Ergebnisfeld löschen

        if (strKonzEinheit.equals("g") == true)   // Wenn das Feld auf g steht ...
        {
            strKonzEinheit = "ml";             // ...umschalten auf ml

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzEinheit);

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
            strKonzEinheit = "g";                 // ...umschalten auf g

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitKonz);
            tv.setText(strKonzEinheit);

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

    /* *********************************************************************************************
     ***************** Button Berechnung ************************************************************
     ***********************************************************************************************/

    public void btnBerechneKonz(View v)
    {
        // Die eingegebenen Felder werden ausgelesen
        et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
        strKonzMenge = et.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        strVerdGehalt = et.getText().toString();

        if ((strKonzMenge.equals("") == false) && (strVerdGehalt.equals("") == false)) // Wenn beide Felder voll sind ...
        {
            dblKonzMenge = Double.parseDouble(strKonzMenge);
            dblVerdGehalt = Double.parseDouble(strVerdGehalt);

            if ((dblKonzMenge != 0) && (dblVerdGehalt != 0)) // Wenn eines der Felder <> 0 ist ...
            {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                /*************************************************************************
                 ****** Berechnung der Masse Verdünnung über prozentuale Konz ************
                 *************************************************************************/

                if(strBerechnung_ueber.equals("Proz") == true)    // Wenn Einheit der Verd % ist
                {
                    switch (strKonzGehaltEinheit)
                    {
                        case "%":

                            dblErgebnis = dblKonzGehalt;                                    // keine Umrechnung notwendig

                            break;
                        case "g/l":

                            dblErgebnis = dblKonzGehalt / (10 * dblDichte); // wird auf % umgerechnet

                            break;
                        case "mol/l":

                            dblErgebnis = (dblKonzGehalt * dblMolmasse) / (10 * dblDichte); // wird auf % umgerechnet

                            break;
                    }
                }
                else                                                // Wenn Einheit der Verd mol/l oder g/l ist
                {
                    switch (strKonzGehaltEinheit)
                    {
                        case "%":

                            dblErgebnis = (dblKonzGehalt * dblDichte * 1000) / (100 * dblMolmasse);  //wird auf mol/l umgerechnet

                            break;
                        case "g/l":

                            dblErgebnis = dblKonzGehalt / dblMolmasse;                               // wird auf mol/l umgerechnet

                            break;
                        case "mol/l":

                            dblErgebnis = dblKonzGehalt;                                              // keine Umrechnung notwendig

                            break;
                    }
                }

                if (strVerdGehaltEinheit.equals("g/l") == true)                                // Wenn das Feld auf g/l steht ...
                {
                    dblVerdGehalt = dblVerdGehalt / dblMolmasse;                               // Umrechnung auf mol/l
                }

                /*
                    if(strKonzGehaltEinheit.equals("mol/l") == true)    // Wenn Einheit der Konz mol/l ist
                    {                                                   // generell auf % umrechnen (Proz!!!)
                        dblErgebnis = (dblKonzGehalt * dblMolmasse * 100) / (1000 * dblDichte); // wird auf % umgerechnet
                    }
                    else
                    {
                        dblErgebnis = dblKonzGehalt;                    // sonst dbl Ergebnis = dblKonzGehalt
                    }
                }
                else                                              // Wenn Einheit der Verd mol/l ist
                {
                    if(strKonzGehaltEinheit.equals("%") == true)    // Wenn Einheit der Konz % ist
                    {                                               // generell auf mol/l umrechnen (Proz!!!)
                        dblErgebnis = (dblKonzGehalt * dblDichte * 1000) / (100 * dblMolmasse);  //wird auf mol/l umgerechnet
                    }
                    else
                    {
                        dblErgebnis = dblKonzGehalt;                    // sonst dbl Ergebnis = dblKonzGehalt
                    }
                }
                */



                /*******************************************************************
                 ****** Berechnung der Masse Konz über prozentuale Verdünnung ******
                 *******************************************************************/

                if(strBerechnung_ueber.equals("Proz") == true)    // Wenn Einheit der Verd % ist
                {
                    if(strKonzEinheit.equals("ml") == true)        // Wenn Einheit der Konz ml ist,
                    {                                              // generell... (Proz!!!)
                        dblKonzMenge = dblKonzMenge * dblDichte;   // ...das Volumen auf Masse umrechnen
                    }

                    dblVerdMenge = (dblKonzMenge * dblErgebnis) / dblVerdGehalt;  // Berechnung der Menge in g!!!

                    strErgebnis = ActivityTools.fktDoubleToStringFormat(dblVerdMenge, 2); // 1 Nachkommastellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Um aus " + strKonzMenge + strKonzEinheit+ " einer " + strKonzAuswahl + " (" + strKonzGehalt
                            + strKonzGehaltEinheit + ") eine Verdünnung (" + strVerdGehalt + "%) herzustellen," +
                            " muss man die konzentrierte " + strKonzAuswahl + " zusammen mit Wasser zu " + strErgebnis + "g verdünnen.");
                }
                else                                               // Wenn Einheit der Verd mol/l ist
                {
                    if(strKonzEinheit.equals("g") == true)        // Wenn Einheit der Konz ml ist,
                    {                                              // generell... (Proz!!!)
                        dblKonzMenge = dblKonzMenge / dblDichte;   // ...die Masse auf Volumen umrechnen
                    }

                    dblVerdMenge = (dblKonzMenge * dblErgebnis) / dblVerdGehalt;  // Berechnung der Menge in g!!!

                    strErgebnis = ActivityTools.fktDoubleToStringFormat(dblVerdMenge, 2); // 1 Nachkommastellen

                    setContentView(R.layout.konz_lsg_ergebnis);

                    tv = (TextView) findViewById(R.id.tvKonzErgebnis);
                    tv.setText("Um aus " + strKonzMenge + strKonzEinheit + " einer " + strKonzAuswahl + " (" + strKonzGehalt
                            + strKonzGehaltEinheit + ") eine Verdünnung (" + strVerdGehalt + strVerdGehaltEinheit + ") herzustellen," +
                            " muss man die konzentrierte " + strKonzAuswahl + " zusammen mit Wasser zu " + strErgebnis + "ml verdünnen.");
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
            String text = "\nBitte die Masse konzentrierten " + strKonzAuswahl +" und den Gehalt der Verdünnung eingeben!\n";
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
