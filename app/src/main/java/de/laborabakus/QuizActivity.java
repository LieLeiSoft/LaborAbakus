package de.laborabakus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	TextView tv;
	int intFrageNr;
    int intLevel;
    int intLevelCounter;
	int intPunkte;
	int intHighscore;
	int intTextSize;
	int intHupe =0;
	int intTicken =0;

	String strPunkte;
	String strHighscore;
	String strFrage;
    String strAntwort;
    String strLevel;
    String strLevelCounter;
    String strQuizHilfe;
    String strAntwortText;

	public MediaPlayer mp;


    public enum Element 														// http://www.mindfiresolutions.com/How-to-handle-String-in-switch-case-of-JAVA-617.php
	// emnum Aufzählungstyp Element
	{
	H, Li, Be, B, C, N, O, F, Na, Mg, Al, Si, P
	, S, Cl, K, Ca, Ga, Ge, As, Se, Br, Rb, Sr
	, In, Sn, Sb, Te, I, Cs, Ba, Tl, Pb, Bi, Po
	, At, Fr, Ra, Sc, Ti, V, Cr, Mn, Fe, Co, Ni
	, Cu, Zn, Y, Zr, Nb, Mo, Tc, Ru, Rh, Pd, Ag
	, Cd, La, Hf, Ta, W, Re, Os, Ir, Pt, Au, Hg; 
	}

	public int[][] arrOxi = new int[100][9]; // Array für Oxidationszahlen (100 Zeilen, 9 Spalten)

	TextView timerTextView;
	long startTime = 0;

	//runs without a timer by reposting this handler at the end of the runnable
	Handler timerHandler = new Handler();
	Runnable timerRunnable = new Runnable() {

		@Override
		public void run() {
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			SharedPreferences.Editor prefEditor = prefs.edit();

			long millis = startTime - System.currentTimeMillis();
			int seconds = (int) (millis / 1000);
			int minutes = seconds / 60;
			seconds = seconds % 60;

			if (millis > 0)
			{
				if (intTicken == 0)         // Damit das Ticken nur einmal gestartet wird
				{
					mp = MediaPlayer.create(getApplicationContext(), R.raw.ticken);
					mp.start();
					intTicken = 1;
				}


				timerTextView.setText(String.format("%d:%02d", minutes, seconds));
				timerHandler.postDelayed(this, 500);

				// ********************************************
				// *************** Zeit läuft *****************
				// ********************************************
			}
			else
			{
				// ********************************************
				// ****** Zeit ist abgelaufen *****************
				// ********************************************

				mp = MediaPlayer.create(getApplicationContext(), R.raw.wecker);
				mp.start();

				timerTextView.setText("END");
				timerHandler.removeCallbacks(timerRunnable);
				startTime = 0;

                tv = (TextView) findViewById(R.id.btnWeiter);
                tv.setVisibility(View.INVISIBLE); // TEXTFELD UNSICHTBAR MACHEN

                Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vi.vibrate(600);  // vibriert für 600ms

				// ********************************************
				// ****** Anzeigen der richtigen Antwort *****************
				// ********************************************

				strAntwortText = QuizFragen.mAntwortText;
				strAntwortText = ActivityTools.fktZiffernTiefstellen(strAntwortText);

				tv = (TextView) findViewById(R.id.tvFormel);
				tv.setText("");		// bisherige Eingabe löschen strAntwort
                tv.setTextColor(Color.RED);
				tv.setTypeface(null, Typeface.BOLD);
				tv.setTextSize(intTextSize+6);
				tv.setText(Html.fromHtml(strAntwortText));

				if(intHighscore < intPunkte)     // die neuen Punkte werden in die Highscore gespeichert, wenn sie höher sind
				{
					prefEditor.putString("Highscore"+strLevel, strPunkte);
					prefEditor.apply();
				}
			}
		}
	}; // timerRunnable

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.quiz_pse);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

		tv = (TextView) findViewById(R.id.btnWeiter);
        tv.setText("Weiter");
		tv.setVisibility(View.INVISIBLE); // TEXTFELD UNSICHTBAR MACHEN

		tv = (TextView) findViewById(R.id.btnPSE_43);
		tv.setVisibility(View.INVISIBLE); // TEXTFELD UNSICHTBAR MACHEN

		timerTextView = (TextView) findViewById(R.id.timerTextView);

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    SharedPreferences.Editor prefEditor = prefs.edit(); 											// Haupt- und Nebengruppenelemente inklusive ihrer Atommassen 
	    																								// werden in die Konfigurationsdatei eingelesen.
	    prefEditor.putInt("AnzahlElemente", 0);
		
	    prefEditor.putString("HE_1", "H");   prefEditor.putFloat("HE_MM_1",  (float) 1.008);	prefEditor.putString("HE_Oxi_1", "1,-1");		
	    prefEditor.putString("HE_2", "Li");  prefEditor.putFloat("HE_MM_2",  (float) 6.939);	prefEditor.putString("HE_Oxi_2", "1");
	    prefEditor.putString("HE_3", "Be");  prefEditor.putFloat("HE_MM_3",  (float) 9.012);	prefEditor.putString("HE_Oxi_3", "2");
	    prefEditor.putString("HE_4", "B");   prefEditor.putFloat("HE_MM_4",  (float) 10.811);	prefEditor.putInt("B_Oxi_1", 3);
	    prefEditor.putString("HE_5", "C");   prefEditor.putFloat("HE_MM_5",  (float) 12.011);	prefEditor.putInt("C_Oxi_1", -4);	prefEditor.putInt("C_Oxi_2", 4);	prefEditor.putInt("C_Oxi_3", 3);	prefEditor.putInt("C_Oxi_4", 2);	prefEditor.putInt("C_Oxi_5", 1);	prefEditor.putInt("C_Oxi_6", 0);	prefEditor.putInt("C_Oxi_7", -1);	prefEditor.putInt("C_Oxi_8", -2);	prefEditor.putInt("C_Oxi_9", -3);
	    prefEditor.putString("HE_6", "N");   prefEditor.putFloat("HE_MM_6",  (float) 14.007);	prefEditor.putInt("N_Oxi_1", -3);	prefEditor.putInt("N_Oxi_2", 3);	prefEditor.putInt("N_Oxi_3", -2);	prefEditor.putInt("N_Oxi_4", -1);	prefEditor.putInt("N_Oxi_5", 1);	prefEditor.putInt("N_Oxi_6", 2);	prefEditor.putInt("N_Oxi_7", 4);	prefEditor.putInt("N_Oxi_8", 5);
	    prefEditor.putString("HE_7", "O");   prefEditor.putFloat("HE_MM_7",  (float) 15.999);	prefEditor.putInt("O_Oxi_1", -2);	prefEditor.putInt("O_Oxi_2", -1);
	    prefEditor.putString("HE_8", "F");   prefEditor.putFloat("HE_MM_8",  (float) 18.998);	prefEditor.putInt("F_Oxi_1", -1);
	    prefEditor.putString("HE_9", "Na");  prefEditor.putFloat("HE_MM_9",  (float) 22.990);	prefEditor.putInt("Na_Oxi_1", 1);
	    prefEditor.putString("HE_10","Mg");  prefEditor.putFloat("HE_MM_10", (float) 24.312);	prefEditor.putInt("Mg_Oxi_1", 2);
	    prefEditor.putString("HE_11","Al");  prefEditor.putFloat("HE_MM_11", (float) 26.982);	prefEditor.putInt("Al_Oxi_1", 3);
	    prefEditor.putString("HE_12","Si");  prefEditor.putFloat("HE_MM_12", (float) 28.086);	prefEditor.putInt("Si_Oxi_1", -4);	prefEditor.putInt("Si_Oxi_2", 4);
	    prefEditor.putString("HE_13","P");   prefEditor.putFloat("HE_MM_13", (float) 30.974);	prefEditor.putInt("P_Oxi_1", 5);	prefEditor.putInt("P_Oxi_2", -3);	prefEditor.putInt("P_Oxi_3", 3);
	    prefEditor.putString("HE_14","S");   prefEditor.putFloat("HE_MM_14", (float) 32.064);	prefEditor.putInt("S_Oxi_1", 6);	prefEditor.putInt("S_Oxi_2", -2);	prefEditor.putInt("S_Oxi_3", 2);	prefEditor.putInt("S_Oxi_4", 4);
	    prefEditor.putString("HE_15","Cl");  prefEditor.putFloat("HE_MM_15", (float) 35.453);	prefEditor.putInt("Cl_Oxi_1", -1);	prefEditor.putInt("Cl_Oxi_2", 1);	prefEditor.putInt("Cl_Oxi_3", 3);	prefEditor.putInt("Cl_Oxi_4", 5);	prefEditor.putInt("Cl_Oxi_5", 7);
	    prefEditor.putString("HE_16","K");   prefEditor.putFloat("HE_MM_16", (float) 39.102);	prefEditor.putInt("K_Oxi_1", 1);
	    prefEditor.putString("HE_17","Ca");  prefEditor.putFloat("HE_MM_17", (float) 40.08);	prefEditor.putInt("Ca_Oxi_1", 2);
	    prefEditor.putString("HE_18","Ga");  prefEditor.putFloat("HE_MM_18", (float) 69.72);	prefEditor.putInt("Ga_Oxi_1", 3);
	    prefEditor.putString("HE_19","Ge");  prefEditor.putFloat("HE_MM_19", (float) 72.59);	prefEditor.putInt("Ge_Oxi_1", 4);	prefEditor.putInt("Ge_Oxi_2", 2);
	    prefEditor.putString("HE_20","As");  prefEditor.putFloat("HE_MM_20", (float) 74.922);	prefEditor.putInt("As_Oxi_1", 3);
	    prefEditor.putString("HE_21","Se");  prefEditor.putFloat("HE_MM_21", (float) 78.96);	prefEditor.putInt("Se_Oxi_1", 4);
	    prefEditor.putString("HE_22","Br");  prefEditor.putFloat("HE_MM_22", (float) 79.909);	prefEditor.putInt("Br_Oxi_1", -1);
	    prefEditor.putString("HE_23","Rb");  prefEditor.putFloat("HE_MM_23", (float) 85.47);	prefEditor.putInt("Rb_Oxi_1", 1);
	    prefEditor.putString("HE_24","Sr");  prefEditor.putFloat("HE_MM_24", (float) 87.62);	prefEditor.putInt("Sr_Oxi_1", 2);
	    prefEditor.putString("HE_25","In");  prefEditor.putFloat("HE_MM_25", (float) 114.82);	prefEditor.putInt("In_Oxi_1", 3);
	    prefEditor.putString("HE_26","Sn");  prefEditor.putFloat("HE_MM_26", (float) 118.69);	prefEditor.putInt("Sn_Oxi_1", 2);
	    prefEditor.putString("HE_27","Sb");  prefEditor.putFloat("HE_MM_27", (float) 121.75);	prefEditor.putInt("Sb_Oxi_1", 3);
	    prefEditor.putString("HE_28","Te");  prefEditor.putFloat("HE_MM_28", (float) 127.60);	prefEditor.putInt("Te_Oxi_1", 4);
	    prefEditor.putString("HE_29","I");   prefEditor.putFloat("HE_MM_29", (float) 126.90);	prefEditor.putInt("I_Oxi_1", -1);
	    prefEditor.putString("HE_30","Cs");  prefEditor.putFloat("HE_MM_30", (float) 132.91);	prefEditor.putInt("Cs_Oxi_1", 1);
	    prefEditor.putString("HE_31","Ba");  prefEditor.putFloat("HE_MM_31", (float) 137.34);	prefEditor.putInt("Ba_Oxi_1", 2);
	    prefEditor.putString("HE_32","Tl");  prefEditor.putFloat("HE_MM_32", (float) 204.38);	prefEditor.putInt("Tl_Oxi_1", 1);
	    prefEditor.putString("HE_33","Pb");  prefEditor.putFloat("HE_MM_33", (float) 207.19);	prefEditor.putInt("Pb_Oxi_1", 2);
	    prefEditor.putString("HE_34","Bi");  prefEditor.putFloat("HE_MM_34", (float) 208.98);	prefEditor.putInt("Bi_Oxi_1", 3);
	    prefEditor.putString("HE_35","Po");  prefEditor.putFloat("HE_MM_35", (float) 210.0);	prefEditor.putInt("Po_Oxi_1", 4);
	    prefEditor.putString("HE_36","At");  prefEditor.putFloat("HE_MM_36", (float) 210.0);	prefEditor.putInt("At_Oxi_1", -1);
	    prefEditor.putString("HE_37","Fr");  prefEditor.putFloat("HE_MM_37", (float) 223.0);	prefEditor.putInt("Fr_Oxi_1", 1);
	    prefEditor.putString("HE_38","Ra");  prefEditor.putFloat("HE_MM_38", (float) 226.0);	prefEditor.putInt("Ra_Oxi_1", 2);
	    prefEditor.putString("NE_2","Sc");   prefEditor.putFloat("NE_MM_2",  (float) 44.956);	prefEditor.putInt("Sc_Oxi_1", 3);
	    prefEditor.putString("NE_3","Ti");   prefEditor.putFloat("NE_MM_3",  (float) 47.88);	prefEditor.putInt("Ti_Oxi_1", 4);
	    prefEditor.putString("NE_4","V");    prefEditor.putFloat("NE_MM_4",  (float) 50.942);	prefEditor.putInt("V_Oxi_1", 5);
	    prefEditor.putString("NE_5","Cr");   prefEditor.putFloat("NE_MM_5",  (float) 51.996);	prefEditor.putInt("Cr_Oxi_1", 3);
	    prefEditor.putString("NE_6","Mn");   prefEditor.putFloat("NE_MM_6",  (float) 54.938);	prefEditor.putInt("Mn_Oxi_1", 2);
	    prefEditor.putString("NE_11","Fe");  prefEditor.putFloat("NE_MM_11", (float) 55.847);	prefEditor.putInt("Fe_Oxi_1", 3);
	    prefEditor.putString("NE_12","Co");  prefEditor.putFloat("NE_MM_12", (float) 58.933);	prefEditor.putInt("Co_Oxi_1", -1);
	    prefEditor.putString("NE_13","Ni");  prefEditor.putFloat("NE_MM_13", (float) 58.69);	prefEditor.putInt("Ni_Oxi_1", 2);
	    prefEditor.putString("NE_14","Cu");  prefEditor.putFloat("NE_MM_14", (float) 63.54);	prefEditor.putInt("Cu_Oxi_1", 2);
	    prefEditor.putString("NE_15","Zn");  prefEditor.putFloat("NE_MM_15", (float) 65.37);	prefEditor.putInt("Zn_Oxi_1", 2);
	    prefEditor.putString("NE_16","Y");   prefEditor.putFloat("NE_MM_16", (float) 88.905);	prefEditor.putInt("Y_Oxi_1", 3);
	    prefEditor.putString("NE_17","Zr");  prefEditor.putFloat("NE_MM_17", (float) 91.22);	prefEditor.putInt("Zr_Oxi_1", 4);
	    prefEditor.putString("NE_18","Nb");  prefEditor.putFloat("NE_MM_18", (float) 92.906);	prefEditor.putInt("Nb_Oxi_1", 5);
	    prefEditor.putString("NE_19","Mo");  prefEditor.putFloat("NE_MM_19", (float) 95.94);	prefEditor.putInt("Mo_Oxi_1", 6);
	    prefEditor.putString("NE_20","Tc");  prefEditor.putFloat("NE_MM_20", (float) 99.0);		prefEditor.putInt("Tc_Oxi_1", 7);
	    prefEditor.putString("NE_25","Ru");  prefEditor.putFloat("NE_MM_25", (float) 101.07);	prefEditor.putInt("Ru_Oxi_1", 3);
	    prefEditor.putString("NE_26","Rh");  prefEditor.putFloat("NE_MM_26", (float) 102.91);	prefEditor.putInt("Rh_Oxi_1", 1);
	    prefEditor.putString("NE_27","Pd");  prefEditor.putFloat("NE_MM_27", (float) 106.42);	prefEditor.putInt("Pd_Oxi_1", 2);
	    prefEditor.putString("NE_28","Ag");  prefEditor.putFloat("NE_MM_28", (float) 107.87);	prefEditor.putInt("Ag_Oxi_1", 1);
	    prefEditor.putString("NE_29","Cd");  prefEditor.putFloat("NE_MM_29", (float) 112.40);	prefEditor.putInt("Cd_Oxi_1", 2);
	    prefEditor.putString("NE_30","La");  prefEditor.putFloat("NE_MM_30", (float) 138.91);	prefEditor.putInt("La_Oxi_1", 3);
	    prefEditor.putString("NE_31","Hf");  prefEditor.putFloat("NE_MM_31", (float) 178.49);	prefEditor.putInt("Hf_Oxi_1", 4);
	    prefEditor.putString("NE_32","Ta");  prefEditor.putFloat("NE_MM_32", (float) 180.95);	prefEditor.putInt("Ta_Oxi_1", 5);
	    prefEditor.putString("NE_33","W");   prefEditor.putFloat("NE_MM_33", (float) 183.85);	prefEditor.putInt("W_Oxi_1", 6);
	    prefEditor.putString("NE_34","Re");  prefEditor.putFloat("NE_MM_34", (float) 186.2);	prefEditor.putInt("Re_Oxi_1", 7);
	    prefEditor.putString("NE_39","Os");  prefEditor.putFloat("NE_MM_39", (float) 190.2);	prefEditor.putInt("Os_Oxi_1", 4);
	    prefEditor.putString("NE_40","Ir");  prefEditor.putFloat("NE_MM_40", (float) 192.2);	prefEditor.putInt("Ir_Oxi_1", -1);
	    prefEditor.putString("NE_41","Pt");  prefEditor.putFloat("NE_MM_41", (float) 195.09);	prefEditor.putInt("Pt_Oxi_1", 2);
	    prefEditor.putString("NE_42","Au");  prefEditor.putFloat("NE_MM_42", (float) 196.97);	prefEditor.putInt("Au_Oxi_1", 3);
	    prefEditor.putString("NE_43","Hg");  prefEditor.putFloat("NE_MM_43", (float) 200.59);	prefEditor.putInt("Hg_Oxi_1", 2);
	    prefEditor.apply();

		QuizFragen.erstelle_Quizfragen();

		strLevel = prefs.getString("Level", "1");
		strLevelCounter = prefs.getString("LevelCounter_"+strLevel, "0");
		intLevelCounter = Integer.parseInt(strLevelCounter);
		intLevelCounter = intLevelCounter + 1;
		strLevelCounter = Integer.toString(intLevelCounter);
		prefEditor.putString("LevelCounter_"+strLevel, strLevelCounter);
		prefEditor.apply();
		intLevel = Integer.parseInt(strLevel);

		if (intLevel <= 2) {
			tv = (TextView) findViewById(R.id.btnSZ_06);
			tv.setVisibility(View.INVISIBLE); // "Clear"-Schaltfläche UNSICHTBAR MACHEN
		}

		if (intLevel == 2)
		{
			tv = (TextView) findViewById(R.id.btnHauptgruppenelemente);
			btnHauptgruppenelemente(tv);
		}



		// ****************************************************
		// **** Hilfe Alert Dialog nur im ersten Durchgang ****
		// ****************************************************

		strQuizHilfe = prefs.getString("QuizHilfe", "1");
		strHighscore = prefs.getString("Highscore"+ strQuizHilfe, "0");
        int intQuizHilfe = Integer.parseInt(strQuizHilfe);

		if (strHighscore.equals("0") == true && intLevelCounter <= 2) // Dialogbox wird nur angezeigt, wenn der aktuelle Highscore noch 0 ist und das Level zum ersten oder zweiten Mal gespielt wurde.
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
			builder.setTitle("Hilfe zu Level " + strQuizHilfe);

			switch (intQuizHilfe) {
				case 1: 		builder.setMessage(getResources().getString(R.string.QuizHilfe_1)
						+" Ach so, diese Anleitung findest du übrigens auch in deiner Hilfe. So, und nun viel Spaß! Bist du bereit?");
					break;
				case 2:			if(intLevel == 2){builder.setMessage("Prima! Du hast Level 1 geschafft! "+getResources().getString(R.string.QuizHilfe_2)+" Kann es losgehen?");}
					break;
				case 3:			if(intLevel == 3){builder.setMessage("Super! Level 2 ist geknackt! "+getResources().getString(R.string.QuizHilfe_3)+" Startklar?");}
					break;
				case 4:			if(intLevel == 4){builder.setMessage("Hervorragend, du hast Level 3 geschafft. "+getResources().getString(R.string.QuizHilfe_4)+" Ready to Start?");}
					break;
				case 5:			if(intLevel == 5){builder.setMessage("Super gut! Das war schwer! Du hast Level 4 geschafft! "+getResources().getString(R.string.QuizHilfe_5)+" Ready?");}
					break;
				case 6:			if(intLevel == 6){builder.setMessage("Das war grandios! "+getResources().getString(R.string.QuizHilfe_6)+" Startklar?");}
					break;
				case 7:			if(intLevel == 7){builder.setMessage("Heureka! "+getResources().getString(R.string.QuizHilfe_7)+" Bist du soweit?");}
					break;
				case 8:			if(intLevel == 8){builder.setMessage("Das war hammergut! "+getResources().getString(R.string.QuizHilfe_8)+" Fertig?");}
					break;
				case 9:			if(intLevel == 9){builder.setMessage("Du bist absolute Spitzenklasse! "+getResources().getString(R.string.QuizHilfe_9)+" Achtung, letzter Level - Startklar!");}
					break;
			}

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
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		
		TextView tv;
		String strPSE; 
		
		tv = (TextView) findViewById(R.id.btnWeiter); // Button Oxidationstufen wird unsichtbar damit ohne Eingabe nicht abstürzt
		tv.setVisibility(View.INVISIBLE);
		
		tv = (TextView) findViewById(R.id.tvMolmasse);
		tv.setText("");
		
		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setText("");
		strPSE = prefs.getString("PSE", "Hauptgruppenelemente");

        intFrageNr = QuizFragen.ermittel_LfdNr(intLevel);
        QuizFragen.lese_Quizfrage(intLevel, intFrageNr);

        strFrage = QuizFragen.mFrage;
        strAntwort = QuizFragen.mAntwort;

        tv = (TextView) findViewById(R.id.tvMolmasse);
        tv.setText(strFrage);

        for (int x=0; x<=4; x++)
		{
            int viewId = getResources().getIdentifier("btnSZ_"+x, "id", getPackageName());
            tv = (TextView) findViewById(viewId);
			tv.setVisibility(View.INVISIBLE);
			prefEditor.putInt("btnSZ_0", 0);
		}
		
		if (intLevel > 2) {
            if (strPSE.equals("Hauptgruppenelemente") == true) {
                tv = (TextView) findViewById(R.id.btnPSE_43);
                tv.setText("(");
                tv.setVisibility(View.VISIBLE);
            }
        }

		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setText("");
		
		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		prefEditor.putFloat("Molmasse", 0);
		prefEditor.apply();
		
		/*		*************************************************
		 * 			Hier Wird die Textgröße eingestellt         
		 *      *************************************************
		 */	
				
		String strFeldname;

		String strTextSize = prefs.getString("TG_Molmasse", "16");
		String strButtonhoehe = prefs.getString("BH_Molmasse", "130");

		intTextSize = Integer.parseInt(strTextSize);
		int intButtonhoehe = Integer.parseInt(strButtonhoehe);

		tv = (TextView) findViewById(R.id.timerTextView);
		tv.setTextSize(intTextSize+4);

		tv = (TextView) findViewById(R.id.tvMolmasse);
		tv.setTextSize(intTextSize);

		tv = (TextView) findViewById(R.id.tvPunkte);
		tv.setTextSize(intTextSize+4);

		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setTextSize(intTextSize);

		tv = (TextView) findViewById(R.id.btnWeiter);
		tv.setTextSize(intTextSize);

		for (int x=1; x<=43; x++)
		{
			strFeldname = "btnPSE_";
			if (x < 10)																		// Wenn der ID Nr kleiner als 10 (einstellig)....
			{
				strFeldname = strFeldname + "0";											// ... dann neuer Feldname "btnPSE_0"
				}

			int resId = getResources().getIdentifier(strFeldname+x, "id", getPackageName());
			tv = (TextView) findViewById(resId);

			// Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-(
			LayoutParams params = (LayoutParams) tv.getLayoutParams();
			params.height = intButtonhoehe;
			tv.setLayoutParams(params);

			tv.setTextSize(intTextSize);
		}

		for (int x=0; x<=4; x++)
		{
			int resId = getResources().getIdentifier("btnSZ_"+x, "id", getPackageName());
			tv = (TextView) findViewById(resId);

			// Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-(
			LayoutParams params = (LayoutParams) tv.getLayoutParams();
			params.height = intButtonhoehe;
			tv.setLayoutParams(params);

			tv.setTextSize(intTextSize);
		}

		tv = (TextView) findViewById(R.id.btnSZ_06);
		// Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-(
		LayoutParams params = (LayoutParams) tv.getLayoutParams();
		params.height = intButtonhoehe;
		tv.setLayoutParams(params);

		tv.setTextSize(intTextSize);

		tv = (TextView) findViewById(R.id.btnHauptgruppenelemente);
		// Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-(
		params.height = intButtonhoehe;
		tv.setLayoutParams(params);

		tv.setTextSize(intTextSize-1);

		tv = (TextView) findViewById(R.id.btnHauptgruppenelemente);
		if (intLevel < 3) {
			tv.setVisibility(View.INVISIBLE); // TEXTFELD UNSICHTBAR MACHEN
		}
		else
		{
			tv.setVisibility(View.VISIBLE); // TEXTFELD SICHTBAR MACHEN
		}

	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		
		float fltMM;
		String strMolmasse;
		String strMM_Molaritaet;
		String strMM_Substanz;
		String strPSE;
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 
		
		strMM_Molaritaet = prefs.getString("MolaritaetEG_1", "");
		strMM_Substanz = prefs.getString("Molmasse_Substanz", "");
		fltMM = prefs.getFloat("Molmasse", 0);	
		strPSE = prefs.getString("PSE", "Hauptgruppenelemente");
		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		
		if(fltMM  == 0.0)
		{
			strMolmasse = "";
		}
		else
		{
			strMolmasse = Float.toString(fltMM);
		}
		
		if(strMM_Molaritaet.equals("Wert") == true)
		{
			prefEditor.putString("MolaritaetEG_1", strMolmasse);
		}

		if(strMM_Substanz.equals("Wert") == true)
		{
			prefEditor.putString("Molmasse_Substanz", strMolmasse);
		}
		
		prefEditor.apply();
		
		for (int x=0; x<=4; x++)
		{
            int viewId = getResources().getIdentifier("btnSZ_"+x, "id", getPackageName());
            tv = (TextView) findViewById(viewId);
			tv.setVisibility(View.INVISIBLE);
			prefEditor.putInt("btnSZ_0", 0);
		}

		if (intLevel > 2) {
            if (strPSE.equals("Hauptgruppenelemente") == true) {
                tv = (TextView) findViewById(R.id.btnPSE_43);
                tv.setText("(");
                tv.setVisibility(View.VISIBLE);
            }
        }
	} // onPause


	 /************************************************************************************
	  ************** Button Haupt- / Nebengruppenelemente ********************************
	  *************************************************************************************/
	
	public void btnHauptgruppenelemente (View v) 
	{
		String strPSE = "";
		String strPSE2 = "";
		String strElement; 
		String strFeldname;
		String strZahl;
		int intRK_auf;
		int intbtnSZ_0;
		float fltMM_RK;
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 

		intRK_auf = prefs.getInt("Runde_Klammer_auf", 0);
		strPSE = prefs.getString("PSE", "Hauptgruppenelemente"); 							// Die Konfigurationsdatei PSE wird ausgelesen. Haupt- oder Nebengruppenelemente
		intbtnSZ_0 = prefs.getInt("btnSZ_0", 0);
		fltMM_RK = prefs.getFloat("Molmasse_Runde_Klammer", 0);
		
		// ******************************************************
		// *** Anzeige Routine für den Button SZ_0 (0 oder 5) ***
		// ******************************************************

		if (intLevel > 2) {
			if (strPSE.equals("Hauptgruppenelemente"))				// Istzustand: Nebengruppenelemente
			{
				if (intbtnSZ_0 == 0)
				{
					tv = (TextView) findViewById(R.id.btnSZ_0); 	// bei den Nebengruppen wird die 5 ausgeblendet, wenn noch kein Element angezeigt wird.
					tv.setVisibility(View.INVISIBLE);
				}
				else // intbtnSZ_0 == 1 oder 2
				{
					tv = (TextView) findViewById(R.id.btnSZ_0); 	// bei den Nebengruppen wird die 5 angezeigt, wenn ein Element oder eine Zahl angezeigt wird.
					tv.setVisibility(View.VISIBLE);
				}
			}
			else													// Istzustand: Hauptgruppenelemente
			{
				if (intbtnSZ_0 == 2) {
					tv = (TextView) findViewById(R.id.btnSZ_0);    // bei den Hauptgruppen wird die 0 angezeigt, wenn eine Zahl angezeigt wird.
					tv.setVisibility(View.VISIBLE);
				} else // intbtnSZ_0 == 0 oder 1
				{
					tv = (TextView) findViewById(R.id.btnSZ_0);    // bei den Hauptgruppen wird die 0 ausgeblendet, wenn noch kein Element oder noch keine Zahl angezeigt wird.
					tv.setVisibility(View.INVISIBLE);
				}
			}
		}
		
		// **************************************************************
		// ************ Schleife für 43 Element Buttons *****************
		// **************************************************************
		
		for (int x=1; x<=43; x++)															 
		{
			if (strPSE.equals("Hauptgruppenelemente" ) == true)								// Wenn PSE Hauptgruppenelemente...
			{
				strPSE2="Nebengruppenelemente";												// String strPSE2 wird auf Nebengruppenelemente gestellt (Istzustand!!!!)	
				strElement = prefs.getString("NE_"+x, "");									// String strElement wird aus Konfig Datei (NE und Button Nr ID) ausgelesen
			}	
			else																			// Wenn PSE Nebengruppenelemente...
			{
				strPSE2="Hauptgruppenelemente";												// String strPSE2 wird auf Hauptgruppenelemente gestellt (Istzustand!!!!)	
				strElement = prefs.getString("HE_"+x, ""); 									// String strElement wird aus Konfig Datei (HE und Button Nr ID) ausgelesen
			}	
			strFeldname = "btnPSE_";
			if (x < 10)																		// Wenn der ID Nr kleiner als 10 (einstellig)....
			{
				strFeldname = strFeldname + "0";											// ... dann neuer Feldname "btnPSE_0"
			}
			
	    	int resId = getResources().getIdentifier(strFeldname+x, "id", getPackageName());// Die resId wird aus dem Feldnamen und der ButtonNr ermittelt
			tv = (TextView) findViewById(resId);											
			tv.setText(strElement);															// und mit dem Elementnamen gefüllt und ausgegeben
			
			if (strElement.equals("") == false)												// Wenn der String strElement mit einem Text gefüllt ist...
			{																				
				tv.setVisibility(View.VISIBLE);
				tv.setTextColor(getResources().getColor(R.color.cSchwarz));
				switch (Element.valueOf(strElement))										// String strElement wird Element zugewiesen...
				{
				case H:																		// ... stringt bei Element H hierhin...
					tv.setBackgroundColor(getResources().getColor(R.color.cHellgruen));		// ... und setzt die Hintergrundfarbe auf hellgrün
					break;
				case C:
				case N:
				case O:
				case F:
				case P:
				case S:
				case Cl:
				case Se:
				case Br:
				case I:
					tv.setBackgroundColor(getResources().getColor(R.color.cOrange));		// Hintergrundfarbe der Elemente C,N,O,F,P,.... auf hellgrün
					break;			
				case B:
				case Si:
				case Ge:
				case As:
				case Sb:
				case Te:
				case At:
					tv.setBackgroundColor(getResources().getColor(R.color.cHellorange));
					break;
				default:
					tv.setBackgroundColor(getResources().getColor(R.color.cHellblau));
					break;
				}
				tv.invalidate(); // Invalidate the whole view. If the view is visible, onDraw(android.graphics.Canvas) will be called at some point in the future. 
			}
			else																			// Wenn der String strElement NICHT mit einem Text gefüllt ist...
			{
				if (strPSE2.equals("Hauptgruppenelemente"))
				{
					switch (x)																// ... werden folgende Felder unsichtbar gemacht.
					{
					case 39: 
						tv.setVisibility(View.INVISIBLE);									
						break;
					case 40:	
						tv.setVisibility(View.INVISIBLE);
						break;
					case 41:	
						tv.setVisibility(View.INVISIBLE);
						break;
					case 42:
						tv.setVisibility(View.INVISIBLE);
						break;
					case 43:																 
						if (intRK_auf == 1)
						{
							if (fltMM_RK == 0)									// Klammer "zu" wird erst dann angezeigt, wenn die Klammer einen Wert enthällt.
							{
								tv = (TextView) findViewById(R.id.btnPSE_43);	// Keinen Wert: Klammer Button wird ausgeblendet
								tv.setVisibility(View.INVISIBLE);
							}
							else
							{
								tv = (TextView) findViewById(R.id.btnPSE_43);	// Wert: Klammer Button zu wird angezeigt
								tv.setText(")");
								tv.setVisibility(View.VISIBLE);
							}
							tv.setText(")");
							break;
						}
						else
						{
							tv.setText("(");
							break;
						}
					}
					switch (x)
					{
					case 43:
						tv.setBackgroundColor(getResources().getColor(R.color.cDunkelgrau));
						tv.setTextColor(getResources().getColor(R.color.cEingabe));
						break;
					}
				}
				else
				{
					tv.setVisibility(View.INVISIBLE);
				}
			}
		} // for (int x=1; x<=43; x++)
		
		// **************************************************************
		// ************ Schleife für 5 Zahlen Buttons *******************
		// **************************************************************
		
		for (int x=0; x<=4; x++)
		{
			if (strPSE2.equals("Hauptgruppenelemente"))
			{
				strZahl = Integer.toString((int) x);				// bei Hauptgruppenelementen: Zahlen 0 bis 4
			}
			else
			{
				strZahl = Integer.toString((int) x + 5);			// bei Nebengruppenelementen: Zahlen 5 bis 9
			}	
			
	   		int resId = getResources().getIdentifier("btnSZ_"+(x), "id", getPackageName());
		    tv = (TextView) findViewById(resId);
			tv.setText(strZahl);
		}
		
		tv = (TextView) findViewById(R.id.btnHauptgruppenelemente);
		tv.setText(strPSE2);

		prefEditor.putString("PSE", strPSE2);
		prefEditor.apply();
    } // btnHauptgruppenelemente

	 /************************************************************************************
	  ******************************* Button Element *************************************
	  ************************************************************************************/
	
	public void btnPSE(View v) 
	{
		String strElement;
		String strFormel;
		String strKey;
		String strPSE; 
		String strFeldname;
		String strMM;
		String strIndex;
		int intFeldNr;
		int intZeilenNr;
		int intIndex;
		int intRK_auf;
		int intAnzahlElemente;
		Float fltMM;
		Float fltMM_RK;
		Float fltAtommasse;
		Float fltMolekuelmasse;
		Float fltMolekuelmasse_RK;

		final MediaPlayer mpTonRichtig = MediaPlayer.create(this, R.raw.glocke_1);
		final MediaPlayer mpTonHighScore = MediaPlayer.create(this, R.raw.hupe);


		tv = (TextView) findViewById(R.id.timerTextView);
		if (tv.getText().equals("END"))
		{
			return;
		}



		tv = (TextView) v;
		strElement = tv.getText().toString();
		if (strElement.equals("") == false)
		{
			tv = (TextView) findViewById(R.id.tvFormel);
			strFormel = tv.getText().toString();
			
			strFormel = strFormel + strElement;

			strFormel = ActivityTools.fktZiffernTiefstellen(strFormel);

			tv.setText(Html.fromHtml(strFormel));

			// Tabelle mit Oxidationszahlen füllen
			// nächste zu füllende ZeilenNr ermitteln
			// siehe: http://board.gulli.com/thread/1560742-wie-man-in-java-mit-einfachen-und-mehrdimensionalen-arrays-arbeitet/
			for (intZeilenNr=0; intZeilenNr<=arrOxi.length; intZeilenNr++)
			{				
				if (arrOxi[intZeilenNr][0] == 0)
				{
					break;
				};
				
			}
			
		} // if (strElement.equals("") == false)
		
	
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		intRK_auf = prefs.getInt("Runde_Klammer_auf", 0);
		intAnzahlElemente = prefs.getInt("AnzahlElemente", 0); 
		strPSE = prefs.getString("PSE", "Hauptgruppenelemente"); 
		strIndex = prefs.getString("Index", "");
		fltAtommasse = prefs.getFloat("Atommasse", 0);							// Die "alte" Atommasse wird aus Konfig Datei ausgelesen
		fltMolekuelmasse = prefs.getFloat("Molekuelmasse", 0);					// Die Molekülmasse wird aus Konfig Datei ausgelesen
		fltMolekuelmasse_RK = prefs.getFloat("Molekuelmasse_Runde_Klammer", 0);	// Die Molekülmasse wird aus Konfig Datei ausgelesen
		fltMM = prefs.getFloat("Molmasse", 0);									// Die Molmasse wird aus Konfig Datei ausgelesen
		fltMM_RK = prefs.getFloat("Molmasse_Runde_Klammer", 0);
		
		
		if(strElement.equals("("))	
		{
			intRK_auf = 1;
			fltMM_RK = (float) 0;
			
			for (int x=0; x<=4; x++)
			{
                int viewId = getResources().getIdentifier("btnSZ_"+x, "id", getPackageName());
                tv = (TextView) findViewById(viewId);
				tv.setVisibility(View.INVISIBLE);
				prefEditor.putInt("btnSZ_0", 0);
			}
		}
		if(strElement.equals(")"))	
		{
			intRK_auf = 2;
		}
		
		// ****************************************************************
		// ********* Button: Eingabe Element oder Klammer *****************
		// ****************************************************************
		
		if (strElement.matches("[0-9]") == false)						// Wenn ein Element ausgewählt wird.
		{
			if (strPSE.equals("Hauptgruppenelemente" ) == true)			// Anzeige Routine für den Button SZ_0 (0 oder 5)
			{
				if (strElement.equals("(") == false)
				{
					tv = (TextView) findViewById(R.id.btnSZ_0);				// Wird ein bei den Hauptgruppenelementen ein Element eingegeben
					tv.setVisibility(View.INVISIBLE);						// wird die "0" ausgeblendet
					prefEditor.putInt("btnSZ_0", 1);						// Zustand wird in den Speicher übertragen, falls zu den Nebengruppenelementen gewechselt wird
					
					if (strElement.equals(")") == false)
					{
						intAnzahlElemente = intAnzahlElemente +1;			// AnzahlElemente wird um 1 addiert
					}
				}
			}
			else
			{
				if (intLevel > 2) {
					tv = (TextView) findViewById(R.id.btnSZ_0);                // Wird ein bei den Nebengruppenelementen ein Element eingegeben
					tv.setVisibility(View.VISIBLE);                            // wird die "5" eingeblendet
					prefEditor.putInt("btnSZ_0", 1);                        // Zustand wird in den Speicher übertragen, falls zu den Hauptgruppenelementen gewechselt wird
				}
				intAnzahlElemente = intAnzahlElemente +1;				// AnzahlElemente wird um 1 addiert
			}


            prefEditor.putString("Index", "");						// Der Index wird zurück gesetzt, weil ein neues Element ausgelesen wird

            if (strPSE.equals("Hauptgruppenelemente" ) == true)
            {
                strKey = "HE_";
            }
            else
            {
                strKey = "NE_";
            }
            strFeldname = getResources().getResourceName(v.getId());
            intFeldNr = Integer.parseInt(strFeldname.substring(strFeldname.length()-2));

            strKey = strKey + "MM_"+Integer.toString(intFeldNr);

            fltAtommasse = prefs.getFloat(strKey, 0);				// Atommasse des gesuchten Elements aus der "Datenbank"

            switch (intRK_auf)										// Auswahl runde Klammer
            {
            case 0:													// 0 , wenn die Klammer zu ist

                fltMolekuelmasse = fltAtommasse;					// Die Molekuelmasse wird errechnet.
                fltMolekuelmasse_RK = (float) 0;
                fltMM = fltMM + fltMolekuelmasse;

            break;

            case 1:													// 1 , wenn die Klammer offen ist

                fltMolekuelmasse_RK = fltAtommasse;					// Die Molekuelmasse wird errechnet.
                fltMM_RK = fltMM_RK + fltMolekuelmasse_RK;
                fltMM = fltMM + fltMolekuelmasse_RK;

            break;

            case 2:													// 2 , wenn die Klammer geschlossen ist

                if (strElement.equals(")") == false)				// die Klammer ist geschlossen und ein neues Element wird eingegeben
                {
                    intRK_auf = 0;
                    fltMM_RK = (float) 0;
                    fltMolekuelmasse = fltAtommasse;
                    fltMM = fltMM + fltMolekuelmasse;
                }

            break;
            } // switch (intRK_auf)

            fltMM = ActivityTools.fktRundenFloat(fltMM, 3);
        } // if (strElement.matches("[0-9]") == false)
		
		// ************************************************
		// ********* Button: Eingabe Zahl *****************
		// ************************************************	
		
		if (strElement.matches("[0-9]") == true)						
		{	
			tv = (TextView) findViewById(R.id.btnSZ_0);
			tv.setVisibility(View.VISIBLE);
			prefEditor.putInt("btnSZ_0", 2);

			if (strIndex.equals("") == true)						// Wenn der Index String keinen Wert enthällt, dann ...
			{														// Also wenn die Zahl eine Einerpotenz ist.
				intIndex = Integer.parseInt(strElement); 			// Der String Index wird in einen Integer Index umgewandelt				
			}
			
			else													// Wenn der Index String einen Wert enthällt, dann ...
			{														// Also wenn die Zahl eine Zehnerpotenz ist.
				strElement = strIndex + strElement;					// Die neue zusammengesetzte Zahl
				intIndex = Integer.parseInt(strElement);			// wird zum neuen Index						
			}	

			switch (intRK_auf)
			{
			case 0:
				
				fltMM = fltMM - fltMolekuelmasse;						// Die alte Molekuelmasse wird wieder von der Molmasse abgezogen
				
				fltMolekuelmasse = fltAtommasse * intIndex;				// Die Molekuelmasse wird errechnet. (Atommasse * Index )
				
				fltMM = fltMM + fltMolekuelmasse;
				
			break;
			
			case 1:
				
				fltMM_RK = fltMM_RK - fltMolekuelmasse_RK;				// Die alte Molekuelmasse wird wieder von der Molmasse abgezogen
				
				fltMM = fltMM - fltMolekuelmasse_RK;					// Die alte Molekülmasse wird von der Molmasse abgezogen, weil sie neu mit dem Index berechnet wird
				
				fltMolekuelmasse_RK = fltAtommasse * intIndex;			// Die Molekuelmasse wird errechnet. (Atommasse * Index )
				
				fltMM_RK = fltMM_RK + fltMolekuelmasse_RK;
				
				fltMM = fltMM + fltMolekuelmasse_RK;
				
			break;
			
			case 2:
				
				if (strIndex.equals("") == true)						// Wenn der Index String keinen Wert enthällt, dann ...
				{
					fltMM = fltMM - fltMM_RK;						
					
					fltMolekuelmasse_RK = fltMM_RK;
					
					fltMM_RK = fltMM_RK * intIndex;				
		
					fltMM = fltMM + fltMM_RK;
				}
				
				else
				{
					fltMM = fltMM - fltMM_RK;						
					
					fltMM_RK = fltMolekuelmasse_RK * intIndex;			// Die Molekuelmasse wird errechnet. (Atommasse * Index )
					
					fltMM = fltMM + fltMM_RK;
				}
				
			break;
			} // switch (intRK_auf)

            fltMM = ActivityTools.fktRundenFloat(fltMM, 3);

			prefEditor.putString("Index", strElement); 					// Die Index Zahl wird in die Konfig Datei gespeichert, falls eine weitere Zahl als 10er Potenz eingegeben wird.
		} // if (strElement.matches("[0-9]") == true)
		
		// ************************************************
		// ********* Anzeige der Buttons ******************
		// ************************************************	
		
	
		if (strElement.equals("") == false)
			{
				tv = (TextView) findViewById(R.id.btnWeiter);
				tv.setVisibility(View.VISIBLE);
			}

		if (intLevel > 2) {
			for (int x=1; x<=4; x++) {
				if (strElement.equals("(") == false) {
					int viewId = getResources().getIdentifier("btnSZ_" + x, "id", getPackageName());
					tv = (TextView) findViewById(viewId);
					tv.setVisibility(View.VISIBLE);
				}
			}
		}

		if (strPSE.equals("Hauptgruppenelemente" ) == true)
		{
			if (intRK_auf == 1)
			{
				if (fltMM_RK == 0)									// Klammer zu wird erst dann angezeigt, wenn die Klammer einen Wert enthällt.
				{
					tv = (TextView) findViewById(R.id.btnPSE_43);	// Keinen Wert: Klammer Button wird ausgeblendet
					tv.setVisibility(View.INVISIBLE);
				}
				else
				{
					tv = (TextView) findViewById(R.id.btnPSE_43);	// Wert: Klammer Button zu wird angezeigt
					tv.setText(")");
					tv.setVisibility(View.VISIBLE);
				}
			}
			
			else
			{
				if (intLevel > 2) {
                    tv = (TextView) findViewById(R.id.btnPSE_43);
                    tv.setText("(");
                    tv.setVisibility(View.VISIBLE);
                }
			}
		}

        // ********************************************************************
        // ********* Vergleich der Eingabe mit der strAntwort *****************
        // ********************************************************************

		strMM = Float.toString(fltMM);
		if(strMM.equals(strAntwort))
		{
			mpTonRichtig.start();

			if (intLevel > 2)
			{
				String text = "\n   Super!   \n   Richtig!   \n";
				Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
				Meldung.setGravity(Gravity.BOTTOM, 0, 0);
				Meldung.show();
			}

			if (intLevel == 3)
			{
				intPunkte = intPunkte + 3;
			}
			if (intLevel > 3)
			{
				intPunkte = intPunkte + 6;
			}
			else
			{
				intPunkte = intPunkte + 1;
			}

			intFrageNr = QuizFragen.ermittel_LfdNr(intLevel);
			QuizFragen.lese_Quizfrage(intLevel, intFrageNr);

			strFrage = QuizFragen.mFrage;
			strAntwort = QuizFragen.mAntwort;

			tv = (TextView) findViewById(R.id.tvMolmasse);
			tv.setText(strFrage);

			// Formel-Feld leeren
			tv = (TextView) findViewById(R.id.tvFormel);
			tv.setText("");

			strHighscore = prefs.getString("Highscore"+strLevel, "0");

			intHighscore = Integer.parseInt(strHighscore);

			strPunkte = Integer.toString(intPunkte);

			tv = (TextView) findViewById(R.id.tvPunkte);
			tv.setText(" " +strPunkte + " ");

            if(intHupe == 0 && intPunkte >= 15 && intHighscore < intPunkte)     // spielt Hupe, wenn der Level geknackt wurde
            {
                mpTonHighScore.start();
                intHupe = 1;
            }

			prefEditor.putInt("Runde_Klammer_auf", 0);
			prefEditor.putInt("AnzahlElemente", 0);
			prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
			prefEditor.putFloat("Molmasse", 0);
			prefEditor.apply();
		}
        else
        {
			// Antwort ist falsch
            if (intLevel < 3)
            {
				Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vi.vibrate(400);  // vibriert für 400ms

                // Formel-Feld leeren
                tv = (TextView) findViewById(R.id.tvFormel);
                tv.setText("");

				prefEditor.putInt("Runde_Klammer_auf", 0);
				prefEditor.putInt("AnzahlElemente", 0);
				prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
				prefEditor.putFloat("Molmasse", 0);
				prefEditor.apply();

            }
			if (intLevel > 2)
			{
				// ************************************************
				// ********* Auslesen der Formel ******************
				// ************************************************

				tv = (TextView) findViewById(R.id.tvFormel);
				strFormel = tv.getText().toString();

				// *************************************************************
				// ********* Auslesen der Anzahl der Elemente ******************
				// *************************************************************

				prefEditor.putInt("Runde_Klammer_auf", intRK_auf);
				prefEditor.putInt("AnzahlElemente", intAnzahlElemente);
				prefEditor.putFloat("Molekuelmasse_Runde_Klammer", fltMolekuelmasse_RK);
				prefEditor.putFloat("Molmasse_Runde_Klammer", fltMM_RK);
				prefEditor.putFloat("Atommasse", fltAtommasse);
				prefEditor.putFloat("Molekuelmasse", fltMolekuelmasse);
				prefEditor.putFloat("Molmasse", fltMM);
				prefEditor.putString("Formel", strFormel);

				prefEditor.apply();
			}

        }

        if (startTime == 0) {
			startTime = System.currentTimeMillis() + 60000; // Countdown x/1000 Sekunden
			timerHandler.postDelayed(timerRunnable, 0);
		}
	} // btnPSE
	
	
	 /************************************************************************************
	  ******************************* Button "Clear" *************************************
	  ************************************************************************************/
	
	public void btnSZ_06(View v)
	{
		String strPSE; 
				
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		
		strPSE = prefs.getString("PSE", "Hauptgruppenelemente");
		
		tv = (TextView) findViewById(R.id.btnWeiter); // Button Oxidationstufen wird unsichtbar damit ohne Eingabe nicht abstürzt
		tv.setVisibility(View.INVISIBLE);
		
		for (int x=0; x<=4; x++)        // Zahlen werden unsichtbar gemacht
		{
            int viewId = getResources().getIdentifier("btnSZ_"+x, "id", getPackageName());
            tv = (TextView) findViewById(viewId);
			tv.setVisibility(View.INVISIBLE);
			prefEditor.putInt("btnSZ_0", 0);
		}

		if (intLevel > 2) {
            if (strPSE.equals("Hauptgruppenelemente" ) == true) {
                tv = (TextView) findViewById(R.id.btnPSE_43);
                tv.setText("(");
                tv.setVisibility(View.VISIBLE);
            }
		}

        tv = (TextView) findViewById(R.id.btnWeiter);
        tv.setVisibility(View.VISIBLE);

		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setText("");
		
		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putInt("AnzahlElemente", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		prefEditor.putFloat("Molmasse", 0);
		prefEditor.apply();
    } // btnSZ_06
	
	
	 /************************************************************************************
	  ******************************* Button "Weiter" ************************************
	  ************************************************************************************/
	
	public void btnWeiter(View v) 
	{
        if (QuizFragen.mAntwortText != null)			// Wenn Antwort nicht gewusst
        {
			// Textgröße einstellen
        	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			SharedPreferences.Editor prefEditor = prefs.edit();

			String strTextSize = prefs.getString("TG_Molmasse", "16");
			int intTextSize = Integer.parseInt(strTextSize);

			// Text tiefer stellen
			strAntwortText = QuizFragen.mAntwortText;
			strAntwortText = ActivityTools.fktZiffernTiefstellen(strAntwortText);

			// Toast anzeigen
        	Toast toast = new Toast(getApplicationContext());
			toast.setGravity(Gravity.BOTTOM,0,0);

			TextView tv = new TextView(QuizActivity.this);
			tv.setBackgroundColor(Color.RED);
			tv.setTextColor(Color.BLACK);
			tv.setTextSize(intTextSize+8);

			// Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
			// tv.setTypeface(t);
			tv.setPadding(20,20,20,20);
			tv.setText(Html.fromHtml(strAntwortText));
			toast.setView(tv);
			toast.show();
        }

		intPunkte = intPunkte - 1;

		strPunkte = Integer.toString(intPunkte);

		tv = (TextView) findViewById(R.id.tvPunkte);
		tv.setText(" " +strPunkte + " ");

        intFrageNr = QuizFragen.ermittel_LfdNr(intLevel);
        QuizFragen.lese_Quizfrage(intLevel, intFrageNr);

        strFrage = QuizFragen.mFrage;
        strAntwort = QuizFragen.mAntwort;

		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setText("");

		tv = (TextView) findViewById(R.id.tvMolmasse);
		tv.setText(strFrage);

		tv = (TextView) findViewById(R.id.tvFormel);
		tv.setText("");

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putInt("AnzahlElemente", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		prefEditor.putFloat("Molmasse", 0);
		prefEditor.apply();
    } // btnWeiter


	@Override
	public void onDestroy() {
		super.onDestroy();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		// Sicherstellen, dass beim nächsten Aufruf der Activity nicht versehentlich Haupt- statt
		// Nebengruppenelemente angezeigt werden (Eintrag für "PSE" wieder auf Grundstellung)
		prefEditor.putString("PSE", "Hauptgruppenelemente");
		prefEditor.apply();
		if(startTime != 0) {mp.stop();}			// Töne werden ausgeschaltet!
		// Timer explizit beenden, weil es sonst vibriert (nach Ablauf des Timers)
		timerHandler.removeCallbacks(timerRunnable);

	} // onDestroy
}


