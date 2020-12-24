package de.laborabakus;

import android.app.Activity;
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


public class Endkonzentration_Activity extends Activity implements OnFocusChangeListener {

    private static final String TAG = "";
    EditText et;
    TextView tv;
    int intEndeVerdReihe = 0;
    int resId;
    int resId2;
    int resId3;
    int x;
    double dblEingabezahl;
    double dblReinheit;
    double dblppm;
    double dblgpml;
    double dblWert;
    String strEingabetext;
    String strEingabetext2;
    String strAuswahl;
    String strAuswahl2;
    String strAuswahl3;
    String strAusgabe;
    String [] arrString = new String [10];
    Double [] arrWert = new Double [12];
    String [] arrEinheit = new String [12];


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

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        for (x=9; x>=0; x--)
        {
            resId = getResources().getIdentifier("et"+x, "id", getPackageName());
            et = (EditText) findViewById(resId);
            strEingabetext = prefs.getString("et"+x, "");
            if (strEingabetext.equals(""))
            {
                et.requestFocus();
            }
            et.setText(strEingabetext);

            resId = getResources().getIdentifier("btn"+x, "id", getPackageName());
            tv = (TextView) findViewById(resId);
            if (x == 0)
            {
                strEingabetext = prefs.getString("btn"+x, "mg");
                tv.setText(strEingabetext);
            }
            else
            {
                strEingabetext = prefs.getString("btn"+x, "ml");
                tv.setText(strEingabetext);
            }
        }

        strEingabetext = prefs.getString("btnEinheit", "%");
        tv = (TextView) findViewById(R.id.btnEinheit);
        tv.setText(strEingabetext);

        strEingabetext = prefs.getString("Reinheit_Konz", "");
        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.setOnFocusChangeListener(this);
        if (strEingabetext.equals("") == true)
        {
            et.requestFocus();
        }
        et.setText(strEingabetext);

        strEingabetext = prefs.getString("btnEinheitReinheit", "%");
        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
        tv.setText(strEingabetext);

