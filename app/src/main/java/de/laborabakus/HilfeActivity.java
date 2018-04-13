package de.laborabakus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class HilfeActivity extends Activity {
	List<Map<String, String>> hilfeListe = new ArrayList<Map<String,String>>();
	String[][] Hilfe = new String[10][4];
	int intFeldNr_max = 0;

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
				"arithmetischer Mittelwert, absulute Abweichung, Standardabweichung und die " +
				"relative Standardabweichung in Prozent berechnen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse und Oxidationsstufen";
		Hilfe[intFeldNr][2] = "Molmasse und Oxidationsstufen";
		Hilfe[intFeldNr][3] = "Mit dieser Routine lässt sich die Atommasse einzelner Elemente der " +
				"Haupt- und Nebengruppen bestimmen. Ganze Molmassen von Formeln können ebenfalls " +
				"über das PSE Eingabefeld berechnet werden.";


		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Menue


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
				+ " Dies beiden Optionen lassen sich unter Einstellungen auswählen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "(Button: weißer Schüssel - blauer Hintergrund) Unter Einstellungen lässt"
				+ " sich die Anzahl der gerundeten Nachkommastellen"
				+ " von dem errechneten Rest bzw. dem verlust einstellen. Desweiteren lässt"
				+ " sich bei einigen Layouts"
				+ " die Schriftgröße und Buttonhöhe individuell anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = "(Button: schwarzes Haus - weißer Kreis)\n"
				+ "Mit diesem Button kehrt man zum Hauptmenü zurück.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = "(Button: weißes Kreuz - roter Hintergrund)\n"
				+ "Wird dieser Button betätigt, wird die App beendet.";



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
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "(Button: weißer Schüssel - blauer Hintergrund) Unter Einstellungen lässt"
				+ " sich die Anzahl der gerundeten Nachkommastellen"
				+ " von dem errechneten Rest bzw. dem verlust einstellen. Desweiteren lässt"
				+ " sich bei einigen Layouts"
				+ " die Schriftgröße und Buttonhöhe individuell anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = "(Button: schwarzes Haus - weißer Kreis)\n"
				+ "Mit diesem Button kehrt man zum Hauptmenü zurück.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = "(Button: weißes Kreuz - roter Hintergrund)\n"
				+ "Wird dieser Button betätigt, wird die App beendet.";

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
		Hilfe[intFeldNr][3] = "Ist die Auswahl der erneunten rückwaage vorgenommen worden, können einzelne Rückwaagen"
				+ " beim Betätigen des Buttons wiederholt werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechnung";
		Hilfe[intFeldNr][2] = "Button > Berechnung <";
		Hilfe[intFeldNr][3] = "Wenn die (erneute) Rückwaage den Anforderungen entspricht, kann mit diesem Button zum"
				+ " nächsten Bildschirm gewechseln werden. Der Prozentuale Anteil des Restes und des Verlustes wird"
				+ " für jede Probe errechnet.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "(Button: weißer Schüssel - blauer Hintergrund) Unter Einstellungen lässt"
				+ " sich die Anzahl der gerundeten Nachkommastellen"
				+ " von dem errechneten Rest bzw. dem verlust einstellen. Desweiteren lässt"
				+ " sich bei einigen Layouts"
				+ " die Schriftgröße und Buttonhöhe individuell anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Home-Button <";
		Hilfe[intFeldNr][3] = "(Button: schwarzes Haus - weißer Kreis)\n"
				+ "Mit diesem Button kehrt man zum Hauptmenü zurück.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "> Beenden-Button <";
		Hilfe[intFeldNr][3] = "(Button: weißes Kreuz - roter Hintergrund)\n"
				+ "Wird dieser Button betätigt, wird die App beendet.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Erneute_Rückwaage


	private void erstelle_Hilfe_Berechnung(String strKapitel) {
		int intFeldNr = 0;

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "(Button: weißer Schüssel - blauer Hintergrund) Unter Einstellungen lässt"
				+ " sich die Anzahl der gerundeten Nachkommastellen"
				+ " von dem errechneten Gehalt und der relativen Standardabweichung einstellen. Die"
				+ " Nachkommastellen vom Titer können nicht eingestellt werden, weil dieser in der Chemie"
				+ " standardmäßig mit 4 Stellen angegeben wird. Desweiteren lässt sich bei einigen Layouts"
				+ " die Schriftgröße und Buttonhöhe individuell anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechne auf TS";
		Hilfe[intFeldNr][2] = "Umrechnung auf TS";
		Hilfe[intFeldNr][3] = "Die Trockensubstanz ist jener Bestandteil"
				+ " einer Substanz, der nach Abzug des Wassergehalts übrig bleibt."
				+ " Trockensubstanz und Wassergehalt ergänzen sich also zu 100 Prozent."
				+ " Wird zuvor in dem Eingabefeld > Wasser Ø Probe < der Ø Wassergehalt der Proben"
				+ " eingeben, so kann mit Hilfe dieses Buttons der Gehalt (as is) auf die"
				+ " Trockensubstanz (TS) umgerechnet werden. Um den Gehalt wieder auf den"
				+ " as is Wert (= so wie es ist) zu berechnen, muss vor dem erneuten Betätigen"
				+ " des Buttons bei dem Wassergehalt wieder eine 0 eingegeben werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gehalt";
		Hilfe[intFeldNr][2] = "Gehalt in %";
		Hilfe[intFeldNr][3] = "Der Gehalt as is (so wie es ist, inkl. Wasser) oder TS"
				+ " (Trockensubstanz ohne Wasser) wird in Gewichtsprozent angegeben."
				+ " Dabei steht Gewichtsprozent für die Anzahl Gramm pro 100 Gramm. Der Gehalt"
				+ " ist ein Maß für die Reinheit einer Substanz.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titer";
		Hilfe[intFeldNr][2] = "Ausgabefeld > Titer <";
		Hilfe[intFeldNr][3] = "Der Titer ist ein Faktor, der die Abweichung der tatsächlichen"
				+ " Konzentration von der gewünschten Konzentration einer Maßlösung angibt."
				+ " Der Idealwert eines Titers ist somit 1,0000.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "% RSD";
		Hilfe[intFeldNr][2] = "Relative Standardabweichung RSD%";
		Hilfe[intFeldNr][3] = "Relative Standardabweichung ist ein statistisches Maß"
				+ " für die Streuung der Meßwerte in Prozent. Die Anzahl der gerundeten"
				+ " Nachkommastellen lassen sich unter dem Button >Einstellungen< verstellen.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Berechnung



	private void erstelle_Hilfe_Titereingaben(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "zur Titration";
		Hilfe[intFeldNr][2] = "Button > zur Vorlage <";
		Hilfe[intFeldNr][3] = "Wurde in alle Eingaben vorgenommen, kann man mit diesem Button zum"
				+ " nächsten Bildschirm wechseln. Mit der Android Zurücktaste, kann man  zurückkehren,"
				+ " um Änderungen bei den Eingaben vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumetrischer Faktor";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumetrischer Faktor <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss der volumetrische Faktor in mg/ml eingegeben werden."
				+ " Der volumetrische Faktor gibt an, wieviel Milligramm des gesuchten Stoffes ein Milliliter"
				+ " der Maßlösung verbraucht. Wird die gesuchte Substanz vollständig von der Maßlösung umgesetzt,"
				+ " entspricht das genau ein Mol der gesuchten Substanz, welche sich dann aus der Molmasse errechnen lässt."
				+ " Ist der Faktor nicht bekannt, kann er auch über den >berechen< Button bestimmt werden."
				+ " Dieses Eingabefeld wird bei der Berechnung des Titer mit einer anderen Maßlösung nicht benötigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Stoffmengenkonzentration (mol/l)";
		Hilfe[intFeldNr][2] = "Eingabefeld > Stoffmengenkonzentration (mol/l) <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Stoffmengenkonzentration in Mol pro Liter von der"
				+ " Vorlage bzw. des Titranten eingeben werden. Die Stoffmengenkonzentration oder auch veraltet Molarität,"
				+ " ist der Quotient der Stoffmenge (in mol) zu dem Lösungsmittel (in Liter). Ist die Stoffmengenkonzentration"
				+ " nicht bekannt, kann diese auch über den >berechen< Button bestimmt werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titer";
		Hilfe[intFeldNr][2] = "Eingabefeld > Titer <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld wird der Titer der Maßlösung eingegeben."
				+ " Der Titer ist ein Faktor, der die Abweichung der tatsächlichen"
				+ " Konzentration von der gewünschten Konzentration einer Maßlösung angibt."
				+ " Der Idealwert eines Titers ist somit 1,0000. Wird keine Eingabe vorgenommen"
				+ " und zum nächsten Display gewechselt,"
				+ " wird der Titer automatisch auf 1,0000 gesetzt. Mit der Android Zurücktaste,"
				+ " kann man jedoch zurückkehren, und diese gesetzte Eingabe"
				+ " jederzeit korrigieren.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Titereingaben

	private void erstelle_Hilfe_Molaritaet(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Zurück";
		Hilfe[intFeldNr][2] = "Button > Zurück <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kehrt man zum vorherigen Bildschirm zurück."
				+ " Die getätigten Eingaben werden dabei übernommen. Der Zurück Button ist dem"
				+ " Android Zurück Button vorzuziehen!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse";
		Hilfe[intFeldNr][2] = "Eingabefeld > Molmasse < und > berechne < Button";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Molmasse der eingesetzten Substanz für die Maßlösung in Gramm"
				+ " pro Mol eingegeben werden. Ist die Molmasse unbekannt, kann diese auch im nächsten Layout über den berechne"
				+ " Button mit Hilfe des Periodensystems errechnet werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "stöchiometrische Wertigkeit";
		Hilfe[intFeldNr][2] = "Eingabefeld > stöchiometrische Wertigkeit";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die stöchiometrische Wertigkeit der eingesetzten Substanz für die Maßlösung"
				+ " eingegeben werden. Die stöchiometrische Wertigkeit oder auch die Äquivalentzahl, ist die Anzahl der bei einer"
				+ " elektrochemischen Reaktion ausgetauschten Elektronen. Oder auch die Zahl, die angibt, wieviel Wasserstoffatome"
				+ " ein Atom eines chemischen Elementes binden oder ersetzen kann. Sie wird benötigt, um die Äquivalentkonzentration "
				+ " (früher Normalität) aus der Stoffmengenkonzentration (Molarität) zu errechnen."
				+ "  Einige Beispiele:\n"
				+ "Salzsäure HCl = 1\n"
				+ "Schwefelsäure H2S04 = 2\n"
				+ "Phosphorsäure H3PO4 = 3\n"
				+ "Kaliumpermanganat KMnO4 = 5\n"
				+ "(Mn +VII zu Mn +II)\n"
				+ "Kaliumbromat KBrO3 = 6\n"
				+ "(Br +V zu Br -I)";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einwaage der Maßlösung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Einwaage der Maßlösung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Einwaage der eingesetzten Substanz für die Maßlösung in Gramm"
				+ " eingegeben werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumen der Maßlösung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumen der Maßlösung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss das Volumen der Maßlösung in Liter eingegeben werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Reinheit der Einwaage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Gehalt der Einwaage <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Reinheit in Prozent der eingesetzten Substanz für die Maßlösung"
				+ " eingegeben werden.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Molaritaet

	private void erstelle_Hilfe_Faktor(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Zurück";
		Hilfe[intFeldNr][2] = "Button > Zurück <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kehrt man zum vorherigen Bildschirm zurück."
				+ " Die getätigten Eingaben werden dabei übernommen. Der Zurück Button ist dem"
				+ " Android Zurück Button vorzuziehen!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse der gesuchten Substanz";
		Hilfe[intFeldNr][2] = "Eingabefeld > Molmasse der gesuchten Substanz <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Molmasse der gesuchten Substanz in Gramm"
				+ " pro Mol eingegeben werden. Ist die Molmasse unbekannt, kann diese auch im nächsten Layout über den berechne"
				+ " Button mit Hilfe des Periodensystems errechnet werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Stoffmengenkonzentration (mol/l) der Maßlösung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Stoffmengenkonzentration (mol/l) der Maßlösung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Stoffmengenkonzentration in Mol pro Liter von der"
				+ " bekannten Maßlösung eingeben werden. Die Stoffmengenkonzentration oder auch veraltet Molarität,"
				+ " ist der Quotient der Stoffmenge (in mol) zu dem Lösungsmittel (in Liter).";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Faktor

	private void erstelle_Hilfe_Vorlage(String strKapitel) {
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben löschen";
		Hilfe[intFeldNr][2] = "Button > Eingaben löschen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons können alle Eingaben auf dem aktuellen"
				+ " Bildschirm gelöscht werden. Eingaben von dem nächsten oder vorherigen"
				+ " Display bleiben dabei unberührt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "zur Titration";
		Hilfe[intFeldNr][2] = "Button > zur Titration <";
		Hilfe[intFeldNr][3] = "Mit Hilfe diesen Buttons kommt man zum Layout der Titration.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titrationsart: Direkte / Inverse Titration";
		Hilfe[intFeldNr][2] = "Button > Titrationsart <";
		Hilfe[intFeldNr][3] = "Durch diesen Button wird die Titratonsart mit einer Dialogbox ausgewählt. Im Normalfall"
				+ " findet die Direkte Titration Anwendung, die in der App voreingestellt ist."
				+ " Bei dieser Titrationsart wird mit einer titerbekannten Maßlösung titriert. Eine titerunbekannte"
				+ " Maßlösung (Titerbestimmung mit einer anderen Maßlösung) oder eine Probelösung dient dabei als Vorlage."
				+ " Bei der Inversen Titration ist es genau umgekehrt. Hier wird mit einer titerunbekannten"
				+ " Maßlösung oder einer Probelösung titriert und eine titerbekannte Maßlösung dient als Vorlage."
				+ " Die Titrationsart wird auch in einem Ausgabefeld im Layout der Vorlage und der Volumetrie angezeigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumen der Vorlage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumen der Vorlage <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld wird das Volumen der Vorlage (falls vorhanden) in Milliliter eingegeben.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Vorlage

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
		} else if (strKapitel.equals("Verbrauch") == true) {
			erstelle_Hilfe_Erneute_Rückwaage(strKapitel);
		} else if (strKapitel.equals("Titereingaben") == true) {
			erstelle_Hilfe_Rückwaage(strKapitel);
		} else if (strKapitel.equals("Molaritaet") == true) {
			erstelle_Hilfe_Molaritaet(strKapitel);
		} else if (strKapitel.equals("Faktor") == true) {
			erstelle_Hilfe_Faktor(strKapitel);
		} else if (strKapitel.equals("Vorlage") == true) {
			erstelle_Hilfe_Vorlage(strKapitel);
		} else if (strKapitel.equals("Molmassen") == true) {
			erstelle_Hilfe_Molmassen(strKapitel);
		} else if (strKapitel.equals("Oxidationsstufen") == true) {
			erstelle_Hilfe_Oxidationsstufen(strKapitel);
		} else if (strKapitel.equals("Berechnung") == true) {
			erstelle_Hilfe_Berechnung(strKapitel);
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
