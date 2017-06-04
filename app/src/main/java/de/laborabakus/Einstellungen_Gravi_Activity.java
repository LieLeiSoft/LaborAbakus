package de.laborabakus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class Einstellungen_Gravi_Activity extends Activity {
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.einstellungen_gravi);	     
  
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
     	
 				
    } // onCreate

    /** wird ausgeführt, wenn Activicty angezeigt wird */
    @Override
    public void onResume() {
    	super.onResume();
    	
    	String strAuswahl;
    	TextView tv;
    
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		strAuswahl = prefs.getString("Netto_Brutto", "Nettoeinwaage");
		
		if (strAuswahl.equals("Nettoeinwaage"))
		{
			strAuswahl = getResources().getString(R.string.aktuell_Netto);
			tv = (TextView) findViewById(R.id.TextView_Brutto_Netto);
		    tv.setText(strAuswahl); 
		}
		
		if (strAuswahl.equals("Bruttoeinwaage"))
		{
			strAuswahl = getResources().getString(R.string.aktuell_Brutto);
			tv = (TextView) findViewById(R.id.TextView_Brutto_Netto);
		    tv.setText(strAuswahl); 
		}
    	
    } // onResume
    
	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		

   		
	    	
	} // onPause
    
	// ***********************************************************************************************
	// ***********************************************************************************************
	// ***********************************************************************************************
	
	// Button Eingabe der Einwaage: Netto oder Brutto
	
	public void btn_Brutto_Netto (View v)
    {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 
		
		String strAuswahl = prefs.getString("Netto_Brutto", "Nettoeinwaage");
		TextView tv;
		
		if (strAuswahl.equals("Bruttoeinwaage"))
		{
			strAuswahl = getResources().getString(R.string.aktuell_Netto);
			tv = (TextView) findViewById(R.id.TextView_Brutto_Netto);
		    tv.setText(strAuswahl); 
		    
			prefEditor.putString("Netto_Brutto", "Nettoeinwaage");
			prefEditor.apply();
		}
		
		if (strAuswahl.equals("Nettoeinwaage"))
		{
			strAuswahl = getResources().getString(R.string.aktuell_Brutto);
			tv = (TextView) findViewById(R.id.TextView_Brutto_Netto);
		    tv.setText(strAuswahl); 
		    
			prefEditor.putString("Netto_Brutto", "Bruttoeinwaage");
			prefEditor.apply();
		}
    }
	
	// *****************
	
	public void btnGehaltMinus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.Gehalt);
		strEingabe = tv.getText().toString();
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe >=1)
     	{
     		intEingabe = intEingabe - 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
    
    public void btnGehaltPlus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.Gehalt);
 		strEingabe = tv.getText().toString(); 
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe <=4)
     	{
     		intEingabe = intEingabe + 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }	
    
	public void btnRSDMinus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.RSD);
		strEingabe = tv.getText().toString();
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe >=1)
     	{
     		intEingabe = intEingabe - 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
    
    public void btnRSDPlus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.RSD);
 		strEingabe = tv.getText().toString(); 
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe <=4)
     	{
     		intEingabe = intEingabe + 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
	
    

} // Public Class   