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
		for (int intFrageNr=1; intFrageNr<=intLfdNr_Gesamt; intFrageNr++) {
			if (   (Quizfragen[intFrageNr][0].equals(Integer.toString(pLevel)))
				&& (Quizfragen[intFrageNr][1].equals(Integer.toString(pLfdNr))))
			{
				mFrage   = Quizfragen[intFrageNr][2];
				mAntwort = Quizfragen[intFrageNr][3];
			}
		} // for...
	} // lese_Quizfrage

	public static int ermittel_LfdNr (int pLevel) {
		int intZufallszahl = 0;
		int intMax = 0;

		for (int intFrageNr=1; intFrageNr<=intLfdNr_Gesamt; intFrageNr++) {
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
