package de.laborabakus;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ActivityTools {
	// Gleitkommazahl runden
	public static double fktRunden(double Zahl, int AnzahlStellen) {
		long Dummy =  (long) Math.pow(10, AnzahlStellen);
		double Ergebnis = (long) ((Zahl*Dummy) + (0.5*Math.signum(Zahl))) / (Dummy*1.0); // *1.0 damit's ein double wird!
		
		return Ergebnis;		
	} // fktRunden

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
/*
	public static double fktSignifikanteStellen(String strZahl, int intAnzahlStellen)
	{
		// int pos = strZahl.indexOf('.');
		//int vorKomma = Integer.parseInt(strZahl.substring(0, pos));
		//String strNachKomma = strZahl.substring(pos+1, strZahl.length());
		//int NachKomma = Integer.parseInt(strNachKomma);
		char chZeichen;
		String strZ; 			    // einzelnes Zeichen
		int intAnzahlZeichen;
		int intCounter=0;
		int intNachkomma =0;
		String strNeuesZeichen ="";

		intAnzahlStellen = intAnzahlStellen + 1; // wichtig für Runden

		intAnzahlZeichen = strZahl.length();   // die Zeichenlänge des Strings wird bestimmt

		for (int x=1;x<=intAnzahlZeichen; x++) // eine Schleife für jedes Zeichen von links
		// nach rechts
		{
			chZeichen = strZahl.charAt(x);      // einzelne Zeichen werden mit char ermittelt
			strZ = ""+chZeichen;                // der char wird in einen String umgewandelt

			if (strZ != "." && intNachkomma =0)
			// wenn das Zeichen keinen . enthält
			{				           // oder man noch vor dem Komma ist
				intCounter = intCounter + 1;     // dann Counter = Counter +1
			}

			if (strZ.equals("0") && strNeuesZeichen.equals("") == true) // wenn am Anfang
			// eine 0 steht
			{
				strZ = "";                       // wird die 0 gelöscht
				intCounter = 0;                  // und der Counter auf 0 gesetzt
			}
			if (intCounter == intAnzahlStellen) // wenn der Counter die Anzahl Stellen hat
			{
				strZ = "0";			    // wird für das Zeichen eine 0 gesetzt

			}
			if (strZ == ".")                    // wird die Nachkommastelle erreicht
			{
				if (strNeuesZeichen.equals(""))  // … und die Ganzzahl ist 0
				{
					strNeuesZeichen = "0";       // … wird eine 0 vor dem Komma gesetzt
				}

				intNachkomma =1;                // und sich gemerkt das man nach dem Komma ist

			}
			if (strZ != "." && intNachkomma =1) 	 // wenn das Zeichen keinen "." enthält
			{				          				 // oder man noch nach dem Komma ist
				intCounter = intCounter + 1;     	 // dann Counter = Counter +1
			}


			strNeuesZeichen = strNeuesZeichen + strZ;  // neues Zeichen wird zusammen gesetzt


		}





		double dblSignifikante;
		dblSignifikante = Double.parseDouble(strZahl);       //  String wird in Zahl umgewandelt

		dblSignifikante = (Math.round(dblSignifikante));      //  Zahl wird auf Ganzzahl gerundet

		return dblSignifikante;
	}
*/

	
} // ActivityTools
