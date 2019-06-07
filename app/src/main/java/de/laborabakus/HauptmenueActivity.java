package de.laborabakus;


import java.util.Map;

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
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class HauptmenueActivity extends Activity {
    int intKEYCODE_BACK_Counter;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK){
			intKEYCODE_BACK_Counter++;
			switch (intKEYCODE_BACK_Counter) {
				case 1: {
							String text = "\n   Zum Beenden erneut drücken.   \n";
							Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
							Meldung.setGravity(Gravity.BOTTOM, 0, 0);
							Meldung.show();

							break;
 						}
				case 2: {
							ActivityRegistry.finishAll();
							finish();
							System.exit(0);
						}
			} // switch
		}
		return true;
	} // onKeyDown
	
	
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

		intKEYCODE_BACK_Counter = 0;

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
   			if (("QuizHilfe,LevelCounter_1,LevelCounter_2,LevelCounter_3,LevelCounter_4,LevelCounter_5,LevelCounter_6,LevelCounter_2,Netto_Brutto,NachkommastellenGehalt,NachkommastellenRSD,Einstellungen," +
				"TG_Hauptmenue,BH_Hauptmenue,TG_Molmasse,BH_Molmasse,strCounter,VerdGehaltEinheit,Auswahl," +
				"KonzAuswahl_0,KonzAuswahl_1,KonzAuswahl_2,KonzAuswahl_3,KonzAuswahl_4,KonzAuswahl_5,KonzAuswahl_6,KonzAuswahl_7,KonzAuswahl_8,KonzAuswahl_9,KonzAuswahl_10,KonzAuswahl_11," +
				"KonzGehalt_0,KonzGehalt_1,KonzGehalt_2,KonzGehalt_3,KonzGehalt_4,KonzGehalt_5,KonzGehalt_6,KonzGehalt_7,KonzGehalt_8,KonzGehalt_9,KonzGehalt_10,KonzGehalt_11," +
				"KonzGehaltEinheit_0,KonzGehaltEinheit_1,KonzGehaltEinheit_2,KonzGehaltEinheit_3,KonzGehaltEinheit_4,KonzGehaltEinheit_5,KonzGehaltEinheit_6,KonzGehaltEinheit_7,KonzGehaltEinheit_8," +
				"KonzGehaltEinheit_9,KonzGehaltEinheit_10,KonzGehaltEinheit_11," +
				"Dichte_0,Dichte_1,Dichte_2,Dichte_3,Dichte_4,Dichte_5,Dichte_6,Dichte_7,Dichte_8,Dichte_9,Dichte_10,Dichte_11," +
				"Molmasse_0,Molmasse_1,Molmasse_2,Molmasse_3,Molmasse_4,Molmasse_5,Molmasse_6,Molmasse_7,Molmasse_8,Molmasse_9,Molmasse_10,Molmasse_11,Level,Highscore,Highscore1,Highscore2,Highscore3," +
				"Highscore4,Highscore5,Highscore6,Highscore7,Highscore8,Highscore9").indexOf(strKeyName) == -1) {
   				// Parameter entfernen
   				prefEditor.remove(strKeyName);
   			}
   		 }
	    prefEditor.apply();

	} // onResume


	public void btnOnClickReview(View v)
	{
		Intent myIntent = new Intent(v.getContext(), Review_Activity.class);

		// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
		startActivity(myIntent);
	}


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


	public void btnOnClickKonzLsg(View v)
	{
		Intent myIntent = new Intent(v.getContext(), Konz_lsg_Auswahl_Activity.class);

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


	public void btnOnClickQuiz(View v)
	{
		Intent myIntent = new Intent(v.getContext(), QuizMenueActivity.class);

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
            	intent = new Intent(this, Org_Generator_Activity.class);
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
