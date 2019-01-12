package de.laborabakus;

public class QuizFragen {
	private static String[][] Quizfragen = new String[200][4];
	private static int intLfdNr_max = 0;
	private static int intLfdNr_Gesamt = 0;


	public static String mFrage;
	public static String mAntwort;

	// 4 Spalten pro Quizfrage:
	// Spalte 0: Level (Schwierigkeitsgrad)
	// Spalte 1: Lfd. Nr. der Frage im Level
	// Spalte 2: Frage
	// Spalte 3: Antwort

	public static void  erstelle_Quizfragen () {
		int intLevel;
		int intLfdNr_Level;
		int intLfdNr_Gesamt = 0;

		// Fragen für Level 1
		/**********************************
		**** Hauptgruppenelemente *********
		 **********************************/

		intLevel = 1;
		intLfdNr_Level = 0;

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Wasserstoff";
		Quizfragen[intLfdNr_Gesamt][3] = "1.008";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lithium";
		Quizfragen[intLfdNr_Gesamt][3] = "6.939";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Beryllium";
		Quizfragen[intLfdNr_Gesamt][3] = "9.012";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Bor";
		Quizfragen[intLfdNr_Gesamt][3] = "10.811";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kohlenstoff";
		Quizfragen[intLfdNr_Gesamt][3] = "12.011";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Stickstoff";
		Quizfragen[intLfdNr_Gesamt][3] = "14.007";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Sauerstoff";
		Quizfragen[intLfdNr_Gesamt][3] = "15.999";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Fluor";
		Quizfragen[intLfdNr_Gesamt][3] = "18.998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natrium";
		Quizfragen[intLfdNr_Gesamt][3] = "22.99";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Magnesium";
		Quizfragen[intLfdNr_Gesamt][3] = "24.312";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Aluminium";
		Quizfragen[intLfdNr_Gesamt][3] = "26.982";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Silicium";
		Quizfragen[intLfdNr_Gesamt][3] = "28.086";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Phosphor";
		Quizfragen[intLfdNr_Gesamt][3] = "30.974";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Schwefel";
		Quizfragen[intLfdNr_Gesamt][3] = "32.064";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Chlor";
		Quizfragen[intLfdNr_Gesamt][3] = "35.453";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalium";
		Quizfragen[intLfdNr_Gesamt][3] = "39.102";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Calcium";
		Quizfragen[intLfdNr_Gesamt][3] = "40.08";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Gallium";
		Quizfragen[intLfdNr_Gesamt][3] = "69.72";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Germanium";
		Quizfragen[intLfdNr_Gesamt][3] = "72.59";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Arsen";
		Quizfragen[intLfdNr_Gesamt][3] = "74.922";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Selen";
		Quizfragen[intLfdNr_Gesamt][3] = "78.96";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Brom";
		Quizfragen[intLfdNr_Gesamt][3] = "79.909";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Rubidium";
		Quizfragen[intLfdNr_Gesamt][3] = "85.47";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Strontium";
		Quizfragen[intLfdNr_Gesamt][3] = "87.62";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Indium";
		Quizfragen[intLfdNr_Gesamt][3] = "114.82";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zinn";
		Quizfragen[intLfdNr_Gesamt][3] = "118.69";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Antimon";
		Quizfragen[intLfdNr_Gesamt][3] = "121.75";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Tellur";
		Quizfragen[intLfdNr_Gesamt][3] = "127.6";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Iod";
		Quizfragen[intLfdNr_Gesamt][3] = "126.9";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Caesium";
		Quizfragen[intLfdNr_Gesamt][3] = "132.91";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Barium";
		Quizfragen[intLfdNr_Gesamt][3] = "137.34";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Thallium";
		Quizfragen[intLfdNr_Gesamt][3] = "204.38";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Blei";
		Quizfragen[intLfdNr_Gesamt][3] = "207.19";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Bismut";
		Quizfragen[intLfdNr_Gesamt][3] = "208.98";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Polonium";
		Quizfragen[intLfdNr_Gesamt][3] = "210.0";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Astat";
		Quizfragen[intLfdNr_Gesamt][3] = "210.0";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Francium";
		Quizfragen[intLfdNr_Gesamt][3] = "223.0";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Radium";
		Quizfragen[intLfdNr_Gesamt][3] = "226.0";

		// Fragen für Level 2
		/**********************************
		 **** Nebengruppenelemente *********
		 **********************************/
		intLevel = 2;
		intLfdNr_Level = 0;

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Scandium";
		Quizfragen[intLfdNr_Gesamt][3] = "44.956";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Titan";
		Quizfragen[intLfdNr_Gesamt][3] = "47.88";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Vanadium";
		Quizfragen[intLfdNr_Gesamt][3] = "50.942";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Chrom";
		Quizfragen[intLfdNr_Gesamt][3] = "51.996";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Mangan";
		Quizfragen[intLfdNr_Gesamt][3] = "54.938";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Eisen";
		Quizfragen[intLfdNr_Gesamt][3] = "55.847";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Cobalt";
		Quizfragen[intLfdNr_Gesamt][3] = "58.933";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Nickel";
		Quizfragen[intLfdNr_Gesamt][3] = "58.69";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kupfer";
		Quizfragen[intLfdNr_Gesamt][3] = "63.54";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zink";
		Quizfragen[intLfdNr_Gesamt][3] = "65.37";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Yttrium";
		Quizfragen[intLfdNr_Gesamt][3] = "88.905";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium";
		Quizfragen[intLfdNr_Gesamt][3] = "91.22";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Niob";
		Quizfragen[intLfdNr_Gesamt][3] = "92.906";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Molybdän";
		Quizfragen[intLfdNr_Gesamt][3] = "95.94";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Technetium";
		Quizfragen[intLfdNr_Gesamt][3] = "99.0";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ruthenium";
		Quizfragen[intLfdNr_Gesamt][3] = "101.07";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Rhodium";
		Quizfragen[intLfdNr_Gesamt][3] = "102.91";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Paladium";
		Quizfragen[intLfdNr_Gesamt][3] = "106.42";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Silber";
		Quizfragen[intLfdNr_Gesamt][3] = "107.87";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Cadmium";
		Quizfragen[intLfdNr_Gesamt][3] = "112.4";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lanthan";
		Quizfragen[intLfdNr_Gesamt][3] = "138.91";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Hafnium";
		Quizfragen[intLfdNr_Gesamt][3] = "178.49";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Tantal";
		Quizfragen[intLfdNr_Gesamt][3] = "180.95";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Wolfram";
		Quizfragen[intLfdNr_Gesamt][3] = "183.85";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Rhenium";
		Quizfragen[intLfdNr_Gesamt][3] = "186.2";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Osmium";
		Quizfragen[intLfdNr_Gesamt][3] = "190.2";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Iridium";
		Quizfragen[intLfdNr_Gesamt][3] = "192.2";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Platin";
		Quizfragen[intLfdNr_Gesamt][3] = "195.09";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Gold";
		Quizfragen[intLfdNr_Gesamt][3] = "196.97";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber";
		Quizfragen[intLfdNr_Gesamt][3] = "200.59";

		// Fragen für Level 3
		/**********************************
		 **** Einfache Verbindungen *******
		 **********************************/
		intLevel = 3;
		intLfdNr_Level = 0;

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lithiumchlorid";
		Quizfragen[intLfdNr_Gesamt][3] = "42.392";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lithiumbromid";
		Quizfragen[intLfdNr_Gesamt][3] = "86.848";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lithiumhydroxid";
		Quizfragen[intLfdNr_Gesamt][3] = "23.946";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natriumfluorid";
		Quizfragen[intLfdNr_Gesamt][3] = "41.988";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natriumsulfat";
		Quizfragen[intLfdNr_Gesamt][3] = "142.04";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natriumnitrat";
		Quizfragen[intLfdNr_Gesamt][3] = "84.994";

		// Fragen für Level 4
		/**********************************
		 ********** Trivialnamen **********
		 **********************************/
		intLevel = 4;
		intLfdNr_Level = 0;

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Wasser";
		Quizfragen[intLfdNr_Gesamt][3] = "18.015";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ätzkali";
		Quizfragen[intLfdNr_Gesamt][3] = "56.109";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ätzkalk";
		Quizfragen[intLfdNr_Gesamt][3] = "56.079002";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ätznatron";
		Quizfragen[intLfdNr_Gesamt][3] = "39.996998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Barytsalpeter";
		Quizfragen[intLfdNr_Gesamt][3] = "261.348";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Bittersalz";
		Quizfragen[intLfdNr_Gesamt][3] = "120.371994";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Bleiglätte";
		Quizfragen[intLfdNr_Gesamt][3] = "223.189";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Branntkalk";
		Quizfragen[intLfdNr_Gesamt][3] = "56.079002";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natron oder Bullrichsalz";
		Quizfragen[intLfdNr_Gesamt][3] = "84.006";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Carbid";
		Quizfragen[intLfdNr_Gesamt][3] = "64.102005";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Chilesalpeter";
		Quizfragen[intLfdNr_Gesamt][3] = "84.994";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Fixiersalz";
		Quizfragen[intLfdNr_Gesamt][3] = "158.105";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalkmilch (l) oder Löschkalk (s)";
		Quizfragen[intLfdNr_Gesamt][3] = "74.094";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Gips (ohne Kristallwasser)";
		Quizfragen[intLfdNr_Gesamt][3] = "136.14";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Glaubersalz (ohne Kristallwasser)";
		Quizfragen[intLfdNr_Gesamt][3] = "142.04";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Hammerschlag";
		Quizfragen[intLfdNr_Gesamt][3] = "231.537";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Hirschhornsalz";
		Quizfragen[intLfdNr_Gesamt][3] = "79.05499";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Höllenstein";
		Quizfragen[intLfdNr_Gesamt][3] = "169.874";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalisalpeter";
		Quizfragen[intLfdNr_Gesamt][3] = "101.106";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalk";
		Quizfragen[intLfdNr_Gesamt][3] = "100.088";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Karbid";
		Quizfragen[intLfdNr_Gesamt][3] = "64.102005";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalk- oder Mauersalpeter";
		Quizfragen[intLfdNr_Gesamt][3] = "102.084";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalomel";
		Quizfragen[intLfdNr_Gesamt][3] = "472.086";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kochsalz";
		Quizfragen[intLfdNr_Gesamt][3] = "58.443";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kupfervitiol";
		Quizfragen[intLfdNr_Gesamt][3] = "159.6";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Mennige";
		Quizfragen[intLfdNr_Gesamt][3] = "685.566";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Pottasche";
		Quizfragen[intLfdNr_Gesamt][3] = "138.212";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Stanniol";
		Quizfragen[intLfdNr_Gesamt][3] = "118.69";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Trockeneis";
		Quizfragen[intLfdNr_Gesamt][3] = "44.009";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Waschsoda";
		Quizfragen[intLfdNr_Gesamt][3] = "105.98799";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zinkvitriol";
		Quizfragen[intLfdNr_Gesamt][3] = "161.43001";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zyankali";
		Quizfragen[intLfdNr_Gesamt][3] = "65.119995";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Zinnober";
		Quizfragen[intLfdNr_Gesamt][3] = "232.65399";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Barytwasser";
		Quizfragen[intLfdNr_Gesamt][3] = "171.35397";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Borwasser";
		Quizfragen[intLfdNr_Gesamt][3] = "61.831997";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Flusssäure";
		Quizfragen[intLfdNr_Gesamt][3] = "20.005999";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Kalilauge";
		Quizfragen[intLfdNr_Gesamt][3] = "56.109";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Natronlauge";
		Quizfragen[intLfdNr_Gesamt][3] = "39.996998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Oleum oder Vitriolöl";
		Quizfragen[intLfdNr_Gesamt][3] = "98.076";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Salmiakgeist";
		Quizfragen[intLfdNr_Gesamt][3] = "17.031";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Salpetersäure";
		Quizfragen[intLfdNr_Gesamt][3] = "63.011997";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Salzsäure";
		Quizfragen[intLfdNr_Gesamt][3] = "36.461";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Schwefelsäure";
		Quizfragen[intLfdNr_Gesamt][3] = "98.076";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Scheidewasser";
		Quizfragen[intLfdNr_Gesamt][3] = "63.011997";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "schweflige Säure";
		Quizfragen[intLfdNr_Gesamt][3] = "82.076996";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ammoniak";
		Quizfragen[intLfdNr_Gesamt][3] = "17.031";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Blausäure";
		Quizfragen[intLfdNr_Gesamt][3] = "27.026001";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Lachgas";
		Quizfragen[intLfdNr_Gesamt][3] = "44.013";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ozon";
		Quizfragen[intLfdNr_Gesamt][3] = "47.996998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Sulfan";
		Quizfragen[intLfdNr_Gesamt][3] = "34.079998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Chloroform";
		Quizfragen[intLfdNr_Gesamt][3] = "119.37799";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Etylen";
		Quizfragen[intLfdNr_Gesamt][3] = "28.053999";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Acetylen";
		Quizfragen[intLfdNr_Gesamt][3] = "26.038";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Spiritus oder Weingeist";
		Quizfragen[intLfdNr_Gesamt][3] = "46.069";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Formaldehyd";
		Quizfragen[intLfdNr_Gesamt][3] = "30.026";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Essigsäure";
		Quizfragen[intLfdNr_Gesamt][3] = "60.052";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Ameisensäure";
		Quizfragen[intLfdNr_Gesamt][3] = "46.024998";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Traubenzucker oder Dextrose";
		Quizfragen[intLfdNr_Gesamt][3] = "180.15599";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Phosgen";
		Quizfragen[intLfdNr_Gesamt][3] = "98.916";

		intLfdNr_max = intLfdNr_Gesamt;
	} // erstelle_Quizfragen

