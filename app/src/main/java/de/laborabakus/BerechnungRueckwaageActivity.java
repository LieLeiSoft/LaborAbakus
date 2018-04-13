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
import android.widget.TableRow;
import android.widget.TextView;


public class BerechnungRueckwaageActivity extends Activity {
	
	/*****************************************
	 ********* Variablen Deklaration *********
	 *****************************************/
	
	double[] arrEinwaage 		= new double[20+1];
	double[] arrTara 			= new double[20+1];
	double[] arrRueckwaageAlt 	= new double[20+1];
	double[] arrRueckwaageNeu 	= new double[20+1];
	double[] arrRest 			= new double[20+1];
	double[] arrVerlust			= new double[20+1];
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.berechnung);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	} // onCreate
	
	@Override
	public void onResume() {
		super.onResume();
		
		String strWert;
		String strAuswahl;
		String strVerlust;
		String strRest;
		TextView tv;
		TableRow tr;
		int intAnzahl = 0;
		int resId;
		double dblRest = 0;
		double dblVerlust = 0;
		double dblSpeicher;
		double dblRSD = 0;

		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

   		//***********************************************************************
   		//********* Auslesen der Ein- Rück- und Tarawaagen **********************
   		//***********************************************************************
   		
   		for (int x=0; x<=5; x++)
   		{
   			strWert = prefs.getString("Einwaage_"+x, "0");
   			arrEinwaage[x]  = Double.parseDouble(strWert);
   			
   			strWert = prefs.getString("Tara_"+x, "0");
   			arrTara[x]  = Double.parseDouble(strWert);
   			
   			strWert = prefs.getString("Rueckwaage_"+x, "0");
   			
   			arrRueckwaageNeu[x] = ActivityTools.fktBlankToNumber(strWert);
   			
   			//arrRueckwaageNeu[x]  = Double.parseDouble(strWert);
   		}
   		
		
   		//***********************************************************************
   		//********* Auslesen der Nachkommastellen *******************************
   		//***********************************************************************
		
		int AnzahlStellen = prefs.getInt("NachkommastellenGehalt", 2);
		
   		//***********************************************************************
   		//********* Anzeige der Ausgabefelder ***********************************
   		//***********************************************************************
			
   		strAuswahl = prefs.getString("Netto_Brutto", "Nettoeinwaage");
		
		for (int x=0; x<=19; x++)
		{	
			// Leere Felder werden ausgeblendet
			
			if (arrEinwaage [x] == 0)
			{										
				resId = getResources().getIdentifier("TR_P"+x, "id", getPackageName());
				tr = (TableRow) findViewById(resId);
				tr.setVisibility(View.GONE);
			}
			else
			{
				if (strAuswahl.equals("Bruttoeinwaage") == true)
				{
					arrEinwaage [x] = arrEinwaage [x] - arrTara[x];
				}
				
				intAnzahl = intAnzahl + 1;
				
				// *************************************************
				// ****** Berechnung Rest **************************
				// *************************************************
				
			    arrRest[x] = ((arrRueckwaageNeu[x] - arrTara[x]) * 100) / arrEinwaage[x];
			    
			    strRest = ActivityTools.fktDoubleToStringFormat(arrRest[x], AnzahlStellen);
			    
				resId = getResources().getIdentifier("tvRest"+x, "id", getPackageName());
				tv = (TextView) findViewById(resId);
			    tv.setText(strRest);
			    
				// *************************************************
				// ****** Berechnung Verlust ***********************
				// *************************************************
			    
			    arrVerlust[x] = 100 - arrRest[x];
			    
			    strVerlust = ActivityTools.fktDoubleToStringFormat(arrVerlust[x], AnzahlStellen);
			    
				resId = getResources().getIdentifier("tvVerlust"+x, "id", getPackageName());
				tv = (TextView) findViewById(resId);
			    tv.setText(strVerlust);
			}
				
				// *************************************************
				// ****** Berechnung Durchschnitt *************
				// *************************************************
			
				if (Double.isInfinite(arrRest[x])) 
				{
					arrRest[x] = 0;
				}
				
				// Summe Rest
				dblRest = dblRest + arrRest [x];
				
	    } 
		
		dblRest = dblRest / intAnzahl; 	// Durchschnitt Rest
		
		dblVerlust = 100 - dblRest;		// Durchschnitt Verlust
		
		dblSpeicher = dblRest;
		
		// Anzeige Durchschnitt
		if (intAnzahl > 1)
		{
			tv = (TextView) findViewById(R.id.tvRestD);
			strRest = ActivityTools.fktDoubleToStringFormat(dblRest, AnzahlStellen);
			tv.setText(strRest);
			tv = (TextView) findViewById(R.id.tvVerlustD);
			strVerlust = ActivityTools.fktDoubleToStringFormat(dblVerlust, AnzahlStellen);
			tv.setText(strVerlust);
		}
		else
		{
			tr = (TableRow) findViewById(R.id.TR_P_Durchschnitt);
			tr.setVisibility(View.GONE);
		}

	
		// Berechnung der Relativen Standardabweichung

		AnzahlStellen = prefs.getInt("NachkommastellenRSD", 2);
		
		for (int x=0; x<=5; x++)
		{
			if (arrRest[x] != 0)
			{
				dblRSD = dblRSD + (Math.pow((arrRest[x] - dblSpeicher),2));
			}
		}
		
		if (intAnzahl >= 2)
		{
			dblRSD = ((Math.sqrt(dblRSD / (intAnzahl-1))) * 100) / dblSpeicher;
		
			// Anzeige RSD		
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("RSD = " +  ActivityTools.fktDoubleToStringFormat(dblRSD, AnzahlStellen) + "%");
		}
		else 
		{
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("");
		}
		
	} // onResume

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
} // BerechnungTiterActivity

