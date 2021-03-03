package de.laborabakus;

import java.util.Arrays;

class tKoordinaten {
    int Spalte = 0;
    int Zeile = 0;
}

class tEndpunkte {
    tKoordinaten StartPos = new tKoordinaten();
    tKoordinaten ZielPos = new tKoordinaten();
    int Bindung = 0;      // Uhrzeit der Bindung zum ersten benachbarten C-Atom
    int Kettenlaenge = 0; // Anzahl gefundener C-Atome

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
    int Bindung_Naechster = 0;      // Uhrzeit der Bindung zum nächsten C-Atom / Endpunkt
    int Kettenlaenge = 0; // Anzahl gefundener C-Atome

    // Initialisierung der Felder
    tElemente() {
        Koordinaten.Spalte = 0;
        Koordinaten.Zeile = 0;
    }
}

public class Org_GeneratorTools {
    // Bilddateien mit diesem Prefix enthalten Kohlenstoff-Elemente
    private static final String[] arrKohlenstoff_Elementtyp = {"an", "co", "en", "in", "nt"};

    // spezielle Kohlenstoff-Elemente mit ZWEI Kohlenstoff-Atomen
    private static final String[] arrKohlenstoff_doppelt = {"en0112a24_022", "en0211a24_022"
                                                           ,"en1021a24_022", "en1102a24_022"
                                                           ,"en1111a24_022", "en1111b24_022"
                                                           ,"en1120a24_022", "en1201a24_022"
                                                           ,"en2011a24_022", "en2110a24_022"
                                                           ,"in0101a24_022", "in1010a24_022"};

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

} // Org_GeneratorTools
