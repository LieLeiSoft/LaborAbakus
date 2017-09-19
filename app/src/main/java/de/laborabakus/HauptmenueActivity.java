package de.laborabakus;


import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class HauptmenueActivity extends Activity {
    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if ((keyCode == KeyEvent.KEYCODE_BACK)){
	}return false;}
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.hauptmenue);	  
     	
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
    }
    
    /** wird ausgeführt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
		// bestimmte Einträge aus Konfigurationsdatei ("Preferences") entfernen
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
   		
   		String strTextSize = prefs.getString("TG_Hauptmenue", "16");
   		String strButtonhoehe = prefs.getString("BH_Hauptmenue", "400");

   		TextView tv;
   		
   		int intTextSize = Integer.parseInt(strTextSize);
   		int intButtonhoehe = Integer.parseInt(strButtonhoehe);
   		
		for (int x=1; x<=7; x++)															 
		{
	    	int resId = getResources().getIdentifier("button"+x, "id", getPackageName());
	        tv = (TextView) findViewById(resId);
	        
	        // Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-( 
	        LayoutParams params = (LayoutParams) tv.getLayoutParams();
	        params.height = intButtonhoehe;
	        tv.setLayoutParams(params);	        
	        
	        tv.setTextSize(intTextSize);
		}

   		// prefs.edit().clear().commit(); // setzt ALLE Werte zurück!
   		
   		String strKeyName;
   		
   		// alle Parameter in eine String-Liste schreiben
   		Map<String,?> keys = prefs.getAll();

   		// String-Liste Eintrag für Eintrag durchgehen
   		for(Map.Entry<String,?> entry : keys.entrySet()){
   			strKeyName = entry.getKey();
   			// prüfen, ob Parameter "NachkommastellenGehalt" oder "NachkommastellenRSD" ist
   			// (diese Parameter sollen NICHT entfernt werden)
   			if ("Netto_Brutto,NachkommastellenGehalt,NachkommastellenRSD,Einstellungen,TG_Hauptmenue,BH_Hauptmenue,TG_Molmasse,BH_Molmasse".indexOf(strKeyName) == -1) {   				
   				// Parameter entfernen 
   				prefEditor.remove(strKeyName);
   			}
   		 }   		
	    prefEditor.apply();	    		
		
	} // onResume
	
    public void btnOnClickGravi(View v)
    {
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    } 
    
    public void btnOnClickStatis(View v)
    {
        Intent myIntent = new Intent(v.getContext(), RSD_Activity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }   

    public void btnOnClickMolmasse(View v)
    {
        Intent myIntent = new Intent(v.getContext(), MolmassenActivity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu2, menu);
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
           		prefEditor.putString("Einstellungen", "1");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Menue");
            	startActivity(intent);
                return true;
                
            case R.id.menu_Impressum:            	
            	intent = new Intent(this, ImpressumActivity.class);
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
