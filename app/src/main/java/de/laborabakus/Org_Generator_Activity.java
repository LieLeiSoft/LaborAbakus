package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;


public class Org_Generator_Activity extends Activity {


    String strZellenname;
    String strStrukturformel;
    String strZeile;
    String strZelle;
    String strSpalte;
    int intCounter = 0;
    int resIdFeld;
    int intZelle;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.org_generator);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate


    @Override
    public void onResume()
    {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        strStrukturformel = prefs.getString("Strukturformel", "");

        if(resIdFeld != 0) // Wird abgefangen, wenn beim ersten Mal resID =0
        {
            ImageButton ibt;
            ibt = (ImageButton) findViewById(resIdFeld);

            strZelle = strStrukturformel.substring(9,12);   // Beispiel: ibtZelle_115 => 115

            intZelle = Integer.parseInt(strZelle);

            String strBildname = "hh0001a1_008";
            int intBildId = 4711;

            switch (intZelle)
            {
                case 11: ibt.setImageResource(R.drawable.co1111a12_011); break;
                case 13: ibt.setImageResource(R.drawable.hh1000a1_008); break;
                case 14: ibt.setImageResource(R.drawable.hh0100a1_008); break;
                case 15: ibt.setImageResource(R.drawable.hh0010a1_008); break;

//                case 16: ibt.setImageResource(R.drawable.hh0001a1_008); break;
                case 16: ibt.setImageResource(intBildId); break;

                case 21: ibt.setImageResource(R.drawable.an1101a13_019); break;
                case 22: ibt.setImageResource(R.drawable.an1110a13_019); break;
                case 23: ibt.setImageResource(R.drawable.an0111a13_019); break;
                case 24: ibt.setImageResource(R.drawable.an1011a13_019); break;
                case 25: ibt.setImageResource(R.drawable.an0101a14_027); break;
                case 26: ibt.setImageResource(R.drawable.an1010a14_027); break;
                case 31: ibt.setImageResource(R.drawable.an1000a15_035); break;
                case 32: ibt.setImageResource(R.drawable.an0100a15_035); break;
                case 33: ibt.setImageResource(R.drawable.an0010a15_035); break;
                case 34: ibt.setImageResource(R.drawable.an0001a15_035); break;
                case 35: ibt.setImageResource(R.drawable.an0101a28_054); break;
                case 36: ibt.setImageResource(R.drawable.an1010a28_054); break;
                case 41: ibt.setImageResource(R.drawable.an0101a42_081); break;
                case 42: ibt.setImageResource(R.drawable.an1010a42_081); break;
                case 43: ibt.setImageResource(R.drawable.an0101a56_108); break;
                case 44: ibt.setImageResource(R.drawable.an1010a56_108); break;
                case 45: ibt.setImageResource(R.drawable.an0101a70_135); break;
                case 46: ibt.setImageResource(R.drawable.an1010a70_135); break;
                case 51: ibt.setImageResource(R.drawable.an0101a84_162); break;
                case 52: ibt.setImageResource(R.drawable.an1010a84_162); break;
                case 53: ibt.setImageResource(R.drawable.an0101a98_189); break;
                case 54: ibt.setImageResource(R.drawable.an1010a98_189); break;
                case 55: ibt.setImageResource(R.drawable.an0101a112_216); break;
                case 56: ibt.setImageResource(R.drawable.an1010a112_216); break;
                case 61: ibt.setImageResource(R.drawable.an0101a126_243); break;
                case 62: ibt.setImageResource(R.drawable.an1010a126_243); break;
                case 63: ibt.setImageResource(R.drawable.an0101a140_27); break;
                case 64: ibt.setImageResource(R.drawable.an1010a140_27); break;

                case 71: ibt.setImageResource(R.drawable.en2101a12_011); break;
                case 72: ibt.setImageResource(R.drawable.en1210a12_011); break;
                case 73: ibt.setImageResource(R.drawable.en0121a12_011); break;
                case 74: ibt.setImageResource(R.drawable.en1012a12_011); break;
                case 75: ibt.setImageResource(R.drawable.en2020a12_011); break;
                case 76: ibt.setImageResource(R.drawable.en0202a12_011); break;
                case 81: ibt.setImageResource(R.drawable.en2110a24_022); break;
                case 82: ibt.setImageResource(R.drawable.en2011a24_022); break;
                case 83: ibt.setImageResource(R.drawable.en1120a24_022); break;
                case 84: ibt.setImageResource(R.drawable.en1021a24_022); break;
                case 86: ibt.setImageResource(R.drawable.en1111a24_022); break;
                case 91: ibt.setImageResource(R.drawable.en0211a24_022); break;
                case 92: ibt.setImageResource(R.drawable.en1201a24_022); break;
                case 93: ibt.setImageResource(R.drawable.en1102a24_022); break;
                case 94: ibt.setImageResource(R.drawable.en0112a24_022); break;
                case 96: ibt.setImageResource(R.drawable.en1111b24_022); break;
                case 101: ibt.setImageResource(R.drawable.in1010a24_022); break;
                case 102: ibt.setImageResource(R.drawable.in0101a24_022); break;
            }
        }


    } // onResume


    @Override
    public void onPause() {
        super.onPause();

    } // onPause

    public void btnFeld(View v)
    {
        strZellenname = getResources().getResourceEntryName(v.getId());  // Der ID Zellenname wird in einen String umgewandelt

        resIdFeld = getResources().getIdentifier(strZellenname, "id", getPackageName());

        strZeile = strZellenname.substring(8,10);   // Beispiel: ibtFeld_115 => 11
        strSpalte = strZellenname.substring(10,11);   // Beispiel: ibtFeld_115 => 5

        intCounter ++;


        Intent myIntent = new Intent(Org_Generator_Activity.this, Org_Strukturformeln_Activity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(myIntent);


    }


} // class Org_Generator

