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
        int i = 0;
        boolean bBildGefunden = false;

        String[] BilderArray = {
                // ***********
                // Kohlenstoff
                // ***********
                "co1111a12_011"
                // ***********
                // Wasserstoff
                // ***********
                ,"hh1000a1_008", "hh0100a1_008", "hh0010a1_008", "hh0001a1_008"
                // ********************
                // -Cx-Hx- Alkylgruppen
                // ********************
                ,"an1101a13_019", "an1110a13_019", "an0111a13_019", "an1011a13_019", "an0101a14_027", "an1010a14_027", "an1000a15_035", "an0100a15_035", "an0010a15_035", "an0001a15_035", "an0101a28_054", "an1010a28_054", "an0101a42_081", "an1010a42_081", "an0101a56_108", "an1010a56_108", "an0101a70_135", "an1010a70_135", "an0101a84_162", "an1010a84_162", "an0101a98_189", "an1010a98_189", "an0101a112_216", "an1010a112_216", "an0101a126_243", "an1010a126_243", "an0101a140_27", "an1010a140_27"
                // *********************
                // -C=C- Doppelbindungen
                // *********************
                ,"en2101a12_011", "en1210a12_011", "en0121a12_011", "en1012a12_011", "en2020a12_011", "en0202a12_011", "en2110a24_022", "en2011a24_022", "en1120a24_022", "en1021a24_022", "en1111a24_022", "en0211a24_022", "en1201a24_022", "en1102a24_022", "en0112a24_022", "en1111b24_022"
                // ***********************
                // -C≡C- Dreifachbindungen
                // ***********************
                ,"in1010a24_022", "in0101a24_022"
        };

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

        // if (drawable.getConstantState().equals(getResources().getDrawable(R.drawable.hh0001a1_008).getConstantState())){
        // "getResources().getDrawable" ist seit Android 5.1 (API 22) veraltet (deprecated)

        do
        {
            strZellenname = BilderArray[i];
            intResId = getResources().getIdentifier(strZellenname, "drawable", getPackageName());
            if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), intResId).getConstantState())){
                bBildGefunden = true;
            }
            i=i+1;
        } while ((i < BilderArray.length) && (bBildGefunden == false));

        if (bBildGefunden) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor prefEditor = prefs.edit();

            prefEditor.putString("Strukturformel-Zellenname", strZellenname);
            prefEditor.putInt("Strukturformel-ResId", intResId);

            prefEditor.apply();

            Intent myIntent = new Intent(Org_Strukturformeln_Activity.this, Org_Generator_Activity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(myIntent);
        } // if (bBildGefunden)
    } // btnZelle
} // class Org_Generator

