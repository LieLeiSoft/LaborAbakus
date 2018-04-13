package de.laborabakus;

import android.app.Activity;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class RueckwaagenActivity extends Activity {
	
	// ***************************************************************
	// **************       Funktion         *************************
	// ***************************************************************
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if ((keyCode == KeyEvent.KEYCODE_BACK)){
	}return false;}
	
	@SuppressWarnings("static-access")
	public boolean fktEingabeprüfung (boolean Eingabe_OK)
	{
    	EditText et;
    	String strWert;
    	String Eingabetext;
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); 
   		
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
	    et = (EditText) findViewById(R.id.Rueckwaage_0);
		et.requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);

       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in dem ersten Eingabefeld ein Wert steht
       		for (int x=0; x<=5; x++)
       		{
       			strWert = prefs.getString("Einwaage_"+x, "0");
       			
       			if (strWert.equals("0") == false)		// Wenn in der Einwaage ein Wert steht, dann ...
       			{
           			int resID = getResources().getIdentifier("Rueckwaage_"+x,"id", getPackageName());
           			et = (EditText) findViewById(resID);
            	    Eingabetext = et.getText().toString();
            	    
           			if (Eingabetext.equals("") == true) 
           	       	{
                       	// **************************************       		
                       	// *** Hier wird ein Toast ausgegeben ***
                       	// **************************************        		
                       	String text = "\n   Bitte Gewicht eingeben!   \n"; 
                       	Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                       	Meldung.setGravity(Gravity.TOP, 0, 0);
                       	Meldung.show();
                       	et.requestFocus();
                       	Eingabe_OK = false;
                       	break;
           	       	}
       			}
       		}
       	}
       	
       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in irgendeiner Eingabe eine "0" steht    		
    	    for (int x=0; x<=5; x++)
    	    {    	    	
    			// Id wird ermittelt
    			int resId = getResources().getIdentifier("Rueckwaage_"+x, "id", getPackageName());
    					
    			// Das Feld der Objektvariable wird �ber die Id gesucht
    	    	et = (EditText) findViewById(resId);  

    	    	if (et.VISIBLE == View.VISIBLE) 
    	    	{
    	    		Eingabetext = et.getText().toString();
        	    	if (Eingabetext.equals("0") == true) 
	    	    	{
	    	    		// **************************************       		
	    	    		// *** Hier wird ein Toast ausgegeben ***
	    	    		// **************************************        		
	    	    		String text = "\n   Bitte keine 0 eingeben!   \n"; 
	    	    		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
	    	    		Meldung.setGravity(Gravity.TOP, 0, 0);
	    	    		Meldung.show();
	    	    		et.requestFocus();
	    	       		Eingabe_OK = false;
	    	    		break;
	    	    	}
    	    	}
           	}
       	}
       	return Eingabe_OK;
	}
	
	// ***************************************************************
	// **************       Funktion Ende    *************************
	// ***************************************************************
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rueckwaage);

		// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	} // onCreate
	
	@Override
	public void onResume() {
		super.onResume();
		
		EditText et;
		int resId;
		String strEinwaage;
		int intErneuteRW;
		int intAlleERW;
		
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    	
    	intAlleERW = prefs.getInt("AlleERW", 0);
    	
		for (int x=5; x>=0; x--)		
   		{
   			strEinwaage = prefs.getString("Einwaage_"+x, "0");
   			//strRueckwaage = prefs.getString("Rueckwaage_"+x, "");
   			intErneuteRW = prefs.getInt("ErneuteRW_"+x, 0);
   			resId = getResources().getIdentifier("Rueckwaage_"+x, "id", getPackageName());
   			et = (EditText) findViewById(resId);
   			
   			if (intAlleERW == 0) 						// erneute R�ckwaage ? nein
   			{
   				if (strEinwaage.equals("0") == true) 	// Einwaage vorhanden? nein
   				{   			
   					et.setVisibility(View.INVISIBLE);
   					et.setFocusableInTouchMode(false);	
   				}
   				else  									// Einwaage vorhanden? ja
   				{
   					et.setVisibility(View.VISIBLE);
   					et.setFocusableInTouchMode(true);	
   					et.requestFocus();
   				}
   			}
   			else										// erneute R�ckwaage ? ja
   			{
   		   		if (intErneuteRW == 1) 					// erneute R�ckwaage Nr x ? ja
   	   	   	   	{
   	   	   			et.setVisibility(View.VISIBLE);
   	   	   			et.setFocusableInTouchMode(true);
   	   	   			et.setText(""); 					// damit die alte R�ckwaage verschwindet
   	   	   			et.requestFocus();
   	   	   	   	}
   		   		else									// erneute R�ckwaage Nr x ? nein
   		   		{
   	   	   			et.setVisibility(View.INVISIBLE);
   	   	   			et.setFocusableInTouchMode(false);
   		   		}
   			}
   		}
   			
   			
   			
   			
	/*
   			else
   			{   			

   	   			else   // erneute RW == 1 (ja)
   	   			{
   	   	   			et.setVisibility(View.VISIBLE);
   	   	   			et.setText(""); 		// damit die alte R�ckwaage verschwindet
   	   	   			//et.setFocusableInTouchMode(true);
   	   	   			et.requestFocus();

   	   				else
   	   				{
   	   					if (x > 0) // mind. 1 Eingabefeld muss aktiv sein (sonst wird alphanum. Tastatur eingeblendet)
   	   					{	
   	   						et.setVisibility(View.INVISIBLE);
   	   						et.setFocusableInTouchMode(false);
   	   					}
   	   				}*/
   	   		
	} // onResume
	
	/** wird ausgef�hrt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		
    	EditText et;
    	String Eingabetext;
    	int resId;
   	
	    // Inhalt der Eingabefelder "Einwaage_xx" wird in Konfigurationsdatei ("Preferences") gespeichert

       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
   		prefEditor.putInt("AlleERW", 0);
   		
	    for (int x=0; x<=5; x++)
	    {
    		resId = getResources().getIdentifier("Rueckwaage_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
    	    Eingabetext = et.getText().toString();
	           	
       		prefEditor.putString("Rueckwaage_"+x, Eingabetext);
       		prefEditor.putInt("ErneuteRW_"+x, 0);
	    }
	    prefEditor.apply();	 
	     		
	} // onPause
	
	public void btnWeiter (View v) {

    	boolean Eingabe_OK;
    	
    	Eingabe_OK = true;
    	
    	// ***************************************************************
    	// ***************************************************************
    	Eingabe_OK = fktEingabeprüfung(Eingabe_OK);
    	// ***************************************************************
    	// ***************************************************************
    	
       	if (Eingabe_OK == true) 
       	{     	             	
       		Intent myIntent = new Intent(this, ErneuteRwActivity.class);
       		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
       		startActivity(myIntent);
       	}
    } // btnRest
	
	
    // Eingabefelder zur�cksetzen
    public void btnClear(View v) {
    	EditText et;
    	int resId;
    	 
    	for (int x=5; x>=0; x--)
    	{  
	    	resId = getResources().getIdentifier("Rueckwaage_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	if (et.getVisibility() == View.VISIBLE)
	    	{
	    		et.setText("");
	    	}

	        et.requestFocus();		// Cursor in erstes Eingabefeld setzen 
    	}
	
} // btnClear

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
