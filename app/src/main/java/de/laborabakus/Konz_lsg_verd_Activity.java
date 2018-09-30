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
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class Konz_lsg_verd_Activity extends Activity /*implements OnFocusChangeListener */
{
    View v;
    TextView tv;
    EditText et;
    String strMasseVerd;
    String strGehaltVerd;
    String strAuswahl;
    String strAcidGehalt;
    String strEinheitGehalt;
    String strAcidAuswahl;
    String strEinheitGehaltVerd;
    String strGesucht;
    String strErgebnis;
    double dblMasseAcid;
    double dblMasseVerd;
    double dblGehaltVerd;
    double dblGehaltAcid;

	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.konz_lsg_verd);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");

        strAcidAuswahl = prefs.getString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);
        strAcidGehalt = prefs.getString("AcidGehalt_"+strAuswahl, strAcidGehalt);
        strEinheitGehalt = prefs.getString("EinheitGehalt_"+strAuswahl, strEinheitGehalt);
        strGesucht = prefs.getString("Gesucht", "MasseKonz");

        tv = (TextView) findViewById(R.id.tvAcidBase);
        tv.setText(strAcidAuswahl + " " + strAcidGehalt + strEinheitGehalt);

        strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
        tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
        tv.setText(strEinheitGehaltVerd);

        if (strGesucht.equals("MasseKonz") == true)
        {
            strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Masse der Konzentrierten Lösung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungMasseKonz);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView5);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Verdünnung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz5);
            b.setVisibility(View.INVISIBLE);
        }

        if (strGesucht.equals("MasseVerd") == true)
        {
            strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Masse der Verdünnung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView6);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Konzentrierten Lösung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz);
            b.setVisibility(View.INVISIBLE);
        }

        if (strGesucht.equals("GehaltVerd") == true)
        {
               strEinheitGehaltVerd = prefs.getString("EinheitGehaltVerd", "%");
            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);

            // Eingabefeld Konzentration der Verdünnung unsichtbar machen
            et = (EditText) findViewById(R.id.etAnpassungKonz);
            et.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.textView7);
            tv.setVisibility(View.VISIBLE);
            // Berechnung Button der Konzentrierten Lösung unsichtbar machen
            View b = findViewById(R.id.tvBerechnungKonz);
            b.setVisibility(View.INVISIBLE);
        }





    } // onResume

    @Override
    protected void onPause() {
        super.onPause();
    } // onPause

    public void btnEinheitGehaltVerd(View v)
    {
        TextView tv;
        tv = (TextView) v;
        strEinheitGehaltVerd = tv.getText().toString();

        if (strEinheitGehaltVerd.equals("%") == true)
        {
            strEinheitGehaltVerd = "mol/L";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);
        }
        else
        {
            strEinheitGehaltVerd = "%";

            tv = (TextView) findViewById(R.id.tvAnpassungEinheitGehaltVerd);
            tv.setText(strEinheitGehaltVerd);
        }
    } // btnAuswahl

    public void btnBerechneMasseKonz(View v)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strAcidAuswahl = prefs.getString("AcidAuswahl_"+strAuswahl, strAcidAuswahl);
        strAcidGehalt = prefs.getString("AcidGehalt_"+strAuswahl, strAcidGehalt);
        dblGehaltAcid = Double.parseDouble(strAcidGehalt);

        et = (EditText) findViewById(R.id.etAnpassungMasseVerd);
        strMasseVerd = et.getText().toString();
        dblMasseVerd = Double.parseDouble(strMasseVerd);

        et = (EditText) findViewById(R.id.etAnpassungKonz);
        strGehaltVerd = et.getText().toString();
        dblGehaltVerd = Double.parseDouble(strGehaltVerd);

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        // Berechnung der Masse der Konzentrierten Lösung
        // Masse Konz = (MasseVerd * GehaltVerd) / GehaltKonz

        dblMasseAcid = (dblMasseVerd * dblGehaltVerd) / dblGehaltAcid;
        strErgebnis = ActivityTools.fktDoubleToStringFormat(dblMasseAcid, 1); // 1 Nachkommastellen

        tv = (TextView) findViewById(R.id.tvErgebnis1);
        tv.setText("Für den Ansatz einer "+ strAcidAuswahl +" "+ strGehaltVerd + strEinheitGehaltVerd +
                ", benötigt man "+ strErgebnis +" g einer "+ strAcidAuswahl + " " + strAcidGehalt +
                strEinheitGehalt +", die mit Wasser zu "+ strMasseVerd +" g verdünnt werden muss.");



        //tv = (TextView) findViewById(R.id.tvErgebnis2);
        //tv.setText(strAcidGehalt+" "+strMasseVerd+" "+strGehaltVerd);




    }

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



} // class Activity

