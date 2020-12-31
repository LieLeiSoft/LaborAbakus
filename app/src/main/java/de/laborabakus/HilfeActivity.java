package de.laborabakus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class HilfeActivity extends Activity {
	List<Map<String, String>> hilfeListe = new ArrayList<Map<String,String>>();
	String[][] Hilfe = new String[40][4];
	int intFeldNr_max = 0;
	String strHilfe;
	String strAuswahl;
	String strKonzAuswahl;
	String strBerechnungUeber;

	// 4 Spalten pro Hilfetext:
	// Spalte 0: Kapitel
	// Spalte 1: Überschrift, die in der Liste angezeigt wird (ListView)
	// Spalte 2: Überschrift, die in der Titelleiste des Meldungsfensters angezeigt wird
	// Spalte 3: Hilfetext

	private void erstelle_Hilfe_Menue(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gravimetrische Berechnungen";
		Hilfe[intFeldNr][2] = "Gravimetrische Berechnungen";
		Hilfe[intFeldNr][3] = "In dieser Routine lässt sich der Verlust und/oder " +
				"der Rest einer Substanz vor und nach einer Analyse mithilfe einer " +
				"Analysenwaage bestimmen. Z.B. Sulfatasche (Rest) oder Trockenverlust (Verlust).";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Statistische Berechnungen";
		Hilfe[intFeldNr][2] = "Statistische Berechnungen";
		Hilfe[intFeldNr][3] = "In dieser Routine lassen sich in der sogenannten Fehlerausgleichsrechnung " +
				"arithmetischer Mittelwert, absolute Abweichung, Standardabweichung und die " +
				"relative Standardabweichung in Prozent berechnen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Verdünnen von konzentrierten Lösungen";
		Hilfe[intFeldNr][2] = "Verdünnen von konzentrierten Lösungen";
		Hilfe[intFeldNr][3] = "In dieser Routine lässt sich entweder die eingesetzte Menge einer" +
				" vordefinierten konzentrierten Lösung oder die Masse, das Volumen oder der Gehalt" +
				" der hergestellten Verdünnung berechnen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechnung der Endkonzentration einer Verdünnung";
		Hilfe[intFeldNr][2] = "Berechnung der Endkonzentration einer Verdünnung";
		Hilfe[intFeldNr][3] = "Mit dieser Routine lässt sich die Endkonzentration einer " +
				"Verdünnung bzw. Verdünnungsreihe bestimmen. Zum Beispiel kann man von einem Standard, " +
				"über die Reinheit der Ausgangssubstanz, der Einwaage und allen Verdünnungsschritten, " +
				"die Konzentration der hergestellten Standardlösung errechnen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse und Oxidationsstufen";
		Hilfe[intFeldNr][2] = "Molmasse und Oxidationsstufen";
		Hilfe[intFeldNr][3] = "Mit dieser Routine lässt sich die Atommasse einzelner Elemente der " +
				"Haupt- und Nebengruppen bestimmen. Ganze Molmassen von Formeln können ebenfalls " +
				"über das PSE Eingabefeld berechnet werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "PSE - Quiz";
		Hilfe[intFeldNr][2] = "PSE - Quiz";
		Hilfe[intFeldNr][3] = "Dies ist ein Quiz über die Formelzeichen des Periodensystems der Elemente";

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonEinstellungen_SG_BH);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonBeenden);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Beenden";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = strHilfe;


		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Menue

	private void erstelle_Hilfe_End_Konz_einer_Verd(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Allgemeines";
		Hilfe[intFeldNr][2] = "Allgemeines";
		Hilfe[intFeldNr][3] = "In dieser Routine lässt sich die Konzentration einer Substanz " +
				"nach deren Verdünnung berechnen. Dabei können viele Einstellungen, wie z.B. " +
				"die Reinheit, der Aggregatzustand oder die Einheit vom Gehalt der Ausgangssubstanz " +
				"eingestellt werden.\nHilfreich ist diese Routine zum Beispiel bei der Berechnung " +
				"der Endkonzentration einer Standardsubstanz bei deren Verdünnung.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button: >Alle Eingaben löschen<";
		Hilfe[intFeldNr][2] = "Button: >Alle Eingaben löschen<";
		Hilfe[intFeldNr][3] = "Mit diesem Button werden alle zuvor getätigten Eingaben " +
				"wieder gelöscht. Sind alle Eingabefelder leer werden danach wieder alle Einheitsbuttons " +
				"zurück gesetzt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button: >Letzte Eingaben löschen<";
		Hilfe[intFeldNr][2] = "Button: >Letzte Eingaben löschen<";
		Hilfe[intFeldNr][3] = "Beim Betätigen dieses Buttons wird jeweils der letzte Verdünnungsschritt der " +
				"Verdünnung-(sreihe) gelöscht.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Die grauen Einheiten Buttons";
		Hilfe[intFeldNr][2] = "Die grauen Einheiten Buttons";
		Hilfe[intFeldNr][3] = "Mit diesen Buttons kann man die Einheit der Einwaage (Gramm oder Milligramm) " +
				"bzw. des Volumeneinmasses (Milliliter oder Mikroliter) " +
				"und / oder die Einheiten der Volumen der Verdünnungen (Liter, Milliliter oder Mikroliter) ändern. " +
				"Die Einheit vom Gehalt der Substanz lässt sich ebenfalls von % über mg/g (mg/ml) auf ppm anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Die grauen Eingabefelder";
		Hilfe[intFeldNr][2] = "Die grauen Eingabefelder";
		Hilfe[intFeldNr][3] = "In dem ersten Eingabefeld muss immer eine Einwaage (Gramm oder Milligramm) " +
				"bzw. ein Volumeneinmass (Milliliter oder Mikroliter) eingegeben werden. Mit Hilfe des >Weiter< Buttons " +
				"auf der Displaytastatur kommt man zum nächsten Eingabefeld rechts daneben. Je nach Verdünnung kann " +
				"hier das entsprechende Volumen, auf das aufgefüllt wurde, eingegeben werden. " +
				"Wurden noch weitere Verdünnungsschritte durchgeführt, kommt man mit dem >Weiter< Button auf " +
				"der Displaytastatur in die nächste Zeile. Leere Eingabefelder werden bei der Berechnung nicht berücksichtigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Der graue >fest/flüssig< Button";
		Hilfe[intFeldNr][2] = "Der graue >fest/flüssig< Button";
		Hilfe[intFeldNr][3] = "Mit diesem Button muss zuvor der Aggregatzustand der zu verdünnenden Substanz " +
				"eingestellt werden. Die Einheiten der Konzentration der Substanz und die Einwaage bzw. " +
				"das Volumeneinmass wird dabei automatisch umgestellt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Der orangene Einheit Button";
		Hilfe[intFeldNr][2] = "Der orangene Einheit Button";
		Hilfe[intFeldNr][3] = "Beim Betätigen dieses Buttons kann die Wunscheinheit der letzten Verdünnung, " +
				"sprich der Endkonzentration, eingestellt werden. Hierbei ist g/ml die größte und ppb " +
				"(parts per billion) die kleinste Einheit die eingestellt werden kann. Generell wird die " +
				"Endkonzentration aber immer auch auf die obtimalen Einheit berechnet und ausgegeben. " +
				"Folgende Einstellungen sind möglich:\n" +
				"g/ml\n" +
				"%\n" +
				"g/l oder mg/ml (gleich)\n" +
				"mg/l, µg/ml oder ppm (alle gleich)\n" +
				"µg/l oder ppb (ebenfalls gleich)";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Der orangene >Berechne< Button";
		Hilfe[intFeldNr][2] = "Der orangene >Berechne< Button";
		Hilfe[intFeldNr][3] = "Sind alle Eingaben der Verdünnung eingegeben und alle Einheiten eingestellt worden, " +
				"wird beim Betätigen des Buttons die Berechnung durchgeführt. Wurde innerhalb einer Zeile " +
				"auch das Volumen, auf das die Substanz verdünnt wurde eingegeben, wird die Konzentration der Lösung " +
				"des letzten Verdünnungsschrittes errechnet. Sprich => Endkonzentration.\nWurde innerhalb einer Zeile " +
				"nicht auf ein Volumen aufgefüllt (rechtes Feld bleibt leer) also nur ein Volumen abgenommen, dann wird " +
				"keine (End-)Konzentration berechnet, sondern der Gehalt der Sustanz in dem letzten abgenommenen Volumen! " +
				"Sehr kleine Konzentrationen bzw. Gehälter können bei der Ausgabe auch ppt (=0,001 ppb), ng (1 Nanogramm = 0,001µg) " +
				"oder pg (1 Picogramm = 0,000001µg) sein.";

		intFeldNr_max = intFeldNr;

	}// erstelle_Hilfe_End_Konz_einer_Verd

	private void erstelle_Hilfe_Konz_Lsg_Auswahl(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Auswahl";
		Hilfe[intFeldNr][2] = "Auswahl";
		Hilfe[intFeldNr][3] = "In diesem Auswahlmenü wird ein Button einer konzentrierten " +
				"Lösung, die verdünnt werden soll, für die weitere Berechnung " +
				"ausgewählt.";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "anpassen";
		Hilfe[intFeldNr][2] = "anpassen";
		Hilfe[intFeldNr][3] = "Beim Betätigen des anpassen-Buttons öffnet sich eine " +
				"Eingabemaske, in der verschiedene Parameter der jeweiligen konzentrierten Lösung " +
				"angepasst werden können.";


		intFeldNr_max = intFeldNr;
	}  // erstelle_Hilfe_Konz_Lsg_Auswahl

	private void erstelle_Hilfe_Konz_Lsg_Anpassung(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Lösung anpassen";
		Hilfe[intFeldNr][2] = "Lösung anpassen";
		Hilfe[intFeldNr][3] = "Im Eingabefeld Gehalt kann dieser auf eine andere " +
				"Konzentration geändert werden. Mithilfe des grauen Konzentrationsbuttons " +
				"kann man die dazugehörige Einheit auf eine andere vorgegebene Einheit " +
				"umstellen. Dabei wird ein eingegebener Gehalt automatisch umgerechnet. " +
				"Bei allen vorgegebenen Säuren und Laugen ist eine Anpassung der " +
				"Molmasse und der stöchiometrischen Wertigkeit nicht möglich. Eine Änderung " +
				"der Dichte ist ebenfalls nicht möglich. Jedoch wird diese bei einer " +
				"Änderung des Gehaltes automatisch aus einer Tabelle neu ermittelt. Ist " +
				"die stöchiometrische Wertigkeit größer als 1, wird die Einheit mol/l " +
				"im grauen Konzentrationsbutton in M für molare und N für normale Lösungen " +
				"aufgeteilt. " +
				"Alle Mustersäuren und -laugen können im Vergleich zu den vorgegebenen " +
				"Säuren und Laugen inklusive des Namens individuell angepasst werden. " +
				"Vorsicht: Eine automatische Umrechnung der Dichte bei einer Änderung des " +
				"Gehaltes erfolgt hier nicht!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "Hier können alle vorgenommenen Einstellungen (Name, " +
				"Gehalt, Dichte und Molmasse) wieder auf Werkseinstellungen" +
				" zurückgesetzt werden!";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Konz_Lsg_Anpassung

	private void erstelle_Hilfe_Konz_Lsg_gesucht_wird(String strKapitel)
	{
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor prefEditor = prefs.edit();

        strAuswahl = prefs.getString("KonzAuswahl", "0");
        strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);

	    int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Menge der konz. Lösung über eine prozentuale Verdünnung";
		Hilfe[intFeldNr][2] = "... die Menge der konz. Lösung über eine prozentuale Verdünnung";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man die eingesetzte Menge " +
                "an konzentrierter " + strKonzAuswahl + " sucht, um eine bestimmte Masse einer " +
                "verdünnten Lösung mit bekanntem Gehalt herzustellen!";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Menge der konz. Lösung über eine molare Verdünnung";
		Hilfe[intFeldNr][2] = "... die Menge der konz. Lösung über eine molare Verdünnung";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man die eingesetzte Menge " +
                "an konzentrierter " + strKonzAuswahl + " sucht, um ein bestimmtes Volumen einer " +
                "verdünnten Lösung mit bekanntem Gehalt herzustellen!";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Masse der verdünnten prozentualen Lösung:";
		Hilfe[intFeldNr][2] = "... die Masse der verdünnten prozentualen Lösung:";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man wissen möchte, wieviel Milliliter " +
                "verdünnte Lösung mit einer bestimmten Konzentration man bekommt, wenn man eine " +
                "bekannte Menge einer konzentrierten " + strKonzAuswahl + " mit Wasser verdünnt!";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... das Volumen der verdünnten molaren Lösung:";
		Hilfe[intFeldNr][2] = "... das Volumen der verdünnten molaren Lösung:";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man wissen möchte, wieviel Gramm " +
                "verdünnte Lösung mit einer bestimmten Konzentration man bekommt, wenn man eine " +
                "bekannte Menge einer konzentrierten " + strKonzAuswahl + " mit Wasser verdünnt!";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gesucht wird der Gehalt der verdünnten Lösung in Prozent:";
		Hilfe[intFeldNr][2] = "Gesucht wird der Gehalt der verdünnten Lösung in Prozent:";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man wissen möchte, welche Konzentration " +
                "eine Verdünnung bekommt, wenn man eine bekannte Menge an konzentrierter "
        + strKonzAuswahl + "zu einer bekannten Masse mit Wasser verdünnt!";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gesucht wird der Gehalt der verdünnten Lösung in mol/L:";
		Hilfe[intFeldNr][2] = "Gesucht wird der Gehalt der verdünnten Lösung in mol/L:";
		Hilfe[intFeldNr][3] = "Diese Routine wird gewählt, wenn man wissen möchte, welche Konzentration " +
                "eine Verdünnung bekommt, wenn man eine bekannte Menge an konzentrierter "
                + strKonzAuswahl + "zu einem bekanntem Volumen mit Wasser verdünnt!";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Konz_Lsg_gesucht_wird

	private void erstelle_Hilfe_Konz_Lsg_Eingabe(String strKapitel)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();

		strAuswahl = prefs.getString("KonzAuswahl", "0");
		strKonzAuswahl = prefs.getString("KonzAuswahl_"+strAuswahl, strKonzAuswahl);
        strBerechnungUeber = prefs.getString("Berechnung_ueber", strBerechnungUeber);


		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "graue Eingabefelder";
		Hilfe[intFeldNr][2] = "graue Eingabefelder";
		Hilfe[intFeldNr][3] = "Nach Auswahl des gesuchten Parameters, werden hier in den grauen Feldern die" +
				" gegebenen Parameter eingetippt.";

        switch (strBerechnungUeber)
        {
            case "1":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + "  berechnet werden soll.";

                break;

            case "2":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + "  berechnet werden soll.";

                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][2] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][3] = "Mit dem Button mol/l oder g/l kann entschieden werden, in welcher Einheit " +
                        "der Gehalt der verdünnten "  + strKonzAuswahl + " vorliegt und eingegeben werden soll. " +
                        "Bei mehrprotonigen Säuren, wie z.B. Schwefelsäure oder Phosphorsäure mit einer " +
                        "stöchimetrischen Wertigkeit > 1, wird die Einheit mol/l durch M für molare und N für " +
                        "normale Verdünnungen ersetzt. Eine zuvor eingegebene Konzentration wird automatisch " +
                        "beim Betätgen des Buttons umgerechnet.";
                break;

            case "3":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + " eingegeben werden soll. " +
                        "Eine zuvor eingegebene Menge wird automatisch beim Betätgen des Buttons " +
                        "umgerechnet.";

                break;

            case "4":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + " eingegeben werden soll. " +
                        "Eine zuvor eingegebene Menge wird automatisch beim Betätgen des Buttons " +
                        "umgerechnet.";

                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][2] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][3] = "Mit dem Button mol/l oder g/l kann entschieden werden, in welcher Einheit " +
                        "der Gehalt der verdünnten "  + strKonzAuswahl + " vorliegt und eingegeben werden soll. " +
                        "Bei mehrprotonigen Säuren, wie z.B. Schwefelsäure oder Phosphorsäure mit einer " +
                        "stöchimetrischen Wertigkeit > 1, wird die Einheit mol/l durch M für molare und N für " +
                        "normale Verdünnungen ersetzt. Eine zuvor eingegebene Konzentration wird automatisch " +
                        "beim Betätgen des Buttons umgerechnet.";
                break;

            case "5":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + " eingegeben werden soll. " +
                        "Eine zuvor eingegebene Menge wird automatisch beim Betätgen des Buttons " +
                        "umgerechnet.";

                break;

            case "6":
                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][2] = "Button g oder ml - Konz Lösung";
                Hilfe[intFeldNr][3] = "Mit dem Button g oder ml kann entschieden werden, ob die Masse oder das " +
                        "Volumen der konzentrierten "  + strKonzAuswahl + " eingegeben  werden soll. " +
                        "Eine zuvor eingegebene Menge wird automatisch beim Betätgen des Buttons " +
                        "umgerechnet.";

                intFeldNr++;
                Hilfe[intFeldNr][0] = strKapitel;
                Hilfe[intFeldNr][1] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][2] = "Button mol/l, M, N oder g/l - Verdünnung";
                Hilfe[intFeldNr][3] = "Mit dem Button mol/l oder g/l kann entschieden werden, in welcher Einheit " +
                        "der Gehalt der verdünnten "  + strKonzAuswahl + " berechnet werden soll. " +
                        "Mehrprotonigen Säuren, wie z.B. Schwefelsäure oder Phosphorsäure mit einer " +
                        "stöchimetrischen Wertigkeit > 1, können auch in molare (M) oder normale (N) " +
                        "Verdünnungen berechnet werden.";
                break;
        }

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button g oder ml - Verdünnung";
		Hilfe[intFeldNr][2] = "Button g oder ml - Verdünnung";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann die Masse in Gramm oder das Volumen in ml " +
				"der Verdünnung jeweils in die andere Einheit umgewandelt werden. " +
				"Eine Berechnung ist nicht möglich, da für die Umwandlung der Masse zum Volumen " +
				"und umgekehrt die Dichte fehlt, die sich bei jedem Gehalt ändert. Diese kann jedoch aus dem " +
				"errechneten Gehalt mithilfe einer Dichtetabelle ermittelt und danach interpoliert werden. " +
				"Deswegen steht dieser Button auch nur für die Säuren und Laugen zur Verfügung, für die " +
				"in dieser App eine Dichtetabelle existiert. Dazu gehören Salz, Schwefel-, Salpeter-, Phosphor-, " +
				"Essig, Perchlorsäure, Wasserstoffperoxid, Ammoniaklösung, Natron- und Kalilauge.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button Berechne";
		Hilfe[intFeldNr][2] = "Button Berechne";
		Hilfe[intFeldNr][3] = "Sind alle Eingaben getätigt, kann mit dem Berechne Button der gesuchte" +
				" Parameter berechnet werden.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Konz_Lsg_EIngabe

	private void erstelle_Hilfe_Quiz(String strKapitel)
	{
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String strQuizHilfe = prefs.getString("QuizHilfe", "1");
		int intQuizHilfe = Integer.parseInt(strQuizHilfe);

		int intFeldNr = -1;
		switch (intQuizHilfe) {
			case 9:
				strHilfe = getResources().getString(R.string.QuizHilfe_9);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 9";
				Hilfe[intFeldNr][2] = "Level 9";
				Hilfe[intFeldNr][3] = strHilfe;
			case 8:
				strHilfe = getResources().getString(R.string.QuizHilfe_8);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 8";
				Hilfe[intFeldNr][2] = "Level 8";
				Hilfe[intFeldNr][3] = strHilfe;
			case 7:
				strHilfe = getResources().getString(R.string.QuizHilfe_7);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 7";
				Hilfe[intFeldNr][2] = "Level 7";
				Hilfe[intFeldNr][3] = strHilfe;
			case 6:
                strHilfe = getResources().getString(R.string.QuizHilfe_6);
                intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 6";
				Hilfe[intFeldNr][2] = "Level 6";
				Hilfe[intFeldNr][3] = strHilfe;
			case 5:
                strHilfe = getResources().getString(R.string.QuizHilfe_5);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 5";
				Hilfe[intFeldNr][2] = "Level 5";
				Hilfe[intFeldNr][3] = strHilfe;
			case 4:
                strHilfe = getResources().getString(R.string.QuizHilfe_4);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 4";
				Hilfe[intFeldNr][2] = "Level 4";
				Hilfe[intFeldNr][3] = strHilfe;
			case 3:
                strHilfe = getResources().getString(R.string.QuizHilfe_3);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 3";
				Hilfe[intFeldNr][2] = "Level 3";
				Hilfe[intFeldNr][3] = strHilfe;
			case 2:
                strHilfe = getResources().getString(R.string.QuizHilfe_2);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 2";
				Hilfe[intFeldNr][2] = "Level 2";
				Hilfe[intFeldNr][3] = strHilfe;
			case 1:
                strHilfe = getResources().getString(R.string.QuizHilfe_1);
				intFeldNr++;
				Hilfe[intFeldNr][0] = strKapitel;
				Hilfe[intFeldNr][1] = "Level 1";
				Hilfe[intFeldNr][2] = "Level 1";
				Hilfe[intFeldNr][3] = strHilfe;
		}

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Quiz


	private void erstelle_Hilfe_RSD(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Allgemeines";
		Hilfe[intFeldNr][2] = "Die Fehlerrechnung";
		Hilfe[intFeldNr][3] = "Bei der Bestimmung einer physikalischen Größe oder der Durchführung einer " +
				"Analyse kann im allgemeinen nicht erwartet werden, daß der sich ergebene Wert gleich dem " +
				"wahren Wert ist. Daher ist es wichtig, einen Hinweis über die Genauigkeit bzw. Zuverlässigkeit " +
				"der Meßergebnisse in Form einer Fehleranzeige anzubringen. Die folgende Fehlerrechnung gilt nur " +
				"für zufällige Fehler, die mit gleicher Wahrscheinlichkeit positive und negative Werte " +
				"annehmen und mit Hilfe der Statistik abgekürzt werden können. Sie gilt nicht für systematische " +
				"Fehler, verursacht durch immer im gleichen Sinne wirkende Mängel der Meßmethode. Sie gilt " +
				"ebenfalls nicht für persönliche Fehler, die durch die Neigung des Beobachters, immer im " +
				"gleichen Sinne etwas unkorrekt abzulesen, entstehen können.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button >Eingabeliste anzeigen<";
		Hilfe[intFeldNr][2] = "Eingabeliste anzeigen";
		Hilfe[intFeldNr][3] = "Beim Betätigen des Buttons öffnet sich eine Liste der bisherigen eingegebenen " +
				"Werte bzw. Ergebnisse. Rechts neben dem jeweiligen Wert/Ergebnis, wird die entsprechen zugehörige" +
				" absolute Abweichung vom Mittelwert errechnet.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button >Letze Eingabe löschen<";
		Hilfe[intFeldNr][2] = "Letze Eingabe löschen";
		Hilfe[intFeldNr][3] = "Beim Betätigen des Buttons wird der jeweilige letzte eingegebe Wert gelöscht. Bei " +
				"Bedarf können alle Werte der Reihe nach einzeln bis zum Anfang gelöscht werden. Ein " +
				"Wiederherstellen ist nicht möglich.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button >Alle Eingaben löschen<";
		Hilfe[intFeldNr][2] = "Alle Eingaben löschen";
		Hilfe[intFeldNr][3] = "Beim Betätigen des Buttons werden alle eingegeben Werte gelöscht."
				+ " Ein Wiederherstellen ist nicht möglich.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button >Berechne<";
		Hilfe[intFeldNr][2] = "Berechne";
		Hilfe[intFeldNr][3] = "Beim Betätigen des Buttons wird bei vorheriger Eingabe eines Wertes bzw. " +
				"Ergebnisses im Eingabefeld, der neue arithmetische Mittelwert, die Standardabweichung " +
				"und die relative Standardabweichung (% RSD) in Prozent neu berechnet.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingabefeld";
		Hilfe[intFeldNr][2] = "Weitere Eingabe?";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld wird der entsprechende zu berechnende Wert bzw. " +
				"das Ergebnis über die Tastatur eingegeben. Die Tastatur wird durch antippen des " +
				"Eingabefeldes wieder aufgerufen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Ausgabefelder";
		Hilfe[intFeldNr][2] = "Ausgabefelder";
		Hilfe[intFeldNr][3] = "arithmetischer Mittelwert: Wenn n Messungen derselben Größe die Ergebnisse " +
				"x1, x2, x3,..... geliefert haben und alle Einzelmessungen untereinander gleichwertig sind," +
				" dann ist der wahrscheinlichste Wert der gemessenen Größe der arithmetische Mittelwert.\n" +
				"Standardabweichung: Die Standardabweichung ist eine statistische Güteziffer für das" +
				" Meßverfahren.\n% RSD: Als Maß für den relativen, zufälligen Fehler, wird hier die " +
				"relative Standardabweichung (Variationskoeffizient) in Prozent angegeben.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_RSD



	private void erstelle_Hilfe_Einwaage(String strKapitel) {

		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Weiter";
		Hilfe[intFeldNr][2] = "Button > Weiter <";
		Hilfe[intFeldNr][3] = "Wurden alle nötigen Eingaben gemacht, kann mit diesem Button zum"
				+ " nächsten Bildschirm gewechseln werden. Mit der Android Zurücktaste, kann man zum vorheringen"
				+ " Display zurückkehren, um Änderungen bei den Eingaben vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Leergewicht";
		Hilfe[intFeldNr][2] = "Eingabefeld > Tiegel x <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeld wird das reine Gewicht des Einwaagegefäßes eingegeben."
				+ " Das reine Gewicht des leeren Behältnisses ist für die spätere Berechnung unerlässlich."
				+ " Für jede durchnumerierte Probe wird vorher ein eigenes Tiegelgewicht-Eingabefeld generiert.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Nettoeinwaage / Bruttoeinwaage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Probe x <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeld gibt es je nach der vorgenommenen Einstellung zwei Optionen.\n"
				+ " Option 1 (Standard): Nettoeinwaage. Wurde die Nettoeinwaage ausgewählt, dann muss in diesem"
				+ " Eingabefeld das reine Gewicht der Probe eingegeben werden. Das reine Nettogewicht erhält man "
				+ " in der Regel, wenn man vor der Einwaage der Probe auf der Waage die Tara Taste betätigt,"
				+ " damit das Gewicht des Gefäßes auf 0,000 gesetzt wird.\n"
				+ " Option 2: Bruttoeinwaage. Wurde die Bruttoeinwaage ausgewählt, dann muss in diesem"
				+ " Eingabefeld das gesammte Gewicht der Probe inklusive des Probengefäßes eingegeben werden."
				+ " Diese beiden Optionen lassen sich unter Einstellungen auswählen.";

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonEinstellungen_NE_BE);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonHome);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Home";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonBeenden);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Beenden";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = strHilfe;



		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Einwaage

	private void erstelle_Hilfe_Rückwaage(String strKapitel) {

		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Weiter";
		Hilfe[intFeldNr][2] = "Button > Weiter <";
		Hilfe[intFeldNr][3] = "Wurden alle nötigen Eingaben gemacht, kann mit diesem Button zum"
				+ " nächsten Bildschirm gewechseln werden. Mit der Android Zurücktaste, kann man zum vorheringen"
				+ " Display zurückkehren, um Änderungen bei den Eingaben vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Bruttorückwaage der Proben";
		Hilfe[intFeldNr][2] = "Eingabefeld > Probe x <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeld wird das Gewicht des Probengefäßes inklusive Pobenrest"
				+ " nach der Analyse und der Rückwaage eingegeben. Die Rückwaage kann beliebig oft"
				+ " (Entscheidung im nächsten Layout) wiederholt werden.";

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonHome);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Home";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Rückwaage


	private void erstelle_Hilfe_Erneute_Rückwaage(String strKapitel) {

		int intFeldNr = 0;

		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Wiederholung der Rückwaage";
		Hilfe[intFeldNr][2] = "Wiederholung der Rückwaage";
		Hilfe[intFeldNr][3] = "Bei einigen Analysen wird eine erneute Rückwaage vorgeschrieben."
				+ " Zum Beispiel die Rückwaage des Probengefäßes bis zur Gewichtskonstanz. Das heißt eine"
				+ " Auswertung der Rückwaage ist nur zulässig, wenn die Differenz zwischen vorheriger und"
				+ " erneuter Rückwaage nicht zu groß ist. Diese Differenz wird nach der 2. Rückwaage berechnet"
				+ " und angezeigt. Ist die Differenz einzelner Rückwaagen zu groß können diese im linken Kreis"
				+ " angewählt werden";

		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Erneute Rückwaage";
		Hilfe[intFeldNr][2] = "Button > Erneute Rückwaage <";
		Hilfe[intFeldNr][3] = "Ist die Auswahl der erneunten Rückwaage vorgenommen worden, können einzelne Rückwaagen"
				+ " beim Betätigen des Buttons wiederholt werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechnung";
		Hilfe[intFeldNr][2] = "Button > Berechnung <";
		Hilfe[intFeldNr][3] = "Wenn die (erneute) Rückwaage den Anforderungen entspricht, kann mit diesem Button zum"
				+ " nächsten Bildschirm gewechseln werden. Der Prozentuale Anteil des Restes und des Verlustes wird"
				+ " für jede Probe errechnet.";

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonHome);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Home";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Erneute_Rückwaage


	private void erstelle_Hilfe_Berechnung(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "%Rest und %Verlust";
		Hilfe[intFeldNr][2] = "%Rest und %Verlust";
		Hilfe[intFeldNr][3] = "Hier wird der errechnete Rest und Verlust in Prozent " +
				"angezeigt. Der Rest ist der Anteil der nach der letzten Rückwaage von der " +
				"Einwaage übrig geblieben ist. Der Verlust ist der Anteil, der nach der " +
				"letzten Rückwaage aus der Einwaage verschwunden ist. Idealerweise sollten beide " +
				"zusammen 100% ergeben.";

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonEinstellungen_NKS);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonHome);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Home";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = strHilfe;

		intFeldNr++;
		strHilfe = getResources().getString(R.string.ButtonBeenden);
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Beenden";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = strHilfe;


		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Berechnung


	private void erstelle_Hilfe_Molmassen(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Allgemeines!";
		Hilfe[intFeldNr][2] = "Allgemeines!";
		Hilfe[intFeldNr][3] = "In diesem Layout kann die Molmasse der gesuchten Substanz bzw. der Maßlösung berechnet werden."
				+ " Achtung WICHTIG! Es ist zu beachten, dass die Molmasse nur dann zur Faktorberechnung 1:1 übernommen werden"
				+ " kann, wenn die gesuchte Substanz zu 100% von der Maßlösung umgesetzt wird. Die berechnete Molmasse wird"
				+ " beim Zurückkehren automatisch in dem Eingabefeld Molmasse übernommen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button > Zurück <";
		Hilfe[intFeldNr][2] = "Button > Zurück <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann man zu dem vorherigen"
				+ " Bildschirm zurück kehren. Die berechnete Molmasse wird dabei übernommen und in dem vorherigen Eingabefeld"
				+ " Molmasse übertragen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button > Hauptgruppenelemente <";
		Hilfe[intFeldNr][2] = "Button > Hauptgruppenelemente <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann zwischen den Haupt- und Nebengruppenelementen gewechselt werden."
				+ " Die Lanthanoide und Actinoide werden nicht angezeigt!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Element-Button (z.B. H, Li, Be, B, C, N, ...)";
		Hilfe[intFeldNr][2] = "Element-Button (z.B. H, Li, Be, B, C, N, ...)";
		Hilfe[intFeldNr][3] = "Beim Betätigen eines Element-Buttons wird das entsprechende Elementsymbol in der Liveanzeige,"
				+ " beziehungsweise hinter der bereits bestehenden Formel angezeigt."
				+ " Gleichzeitig wird die Atommasse des Elements zu der Molmasse des Moleküls dazu addiert. Nebengruppenelemente"
				+ " können nach Betätigen des Hauptgruppenelemente-Buttons eingegeben werden. Von den Lanthanoide und Actinoide können"
				+ " keine Atommassen berechnet werden.";
		
   		/*							// habe hier versucht das "Pfeil-zurück-Symbol" anzeigen zu lassen. Funzt nicht! :-(
   		int resId;
   		EditText et;
   		String strBack;
   		
		resId = R.string.Back;
        et = (EditText) findViewById(resId);
    	strBack = et.getText().toString();
		*/

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button <- ";
		Hilfe[intFeldNr][2] = "Button <- ";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann die zuvor eingegebene Formel und die berechnetete Molmasse wieder gelöscht werden."
				+ " Ein schrittweises rückgängiges Löschen einzelner Elemente ist nicht möglich.";


		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Indexzahl-Button (z.B. 0, 1, 2, 3, ...)";
		Hilfe[intFeldNr][2] = "Indexzahl-Button (z.B. 0, 1, 2, 3, ...)";
		Hilfe[intFeldNr][3] = "Beim Betätigen eines Indexzahl-Buttons wird die entsprechende Indexzahl tiefgestellt in der Liveanzeige angezeigt."
				+ " Höhere Potenzen (10er oder 100er) sind ebenfalls möglich. Indexzahlen können ausschließlich hinter einem Element oder"
				+ " einer geschlossenen Klammer eingegeben werden. Ansonsten werden sie ausgeblendet. Die Null erscheint erst ab einer"
				+ " möglichen Zehnerpotenz. Bei der Berechnung wird das jeweilige einzelne Element oder die ganze Klammer mit der Indexzahl"
				+ " multipliziert und zur Molmasse addiert. Die Index-Zahlen von 5 bis 9 befinden sich bei den Nebengruppenelementen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Klammer-Button > ( <";
		Hilfe[intFeldNr][2] = "Klammer-Button > ( <";
		Hilfe[intFeldNr][3] = "Beim Betätigen des Klammer-Buttons wird das entsprechende Symbol in der Liveanzeige angezeigt. Es"
				+ " können nicht mehrere Klammern ineinander verschachtelt werden! Das Klammer zu -Symbol erscheint erst, nachdem"
				+ " mindestens ein Element eingegeben wurde. Ein neues Klammer auf -Symbol wird erst wieder angezeigt, nachdem"
				+ " die alte Klammer geschlossen wurde. Eckige Klammern (Komplexe) können nicht eingegeben werden. Diese Formeln "
				+ " müssen als Summenformel eingegeben werden.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Molmassen

	private void erstelle_Hilfe_Oxidationsstufen(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Allgemeines!";
		Hilfe[intFeldNr][2] = "Allgemeines!";
		Hilfe[intFeldNr][3] = "Die Oxidationsstufe (auch Oxidationszahl, Oxidationswert,"
				+ " elektrochemische Wertigkeit) gibt die Ionenladung eines Atoms innerhalb"
				+ " einer chemischen Verbindung an. Atome denen Elektronen fehlen, haben"
				+ " eine positive Oxidationsstufe. Atome die Elektronen im Überschuss haben,"
				+ " sind dabei negativ geladen und haben eine negative Oxidationsstufe."
				+ " Die Anzahl der Oxidationsstufen der Elemente ist unterschiedlich."
				+ " Welche Oxidationsstufe ein Atom eines Elements einnimmt hängt dabei immer"
				+ " vom Reaktionspartner ab."
				+ " Die Oxidationsstufe eines Elements wird durch römischen Ziffern dargestellt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button > Zurück <";
		Hilfe[intFeldNr][2] = "Button > Zurück <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann man zu dem vorherigen"
				+ " Bildschirm zurück kehren.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Oxidatonstufen bei organischen Verbindungen";
		Hilfe[intFeldNr][2] = "Oxidatonstufen bei organischen Verbindungen";
		Hilfe[intFeldNr][3] = "In organischen Verbindungen kann der Kohlenstoff in mehreren verschiedenen"
				+ " Oxidiationsstufen vorkommen. Eine genaue Aussage hierüber kann nur in der Strukturformel"
				+ " gezeigt werden, nicht aber wie hier in der Summenformel. Bei der Eingabe EINES Kohlenstoffzeichens"
				+ " welches mehrfach vorhanden ist, wird immer nur EINE Oxidationsstufe für dieses Zeichen errechnet."
				+ " Eine korrekte Anzeige der Oxidationsstufen von meheren C-Atomen mit verschiedenen Oxidationsstufen wie in"
				+ " organischen Verbindungen ist in der Summenformel somit nicht möglich!";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Molmassen

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hilfe);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
		ActivityRegistry.register(this);

		Bundle extras = getIntent().getExtras();
		String strKapitel;

		strKapitel = extras.getString("Kapitel");

		if (strKapitel.equals("Menue") == true) {
			erstelle_Hilfe_Menue(strKapitel);
		} else if (strKapitel.equals("RSD") == true) {
			erstelle_Hilfe_RSD(strKapitel);
		} else if (strKapitel.equals("Einwaage") == true) {
			erstelle_Hilfe_Einwaage(strKapitel);
		} else if (strKapitel.equals("Erneute_RW") == true) {
			erstelle_Hilfe_Erneute_Rückwaage(strKapitel);
		} else if (strKapitel.equals("RW") == true) {
			erstelle_Hilfe_Rückwaage(strKapitel);
		} else if (strKapitel.equals("Molmassen") == true) {
			erstelle_Hilfe_Molmassen(strKapitel);
		} else if (strKapitel.equals("Oxidationsstufen") == true) {
			erstelle_Hilfe_Oxidationsstufen(strKapitel);
		} else if (strKapitel.equals("Berechnung") == true) {
			erstelle_Hilfe_Berechnung(strKapitel);
		} else if (strKapitel.equals("Konz_Lsg_Auswahl") == true) {
			erstelle_Hilfe_Konz_Lsg_Auswahl(strKapitel);
		} else if (strKapitel.equals("Konz_Lsg_Anpassung") == true) {
			erstelle_Hilfe_Konz_Lsg_Anpassung(strKapitel);
		} else if (strKapitel.equals("Konz_Lsg_gesucht wird") == true) {
			erstelle_Hilfe_Konz_Lsg_gesucht_wird(strKapitel);
		} else if (strKapitel.equals("Konz_Lsg_Eingabe") == true) {
			erstelle_Hilfe_Konz_Lsg_Eingabe(strKapitel);
		} else if (strKapitel.equals("End_Konz_einer_Verd") == true) {
			erstelle_Hilfe_End_Konz_einer_Verd(strKapitel);
		} else if (strKapitel.equals("Quiz") == true) {
			erstelle_Hilfe_Quiz(strKapitel);
		};

		initList();

		// Die ListView-Komponente kommt aus dem Layout
		ListView lv = (ListView) findViewById(R.id.lvHilfe);

		// Der 'SimpleAdapter' erwartet folgende Parameter:
		//  1. Kontext-Referenz (Activity)
		//  2. Daten, die angezeigt werden sollen (hier vom Typ 'ArrayList')
		//  3. Layout, das für jede Zeile in der Liste verwendet werden soll
		//  4. String-Array mit den Schlüsseln, nach denen die Datenliste gefiltert werden soll (hier: 'Kapitel')
		//  5. Integer-Array mit den View-IDs, die je Zeile angezeigt werden sollen
		//  Die Größe der Arrays der Parameter 4 und 5 muss identisch sein!
		//SimpleAdapter simpleAdpt = new SimpleAdapter(this, hilfeListe, android.R.layout.simple_list_item_1, new String[] {strKapitel}, new int[] {android.R.id.text1});
		SimpleAdapter simpleAdpt = new SimpleAdapter(this, hilfeListe, R.layout.my_listview, new String[] {strKapitel}, new int[] {R.id.tvHilfezeile});

		lv.setAdapter(simpleAdpt);

		// hier wird festgelegt, was passieren soll, wenn der Anwender eine Zeile anklickt:
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {

				LinearLayout ll = (LinearLayout) view;
				TextView clickedView = (TextView) ll.getChildAt(0);

				// es ist bekannt, dass der angeklickte View eine TextView ist; er wird daher als solcher angesprochen
				//TextView clickedView = (TextView) view;

				for (int intFeldNr=0; intFeldNr<=intFeldNr_max; intFeldNr++) {
					if (Hilfe[intFeldNr][1] == clickedView.getText()) {
						AlertDialog.Builder builder = new AlertDialog.Builder(HilfeActivity.this);
						builder.setTitle(Hilfe[intFeldNr][2]);
						builder.setMessage(Hilfe[intFeldNr][3]);
						builder.setPositiveButton("OK",
								new DialogInterface.OnClickListener()
								{
									public void onClick(DialogInterface dialog, int id)
									{
										dialog.dismiss();
									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();

						break; // for-Schleife vorzeitig beenden
					} // if (Hilfe[zeile][1] == clickedView.getText())
				} // for
			} // onItemClick
		}); // setOnItemClickListener
	} // onCreate

	private void initList() {
		for (int zeile=0; zeile<=intFeldNr_max; zeile++) {
			hilfeListe.add(erstelleHilfe(Hilfe[zeile][0], Hilfe[zeile][1]));
		}
	}

	private LinkedHashMap<String, String> erstelleHilfe(String key, String name) {
		LinkedHashMap<String, String> hilfetext = new LinkedHashMap<String, String>();
		hilfetext.put(key, name);

		return hilfetext;
	}

} // HilfeActivity
