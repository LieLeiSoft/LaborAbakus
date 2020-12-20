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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Org_Strukturformeln_Activity extends Activity {
    private static final String TAG = "Org_Strukturformeln_Activity";

    // HashMap definieren, die ALLE Bilddateinamen (z.B. "co1111a12_011")+resID des dazugehörenden ImageButtons (org_strukturformeln.xml) enthält
    // key   (String) : Bilddateiname
    // value (Integer): resId
    HashMap<String, Integer> hmBilddateien = new HashMap<String,Integer>();

    static int intZeile_max  = 20;
    static int intSpalte_max = 6;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        String strZellenname;
        String strBilddateiname;
        int intResId_Zelle;
        int intResId_Bild;
        boolean bBildGefunden;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_strukturformeln);

        // Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
        ActivityRegistry.register(this);

        // erst einmal nur die Bilddateinamen in die HashMap eintragen
        SchreibeBilddateienInHashMap();

        // jetzt die HashMap um die ResId der jeweiligen Zelle ergänzen
        for (int intZeile = 1; intZeile <= intZeile_max; intZeile++) {
            for (int intSpalte = 1; intSpalte <= intSpalte_max; intSpalte++) {
                // Name des ImageButtons aus Zeile und Spalte bilden
                strZellenname = "ibtZelle_" + new DecimalFormat("00").format(intZeile) + intSpalte;
                // ResId des ImageButtons ermitteln
                intResId_Zelle = getResources().getIdentifier(strZellenname, "id", getPackageName());

                ImageButton btn = (ImageButton) findViewById(intResId_Zelle);
                Drawable drawable = btn.getDrawable();

                Log.d(TAG, "strZellenname = "+strZellenname);
                Log.d(TAG, "getPackageName: "+getPackageName().toString());
                Log.d(TAG, "intResId = "+Integer.toString(intResId_Zelle));
                if (btn == null)
                    Log.d(TAG, "*** btn IST NULL!!! ***");
                else
                    Log.d(TAG, "btn: "+btn.toString());

                // HashMap erstellen, die nur Einträge mit Value (resId) = 0 enthält
                // (d.h. alle bereits verwendetet Einträge (resId <> 0) sind rausgefiltert)
                // (hier werden Lambda-Ausdrücke (->) verwendet)
                // https://beginnersbook.com/2017/10/java-8-filter-a-map-by-keys-and-values/
                Map<String, Integer> hmGefiltert = hmBilddateien.entrySet()
                        .stream()
                        .filter(map -> map.getValue().intValue() == 0)
                        .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                // HashMap durchlaufen, bis Ende erreicht oder Bild gefunden
                // https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
                Iterator iterator = hmGefiltert.entrySet().iterator();
                bBildGefunden = false;
                while (iterator.hasNext() & (bBildGefunden == false)) {
                    Map.Entry me = (Map.Entry) iterator.next();

                    strBilddateiname = me.getKey().toString();
                    intResId_Bild = getResources().getIdentifier(strBilddateiname, "drawable", getPackageName());

                    if (drawable.getConstantState().equals(ContextCompat.getDrawable(getBaseContext(), intResId_Bild).getConstantState())){
                        hmBilddateien.put(me.getKey().toString(), intResId_Zelle);
                        bBildGefunden = true;
                    }
                } // while (iterator.hasNext() & (bBildGefunden == false))
                hmGefiltert.clear();
            } // for (int intSpalte = 1; intSpalte <= intSpalte_max; intSpalte++)
        } // for (int intZeile = 1; intZeile <= intZeile_max; intZeile++)
    } // onCreate

    @Override
    public void onDestroy() {
        super.onDestroy();

        hmBilddateien.clear();
    } // onDestroy

    @Override
    public void onResume()
    {
        super.onResume();

        View v;
        String strZellenname = "";
        String strBilddateiname = "";
        Boolean bVisible;


        /*
            Um die Anzeige der Bilder zu steuern, soll aus 'Org_Generator_Activity' ein 4stelliger String übergeben werden.
            Stelle 1 des Strings bezieht sich auf die erlaubte Bindung auf 12 Uhr.
            Stelle 2 des Strings bezieht sich auf die erlaubte Bindung auf  3 Uhr.
            Stelle 3 des Strings bezieht sich auf die erlaubte Bindung auf  6 Uhr.
            Stelle 4 des Strings bezieht sich auf die erlaubte Bindung auf  9 Uhr.
            Je Stelle sind folgende Werte möglich:
            0 : alles erlaubt
            1 : nur einfache Bindung erlaubt
            2 : nur zweifache Bindung erlaubt
            9 : keine Bindung erlaubt

            Beispiele:
            0000 ==> alles erlaubt
            1000 ==> auf 12 Uhr ist nur eine einfache Bindung erlaubt, auf 3, 6 und 9 Uhr ist alles erlaubt
            2000 ==> auf 12 Uhr ist nur eine zweifache Bindung erlaubt, auf 3, 6 und 9 Uhr ist alles erlaubt
            9000 ==> auf 12 Uhr ist KEINE Bindung erlaubt, auf 3, 6 und 9 Uhr ist alles erlaubt
            9009 ==> auf 12 und 9 Uhr ist KEINE Bindung erlaubt, auf 3 und 6 Uhr ist alles erlaubt
            1290 ==> auf 12 Uhr ist nur eine einfache Bindung erlaubt
                     auf  3 Uhr ist nur eine zweifache Bindung erlaubt
                     auf  6 Uhr ist KEINE Bindung erlaubt
                     auf  9 Uhr ist alles erlaubt
         */

        Intent myIntent = getIntent();
        int arrFilter[] = myIntent.getIntArrayExtra("Filter");

        for (int i = 0; i < 4; i++) {
            Log.d(TAG, "arrFilter["+i+"]="+arrFilter[i]);
        }

        for(String key : hmBilddateien.keySet()) {
            Integer value = hmBilddateien.get(key);
            if (value != 0) {
                strBilddateiname = key;

                int arrBindung[] = new int[4];
                // Bindungseigenschaften in Array speichern
                for (int b = 0; b < 4; b++) {
                    int intPos = 2 + b;
                    arrBindung[b] = Integer.parseInt(strBilddateiname.substring(intPos, intPos+1));
                }

                bVisible = true;

                if ((arrFilter[0] == 9) & (arrBindung[0] > 0)) {
                    // Bindung auf 12 Uhr vorhanden ==> Feld unsichtbar machen
                    bVisible = false;
                }
                if ((arrFilter[1] == 9) & (arrBindung[1] > 0)) {
                    // Bindung auf 3 Uhr vorhanden ==> Feld unsichtbar machen
                    bVisible = false;
                }
                if ((arrFilter[2] == 9) & (arrBindung[2] > 0)) {
                    // Bindung auf 6 Uhr vorhanden ==> Feld unsichtbar machen
                    bVisible = false;
                }
                if ((arrFilter[3] == 9) & (arrBindung[3] > 0)) {
                    // Bindung auf 9 Uhr vorhanden ==> Feld unsichtbar machen
                    bVisible = false;
                }

                int intResId = value;
                v = (View) findViewById(intResId);
                if (bVisible)
                    v.setVisibility(View.VISIBLE);
                else
                    v.setVisibility(View.INVISIBLE);

            } // if (value != "frei")
        } // for(String key : hmBilddateien.keySet())
    } // onResume

    @Override
    public void onPause() {
        super.onPause();
    } // onPause

    // onNewIntent / setIntent notwendig, damit die mit "PutExtra" übergebenen Parameter aktualisiert werden
    // (sonst ermittelt "getIntArrayExtra" immer dieselben Parameter)
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
    private void SchreibeBilddateienInHashMap()
    {
        // Liste von Feldern definieren, die alle Grafik-Objekte (drawables) des Projekts enthält
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
        // Jeder gefunden Eintrag wird in die Feldliste eingetragen
        for (Field field : fields) {
            if (p.matcher(field.getName()).matches()) {
                hmBilddateien.put(field.getName(), 0);
            }
        }
    } // SchreibeBilddateienInHashMap

    public void btnZelle(View v)
    {
        String strBilddateiname = "";
        int intResId = 0;
        boolean bBildGefunden;

        // Hashmap mit den Bilddateien durchlaufen, um die ResId der Bilddatei zu ermitteln
        // Alle Elemente der HashMap durchlaufen, bis Ende erreicht oder Bild gefunden
        // https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
        Iterator iterator = hmBilddateien.entrySet().iterator();
        bBildGefunden = false;
        while (iterator.hasNext() & (bBildGefunden == false)) {
            Map.Entry me = (Map.Entry) iterator.next();
            Integer value = (Integer) me.getValue();
            if (v.getId() == value) {
                strBilddateiname = me.getKey().toString();
                intResId = getResources().getIdentifier(strBilddateiname, "drawable", getPackageName());
                bBildGefunden = true;
            }
        } // while (iterator.hasNext() & (bBildGefunden == false))

        if (bBildGefunden) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor prefEditor = prefs.edit();

            prefEditor.putString("Strukturformel-Zellenname", strBilddateiname);
            prefEditor.putInt   ("Strukturformel-ResId"     , intResId     );

            prefEditor.apply();

            Intent myIntent = new Intent(Org_Strukturformeln_Activity.this, Org_Generator_Activity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(myIntent);
        } // if (bBildGefunden)
    } // btnZelle
} // class Org_Strukturformeln_Activity

