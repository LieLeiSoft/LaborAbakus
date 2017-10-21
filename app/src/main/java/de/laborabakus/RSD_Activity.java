package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RSD_Activity extends Activity /*implements OnFocusChangeListener */ {

    int n = 0;      // Anzahl der Messwerte
    double[] arr_x = new double[99];
    double X;   // arithmetischer Mittelwert
    double d;   // absolute Abweichung der Einzelwerte vom Mittelwert
    double s;   // Standardabweichung
    double RSD; // relative Standardabweichung in Prozent
    boolean mainisopen = true;

    EditText et;
    TextView tv;
    String Eingabetext;
    String strAusgabetext;
    double Speicher;


	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.eingabe_rsd);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

        EditText et = null;
        // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
        et = (EditText) findViewById(R.id.Eingabewert);
        et.requestFocus();
        showSoftKeyboard(findViewById(R.id.Eingabewert));
	} // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume() {
        super.onResume();
    } // onResume

    @Override
    protected void onPause() {
        super.onPause();
    } // onPause


    // ******************************************************************************************
	// ******************* Button Weiter ********************************************************
	// ******************************************************************************************

	public void btnWeiter(View v) {

        // *********** Eingabewert wird ausgelesen *************
        et = (EditText) findViewById(R.id.Eingabewert);
        Eingabetext = et.getText().toString();

        // *********** Weiter nur bei Eingabe *************
        if (Eingabetext.equals("") == false)
        {
            // *********** alte Werte werden gel�scht und neu berechnet *************

            arr_x[0] = 0;
            X = 0;
            d = 0;

            // *********** RSD wird berechnet *************
            n = n + 1;
            arr_x[n] = Double.parseDouble(Eingabetext); //Eingabewert wird in Zahl umgewandelt

            for (int t=1; t<=n; t++)
            {
                arr_x[0] = arr_x[0] + arr_x[t];
            }

            X = arr_x[0] / n;

            for (int t=1; t<=n; t++)
            {
                d = d + Math.pow((arr_x[t] - X), 2);   //d hoch 2
            }

            s = Math.sqrt(d / (n - 1));
            RSD = (s * 100 / X);

            // strErgebnis = Double.toString(dblErgebnis);

            // *********** Ausgabe Anzahl Me�werte *************
            strAusgabetext = Integer.toString(n);; // 0 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Mittelwert *************
            Speicher = X; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Standardabweichung *************
            Speicher = s; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvStandardabweichung);
            tv.setText(strAusgabetext);

            // *********** Ausgabe relative Standardabweichung % *************
            Speicher = RSD; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvRSD);
            tv.setText(strAusgabetext);

            // *********** Eingabefeld f�r n�chste Eingabe leeren *************
            et = (EditText) findViewById(R.id.Eingabewert);
            et.setText("");
        }

    } // btnWeiter

    // ******************************************************************************************
    // ******************* Button Liste *********************************************************
    // ******************************************************************************************

    public void btnListe(View v)
    {
        List<String> WerteList = new ArrayList<String>();
        List<Double> List_Eingabe_RDS = new ArrayList<Double>();

        double dblMittelwert = 0;
        double dblEingabewert = 0;
        double dblAbsolAbweich = 0;
        String strListText;


        try {
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            strListText = tv.getText().toString();
            strListText = strListText.replace(",", ".");

            dblMittelwert = Double.parseDouble(strListText);

            hideSoftKeyboard();

            setContentView(R.layout.gridview_rsd);
            mainisopen = false;

            for (int t=1; t<=n; t++)
            {
                dblEingabewert  = arr_x[t];
                dblAbsolAbweich = dblEingabewert - dblMittelwert;

                List_Eingabe_RDS.add(dblEingabewert);
                List_Eingabe_RDS.add(dblAbsolAbweich);
            }

            GridView gridView = (GridView)findViewById(R.id.gridview);
            RDSAdapter rdsAdapter = new RDSAdapter(this, List_Eingabe_RDS);
            gridView.setAdapter(rdsAdapter);

        } // try ...
        catch (Exception e)
        {
            Log.i("RSD_Activity", "btnListe: " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    } // btnListe

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && mainisopen == false) {
            mainisopen = true;
            setContentView(R.layout.eingabe_rsd);

            // *********** Ausgabe Anzahl Me�werte *************
            strAusgabetext = Integer.toString(n);; // 0 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Mittelwert *************
            Speicher = X; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Standardabweichung *************
            Speicher = s; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvStandardabweichung);
            tv.setText(strAusgabetext);

            // *********** Ausgabe relative Standardabweichung % *************
            Speicher = RSD; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvRSD);
            tv.setText(strAusgabetext);

            // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
            et = (EditText) findViewById(R.id.Eingabewert);
            et.requestFocus();
            showSoftKeyboard(findViewById(R.id.Eingabewert));

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // ******************************************************************************************
    // ******************* Button Clear_last ****************************************************
    // ******************************************************************************************

    public void btnClear_last(View v)

    {
        // *********** alte Werte werden gel�scht und neu berechnet *************

        arr_x[0] = 0;
        X = 0;
        d = 0;

        // *********** RSD wird berechnet *************
        if (n >= 1)
        {
            n = n - 1;

            for (int t=1; t<=n; t++)
            {
                arr_x[0] = arr_x[0] + arr_x[t];
            }

            X = arr_x[0] / n;

            for (int t=1; t<=n; t++)
            {
                d = d + Math.pow((arr_x[t] - X), 2);   //d hoch 2
            }

            s = Math.sqrt(d / (n - 1));
            RSD = (s * 100 / X);

            // *********** Ausgabe Anzahl Me�werte *************
            strAusgabetext = Integer.toString(n);; // 0 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Mittelwert *************
            Speicher = X; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Standardabweichung *************
            Speicher = s; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvStandardabweichung);
            tv.setText(strAusgabetext);

            // *********** Ausgabe relative Standardabweichung % *************
            Speicher = RSD; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvRSD);
            tv.setText(strAusgabetext);

            // *********** Eingabefeld f�r n�chste Eingabe leeren *************
            et = (EditText) findViewById(R.id.Eingabewert);
            et.setText("");
        }

    } // btnClear_last


    // ******************************************************************************************
    // ******************* Button Clear_alle ****************************************************
    // ******************************************************************************************

    public void btnClear_alle(View v)
    {
        et = (EditText) findViewById(R.id.Eingabewert);
        et.setText("");

        for (int t=0; t<=n; t++)
        {
            arr_x[t] = 0;
        }

        n = 0;
        X = 0;
        d = 0;
        s = 0;
        RSD = 0;

        // *********** Ausgabe Anzahl Me�werte *************
        tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
        tv.setText("");

        // *********** Ausgabe Mittelwert *************
        tv = (TextView) findViewById(R.id.tv_Mittelwert);
        tv.setText("");

        // *********** Ausgabe Standardabweichung *************
        tv = (TextView) findViewById(R.id.tvStandardabweichung);
        tv.setText("");

        // *********** Ausgabe relative Standardabweichung % *************
        tv = (TextView) findViewById(R.id.tvRSD);
        tv.setText("");
    } // btnClear_alle
	
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
            	intent.putExtra("Kapitel", "RSD");
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
	} // onOptionsItemSelected

    /**
     * Hides the soft keyboard
     */
    private void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    private void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }
} // class RSD_Activity

