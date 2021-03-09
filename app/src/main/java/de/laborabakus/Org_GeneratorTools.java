package de.laborabakus;

import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;

class tKoordinaten {
    int Spalte = 0;
    int Zeile = 0;
}

class tEndpunkte {
    tKoordinaten StartPos = new tKoordinaten();
    tKoordinaten ZielPos = new tKoordinaten();
    int Bindung = 0;      // Uhrzeit der Bindung zum ersten benachbarten C-Atom
    int Kettenlaenge = 0; // Anzahl gefundener C-Atome
    float Molmasse = 0; // Summe der Molmasse der gefundenen C-Atome

    // Initialisierung der Felder
    tEndpunkte() {
        StartPos.Spalte = 0;
        StartPos.Zeile = 0;
        ZielPos.Spalte = 0;
        ZielPos.Zeile = 0;
    }
}

class tElemente {
    tKoordinaten Koordinaten = new tKoordinaten();
    int Bindung_Vorgaenger = 0;      // Uhrzeit der Bindung zum vorangegangenen C-Atom / Endpunkt (Herkunftsbindung)
    int Kettenlaenge = 0; // Anzahl gefundener C-Atome
    int Ketten_Index = 0;

    // Initialisierung der Felder
    tElemente() {
        Koordinaten.Spalte = 0;
        Koordinaten.Zeile = 0;
    }
}

class tKetten {
    int Endpunkt_Index = 0;
    int Kettenlaenge = 0; // Anzahl gefundener C-Atome
    float Molmasse = 0; // Summe der Molmasse der gefundenen C-Atome
    String Koordinatenpaare = "";
}

public class Org_GeneratorTools {
    private static final String TAG = "Org_GeneratorTools";

    // Bilddateien mit diesem Prefix enthalten Kohlenstoff-Elemente
    private static final String[] arrKohlenstoff_Elementtyp = {"an", "co", "en", "in", "nt"};

    // spezielle Kohlenstoff-Elemente mit ZWEI Kohlenstoff-Atomen
    private static final String[] arrKohlenstoff_doppelt = {"en0112a24_022", "en0211a24_022"
                                                           ,"en1021a24_022", "en1102a24_022"
                                                           ,"en1111a24_022", "en1111b24_022"
                                                           ,"en1120a24_022", "en1201a24_022"
                                                           ,"en2011a24_022", "en2110a24_022"
                                                           ,"in0101a24_022", "in1010a24_022"};

    // spezielle Kohlenstoff-Elemente mit mehreren Kohlenstoff-Atomen
    // Array enthält abwechselnd Bilddateinamen und Anzahle Kohlenstoff-Atome
    // Array dient als Datenquelle für Hashmap "hmC_Atome_mehrfach"
    private static final String[] arrKohlenstoff_mehrfach = {"an0101a28_054" , "2"
                                                            ,"an1010a28_054" , "2"
                                                            ,"an0101a42_081" , "3"
                                                            ,"an1010a42_081" , "3"
                                                            ,"an0101a56_108" , "4"
                                                            ,"an1010a56_108" , "4"
                                                            ,"an0101a70_135" , "5"
                                                            ,"an1010a70_135" , "5"
                                                            ,"an0101a84_162" , "6"
                                                            ,"an1010a84_162" , "6"
                                                            ,"an0101a98_189" , "7"
                                                            ,"an1010a98_189" , "7"
                                                            ,"an0101a112_216", "8"
                                                            ,"an1010a112_216", "8"
                                                            ,"an0101a126_243", "9"
                                                            ,"an1010a126_243", "9"
                                                            ,"an0101a140_27" , "10"
                                                            ,"an1010a140_27" , "10"};

    // HashMap definieren, die bestimmte Bilddateinamen (z.B. "an1010a112_216")+die Anzahl der C-Atome enthält
    // key   (String) : Bilddateiname
    // value (Integer): Anzahl C-Atome
    private static HashMap<String, Integer> hmC_Atome_mehrfach = new HashMap<String,Integer>();

    // Konstruktor
    public Org_GeneratorTools () {
        Log.d(TAG, "Org_GeneratorTools: Konstruktor");
        // Schleife mit Schrittweite 2
        for (int i = 0; i < arrKohlenstoff_mehrfach.length; i+=2) {
            hmC_Atome_mehrfach.put(arrKohlenstoff_mehrfach[i], Integer.parseInt(arrKohlenstoff_mehrfach[(i+1)]));
        }
    } // Org_GeneratorTools (Konstruktor!)

    // Bindungseigenschaften in Array speichern
    public static int [] fktBindung2Array (String pBilddateiname) {
        int arrBindung[] = new int[4];

        for (int b = 0; b < 4; b++) {
            int intPos = 2 + b;
            arrBindung[b] = Integer.parseInt(pBilddateiname.substring(intPos, intPos+1));
        }
        return arrBindung;
    } // fktBindung2Array