        strEingabetext = prefs.getString("btnFestFluessig", "fest");
        tv = (TextView) findViewById(R.id.btnFestFluessig);
        tv.setText(strEingabetext);

    } // onResume

    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        tv = (TextView) findViewById(R.id.btnEinheit);
        strEingabetext = tv.getText().toString();
        prefEditor.putString("btnEinheit", strEingabetext);

        et = (EditText) findViewById(R.id.Reinheit_Konz);
        strEingabetext = et.getText().toString();
        prefEditor.putString("Reinheit_Konz", strEingabetext);

        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
        strEingabetext = tv.getText().toString();
        prefEditor.putString("btnEinheitReinheit", strEingabetext);

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        strEingabetext = tv.getText().toString();
        prefEditor.putString("btnFestFluessig", strEingabetext);

        for (x=0; x<=9; x++)
        {
            resId = getResources().getIdentifier("et"+x, "id", getPackageName());
            et = (EditText) findViewById(resId);
            strEingabetext = et.getText().toString();
            prefEditor.putString("et"+x, strEingabetext);

            resId = getResources().getIdentifier("btn"+x, "id", getPackageName());
            tv = (TextView) findViewById(resId);
            strEingabetext = tv.getText().toString();
            prefEditor.putString("btn"+x, strEingabetext);
        }

        prefEditor.apply();

    } // onPause


    public void onFocusChange(View v, boolean hasFocus)
    {
        int CurrentID = v.getId();
        if(R.id.Reinheit_Konz == CurrentID)
        {
            if ((hasFocus == false))
            {
                et = (EditText) findViewById(R.id.Reinheit_Konz);

                strEingabetext = et.getText().toString();
                if (strEingabetext.equals("") == true)
                {
                    et.setText("100");

                    fktDerGehaltderSubstanzwurdeauf100gesetzt();

                    tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                    tv.setText("%");
                }
                else
                {
                    dblEingabezahl = Double.parseDouble(strEingabetext);

                    if (dblEingabezahl == 0)
                    {
                        fktEingabeNullNichtZulaessig();

                        fktDerGehaltderSubstanzwurdeauf100gesetzt();

                        et.setText("100");
                        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                        tv.setText("%");
                    }
                }
            }
        }
    }

    @SuppressWarnings("static-access")

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

        if (strFeldname.equals("btn0"))
        {
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

        if ((strFeldname.equals("btn1")) || (strFeldname.equals("btn3")) || (strFeldname.equals("btn5")) || (strFeldname.equals("btn7")) || (strFeldname.equals("btn9")))
        {
            if (strAuswahl.equals("l"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.ml);
            }
            if (strAuswahl.equals("ml"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.l);
            }
        }
        else
        {
            if (strAuswahl.equals("µl"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.ml);
            }
            if (strAuswahl.equals("ml"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.ul);
            }
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

    // Eingabefelder zur�cksetzen
    public void btnOnClickCE(View v) {
        EditText et;
        int resId;
        int x = 9;
        String strWert = "";

        while (strWert.equals("") == true && (x != -1))
        {
            resId = getResources().getIdentifier("et"+(x), "id", getPackageName());
            et = (EditText) findViewById(resId);
            strWert = et.getText().toString();
            if (strWert.equals("") == false)
            {
                et.setText("");
                et.requestFocus();
            }

            x = x -1;
        }

        if((strWert.equals("") == true) && (x==-1))
        {
            et = (EditText) findViewById(R.id.Reinheit_Konz);
            et.setText("");
            et.requestFocus();
        }
    } // btnCE

    // Eingabefelder zur�cksetzen
    public void btnOnClickAC(View v) {
        EditText et;
        int resId;

        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.setText("");

        for (int x=0; x<=9; x++)
        {
            resId = getResources().getIdentifier("et"+(x), "id", getPackageName());
            et = (EditText) findViewById(resId);
            et.setText("");
        }

        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.requestFocus();		// Cursor in erstes Eingabefeld setzen

    } // btnAC

    /********************************************
     ************** Button Berechne *************
     ********************************************/

    public void btnOnClickBerechneEndkonz (View v)
    {
        et = (EditText) findViewById(R.id.Reinheit_Konz);
        strEingabetext = et.getText().toString();
        dblReinheit = Double.parseDouble(strEingabetext);

        // *****************************************************************
        // ***** Hier wird von hinten das letzte Eingabefeld bestimmt. *****
        // *****************************************************************

        for (x = 9; x >= 0; x--)
        {
            resId = getResources().getIdentifier("et"+x, "id", getPackageName());
            et = (EditText) findViewById(resId);
            strEingabetext = et.getText().toString();
            if(strEingabetext.equals("") == false)
            {
                intEndeVerdReihe = x;
                break;
            }
        }

        // **********************************************************************
        // ***** Hier werden von vorne die Eingabefelder bis zum letzten    *****
        // ***** gefüllten Eingabefeld ausgelesen und gleichzeitig geprüft, *****
        // ***** ob alle Felder dazwischen gefüllt sind!!                   *****
        // **********************************************************************

        for (x=0; x<= intEndeVerdReihe; x++)
        {
            resId2 = getResources().getIdentifier("et" + x, "id", getPackageName());
            et = (EditText) findViewById(resId2);
            strEingabetext = et.getText().toString();
            if (strEingabetext.equals("") == false)
            {
                dblEingabezahl = Double.parseDouble(strEingabetext);
                if (dblEingabezahl == 0)
                {
                    fktEingabeNullNichtZulaessig();
                    break;
                }
                else
                {
                    arrWert[x] = Double.parseDouble(strEingabetext);

                    resId3 = getResources().getIdentifier("btn" + x, "id", getPackageName());
                    tv = (TextView) findViewById(resId3);
                    strEingabetext2 = tv.getText().toString();
                    arrEinheit[x] = strEingabetext2;

                    if (arrEinheit[x].equals("g"))
                    {
                        arrWert[x] = arrWert[x] * 1000;
                    }
                    if (arrEinheit[x].equals("µl"))
                    {
                        arrWert[x] = arrWert[x] / 1000;
                    }
                    if (arrEinheit[x].equals("l"))
                    {
                        arrWert[x] = arrWert[x] * 1000;
                    }
                }
            }
            else
            {
                fktEineBerechnungKannNichtDurchgeführtWerden();
                break;
            }

        }

        dblgpml = dblReinheit/100;

        for (x=0; x<= intEndeVerdReihe; x++ )
        {
            if ((x == 0)||(x == 2)||(x == 4)||(x == 6)||(x == 8))
            {
                dblWert = arrWert[x] / arrWert[x+1];
                dblgpml = dblgpml * dblWert;
            }
        }

        dblppm = dblgpml * 1000;

        strAusgabe = Double.toString(dblppm);

        // **************************************
        // *** Hier wird ein Toast ausgegeben ***
        // **************************************
        String text = strAusgabe + " ppm";
        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
    }

    private void fktDerGehaltderSubstanzwurdeauf100gesetzt()
    {
        // **************************************
        // *** Hier wird ein Toast ausgegeben ***
        // **************************************
        String text = "\n   Der Gehalt der Substanz   \n   wurde auf 100% gesetzt!   \n";
        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
    }

    private void fktEingabeNullNichtZulaessig()
    {
        // **************************************
        // *** Hier wird ein Toast ausgegeben ***
        // **************************************
        String text = "\n   Die Eingabe 0 ist   \n   nicht zulässig!   \n";
        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
    }

    private void fktEineBerechnungKannNichtDurchgeführtWerden()
    {
        // **************************************
        // *** Hier wird ein Toast ausgegeben ***
        // **************************************
        String text = "\n   Achtung! Eine Berechnung   \n   " +
                "kann nicht durchgeführt   \n   " +
                "werden, da in der   \n   " +
                "Verdünnungsreihe ein oder   \n   " +
                "mehrere Eingabefelder  \n   " +
                "nicht gefüllt sind!  \n   ";
        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
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

