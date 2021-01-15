package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class Ausgangskonzentration_Activity extends Activity  {

    private static final String TAG = "";
    EditText et;
    TextView tv;
    int intEndeVerdReihe = 0;
    int resId;
    int resId2;
    int resId3;
    int x;
    boolean EingabefelderLeer;
    boolean AlleEinheitenZuruckGesetzt;
    double dblEingabezahl;
    double dblGehalt;
    double dblPPM;
    double dblZwischenergebnis;
    double dblWert;
    String strEingabetext;
    String strEingabetext2;
    String strAuswahl;
    String strAuswahl3;

	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.verduennen);
        // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
        et = (EditText) findViewById(R.id.End_Konz);
        et.requestFocus();
        showSoftKeyboard(findViewById(R.id.End_Konz));


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

        tv = (TextView) findViewById(R.id.TextView00);
        tv.setText(R.string.Berechnung_der_Anfangskonzentration);

        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        tv.setText("mg/l (ppm)");

        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
        tv.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        tv.setVisibility(View.GONE);

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

        strEingabetext = prefs.getString("End_Konz", "");
        et = (EditText) findViewById(R.id.End_Konz);
        et.setText(strEingabetext);

        strEingabetext = prefs.getString("btnEinheitEndKonz", "mg/l (ppm)");
        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        tv.setText(strEingabetext);

        fktCheckAlleEinheitenZuruckgesetzt();

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

        et = (EditText) findViewById(R.id.End_Konz);
        strEingabetext = et.getText().toString();
        prefEditor.putString("End_Konz", strEingabetext);

        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        strEingabetext = tv.getText().toString();
        prefEditor.putString("btnEinheitEndKonz", strEingabetext);

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

    /**************************************************
     ************** Button % / mg/ml / ppm ************
     **************************************************/

    public void btnOnClickEinheitEndKonz (View v)
    {
        // ******************************************************
        // *** Wechsel der Anzeige "%" "mg/ml" und "ppm" ********
        // ******************************************************

        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        strAuswahl = tv.getText().toString();

        if (strAuswahl.equals("mg/l (ppm)"))
        {
            tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
            tv.setText("µg/l (ppb)");
        }

        if (strAuswahl.equals("µg/l (ppb)"))
        {
            tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
            tv.setText("mg/l (ppm)");
        }

        fktCheckAlleEinheitenZuruckgesetzt();
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
                tv.setText(R.string.ml);
            }
            if (strAuswahl.equals("ml"))
            {
                tv = (TextView) findViewById(CurrentID);
                tv.setText(R.string.ul);
            }
            if (strAuswahl.equals("µl"))
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
        if ((strFeldname.equals("btn2")) || (strFeldname.equals("btn4")) || (strFeldname.equals("btn6")) || (strFeldname.equals("btn8")))
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

        fktCheckAlleEinheitenZuruckgesetzt();
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

        if (strAuswahl.equals("ppm"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.Prozent);
        }
        if (strAuswahl.equals("%"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText(R.string.ppm);
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
            et = (EditText) findViewById(R.id.End_Konz);
            et.setText("");
            et.requestFocus();
        }

        fktCheckAlleEinheitenZuruckgesetzt();
    } // btnCE

    // Eingabefelder zur�cksetzen
    public void btnOnClickAC(View v) {
        EditText et;
        int resId;

        fktCheckAlleEingabefelderLeer();

        if (EingabefelderLeer == false)  // Wenn alle Eingabefelder leer sind
        {
            et = (EditText) findViewById(R.id.End_Konz);
            et.setText("");

            for (int x=0; x<=9; x++)
            {
                resId = getResources().getIdentifier("et"+(x), "id", getPackageName());
                et = (EditText) findViewById(resId);
                et.setText("");
            }

            et = (EditText) findViewById(R.id.End_Konz);
            et.requestFocus();		// Cursor in erstes Eingabefeld setzen

            EingabefelderLeer = true;

            fktCheckAlleEinheitenZuruckgesetzt();
        }
        else
        {
            tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
            tv.setText("mg/l (ppm)");

            tv = (TextView) findViewById(R.id.btn0);
            tv.setText(R.string.g);

            for (int x=1; x<=9; x++)
            {
                resId = getResources().getIdentifier("btn"+x, "id", getPackageName());
                TextView tv = (TextView) findViewById(resId);
                tv.setText(R.string.ml);
            }

            tv = (TextView) findViewById(R.id.btnAC);
            tv.setText(R.string.AC);
        }
    } // btnAC

    /********************************************
     ************** Button Berechne *************
     ********************************************/

    public void btnOnClickBerechneEndkonz (View v)
    {
        Double [] arrWert = new Double [12];
        String [] arrEinheit = new String [12];
        strAuswahl3 = "";
        String strAusgabe = "";
        String strAusgabe3 = "";

        //fktCheckAlleEingabefelderLeer();

        // *************************************************************************
        // ***** Hier wird der Gehalt der Substanz und die Einheit ausgelesen. *****
        // *************************************************************************
        et = (EditText) findViewById(R.id.End_Konz);
        strEingabetext = et.getText().toString();

        if (strEingabetext.equals("") == false)
        {
            dblGehalt = Double.parseDouble(strEingabetext);
            if (dblGehalt == 0)
            {
                fktEingabeNullNichtZulaessig();
            }
            else
            {
                // *******************************************************************
                // ***** Hier wird Berechnung bei mg/g, mg/l und ppm korrigiert. *****
                // *******************************************************************

                tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
                strEingabetext2 = tv.getText().toString();
                if (strEingabetext2.equals("mg/l (ppm)"))
                {
                    dblGehalt = dblGehalt / 100;
                }
                if (strEingabetext2.equals("µg/l (ppb)"))
                {
                    dblGehalt = dblGehalt / 100000;
                }

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
                    // *****************************************************************
                    // ***** Hier wird geprüft, ob eine "0" eingegeben wurde! **********
                    // *****************************************************************
                    resId2 = getResources().getIdentifier("et" + x, "id", getPackageName());
                    et = (EditText) findViewById(resId2);
                    strEingabetext = et.getText().toString();
                    if (strEingabetext.equals("") == false)
                    {
                        dblEingabezahl = Double.parseDouble(strEingabetext);
                        if (dblEingabezahl == 0)
                        {
                            fktEingabeNullNichtZulaessig();
                            EingabefelderLeer = true;
                            break;
                        }
                        else
                        {
                            // ***************************************************************************************
                            // ***** Hier werden die vollen Eingabezellen ausgelesen und in einen Array gepackt! *****
                            // ***************************************************************************************
                            arrWert[x] = Double.parseDouble(strEingabetext);

                            resId3 = getResources().getIdentifier("btn" + x, "id", getPackageName());
                            tv = (TextView) findViewById(resId3);
                            strEingabetext2 = tv.getText().toString();
                            arrEinheit[x] = strEingabetext2;

                            // *****************************************************************
                            // ***** Hier werden die Einheiten umgerechnet! ********************
                            // *****************************************************************

                            if (arrEinheit[x].equals("g"))      // Gramm auf Milligramm
                            {
                                arrWert[x] = arrWert[x] * 1000;
                                arrEinheit[x] = "mg";
                            }
                            if (arrEinheit[x].equals("µl"))     // Mikroliter auf Milliliter
                            {
                                arrWert[x] = arrWert[x] / 1000;
                                arrEinheit[x] = "ml";
                            }
                            if (arrEinheit[x].equals("l"))      // Liter auf Milliliter
                            {
                                arrWert[x] = arrWert[x] * 1000;
                                arrEinheit[x] = "ml";
                            }

                            EingabefelderLeer = false;
                        }
                    }
                    else
                    {
                        fktEineBerechnungKannNichtDurchgeführtWerden();
                        EingabefelderLeer = true;
                        break;
                    }
                }

                // *****************************************************************
                // ***** Hier wird nur gerechnet wenn alle Felder gefüllt sind! ****
                // *****************************************************************
                if (EingabefelderLeer == false)
                {
                    dblZwischenergebnis = dblGehalt*100;

                    for (x=0; x<= intEndeVerdReihe; x++ )
                    {
                        // *****************************************************************
                        // ***** Hier werden nur die vollen Verdünnungsreihen berechnet ****
                        // *****************************************************************
                        if ((x == 1)||(x == 3)||(x == 5)||(x == 7)||(x == 9))
                        {
                            dblWert = arrWert[x-1] / arrWert[x];
                            dblZwischenergebnis = dblZwischenergebnis / dblWert;

                        }
                    }

                    // Korrektur bei ml
                    if(arrEinheit[0].equals("ml"))
                    {
                        dblPPM = dblZwischenergebnis;
                    }
                    else
                    {
                        dblPPM = dblZwischenergebnis * 1000;
                    }

                    //strAusgabe = Double.toString(dblPPM);
                    strAusgabe = "Gehalt = \n" + ActivityTools.fktUmrechnungEinheit(dblPPM, "ppm");

                    tv = (TextView) findViewById(R.id.btnEinheit);
                    strAuswahl = tv.getText().toString();

                    boolean bo_Gleich = strAusgabe.contains(strAuswahl);

                    if(bo_Gleich == false) // nur die Wuscheinheit Anzeigen, wenn sie nicht gleich der normalen Einheit ist.
                    {
                        strAusgabe3 = "Oder\n" + ActivityTools.fktUmrechnungKonzentration(dblPPM, strAuswahl) + "\nin der\nangegebenen\nEinheit.";
                    }

                    // *********************************************
                    // *** Hier wird ein Alert Dialog ausgegeben ***
                    // *********************************************

                    AlertDialog.Builder builder = new AlertDialog.Builder(Ausgangskonzentration_Activity.this);
                    builder.setTitle(strAusgabe);
                    builder.setMessage(strAusgabe3);
                    builder.setPositiveButton("Zurück",
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        }
    }

    private void fktCheckAlleEingabefelderLeer()
    {
        EingabefelderLeer = true;

        et = (EditText) findViewById(R.id.End_Konz);
        strEingabetext = et.getText().toString();

        if (strEingabetext.equals("") == false)
        {
            EingabefelderLeer = false;
        }

        for (int x=0; x<=9; x++)
        {
            resId = getResources().getIdentifier("et"+x, "id", getPackageName());
            et = (EditText) findViewById(resId);
            strEingabetext = et.getText().toString();
            if (strEingabetext.equals("") == false)
            {
                EingabefelderLeer = false;
            }
        }
    }

    private void fktCheckAlleEinheitenZuruckgesetzt()
    {
        AlleEinheitenZuruckGesetzt = true;

        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        strEingabetext = tv.getText().toString();
        if (strEingabetext.equals("mg/l (ppm)") == false)
        {
            AlleEinheitenZuruckGesetzt = false;
        }

        tv = (TextView) findViewById(R.id.btn0);
        strEingabetext = tv.getText().toString();
        if (strEingabetext.equals("g") == false)
        {
            AlleEinheitenZuruckGesetzt = false;
        }

        for (int x=1; x<=9; x++)
        {
            resId = getResources().getIdentifier("btn"+x, "id", getPackageName());
            tv = (TextView) findViewById(resId);
            strEingabetext = tv.getText().toString();
            if (strEingabetext.equals("ml") == false)
            {
                AlleEinheitenZuruckGesetzt = false;
            }
        }

        fktCheckAlleEingabefelderLeer();

        if((AlleEinheitenZuruckGesetzt == false) && (EingabefelderLeer == true))
        {
            tv = (TextView) findViewById(R.id.btnAC);
            tv.setText(R.string.AC2);
        }
        else
        {
            tv = (TextView) findViewById(R.id.btnAC);
            tv.setText(R.string.AC);
        }
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
            	intent.putExtra("Kapitel", "Anfangs_Konz_einer_Verd");
            	startActivity(intent);
                return true;

            case R.id.menu_Menue:
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE); imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
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

