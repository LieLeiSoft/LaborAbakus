package de.laborabakus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class Konz_lsg_Anpassung_Activity extends Activity /*implements OnFocusChangeListener */ {


    EditText et;
    TextView tv;
    String strAcidAuswahl;
    String strAcidGehalt;
    String strEinheitGehalt;
    String strDichte;
    String strMolmasse;
    String strAuswahl;
    double dblAcidGehalt;
    double dblDichte;
    double dblMolmasse;
    double dblErgebnis;


    /** wird ausgef�hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_anpassung);


    } // onCreate

    /** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume()
    { super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strAuswahl = prefs.getString("Auswahl", "0");

        strAcidAuswahl = prefs.getString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);
        tv = (TextView) findViewById(R.id.etAnpassungName);
        tv.setText(strAcidAuswahl);

        strAcidGehalt = prefs.getString("AcidGehalt_"+strAuswahl, strAcidGehalt);
        tv = (TextView) findViewById(R.id.etAnpassungGehalt);
        tv.setText(strAcidGehalt);
        dblAcidGehalt = Double.parseDouble(strAcidGehalt);

        strEinheitGehalt = prefs.getString("EinheitGehalt_"+strAuswahl, strEinheitGehalt);
        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
        tv.setText(strEinheitGehalt);

        strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        tv = (TextView) findViewById(R.id.etAnpassungDichte);
        tv.setText(strDichte);
        dblDichte = Double.parseDouble(strDichte);

        strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
        tv = (TextView) findViewById(R.id.etAnpassungMolmasse);
        tv.setText(strMolmasse);
        dblMolmasse = Double.parseDouble(strMolmasse);

    } // onResume

    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");

        et = (EditText) findViewById(R.id.etAnpassungName);
        strAcidAuswahl = et.getText().toString();
        prefEditor.putString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strAcidGehalt = et.getText().toString();
        prefEditor.putString("AcidGehalt_"+strAuswahl, strAcidGehalt);

        et = (EditText) findViewById(R.id.etAnpassungDichte);
        strDichte = et.getText().toString();
        prefEditor.putString("Dichte_"+strAuswahl, strDichte);

        et = (EditText) findViewById(R.id.etAnpassungMolmasse);
        strMolmasse = et.getText().toString();
        prefEditor.putString("Molmasse_"+strAuswahl, strMolmasse);

        prefEditor.apply();

    } // onPause

    // ******************************************************************************************
    // ******************* Button btnAuswahl ********************************************************
    // ******************************************************************************************

    public void btnEinheitGehalt(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strEinheitGehalt = tv.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        if (strEinheitGehalt.equals("%") == true)
        {
            strEinheitGehalt = "mol/L";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strEinheitGehalt);

            // Umrechnung auf mol/L

            dblAcidGehalt = (dblAcidGehalt * dblDichte * 1000) / (100 * dblMolmasse);
            dblAcidGehalt = ActivityTools.fktRunden(dblAcidGehalt, 2); // 2 Nachkommastellen
            strAcidGehalt = Double.toString(dblAcidGehalt);
            tv = (TextView) findViewById(R.id.etAnpassungGehalt);
            tv.setText(strAcidGehalt);

        }
        else
        {
            strEinheitGehalt = "%";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strEinheitGehalt);

            // Umrechnung auf %

            dblAcidGehalt = (dblAcidGehalt * dblMolmasse) / (10 * dblDichte);
            dblAcidGehalt = ActivityTools.fktRunden(dblAcidGehalt, 2); // 2 Nachkommastellen
            strAcidGehalt = Double.toString(dblAcidGehalt);
            tv = (TextView) findViewById(R.id.etAnpassungGehalt);
            tv.setText(strAcidGehalt);
        }
        strAuswahl = prefs.getString("Auswahl", "0");
        prefEditor.putString("EinheitGehalt_"+strAuswahl, strEinheitGehalt);
        prefEditor.apply();

    } // btnAuswahl

} // class Konz_lsg_Anpassung

