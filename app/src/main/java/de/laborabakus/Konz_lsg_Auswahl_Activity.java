package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Konz_lsg_Auswahl_Activity extends Activity /*implements View.OnClickListener*/  {

    //private View mButton;
    // EditText et;
    TextView tv;
    String strKonzAuswahl = "";
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strCounter;
    String strX;
    int intCounter;
    int resId;



    /** wird ausgef�hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_auswahl);


    } // onCreate

    /** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strCounter = prefs.getString("strCounter", "0");
        intCounter = Integer.parseInt(strCounter);

        if (intCounter == 0) // nur, wenn nichts eingegeben wurde (also auch beim Ersten mal)
        {
            intCounter = intCounter +1;
            strCounter = Integer.toString(intCounter);

            prefEditor.putString("strCounter", strCounter);
            //prefEditor.putString("KonzGehaltEinheitVerd", "%");

            // Salzsäure
            prefEditor.putString("KonzAuswahl_0", "Salzsäure");
            prefEditor.putString("KonzGehalt_0", "37");
            prefEditor.putString("KonzGehaltEinheit_0", "%");
            prefEditor.putString("Dichte_0", "1.183");
            prefEditor.putString("Molmasse_0", "36.461");
            // Schwefelsäure
            prefEditor.putString("KonzAuswahl_1", "Schwefelsäure");
            prefEditor.putString("KonzGehalt_1", "97");
            prefEditor.putString("KonzGehaltEinheit_1", "%");
            prefEditor.putString("Dichte_1", "1.8364");
            prefEditor.putString("Molmasse_1", "98.076");
            // Salpetersäure
            prefEditor.putString("KonzAuswahl_2", "Salpetersäure");
            prefEditor.putString("KonzGehalt_2", "65");
            prefEditor.putString("KonzGehaltEinheit_2", "%");
            prefEditor.putString("Dichte_2", "1.391");
            prefEditor.putString("Molmasse_2", "63.012");
            // Phosphorsäure
            prefEditor.putString("KonzAuswahl_3", "Phosphorsäure");
            prefEditor.putString("KonzGehalt_3", "85");
            prefEditor.putString("KonzGehaltEinheit_3", "%");
            prefEditor.putString("Dichte_3", "1.689");
            prefEditor.putString("Molmasse_3", "97.994");
            // Essigsäure
            prefEditor.putString("KonzAuswahl_4", "Essigsäure");
            prefEditor.putString("KonzGehalt_4", "100");
            prefEditor.putString("KonzGehaltEinheit_4", "%");
            prefEditor.putString("Dichte_4", "1.048");
            prefEditor.putString("Molmasse_4", "60.052");
            // Perchlorsäure
            prefEditor.putString("KonzAuswahl_5", "Perchlorsäure");
            prefEditor.putString("KonzGehalt_5", "71");
            prefEditor.putString("KonzGehaltEinheit_5", "%");
            prefEditor.putString("Dichte_5", "1.684");
            prefEditor.putString("Molmasse_5", "100.457");
            // Wasserstoffperoxid
            prefEditor.putString("KonzAuswahl_6", "Wasserstoffperoxid");
            prefEditor.putString("KonzGehalt_6", "35");
            prefEditor.putString("KonzGehaltEinheit_6", "%");
            prefEditor.putString("Dichte_6", "1.132");
            prefEditor.putString("Molmasse_6", "34.014");
            // Mustersäure
            prefEditor.putString("KonzAuswahl_7", "Mustersäure");
            prefEditor.putString("KonzGehalt_7", "1");
            prefEditor.putString("KonzGehaltEinheit_7", "mol/l");
            prefEditor.putString("Dichte_7", "1.0");
            prefEditor.putString("Molmasse_7", "1");
            // Natronlauge
            prefEditor.putString("KonzAuswahl_8", "Natronlauge");
            prefEditor.putString("KonzGehalt_8", "40");
            prefEditor.putString("KonzGehaltEinheit_8", "%");
            prefEditor.putString("Dichte_8", "1.43");
            prefEditor.putString("Molmasse_8", "39.997");
            // Kalilauge
            prefEditor.putString("KonzAuswahl_9", "Kalilauge");
            prefEditor.putString("KonzGehalt_9", "50");
            prefEditor.putString("KonzGehaltEinheit_9", "%");
            prefEditor.putString("Dichte_9", "1.503");
            prefEditor.putString("Molmasse_9", "56.109");
            // Ammoniaklösung
            prefEditor.putString("KonzAuswahl_10", "Ammoniaklösung");
            prefEditor.putString("KonzGehalt_10", "32");
            prefEditor.putString("KonzGehaltEinheit_10", "%");
            prefEditor.putString("Dichte_10", "0.886");
            prefEditor.putString("Molmasse_10", "17.031");
            // Musterlauge
            prefEditor.putString("KonzAuswahl_11", "Musterlauge");
            prefEditor.putString("KonzGehalt_11", "10");
            prefEditor.putString("KonzGehaltEinheit_11", "mol/l");
            prefEditor.putString("Dichte_11", "0.999");
            prefEditor.putString("Molmasse_11", "1");
            prefEditor.apply();

            // Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
            ActivityRegistry.register(this);
        } // if


        for (int x=0; x<=11; x++) // 12 Zeilen im Auswahl-Layout
        {
            // hier werden die Felder im Layout befüllt
            strX = Integer.toString(x);
            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strX, strKonzAuswahl);
            strKonzGehalt = prefs.getString("KonzGehalt_"+strX, strKonzGehalt);
            strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strX, strKonzGehaltEinheit);

            resId = getResources().getIdentifier("KonzAuswahl_"+strX, "id", getPackageName());
            tv = (TextView) findViewById(resId);
            tv.setText(strKonzAuswahl+" "+strKonzGehalt+strKonzGehaltEinheit);

        } //for
    } // onResume

    @Override
    protected void onPause()
    {
        super.onPause();




    } // onPause

    // ******************************************************************************************
    // ******************* Button Auswahl ********************************************************
    // ******************************************************************************************
    public void btnAuswahl(View v) {
        String strFeldname = "";
        int intPos = 0;
        String strAuswahl = "";

        // Feldnamen anhand der ID ermitteln
        strFeldname = getResources().getResourceEntryName(v.getId());
        // Feldnummer aus Feldnamen extrahieren und in strAuswahl speichern
        intPos = strFeldname.indexOf("_")+1;
        strAuswahl = strFeldname.substring(intPos);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Auswahl", strAuswahl);
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_Gesucht_Activity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btnLsg0

    public void btnLsg(View v) {
        String strFeldname = "";
        int intPos = 0;
        String strAuswahl = "";

        // Feldnamen anhand der ID ermitteln
        strFeldname = getResources().getResourceEntryName(v.getId());
        // Feldnummer aus Feldnamen extrahieren und in strAuswahl speichern
        intPos = strFeldname.indexOf("_")+1;
        strAuswahl = strFeldname.substring(intPos);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Auswahl", strAuswahl);
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_Anpassung_Activity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btnLsg

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent[] intent = {null};
        switch (item.getItemId())
        {
            case R.id.menu_Hilfe:
                intent[0] = new Intent(this, HilfeActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent[0].putExtra("Kapitel", "Konz_Lsg_Auswahl");
                startActivity(intent[0]);
                return true;

            case R.id.menu_Menue:
                ActivityRegistry.finishAll();
                intent[0] = new Intent(this, HauptmenueActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent[0]);
                return true;

            case R.id.menu_Aus:
                ActivityRegistry.finishAll();
                finish();
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    } // onOptionsItemSelected

    /*@Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button1:
                // Do something
        }
    }*/
} // class Konz_lsg_Auswahl
