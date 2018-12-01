package de.laborabakus;

public class QuizFragen {
	private static String[][] Quizfragen = new String[100][4];
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
		Quizfragen[intLfdNr_Gesamt][3] = "22.990";

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
		Quizfragen[intLfdNr_Gesamt][3] = "127.60";

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Iod";
		Quizfragen[intLfdNr_Gesamt][3] = "126.90";

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
		intLevel = 2;
		intLfdNr_Level = 0;

		intLfdNr_Level++;
		intLfdNr_Gesamt++;
		Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
		Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
		Quizfragen[intLfdNr_Gesamt][2] = "Wasser";
		Quizfragen[intLfdNr_Gesamt][3] = "18.015";

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
		int intMax = 0;

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
			intZufallszahl = (int) (Math.random() * intMax);
		}

		return intZufallszahl;
	} // ermittel_LfdNr

	} // QuizFragen
