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
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Konz_lsg_verd_Activity extends Activity /*implements OnFocusChangeListener */
{
    View v;
    TextView tv;
    EditText et;
    String strMasseVerd;
    String strGehaltVerd;
    String strAuswahl;
    String strAcidGehalt;
    String strEinheitGehalt;
    String strAcidAuswahl;
    String strEinheitGehaltVerd;
    String strGesucht;
    String strErgebnis;
    String strDichte;
    String strMolmasse;
    double dblMasseAcid;
    double dblMasseVerd;
    double dblGehaltVerd;
    double dblGehaltAcid;
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

        strAcidAuswahl = prefs.getString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);
        strAcidGehalt = prefs.getString("AcidGehalt_"+strAuswahl, strAcidGehalt);
        strEinheitGehalt = prefs.getString("EinheitGehalt_"+strAuswahl, strEinheitGehalt);
        strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        dblDichte = Double.parseDouble(strDichte);
        strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
        dblMolmasse = Double.parseDouble(strMolmasse);
        strGesucht = prefs.getString("Gesucht", "MasseKonz");

        tv = (TextView) findViewById(R.id.tvAcidBase);
        tv.setText(strAcidAuswahl + " " + strAcidGehalt + strEinheitGehalt);

        strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
        tv.setText(strEinheitGehaltVerd);

        if (strGesucht.equals("MasseKonz") == true)
        {
            strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Masse der Konzentrierten Lösung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView5);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Verdünnung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz5);
            b.setVisibility(View.INVISIBLE);
        }

        if (strGesucht.equals("MasseVerd") == true)
        {
            strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Masse der Verdünnung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView6);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Konzentrierten Lösung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz);
            b.setVisibility(View.INVISIBLE);
        }

        if (strGesucht.equals("GehaltVerd") == true)
        {
            strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Konzentration der Verdünnung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView7);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Konzentrierten Lösung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz);
            b.setVisibility(View.INVISIBLE);
        }

    } // onResume

    @Override
    protected void onPause() {
        super.onPause();
    } // onPause


    /* *********************************************************************************************
     ***************** Button % / mol/L ************************************************************
     ***********************************************************************************************/

    public void btnEinheitGehaltVerd(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strEinheitGehaltVerd = tv.getText().toString();

        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        strGehaltVerd = et.getText().toString();

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("");    // Beim Wechsel von % auf mol/L oder umgekehrt das Ergebnisfeld löschen

        if (strEinheitGehaltVerd.equals("%") == true)   // Wenn das Feld auf % steht ...
        {
            strEinheitGehaltVerd = "mol/L";             // ...umschalten auf mol/L

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            if (strGehaltVerd.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblGehaltVerd = Double.parseDouble(strGehaltVerd);
                dblGehaltVerd = (dblGehaltVerd * dblDichte * 1000) / (100 * dblMolmasse); // ...den Gehalt auf mol/L umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblGehaltVerd, 2); // 2 Nachkommastellen
                strGehaltVerd = Double.toString(dblErgebnis);
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strGehaltVerd);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }
        }
        else
        {
            strEinheitGehaltVerd = "%";                 // ...umschalten auf mol/L

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            if (strGehaltVerd.equals("") == false)      // Nur wenn das Feld voll ist, dann ...
            {
                dblGehaltVerd = Double.parseDouble(strGehaltVerd);
                dblGehaltVerd = (dblGehaltVerd * dblMolmasse) / (10 * dblDichte);   // ...den Gehalt auf % umrechnen
                dblErgebnis = ActivityTools.fktRunden(dblGehaltVerd, 2); // 2 Nachkommastellen
                strGehaltVerd = Double.toString(dblErgebnis);
                et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
                et.setText(strGehaltVerd);
                et.setSelection(et.getText().length());     // Cursor nach rechts setzen
            }
        }
    } // btn % mol/L

    /* *********************************************************************************************
     ***************** Button Berechnung ************************************************************
     ***********************************************************************************************/

    public void btnBerechneMasseKonz(View v)
    {
        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
        strMasseVerd = et.getText().toString();
        et = (EditText) findViewById(R.id.etAnpassungGehaltVerd);
        strGehaltVerd = et.getText().toString();

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("");    // das Ergebnisfeld löschen

        if ((strMasseVerd.equals("") == false) && (strGehaltVerd.equals("") == false)) // Wenn beide Felder voll sind ...
        {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor prefEditor = prefs.edit();

            strAuswahl = prefs.getString("Auswahl", "0");
            strAcidAuswahl = prefs.getString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);
            strAcidGehalt = prefs.getString("AcidGehalt_"+strAuswahl, strAcidGehalt);
            strEinheitGehalt = prefs.getString("EinheitGehalt_"+strAuswahl, strEinheitGehalt);
            strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
            strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);

            dblGehaltAcid = Double.parseDouble(strAcidGehalt);
            dblDichte = Double.parseDouble(strDichte);
            dblMolmasse = Double.parseDouble(strMolmasse);
            dblMasseVerd = Double.parseDouble(strMasseVerd);
            dblGehaltVerd = Double.parseDouble(strGehaltVerd);

            if (strEinheitGehalt.equals("mol/L") == true)
            {
                dblGehaltAcid = (dblGehaltAcid * dblMolmasse) / (10 * dblDichte);
            }

            if (strEinheitGehaltVerd.equals("mol/L") == true) // fehlt noch konz mol/L bzw %!!!!!!!!!!!!!!!!!!!!!!
            {
                dblErgebnis = (dblGehaltVerd * dblMolmasse) / (10 * dblDichte);   // ...den Gehalt auf % umrechnen
            }
            else
            {
                dblErgebnis = dblGehaltVerd;
            }

            if ((dblMasseVerd != 0) && (dblGehaltVerd != 0)) // Wenn eines der Felder <> 0 ist ...
            {
                if (dblErgebnis >= dblGehaltAcid) // Wenn der Gehalt der Verd größer der Konz ist ...
                {
                    String text = "\n  Der Gehalt der  \n  Verdünnung ist größer,  \n  als der Gehalt der  \n" + strAcidAuswahl +" "+ strAcidGehalt + strEinheitGehalt + "\n  Da gibt es nichts  \n  zu verdünnen!  \n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                    Meldung.setGravity(Gravity.TOP, 0, 0);
                    Meldung.show();
                }
                else
                {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    // Berechnung der Masse der Konzentrierten Lösung
                    // Masse Konz = (MasseVerd * GehaltVerd) / GehaltKonz

                    if (strEinheitGehaltVerd.equals("%") == true)
                    {
                        dblMasseAcid = (dblMasseVerd * dblGehaltVerd) / dblGehaltAcid;
                        strErgebnis = ActivityTools.fktDoubleToStringFormat(dblMasseAcid, 1); // 1 Nachkommastellen
                    }
                    else
                    {
                        dblGehaltVerd = (dblGehaltVerd * 100 * dblMolmasse) / (dblDichte * 1000);
                        dblMasseAcid = (dblMasseVerd * dblGehaltVerd) / dblGehaltAcid;
                        strErgebnis = ActivityTools.fktDoubleToStringFormat(dblMasseAcid, 1); // 1 Nachkommastellen
                    }

                    tv = (TextView) findViewById(R.id.tvErgebnis1);
                    tv.setText("Für den Ansatz einer " + strAcidAuswahl + " " + strGehaltVerd + " " + strEinheitGehaltVerd +
                            ", benötigt man " + strErgebnis + " g einer " + strAcidAuswahl + " " + strAcidGehalt + " " +
                            strEinheitGehalt + ", die mit Wasser zu " + strMasseVerd + " g verdünnt werden muss.");
                }
            }
            else
            {
                String text = "\n   Bitte keine   \n   0 eingeben!  \n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }
        }
        else
        {
            String text = "\n   Bitte Masse und Gehalt   \n   der Verdünnung eingeben!   \n";
            Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
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
                intent.putExtra("Kapitel", "RSD");
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
