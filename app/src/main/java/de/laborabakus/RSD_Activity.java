package de.laborabakus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        EditText et = null;
        // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
        et = (EditText) findViewById(R.id.Eingabewert);
        et.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
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
        String strAusgabetext;


        // *********** Eingabewert wird ausgelesen *************
        et = (EditText) findViewById(R.id.Eingabewert);
        Eingabetext = et.getText().toString();

        // *********** Weiter nur bei Eingabe *************
        if (Eingabetext.equals("") == false)
        {
            // *********** Eingabewert wird in Zahl umgewandelt *************
            dblAktuellerWert = Double.parseDouble(Eingabetext);

            // *********** RSD wird berechnet *************
            x = x + dblAktuellerWert;
            n = n + 1;
            X = x / n;
            d = dblAktuellerWert - X;
            d = Math.pow(d, 2);   //d hoch 2
            Sd = Sd + d;
            s = Math.sqrt(Sd / (n - 1));
            RSD = (s * 100 / X);

            // *********** Ausgabe Anzahl Meßwerte *************
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(n, 0); // 0 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Mittelwert *************
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(X, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Standardabweichung *************
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(s, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvStandardabweichung);
            tv.setText(strAusgabetext);

            // *********** Ausgabe relative Standardabweichung % *************
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(RSD, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvRSD);
            tv.setText(strAusgabetext);

            // *********** Eingabefeld für nächste Eingabe leeren *************
            et = (EditText) findViewById(R.id.Eingabewert);
            et.setText("");
        }

    } // btnWeiter
    // Eingabefelder zurücksetzen
    public void btnClear(View v)
    {
    	EditText et;
        et = (EditText) findViewById(R.id.Eingabewert);
        et.setText("");
        TextView tv;
        tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
        tv.setText("");
        tv = (TextView) findViewById(R.id.tv_Mittelwert);
        tv.setText("");
        tv = (TextView) findViewById(R.id.tvStandardabweichung);
        tv.setText("");
        tv = (TextView) findViewById(R.id.tvRSD);
        tv.setText("");

        x = 0;
        n = 0;
        X = 0;
        d = 0;
        Sd = 0;
        s = 0;
        RSD = 0;



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
} // class RSD_Activity

