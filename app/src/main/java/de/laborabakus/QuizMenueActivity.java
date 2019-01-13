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

public class QuizMenueActivity extends Activity {

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/

	TextView tv;
	String strHighscore;


	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.quiz_menue);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
		ActivityRegistry.register(this);

	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();

	    String strLevel;
		String strHighscore;
		String strX;

		int intHighscore = 0;
		int intSpeicher;

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

        for (int x=1; x<=6; x++)
        {
            strX = Integer.toString(x);
            strHighscore = prefs.getString("Highscore"+strX, "0");

            intSpeicher = Integer.parseInt(strHighscore);
            intHighscore = intHighscore + intSpeicher;
        }

        // **********************************
		strHighscore = prefs.getString("Highscore1", "0");
		tv = (TextView) findViewById(R.id.textView8);
		tv.setText("Highscore: "+strHighscore);

		strHighscore = prefs.getString("Highscore2", "0");
		tv = (TextView) findViewById(R.id.textView9);
		tv.setText("Highscore: "+strHighscore);

		strHighscore = prefs.getString("Highscore3", "0");
		tv = (TextView) findViewById(R.id.textView10);
		tv.setText("Highscore: "+strHighscore);

		strHighscore = prefs.getString("Highscore4", "0");
		tv = (TextView) findViewById(R.id.textView11);
		tv.setText("Highscore: "+strHighscore);

		strHighscore = prefs.getString("Highscore5", "0");
		tv = (TextView) findViewById(R.id.textView12);
		tv.setText("Highscore: "+strHighscore);

		strHighscore = prefs.getString("Highscore6", "0");
		tv = (TextView) findViewById(R.id.textView13);
		tv.setText("Highscore: "+strHighscore);
		// **********************************

		strHighscore = Integer.toString(intHighscore);

		tv = (TextView) findViewById(R.id.tvHighscore);
		tv.setText("Highscore: "+strHighscore);

		if(intHighscore > 10)
		{
			tv = (TextView) findViewById(R.id.btnLevel_1);
			tv.setVisibility(View.VISIBLE);
		}

		if(intHighscore > 20)
		{
			tv = (TextView) findViewById(R.id.btnLevel_2);
			tv.setVisibility(View.VISIBLE);
		}

		if(intHighscore > 30)
		{
			tv = (TextView) findViewById(R.id.btnLevel_3);
			tv.setVisibility(View.VISIBLE);
		}

		if(intHighscore > 40)
		{
			tv = (TextView) findViewById(R.id.btnLevel_4);
			tv.setVisibility(View.VISIBLE);
		}

		if(intHighscore > 50)
		{
			tv = (TextView) findViewById(R.id.btnLevel_5);
			tv.setVisibility(View.VISIBLE);
		}



	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		


	} // onPause

	public void btnLevel_1(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "1");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_2(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "2");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_3(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "3");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}
	public void btnLevel_4(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "4");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_5(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "5");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_6(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "6");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}



/*
	public void btnLevel(View v)
	{

		 // DAS KLAPPT IRGENDWIE NICHT BEI MIR!
		String strFeldname = "";
		int intPos = 0;
		String strLevel = "";

		// Feldnamen anhand der ID ermitteln
		strFeldname = getResources().getResourceEntryName(v.getId());
		// Feldnummer aus Feldnamen extrahieren und in strAuswahl speichern
		intPos = strFeldname.indexOf("_")+1;
		strLevel = strFeldname.substring(intPos);

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", strLevel);
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);

	}
*/
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
           		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
           		SharedPreferences.Editor prefEditor = prefs.edit();
           		prefEditor.putString("Einstellungen", "3");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Molmassen");
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
    }	   
} 

