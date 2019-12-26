package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Konz_lsg_Gesucht_Activity extends Activity /*implements OnFocusChangeListener */ {

    int intCounter;
    TextView tv;
    String strAuswahl;
    String strKonzAuswahl;
    String strKonzGehalt;
    String strKonzGehaltEinheit;

    /** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.konz_lsg_gesucht);
	} // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume(){super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("Auswahl", "0");
        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        strKonzGehalt = prefs.getString("KonzGehalt_"+strAuswahl, strKonzGehalt);
        strKonzGehaltEinheit = prefs.getString("KonzGehaltEinheit_"+strAuswahl, strKonzGehaltEinheit);

        tv = (TextView) findViewById(R.id.AcidAuswahl_0);
        tv.setText(" ... die Menge an \n"+ strKonzAuswahl+ " ("+ strKonzGehalt + strKonzGehaltEinheit +")\n für den Ansatz einer Verdünnung in % \n (g in 100g Lösungsmittel).");

        tv = (TextView) findViewById(R.id.AcidAuswahl_1);
        tv.setText(" ... die Menge an \n"+ strKonzAuswahl+ " ("+ strKonzGehalt + strKonzGehaltEinheit +")\n für den Ansatz einer Verdünnung \n in g/l oder mol/l.");

    } // onResume

    @Override
    protected void onPause(){super.onPause();} // onPause

    public void btnGesuchtKonzUeberProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "1"); // (“Name“ und “Wertname“)
        prefEditor.apply();


        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_1.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtKonzUeberMol (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "2"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_2.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtVerdUeberProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "3"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_3.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtVerdUeberMol (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "4"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_4.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtGehaltVerdinProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "5"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_5.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtGehaltVerdinMolpL (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "6"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_6.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent[] intent = {null};
        switch (item.getItemId())
        {
            case R.id.menu_Hilfe:
                intent[0] = new Intent(this, HilfeActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent[0].putExtra("Kapitel", "Konz_Lsg_gesucht wird");
                startActivity(intent[0]);
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
    } // onOptionsItemSelected

} // class Konz_lsg_Auswahl

