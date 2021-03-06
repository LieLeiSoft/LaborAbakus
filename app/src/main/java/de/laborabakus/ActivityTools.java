package de.laborabakus;

import android.view.Gravity;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ActivityTools {
	// Gleitkommazahl vom Typ Double runden
	public static double fktRunden(double Zahl, int AnzahlStellen) {
		long Dummy =  (long) Math.pow(10, AnzahlStellen);
		double Ergebnis = (long) ((Zahl*Dummy) + (0.5*Math.signum(Zahl))) / (Dummy*1.0); // *1.0 damit's ein double wird!
		
		return Ergebnis;		
	} // fktRunden

	// Gleitkommazahl vom Typ Float runden
	// https://www.java-forum.org/thema/float-auf-bestimmte-nachkommazahl-runden.102634/
	public static float fktRundenFloat(final float number, final int decimalPlaces) {
		float precision = 1.0F;
		for (int i = 0; i < decimalPlaces; i++, precision *= 10);
		return ((int) (number * precision + 0.5)  / precision);
	}

	/*
	   Text duplizieren
	   
       Ein Text wird so oft dupliziert, wie im 2. Parameter angegeben
       Beispiel: repeat("ha", 5) 
                 gibt den Text "hahahahaha" zurück
    
	   http://rosettacode.org/wiki/Repeat_a_string#Java
	   Works with: Java version 1.5+
	*/
	public static String repeat(String str, int times){
		return new String(new char[times]).replace("\0", str);
	} // repeat
	
	// Gleitkommazahl in Text umwandeln
	public static String fktDoubleToStringFormat(double Zahl, int AnzahlStellen) {
		double dblWert;
		String strFormat;
		String strErgebnis = "";
		
		dblWert = fktRunden(Zahl, AnzahlStellen);
		
		strFormat = "#0."+repeat("0", AnzahlStellen);
		NumberFormat formatter = new DecimalFormat(strFormat); 
		strErgebnis = formatter.format(dblWert);

		// Punkt durch Komma ersetzen. Dadurch ist sichergestellt, dass im Ergebnis kein Punkt als Dezimaltrennzeichen steht.
    	strErgebnis = strErgebnis.replace(".", ",");
    	
		return strErgebnis;
	} // fktDoubleToStringFormat

	/*
		Text in Zahl umwandeln
		Ist der übergebene Text leer, wird 0 zurückgegeben
	*/
	public static double fktBlankToNumber(String strParameter){
    	double Ergebnis = 0;
    	if (strParameter.equals("") == false) {
           	Ergebnis = Double.parseDouble(strParameter);
   		}
		return Ergebnis;		
    } // fktBlankToNumber

	// in einem String die Ziffern 0 bis 9 mittels HTML-Code tiefstellen
	public static String fktZiffernTiefstellen(String strParameter) {
		int intIndex;
		String strErgebnis = "";
		
		strErgebnis = strParameter;
		for (intIndex = 0; intIndex <= (9); intIndex++)
		{
			strErgebnis = strErgebnis.replaceAll(Integer.toString(intIndex), "<sub><small>"+Integer.toString(intIndex)+"</sub></small>");				
		}    	
		return strErgebnis;
	} // fktZiffernTiefstellen

	public static String fktSignifikanteStellen(double dblZahl, int intSigniStellen)
	{
		int intAnzahlZeichen;
		int intKeineNullMehr = 0;							// 0 = Nullen nach dem komma , 1 = Zahlen
		int intAnzahlNullenNachKomma = 0;
		int intAnzahlZeichenVorKomma = 0;
		int intStellenRunden = 0;
		double dblSignifikante;
		String strZahl;
		String strZ;
		String strSignifikante ="";
		char chZeichen;

		strZahl = Double.toString(dblZahl);
        strZahl = strZahl.replace(".", ",");
		String[] splitResult = strZahl.split(",", 6); // –> splitten am Punkt
		 // strZahl = 123.456789
		// splitResult[0] = 123
		// splitResult[1] = 456789

		if (splitResult[0].equals("0") == true)			// Wenn die Zahl nur Nachkomma enthällt, dann...
		{
			intAnzahlZeichen = splitResult[1].length();  		// die Zeichenlänge des Strings wird bestimmt

			for (int x=0;x<=intAnzahlZeichen-1; x++) 		// eine Schleife für jedes Zeichen von links nach rechts
			{
				chZeichen = splitResult[1].charAt(x);    		// einzelne Zeichen werden mit char ermittelt
				strZ = ""+chZeichen;                	// der char wird in einen String umgewandelt

				if ((strZ.equals("0") == true) && (intKeineNullMehr == 0))			// Nullen vor dem ersten Zeichen
				{
					intAnzahlNullenNachKomma = intAnzahlNullenNachKomma + 1;		// Anzahl der Nullen nach dem Komma werden gezählt.
				}
				else 																// Zeichen nach den ersten Nullen
				{
					intKeineNullMehr = 1;											// Erstes Zeichen, ab jetzt werden auch Nullen gezählt.

					// Berechnung
					intStellenRunden = intSigniStellen + intAnzahlNullenNachKomma;	// z.B. 0.001234567 -> 2 Nullen werden dazu gezählt, damit richtig gerundet wird
					//dblSignifikante = Double.parseDouble(splitResult[1]);			// String umwandeln in double
					strZahl = strZahl.replace(",", ".");
					dblSignifikante = Double.parseDouble(strZahl);			// String umwandeln in double
					strSignifikante = ActivityTools.fktDoubleToStringFormat(dblSignifikante, intStellenRunden);
				}
			}
		}
		else											// ...sonst
		{
			// Berechnung
			intAnzahlZeichenVorKomma = splitResult[0].length();											// Länge des Strings vor dem Komma
			intStellenRunden = intSigniStellen - intAnzahlZeichenVorKomma;								// z.B. 123.4567 -> Anzahl der Vorkommastellen werden von den
																										// SignifikantenStellen abgezogen um die die zu rundenen
																										// Stellen zu ermitteln.

			strZahl = strZahl.replace(",", ".");// String umwandeln in double
			dblZahl = Double.parseDouble(strZahl);

			dblSignifikante = Math.round(dblZahl * Math.pow(10, intStellenRunden)) / Math.pow(10, intStellenRunden);

			strSignifikante = Double.toString(dblSignifikante);
		}

		if (dblZahl==0)
		{
			strSignifikante = "0,0";    // Damit bei 0 kein Leer angezeigt wird
		}

		strSignifikante = strSignifikante.replace(".", ",");

		return strSignifikante;
	}



	// **********************************************************************************************
	// ***** Darstellung eines Strings in exponentialer Schreibweise in x Zeichen, ab x Zeichen *****
	// **********************************************************************************************

	public static String fktDarstellungEponential(String strZahl, int intExpoAbZeichen)
	{
		String strExpo = "";
		String strZeichenkette ="";
		double dblZahl;
		int intIstZeichen;

		intIstZeichen = strZahl.length();
		if(intIstZeichen > intExpoAbZeichen)
		{
			strZahl = strZahl.replace(",", ".");
			dblZahl = Double.parseDouble(strZahl);

			intIstZeichen =0;

			while(intExpoAbZeichen != intIstZeichen)
			{
				strZeichenkette = strZeichenkette + "#";
				strExpo = "#." + strZeichenkette + "E0";
				intIstZeichen = strExpo.length();
			}

			strExpo = new DecimalFormat(strExpo).format(dblZahl);
			strExpo = strExpo.replace(",", ".");
		}
		else
		{
			strZahl = strZahl.replace(".", ",");
			strExpo = strZahl;
		}

		if (strExpo.equals("NaN")==true)
		{
			strExpo ="0,0";
		}

		return strExpo;
	}

	// **********************************************************************************************
	// *********** Umrechnung des Wertes bei zu großen und zu kleinen Werten mit neuer Einheit  *****
	// **********************************************************************************************

	public static String fktUmrechnungEinheit(Double dblWert, String strEinheit)
	{
		String strNeuerWert = null;
		String strNeuerWertmitEinheit = null;

		// **********************************************************************************************
		// ****** Alles was kleiner ist als 1 wird auf die nächstkleinere Einheit umgerechnet ***********
		// **********************************************************************************************

		while (dblWert < 1)
		{
			if (strEinheit.equals(" atto g"))
			{
				break;
			}
			if (strEinheit.equals(" femto g"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " atto g";
			}
			if (strEinheit.equals(" piko g"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " femto g";
			}
			if (strEinheit.equals(" nano g"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " piko g";
			}
			if (strEinheit.equals("µg"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " nano g";
			}
			if (strEinheit.equals("mg"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "µg";
			}
			if (strEinheit.equals("g"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "mg";
			}
			if (strEinheit.equals("kg"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "g";
			}
			if (strEinheit.equals(" atto l"))
			{
				break;
			}
			if (strEinheit.equals(" femto l"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " atto l";
			}
			if (strEinheit.equals(" piko l"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " femto l";
			}
			if (strEinheit.equals(" nano l"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " piko l";
			}
			if (strEinheit.equals("µl"))
			{
				dblWert = dblWert * 1000;
				strEinheit = " nano l";
			}
			if (strEinheit.equals("ml"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "µl";
			}
			if (strEinheit.equals("l"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "ml";
			}

			if (strEinheit.equals("ppq"))
			{
				break;
			}
			if (strEinheit.equals("ppt"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "ppq";
			}
			if (strEinheit.equals("ppb"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "ppt";
			}
			if (strEinheit.equals("ppm"))
			{
				dblWert = dblWert * 1000;
				strEinheit = "ppb";
			}
			if (strEinheit.equals("%"))
			{
				dblWert = dblWert * 10000;
				strEinheit = "ppm";
			}
		}


		// **********************************************************************************************
		// ****** Alles was größer ist als 1000 wird auf die nächstgrößere Einheit umgerechnet **********
		// **********************************************************************************************

		while (dblWert > 1000)
		{
			if (strEinheit.equals("kg"))
			{
				break;
			}
			if (strEinheit.equals("g"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "kg";
			}
			if (strEinheit.equals("mg"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "g";
			}
			if (strEinheit.equals("µg"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "mg";
			}
			if (strEinheit.equals(" nano g"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "µg";
			}
			if (strEinheit.equals(" piko g"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " nano g";
			}
			if (strEinheit.equals(" femto g"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " piko g";
			}
			if (strEinheit.equals(" atto g"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " femto g";
			}
			if (strEinheit.equals("l"))
			{
				break;
			}
			if (strEinheit.equals("ml"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "l";
			}
			if (strEinheit.equals("µl"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "ml";
			}
			if (strEinheit.equals(" nano l"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "µl";
			}
			if (strEinheit.equals(" piko l"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " nano l";
			}
			if (strEinheit.equals(" femto l"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " piko l";
			}
			if (strEinheit.equals(" atto l"))
			{
				dblWert = dblWert / 1000;
				strEinheit = " femto l";
			}
			if (strEinheit.equals("%"))
			{
				break;
			}
			if (strEinheit.equals("ppm"))
			{
				dblWert = dblWert / 10000;
				strEinheit = "%";
			}
			if (strEinheit.equals("ppb"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "ppm";
			}
			if (strEinheit.equals("ppt"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "ppb";
			}
			if (strEinheit.equals("ppq"))
			{
				dblWert = dblWert / 1000;
				strEinheit = "ppt";
			}
		}

		if(dblWert < 0.00000001)
		{
			strNeuerWert = new DecimalFormat("#.####E0").format(dblWert);
		}
		else
		{
			strNeuerWert= new DecimalFormat("#.########").format(dblWert);
		}


		strNeuerWertmitEinheit = strNeuerWert + " " + strEinheit;
		return strNeuerWertmitEinheit;
	}

	public static String fktUmrechnungKonzentration(Double dblppmWert, String strEinheit)
	{
		double dblWert = 0;
		String strNeueKonz = null;
		String strNeueKonzMitEinheit = null;

		if (strEinheit.equals("g/ml"))
		{
			dblWert = dblppmWert / 1000000;
		}
		if (strEinheit.equals("%"))
		{
			dblWert = dblppmWert / 10000;
		}
		if (strEinheit.equals("g/l"))
		{
			dblWert = dblppmWert / 1000;
		}
		if (strEinheit.equals("mg/ml"))
		{
			dblWert = dblppmWert / 1000;
		}
		if (strEinheit.equals("mg/l"))
		{
			dblWert = dblppmWert; // entspricht ppm, nur Runden
		}
		if (strEinheit.equals("µg/ml"))
		{
			dblWert = dblppmWert; // entspricht ppm, nur Runden
		}
		if (strEinheit.equals("ppm"))
		{
			dblWert = dblppmWert; // nur Runden
		}
		if (strEinheit.equals("µg/l"))
		{
			dblWert = dblppmWert * 1000; // entspricht ppb
		}
		if (strEinheit.equals("ppb"))
		{
			dblWert = dblppmWert * 1000;
		}
		if (strEinheit.equals("ng/l"))
		{
			dblWert = dblppmWert * 1000000;
		}
		if (strEinheit.equals("ppt"))
		{
			dblWert = dblppmWert * 1000000;
		}

		if(dblWert < 0.00000001)
		{
			strNeueKonz = new DecimalFormat("#.####E0").format(dblWert);
		}
		else
		{
			strNeueKonz = new DecimalFormat("#.########").format(dblWert);
		}

		strNeueKonzMitEinheit = strNeueKonz + " " + strEinheit;
		return strNeueKonzMitEinheit;
	}

	
} // ActivityTools
