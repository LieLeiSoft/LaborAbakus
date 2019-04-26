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

public class QuizMenueActivity extends Activity {

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/

	TextView tv;
	String strHighscore;
	String strQuizHilfe;
	String strLevelCounter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.quiz_menue);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
		ActivityRegistry.register(this);


        // ****************************************************
        // *** Hilfe Alert Dialog nur beim ersten Durchgang ***
        // ****************************************************

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		strQuizHilfe = prefs.getString("QuizHilfe", "1");
		strLevelCounter = prefs.getString("LevelCounter_1", "0");

		if (strQuizHilfe.equals("1") == true && strLevelCounter.equals("0"))
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(QuizMenueActivity.this);
			builder.setTitle("Hallo");
			builder.setMessage("Für das ersten Mal erkläre ich dir kurz die Spielregeln. Tippe gleich auf das blaue Feld - Level 1");
			builder.setPositiveButton
					("OK",
							new DialogInterface.OnClickListener()
							{
								public void onClick(DialogInterface dialog, int id)
								{
									dialog.dismiss();
								}
							}
					);

			AlertDialog dialog = builder.create();
			dialog.show();
		}
	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();

	    String strLevel;
		String strHighscore;
		String strX;

		int intHighscore = 0;
		int intSpeicher;

		int[] arrHighscore = new int[10];

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

        for (int x=1; x<=6; x++)
        {
            strX = Integer.toString(x);
            strHighscore = prefs.getString("Highscore"+strX, "0");

            arrHighscore[x] = Integer.parseInt(strHighscore);
            intHighscore = intHighscore + arrHighscore[x];
        }

		strHighscore = Integer.toString(intHighscore);

		tv = (TextView) findViewById(R.id.tvHighscore);
		tv.setText("Highscore: "+strHighscore);

		tv = (TextView) findViewById(R.id.btnLevel_0);
		tv.setVisibility(View.VISIBLE);
		strHighscore = Integer.toString(arrHighscore[1]);
		tv.setText("\nLevel 1 - Hauptgruppenelemente\n Highscore: "+strHighscore+"  (min. 25)\n");

		if(arrHighscore[1] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_1);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[2]);
			if (arrHighscore[2] == 0)
			{
				tv.setText("\nLevel 2\n Highscore: "+strHighscore+"  (min. 25)\n");
			}
			else
			{
				tv.setText("\nLevel 2 - Nebengruppenelemente\n Highscore: "+strHighscore+"  (min. 25)\n");
			}

			prefEditor.putString("QuizHilfe", "2");
			prefEditor.apply();
		}

		if(arrHighscore[2] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_2);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[3]);
			if (arrHighscore[3] == 0)
			{
				tv.setText("\nLevel 3\n Highscore: "+strHighscore+"  (min. 25)\n");
			}
			else
			{
				tv.setText("\nLevel 3 - Binäre Verbindungen\n Highscore: "+strHighscore+"  (min. 25)\n");
			}

			prefEditor.putString("QuizHilfe", "3");
			prefEditor.apply();
		}

		if(arrHighscore[3] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_3);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[4]);
			if (arrHighscore[4] == 0)
			{
				tv.setText("\nLevel 4\n Highscore: "+strHighscore+"  (min. 25)\n");
			}
			else
			{
				tv.setText("\nLevel 4 - Ternäre Verbindungen\n Highscore: "+strHighscore+"  (min. 25)\n");
			}

			prefEditor.putString("QuizHilfe", "4");
			prefEditor.apply();
		}

		if(arrHighscore[4] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_4);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[5]);
			if (arrHighscore[5] == 0)
			{
				tv.setText("\nLevel 5\n Highscore: "+strHighscore+"  (min. 25)\n");
			}
			else
			{
				tv.setText("\nLevel 5 - Quaternäre Verbindungen\n Highscore: "+strHighscore+"  (min. 25)\n");
			}

			prefEditor.putString("QuizHilfe", "5");
			prefEditor.apply();
		}

		if(arrHighscore[5] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_5);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[6]);
			if (arrHighscore[6] == 0)
			{
				tv.setText("\nLevel 6\nHighscore: "+strHighscore+"\n");
			}
			else
			{
				tv.setText("\nLevel 6 - Trivialnamen und\nenglisch Bezeichnungen\nHighscore: "+strHighscore+"\n");
			}


			prefEditor.putString("QuizHilfe", "6");
			prefEditor.apply();
		}


		if(arrHighscore[6] > 24)
		{
			tv = (TextView) findViewById(R.id.btnLevel_6);
			tv.setVisibility(View.VISIBLE);
			strHighscore = Integer.toString(arrHighscore[7]);
			if (arrHighscore[7] == 0)
			{
				tv.setText("\nLevel 7\nHighscore: "+strHighscore+"\n");
			}
			else
			{
				tv.setText("\nLevel 7 - Alkane, \n Alkene und Alkine \nHighscore: "+strHighscore+"\n");
			}


			prefEditor.putString("QuizHilfe", "6");
			prefEditor.apply();
		}

	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		


	} // onPause

	public void btnLevel_1(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "1");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_2(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "2");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_3(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "3");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}
	public void btnLevel_4(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "4");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_5(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "5");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_6(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "6");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

    public void btnLevel_7(View v)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Level", "7");
        prefEditor.apply();

        Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(myIntent);
    }

	public void btnLevel_8(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "7");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}

	public void btnLevel_9(View v)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putString("Level", "7");
		prefEditor.apply();

		Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
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
           		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
           		SharedPreferences.Editor prefEditor = prefs.edit();
           		prefEditor.putString("Einstellungen", "3");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Quiz");
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
    }	   
} 

