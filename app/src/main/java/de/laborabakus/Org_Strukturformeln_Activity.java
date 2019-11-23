package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;

public class Org_Strukturformeln_Activity extends Activity {

    @Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.org_strukturformeln);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	} // onCreate


    @Override
    public void onResume()
    {
        super.onResume();

    } // onResume


    @Override
    public void onPause() {
        super.onPause();

    } // onPause

    public void btnZelle(View v)
    {
        String strZellenname = "";
        int intResId = 0;

        ImageButton btn = (ImageButton) findViewById(v.getId());
        Drawable drawable = btn.getDrawable();
/*
A) drawables with theme attributes
   ContextCompat.getDrawable(getActivity(), R.drawable.name);
   You’ll obtain a styled Drawable as your Activity theme instructs. This is probably what you need.

B) drawables without theme attributes
   ResourcesCompat.getDrawable(getResources(), R.drawable.name, null);
   You’ll get your unstyled drawable the old way.
 */

//      if (drawable.getConstantState().equals(getResources().getDrawable(R.drawable.hh0001a1_008).getConstantState())){
//      "getResources().getDrawable" ist seit Android 5.1 (API 22) veraltet (deprecated)

        // ***********
        // Kohlenstoff
        // ***********
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.co1111a12_011).getConstantState())){
            strZellenname =           "co1111a12_011";
            intResId      = R.drawable.co1111a12_011;
        }

        // ***********
        // Wasserstoff
        // ***********
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.hh1000a1_008).getConstantState())){
            strZellenname =           "hh1000a1_008";
            intResId      = R.drawable.hh1000a1_008;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.hh0100a1_008).getConstantState())){
            strZellenname =           "hh0100a1_008";
            intResId      = R.drawable.hh0100a1_008;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.hh0010a1_008).getConstantState())){
            strZellenname =           "hh0010a1_008";
            intResId      = R.drawable.hh0010a1_008;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.hh0001a1_008).getConstantState())){
            strZellenname =           "hh0001a1_008";
            intResId      = R.drawable.hh0001a1_008;
        }

        // ****
        // "en"
        // ****
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1101a13_019).getConstantState())){
            strZellenname =           "an1101a13_019";
            intResId      = R.drawable.an1101a13_019;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1110a13_019).getConstantState())){
            strZellenname =           "an1110a13_019";
            intResId      = R.drawable.an1110a13_019;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0111a13_019).getConstantState())){
            strZellenname =           "an0111a13_019";
            intResId      = R.drawable.an0111a13_019;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1011a13_019).getConstantState())){
            strZellenname =           "an1011a13_019";
            intResId      = R.drawable.an1011a13_019;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a14_027).getConstantState())){
            strZellenname =           "an0101a14_027";
            intResId      = R.drawable.an0101a14_027;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a14_027).getConstantState())){
            strZellenname =           "an1010a14_027";
            intResId      = R.drawable.an1010a14_027;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1000a15_035).getConstantState())){
            strZellenname =           "an1000a15_035";
            intResId      = R.drawable.an1000a15_035;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0100a15_035).getConstantState())){
            strZellenname =           "an0100a15_035";
            intResId      = R.drawable.an0100a15_035;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0010a15_035).getConstantState())){
            strZellenname =           "an0010a15_035";
            intResId      = R.drawable.an0010a15_035;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0001a15_035).getConstantState())){
            strZellenname =           "an0001a15_035";
            intResId      = R.drawable.an0001a15_035;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a28_054).getConstantState())){
            strZellenname =           "an0101a28_054";
            intResId      = R.drawable.an0101a28_054;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a28_054).getConstantState())){
            strZellenname =           "an1010a28_054";
            intResId      = R.drawable.an1010a28_054;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a42_081).getConstantState())){
            strZellenname =           "an0101a42_081";
            intResId      = R.drawable.an0101a42_081;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a42_081).getConstantState())){
            strZellenname =           "an1010a42_081";
            intResId      = R.drawable.an1010a42_081;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a56_108).getConstantState())){
            strZellenname =           "an0101a56_108";
            intResId      = R.drawable.an0101a56_108;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a56_108).getConstantState())){
            strZellenname =           "an1010a56_108";
            intResId      = R.drawable.an1010a56_108;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a70_135).getConstantState())){
            strZellenname =           "an0101a70_135";
            intResId      = R.drawable.an0101a70_135;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a70_135).getConstantState())){
            strZellenname =           "an1010a70_135";
            intResId      = R.drawable.an1010a70_135;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a84_162).getConstantState())){
            strZellenname =           "an0101a84_162";
            intResId      = R.drawable.an0101a84_162;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a84_162).getConstantState())){
            strZellenname =           "an1010a84_162";
            intResId      = R.drawable.an1010a84_162;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a98_189).getConstantState())){
            strZellenname =           "an0101a98_189";
            intResId      = R.drawable.an0101a98_189;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a98_189).getConstantState())){
            strZellenname =           "an1010a98_189";
            intResId      = R.drawable.an1010a98_189;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a112_216).getConstantState())){
            strZellenname =           "an0101a112_216";
            intResId      = R.drawable.an0101a112_216;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a112_216).getConstantState())){
            strZellenname =           "an1010a112_216";
            intResId      = R.drawable.an1010a112_216;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a126_243).getConstantState())){
            strZellenname =           "an0101a126_243";
            intResId      = R.drawable.an0101a126_243;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a126_243).getConstantState())){
            strZellenname =           "an1010a126_243";
            intResId      = R.drawable.an1010a126_243;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an0101a140_27).getConstantState())){
            strZellenname =           "an0101a140_27";
            intResId      = R.drawable.an0101a140_27;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.an1010a140_27).getConstantState())){
            strZellenname =           "an1010a140_27";
            intResId      = R.drawable.an1010a140_27;
        }

        // ****
        // "en"
        // ****
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en2101a12_011).getConstantState())){
            strZellenname =           "en2101a12_011";
            intResId      = R.drawable.en2101a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1210a12_011).getConstantState())){
            strZellenname =           "en1210a12_011";
            intResId      = R.drawable.en1210a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en0121a12_011).getConstantState())){
            strZellenname =           "en0121a12_011";
            intResId      = R.drawable.en0121a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1012a12_011).getConstantState())){
            strZellenname =           "en1012a12_011";
            intResId      = R.drawable.en1012a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en2020a12_011).getConstantState())){
            strZellenname =           "en2020a12_011";
            intResId      = R.drawable.en2020a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en0202a12_011).getConstantState())){
            strZellenname =           "en0202a12_011";
            intResId      = R.drawable.en0202a12_011;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en2110a24_022).getConstantState())){
            strZellenname =           "en2110a24_022";
            intResId      = R.drawable.en2110a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en2011a24_022).getConstantState())){
            strZellenname =           "en2011a24_022";
            intResId      = R.drawable.en2011a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1120a24_022).getConstantState())){
            strZellenname =           "en1120a24_022";
            intResId      = R.drawable.en1120a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1021a24_022).getConstantState())){
            strZellenname =           "en1021a24_022";
            intResId      = R.drawable.en1021a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1111a24_022).getConstantState())){
            strZellenname =           "en1111a24_022";
            intResId      = R.drawable.en1111a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en0211a24_022).getConstantState())){
            strZellenname =           "en0211a24_022";
            intResId      = R.drawable.en0211a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1201a24_022).getConstantState())){
            strZellenname =           "en1201a24_022";
            intResId      = R.drawable.en1201a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1102a24_022).getConstantState())){
            strZellenname =           "en1102a24_022";
            intResId      = R.drawable.en1102a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en0112a24_022).getConstantState())){
            strZellenname =           "en0112a24_022";
            intResId      = R.drawable.en0112a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.en1111b24_022).getConstantState())){
            strZellenname =           "en1111b24_022";
            intResId      = R.drawable.en1111b24_022;
        }

        // ****
        // "in"
        // ****
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.in1010a24_022).getConstantState())){
            strZellenname =           "in1010a24_022";
            intResId      = R.drawable.in1010a24_022;
        }
        if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), R.drawable.in0101a24_022).getConstantState())){
            strZellenname =           "in0101a24_022";
            intResId      = R.drawable.in0101a24_022;
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        prefEditor.putString("Strukturformel-Zellenname", strZellenname);
        prefEditor.putInt   ("Strukturformel-ResId"     , intResId);

        prefEditor.apply();


        Intent myIntent = new Intent(Org_Strukturformeln_Activity.this, Org_Generator_Activity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(myIntent);
    }


} // class Org_Generator

