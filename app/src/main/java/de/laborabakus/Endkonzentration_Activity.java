package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class Endkonzentration_Activity extends Activity {

    private static final String TAG = "";
    EditText et;
    TextView tv;
    String strAuswahl;
    String strAuswahl2;
    String strAuswahl3;
    
	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.verduennen);
        // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.requestFocus();
        showSoftKeyboard(findViewById(R.id.Reinheit_Konz));


    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate

    private void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    /** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume()
    {
        super.onResume();
/*
        String strAuswahl;
        TextView tv;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strAuswahl = prefs.getString("Reinheit_Konz_solid_liquid", "fest");

        if (strAuswahl.equals("fest"))
        {
            strAuswahl = getResources().getString(R.string.aktuell_fest);
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText(strAuswahl);
        }

        if (strAuswahl.equals("flüssig"))
        {
            strAuswahl = getResources().getString(R.string.aktuell_fluessig);
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText(strAuswahl);
        }
*/
    } // onResume

    @Override
    protected void onPause() {
        super.onPause();


    } // onPause

    /********************************************
     ************** Button fest / flüssig *******
     ********************************************/

    public void btnOnClickFestFluessig (View v)
    {
        // ********************************************
        // *** Wechsel der Anzeige "fest" "flüssig" ***
        // ********************************************

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        strAuswahl = tv.getText().toString();

        if (strAuswahl.equals("fest"))
        {
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText(R.string.aktuell_fluessig);

            tv = (TextView) findViewById(R.id.btnEinheitReinheit);
            strAuswahl2 = tv.getText().toString();

            if (strAuswahl2.equals("%"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.Prozent);
            }

            if (strAuswahl2.equals("mg/g"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.mg_ml);
            }

            tv = (TextView) findViewById(R.id.btn0);
            strAuswahl3 = tv.getText().toString();

            if (strAuswahl3.equals("mg"))
            {
                tv = (TextView) findViewById(R.id.btn0);
                tv.setText(R.string.ul);
            }

            if (strAuswahl3.equals("g"))
            {
                tv = (TextView) findViewById(R.id.btn0);
                tv.setText(R.string.ml);
            }
        }

        if (strAuswahl.equals("flüssig"))
        {
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText(R.string.aktuell_fest);

            tv = (TextView) findViewById(R.id.btnEinheitReinheit);
            strAuswahl2 = tv.getText().toString();

            if (strAuswahl2.equals("%"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.Prozent);
            }

            if (strAuswahl2.equals("mg/ml"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.mg_g);
            }

            tv = (TextView) findViewById(R.id.btn0);
            strAuswahl3 = tv.getText().toString();

            if (strAuswahl3.equals("µl"))
            {
                tv = (TextView) findViewById(R.id.btn0);
                tv.setText(R.string.mg);
            }

            if (strAuswahl3.equals("ml"))
            {
                tv = (TextView) findViewById(R.id.btn0);
                tv.setText(R.string.g);
            }
        }
    }

    /********************************************
     ************** Button % / mg/ml ************
     ********************************************/

    public void btnOnClickEinheitReinheit (View v)
    {
        // ********************************************
        // *** Wechsel der Anzeige "%" "mg/ml" ********
        // ********************************************

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        strAuswahl = tv.getText().toString();

        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
        strAuswahl2 = tv.getText().toString();

        if (strAuswahl2.equals("%"))
        {
            if (strAuswahl.equals("fest"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.mg_g);
            }
            if (strAuswahl.equals("flüssig"))
            {
                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                tv.setText(R.string.mg_ml);
            }
        }

        if (strAuswahl2.equals("mg/ml") || strAuswahl2.equals("mg/g"))
        {
            tv = (TextView) findViewById(R.id.btnEinheitReinheit);
            tv.setText(R.string.Prozent);
        }
    }

    /********************************************
     ************** Button EinheitEinmass *******
     ********************************************/

    public void btnOnClickEinheitEinmass (View v)
    {
        // *************************************************************
        // *** Wechsel der Anzeige "µg"/"µl" "mg"/"ml"  "g"/"l" ********
        // *************************************************************

        tv = (TextView) findViewById(R.id.btn0);
        strAuswahl3 = tv.getText().toString();

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        strAuswahl = tv.getText().toString();

        if (strAuswahl.equals("fest") && strAuswahl3.equals("mg"))
        {
            tv = (TextView) findViewById(R.id.btn0);
            tv.setText(R.string.g);
        }
        if (strAuswahl.equals("fest") && strAuswahl3.equals("g"))
        {
            tv = (TextView) findViewById(R.id.btn0);
            tv.setText(R.string.mg);
        }

        if (strAuswahl.equals("flüssig") && strAuswahl3.equals("µl"))
        {
            tv = (TextView) findViewById(R.id.btn0);
            tv.setText(R.string.ml);
        }
        if (strAuswahl.equals("flüssig") && strAuswahl3.equals("ml"))
        {
            tv = (TextView) findViewById(R.id.btn0);
            tv.setText(R.string.ul);
        }
    }

    /**********************************************
     ************** Button Einheit (alle ml) ******
     **********************************************/

    public void btnOnClickEinheit (View v)
    {
        int CurrentID = 0;
        String strFeldname = "";
        CurrentID = v.getId();

        tv = (TextView) findViewById(CurrentID);
        strAuswahl = tv.getText().toString();

        strFeldname = getResources().getResourceEntryName(v.getId());

        if (strAuswahl.equals("ml"))
        {
            if (strFeldname.equals("btn0"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.ul);
            }
            else
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.l);
            }
        }

        if (strAuswahl.equals("µl"))
        {
            tv = (TextView) findViewById(CurrentID);
            tv.setText(R.string.ml);
        }
        if (strAuswahl.equals("l"))
        {
            tv = (TextView) findViewById(CurrentID);
            tv.setText(R.string.ml);
        }
        if (strAuswahl.equals("mg"))
        {
            tv = (TextView) findViewById(CurrentID);
            tv.setText(R.string.g);
        }
        if (strAuswahl.equals("g"))
        {
            tv = (TextView) findViewById(CurrentID);
            tv.setText(R.string.mg);
        }
    }

    /********************************************
     ************** Button EinheitErgebnis ******
     ********************************************/

    public void btnOnClickEinheitErgebnis (View v)
    {
        // *************************************************************
        // *** Wechsel der Anzeige  ************************************
        // *************************************************************

        tv = (TextView) findViewById(R.id.btnEinheit);
        strAuswahl = tv.getText().toString();

        if (strAuswahl.equals("g/ml"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.Prozent);
        }
        if (strAuswahl.equals("%"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.g_l);
        }
        if (strAuswahl.equals("g/l"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.mg_ml);
        }
        if (strAuswahl.equals("mg/ml"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.mg_l);
        }
        if (strAuswahl.equals("mg/l"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.ug_ml);
        }
        if (strAuswahl.equals("µg/ml"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.ppm);
        }
        if (strAuswahl.equals("ppm"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.ug_l);
        }
        if (strAuswahl.equals("µg/l"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.ppb);
        }
        if (strAuswahl.equals("ppb"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.g_ml);
        }
    }

	/********************************************
	 ************** Menue Button ****************
	 ********************************************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu4, menu);
        return true;
    }   
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent intent = null;
        switch (item.getItemId()) 
        {
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
} // class RSD_Activity

