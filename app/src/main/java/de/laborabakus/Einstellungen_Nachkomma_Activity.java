package de.laborabakus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class Einstellungen_Nachkomma_Activity extends Activity {

    /*****************************************
     ********* Variablen Deklaration *********
     *****************************************/

    TextView tv;
    String strEingabe;
    int intEingabe;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.einstellungen_nachkomma);
  
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
     	
 				
    } // onCreate

    /** wird ausgeführt, wenn Activicty angezeigt wird */
    @Override
    public void onResume() {
    	super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        int intGehalt = prefs.getInt("NachkommastellenGehalt", 2);
        String strGehalt = Integer.toString((int) intGehalt);

        tv = (TextView) findViewById(R.id.Gehalt);
        tv.setText(strGehalt);

		int intRSD = prefs.getInt("NachkommastellenRSD", 2);
		String strRSD = Integer.toString((int) intRSD);

		tv = (TextView) findViewById(R.id.RSD);
		tv.setText(strRSD);

    } // onResume
    
	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		
       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();

		tv = (TextView) findViewById(R.id.Gehalt);
		String strGehalt = tv.getText().toString();
		int intGehalt = Integer.parseInt(strGehalt);
		prefEditor.putInt("NachkommastellenGehalt", intGehalt);
		prefEditor.apply();

		tv = (TextView) findViewById(R.id.RSD);
		String strRSD = tv.getText().toString();
		int intRSD = Integer.parseInt(strRSD);
		prefEditor.putInt("NachkommastellenRSD", intRSD);
		prefEditor.apply();

	} // onPause
    
	// ***********************************************************************************************
	// ***********************************************************************************************
	// ***********************************************************************************************
	
	
	public void btnGehaltMinus(View v)
    {
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