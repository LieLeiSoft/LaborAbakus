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


public class Konz_lsg_Anpassung_Activity extends Activity /*implements OnFocusChangeListener */ {


    EditText et;
    TextView tv;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;
    String strDichte;
    String strMolmasse;
    String strAuswahl;
    String strAlterKonzGehalt;
    String strAlteKonzGehaltEinheit;
    String strAlteDichte;
    double dblKonzGehalt;
    double dblAlterKonzGehalt;
    double dblDichte;
    double dblMolmasse;
    double dblAbweichung;


    /** wird ausgef�hrt, wenn Activicty erstellt wird */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konz_lsg_anpassung);


    } // onCreate


    /** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume()
    { super.onResume();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strAuswahl = prefs.getString("Auswahl", "0");

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2") ||
                strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("8")  == true)
        {
            et = (EditText) findViewById(R.id.etAnpassungName);
            et.setVisibility(View.GONE);

            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
            tv = (TextView) findViewById(R.id.tvAnpassungName);
            tv.setVisibility(View.VISIBLE);
            tv.setText(strKonzAuswahl);

            strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
            //dblKonzGehalt = ActivityTools.fktSignifikanteStellen(strKonzGehalt, 4);
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

        }
        else
        {
            strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
            et = (EditText) findViewById(R.id.etAnpassungName);
            et.setText(strKonzAuswahl);
            et.setSelection(et.getText().length());

            strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
            //dblKonzGehalt = ActivityTools.fktSignifikanteStellen(strKonzGehalt, 4);
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

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2")
                || strAuswahl.equals("3") || strAuswahl.equals("4")|| strAuswahl.equals("8") == true)
        {


            tv = (TextView) findViewById(R.id.tvAnpassungDichte);
            strDichte = tv.getText().toString();
        }
        else
        {
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            strDichte = et.getText().toString();
        }


        tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
        strKonzGehaltEinheit = tv.getText().toString();

        if (strDichte.equals(strAlteDichte) == true)
        {
            if (strAlteKonzGehaltEinheit.equals(strKonzGehaltEinheit) == false)
            {
                switch (strKonzGehaltEinheit)
                {
                    case "g/l":
                        if (strAlteKonzGehaltEinheit.equals("mol/l") == true)
                        {
                            // Umrechnung von mol/l auf g/L
                            dblAlterKonzGehalt = dblAlterKonzGehalt * dblMolmasse;
                        }
                        else
                        {
                            // Umrechnung von % auf g/l
                            dblAlterKonzGehalt = dblAlterKonzGehalt * 10 * dblDichte;
                        }

                        break;

                    case "mol/l":
                        if (strAlteKonzGehaltEinheit.equals("%") == true)
                        {
                            // Umrechnung von % auf mol/l
                            dblAlterKonzGehalt = (dblAlterKonzGehalt * 10 * dblDichte) / dblMolmasse;
                        }
                        else
                        {
                            // Umrechnung von g/l auf mol/l
                            dblAlterKonzGehalt = dblAlterKonzGehalt / dblMolmasse;
                        }
                        break;

                    case "%":
                        if (strAlteKonzGehaltEinheit.equals("g/l") == true)
                        {
                            // Umrechnung von g/l auf %
                            dblAlterKonzGehalt = dblAlterKonzGehalt / (10 * dblDichte);
                        }
                        else
                        {
                            // Umrechnung von mol/l auf %
                            dblAlterKonzGehalt = (dblAlterKonzGehalt * dblMolmasse) / (10 * dblDichte);
                        }
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
                String text = "\nAchtung: Der Gehalt wurde gravierend geändert ohne die Dichte anzupassen!! ist das Korrekt?\n";
                Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
                Meldung.setGravity(Gravity.TOP, 0, 0);
                Meldung.show();
            }
        }

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2")
                || strAuswahl.equals("3") || strAuswahl.equals("4")|| strAuswahl.equals("8") == true)
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
        TextView tv;
        tv = (TextView) v;
        strKonzGehaltEinheit = tv.getText().toString();

        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        strKonzGehalt = et.getText().toString();
        dblKonzGehalt = Double.parseDouble(strKonzGehalt);

        if (strAuswahl.equals("0") || strAuswahl.equals("1") || strAuswahl.equals("2")
                || strAuswahl.equals("3") || strAuswahl.equals("4") || strAuswahl.equals("8") == true)
        {
            tv = (TextView) findViewById(R.id.tvAnpassungDichte);
            strDichte = tv.getText().toString();
            dblDichte = Double.parseDouble(strDichte);

            tv = (TextView) findViewById(R.id.tvAnpassungMolmasse);
            strMolmasse = tv.getText().toString();
            dblMolmasse = Double.parseDouble(strMolmasse);
        }
        else
        {
            et = (EditText) findViewById(R.id.etAnpassungDichte);
            strDichte = et.getText().toString();
            dblDichte = Double.parseDouble(strDichte);

            et = (EditText) findViewById(R.id.etAnpassungMolmasse);
            strMolmasse = et.getText().toString();
            dblMolmasse = Double.parseDouble(strMolmasse);
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        switch (strKonzGehaltEinheit)
        {
            case "%":
                strKonzGehaltEinheit = "g/l";

                tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                tv.setText(strKonzGehaltEinheit);

                // Umrechnung auf g/l

                dblKonzGehalt = (dblKonzGehalt * dblDichte * 10);
                dblKonzGehalt = ActivityTools.fktRunden(dblKonzGehalt, 2); // 4 Nachkommastellen
                break;

            case "g/l":
                strKonzGehaltEinheit = "mol/l";

                tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                tv.setText(strKonzGehaltEinheit);

                // Umrechnung auf mol/l

                dblKonzGehalt = dblKonzGehalt / dblMolmasse;
                dblKonzGehalt = ActivityTools.fktRunden(dblKonzGehalt, 4); // 2 Nachkommastellen
                break;

            case "mol/l":
                strKonzGehaltEinheit = "%";

                tv = (TextView) findViewById(R.id.tvAnpassungEinheit);
                tv.setText(strKonzGehaltEinheit);

                // Umrechnung auf %

                dblKonzGehalt = (dblKonzGehalt * dblMolmasse) / (10 * dblDichte);
                dblKonzGehalt = ActivityTools.fktRunden(dblKonzGehalt, 3); // 2 Nachkommastellen
                break;
        }

        strKonzGehalt = Double.toString(dblKonzGehalt);
        et = (EditText) findViewById(R.id.etAnpassungGehalt);
        et.setText(strKonzGehalt);
        et.setSelection(et.getText().length());

    } // btnAuswahl


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