	public static void lese_Quizfrage (int pLevel, int pLfdNr) {
		mFrage   = "";
		mAntwort = "";
		for (int intFrageNr=1; intFrageNr<=intLfdNr_max; intFrageNr++) {
			if (   (Quizfragen[intFrageNr][0].equals(Integer.toString(pLevel)))
				&& (Quizfragen[intFrageNr][1].equals(Integer.toString(pLfdNr))))
			{
				mFrage   = Quizfragen[intFrageNr][2];
				mAntwort = Quizfragen[intFrageNr][3];
                break; // for-Schleife vorzeitig beenden
			}
		} // for...
	} // lese_Quizfrage

	public static int ermittel_LfdNr (int pLevel) {
		int intZufallszahl = 0;
		int intMax = 0; // Anzahl der Fragen im jeweiligen Level

		for (int intFrageNr=1; intFrageNr<=intLfdNr_max; intFrageNr++) {
			if (Quizfragen[intFrageNr][0].equals(Integer.toString(pLevel)))
			{
				intMax++;
			}
			else if (Integer.parseInt(Quizfragen[intFrageNr][0]) > pLevel) {
                break; // for-Schleife vorzeitig beenden
            }
        } // for...

		if (intMax > 0) {
			intZufallszahl = (int) (Math.random() * intMax) + 1;
		}

		return intZufallszahl;
	} // ermittel_LfdNr

	} // QuizFragen
