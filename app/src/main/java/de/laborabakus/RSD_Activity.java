package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class RSD_Activity extends Activity /*implements OnFocusChangeListener */ {

    int n;      // Anzahl der Messwerte
    double x;   // Ergebnisse
    double X;   // arithmetischer Mittelwert
    double d;   // absolute Abweichung der Einzelwerte vom Mittelwert
    double Sd;  // Summe der absolute Abweichung der Einzelwerte vom Mittelwert
    double s;   // Standardabweichung
    double RSD; // relative Standardabweichung in Prozent
    double dblAktuellerWert;



	/** wird ausgeführt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.eingabe_rsd);

    	// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	} // onCreate

	/** wird ausgeführt, wenn Activicty angezeigt wird */

		@Override
		public void onResume() {
		super.onResume();




	} // onResume


	// ******************************************************************************************
	// ******************* Button Weiter ********************************************************
	// ******************************************************************************************

	public void btnWeiter(View v) {

        EditText et;
        TextView tv;
        String Eingabetext;


        // *********** Eingabewert wird ausgelesen *************

        et = (EditText) findViewById(R.id.Eingabewert);
        Eingabetext = et.getText().toString();

        // *********** Eingabewert wird in Zahl umgewandelt *************

        dblAktuellerWert = Double.parseDouble(Eingabetext);

        // *********** RSD wird berechnet *************

        x = x + dblAktuellerWert;
        n = n + 1;
        X = x/n;
        d = dblAktuellerWert - X;
        d = Math.pow(d, 2);   //d hoch 2
        Sd = Sd + d;
        s = Math.sqrt (Sd/(n-1));
        RSD =(s*100/X);

        // *********** Ausgabe Anzahl Meßwerte *************

        tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
        tv.setText(Double.toString(n));

        // *********** Ausgabe Mittelwert *************

        tv = (TextView) findViewById(R.id.tv_Mittelwert);
        tv.setText(Double.toString(X));

        // *********** Ausgabe Standardabweichung *************

        tv = (TextView) findViewById(R.id.tvStandardabweichung);
        tv.setText(Double.toString(s));

        // *********** Ausgabe relative Standardabweichung % *************

        tv = (TextView) findViewById(R.id.tvStandardabweichung);
        tv.setText(Double.toString(RSD));

    } // btnWeiter

    // Eingabefelder zurücksetzen
    public void btnClear(View v)
    {
    	EditText et;

        et = (EditText) findViewById(R.id.Eingabewert);
        et.setText("");
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
} // class RSD_Activity

