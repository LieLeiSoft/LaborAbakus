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
import android.widget.TextView;


public class Konz_lsg_Gesucht_Activity extends Activity /*implements OnFocusChangeListener */ {

    int intCounter;

    /** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.konz_lsg_gesucht);

	} // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */

    @Override
    protected void onResume(){super.onResume();} // onResume

    @Override
    protected void onPause(){super.onPause();} // onPause

    public void btnGesuchtKonzUeberProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Proz"); // (“Name“ und “Wertname“)
        prefEditor.apply();


        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtKonzUeberMol (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Mol"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtVerdUeberProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Proz"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_2.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtVerdUeberMol (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Mol"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_2.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtGehaltVerdinProz (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Masse"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_3.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn

    public void btnGesuchtGehaltVerdinMolpL (View v) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Berechnung_ueber", "Volumen"); // (“Name“ und “Wertname“)
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), Konz_lsg_verd_Activity_3.class);

        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // Activity aufrufen
        startActivity(myIntent);

    } // btn


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent[] intent = {null};
        switch (item.getItemId())
        {
            case R.id.menu_Einstellungen:

                AlertDialog.Builder builder = new AlertDialog.Builder(Konz_lsg_Gesucht_Activity.this);
                builder.setTitle("Zurücksetzen aller Säuren und Laugen?");
                builder.setPositiveButton("Ja",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                intCounter = 0;
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                                SharedPreferences.Editor prefEditor = prefs.edit();
                                prefEditor.putInt("intCounter", intCounter);
                                prefEditor.apply();
                                dialog.dismiss();

                               ActivityRegistry.finishAll();

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

            case R.id.menu_Hilfe:
                intent[0] = new Intent(this, HilfeActivity.class);
                intent[0].setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent[0].putExtra("Kapitel", "RSD");
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

