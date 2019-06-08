package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;


public class Org_Strukturformeln_Activity extends Activity {


    String strZellenname;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.org_strukturformeln);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate


    @Override
    public void onResume()
    {
        super.onResume();

    } // onResume


    @Override
    public void onPause() {
        super.onPause();

    } // onPause

    public void btnZelle(View v)
    {
        strZellenname = getResources().getResourceEntryName(v.getId());  // Der ID Zellenname wird in einen String umgewandelt

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Strukturformel", strZellenname);
        prefEditor.apply();


        Intent myIntent = new Intent(Org_Strukturformeln_Activity.this, Org_Generator_Activity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(myIntent);
    }


} // class Org_Generator

