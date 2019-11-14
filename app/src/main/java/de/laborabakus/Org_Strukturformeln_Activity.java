package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
//import android.support.v4.content.ContextCompat;


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
        int intResId;

        ImageButton btn = (ImageButton) findViewById(v.getId());
        Drawable drawable = btn.getDrawable();
/*

A) drawables with theme attributes

ContextCompat.getDrawable(getActivity(), R.drawable.name);

You’ll obtain a styled Drawable as your Activity theme instructs. This is probably what you need.

B) drawables without theme attributes

ResourcesCompat.getDrawable(getResources(), R.drawable.name, null);

You’ll get your unstyled drawable the old way.
 */

//      if (drawable.getConstantState().equals(getResources().getDrawable(R.drawable.hh0001a1_008).getConstantState())){
// "getResources().getDrawable" ist seit Android 5.1 (API 22) veraltet (deprecated)
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.hh0001a1_008).getConstantState())){
            strZellenname = "hh0001a1_008";
            intResId = R.drawable.hh0001a1_008;
        }

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

