package de.laborabakus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EinwaageActivity extends Activity implements OnFocusChangeListener  {
	
	/** wird ausgeführt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.einwaage);       

	    EditText et;

    	// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);  

		// Eingabefelder mit Listener verbinden
    	for (int intFeldNr=0; intFeldNr<=5; intFeldNr++) 
    	{
    		int resId = getResources().getIdentifier("Tara_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setOnFocusChangeListener(this);
    	}
    	
		// Eingabefelder mit Listener verbinden
    	for (int intFeldNr=0; intFeldNr<=5; intFeldNr++) 
    	{
    		int resId = getResources().getIdentifier("Einwaage_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setOnFocusChangeListener(this);
    	}

        et = (EditText) findViewById(R.id.Tara_0);
        et.requestFocus();		// Cursor in erstes Eingabefeld setzen 

	} // onCreate

	/** wird ausgeführt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
    	EditText et;
    	TextView tv;
    	String strEinwaage;
    	String strAuswahl;
    	String strTara;
    	int resId;	
	    
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
   		strAuswahl = prefs.getString("Netto_Brutto", "Nettoeinwaage");
   		
   		tv = (TextView) findViewById(R.id.TextView_Einmassart);
   		
   		if (strAuswahl.equals("Nettoeinwaage") == true)
   		{
   			tv.setBackgroundColor(getResources().getColor(R.color.cHellgruen));
   		}
   		else
   		{
   			tv.setBackgroundColor(getResources().getColor(R.color.cHellblau));
   		}
   		
   		tv.setText(strAuswahl);
   		
   		// *************************************************************************************
   		
	    for (int x=0; x<=5; x++)
	    {
	   		strEinwaage = prefs.getString("Einwaage_"+x, "0");
	    	
	   		if (strEinwaage.equals("0") == false)
	   		{
	    		resId = getResources().getIdentifier("Einwaage_"+x, "id", getPackageName());
	           	et = (EditText) findViewById(resId);
	    		et.setText(strEinwaage);
	   		}
	   		
	   		strTara = prefs.getString("Tara_"+x, "0");
	    	
	   		if (strTara.equals("0") == false)
	   		{
	    		resId = getResources().getIdentifier("Tara_"+x, "id", getPackageName());
	           	et = (EditText) findViewById(resId);
	    		et.setText(strTara);
	   		}
	    } 
	} // onResume

	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
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
       	
	    for (int x=0; x<=5; x++)
	    {
    		resId = getResources().getIdentifier("Einwaage_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) {
           		Eingabetext = "0";
           	}  	           	
       		prefEditor.putString("Einwaage_"+x, Eingabetext);
       		
    		resId = getResources().getIdentifier("Tara_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) {
           		Eingabetext = "0";
           	}  	           	
       		prefEditor.putString("Tara_"+x, Eingabetext);
       		
       		
	    }
	    prefEditor.apply();	    		
	} // onPause
	
    // Implement the onFocusChange callback
	// Felder einblenden
    public void onFocusChange(View v, boolean hasFocus) {
    	EditText et;
		int CurrentID = v.getId();
		switch (CurrentID) {
		case R.id.Einwaage_0:
	    	et = (EditText) findViewById(R.id.Tara_1);
			et.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.Einwaage_1);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_1:			
	    	et = (EditText) findViewById(R.id.Tara_2);
			et.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.Einwaage_2);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_2:			
	    	et = (EditText) findViewById(R.id.Tara_3);
			et.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.Einwaage_3);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_3:			
	    	et = (EditText) findViewById(R.id.Tara_4);
			et.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.Einwaage_4);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_4:			
	    	et = (EditText) findViewById(R.id.Tara_5);
			et.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.Einwaage_5);
			et.setVisibility(View.VISIBLE);
			break;
		}		
    } // onFocusChange
    
	@SuppressWarnings("static-access")

	
	
	// ******************************************************************************************
	// ******************* Button Weiter ********************************************************
	// ******************************************************************************************
	
	public void btnWeiter(View v) {
    	EditText et;
    	String Eingabetext;
    	boolean Eingabe_OK;
    	int resID;
    	//int resID2;
    	
    	Eingabe_OK = true;
    	
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
	    et = (EditText) findViewById(R.id.Tara_0);
		et.requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);

       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in dem ersten Eingabefeld (Tara 1) ein Wert steht
    		
           	et = (EditText) findViewById(R.id.Tara_0);  
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) 
           	{
           		// **************************************       		
           		// *** Hier wird ein Toast ausgegeben ***
           		// **************************************        		
           		String text = "\n   Bitte Leergewicht eingeben!   \n"; 
           		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
           		Meldung.setGravity(Gravity.TOP, 0, 0);
           		Meldung.show();
           		et.requestFocus();
           		Eingabe_OK = false;
           	}
       	}
       	
       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird geprüft, ob in dem ersten Eingabefeld (Tara 1) ein Wert steht
       		for (int x=0; x<=5; x++)
       		{
       			resID = getResources().getIdentifier("Tara_"+x, "id", getPackageName());
       			et = (EditText) findViewById(resID);
        	    Eingabetext = et.getText().toString();
        	    
       			if (Eingabetext.equals("") == false) 
       	       	{
           			resID = getResources().getIdentifier("Einwaage_"+x, "id", getPackageName());
           			et = (EditText) findViewById(resID);  
            	    Eingabetext = et.getText().toString();
                   	if (Eingabetext.equals("") == true) 
                   	{
                   		// **************************************       		
                   		// *** Hier wird ein Toast ausgegeben ***
                   		// **************************************        		
                   		String text = "\n   Bitte Einwaage eingeben!   \n"; 
                   		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                   		Meldung.setGravity(Gravity.TOP, 0, 0);
                   		Meldung.show();
                   		et.requestFocus();
                   		Eingabe_OK = false;
                   	}
       	       	}
       		}
       	}
       	
       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in irgendeiner Eingabe eine "0" steht    		
    	    for (int intEW=0; intEW<=5; intEW++)
    	    {    	    	
    			// Id wird ermittelt
    			int resId = getResources().getIdentifier("Einwaage_"+intEW, "id", getPackageName());
    					
    			// Das Feld der Objektvariable wird über die Id gesucht
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
       	
    	if (Eingabe_OK == true) 
        {
    		Intent myIntent = new Intent(this, RueckwaagenActivity.class);
       		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
       		startActivity(myIntent);  
        }
    	
    } // btnWeiter
	
	
    // Eingabefelder zur�cksetzen
    public void btnClear(View v) {
    	EditText et;
    	int resId;
    	 
    	for (int x=0; x<=5; x++)
    	{  
	    	resId = getResources().getIdentifier("Tara_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setText("");
	    	
	    	resId = getResources().getIdentifier("Einwaage_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setText("");
    	}
    	
    	et = (EditText) findViewById(R.id.Tara_0);
	    et.requestFocus();		// Cursor in erstes Eingabefeld setzen 
	    
    	for (int x=1; x<=5; x++)
    	{  
	    	resId = getResources().getIdentifier("Tara_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setVisibility(View.INVISIBLE);
	    	
	    	resId = getResources().getIdentifier("Einwaage_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setVisibility(View.INVISIBLE);
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
            	intent.putExtra("Kapitel", "Einwaage");
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
} // class EinwaageActivity

