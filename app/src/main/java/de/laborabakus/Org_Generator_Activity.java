package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Org_Generator_Activity extends Activity {


    String strZellenname;
    String strStrukturformel;
    String strZeile;
    String strSpalte;
    int intCounter = 0;
    int resIdFeld;
    int resIdZelle;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.org_generator);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate


    @Override
    public void onResume()
    {
        super.onResume();

        String strText;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strStrukturformel = prefs.getString("Strukturformel", "");
        resIdZelle = prefs.getInt("resIdZelle", 0);

        if(resIdFeld != 0) // Wird abgefangen, wenn beim ersten Mal resID =0
        {
            ImageButton ibt;
            ibt = (ImageButton) findViewById(resIdFeld);
            ibt.setImageResource(R.drawable.co1111a12_011);

            // ibt.setImageResource(resIdZelle); // funzt nicht :-(
        }


    } // onResume


    @Override
    public void onPause() {
        super.onPause();

    } // onPause

    public void btnFeld(View v)
    {
        strZellenname = getResources().getResourceEntryName(v.getId());  // Der ID Zellenname wird in einen String umgewandelt

        resIdFeld = getResources().getIdentifier(strZellenname, "id", getPackageName());

        strZeile = strZellenname.substring(8,10);   // Beispiel: ibtFeld_115 => 11
        strSpalte = strZellenname.substring(10,11);   // Beispiel: ibtFeld_115 => 5

        intCounter ++;


        Intent myIntent = new Intent(Org_Generator_Activity.this, Org_Strukturformeln_Activity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(myIntent);


    }


} // class Org_Generator

