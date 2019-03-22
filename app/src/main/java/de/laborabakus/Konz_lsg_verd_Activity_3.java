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
    String strArtikel;
    String strArtikel2;
    double dblKonzMenge;
    double dblVerdMenge;
    double dblVerdGehalt;
    double dblKonzGehalt;
    double dblDichte;
    double dblMolmasse;
    double dblErgebnis;
    double dblErgebnis2;


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
        }
        else
        {
            tv = (TextView) findViewById(R.id.tvEinheitVerd);
            tv.setText("ml");

            tv = (TextView) findViewById(R.id.tvEinheitVerdGehalt);
            tv.setText("mol/l");

            tv = (TextView) findViewById(R.id.tvNameVerd);
            tv.setText("Volumen");
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

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("");    // das Ergebnisfeld löschen

        if ((strKonzMenge.equals("") == false) && (strVerdMenge.equals("") == false)) // Wenn beide Felder voll sind ...
        {
            dblKonzMenge = Double.parseDouble(strKonzMenge);
            dblVerdMenge = Double.parseDouble(strVerdMenge);

            if ((dblKonzMenge != 0) && (dblVerdMenge != 0) == true) // Wenn eines der Felder <> 0 ist ...
            {
                if(strBerechnung_ueber.equals("Masse") == true)    // Wenn Einheit der Verd g ist
                {
                    if(strKonzGehaltEinheit.equals("mol/l") == true)    // Wenn Einheit der Konz mol/l ist
                    {                                                   // generell auf % umrechnen (Proz!!!)
                        dblErgebnis = (dblKonzGehalt * dblMolmasse * 100) / (1000 * dblDichte); // wird auf % umgerechnet
                    }
                    else
                    {
                        dblErgebnis = dblKonzGehalt;                  // sonst dbl Ergebnis = dblKonzGehalt
                    }

                    if(strKonzEinheit.equals("ml"))                   // Wenn Einheit der Konz ml ist
                    {                                                 // generell auf g umrechnen (Masse!!!)
                        dblErgebnis2 = dblKonzMenge * dblDichte;      // wird auf g umgerechnet
                    }
                    else
                    {
                        dblErgebnis2 = dblKonzMenge;                  // sonst dbl Ergebnis2 = dblKonzMenge
                    }
                }
                else                                              // Wenn Einheit der Verd ml ist
                {
                    if(strKonzGehaltEinheit.equals("%") == true)    // Wenn Einheit der Konz % ist
                    {                                               // generell auf mol/l umrechnen (Proz!!!)
                        dblErgebnis = (dblKonzGehalt * dblDichte * 1000) / (100 * dblMolmasse);  //wird auf mol/l umgerechnet
                    }
                    else
                    {
                        dblErgebnis = dblKonzGehalt;                    // sonst dbl Ergebnis = dblKonzGehalt
                    }

                    if(strKonzEinheit.equals("g"))                    // Wenn Einheit der Konz g ist
                    {                                                 // generell auf ml umrechnen (Masse!!!)
                        dblErgebnis2 = dblKonzMenge / dblDichte;      // wird auf ml umgerechnet
                    }
                    else
                    {
                        dblErgebnis2 = dblKonzMenge;                  // sonst dbl Ergebnis2 = dblKonzMenge
                    }
                }

                if (dblErgebnis2 >= dblVerdMenge) // Wenn die Masse der Konz größer der Verd ist ...
                {
                    if (strBerechnung_ueber.equals("Masse") == true){strArtikel ="Die Masse"; strArtikel2 ="die Masse";}
                    else{strArtikel ="Das Volumen"; strArtikel2 ="das Volumen";}

                    String text = "\n" +strArtikel + " der " + strKonzAuswahl +" ("+ strKonzGehalt + strKonzGehaltEinheit +
                                  ") ist gleich bzw. größer, als " + strArtikel2 + " der Verdünnung. Das ist nicht möglich!\n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                    Meldung.setGravity(Gravity.TOP, 0, 0);
                    Meldung.show();
                }
                else
                {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    /*******************************************************************
                     ****** Berechnung der Masse Konz über prozentuale Verdünnung ******
                     *******************************************************************/

                    dblVerdGehalt = (dblErgebnis2 * dblErgebnis) / dblVerdMenge;            // Berechnung der Menge in g oder ml!!!
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
                                + strErgebnis + " mol/l");
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
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId())
        {
            case R.id.menu_Einstellungen:
                intent = new Intent(this, Einstellungen_Gravi_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                return true;

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
