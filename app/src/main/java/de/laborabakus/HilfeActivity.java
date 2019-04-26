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
	String[][] Hilfe = new String[30][4];
	int intFeldNr_max = 0;
	String strHilfe;

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

	private void erstelle_Hilfe_Konz_Lsg_Auswahl(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Auswahl";
		Hilfe[intFeldNr][2] = "Auswahl";
		Hilfe[intFeldNr][3] = "In diesem Auswahlmenü wird eine konzentrierte" +
				" Lösung, die verdünnt werden soll, ausgewählt. Jede Lösung" +
				" kann individuell durch den >Anpassung< Button bei dem Gehalt," +
				" der Dichte und der Molmasse eingestellt oder komplett mit neuem" +
				" Namen verändert werden.";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "anpassen";
		Hilfe[intFeldNr][2] = "anpassen";
		Hilfe[intFeldNr][3] = "Jede Lösung kann individuell durch den >Anpassung<" +
				" Button bei dem Gehalt, der Dichte und der Molmasse eingestellt" +
				" oder komplett mit neuem Namen verändert werden. Da die Molmasse" +
				" für jeden Stoff spezifisch ist und die Dichte zusätzlich noch von" +
				" der Konzentration abhängt, sollten diese Werte nur mit Bedacht" +
				" geändert werden. Mit Hilfe des grauen Buttons (% oder mol/L) lässt" +
				" sie die Konzentration der Lösung bei vorhandener Molmasse und Dichte" +
				" von Prozent auf die Stoffmengenkonzentration in mol/L bzw. von der" +
				" Stoffmengenkonzentration auf Prozent unmittelbar umrechnen.";


		intFeldNr_max = intFeldNr;
	}  // erstelle_Hilfe_Konz_Lsg_Auswahl

	private void erstelle_Hilfe_Konz_Lsg_Anpassung(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "anpassen";
		Hilfe[intFeldNr][2] = "anpassen";
		Hilfe[intFeldNr][3] = "Jede Lösung kann individuell durch den >Anpassung<" +
				" Button bei dem Gehalt, der Dichte und der Molmasse eingestellt" +
				" oder komplett mit neuem Namen verändert werden. Da die Molmasse" +
				" für jeden Stoff spezifisch ist und die Dichte zusätzlich noch von" +
				" der Konzentration abhängt, sollten diese Werte nur mit Bedacht" +
				" geändert werden. Mit Hilfe des grauen Buttons (% oder mol/L) lässt" +
				" sie die Konzentration der Lösung bei vorhandener Molmasse und Dichte" +
				" von Prozent auf die Stoffmengenkonzentration in mol/L bzw. von der" +
				" Stoffmengenkonzentration auf Prozent unmittelbar umrechnen.";

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
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Menge der konz. Lösung über eine prozentuale Verdünnung";
		Hilfe[intFeldNr][2] = "... die Menge der konz. Lösung über eine prozentuale Verdünnung";
		Hilfe[intFeldNr][3] = "Gesucht: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Masse (g) der Verdünnung\n" +
				"Gegeben: Gehalt (%) der Verdünnung";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Menge der konz. Lösung über eine molare Verdünnung";
		Hilfe[intFeldNr][2] = "... die Menge der konz. Lösung über eine molare Verdünnung";
		Hilfe[intFeldNr][3] = "Gesucht: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Volumen (ml) der Verdünnung\n" +
				"Gegeben: Gehalt (mol/L) der Verdünnung";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... die Masse der verdünnten prozentualen Lösung:";
		Hilfe[intFeldNr][2] = "... die Masse der verdünnten prozentualen Lösung:";
		Hilfe[intFeldNr][3] = "Gesucht: Masse (g) der Verdünnung\n" +
				"Gegeben: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Gehalt (%) der Verdünnung";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "... das Volumen der verdünnten molaren Lösung:";
		Hilfe[intFeldNr][2] = "... das Volumen der verdünnten molaren Lösung:";
		Hilfe[intFeldNr][3] = "Gesucht: Volumen (ml) der Verdünnung\n" +
				"Gegeben: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Gehalt (mol/L) der Verdünnung";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gesucht wird der Gehalt der verdünnten Lösung in Prozent:";
		Hilfe[intFeldNr][2] = "Gesucht wird der Gehalt der verdünnten Lösung in Prozent:";
		Hilfe[intFeldNr][3] = "Gesucht: Gehalt (%) der Verdünnung\n" +
				"Gegeben: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Masse (g) der Verdünnung";

        intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gesucht wird der Gehalt der verdünnten Lösung in mol/L:";
		Hilfe[intFeldNr][2] = "Gesucht wird der Gehalt der verdünnten Lösung in mol/L:";
		Hilfe[intFeldNr][3] = "Gesucht: Gehalt (mol/L) der Verdünnung\n" +
				"Gegeben: Masse (g) oder Volumen (ml) der konzentrierten Lösung\n" +
				"Gegeben: Volumen (ml) der Verdünnung";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Konz_Lsg_gesucht_wird

	private void erstelle_Hilfe_Konz_Lsg_Eingabe(String strKapitel)
	{
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingabe";
		Hilfe[intFeldNr][2] = "Eingabe";
		Hilfe[intFeldNr][3] = "Nach Auswahl des gesuchten Parameters, werden hier in den grauen Feldern die" +
				" gegebenen Parameter eingetippt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button g/ml";
		Hilfe[intFeldNr][2] = "Button g/ml";
		Hilfe[intFeldNr][3] = "Mit dem Button (g/ml) kann entschieden werden, ob die Masse oder das " +
				"Volumen der konzentrierten Lösung eingegeben bzw. berechnet werden soll.";

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
				+ " wird auch immer nur EINE Oxidationsstufe für dieses Zeichen errechnet."
				+ " Eine korrekte Ausgabe der Oxidationsstufen von"
				+ " organischen Verbindungen ist der Summenformel somit nicht möglich!";

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
