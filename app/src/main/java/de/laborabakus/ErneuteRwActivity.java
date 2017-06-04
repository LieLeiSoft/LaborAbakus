package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ErneuteRwActivity extends Activity {

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if ((keyCode == KeyEvent.KEYCODE_BACK)){
	}return false;}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.erneute_rw);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	} // onCreate
	
	@Override
	public void onResume() {
		super.onResume();
		
		TableRow tr;
		TextView tv1;
		TextView tv2;
		TextView tv3;
		CheckBox cb;
		int resId1;
		int resId2;
		int resId3;
		int resId4;
		int resId5;
		String strEinwaage;
		String strNeueRueckwaage;
		String strAlteRueckwaage;
		
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    SharedPreferences.Editor prefEditor = prefs.edit();
    	prefEditor.putInt("ErneuteRW", 0);
    	prefEditor.apply();
    	
		for (int x=0; x<=5; x++)
   		{
   			strEinwaage = prefs.getString("Einwaage_"+x, "0");
   			resId1 = getResources().getIdentifier("TableRow"+x, "id", getPackageName());
   			tr = (TableRow) findViewById(resId1);
   			
   			strNeueRueckwaage = prefs.getString("Rueckwaage_"+x, "");
   			resId2 = getResources().getIdentifier("TVneueRW"+x, "id", getPackageName());
   			tv1 = (TextView) findViewById(resId2);
   			
   			strAlteRueckwaage = prefs.getString("AlteRueckwaage_"+x, "---");
   			resId3 = getResources().getIdentifier("TValteRW"+x, "id", getPackageName());
   			tv2 = (TextView) findViewById(resId3);
   			
   			resId4 = getResources().getIdentifier("CheckBox"+x, "id", getPackageName());
   			cb = (CheckBox) findViewById(resId4);
   			
   			resId5 = getResources().getIdentifier("TVdiffP"+x, "id", getPackageName());
   			tv3 = (TextView) findViewById(resId5);
	    	
   //		**************************************************			
   //		************ Berechnung der Differenz ************	 			
   //		**************************************************
   			
	   		double dblNeueRueckwaage;
	   		double dblAlteRueckwaage;
	   		double dblDifferenz;
	   		String strDifferenz = "---";
	   		
   			if(strAlteRueckwaage.equals("---") == false)
   			{		
   	   			dblNeueRueckwaage = Double.parseDouble(strNeueRueckwaage);
   	   			dblAlteRueckwaage = Double.parseDouble(strAlteRueckwaage);
   	   			
   	   			if (dblNeueRueckwaage >= dblAlteRueckwaage)
   	   			{
   	   				dblDifferenz = dblNeueRueckwaage - dblAlteRueckwaage;
   	   			}
   	   			else
   	   			{
   	   				dblDifferenz = dblAlteRueckwaage - dblNeueRueckwaage;
   	   			}
   	   			
   	   			strDifferenz = ActivityTools.fktDoubleToStringFormat(dblDifferenz, 2);
   			}
   			
   			
   //		************************************************** 	
   			
   			if (strEinwaage.equals("0") == false)
   			{   			
   				tr.setVisibility(View.VISIBLE);
   				tr.setFocusable(true);
   				tv1.setText(strNeueRueckwaage);
   				tv2.setText(strAlteRueckwaage);
   				tv3.setText(strDifferenz);
   				cb.setChecked(false);
   				
   			}
   			else
   			{   			
   				tr.setVisibility(View.INVISIBLE);
   				tr.setFocusable(false);
   			}
   		}

		
	} // onResume
	
	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		
		CheckBox cb;
		int resId;
		
		for (int x=0; x<=5; x++)
   		{	// jeder Hakene von jede CheckBox wird wieder entfernt
			resId = getResources().getIdentifier("CheckBox"+x, "id", getPackageName());
			cb = (CheckBox) findViewById(resId);
			cb.setChecked(false);
   		}

	} // onPause
	
	public void btnErneuteRW (View v) 
	{
		int ER = 0; 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		
		for (int x=0; x<=5; x++)
   		{
			ER = ER + prefs.getInt("ErneuteRW_"+x, 0);
   		}
		
		if (ER == 0) 
    	{
    		// **************************************       		
    		// *** Hier wird ein Toast ausgegeben ***
    		// **************************************        		
    		String text = "\n   Bitte mindestens eine   \n      Probe auswählen!   \n"; 
    		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
    		Meldung.setGravity(Gravity.TOP, 0, 0);
    		Meldung.show();
    	}
		else
		{
	    	prefEditor.putInt("AlleERW", 1);
	    	prefEditor.apply();
			
			Intent myIntent = new Intent(this, RueckwaagenActivity.class);
			myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);	
			startActivity(myIntent);
		}

	}
	
	public void btnBerechnung (View v) 
	{	
		int ER = 0; 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		for (int x=0; x<=5; x++)
   		{
			ER = ER + prefs.getInt("ErneuteRW_"+x, 0);
   		}
		
		if (ER == 0) 
    	{
			Intent myIntent = new Intent(this, BerechnungRueckwaageActivity.class);
			myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);	
			startActivity(myIntent);
    	}
		else
		{
    		// **************************************       		
    		// *** Hier wird ein Toast ausgegeben ***
    		// **************************************        		
    		String text = "\n    Bitte für die Berechnung die   \n   angewählten Proben abwählen!   \n"; 
    		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
    		Meldung.setGravity(Gravity.TOP, 0, 0);
    		Meldung.show();
		}
	}

	public void onCheckboxClicked(View view) {

	    boolean checked = ((CheckBox) view).isChecked();
	    
	    String strRueckwaage;
	    String strAlteRueckwaage;
	    String strFeldname, strFeldNr;
	    TextView tv;
	    int resId;
	    
	    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    SharedPreferences.Editor prefEditor = prefs.edit();
	    
	    // Check which checkbox was clicked
	    strFeldname = getResources().getResourceEntryName(view.getId());
	    strFeldNr = strFeldname.substring(strFeldname.length()-1);
	    
	    resId = getResources().getIdentifier("TValteRW"+strFeldNr, "id", getPackageName());
	    tv = (TextView) findViewById(resId);
	    strAlteRueckwaage = tv.getText().toString();
	    
	    resId = getResources().getIdentifier("TVneueRW"+strFeldNr, "id", getPackageName());
	    tv = (TextView) findViewById(resId);
	    strRueckwaage = tv.getText().toString();

        if (checked)
        {
        	prefEditor.putString("SpeicherARW_"+strFeldNr, strAlteRueckwaage);
        	// die alte RW wird hier zwischen gespeichert, damit die diese 
        	// nicht verloren geht, falls der Haken bei der Checkbox wieder entfernt wird.
        	prefEditor.putString("AlteRueckwaage_"+strFeldNr, strRueckwaage);
        	prefEditor.putString("Rueckwaage_"+strFeldNr, "");
        	prefEditor.putInt("ErneuteRW_"+strFeldNr, 1);
        	prefEditor.apply();
        }
        else
        {
        	prefEditor.putString("AlteRueckwaage_"+strFeldNr, strAlteRueckwaage);
        	prefEditor.putString("Rueckwaage_"+strFeldNr, strRueckwaage);
        	prefEditor.putInt("ErneuteRW_"+strFeldNr, 0);
        	prefEditor.apply();
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
            	intent.putExtra("Kapitel", "Berechnung");
            	startActivity(intent);
                return true;
                
            case R.id.menu_Impressum:
            	intent = new Intent(this, ImpressumActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
} // BerechnungFettkennzahlActivity
