package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static de.laborabakus.ActivityTools.fktSignifikanteStellen;
import static de.laborabakus.Konz_lsg_Gegeben_Activity.fktDichtetabellen;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufGrammProLiter;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufMolar;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufNormal;
import static de.laborabakus.Konz_lsg_verd_Activity.fktGehaltUmrechnenAufProzent;


public class Konz_lsg_Anpassung_Activity extends Activity /*implements OnFocusChangeListener */ {


    EditText et;
    TextView tv;
    boolean booWechselDerEinheitErlauben = true;
    String strName;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strDichte;
    String strMolmasse;
    String strAuswahl;
    String strAlterKonzGehalt;
    String strAlteKonzGehaltEinheit;
    String strAlteDichte;
    String strStoWert;
    String strGehaltEinheit;    // für die Ermittlung der Dichte
    String strGehalt;           // für die Ermittlung der Dichte
    double dblGehalt;           // für die Ermittlung der Dichte
    double dblMaxGehalt;
    double dblKonzGehalt;
    double dblAlterKonzGehalt;
    double dblDichte;
    double dblMolmasse;
    double dblAbweichung;
    double dblErgebnis;
    double dblStoWert;


    /** wird ausgef�hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_anpassung);


    } // onCreate

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        tv = (TextView) findViewById(R.id.tvAnpassungName);
        strName = tv.getText().toString();
        if (strName.equals(""))
        {
            et = (EditText) findViewById(R.id.etAnpassungName);
            strName = et.getText().toString();
            if(strName.equals(""))
            {
                String text = "\n   Bitte einen Namen eingeben!   \n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                Meldung.setGravity(Gravity.BOTTOM, 0, 0);
                Meldung.show();
                return true;
            }
        }

        tv = (TextView) findViewById(R.id.tvAnpassungDichte);
        strDichte = tv.getText().toString();
        if (strDichte.equals(""))
        {
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            strDichte = et.getText().toString();
            if(strDichte.equals(""))
            {
                fktAusgabeKeinWert();
                return true;
            }
            dblDichte = Double.parseDouble(strDichte);
            if(dblDichte == 0)
            {
                fktAusgabeKeineNull();
                return true;
            }
        }

        tv = (TextView) findViewById(R.id.tvAnpassungMolmasse);
        strMolmasse = tv.getText().toString();
        if (strMolmasse.equals(""))
        {
            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            strMolmasse = et.getText().toString();
            if(strMolmasse.equals(""))
            {
                fktAusgabeKeinWert();
                return true;
            }
            dblMolmasse = Double.parseDouble(strMolmasse);
            if(dblMolmasse == 0)
            {
                fktAusgabeKeineNull();
                return true;
            }
        }

        tv = (TextView) findViewById(R.id.tvAnpassungWertigkeit);
        strStoWert = tv.getText().toString();
        if (strStoWert.equals(""))
        {
            et = (EditText) findViewById(R.id.etAnpassungWertigkeit);
            strStoWert = et.getText().toString();
            if(strStoWert.equals(""))
            {
                fktAusgabeKeinWert();
                return true;
            }
            dblStoWert = Double.parseDouble(strStoWert);
            if(dblStoWert == 0)
            {
                fktAusgabeKeineNull();
                return true;
            }
        }

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();

        if(strKonzGehalt.equals(""))
        {
            fktAusgabeKeinWert();
            return true;
        }

        dblKonzGehalt = Double.parseDouble(strKonzGehalt);

        if(dblKonzGehalt == 0)
        {
            fktAusgabeKeineNull();
            return true;
        }

        dblMaxGehalt = 100;
        switch (strAuswahl)
        {
            case "0":
                dblMaxGehalt = 40;      // Salzsäure
                break;

            case "8":
                dblMaxGehalt = 54;      // Natronlauge
                break;

            case "9":
                dblMaxGehalt = 52;      // Kalilauge
                break;

            case "10":
                dblMaxGehalt = 34;      // Ammoniaklösung
                break;
        }

        dblErgebnis = fktGehaltUmrechnenAufProzent(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);

        if (dblErgebnis > dblMaxGehalt)
        {
            String text = "\n   Der Gehalt ist zu hoch!   \n";
            Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
            Meldung.setGravity(Gravity.BOTTOM, 0, 0);
            Meldung.show();
            return true;
        }
        else
        {
            ActivityRegistry.register(this);
            finish();
            return false;
        }
    } // onKeyDown



    /** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume()
    { super.onResume();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strAuswahl = prefs.getString("Auswahl", "0");

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2") ||
                strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("5") ||
                strAuswahl.equals("6") || strAuswahl.equals("8") || strAuswahl.equals("9") ||
                strAuswahl.equals("10")  == true)
        {
            et = (EditText) findViewById(R.id.etAnpassungName);
            et.setVisibility(View.GONE);

            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
            tv = (TextView) findViewById(R.id.tvAnpassungName);
            tv.setVisibility(View.VISIBLE);
            tv.setText(strKonzAuswahl);

            strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
            dblKonzGehalt = Double.parseDouble(strKonzGehalt);
            et = (EditText) findViewById(R.id.etAnpassungGehalt);
            et.setText(strKonzGehalt);
            et.setSelection(et.getText().length());

            strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strKonzGehaltEinheit);

            et = (EditText) findViewById(R.id.etAnpassungDichte);
            et.setVisibility(View.GONE);

            tv = (TextView) findViewById(R.id.tvAnpassungDichte);
            strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
            dblDichte = Double.parseDouble(strDichte);

            tv.setVisibility(View.VISIBLE);
            tv.setText(strDichte);

            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            et.setVisibility(View.GONE);

            strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
            dblMolmasse = Double.parseDouble(strMolmasse);
            tv = (TextView) findViewById(R.id.tvAnpassungMolmasse);
            tv.setVisibility(View.VISIBLE);
            tv.setText(strMolmasse);

            et = (EditText) findViewById(R.id.etAnpassungWertigkeit);
            et.setVisibility(View.GONE);

            strStoWert = prefs.getString("Wertigkeit_"+strAuswahl, strStoWert);
            dblStoWert = Double.parseDouble(strStoWert);
            tv = (TextView) findViewById(R.id.tvAnpassungWertigkeit);
            tv.setVisibility(View.VISIBLE);
            tv.setText(strStoWert);
        }
        else  // Säuren und Laugen ohne Dichtetabelle
        {
            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
            et = (EditText) findViewById(R.id.etAnpassungName);
            et.setText(strKonzAuswahl);
            et.setSelection(et.getText().length());

            strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
            dblKonzGehalt = Double.parseDouble(strKonzGehalt);
            et = (EditText) findViewById(R.id.etAnpassungGehalt);
            et.setText(strKonzGehalt);
            et.setSelection(et.getText().length());

            strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);
            tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
            tv.setText(strKonzGehaltEinheit);

            strDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
            dblDichte = Double.parseDouble(strDichte);
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            et.setText(strDichte);
            et.setSelection(et.getText().length());

            strMolmasse = prefs.getString("Molmasse_"+strAuswahl, strMolmasse);
            dblMolmasse = Double.parseDouble(strMolmasse);
            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            et.setText(strMolmasse);
            et.setSelection(et.getText().length());

            strStoWert = prefs.getString("Wertigkeit_"+strAuswahl, strStoWert);
            dblStoWert = Double.parseDouble(strStoWert);
            et = (EditText) findViewById(R.id.etAnpassungWertigkeit);
            et.setText(strStoWert);
            et.setSelection(et.getText().length());
        }
    } // onResume


    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strAlterKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        dblAlterKonzGehalt = Double.parseDouble(strAlterKonzGehalt);
        strAlteDichte = prefs.getString("Dichte_"+strAuswahl, strDichte);
        strAlteKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strAlteKonzGehaltEinheit);

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);


        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2") ||
                strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("5") ||
                strAuswahl.equals("6") || strAuswahl.equals("8") || strAuswahl.equals("9") ||
                strAuswahl.equals("10")  == true)
        {

            double dblDummy = 0; double dblVerdMenge = 0; double dblKonzMenge = 0;

            if(strKonzGehaltEinheit.equals("%") == false)
            {
                dblKonzGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDummy);                 // ...mol/l auf g/l umrechnen
            }

            strGehalt = Double.toString(dblKonzGehalt);

            dblDichte = fktDichtetabellen(strKonzAuswahl, dblDummy, dblVerdMenge, dblKonzMenge, strGehalt, strKonzGehaltEinheit); // Aufruf der Funktion Dichtetabelle
            // Dichte wurde ermittelt
            dblDichte = ActivityTools.fktRunden(dblDichte,5);
            // strDichte = ActivityTools.fktSignifikanteStellen(dblDichte, 5);

            dblMaxGehalt = 100;
            switch (strAuswahl)
            {
                case "0":
                    dblMaxGehalt = 40;      // Salzsäure
                    break;

                case "8":
                    dblMaxGehalt = 54;      // Natronlauge
                    break;

                case "9":
                    dblMaxGehalt = 52;      // Kalilauge
                    break;

                case "10":
                    dblMaxGehalt = 34;      // Ammoniaklösung
                    break;
            }

            dblErgebnis = fktGehaltUmrechnenAufProzent(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);

            if (dblErgebnis > dblMaxGehalt)
            {
                fktDichteKonnteNichtErmitteltWerden();
            }
            else
            {
                if (dblDichte == 0)
                {
                    fktDichteKonnteNichtErmitteltWerden();
                }
                else
                {
                    strDichte = Double.toString(dblDichte);

                    if (dblAlterKonzGehalt != dblKonzGehalt)
                    {
                        String text = "\n   Der Gehalt wurde angepasst!   \n   Deswegen wurde die Dichte \n   aus der  Dichtetabelle neu \n   ermittelt!   \n   Dichte = " + strDichte + "g/ml   \n";
                        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                        Meldung.setGravity(Gravity.TOP, 0, 0);
                        Meldung.show();
                    }
                }
            }


            tv = (TextView) findViewById(R.id.tvAnpassungDichte);
            tv.setText(strDichte);
        }
        else
        {
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            strDichte = et.getText().toString();

            if (strDichte.equals(strAlteDichte) == true)
            {
                if (strAlteKonzGehaltEinheit.equals(strKonzGehaltEinheit) == false)
                {
                    switch (strKonzGehaltEinheit)
                    {
                        case "%":
                            dblAlterKonzGehalt = fktGehaltUmrechnenAufProzent(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                            break;
                        case "g/l":
                            dblAlterKonzGehalt = fktGehaltUmrechnenAufGrammProLiter(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                            break;
                        case "mol/l":
                            dblAlterKonzGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                            break;
                        case "M":
                            dblAlterKonzGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                            break;
                        case "N":
                            dblAlterKonzGehalt = fktGehaltUmrechnenAufNormal(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                            break;
                    }
                }

                if (dblAlterKonzGehalt >= dblKonzGehalt)
                {
                    dblAbweichung = ((dblAlterKonzGehalt - dblKonzGehalt) / dblAlterKonzGehalt) * 100;
                }
                else
                {
                    dblAbweichung = ((dblKonzGehalt - dblAlterKonzGehalt) / dblKonzGehalt) * 100;
                }

                if (dblAbweichung > 1)
                {
                    String text = "\nAchtung: Der Gehalt wurde gravierend geändert ohne die Dichte anzupassen!! Ist das korrekt?\n";
                    Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                    Meldung.setGravity(Gravity.TOP, 0, 0);
                    Meldung.show();
                }
            }
        }


        //tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
        //strKonzGehaltEinheit = tv.getText().toString();
        //  wurde raus genommen, weil bei einem Absturz die KonzGehaltEinheit nicht zurück gestzt wird und hier neu ausgelesen wird.


        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2") ||
                strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("5") ||
                strAuswahl.equals("6") || strAuswahl.equals("8") || strAuswahl.equals("9") ||
                strAuswahl.equals("10")  == true)
        {
            tv = (TextView) findViewById(R.id.tvAnpassungName);
            strKonzAuswahl = tv.getText().toString();
            prefEditor.putString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);

            prefEditor.putString("KonzGehalt_"+strAuswahl, strKonzGehalt);

            prefEditor.putString("Dichte_"+strAuswahl, strDichte);

            TableRow tr;
            tr = (TableRow) findViewById(R.id.trMolmasse);

            tv = (TextView) findViewById(R.id.tvAnpassungMolmasse);
            strMolmasse = tv.getText().toString();
            prefEditor.putString("Molmasse_"+strAuswahl, strMolmasse);

            tv = (TextView) findViewById(R.id.tvAnpassungWertigkeit);
            strStoWert = tv.getText().toString();
            prefEditor.putString("Wertigkeit_"+strAuswahl, strStoWert);

            strAuswahl = prefs.getString("Auswahl", "0");
            prefEditor.putString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);

            prefEditor.apply();
        }
        else
        {
            et = (EditText) findViewById(R.id.etAnpassungName);
            strKonzAuswahl = et.getText().toString();
            prefEditor.putString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);

            prefEditor.putString("KonzGehalt_"+strAuswahl, strKonzGehalt);

            prefEditor.putString("Dichte_"+strAuswahl, strDichte);

            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            strMolmasse = et.getText().toString();
            prefEditor.putString("Molmasse_"+strAuswahl, strMolmasse);

            et = (EditText) findViewById(R.id.etAnpassungWertigkeit);
            strStoWert = et.getText().toString();
            prefEditor.putString("Wertigkeit_"+strAuswahl, strStoWert);

            strAuswahl = prefs.getString("Auswahl", "0");
            prefEditor.putString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);

            prefEditor.apply();
        }


    } // onPause

    // ******************************************************************************************
    // ******************* Button btnAuswahl ********************************************************
    // ******************************************************************************************

    public void btnEinheitGehalt(View v)
    {
        booWechselDerEinheitErlauben = true;

        TextView tv;
        tv = (TextView) v;
        strKonzGehaltEinheit = tv.getText().toString();

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2") ||
                strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("5") ||
                strAuswahl.equals("6") || strAuswahl.equals("8") || strAuswahl.equals("9") ||
                strAuswahl.equals("10")  == true)
        {
            tv = (TextView) findViewById(R.id.tvAnpassungMolmasse);
            strMolmasse = tv.getText().toString();
            dblMolmasse = Double.parseDouble(strMolmasse);

            tv = (TextView) findViewById(R.id.tvAnpassungWertigkeit);
            strStoWert = tv.getText().toString();
            dblStoWert = Double.parseDouble(strStoWert);

            if (strKonzGehalt.equals("") == false)
            {
                dblKonzGehalt = Double.parseDouble(strKonzGehalt);

                if((strKonzGehaltEinheit.equals("%")) == false && (strKonzGehaltEinheit.equals("mol/l")) == false)
                // Wenn der Gehalt g/l / N oder M ist
                {
                    dblGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                    strGehalt = Double.toString(dblGehalt);
                }
                else
                {
                    strGehalt = strKonzGehalt;
                }

                dblDichte = fktDichtetabellen(strKonzAuswahl, 0, 0, 0, strGehalt, strKonzGehaltEinheit);
                dblDichte = ActivityTools.fktRunden(dblDichte,5);
                if(dblDichte == 0)
                {
                    String text = "\n   Der Gehalt liegt außerhalb  \n   des zulässigen Bereiches!   \n";
                    Toast Meldung = Toast.makeText(Konz_lsg_Anpassung_Activity.this, text, Toast.LENGTH_LONG);
                    Meldung.setGravity(Gravity.BOTTOM, 0, 0);
                    Meldung.show();

                    et = (EditText) findViewById(R.id.etAnpassungGehalt);
                    et.setText(" ");
                    strKonzGehalt = "";
                    booWechselDerEinheitErlauben = false;
                }
                else
                {
                    strDichte = Double.toString(dblDichte);
                    tv = (TextView) findViewById(R.id.tvAnpassungDichte);
                    tv.setText(strDichte);
                    booWechselDerEinheitErlauben = true;
                }
            }
        }
        else
        {
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            strDichte = et.getText().toString();
            dblDichte = Double.parseDouble(strDichte);

            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            strMolmasse = et.getText().toString();
            dblMolmasse = Double.parseDouble(strMolmasse);

            et = (EditText) findViewById(R.id.etAnpassungWertigkeit);
            strStoWert = et.getText().toString();
            dblStoWert = Double.parseDouble(strStoWert);
        }

        if(booWechselDerEinheitErlauben == true)
        {
            switch (strKonzGehaltEinheit)
            {
                case "%":
                    // Umrechnung auf g/l

                    if (strKonzGehalt.equals("") == false)
                    {
                        dblKonzGehalt = fktGehaltUmrechnenAufGrammProLiter(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                        strKonzGehalt = fktSignifikanteStellen(dblKonzGehalt, 5); // 5 stellen
                        strKonzGehalt = strKonzGehalt.replace(",", ".");
                    }
                    strKonzGehaltEinheit = "g/l";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                    tv.setText(strKonzGehaltEinheit);
                    break;

                case "g/l":
                    // Umrechnung auf mol/l

                    if (strKonzGehalt.equals("") == false)
                    {
                        dblKonzGehalt = fktGehaltUmrechnenAufMolar(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                        strKonzGehalt = fktSignifikanteStellen(dblKonzGehalt, 5); // 5 stellen
                        strKonzGehalt = strKonzGehalt.replace(",", ".");
                    }

                    if (dblStoWert == 1)
                    {
                        strKonzGehaltEinheit = "mol/l";
                        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                        tv.setText(strKonzGehaltEinheit);
                        break;
                    }
                    else
                    {
                        strKonzGehaltEinheit = "M";
                        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                        tv.setText(strKonzGehaltEinheit);
                        break;
                    }


                case "mol/l":
                    // Umrechnung auf N

                    if (strKonzGehalt.equals("") == false)
                    {
                        dblKonzGehalt = fktGehaltUmrechnenAufProzent(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                        strKonzGehalt = fktSignifikanteStellen(dblKonzGehalt, 5); // 5 stellen
                        strKonzGehalt = strKonzGehalt.replace(",", ".");
                    }
                    strKonzGehaltEinheit = "%";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                    tv.setText(strKonzGehaltEinheit);
                    break;

                case "M":
                    // Umrechnung auf N

                    if (strKonzGehalt.equals("") == false)
                    {
                        dblKonzGehalt = fktGehaltUmrechnenAufNormal(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                        strKonzGehalt = fktSignifikanteStellen(dblKonzGehalt, 5); // 5 stellen
                        strKonzGehalt = strKonzGehalt.replace(",", ".");
                    }
                    strKonzGehaltEinheit = "N";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                    tv.setText(strKonzGehaltEinheit);
                    break;

                case "N":
                    // Umrechnung auf %

                    if (strKonzGehalt.equals("") == false)
                    {
                        dblKonzGehalt = fktGehaltUmrechnenAufProzent(dblKonzGehalt, strAuswahl, strKonzGehaltEinheit, dblStoWert, dblMolmasse, dblDichte);
                        strKonzGehalt = fktSignifikanteStellen(dblKonzGehalt, 5); // 5 stellen
                        strKonzGehalt = strKonzGehalt.replace(",", ".");
                    }
                    strKonzGehaltEinheit = "%";
                    tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                    tv.setText(strKonzGehaltEinheit);
                    break;
            }
        }

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        et.setText(strKonzGehalt);
        et.setSelection(et.getText().length());

    } // btnAuswahl

    public void fktAusgabeKeinWert()
    {
        String text = "\n   Bitte einen Wert eingeben!   \n";
        Toast Meldung = Toast.makeText(Konz_lsg_Anpassung_Activity.this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.BOTTOM, 0, 0);
        Meldung.show();
    }

    public void fktAusgabeKeineNull()
    {
        String text = "\n   Bitte keine Null eingeben!   \n";
        Toast Meldung = Toast.makeText(Konz_lsg_Anpassung_Activity.this, text, Toast.LENGTH_SHORT);
        Meldung.setGravity(Gravity.BOTTOM, 0, 0);
        Meldung.show();
    }

    public void fktDichteKonnteNichtErmitteltWerden()
    {
        String text = "\n   Der Gehalt liegt außerhalb \n   des zulässigen Bereiches. \n   Deswegen konnte die neue   \n   Dichte nicht ermittlet    \n   werden! Die Dichte \n   und der Gehalt wurden  \n   auf die alten Werte \n   zurück gesetzt!  \n";
        Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
        Meldung.setGravity(Gravity.TOP, 0, 0);
        Meldung.show();
        strDichte = strAlteDichte;
        strKonzGehalt = strAlterKonzGehalt;
        strKonzGehaltEinheit = strAlteKonzGehaltEinheit;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent[] intent = {null};
        switch (item.getItemId()) {
            case R.id.menu_Hilfe:
                intent[0] = new Intent(this, HilfeActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent[0].putExtra("Kapitel", "Konz_Lsg_Anpassung");
                startActivity(intent[0]);
                return true;

            case R.id.menu_Einstellungen:

                AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_Anpassung_Activity.this);
                builder.setTitle("Zurücksetzen aller Säuren und Laugen?");
                builder.setPositiveButton("Ja",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                                SharedPreferences.Editor prefEditor = prefs.edit();
                                prefEditor.putString("strCounter", "0");
                                prefEditor.apply();
                                dialog.dismiss();
                                ActivityRegistry.finishAll();
                                Intent myIntent = new Intent(Konz_lsg_Anpassung_Activity.this, Konz_lsg_Auswahl_Activity.class);
                                myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(myIntent);
                            }
                        }
                );
                builder.setNegativeButton("Nein",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        }
                );

                AlertDialog dialog = builder.create();
                dialog.show();


                return true;

            case R.id.menu_Menue:
                ActivityRegistry.finishAll();
                intent[0] = new Intent(this, HauptmenueActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent[0]);
                return true;

            case R.id.menu_Aus:
                ActivityRegistry.finishAll();
                finish();
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

} // class Konz_lsg_Anpassung

