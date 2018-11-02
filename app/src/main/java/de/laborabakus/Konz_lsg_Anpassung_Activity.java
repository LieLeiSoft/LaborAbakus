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
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strDichte;
    String strMolmasse;
    String strAuswahl;
    double dblKonzGehalt;
    double dblDichte;
    double dblMolmasse;

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

        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        tv = (TextView) findViewById(R.id.etAnpassungName);
        tv.setText(strKonzAuswahl);

        strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);
        tv = (TextView) findViewById(R.id.etAnpassungGehalt);
        tv.setText(strKonzGehalt);

        strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
        tv.setText(strKonzGehaltEinheit);

        strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        dblDichte = Double.parseDouble(strDichte);
        tv = (TextView) findViewById(R.id.etAnpassungDichte);
        tv.setText(strDichte);

        strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
        dblMolmasse = Double.parseDouble(strMolmasse);
        tv = (TextView) findViewById(R.id.etAnpassungMolmasse);
        tv.setText(strMolmasse);

    } // onResume

    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");

        et = (EditText) findViewById(R.id.etAnpassungName);
        strKonzAuswahl = et.getText().toString();
        prefEditor.putString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();
        prefEditor.putString("KonzGehalt_"+strAuswahl, strKonzGehalt);

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
        strKonzGehaltEinheit = tv.getText().toString();

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);

        et = (EditText) findViewById(R.id.etAnpassungDichte);
        strDichte = et.getText().toString();
        dblDichte = Double.parseDouble(strDichte);

        et = (EditText) findViewById(R.id.etAnpassungMolmasse);
        strMolmasse = et.getText().toString();
        dblMolmasse = Double.parseDouble(strMolmasse);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        if (strKonzGehaltEinheit.equals("%") == true)
        {
            strKonzGehaltEinheit = "mol/l";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strKonzGehaltEinheit);

            // Umrechnung auf mol/l

            dblKonzGehalt = (dblKonzGehalt * dblDichte * 10) / dblMolmasse;
            dblKonzGehalt = ActivityTools.fktRunden(dblKonzGehalt, 4); // 2 Nachkommastellen
        }
        else
        {
            strKonzGehaltEinheit = "%";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strKonzGehaltEinheit);

            // Umrechnung auf %

            dblKonzGehalt = (dblKonzGehalt * dblMolmasse) / (10 * dblDichte);
            dblKonzGehalt = ActivityTools.fktRunden(dblKonzGehalt, 4); // 2 Nachkommastellen
        }

        strKonzGehalt = Double.toString(dblKonzGehalt);
        tv = (TextView) findViewById(R.id.etAnpassungGehalt);
        tv.setText(strKonzGehalt);

        strAuswahl = prefs.getString("Auswahl", "0");
        prefEditor.putString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        prefEditor.apply();

    } // btnAuswahl

} // class Konz_lsg_Anpassung

