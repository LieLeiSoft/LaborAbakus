package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
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


public class Endkonzentration_Activity extends Activity implements OnFocusChangeListener {

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
    double dblReinheit;
    double dblPPM;
    double dblZwischenergebnis;
    double dblWert;
    String strEingabetext;
    String strEingabetext2;
    String strAuswahl;
    String strAuswahl2;
    String strAuswahl3;

    /** wird ausgef�hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verduennen);

        // Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);

        // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
        et = (EditText) findViewById(R.id.Reinheit_Konz);
        et.requestFocus();
        showSoftKeyboard(findViewById(R.id.Reinheit_Konz));

        et = (EditText) findViewById(R.id.End_Konz);
        et.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.btnEinheitEndKonz);
        tv.setVisibility(View.GONE);


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

        tv = (TextView) findViewById(R.id.btn0);
        strAuswahl = tv.getText().toString();

        // *****************************************************************************************************************************************
        // *** falls mg oder g auf ml oder µl in der AusgangskonzentrationActivity verstellt wurde, wird hier die Aggregatzustand nue angepasst ****
        // *****************************************************************************************************************************************
        if (strAuswahl.equals("mg") || strAuswahl.equals("g"))
        {
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText("fest");
        }
        else
        {
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText("flüssig");
        }

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

        fktCheckAlleEinheitenZuruckgesetzt();
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

        fktCheckAlleEinheitenZuruckgesetzt();
    }

    /**************************************************
     ************** Button % / mg/ml / ppm ************
     **************************************************/

    public void btnOnClickEinheitReinheit (View v)
    {
        // ******************************************************
        // *** Wechsel der Anzeige "%" "mg/ml" und "ppm" ********
        // ******************************************************

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
            tv.setText(R.string.ppm);
        }

        if (strAuswahl2.equals("ppm"))
        {
            tv = (TextView) findViewById(R.id.btnEinheitReinheit);
            tv.setText(R.string.Prozent);
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
            tv.setText("ng/l");
        }
        if (strAuswahl.equals("ng/l"))
        {
            tv = (TextView) findViewById(R.id.btnEinheit);
            tv.setText("ppt");
        }
        if (strAuswahl.equals("ppt"))
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

        fktCheckAlleEinheitenZuruckgesetzt();
    } // btnCE

    // Eingabefelder zur�cksetzen
    public void btnOnClickAC(View v) {
        EditText et;
        int resId;

        fktCheckAlleEingabefelderLeer();

        if (EingabefelderLeer == false)  // Wenn alle Eingabefelder leer sind
        {
            et = (EditText) findViewById(R.id.Reinheit_Konz);
            et.setText("");

            for (int x=0; x<=9; x++)
            {
                resId = getResources().getIdentifier("et"+(x), "id", getPackageName());
                et = (EditText) findViewById(resId);
                et.setText("");
            }

            et = (EditText) findViewById(R.id.Reinheit_Konz);
            et.requestFocus();    // Cursor in erstes Eingabefeld setzen

            EingabefelderLeer = true;

            fktCheckAlleEinheitenZuruckgesetzt();
        }
        else
        {
            tv = (TextView) findViewById(R.id.btnFestFluessig);
            tv.setText(R.string.aktuell_fest);

            tv = (TextView) findViewById(R.id.btnEinheitReinheit);
            tv.setText(R.string.Prozent);

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
        double dblMenge;
        strAuswahl3 = "";
        String strAusgabe = "";
        String strAusgabe2 = "";
        String strAusgabe3 = "";

        //fktCheckAlleEingabefelderLeer();

        // *************************************************************************
        // ***** Hier wird der Gehalt der Substanz und die Einheit ausgelesen. *****
        // *************************************************************************
        et = (EditText) findViewById(R.id.Reinheit_Konz);
        strEingabetext = et.getText().toString();

        if (strEingabetext.equals("") == false)
        {
            dblReinheit = Double.parseDouble(strEingabetext);
            if (dblReinheit == 0)
            {
                fktEingabeNullNichtZulaessig();
            }
            else
            {
                // *******************************************************************
                // ***** Hier wird Berechnung bei mg/g, mg/l und ppm korrigiert. *****
                // *******************************************************************

                tv = (TextView) findViewById(R.id.btnEinheitReinheit);
                strEingabetext2 = tv.getText().toString();
                if ((strEingabetext2.equals("mg/g")) || (strEingabetext2.equals("mg/ml")))
                {
                    dblReinheit = dblReinheit / 10;
                }
                if (strEingabetext2.equals("ppm"))
                {
                    dblReinheit = dblReinheit / 10000;
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
                    dblZwischenergebnis = dblReinheit/100;

                    for (x=0; x<= intEndeVerdReihe; x++ )
                    {
                        // *****************************************************************
                        // ***** Hier werden nur die vollen Verdünnungsreihen berechnet ****
                        // *****************************************************************
                        if ((x == 1)||(x == 3)||(x == 5)||(x == 7)||(x == 9))
                        {
                            dblWert = arrWert[x-1] / arrWert[x];
                            dblZwischenergebnis = dblZwischenergebnis * dblWert;

                        }
                    }

                    // Korrektur bei ml
                    if(arrEinheit[0].equals("ml"))
                    {
                        dblPPM = dblZwischenergebnis * 1000000;
                    }
                    else
                    {
                        dblPPM = dblZwischenergebnis * 1000;
                    }




                    //strAusgabe = Double.toString(dblPPM);
                    strAusgabe = "Endkonzentration = \n" + ActivityTools.fktUmrechnungEinheit(dblPPM, "ppm");

                    tv = (TextView) findViewById(R.id.btnEinheit);
                    strAuswahl = tv.getText().toString();

                    boolean bo_Gleich = strAusgabe.contains(strAuswahl);

                    if(bo_Gleich == false) // nur die Wuscheinheit Anzeigen, wenn sie nicht gleich der normalen Einheit ist.
                    {
                        strAusgabe3 = "Oder\n" + ActivityTools.fktUmrechnungKonzentration(dblPPM, strAuswahl) + "\nin der\nangegebenen\nEinheit.";
                    }


                    if ((intEndeVerdReihe == 0)||(intEndeVerdReihe == 2)||(intEndeVerdReihe == 4)||(intEndeVerdReihe == 6)||(intEndeVerdReihe == 8))
                    {
                        dblMenge = (dblPPM * arrWert[intEndeVerdReihe]) / 1000;

                        strAusgabe = ActivityTools.fktUmrechnungEinheit(dblMenge, "mg");
                        strAusgabe2 = ActivityTools.fktUmrechnungEinheit(arrWert[intEndeVerdReihe], arrEinheit[intEndeVerdReihe]);

                        strAusgabe = strAusgabe + " in " + strAusgabe2;

                        strAusgabe3 = "";
                    }


                    // *********************************************
                    // *** Hier wird ein Alert Dialog ausgegeben ***
                    // *********************************************

                    AlertDialog.Builder builder = new AlertDialog.Builder(Endkonzentration_Activity.this);
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

        et = (EditText) findViewById(R.id.Reinheit_Konz);
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

        tv = (TextView) findViewById(R.id.btnFestFluessig);
        strEingabetext = tv.getText().toString();
        if (strEingabetext.equals("fest") == false)
        {
            AlleEinheitenZuruckGesetzt = false;
        }

        tv = (TextView) findViewById(R.id.btnEinheitReinheit);
        strEingabetext = tv.getText().toString();
        if (strEingabetext.equals("%") == false)
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
                intent.putExtra("Kapitel", "End_Konz_einer_Verd");
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


