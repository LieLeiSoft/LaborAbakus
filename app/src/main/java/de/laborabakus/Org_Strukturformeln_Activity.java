package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Org_Strukturformeln_Activity extends Activity {
    // Stringlist 'names', die später die Namen der Bilddateien (z.B. "co1111a12_011", "hh1000a1_008") enthalten soll
    static List<String> names = new ArrayList<String>();
    static int intZeile_max  = 20;
    static int intSpalte_max = 6;

    @Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.org_strukturformeln);

        // Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);

        ErstelleListe();
	} // onCreate

    @Override
    public void onDestroy() {
        super.onDestroy();

        names.clear();
    } // onDestroy

    @Override
    public void onResume()
    {
        super.onResume();

        String strZellenname = "";
        String strFeldname = "";
        int intResId = 0;
        int intResId2 = 0;

        int x = 0;
        boolean bBildGefunden = false;

        for (int intZeile = 1; intZeile <= intZeile_max; intZeile++) {
            for (int intSpalte = 1; intSpalte <= intSpalte_max; intSpalte++) {

                strZellenname = new DecimalFormat("00").format(intZeile);
                strZellenname = "ibtZelle_" + strZellenname + intSpalte;
                intResId = getResources().getIdentifier(strZellenname, "id", getPackageName());

                Log.i("Org_Strukturformeln_Activity", "intResId="+intResId);

                ImageButton btn = (ImageButton) findViewById(intResId);

                Log.i("Org_Strukturformeln_Activity", "btn="+btn.toString());

                Drawable drawable = btn.getDrawable();

                Log.i("Org_Strukturformeln_Activity", "drawable="+drawable.toString());

                Log.i("Org_Strukturformeln_Activity", "names.size()="+names.size());

                do
                {
                    strFeldname = names.get(x);
                    Log.i("Org_Strukturformeln_Activity", "strFeldname="+strFeldname);

/*
                    intResId2 = getResources().getIdentifier(strFeldname, "drawable", getPackageName());
                    Log.i("Org_Strukturformeln_Activity", "intResId2="+intResId2);

                    if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), intResId2).getConstantState())){
                        bBildGefunden = true;
                        Log.i("Org_Strukturformeln_Activity", "strFeldname="+strFeldname);
                    }
*/
                    x = x + 1;
                } while ((x < names.size()) && (bBildGefunden == false)); // BEIDE Bedingungen müssen erfüllt sein, damit die Schleife weiter durchlaufen wird!

                if (bBildGefunden == false)
                {
                    strFeldname = "???";
                }

                Log.i("Org_Strukturformeln_Activity", "strZellenname="+strZellenname + " / intResId="+intResId + " / strFeldname="+strFeldname);
            }
        }

    } // onResume

    @Override
    public void onPause() {
        super.onPause();
    } // onPause

    private void ErstelleListe()
    {
        // Feldliste definieren, die alle Grafik-Objekte (drawables) des Projekts enthält
        Field[] fields =  R.drawable.class.getFields();

        /*
            Die Namen der Bilddateien müssen folgen Aufbau haben:
            xx     = Typ (z.B. an = Alkane)
            1234   = Bindungseigenschaften (1. Ziffer: Bindung 12:00 Uhr, 2. Ziffer: Bindung 15:00 Uhr, usw.)
            x      = Variante (mehrere Möglichkeiten, a = Standard)
            12_345 = Molmasse, der Unterstrich ist gleich Komma (z.B. 13_019 = 13,019 g/mol)

            Beispiele:
            Kohlenstoff: "co1111a12_011"
            Wasserstoff: "hh1000a1_008"
        */

        /*
            Hier wird ein "Regulärer Ausdruck" ("Pattern") gebildet, um die gewünschten Grafik-Objekte
            (z.B. "co1111a12_011", "hh1000a1_008") in der Feldliste zu finden.

            Der "Reguläre Ausdruck" setzt sich aus verschiedenen Platzhaltern zusammen:
            .*          : beliebiges Zeichen, beliebig oft
            [a-zA-Z]{2} : 2 Buchstaben (Groß-/Kleinschreibung egal)
            \d{4}       : 4 Ziffern
            [a-zA-Z]    : 1 Buchstabe (Groß-/Kleinschreibung egal)
            \d+         : Ziffer, beliebig oft
            [_]         : Unterstrich
            \d+         : Ziffer, beliebig oft

            Info zu "Regulären Ausdrücken": http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_04_007.htm#mj26fc5cf60311afbddd72295cdd646a48
        */
        Pattern p = Pattern.compile(".*[a-zA-Z]{2}\\d{4}[a-zA-Z]\\d+[_]\\d+");

        // Die Feldliste wird mit dem "Regulärer Ausdruck" ("Pattern") durchsucht.
        // Jeder gefunden Eintrag wird in die Stringlist 'names' eingetragen
        for (Field field : fields) {
            if (p.matcher(field.getName()).matches())
                names.add(field.getName());
        }
    }

    public void btnZelle(View v)
    {
        String strZellenname = "";
        int intResId = 0;
        int i = 0;
        boolean bBildGefunden = false;

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

        // Stringlist 'names' durchlaufen
        do
        {
            strZellenname = names.get(i);
            intResId = getResources().getIdentifier(strZellenname, "drawable", getPackageName());

            if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), intResId).getConstantState())){
                bBildGefunden = true;
            }
            i = i + 1;
        } while ((i < names.size()) && (bBildGefunden == false)); // BEIDE Bedingungen müssen erfüllt sein, damit die Schleife weiter durchlaufen wird!

        if (bBildGefunden) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor prefEditor = prefs.edit();

            prefEditor.putString("Strukturformel-Zellenname", strZellenname);
            prefEditor.putInt   ("Strukturformel-ResId"     , intResId     );

            prefEditor.apply();

            Intent myIntent = new Intent(Org_Strukturformeln_Activity.this, Org_Generator_Activity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(myIntent);
        } // if (bBildGefunden)
    } // btnZelle
} // class Org_Generator

