package de.laborabakus;

import android.app.Activity;
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

    TextView tv;
    TextView tv2;
    String strKonzAuswahl = "";
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strCounter;
    String strX;
    int intCounter;
    int resId;
    int resId2;



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
            prefEditor.putString("Wertigkeit_0", "1");
            // Salzsäure
            prefEditor.putString("KonzAuswahl_1", "Salzsäure");
            prefEditor.putString("KonzGehalt_1", "25");
            prefEditor.putString("KonzGehaltEinheit_1", "%");
            prefEditor.putString("Dichte_1", "1.123");
            prefEditor.putString("Molmasse_1", "36.461");
            prefEditor.putString("Wertigkeit_1", "1");
            // Schwefelsäure
            prefEditor.putString("KonzAuswahl_2", "Schwefelsäure");
            prefEditor.putString("KonzGehalt_2", "96");
            prefEditor.putString("KonzGehaltEinheit_2", "%");
            prefEditor.putString("Dichte_2", "1.8355");
            prefEditor.putString("Molmasse_2", "98.076");
            prefEditor.putString("Wertigkeit_2", "2");
            // Schwefelsäure
            prefEditor.putString("KonzAuswahl_3", "Schwefelsäure");
            prefEditor.putString("KonzGehalt_3", "98");
            prefEditor.putString("KonzGehaltEinheit_3", "%");
            prefEditor.putString("Dichte_3", "1.8361");
            prefEditor.putString("Molmasse_3", "98.076");
            prefEditor.putString("Wertigkeit_3", "2");
            // Salpetersäure
            prefEditor.putString("KonzAuswahl_4", "Salpetersäure");
            prefEditor.putString("KonzGehalt_4", "65");
            prefEditor.putString("KonzGehaltEinheit_4", "%");
            prefEditor.putString("Dichte_4", "1.391");
            prefEditor.putString("Molmasse_4", "63.012");
            prefEditor.putString("Wertigkeit_4", "1");
            // Phosphorsäure
            prefEditor.putString("KonzAuswahl_5", "Phosphorsäure");
            prefEditor.putString("KonzGehalt_5", "85");
            prefEditor.putString("KonzGehaltEinheit_5", "%");
            prefEditor.putString("Dichte_5", "1.689");
            prefEditor.putString("Molmasse_5", "97.994");
            prefEditor.putString("Wertigkeit_5", "3");
            // Essigsäure
            prefEditor.putString("KonzAuswahl_6", "Essigsäure");
            prefEditor.putString("KonzGehalt_6", "100");
            prefEditor.putString("KonzGehaltEinheit_6", "%");
            prefEditor.putString("Dichte_6", "1.048");
            prefEditor.putString("Molmasse_6", "60.052");
            prefEditor.putString("Wertigkeit_6", "1");
            // Essigsäure
            prefEditor.putString("KonzAuswahl_7", "Essigsäure");
            prefEditor.putString("KonzGehalt_7", "1");
            prefEditor.putString("KonzGehaltEinheit_7", "mol/l");
            prefEditor.putString("Dichte_7", "1.00693");
            prefEditor.putString("Molmasse_7", "60.052");
            prefEditor.putString("Wertigkeit_7", "1");
            // Perchlorsäure
            prefEditor.putString("KonzAuswahl_8", "Perchlorsäure");
            prefEditor.putString("KonzGehalt_8", "71");
            prefEditor.putString("KonzGehaltEinheit_8", "%");
            prefEditor.putString("Dichte_8", "1.684");
            prefEditor.putString("Molmasse_8", "100.457");
            prefEditor.putString("Wertigkeit_8", "1");
            // Wasserstoffperoxid
            prefEditor.putString("KonzAuswahl_9", "Wasserstoffperoxid");
            prefEditor.putString("KonzGehalt_9", "35");
            prefEditor.putString("KonzGehaltEinheit_9", "%");
            prefEditor.putString("Dichte_9", "1.132");
            prefEditor.putString("Molmasse_9", "34.014");
            prefEditor.putString("Wertigkeit_9", "1");
            // Wasserstoffperoxid
            prefEditor.putString("KonzAuswahl_10", "Wasserstoffperoxid");
            prefEditor.putString("KonzGehalt_10", "25");
            prefEditor.putString("KonzGehaltEinheit_10", "%");
            prefEditor.putString("Dichte_10", "1.092");
            prefEditor.putString("Molmasse_10", "34.014");
            prefEditor.putString("Wertigkeit_10", "1");
            // Natronlauge
            prefEditor.putString("KonzAuswahl_11", "Natronlauge");
            prefEditor.putString("KonzGehalt_11", "40");
            prefEditor.putString("KonzGehaltEinheit_11", "%");
            prefEditor.putString("Dichte_11", "1.43");
            prefEditor.putString("Molmasse_11", "39.997");
            prefEditor.putString("Wertigkeit_11", "1");
            // Natronlauge
            prefEditor.putString("KonzAuswahl_12", "Natronlauge");
            prefEditor.putString("KonzGehalt_12", "10");
            prefEditor.putString("KonzGehaltEinheit_12", "mol/l");
            prefEditor.putString("Dichte_12", "1.32904");
            prefEditor.putString("Molmasse_12", "39.997");
            prefEditor.putString("Wertigkeit_12", "1");
            // Kalilauge
            prefEditor.putString("KonzAuswahl_13", "Kalilauge");
            prefEditor.putString("KonzGehalt_13", "47");
            prefEditor.putString("KonzGehaltEinheit_13", "%");
            prefEditor.putString("Dichte_13", "1.468");
            prefEditor.putString("Molmasse_13", "56.109");
            prefEditor.putString("Wertigkeit_13", "1");
            // Ammoniaklösung
            prefEditor.putString("KonzAuswahl_14", "Ammoniaklösung");
            prefEditor.putString("KonzGehalt_14", "32");
            prefEditor.putString("KonzGehaltEinheit_14", "%");
            prefEditor.putString("Dichte_14", "0.886");
            prefEditor.putString("Molmasse_14", "17.031");
            prefEditor.putString("Wertigkeit_14", "1");
            // Ammoniaklösung
            prefEditor.putString("KonzAuswahl_15", "Ammoniaklösung");
            prefEditor.putString("KonzGehalt_15", "25");
            prefEditor.putString("KonzGehaltEinheit_15", "%");
            prefEditor.putString("Dichte_15", "0.907");
            prefEditor.putString("Molmasse_15", "17.031");
            prefEditor.putString("Wertigkeit_15", "1");
            // Musterlauge
            prefEditor.putString("KonzAuswahl_16", "Mustersäure");
            prefEditor.putString("KonzGehalt_16", "100");
            prefEditor.putString("KonzGehaltEinheit_16", "%");
            prefEditor.putString("Dichte_16", "0.999");
            prefEditor.putString("Molmasse_16", "123");
            prefEditor.putString("Wertigkeit_16", "1");
            prefEditor.apply();
            // Musterlauge
            prefEditor.putString("KonzAuswahl_17", "Musterlauge");
            prefEditor.putString("KonzGehalt_17", "10");
            prefEditor.putString("KonzGehaltEinheit_17", "mol/l");
            prefEditor.putString("Dichte_17", "0.777");
            prefEditor.putString("Molmasse_17", "456");
            prefEditor.putString("Wertigkeit_17", "1");
            prefEditor.apply();
            // Musterlauge
            prefEditor.putString("KonzAuswahl_18", "Musterlösung");
            prefEditor.putString("KonzGehalt_18", "250");
            prefEditor.putString("KonzGehaltEinheit_18", "g/l");
            prefEditor.putString("Dichte_18", "2.345");
            prefEditor.putString("Molmasse_18", "345");
            prefEditor.putString("Wertigkeit_18", "1");
            prefEditor.apply();
            // Musterlauge
            prefEditor.putString("KonzAuswahl_19", "Musterlösung");
            prefEditor.putString("KonzGehalt_19", "5");
            prefEditor.putString("KonzGehaltEinheit_19", "N");
            prefEditor.putString("Dichte_19", "1.123");
            prefEditor.putString("Molmasse_19", "234");
            prefEditor.putString("Wertigkeit_19", "2");
            prefEditor.apply();
            // Musterlauge
            prefEditor.putString("KonzAuswahl_20", "Musterlösung");
            prefEditor.putString("KonzGehalt_20", "2.5");
            prefEditor.putString("KonzGehaltEinheit_20", "M");
            prefEditor.putString("Dichte_20", "0.987");
            prefEditor.putString("Molmasse_20", "123");
            prefEditor.putString("Wertigkeit_20", "2");
            prefEditor.apply();

            // Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
            ActivityRegistry.register(this);
        } // if


        for (int x=0; x<=20; x++) // 21 Zeilen im Auswahl-Layout
        {
            // hier werden die Felder im Layout befüllt
            strX = Integer.toString(x);
            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strX, strKonzAuswahl);
            strKonzGehalt = prefs.getString("KonzGehalt_"+strX, strKonzGehalt);
            strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strX, strKonzGehaltEinheit);

            resId = getResources().getIdentifier("KonzAuswahl_"+strX, "id", getPackageName());
            resId2 = getResources().getIdentifier("btnLsg_"+strX, "id", getPackageName());

            tv = (TextView) findViewById(resId);
            tv2 = (TextView) findViewById(resId2);

            tv.setText(strKonzAuswahl+" "+strKonzGehalt+strKonzGehaltEinheit);



            if (strKonzAuswahl.contains("Wasserstoffperoxid") || strKonzAuswahl.contains("säure"))
            {
                tv.setBackgroundColor(getResources().getColor(R.color.chellhellblau));
                tv2.setBackgroundColor(getResources().getColor(R.color.chellhellblau));
            }
            else
            {
                if (strKonzAuswahl.contains("Ammoniak") || strKonzAuswahl.contains("lauge"))
                {
                    tv.setBackgroundColor(getResources().getColor(R.color.chellrosa));
                    tv2.setBackgroundColor(getResources().getColor(R.color.chellrosa));
                }
                else
                {
                    tv.setBackgroundColor(getResources().getColor(R.color.cHellgruen));
                    tv2.setBackgroundColor(getResources().getColor(R.color.cHellgruen));
                }
            }

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
