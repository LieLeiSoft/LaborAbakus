package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Konz_lsg_Anpassung_Activity extends Activity /*implements OnFocusChangeListener */ {


    EditText et;
    TextView tv;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strDichte;
    String strMolmasse;
    String strAuswahl;
    String strAlterKonzGehalt;
    String strAlteKonzGehaltEinheit;
    String strAlteDichte;
    double dblKonzGehalt;
    double dblAlterKonzGehalt;
    double dblDichte;
    double dblMolmasse;
    double dblAbweichung;

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
        //dblKonzGehalt = ActivityTools.fktSignifikanteStellen(strKonzGehalt, 4);
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
        strAlterKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        dblAlterKonzGehalt = Double.parseDouble(strAlterKonzGehalt);
        strAlteDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        strAlteKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strAlteKonzGehaltEinheit);

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);

        et = (EditText) findViewById(R.id.etAnpassungDichte);
        strDichte = et.getText().toString();

        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
        strKonzGehaltEinheit = tv.getText().toString();

        if (strDichte.equals(strAlteDichte) == true)
        {
            if (strAlteKonzGehaltEinheit.equals(strKonzGehaltEinheit) == false)
            {
                if (strKonzGehaltEinheit.equals("%"))
                {
                    dblAlterKonzGehalt = (dblAlterKonzGehalt * dblMolmasse) / (10 * dblDichte);
                }
                else
                {
                    dblAlterKonzGehalt = (dblAlterKonzGehalt * dblDichte * 10) / dblMolmasse;
                }
            }
            if (dblAlterKonzGehalt >= dblKonzGehalt)
            {
                dblAbweichung = ((dblAlterKonzGehalt - dblKonzGehalt) / dblAlterKonzGehalt) * 100;
            }
            else
            {
                dblAbweichung = ((dblKonzGehalt - dblAlterKonzGehalt) / dblKonzGehalt) * 100;
            }

            if (dblAbweichung > 1)
            {
                String text = "\nAchtung: Der Gehalt wurde gravierend geändert ohne die Dichte anzupassen!! ist das Korrekt?\n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }
        }

        et = (EditText) findViewById(R.id.etAnpassungName);
        strKonzAuswahl = et.getText().toString();
        prefEditor.putString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);

        prefEditor.putString("KonzGehalt_"+strAuswahl, strKonzGehalt);

        prefEditor.putString("Dichte_"+strAuswahl, strDichte);

        et = (EditText) findViewById(R.id.etAnpassungMolmasse);
        strMolmasse = et.getText().toString();
        prefEditor.putString("Molmasse_"+strAuswahl, strMolmasse);

        strAuswahl = prefs.getString("Auswahl", "0");
        prefEditor.putString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);

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

        //strAuswahl = prefs.getString("Auswahl", "0");
        //prefEditor.putString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
        //prefEditor.apply();

    } // btnAuswahl


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent[] intent = {null};
        switch (item.getItemId()) {
            case R.id.menu_Hilfe:
                intent[0] = new Intent(this, HilfeActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent[0].putExtra("Kapitel", "Konz_Lsg_Anpassung");
                startActivity(intent[0]);
                return true;

            case R.id.menu_Menue:
                ActivityRegistry.finishAll();
                intent[0] = new Intent(this, HauptmenueActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent[0]);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

} // class Konz_lsg_Anpassung