    // Endpunkte-Array dynamisch um einen Tabellenplatz erweitern
    // https://www.youtube.com/watch?v=-PktkiWCqBs
    public static tEndpunkte[] fktEndpunkteArray_vergr(tEndpunkte[] pEndpunkte) {
        // pEndpunkte.length gibt die Anzahl der Tabellenplätze wider und beginnt mit 1!
        tEndpunkte[] tmp = new tEndpunkte[pEndpunkte.length + 1];
        System.arraycopy(pEndpunkte, 0, tmp, 0, pEndpunkte.length);
        tmp[pEndpunkte.length] = new tEndpunkte();
        pEndpunkte = tmp;
        return pEndpunkte;
    } // fktEndpunkteArray_vergr

    // Elemente-Array dynamisch um einen Tabellenplatz erweitern
    // https://www.youtube.com/watch?v=-PktkiWCqBs
    public static tElemente[] fktElementeArray_vergr(tElemente[] pElemente) {
        // pElemente.length gibt die Anzahl der Tabellenplätze wider und beginnt mit 1!
        tElemente[] tmp = new tElemente[pElemente.length + 1];
        System.arraycopy(pElemente, 0, tmp, 0, pElemente.length);
        tmp[pElemente.length] = new tElemente();
        pElemente = tmp;
        return pElemente;
    } // fktElementeArray_vergr

    // ersten Eintrag (Index [0]) aus Elemente-Array entfernen
    public static tElemente[] fktElementeArray_verkl(tElemente[] pElemente) {
        // pElemente.length gibt die Anzahl der Tabellenplätze wider und beginnt mit 1!
        if (pElemente.length > 0) {
            tElemente[] tmp = new tElemente[pElemente.length - 1];
            System.arraycopy(pElemente, 1, tmp, 0, pElemente.length - 1);
            pElemente = tmp;
        }
        return pElemente;
    } // fktElementeArray_verkl

    // Ketten-Array dynamisch um einen Tabellenplatz erweitern
    // https://www.youtube.com/watch?v=-PktkiWCqBs
    public static tKetten[] fktKettenArray_vergr(tKetten[] pKetten) {
        // pKetten.length gibt die Anzahl der Tabellenplätze wider und beginnt mit 1!
        tKetten[] tmp = new tKetten[pKetten.length + 1];
        System.arraycopy(pKetten, 0, tmp, 0, pKetten.length);
        tmp[pKetten.length] = new tKetten();
        pKetten = tmp;
        return pKetten;
    } // fktKettenArray_vergr

    public static boolean fktIstKohlenstoff(String pBilddateiname) {
        String strElementTyp;
        boolean bReturn = false;

        // die ersten beiden Zeichen des Bilddateinamens stehen für den ElementTyp (z.B. "an")
        strElementTyp = pBilddateiname.substring(0, 2);
        if (Arrays.asList(arrKohlenstoff_Elementtyp).contains(strElementTyp)) {
            // der ElementTyp ist im Array "arrKohlenstoff_Elementtyp" enthalten
            bReturn = true;
        }
        return bReturn;
    } // fktIstKohlenstoff

    public static boolean fktIstKohlenstoff_doppelt(String pBilddateiname) {
        boolean bReturn = false;
        if (Arrays.asList(arrKohlenstoff_doppelt).contains(pBilddateiname)) {
            bReturn = true;
        }
        return bReturn;
    } // fktIstKohlenstoff_doppelt

    public static boolean fktIstEndpunkt(tEndpunkte[] pEndpunkte, int pZeile, int pSpalte) {
        boolean bReturn = false;
        for (int i = 0; i < pEndpunkte.length; i++) {
            if (   (pEndpunkte[i].StartPos.Zeile  == pZeile )
                && (pEndpunkte[i].StartPos.Spalte == pSpalte)) {
                bReturn = true;
                break;
            }
        }
        return bReturn;
    } // fktIstEndpunkt

    // Uhrzeit der Bindung umkehren:
    // 3==>9, 6==>12, 9==>3, 12==>6
    public static int fktBindungUmkehren (int pBindung) {
        int intBindung = 0;
        switch (pBindung) {
            case 3:
                intBindung = 9;
                break;
            case 6:
                intBindung = 12;
                break;
            case 9:
                intBindung = 3;
                break;
            case 12:
                intBindung = 6;
                break;
        }
        return intBindung;
    } // fktBindungUmkehren

    public static int fktAnzahl_C_Atome (String pBilddateiname) {
        int intAnzahl_C_Atome = 0;
        if (fktIstKohlenstoff(pBilddateiname)) {
            // Element enthält mind. 1 Kohlenstoffatom
            intAnzahl_C_Atome = 1;

            if (fktIstKohlenstoff_doppelt(pBilddateiname)) {
                // Element mit 2 Kohlenstoffatomen
                intAnzahl_C_Atome = 2;
            } else {
                Integer value = hmC_Atome_mehrfach.get(pBilddateiname);
                if (value != null) {
                    intAnzahl_C_Atome = value;
                }
            }
        }
        return intAnzahl_C_Atome;
    } // fktAnzahl_C_Atome

    public static float fktMolmasse (String pBilddateiname) {
        String strMolmasse = "";
        float fltMolmasse = 0;
        // Bilddateinamen (z.B. "an0001a15_035") zerlegen
        strMolmasse = pBilddateiname.substring(7);
        strMolmasse = strMolmasse.replace("_", ".");
        fltMolmasse = Float.parseFloat(strMolmasse);
        return fltMolmasse;
    } // fktMolmasse
} // Org_GeneratorTools
