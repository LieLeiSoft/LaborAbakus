package de.laborabakus;

public class QuizFragen {
	private static String[][] Quizfragen = new String[900][5];
	private static int[] LetzteQuizfragen = new int[10];
	private static int intLfdNr_max = 0;
	private static int intLfdNr_Gesamt = 0;


	public static String mFrage;
	public static String mAntwort;
    public static String mAntwortText;

	// 4 Spalten pro Quizfrage:
	// Spalte 0: Level (Schwierigkeitsgrad)
	// Spalte 1: Lfd. Nr. der Frage im Level
	// Spalte 2: Frage
	// Spalte 3: Antwort

	public static void  erstelle_Quizfragen () {
		int intLevel;
		int intLfdNr_Level;
		int intLfdNr_Gesamt = 0;

        //region Fragen für Level 1 (38 Elemente)
        /**********************************
         **** Hauptgruppenelemente ********
         **********************************/
        intLevel = 1;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "1.008";
        Quizfragen[intLfdNr_Gesamt][4] = "H";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithium";
        Quizfragen[intLfdNr_Gesamt][3] = "6.939";
        Quizfragen[intLfdNr_Gesamt][4] = "Li";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Beryllium";
        Quizfragen[intLfdNr_Gesamt][3] = "9.012";
        Quizfragen[intLfdNr_Gesamt][4] = "Be";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bor";
        Quizfragen[intLfdNr_Gesamt][3] = "10.811";
        Quizfragen[intLfdNr_Gesamt][4] = "B";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kohlenstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "12.011";
        Quizfragen[intLfdNr_Gesamt][4] = "C";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "14.007";
        Quizfragen[intLfdNr_Gesamt][4] = "N";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Sauerstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "15.999";
        Quizfragen[intLfdNr_Gesamt][4] = "O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Fluor";
        Quizfragen[intLfdNr_Gesamt][3] = "18.998";
        Quizfragen[intLfdNr_Gesamt][4] = "F";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natrium";
        Quizfragen[intLfdNr_Gesamt][3] = "22.99";
        Quizfragen[intLfdNr_Gesamt][4] = "Na";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesium";
        Quizfragen[intLfdNr_Gesamt][3] = "24.312";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminium";
        Quizfragen[intLfdNr_Gesamt][3] = "26.982";
        Quizfragen[intLfdNr_Gesamt][4] = "Al";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silicium";
        Quizfragen[intLfdNr_Gesamt][3] = "28.086";
        Quizfragen[intLfdNr_Gesamt][4] = "Si";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phosphor";
        Quizfragen[intLfdNr_Gesamt][3] = "30.974";
        Quizfragen[intLfdNr_Gesamt][4] = "P";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefel";
        Quizfragen[intLfdNr_Gesamt][3] = "32.064";
        Quizfragen[intLfdNr_Gesamt][4] = "S";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chlor";
        Quizfragen[intLfdNr_Gesamt][3] = "35.453";
        Quizfragen[intLfdNr_Gesamt][4] = "Cl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalium";
        Quizfragen[intLfdNr_Gesamt][3] = "39.102";
        Quizfragen[intLfdNr_Gesamt][4] = "K";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calcium";
        Quizfragen[intLfdNr_Gesamt][3] = "40.08";
        Quizfragen[intLfdNr_Gesamt][4] = "Ca";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gallium";
        Quizfragen[intLfdNr_Gesamt][3] = "69.72";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium";
        Quizfragen[intLfdNr_Gesamt][3] = "72.59";
        Quizfragen[intLfdNr_Gesamt][4] = "Ge";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen";
        Quizfragen[intLfdNr_Gesamt][3] = "74.922";
        Quizfragen[intLfdNr_Gesamt][4] = "As";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selen";
        Quizfragen[intLfdNr_Gesamt][3] = "78.96";
        Quizfragen[intLfdNr_Gesamt][4] = "Se";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Brom";
        Quizfragen[intLfdNr_Gesamt][3] = "79.909";
        Quizfragen[intLfdNr_Gesamt][4] = "Br";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidium";
        Quizfragen[intLfdNr_Gesamt][3] = "85.47";
        Quizfragen[intLfdNr_Gesamt][4] = "Rb";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontium";
        Quizfragen[intLfdNr_Gesamt][3] = "87.62";
        Quizfragen[intLfdNr_Gesamt][4] = "Sr";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium";
        Quizfragen[intLfdNr_Gesamt][3] = "114.82";
        Quizfragen[intLfdNr_Gesamt][4] = "In";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn";
        Quizfragen[intLfdNr_Gesamt][3] = "118.69";
        Quizfragen[intLfdNr_Gesamt][4] = "Sn";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon";
        Quizfragen[intLfdNr_Gesamt][3] = "121.75";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tellur";
        Quizfragen[intLfdNr_Gesamt][3] = "127.6";
        Quizfragen[intLfdNr_Gesamt][4] = "Te";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iod";
        Quizfragen[intLfdNr_Gesamt][3] = "126.9";
        Quizfragen[intLfdNr_Gesamt][4] = "I";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Caesium";
        Quizfragen[intLfdNr_Gesamt][3] = "132.91";
        Quizfragen[intLfdNr_Gesamt][4] = "Cs";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Barium";
        Quizfragen[intLfdNr_Gesamt][3] = "137.34";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium";
        Quizfragen[intLfdNr_Gesamt][3] = "204.38";
        Quizfragen[intLfdNr_Gesamt][4] = "Tl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei";
        Quizfragen[intLfdNr_Gesamt][3] = "207.19";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bismut";
        Quizfragen[intLfdNr_Gesamt][3] = "208.98";
        Quizfragen[intLfdNr_Gesamt][4] = "Bi";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Polonium";
        Quizfragen[intLfdNr_Gesamt][3] = "210.0";
        Quizfragen[intLfdNr_Gesamt][4] = "Po";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Astat";
        Quizfragen[intLfdNr_Gesamt][3] = "210.0";
        Quizfragen[intLfdNr_Gesamt][4] = "At";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Francium";
        Quizfragen[intLfdNr_Gesamt][3] = "223.0";
        Quizfragen[intLfdNr_Gesamt][4] = "Fr";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Radium";
        Quizfragen[intLfdNr_Gesamt][3] = "226.0";
        Quizfragen[intLfdNr_Gesamt][4] = "Ra";
        //endregion

        //region Fragen für Level 2 (30 Elemente)
        /**********************************
         **** Nebengruppenelemente ********
         **********************************/
        intLevel = 2;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Scandium";
        Quizfragen[intLfdNr_Gesamt][3] = "44.956";
        Quizfragen[intLfdNr_Gesamt][4] = "Sc";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titan";
        Quizfragen[intLfdNr_Gesamt][3] = "47.88";
        Quizfragen[intLfdNr_Gesamt][4] = "Ti";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium";
        Quizfragen[intLfdNr_Gesamt][3] = "50.942";
        Quizfragen[intLfdNr_Gesamt][4] = "V";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom";
        Quizfragen[intLfdNr_Gesamt][3] = "51.996";
        Quizfragen[intLfdNr_Gesamt][4] = "Cr";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan";
        Quizfragen[intLfdNr_Gesamt][3] = "54.938";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen";
        Quizfragen[intLfdNr_Gesamt][3] = "55.847";
        Quizfragen[intLfdNr_Gesamt][4] = "Fe";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt";
        Quizfragen[intLfdNr_Gesamt][3] = "58.933";
        Quizfragen[intLfdNr_Gesamt][4] = "Co";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel";
        Quizfragen[intLfdNr_Gesamt][3] = "58.69";
        Quizfragen[intLfdNr_Gesamt][4] = "Ni";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer";
        Quizfragen[intLfdNr_Gesamt][3] = "63.54";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zink";
        Quizfragen[intLfdNr_Gesamt][3] = "65.37";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Yttrium";
        Quizfragen[intLfdNr_Gesamt][3] = "88.905";
        Quizfragen[intLfdNr_Gesamt][4] = "Y";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium";
        Quizfragen[intLfdNr_Gesamt][3] = "91.22";
        Quizfragen[intLfdNr_Gesamt][4] = "Zr";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob";
        Quizfragen[intLfdNr_Gesamt][3] = "92.906";
        Quizfragen[intLfdNr_Gesamt][4] = "Nb";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Molybdän";
        Quizfragen[intLfdNr_Gesamt][3] = "95.94";
        Quizfragen[intLfdNr_Gesamt][4] = "Mo";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Technetium";
        Quizfragen[intLfdNr_Gesamt][3] = "99.0";
        Quizfragen[intLfdNr_Gesamt][4] = "Tc";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ruthenium";
        Quizfragen[intLfdNr_Gesamt][3] = "101.07";
        Quizfragen[intLfdNr_Gesamt][4] = "Ru";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rhodium";
        Quizfragen[intLfdNr_Gesamt][3] = "102.91";
        Quizfragen[intLfdNr_Gesamt][4] = "Rh";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium";
        Quizfragen[intLfdNr_Gesamt][3] = "106.42";
        Quizfragen[intLfdNr_Gesamt][4] = "Pd";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silber";
        Quizfragen[intLfdNr_Gesamt][3] = "107.87";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmium";
        Quizfragen[intLfdNr_Gesamt][3] = "112.4";
        Quizfragen[intLfdNr_Gesamt][4] = "Cd";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthan";
        Quizfragen[intLfdNr_Gesamt][3] = "138.91";
        Quizfragen[intLfdNr_Gesamt][4] = "La";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium";
        Quizfragen[intLfdNr_Gesamt][3] = "178.49";
        Quizfragen[intLfdNr_Gesamt][4] = "Hf";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tantal";
        Quizfragen[intLfdNr_Gesamt][3] = "180.95";
        Quizfragen[intLfdNr_Gesamt][4] = "Ta";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram";
        Quizfragen[intLfdNr_Gesamt][3] = "183.85";
        Quizfragen[intLfdNr_Gesamt][4] = "W";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rhenium";
        Quizfragen[intLfdNr_Gesamt][3] = "186.2";
        Quizfragen[intLfdNr_Gesamt][4] = "Re";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Osmium";
        Quizfragen[intLfdNr_Gesamt][3] = "190.2";
        Quizfragen[intLfdNr_Gesamt][4] = "Os";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium";
        Quizfragen[intLfdNr_Gesamt][3] = "192.2";
        Quizfragen[intLfdNr_Gesamt][4] = "Ir";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin";
        Quizfragen[intLfdNr_Gesamt][3] = "195.09";
        Quizfragen[intLfdNr_Gesamt][4] = "Pt";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold";
        Quizfragen[intLfdNr_Gesamt][3] = "196.97";
        Quizfragen[intLfdNr_Gesamt][4] = "Au";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber";
        Quizfragen[intLfdNr_Gesamt][3] = "200.59";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg";
        //endregion

        //region Fragen für Level 3
        /**********************************
         ****** Binäre Verbindungen *******
         **********************************/
        intLevel = 3;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "266.709";
        Quizfragen[intLfdNr_Gesamt][4] = "AlBr3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumcarbid";
        Quizfragen[intLfdNr_Gesamt][3] = "143.961";
        Quizfragen[intLfdNr_Gesamt][4] = "Al4C3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "133.341";
        Quizfragen[intLfdNr_Gesamt][4] = "AlCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "83.976";
        Quizfragen[intLfdNr_Gesamt][4] = "AlF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "407.682";
        Quizfragen[intLfdNr_Gesamt][4] = "AlI3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "40.989";
        Quizfragen[intLfdNr_Gesamt][4] = "AlN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "101.961";
        Quizfragen[intLfdNr_Gesamt][4] = "Al2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumphosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "57.956";
        Quizfragen[intLfdNr_Gesamt][4] = "AlP";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "150.156";
        Quizfragen[intLfdNr_Gesamt][4] = "Al2S3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniak";
        Quizfragen[intLfdNr_Gesamt][3] = "17.031";
        Quizfragen[intLfdNr_Gesamt][4] = "NH3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "361.477";
        Quizfragen[intLfdNr_Gesamt][4] = "SbBr3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "228.109";
        Quizfragen[intLfdNr_Gesamt][4] = "SbCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "178.744";
        Quizfragen[intLfdNr_Gesamt][4] = "SbF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(V)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "216.74";
        Quizfragen[intLfdNr_Gesamt][4] = "SbF5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "124.774";
        Quizfragen[intLfdNr_Gesamt][4] = "SbH3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "291.497";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "339.692";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb2S3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(V)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "403.82";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb2S5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(V)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "252.187";
        Quizfragen[intLfdNr_Gesamt][4] = "AsCl5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(V)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "229.839";
        Quizfragen[intLfdNr_Gesamt][4] = "As2O5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "181.281";
        Quizfragen[intLfdNr_Gesamt][4] = "AsCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "197.841";
        Quizfragen[intLfdNr_Gesamt][4] = "As2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "297.158";
        Quizfragen[intLfdNr_Gesamt][4] = "BaBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "208.246";
        Quizfragen[intLfdNr_Gesamt][4] = "BaCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "175.336";
        Quizfragen[intLfdNr_Gesamt][4] = "BaF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "139.356";
        Quizfragen[intLfdNr_Gesamt][4] = "BaH2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "391.14";
        Quizfragen[intLfdNr_Gesamt][4] = "BaI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "440.034";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba3N2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "153.339";
        Quizfragen[intLfdNr_Gesamt][4] = "BaO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "169.338";
        Quizfragen[intLfdNr_Gesamt][4] = "BaO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "169.404";
        Quizfragen[intLfdNr_Gesamt][4] = "BaS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "168.83";
        Quizfragen[intLfdNr_Gesamt][4] = "BeBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "79.918";
        Quizfragen[intLfdNr_Gesamt][4] = "BeCl2";
        intLfdNr_Level++;

        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "47.008";
        Quizfragen[intLfdNr_Gesamt][4] = "BeF2";

        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "11.028";
        Quizfragen[intLfdNr_Gesamt][4] = "BeH2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "262.812";
        Quizfragen[intLfdNr_Gesamt][4] = "BeI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "25.011";
        Quizfragen[intLfdNr_Gesamt][4] = "BeO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "41.01";
        Quizfragen[intLfdNr_Gesamt][4] = "BeO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bortrichlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "117.17";
        Quizfragen[intLfdNr_Gesamt][4] = "BCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bortrifluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "67.805";
        Quizfragen[intLfdNr_Gesamt][4] = "BF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bismut(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "315.339";
        Quizfragen[intLfdNr_Gesamt][4] = "BiCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bleiazid";
        Quizfragen[intLfdNr_Gesamt][3] = "291.232";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(N3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "278.096";
        Quizfragen[intLfdNr_Gesamt][4] = "PbCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "367.008";
        Quizfragen[intLfdNr_Gesamt][4] = "PbBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-iodid";
        Quizfragen[intLfdNr_Gesamt][3] = "460.99";
        Quizfragen[intLfdNr_Gesamt][4] = "PbI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "245.186";
        Quizfragen[intLfdNr_Gesamt][4] = "PbF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "223.189";
        Quizfragen[intLfdNr_Gesamt][4] = "PbO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "239.188";
        Quizfragen[intLfdNr_Gesamt][4] = "PbO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "239.254";
        Quizfragen[intLfdNr_Gesamt][4] = "PbS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Dibortrioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "69.619";
        Quizfragen[intLfdNr_Gesamt][4] = "B2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumbromid"; //CaBr2
        Quizfragen[intLfdNr_Gesamt][3] = "199.898"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumchlorid"; // CaCl2
        Quizfragen[intLfdNr_Gesamt][3] = "110.986"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumcarbid"; // CaC2
        Quizfragen[intLfdNr_Gesamt][3] = "64.102"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaC2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumfluorid"; // CaF2
        Quizfragen[intLfdNr_Gesamt][3] = "78.076"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumhydrid"; // CaH2
        Quizfragen[intLfdNr_Gesamt][3] = "42.096"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaH2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumiodid"; // CaI2
        Quizfragen[intLfdNr_Gesamt][3] = "293.88"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumnitrid"; // Ca3N2
        Quizfragen[intLfdNr_Gesamt][3] = "148.254"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Ca3N2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumoxid"; // CaO
        Quizfragen[intLfdNr_Gesamt][3] = "56.079"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumperoxid"; // CaO2
        Quizfragen[intLfdNr_Gesamt][3] = "72.078"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumphosphid"; // Ca3P2
        Quizfragen[intLfdNr_Gesamt][3] = "182.188"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Ca3P2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumsulfid"; // CaS
        Quizfragen[intLfdNr_Gesamt][3] = "72.144"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumbromid"; // CdBr2
        Quizfragen[intLfdNr_Gesamt][3] = "272.218"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumchlorid"; // CdCl2
        Quizfragen[intLfdNr_Gesamt][3] = "183.306"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumfluorid"; // CdF2
        Quizfragen[intLfdNr_Gesamt][3] = "150.396"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmium(II)-hydrid"; //
        Quizfragen[intLfdNr_Gesamt][3] = "114.416"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdH2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumiodid"; // CdI2
        Quizfragen[intLfdNr_Gesamt][3] = "366.2"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumoxid"; // CdO
        Quizfragen[intLfdNr_Gesamt][3] = "128.399"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumsulfid"; // CdS
        Quizfragen[intLfdNr_Gesamt][3] = "144.464"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CdS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumbromid"; // CsBr
        Quizfragen[intLfdNr_Gesamt][3] = "212.819"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CsBr";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumchlorid"; // CsCl
        Quizfragen[intLfdNr_Gesamt][3] = "168.363"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CsCl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumfluorid"; // CsF
        Quizfragen[intLfdNr_Gesamt][3] = "151.908"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CsF";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumhydrid"; //
        Quizfragen[intLfdNr_Gesamt][3] = "133.918"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CsH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumiodid"; // CsI
        Quizfragen[intLfdNr_Gesamt][3] = "259.81"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CsI";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumoxid"; // Cs2O
        Quizfragen[intLfdNr_Gesamt][3] = "281.819"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Cs2O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumperoxid"; // Cs2O2
        Quizfragen[intLfdNr_Gesamt][3] = "297.818"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Cs2O2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-chlorid"; // CrCl3
        Quizfragen[intLfdNr_Gesamt][3] = "158.355"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CrCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chromcarbit"; // Cr3C2
        Quizfragen[intLfdNr_Gesamt][3] = "180.01"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Cr3C2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(IV)-oxid"; // CrO2
        Quizfragen[intLfdNr_Gesamt][3] = "83.994"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CrO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-oxid"; // Cr2O3
        Quizfragen[intLfdNr_Gesamt][3] = "151.989"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Cr2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chromnitrid"; // CrN
        Quizfragen[intLfdNr_Gesamt][3] = "66.003"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CrN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(VI)-peroxid"; // CrO5
        Quizfragen[intLfdNr_Gesamt][3] = "131.991"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CrO5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Salzsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "36.461";
        Quizfragen[intLfdNr_Gesamt][4] = "HCl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chlortrifluorid"; // ClF3
        Quizfragen[intLfdNr_Gesamt][3] = "92.447"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "ClF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-bromid"; // CoBr2
        Quizfragen[intLfdNr_Gesamt][3] = "218.751"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CoBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-chlorid"; // CoCl2
        Quizfragen[intLfdNr_Gesamt][3] = "129.839"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CoCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-iodid"; // CoI2
        Quizfragen[intLfdNr_Gesamt][3] = "312.733"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CoI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-nitrat"; // Co(NO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "182.941"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Co(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-oxid"; // CoO
        Quizfragen[intLfdNr_Gesamt][3] = "74.932"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CoO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(III)-oxid"; // Co2O3
        Quizfragen[intLfdNr_Gesamt][3] = "165.863"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Co2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(III)-sulfid"; // Co2S3
        Quizfragen[intLfdNr_Gesamt][3] = "214.058"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Co2S3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-sulfid"; // CoS
        Quizfragen[intLfdNr_Gesamt][3] = "90.997"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CoS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-bromid"; // FeBr2
        Quizfragen[intLfdNr_Gesamt][3] = "215.665"; // 2   215.65
        Quizfragen[intLfdNr_Gesamt][4] = "FeBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-bromid"; // FeBr3
        Quizfragen[intLfdNr_Gesamt][3] = "295.574"; // 2   295.56
        Quizfragen[intLfdNr_Gesamt][4] = "FeBr3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-chlorid"; //  FeCl2
        Quizfragen[intLfdNr_Gesamt][3] = "126.753"; // 2   126.75
        Quizfragen[intLfdNr_Gesamt][4] = "FeCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-chlorid"; // FeCl3
        Quizfragen[intLfdNr_Gesamt][3] = "162.206"; // 2   162.2
        Quizfragen[intLfdNr_Gesamt][4] = "FeCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-fluorid"; // FeF2
        Quizfragen[intLfdNr_Gesamt][3] = "93.843"; // 2   98.84
        Quizfragen[intLfdNr_Gesamt][4] = "FeF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-fluorid"; // FeF3
        Quizfragen[intLfdNr_Gesamt][3] = "112.841"; // 2   112.84
        Quizfragen[intLfdNr_Gesamt][4] = "FeF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-iodid"; // FeI2
        Quizfragen[intLfdNr_Gesamt][3] = "309.647"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "FeI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-iodid"; // FeI3
        Quizfragen[intLfdNr_Gesamt][3] = "436.547"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "FeI3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(I)-oxid"; // Fe2O
        Quizfragen[intLfdNr_Gesamt][3] = "127.693"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Fe2O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-oxid"; // FeO
        Quizfragen[intLfdNr_Gesamt][3] = "71.846"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "FeO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-oxid"; // Fe2O3
        Quizfragen[intLfdNr_Gesamt][3] = "159.691"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Fe2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-sulfid"; // FeS
        Quizfragen[intLfdNr_Gesamt][3] = "87.911"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "FeS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-disulfid"; // FeS2
        Quizfragen[intLfdNr_Gesamt][3] = "119.975"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "FeS2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-sulfid"; // Fe2S3
        Quizfragen[intLfdNr_Gesamt][3] = "207.886"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Fe2S3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Flusssäure";
        Quizfragen[intLfdNr_Gesamt][3] = "20.006";
        Quizfragen[intLfdNr_Gesamt][4] = "HF";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Franciumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "258.453";
        Quizfragen[intLfdNr_Gesamt][4] = "FrCl";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumarsenid";
        Quizfragen[intLfdNr_Gesamt][3] = "144.642";
        Quizfragen[intLfdNr_Gesamt][4] = "GaAs";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "176.079";
        Quizfragen[intLfdNr_Gesamt][4] = "GaCl3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "83.727";
        Quizfragen[intLfdNr_Gesamt][4] = "GaN";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "187.437";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga2O3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "235.434";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga2(O2)3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumphosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "100.694";
        Quizfragen[intLfdNr_Gesamt][4] = "GaP";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gallium(III)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "235.632";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga2S3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "143.496";
        Quizfragen[intLfdNr_Gesamt][4] = "GeCl2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "214.402";
        Quizfragen[intLfdNr_Gesamt][4] = "GeCl4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(IV)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "76.622";
        Quizfragen[intLfdNr_Gesamt][4] = "GeH4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "88.589";
        Quizfragen[intLfdNr_Gesamt][4] = "GeO";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "104.588";
        Quizfragen[intLfdNr_Gesamt][4] = "GeO2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "104.654";
        Quizfragen[intLfdNr_Gesamt][4] = "GeS";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "136.718";
        Quizfragen[intLfdNr_Gesamt][4] = "GeS2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "303.329";
        Quizfragen[intLfdNr_Gesamt][4] = "AuCl3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold(I)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "197.978";
        Quizfragen[intLfdNr_Gesamt][4] = "AuH";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold(III)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "199.994";
        Quizfragen[intLfdNr_Gesamt][4] = "AuH3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium(IV)-carbid";
        Quizfragen[intLfdNr_Gesamt][3] = "190.501";
        Quizfragen[intLfdNr_Gesamt][4] = "HfC";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "320.302";
        Quizfragen[intLfdNr_Gesamt][4] = "HfCl4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium(IV)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "254.482";
        Quizfragen[intLfdNr_Gesamt][4] = "HfF4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafniumdihydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "180.506";
        Quizfragen[intLfdNr_Gesamt][4] = "HfH2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafniumtetrahydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "182.522";
        Quizfragen[intLfdNr_Gesamt][4] = "HfH4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "210.488";
        Quizfragen[intLfdNr_Gesamt][4] = "HfO2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hafnium(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "194.489";
        Quizfragen[intLfdNr_Gesamt][4] = "HfO";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-antimonid";
        Quizfragen[intLfdNr_Gesamt][3] = "236.57";
        Quizfragen[intLfdNr_Gesamt][4] = "InSb";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-arsenid";
        Quizfragen[intLfdNr_Gesamt][3] = "189.742";
        Quizfragen[intLfdNr_Gesamt][4] = "InAs";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "221.179";
        Quizfragen[intLfdNr_Gesamt][4] = "InCl3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indiumtrihydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "117.844";
        Quizfragen[intLfdNr_Gesamt][4] = "InH3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "128.827";
        Quizfragen[intLfdNr_Gesamt][4] = "InN";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "277.637";
        Quizfragen[intLfdNr_Gesamt][4] = "In2O3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(I)-peroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "261.638";
        Quizfragen[intLfdNr_Gesamt][4] = "In2O2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-phosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "145.794";
        Quizfragen[intLfdNr_Gesamt][4] = "InP";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "325.832";
        Quizfragen[intLfdNr_Gesamt][4] = "In2S3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iodbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "206.809";
        Quizfragen[intLfdNr_Gesamt][4] = "IBr";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iodchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "162.353";
        Quizfragen[intLfdNr_Gesamt][4] = "ICl";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Diiodpentoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "333.795";
        Quizfragen[intLfdNr_Gesamt][4] = "I2O5";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iodsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "175.905";
        Quizfragen[intLfdNr_Gesamt][4] = "HIO3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "298.559";
        Quizfragen[intLfdNr_Gesamt][4] = "IrCl3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "334.012";
        Quizfragen[intLfdNr_Gesamt][4] = "IrCl4";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(III)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "195.224";
        Quizfragen[intLfdNr_Gesamt][4] = "IrH3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "432.397";
        Quizfragen[intLfdNr_Gesamt][4] = "Ir2O3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "224.198";
        Quizfragen[intLfdNr_Gesamt][4] = "IrO2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iridium(VI)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "240.197";
        Quizfragen[intLfdNr_Gesamt][4] = "IrO3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "119.011";
        Quizfragen[intLfdNr_Gesamt][4] = "KBr";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "74.555";
        Quizfragen[intLfdNr_Gesamt][4] = "KCl";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumdioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "94.203";
        Quizfragen[intLfdNr_Gesamt][4] = "K2O";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "58.1";
        Quizfragen[intLfdNr_Gesamt][4] = "KF";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "40.11";
        Quizfragen[intLfdNr_Gesamt][4] = "KH";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "166.002";
        Quizfragen[intLfdNr_Gesamt][4] = "KI";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "94.203";
        Quizfragen[intLfdNr_Gesamt][4] = "K2O";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "110.202";
        Quizfragen[intLfdNr_Gesamt][4] = "K2O2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "110.268";
        Quizfragen[intLfdNr_Gesamt][4] = "K2S";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kohlendioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "44.009";
        Quizfragen[intLfdNr_Gesamt][4] = "CO2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kohlenmonoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "28.01";
        Quizfragen[intLfdNr_Gesamt][4] = "CO";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kohlensäure";
        Quizfragen[intLfdNr_Gesamt][3] = "62.024";
        Quizfragen[intLfdNr_Gesamt][4] = "H2CO3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "223.358";
        Quizfragen[intLfdNr_Gesamt][4] = "CuBr2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "143.449";
        Quizfragen[intLfdNr_Gesamt][4] = "CuBr";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "134.446";
        Quizfragen[intLfdNr_Gesamt][4] = "CuCl2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "98.993";
        Quizfragen[intLfdNr_Gesamt][4] = "CuCl";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "82.538";
        Quizfragen[intLfdNr_Gesamt][4] = "CuF";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "101.536";
        Quizfragen[intLfdNr_Gesamt][4] = "CuF2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "64.548";
        Quizfragen[intLfdNr_Gesamt][4] = "CuH";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-iodid";
        Quizfragen[intLfdNr_Gesamt][3] = "190.44";
        Quizfragen[intLfdNr_Gesamt][4] = "CuI";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "204.627";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu3N";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "143.079";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu2O";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "79.539";
        Quizfragen[intLfdNr_Gesamt][4] = "CuO";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "159.144";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu2S";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "95.604";
        Quizfragen[intLfdNr_Gesamt][4] = "CuS";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthanhexaborid";
        Quizfragen[intLfdNr_Gesamt][3] = "203.776";
        Quizfragen[intLfdNr_Gesamt][4] = "LaB6";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthanchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "245.269";
        Quizfragen[intLfdNr_Gesamt][4] = "LaCl3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthanfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "195.904";
        Quizfragen[intLfdNr_Gesamt][4] = "LaF3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthan(III)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "141.934";
        Quizfragen[intLfdNr_Gesamt][4] = "LaH3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthanoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "325.817";
        Quizfragen[intLfdNr_Gesamt][4] = "La2O3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "86.848";
        Quizfragen[intLfdNr_Gesamt][4] = "LiBr";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "42.392";
        Quizfragen[intLfdNr_Gesamt][4] = "LiCl";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "25.937";
        Quizfragen[intLfdNr_Gesamt][4] = "LiF";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "7.947";
        Quizfragen[intLfdNr_Gesamt][4] = "LiH";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "133.839";
        Quizfragen[intLfdNr_Gesamt][4] = "LiI";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "34.824";
        Quizfragen[intLfdNr_Gesamt][4] = "Li3N";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "29.877";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2O";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "45.942";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2S";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "184.13";
        Quizfragen[intLfdNr_Gesamt][4] = "MgBr2";  // Elemente 2 – 184.113 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "95.218";
        Quizfragen[intLfdNr_Gesamt][4] = "MgCl2";  // Elemente 2 – 95.211 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "62.308";
        Quizfragen[intLfdNr_Gesamt][4] = "MgF2";  // Elemente 2 – 62.3018 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "26.328";
        Quizfragen[intLfdNr_Gesamt][4] = "MgH2";  // Elemente 2 – 26.3209 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "278.112";
        Quizfragen[intLfdNr_Gesamt][4] = "MgI2";  // Elemente 2 – 278.1139 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "100.949";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg3N2";  // Elemente 2 – 100.9494 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "40.311";
        Quizfragen[intLfdNr_Gesamt][4] = "MgO";  // Elemente 2 – 40.3044 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "56.31";
        Quizfragen[intLfdNr_Gesamt][4] = "MgO2";  // Elemente 2 – 56.3038 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumphosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "134.884";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg3P2";  // Elemente 2 – 134.86 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "56.376";
        Quizfragen[intLfdNr_Gesamt][4] = "MgS";  // Elemente 2 – 56.38 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "214.756";
        Quizfragen[intLfdNr_Gesamt][4] = "MnBr2";  // Elemente 2 – 214.75 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "125.844";
        Quizfragen[intLfdNr_Gesamt][4] = "MnCl2";  // Elemente 2 – 125.84 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "92.934";
        Quizfragen[intLfdNr_Gesamt][4] = "MnF2";  // Elemente 2 – 92.93 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(IV)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "130.93";
        Quizfragen[intLfdNr_Gesamt][4] = "MnF4";  // Elemente 2 – 130.93 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "70.937";
        Quizfragen[intLfdNr_Gesamt][4] = "MnO";  // Elemente 2 – 70.94 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "157.873";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn2O3";  // Elemente 2 – 157.88 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "86.936";
        Quizfragen[intLfdNr_Gesamt][4] = "MnO2";  // Elemente 2 – 86.94 g/mol Braunstein

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(VII)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "221.869";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn2O7";  // Elemente 2 – 221.87 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "87.002";
        Quizfragen[intLfdNr_Gesamt][4] = "MnS";  // Elemente 2 – 87.003 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumazid";
        Quizfragen[intLfdNr_Gesamt][3] = "65.011";
        Quizfragen[intLfdNr_Gesamt][4] = "NaN3";  // Elemente 2 – 65.0099 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "102.899";
        Quizfragen[intLfdNr_Gesamt][4] = "NaBr";  // Elemente 2 – 102.894 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "23.998";
        Quizfragen[intLfdNr_Gesamt][4] = "NaH";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "61.979";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2O";  // Elemente 2 – 61.979 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "77.978";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2O2";  // Elemente 2 – 77,98 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickeloxid";
        Quizfragen[intLfdNr_Gesamt][3] = "74.689";
        Quizfragen[intLfdNr_Gesamt][4] = "NiO";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-peroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "90.688";
        Quizfragen[intLfdNr_Gesamt][4] = "NiO2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "234.718";
        Quizfragen[intLfdNr_Gesamt][4] = "NbCl4";  // Elemente 2 – 234.72 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(V)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "270.171";
        Quizfragen[intLfdNr_Gesamt][4] = "NbCl5";  // Elemente 2 – 270.17 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "94.922";
        Quizfragen[intLfdNr_Gesamt][4] = "NbH2";  // Elemente 2 – 270.17 g/mol
        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "108.905";
        Quizfragen[intLfdNr_Gesamt][4] = "NbO";  // Elemente 2 – 108.9 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "124.904";
        Quizfragen[intLfdNr_Gesamt][4] = "NbO2";  // Elemente 2 – 124.91 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Niob(V)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "265.807";
        Quizfragen[intLfdNr_Gesamt][4] = "Nb2O5";  // Elemente 2 – 265.81 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Osmium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "222.198";
        Quizfragen[intLfdNr_Gesamt][4] = "OsO2";  // Elemente 2 – 222.20 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Osmium(VIII)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "254.196";
        Quizfragen[intLfdNr_Gesamt][4] = "OsO4";  // Elemente 2 – 254.23 g/mol

        // P

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "266.238";
        Quizfragen[intLfdNr_Gesamt][4] = "PdBr2";  // Elemente 2 – 266.2 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "177.326";
        Quizfragen[intLfdNr_Gesamt][4] = "PdCl2";  // Elemente 2 – 177.33 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "108.436";
        Quizfragen[intLfdNr_Gesamt][4] = "PdH2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "122.419";
        Quizfragen[intLfdNr_Gesamt][4] = "PdO";  // Elemente 2 – 122.42 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophortribromid";
        Quizfragen[intLfdNr_Gesamt][3] = "270.701";
        Quizfragen[intLfdNr_Gesamt][4] = "PBr3";  // Elemente 2 –  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorpentabromid";
        Quizfragen[intLfdNr_Gesamt][3] = "430.519";
        Quizfragen[intLfdNr_Gesamt][4] = "PBr5";  // Elemente 2 –  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophortrichlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "137.333";
        Quizfragen[intLfdNr_Gesamt][4] = "PCl3";  // Elemente 2 –  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorpentachlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "208.239";
        Quizfragen[intLfdNr_Gesamt][4] = "PCl5";  // Elemente 2 –  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophortrifluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "87.968";
        Quizfragen[intLfdNr_Gesamt][4] = "PF3";  // Elemente 2 – 87.96897 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophor(III)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "44.981";
        Quizfragen[intLfdNr_Gesamt][4] = "PN";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorpentoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "283.886";
        Quizfragen[intLfdNr_Gesamt][4] = "P4O10";  // Elemente 2 – 283.92 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophor(V)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "444.536";
        Quizfragen[intLfdNr_Gesamt][4] = "P4S10";  // Elemente 2 –

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "33.998";
        Quizfragen[intLfdNr_Gesamt][4] = "H3P";  // Elemente 2 – 33.99758 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(IV)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "514.726";
        Quizfragen[intLfdNr_Gesamt][4] = "PtBr4";  // Elemente 2 – 514.7 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "265.996";
        Quizfragen[intLfdNr_Gesamt][4] = "PtCl2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(VI)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "309.078";
        Quizfragen[intLfdNr_Gesamt][4] = "PtF6"; // Elemente 2 – 309.07 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(IV)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "199.122";
        Quizfragen[intLfdNr_Gesamt][4] = "PtH4"; // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "211.089";
        Quizfragen[intLfdNr_Gesamt][4] = "PtO";  // Elemente 2 – 211.08 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "227.088";
        Quizfragen[intLfdNr_Gesamt][4] = "PtO2";  // Elemente 2 – 227.077 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Polonium(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "212.016";
        Quizfragen[intLfdNr_Gesamt][4] = "PoH2";  // Elemente 2

        // Q

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "360.408";
        Quizfragen[intLfdNr_Gesamt][4] = "HgBr2";  // Elemente 2 – 360.41 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "271.496";
        Quizfragen[intLfdNr_Gesamt][4] = "HgCl2";  // Elemente 2 – 271.52 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "238.586";
        Quizfragen[intLfdNr_Gesamt][4] = "HgF2";  // Elemente 2 – 238.59 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-iodid";
        Quizfragen[intLfdNr_Gesamt][3] = "454.39";
        Quizfragen[intLfdNr_Gesamt][4] = "HgI2";  // Elemente 2 – 454.4 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "216.589";
        Quizfragen[intLfdNr_Gesamt][4] = "HgO";  // Elemente 2 – 216.59 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "232.654";
        Quizfragen[intLfdNr_Gesamt][4] = "HgS";  // Elemente 2 – 232.6 g/mol

        // R

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Radium(II)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "385.818";
        Quizfragen[intLfdNr_Gesamt][4] = "RaBr2";  // Elemente 2 – 385.83 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Radium(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "296.906";
        Quizfragen[intLfdNr_Gesamt][4] = "RaCl2";  // Elemente 2 – 296.094 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Radium(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "228.016";
        Quizfragen[intLfdNr_Gesamt][4] = "RaH2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rheniumdiborid";
        Quizfragen[intLfdNr_Gesamt][3] = "207.822";
        Quizfragen[intLfdNr_Gesamt][4] = "ReB2";  // Elemente 2 – 207.83 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rhenium(VI)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "234.197";
        Quizfragen[intLfdNr_Gesamt][4] = "ReO3";  // Elemente 2 – 234.21 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rhodiumdihydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "104.926";
        Quizfragen[intLfdNr_Gesamt][4] = "RhH2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "165.379";
        Quizfragen[intLfdNr_Gesamt][4] = "RbBr";  // Elemente 2 – 165.372 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "120.923";
        Quizfragen[intLfdNr_Gesamt][4] = "RbCl";  // Elemente 2 – 120.921 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "104.468";
        Quizfragen[intLfdNr_Gesamt][4] = "RbF";  // Elemente 2 – 104.4662 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "212.37";
        Quizfragen[intLfdNr_Gesamt][4] = "RbI";  // Elemente 2 – 212.3723 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "186.939";
        Quizfragen[intLfdNr_Gesamt][4] = "Rb2O";  // Elemente 2 – 186.94 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "202.938";
        Quizfragen[intLfdNr_Gesamt][4] = "Rb2O2";  // Elemente 2 – 186.94 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ruthenium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "207.429";
        Quizfragen[intLfdNr_Gesamt][4] = "RuCl3";  // Elemente 2 – 207.43 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ruthenium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "133.068";
        Quizfragen[intLfdNr_Gesamt][4] = "RuO2";  // Elemente 2 – 133.07 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ruthenium(VIII)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "165.066";
        Quizfragen[intLfdNr_Gesamt][4] = "RuO4";  // Elemente 2 – 165.07 g/mol

        // S

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selen(IV)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "154.952";
        Quizfragen[intLfdNr_Gesamt][4] = "SeF4";  // Elemente 2 – 154.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selen(VI)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "192.948";
        Quizfragen[intLfdNr_Gesamt][4] = "SeF6";  // Elemente 2 – 192.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selendioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "110.958";
        Quizfragen[intLfdNr_Gesamt][4] = "SeO2";  // Elemente 2 – 110.96 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selentrioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "126.957";
        Quizfragen[intLfdNr_Gesamt][4] = "SeO3";  // Elemente 2 – 126.958 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Selenwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "80.976";
        Quizfragen[intLfdNr_Gesamt][4] = "H2Se";  // Elemente 2 – 80.98 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberazid";
        Quizfragen[intLfdNr_Gesamt][3] = "149.891";
        Quizfragen[intLfdNr_Gesamt][4] = "AgN3";  // Elemente 2 – 149.888 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "187.779";
        Quizfragen[intLfdNr_Gesamt][4] = "AgBr";  // Elemente 2 – 187.77 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "143.323";
        Quizfragen[intLfdNr_Gesamt][4] = "AgCl";  // Elemente 2 – 143.32 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "126.868";
        Quizfragen[intLfdNr_Gesamt][4] = "AgF";  // Elemente 2 – 126.866 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "108.878";
        Quizfragen[intLfdNr_Gesamt][4] = "AgH";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "234.77";
        Quizfragen[intLfdNr_Gesamt][4] = "AgI";  // Elemente 2 – 234.77 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "231.739";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2O";  // Elemente 2 – 231.735 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silbersulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "247.804";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2S";  // Elemente 2 – 247.8 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Siliciumcarbid";
        Quizfragen[intLfdNr_Gesamt][3] = "44.075";
        Quizfragen[intLfdNr_Gesamt][4] = "SiC";  // Elemente 2 – 40.11 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Siliciumdioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "60.084";
        Quizfragen[intLfdNr_Gesamt][4] = "SiO2";  // Elemente 2 – 60.08 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Siliciumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "140.286";
        Quizfragen[intLfdNr_Gesamt][4] = "Si3N4";  // Elemente 2 – 140.28 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Siliciumtetrachlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "169.898";
        Quizfragen[intLfdNr_Gesamt][4] = "SiCl4";  // Elemente 2 – 169.9 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeldioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "64.062";
        Quizfragen[intLfdNr_Gesamt][4] = "SO2";  // Elemente 2 – 64,066 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeltrioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "80.061";
        Quizfragen[intLfdNr_Gesamt][4] = "SO3";  // Elemente 2 – 80,066 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeldichlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "102.97";
        Quizfragen[intLfdNr_Gesamt][4] = "SCl2";  // Elemente 2 – 102,97 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeltetrachlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "173.876";
        Quizfragen[intLfdNr_Gesamt][4] = "SCl4";  // Elemente 2 – 173,88 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeldifluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "70.06";
        Quizfragen[intLfdNr_Gesamt][4] = "SF2";  // Elemente 2 – 70,062 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelhexafluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "146.052";
        Quizfragen[intLfdNr_Gesamt][4] = "SF6";  // Elemente 2 – 146,0 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelkohlenstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "76.139";
        Quizfragen[intLfdNr_Gesamt][4] = "CS2";  // Elemente 2 – 76,139 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelmonoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "48.063";
        Quizfragen[intLfdNr_Gesamt][4] = "SO";  // Elemente 2 – 48,064 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "34.08";
        Quizfragen[intLfdNr_Gesamt][4] = "H2S";  // Elemente 2 – 34,1 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Scandium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "151.315";
        Quizfragen[intLfdNr_Gesamt][4] = "ScCl3";  // Elemente 2 – 151,31 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Scandium(III)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "101.95";
        Quizfragen[intLfdNr_Gesamt][4] = "ScF3";  // Elemente 2 – 101,9511 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Scandium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "137.909";
        Quizfragen[intLfdNr_Gesamt][4] = "Sc2O3";  // Elemente 2 – 137,91 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstoffdioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "46.005";
        Quizfragen[intLfdNr_Gesamt][4] = "NO2";  // Elemente 2 - 46,0055 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstoffmonoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "30.006";
        Quizfragen[intLfdNr_Gesamt][4] = "NO";  // Elemente 2 – 30,01 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Distickstoffpentoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "108.009";
        Quizfragen[intLfdNr_Gesamt][4] = "N2O5";  // Elemente 2 – 108,01 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Distickstofftrioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "76.011";
        Quizfragen[intLfdNr_Gesamt][4] = "N2O3";  // Elemente 2 – 76,01 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstofftrifluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "71.001";
        Quizfragen[intLfdNr_Gesamt][4] = "NF3";  // Elemente 2 - 71 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstofftrichlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "120.366";
        Quizfragen[intLfdNr_Gesamt][4] = "NCl3";  // Elemente 2 – 120,365 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstofftriiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "394.707";
        Quizfragen[intLfdNr_Gesamt][4] = "NI3";  // Elemente 2 – 394,719 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stickstofftribromid";
        Quizfragen[intLfdNr_Gesamt][3] = "253.734";
        Quizfragen[intLfdNr_Gesamt][4] = "NBr3";  // Elemente 2 – 253,7187 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "247.438";
        Quizfragen[intLfdNr_Gesamt][4] = "SrBr2";  // Elemente 2 – 247,43 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "158.526";
        Quizfragen[intLfdNr_Gesamt][4] = "SrCl2";  // Elemente 2 – 158,53 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "125.616";
        Quizfragen[intLfdNr_Gesamt][4] = "SrF2";  // Elemente 2 – 125,62 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "89.636";
        Quizfragen[intLfdNr_Gesamt][4] = "SrH2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumnitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "290.874";
        Quizfragen[intLfdNr_Gesamt][4] = "Sr3N2";  // Elemente 2 – 290,87 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "103.619";
        Quizfragen[intLfdNr_Gesamt][4] = "SrO";  // Elemente 2 – 103,62 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "119.618";
        Quizfragen[intLfdNr_Gesamt][4] = "SrO2";  // Elemente 2 – 119.619 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "119.684";
        Quizfragen[intLfdNr_Gesamt][4] = "SrS";  // Elemente 2 – 119,68 g/mol

        // T

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tantal(V)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "185.99";
        Quizfragen[intLfdNr_Gesamt][4] = "TaH5";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tantal(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "245.078";
        Quizfragen[intLfdNr_Gesamt][4] = "TaS2";  // Elemente 2 – 245,08 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tantal(III)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "194.957";
        Quizfragen[intLfdNr_Gesamt][4] = "TaN";  // Elemente 2 – 194,95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tantal(V)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "441.895";
        Quizfragen[intLfdNr_Gesamt][4] = "Ta2O5";  // Elemente 2 – 441,893 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tellurhexafluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "241.588";
        Quizfragen[intLfdNr_Gesamt][4] = "TeF6";  // Elemente 2 – 241,59 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Tellurdioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "159.598";
        Quizfragen[intLfdNr_Gesamt][4] = "TeO2";  // Elemente 2 – 159,6 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(I)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "239.833";
        Quizfragen[intLfdNr_Gesamt][4] = "TlCl";  // Elemente 2 – 239,82 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "310.739";
        Quizfragen[intLfdNr_Gesamt][4] = "TlCl3";  // Elemente 2 – 310,74 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(III)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "207.404";
        Quizfragen[intLfdNr_Gesamt][4] = "TlH3";  // Elemente 2 – 310,74 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "456.757";
        Quizfragen[intLfdNr_Gesamt][4] = "Tl2O3";  // Elemente 2 - g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(I)-peroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "440.758";
        Quizfragen[intLfdNr_Gesamt][4] = "Tl2O2";  // Elemente 2 - g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titan(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "189.692";
        Quizfragen[intLfdNr_Gesamt][4] = "TiCl4";  // Elemente 2 – 189,679 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titan(IV)-carbid";
        Quizfragen[intLfdNr_Gesamt][3] = "59.891";
        Quizfragen[intLfdNr_Gesamt][4] = "TiC";  // Elemente 2 – 59,89 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titandioxid";
        Quizfragen[intLfdNr_Gesamt][3] = "79.878";
        Quizfragen[intLfdNr_Gesamt][4] = "TiO2";  // Elemente 2 – 79,866 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titandihydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "49.896";
        Quizfragen[intLfdNr_Gesamt][4] = "TiH2";  // Elemente 2 – 79,866 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titanperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "191.754";
        Quizfragen[intLfdNr_Gesamt][4] = "Ti2(O2)3";  // Elemente 2 – 79,866 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titan(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "112.008";
        Quizfragen[intLfdNr_Gesamt][4] = "TiS2";  // Elemente 2 – 112,01 g/mol

        // V W Y

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium(IV)-carbid";
        Quizfragen[intLfdNr_Gesamt][3] = "62.953";
        Quizfragen[intLfdNr_Gesamt][4] = "VC";  // Elemente 2 - 62.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "157.301";
        Quizfragen[intLfdNr_Gesamt][4] = "VCl3";  // Elemente 2 – 157.3  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium(III)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "64.949";
        Quizfragen[intLfdNr_Gesamt][4] = "VN";  // Elemente 2 -  64.9482 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium(V)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "181.879";
        Quizfragen[intLfdNr_Gesamt][4] = "V2O5";  // Elemente 2 – 181.88  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Vanadium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "149.881";
        Quizfragen[intLfdNr_Gesamt][4] = "V2O3";  // Elemente 2 – 149.881  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(IV)-carbit";
        Quizfragen[intLfdNr_Gesamt][3] = "195.861";
        Quizfragen[intLfdNr_Gesamt][4] = "WC";  // Elemente 2 – 195.86 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(VI)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "396.568";
        Quizfragen[intLfdNr_Gesamt][4] = "WCl6";  // Elemente 2 – 396.56 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "254.756";
        Quizfragen[intLfdNr_Gesamt][4] = "WCl2";  // Elemente 2 – 254.74 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "325.662";
        Quizfragen[intLfdNr_Gesamt][4] = "WCl4";  // Elemente 2 – 325.65 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(VI)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "297.838";
        Quizfragen[intLfdNr_Gesamt][4] = "WF6";  // Elemente 2 – 297.83 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(II)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "579.564";
        Quizfragen[intLfdNr_Gesamt][4] = "W3N2";  // Elemente 2 – 579.53 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(VI)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "231.847";
        Quizfragen[intLfdNr_Gesamt][4] = "WO3";  // Elemente 2 – 231.84 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wolfram(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "247.978";
        Quizfragen[intLfdNr_Gesamt][4] = "WS2";  // Elemente 2 – 247.98 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chlorwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "36.461";
        Quizfragen[intLfdNr_Gesamt][4] = "HCl";  // Elemente 2 – 36.46 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Wasserstoffperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "34.014";
        Quizfragen[intLfdNr_Gesamt][4] = "H2O2";  // Elemente 2 – 34.0147 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Fluorwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "20.006";
        Quizfragen[intLfdNr_Gesamt][4] = "HF";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "34.08";
        Quizfragen[intLfdNr_Gesamt][4] = "H2S";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Yttrium(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "195.264";
        Quizfragen[intLfdNr_Gesamt][4] = "YCl3";  // Elemente 2 – 195.26 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Yttrium(III)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "145.899";
        Quizfragen[intLfdNr_Gesamt][4] = "YF3";  // Elemente 2 – 145.9  g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Yttrium(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "225.807";
        Quizfragen[intLfdNr_Gesamt][4] = "Y2O3";  // Elemente 2 – 225.81 g/mol

        // Z

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "225.188";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnBr2";  // Elemente 2 – 225.198 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "136.276";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnCl2";  // Elemente 2 – 136.286 g/mol
        intLfdNr_Level++;

        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "81.369";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnO";  // Elemente 2 – 81.38 g/mol

        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkperoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "97.368";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnO2";  // Elemente 2 – 81.38 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "103.366";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnF2";  // Elemente 2 – 103.406 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zink(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "67.386";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnH2";  // Elemente 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "319.17";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnI2";  // Elemente 2 – 319.2 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinknitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "224.124";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn3N2";  // Elemente 2 – 224.154 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkphosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "258.058";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn3P2";  // Elemente 2 – 258.12 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinksulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "97.434";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnS";  // Elemente 2 – 97.474 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "189.596";
        Quizfragen[intLfdNr_Gesamt][4] = "SnCl2";  // Elemente 2 – 189.6 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "150.688";
        Quizfragen[intLfdNr_Gesamt][4] = "SnO2";  // Elemente 2 – 150.71 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "156.686";
        Quizfragen[intLfdNr_Gesamt][4] = "SnF2";  // Elemente 2 – 156.69 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "134.689";
        Quizfragen[intLfdNr_Gesamt][4] = "SnO";  // Elemente 2 – 134.7 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "150.754";
        Quizfragen[intLfdNr_Gesamt][4] = "SnS";  // Elemente 2 – 150.76 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "182.818";
        Quizfragen[intLfdNr_Gesamt][4] = "SnS2";  // Elemente 2 – 182.84 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-bromid";
        Quizfragen[intLfdNr_Gesamt][3] = "410.856";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrBr4";  // Elemente 2 – 410.86 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "233.032";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrCl4";  // Elemente 2 – 233.04 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "167.212";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrF4";  // Elemente 2 – 167.21 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(II)-hydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "93.236";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrH2";  // Elemente 2 –

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-nitrid";
        Quizfragen[intLfdNr_Gesamt][3] = "105.227";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrN";  // Elemente 2 – 105.23 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "123.218";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrO2";  // Elemente 2 – 123.218 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "155.348";
        Quizfragen[intLfdNr_Gesamt][4] = "ZrS2";  // Elemente 2 – 155.356 g/mol

        //endregion

        //region Fragen für Level 4
        /**********************************
         ****** Ternäre Verbindungen *******
         **********************************/
        intLevel = 4;
        intLfdNr_Level = 0;

        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "233.988";
        Quizfragen[intLfdNr_Gesamt][4] = "Al2(CO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "78.003";
        Quizfragen[intLfdNr_Gesamt][4] = "Al(OH)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "212.994";
        Quizfragen[intLfdNr_Gesamt][4] = "Al(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "121.952";
        Quizfragen[intLfdNr_Gesamt][4] = "AlPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "342.144";
        Quizfragen[intLfdNr_Gesamt][4] = "Al2(SO4)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "172.771";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb(OH)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(V)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "206.785";
        Quizfragen[intLfdNr_Gesamt][4] = "Sb(OH)5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "97.948";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4Br";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumchlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "53.492";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4Cl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumfluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "37.037";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4F";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumiodid";
        Quizfragen[intLfdNr_Gesamt][3] = "144.939";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4I";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumborat";
        Quizfragen[intLfdNr_Gesamt][3] = "222.958";
        Quizfragen[intLfdNr_Gesamt][4] = "BaB2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumbromat";
        Quizfragen[intLfdNr_Gesamt][3] = "393.152";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(BrO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "197.348";
        Quizfragen[intLfdNr_Gesamt][4] = "BaCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumchromat";
        Quizfragen[intLfdNr_Gesamt][3] = "253.332";
        Quizfragen[intLfdNr_Gesamt][4] = "BaCrO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "304.24";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(ClO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "171.354";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(OH)2";


        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumiodat";
        Quizfragen[intLfdNr_Gesamt][3] = "487.134";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(IO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "261.348";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumnitrit";
        Quizfragen[intLfdNr_Gesamt][3] = "229.35";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(NO2)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumoxalat";
        Quizfragen[intLfdNr_Gesamt][3] = "225.358";
        Quizfragen[intLfdNr_Gesamt][4] = "BaC2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "601.96";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "336.238";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(ClO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumpermanganat";
        Quizfragen[intLfdNr_Gesamt][3] = "375.208";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(MnO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "233.4";
        Quizfragen[intLfdNr_Gesamt][4] = "BaSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "217.401";
        Quizfragen[intLfdNr_Gesamt][4] = "BaSO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumtitanat";
        Quizfragen[intLfdNr_Gesamt][3] = "233.217";
        Quizfragen[intLfdNr_Gesamt][4] = "BaTiO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumthiosulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "249.465";
        Quizfragen[intLfdNr_Gesamt][4] = "BaS2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumwolframat";
        Quizfragen[intLfdNr_Gesamt][3] = "385.186";
        Quizfragen[intLfdNr_Gesamt][4] = "BaWO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bismut(III)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "394.992";
        Quizfragen[intLfdNr_Gesamt][4] = "Bi(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "241.204";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "331.198";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bleiphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "811.51";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "303.25";
        Quizfragen[intLfdNr_Gesamt][4] = "PbSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Borsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "61.832";
        Quizfragen[intLfdNr_Gesamt][4] = "H3BO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumcarbonat"; // CaCO3
        Quizfragen[intLfdNr_Gesamt][3] = "100.088"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CaCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumhydroxid"; // Ca(OH)2
        Quizfragen[intLfdNr_Gesamt][3] = "74.094"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumhypochlorid"; // Ca(ClO)2
        Quizfragen[intLfdNr_Gesamt][3] = "142.984"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(ClO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumiodat"; // Ca(IO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "389.874"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(IO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumnitrat"; // Ca(NO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "164.088"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumnitrit"; // Ca(NO2)2
        Quizfragen[intLfdNr_Gesamt][3] = "132.09"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(NO2)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumoxalat"; // CaC2O4
        Quizfragen[intLfdNr_Gesamt][3] = "128.098"; // 3  schwer
        Quizfragen[intLfdNr_Gesamt][4] = "CaC2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumphosphat"; // Ca3(PO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "310.18"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Ca3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumsulfit"; // CaSO3
        Quizfragen[intLfdNr_Gesamt][3] = "120.141"; // 2
        Quizfragen[intLfdNr_Gesamt][4] = "CaSO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumsulfat"; // CaSO4
        Quizfragen[intLfdNr_Gesamt][3] = "136.14"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CaSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumcarbonat"; // CdCO3
        Quizfragen[intLfdNr_Gesamt][3] = "172.408"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CdCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumcyanid"; // Cd(CN)2
        Quizfragen[intLfdNr_Gesamt][3] = "164.436"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cd(CN)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumhydroxid"; // Cd(OH)2
        Quizfragen[intLfdNr_Gesamt][3] = "146.414"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cd(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumnitrat"; // Cd(NO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "236.408"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cd(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumphosphat"; // Cd3(PO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "527.14"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cd3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumsulfat"; // CdSO4
        Quizfragen[intLfdNr_Gesamt][3] = "208.46"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CdSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumcarbonat"; // Cs2CO3
        Quizfragen[intLfdNr_Gesamt][3] = "325.828"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cs2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumhydroxid"; // CsOH
        Quizfragen[intLfdNr_Gesamt][3] = "149.917"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CsOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumnitrat"; //CsNO3
        Quizfragen[intLfdNr_Gesamt][3] = "194.914"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CsNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cäsiumsulfat"; // Cs2SO4
        Quizfragen[intLfdNr_Gesamt][3] = "361.88"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cs2SO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-hydroxid"; // Cr(OH)3
        Quizfragen[intLfdNr_Gesamt][3] = "103.017"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cr(OH)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-nitrat"; // Cr(NO3)3
        Quizfragen[intLfdNr_Gesamt][3] = "238.008"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cr(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-phosphat"; // CrPO4
        Quizfragen[intLfdNr_Gesamt][3] = "146.966"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CrPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chrom(III)-sulfat"; // Cr2(SO4)3
        Quizfragen[intLfdNr_Gesamt][3] = "392.172"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Cr2(SO4)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-carbonat"; // CoCO3
        Quizfragen[intLfdNr_Gesamt][3] = "118.941"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CoCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-hydroxid"; // Co(OH)2
        Quizfragen[intLfdNr_Gesamt][3] = "92.947"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Co(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-perchlorat"; // Co(ClO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "257.831"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Co(ClO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-sulfat"; // CoSO4
        Quizfragen[intLfdNr_Gesamt][3] = "154.993"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "CoSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-nitrat"; // Fe(NO3)3
        Quizfragen[intLfdNr_Gesamt][3] = "241.859"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Fe(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-oxalat"; // FeC2O4
        Quizfragen[intLfdNr_Gesamt][3] = "143.865"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "FeC2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-phosphat"; // Fe3(PO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "357.481"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Fe3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-phosphat"; // FePO4
        Quizfragen[intLfdNr_Gesamt][3] = "150.817"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "FePO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-sulfat"; // FeSO4
        Quizfragen[intLfdNr_Gesamt][3] = "151.907"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "FeSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-sulfat"; // Fe2(SO4)3
        Quizfragen[intLfdNr_Gesamt][3] = "399.874"; // 3
        Quizfragen[intLfdNr_Gesamt][4] = "Fe2(SO4)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Essigsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "60.052";
        Quizfragen[intLfdNr_Gesamt][4] = "CH3COOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "120.741";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga(OH)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "255.732";
        Quizfragen[intLfdNr_Gesamt][4] = "Ga(NO3)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Galliumorthophosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "164.69";
        Quizfragen[intLfdNr_Gesamt][4] = "GaPO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "106.604";
        Quizfragen[intLfdNr_Gesamt][4] = "Ge(OH)2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-carbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "409.664";
        Quizfragen[intLfdNr_Gesamt][4] = "In2(CO3)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "165.841";
        Quizfragen[intLfdNr_Gesamt][4] = "In(OH)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "300.832";
        Quizfragen[intLfdNr_Gesamt][4] = "In(NO3)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "517.82";
        Quizfragen[intLfdNr_Gesamt][4] = "In2(SO4)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalilauge";
        Quizfragen[intLfdNr_Gesamt][3] = "56.109";
        Quizfragen[intLfdNr_Gesamt][4] = "KOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumbromat";
        Quizfragen[intLfdNr_Gesamt][3] = "167.008";
        Quizfragen[intLfdNr_Gesamt][4] = "KBrO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "122.552";
        Quizfragen[intLfdNr_Gesamt][4] = "KClO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumcyanid";
        Quizfragen[intLfdNr_Gesamt][3] = "65.12";
        Quizfragen[intLfdNr_Gesamt][4] = "KCN";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "138.212";
        Quizfragen[intLfdNr_Gesamt][4] = "K2CO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumchromat";
        Quizfragen[intLfdNr_Gesamt][3] = "194.196";
        Quizfragen[intLfdNr_Gesamt][4] = "K2CrO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumdichromat";
        Quizfragen[intLfdNr_Gesamt][3] = "294.189";
        Quizfragen[intLfdNr_Gesamt][4] = "K2Cr2O7";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumdisulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "222.327";
        Quizfragen[intLfdNr_Gesamt][4] = "K2S2O5";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumferrat";
        Quizfragen[intLfdNr_Gesamt][3] = "198.047";
        Quizfragen[intLfdNr_Gesamt][4] = "K2FeO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhexachloroplatinat (IV)";
        Quizfragen[intLfdNr_Gesamt][3] = "486.012";
        Quizfragen[intLfdNr_Gesamt][4] = "K2PtCl6";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "56.109";
        Quizfragen[intLfdNr_Gesamt][4] = "KOH";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhypochlorit";
        Quizfragen[intLfdNr_Gesamt][3] = "90.554";
        Quizfragen[intLfdNr_Gesamt][4] = "KClO";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumiodat";
        Quizfragen[intLfdNr_Gesamt][3] = "213.999";
        Quizfragen[intLfdNr_Gesamt][4] = "KIO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "101.106";
        Quizfragen[intLfdNr_Gesamt][4] = "KNO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumnitrit";
        Quizfragen[intLfdNr_Gesamt][3] = "85.107";
        Quizfragen[intLfdNr_Gesamt][4] = "KNO2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumpermanganat";
        Quizfragen[intLfdNr_Gesamt][3] = "158.036";
        Quizfragen[intLfdNr_Gesamt][4] = "KMnO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "138.551";
        Quizfragen[intLfdNr_Gesamt][4] = "KClO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "212.276";
        Quizfragen[intLfdNr_Gesamt][4] = "K3PO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumperoxodisulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "270.324";
        Quizfragen[intLfdNr_Gesamt][4] = "K2S2O8";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "174.264";
        Quizfragen[intLfdNr_Gesamt][4] = "K2SO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "158.265";
        Quizfragen[intLfdNr_Gesamt][4] = "K2SO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumthiosulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "190.329";
        Quizfragen[intLfdNr_Gesamt][4] = "K2S2O3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-cyanid";
        Quizfragen[intLfdNr_Gesamt][3] = "89.558";
        Quizfragen[intLfdNr_Gesamt][4] = "CuCN";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "97.554";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu(OH)2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "187.548";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu(NO3)2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(II)-phosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "380.56";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu3(PO4)2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfersulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "159.6";
        Quizfragen[intLfdNr_Gesamt][4] = "CuSO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthancarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "457.844";
        Quizfragen[intLfdNr_Gesamt][4] = "La2(CO3)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthannitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "324.922";
        Quizfragen[intLfdNr_Gesamt][4] = "La(NO3)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumaluminiumhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "37.953";
        Quizfragen[intLfdNr_Gesamt][4] = "LiAlH4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumamid";
        Quizfragen[intLfdNr_Gesamt][3] = "22.962";
        Quizfragen[intLfdNr_Gesamt][4] = "LiNH2";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumborhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "21.782";
        Quizfragen[intLfdNr_Gesamt][4] = "LiBH4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "73.886";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2CO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "23.946";
        Quizfragen[intLfdNr_Gesamt][4] = "LiOH";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "73.886";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2CO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiummolybdat";
        Quizfragen[intLfdNr_Gesamt][3] = "173.814";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2MoO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "68.943";
        Quizfragen[intLfdNr_Gesamt][4] = "LiNO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumniobat";
        Quizfragen[intLfdNr_Gesamt][3] = "147.842";
        Quizfragen[intLfdNr_Gesamt][4] = "LiNbO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "115.787";
        Quizfragen[intLfdNr_Gesamt][4] = "Li3PO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "106.388";
        Quizfragen[intLfdNr_Gesamt][4] = "LiClO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "109.938";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2SO4";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumtantalat";
        Quizfragen[intLfdNr_Gesamt][3] = "235.886";
        Quizfragen[intLfdNr_Gesamt][4] = "LiTaO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumtetraborat";
        Quizfragen[intLfdNr_Gesamt][3] = "169.115";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2B4O7";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumaluminat";
        Quizfragen[intLfdNr_Gesamt][3] = "142.272";
        Quizfragen[intLfdNr_Gesamt][4] = "MgAl2O4";  // Elemente 3 – 142.27 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "84.32";
        Quizfragen[intLfdNr_Gesamt][4] = "MgCO3";  // Elemente 3 – 84.3139 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "58.326";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(OH)2";  // Elemente 2 – 58.3197 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "148.32";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(NO3)2";  // Elemente 3 – 148.3 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "262.876";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg3(PO4)2";  // Elemente 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "223.21";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(ClO4)2";  // Elemente 3 – 223.206 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "120.372";
        Quizfragen[intLfdNr_Gesamt][4] = "MgSO4";  // Elemente 3 – 120.366 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "104.373";
        Quizfragen[intLfdNr_Gesamt][4] = "MgSO3";  // Elemente 3 – 104.3682 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumthiosulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "136.437";
        Quizfragen[intLfdNr_Gesamt][4] = "MgS2O3";  // Elemente 3 – 136.43 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumwolframat";
        Quizfragen[intLfdNr_Gesamt][3] = "272.158";
        Quizfragen[intLfdNr_Gesamt][4] = "MgWO4";  // Elemente 3 – 272.14 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-carbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "114.946";
        Quizfragen[intLfdNr_Gesamt][4] = "MnCO3";  // Elemente 3 – 114.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "88.952";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn(OH)2";  // Elemente 3 – 88.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "178.946";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn(NO3)2";  // Elemente 3 – 178.95 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "150.001";
        Quizfragen[intLfdNr_Gesamt][4] = "MnSO4";  // Elemente 3 – 151.001 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natronlauge";
        Quizfragen[intLfdNr_Gesamt][3] = "39.997";
        Quizfragen[intLfdNr_Gesamt][4] = "NaOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumaluminat";
        Quizfragen[intLfdNr_Gesamt][3] = "81.97";
        Quizfragen[intLfdNr_Gesamt][4] = "NaAlO2";  // Elemente 3 – 81.97 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumamid";
        Quizfragen[intLfdNr_Gesamt][3] = "39.013";
        Quizfragen[intLfdNr_Gesamt][4] = "NaNH2";  // Elemente 3 – 39.01 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumbromat";
        Quizfragen[intLfdNr_Gesamt][3] = "150.896";
        Quizfragen[intLfdNr_Gesamt][4] = "NaBrO3";  // Elemente 3 – 150.89 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumborhydrid";
        Quizfragen[intLfdNr_Gesamt][3] = "37.833";
        Quizfragen[intLfdNr_Gesamt][4] = "NaBH4";  // Elemente 3 – 37.83 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "105.988";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2CO3";  // Elemente 3 – 105.9888 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumchlorit";
        Quizfragen[intLfdNr_Gesamt][3] = "90.441";
        Quizfragen[intLfdNr_Gesamt][4] = "NaClO2";  // Elemente 3 – 90.44 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "106.44";
        Quizfragen[intLfdNr_Gesamt][4] = "NaClO3";  // Elemente 3 – 106.44 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumcyanid";
        Quizfragen[intLfdNr_Gesamt][3] = "49.008";
        Quizfragen[intLfdNr_Gesamt][4] = "NaCN";  // Elemente 3 – 49.0072 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumdithionit";
        Quizfragen[intLfdNr_Gesamt][3] = "174.104";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O4";  // Elemente 3 – 174.107 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumdithionat";
        Quizfragen[intLfdNr_Gesamt][3] = "206.102";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O6";  // Elemente 3 – 174.107 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumdisulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "190.103";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O5";  // Elemente 3 – 190.107 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumdichromat";
        Quizfragen[intLfdNr_Gesamt][3] = "261.965";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2Cr2O7";  // Elemente 3 – 261.97 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "39.997";
        Quizfragen[intLfdNr_Gesamt][4] = "NaOH";  // Elemente 3 – 39.997 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhypochlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "74.442";
        Quizfragen[intLfdNr_Gesamt][4] = "NaClO";  // Elemente 3 – 74.44 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumiodat";
        Quizfragen[intLfdNr_Gesamt][3] = "197.887";
        Quizfragen[intLfdNr_Gesamt][4] = "NaIO3";  // Elemente 3 – 197.8924 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriummolybdat";
        Quizfragen[intLfdNr_Gesamt][3] = "205.916";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2MoO4";  // Elemente 3 – 205.92 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumnitrit";
        Quizfragen[intLfdNr_Gesamt][3] = "68.995";
        Quizfragen[intLfdNr_Gesamt][4] = "NaNO2";  // Elemente 3 – 68.9953 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "84.994";
        Quizfragen[intLfdNr_Gesamt][4] = "NaNO3";  // Elemente 3 – 84.9947 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumpersulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "238.1";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O8";  // Elemente 3 – 238.03 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "163.94";
        Quizfragen[intLfdNr_Gesamt][4] = "Na3PO4";  // Elemente 3 – 163.94 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "122.439";
        Quizfragen[intLfdNr_Gesamt][4] = "NaClO4";  // Elemente 3 – 122.44 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "126.041";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2SO3";  // Elemente 3 – 126.043 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "142.04";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2SO4";  // Elemente 3 – 142.04 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumselenit";
        Quizfragen[intLfdNr_Gesamt][3] = "172.937";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2SeO3";  // Elemente 3 – 172.94 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumsilikat";
        Quizfragen[intLfdNr_Gesamt][3] = "122.063";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2SiO3";  // Elemente 3 – 122.06 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Dinatriumtetraborat";
        Quizfragen[intLfdNr_Gesamt][3] = "201.217";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2B4O7";  // Elemente 3 –

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumthiosulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "158.105";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O3";  // Elemente 3 – 158.11 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriummetavanadat";
        Quizfragen[intLfdNr_Gesamt][3] = "121.929";
        Quizfragen[intLfdNr_Gesamt][4] = "NaVO3";  // Elemente 3 – 121.9295 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-carbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "118.698";
        Quizfragen[intLfdNr_Gesamt][4] = "NiCO3";  // Elemente 3 – 118.702 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "92.704";
        Quizfragen[intLfdNr_Gesamt][4] = "Ni(OH)2";  // Elemente 3 – 92.708 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "182.698";
        Quizfragen[intLfdNr_Gesamt][4] = "Ni(NO3)2";  // Elemente 3 – 182.703 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "154.75";
        Quizfragen[intLfdNr_Gesamt][4] = "NiSO4";  // Elemente 3 – 154.75 g/mol

        // P

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "230.428";
        Quizfragen[intLfdNr_Gesamt][4] = "Pd(NO3)2";  // Elemente 2 – 230.43 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "97.994";
        Quizfragen[intLfdNr_Gesamt][4] = "H3PO4";  // Elemente 3 – 97.994 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phophorige Säure";
        Quizfragen[intLfdNr_Gesamt][3] = "81.995";
        Quizfragen[intLfdNr_Gesamt][4] = "H3PO3";  // Elemente 3 – 82 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(IV)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "443.106";
        Quizfragen[intLfdNr_Gesamt][4] = "Pt(NO3)4";  // Elemente 3 - 443.1 g/mol

        // Q

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-cyanid";
        Quizfragen[intLfdNr_Gesamt][3] = "252.626";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg(CN)2";  // Elemente 3 – 252.63 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "324.598";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg(NO3)2";  // Elemente 3 – 324.7 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "296.65";
        Quizfragen[intLfdNr_Gesamt][4] = "HgSO4";  // Elemente 3 – 296.65 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(I)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "497.24";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg2SO4";  // Elemente 3 – 497.24 g/mol

        // R

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "230.948";
        Quizfragen[intLfdNr_Gesamt][4] = "Rb2CO3";  // Elemente 3 – 230.945 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumcyanid";
        Quizfragen[intLfdNr_Gesamt][3] = "111.488";
        Quizfragen[intLfdNr_Gesamt][4] = "RbCN";  // Elemente 3 – 111.486 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "102.477";
        Quizfragen[intLfdNr_Gesamt][4] = "RbOH";  // Elemente 3 – 102.475 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "147.474";
        Quizfragen[intLfdNr_Gesamt][4] = "RbNO3";  // Elemente 3 – 147.473 g/mol

        // S

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schweflige Säure";
        Quizfragen[intLfdNr_Gesamt][3] = "82.077";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO3";  // Elemente 3 – 82,07 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "98.076";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO4";  // Elemente 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "schweflige Säure";
        Quizfragen[intLfdNr_Gesamt][3] = "82.077";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Salpetersäure";
        Quizfragen[intLfdNr_Gesamt][3] = "63.012";
        Quizfragen[intLfdNr_Gesamt][4] = "HNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silbercarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "275.748";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2CO3";  // Elemente 3 – 275.7453 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberchromat";
        Quizfragen[intLfdNr_Gesamt][3] = "331.732";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2CrO4";  // Elemente 3 – 331.73 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "124.877";
        Quizfragen[intLfdNr_Gesamt][4] = "AgOH";  // Elemente 3 – 124.88 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silbernitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "169.874";
        Quizfragen[intLfdNr_Gesamt][4] = "AgNO3";  // Elemente 3 – 169.87 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silbersulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "311.8";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2SO4";  // Elemente 3 – 311.799 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumaluminat";
        Quizfragen[intLfdNr_Gesamt][3] = "205.58";
        Quizfragen[intLfdNr_Gesamt][4] = "SrAl2O4";  // Elemente 3 – 205,58 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "147.628";
        Quizfragen[intLfdNr_Gesamt][4] = "SrCO3";  // Elemente 3 – 147,63 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumchromat";
        Quizfragen[intLfdNr_Gesamt][3] = "203.612";
        Quizfragen[intLfdNr_Gesamt][4] = "SrCrO4";  // Elemente 3 – 203,614 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "121.634";
        Quizfragen[intLfdNr_Gesamt][4] = "Sr(OH)2";  // Elemente 3 – 121,63 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "211.628";
        Quizfragen[intLfdNr_Gesamt][4] = "Sr(NO3)2";  // Elemente 3 – 211,63 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "183.68";
        Quizfragen[intLfdNr_Gesamt][4] = "SrSO4";  // Elemente 3 – 183,68 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumtitanat";
        Quizfragen[intLfdNr_Gesamt][3] = "183.497";
        Quizfragen[intLfdNr_Gesamt][4] = "SrTiO3";  // Elemente 3 – 183,49 g/mol

        // T

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(I)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "221.387";
        Quizfragen[intLfdNr_Gesamt][4] = "TlOH";  // Elemente 3 – 221,39 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(I)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "266.384";
        Quizfragen[intLfdNr_Gesamt][4] = "TlNO3";  // Elemente 3 – 266,39 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Thallium(I)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "504.82";
        Quizfragen[intLfdNr_Gesamt][4] = "Tl2SO4";  // Elemente 3 – 504,83 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Titan(III)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "383.94";
        Quizfragen[intLfdNr_Gesamt][4] = "Ti2(SO4)3";  // Elemente 3 – 383,92 g/mol

        // V W Y

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cyanwasserstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "27.026";
        Quizfragen[intLfdNr_Gesamt][4] = "HCN";  // Elemente 3 – 27.0253 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Yttrium(III)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "274.917";
        Quizfragen[intLfdNr_Gesamt][4] = "Y(NO3)3";  // Elemente 3 – 274.92 g/mol

        // Z

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "125.378";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnCO3";  // Elemente 3 – 125.42 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkchromat";
        Quizfragen[intLfdNr_Gesamt][3] = "181.362";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnCrO4";  // Elemente 3 – 181.38 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "99.384";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn(OH)2";  // Elemente 3 – 99.424 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinknitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "189.378";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn(NO3)2";  // Elemente 3 – 189.36 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "386.05";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn3(PO4)2";  // Elemente 3 – 386.11 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinksulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "161.43";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnSO4";  // Elemente 3 – 161.47 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "152.704";
        Quizfragen[intLfdNr_Gesamt][4] = "Sn(OH)2";  // Elemente 3 – 152.73 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "214.75";
        Quizfragen[intLfdNr_Gesamt][4] = "SnSO4";  // Elemente 3 – 214.77 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinn(IV)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "310.81";
        Quizfragen[intLfdNr_Gesamt][4] = "Sn(SO4)2";  // Elemente 3 – 310.84 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "339.236";
        Quizfragen[intLfdNr_Gesamt][4] = "Zr(NO3)4";  // Elemente 3 – 339.24 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "283.34";
        Quizfragen[intLfdNr_Gesamt][4] = "Zr(SO4)2";  // Elemente 3 – 285.35 g/mol

        //endregion

        //region Fragen für Level 5
        /**********************************
         ****** Quaternäre Verbindungen *******
         **********************************/
        intLevel = 5;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "204.114";
        Quizfragen[intLfdNr_Gesamt][4] = "Al(CH3COO)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "77.083";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4CH3COO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "96.086";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumcyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "60.056";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4OCN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumdichromat";
        Quizfragen[intLfdNr_Gesamt][3] = "252.063";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2Cr2O7";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumhydrogencarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "79.055";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4HCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumdihydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "115.025";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4H2PO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Diammoniumhydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "132.056";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2HPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumhydrogensulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "99.108";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4HSO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumhydrogensulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "115.107";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4HSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumheptamolydat";
        Quizfragen[intLfdNr_Gesamt][3] = "1163.79";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)6Mo7O24";


        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumeisen(II)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "284.045";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2Fe(SO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumeisen(III)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "266.006";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4Fe(SO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniummagnesiumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "137.321";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4MgPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniummetavanadat";
        Quizfragen[intLfdNr_Gesamt][3] = "116.978";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4VO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "80.043";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4NO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumoxalat";
        Quizfragen[intLfdNr_Gesamt][3] = "124.096";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2C2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "149.087";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)3PO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumperoxodisulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "228.198";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2S2O8";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "117.488";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4ClO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "68.142";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2S";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "116.139";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2SO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "132.138";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2SO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumthiocyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "76.121";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4SCN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumthiosulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "148.203";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2S2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "255.428";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumthiocyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "253.504";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(SCN)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "127.1";
        Quizfragen[intLfdNr_Gesamt][4] = "Be(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blei(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "325.278";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "158.168";
        Quizfragen[intLfdNr_Gesamt][4] = "CaCH3COO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumcitrat"; // Ca3(C6H5O7)2
        Quizfragen[intLfdNr_Gesamt][3] = "498.438"; // 4 sehr schwer
        Quizfragen[intLfdNr_Gesamt][4] = "Ca3(C6H5O7)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumdihydrogenphosphat"; // Ca(H2PO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "234.052"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(H2PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumhydrogencarbonat"; // Ca(HCO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "162.112"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(HCO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumhydrogenphosphat"; // CaHPO4
        Quizfragen[intLfdNr_Gesamt][3] = "136.058"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "CaHPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumthiocyanat"; // Ca(SCN)2
        Quizfragen[intLfdNr_Gesamt][3] = "156.244"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(SCN)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumacetat"; // Cd(CH3COO)2
        Quizfragen[intLfdNr_Gesamt][3] = "230.488"; // 5
        Quizfragen[intLfdNr_Gesamt][4] = "Cd(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-acetat"; // Co(CH3COO)2
        Quizfragen[intLfdNr_Gesamt][3] = "177.021"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Co(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-thiocyanat"; // Co(SCN)2
        Quizfragen[intLfdNr_Gesamt][3] = "175.097"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Co(SCN)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-acetat"; // Fe(CH3COO)2
        Quizfragen[intLfdNr_Gesamt][3] = "173.935"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Fe(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-thiocyanat"; // Fe(SCN)3
        Quizfragen[intLfdNr_Gesamt][3] = "230.093"; // 4
        Quizfragen[intLfdNr_Gesamt][4] = "Fe(SCN)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold(III)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "374.102";
        Quizfragen[intLfdNr_Gesamt][4] = "Au(CH3COO)3";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumaluminiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "258.204";
        Quizfragen[intLfdNr_Gesamt][4] = "KAl(SO4)2";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "98.146";
        Quizfragen[intLfdNr_Gesamt][4] = "KCH3COO";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumcyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "81.119";
        Quizfragen[intLfdNr_Gesamt][4] = "KOCN";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumdihydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "136.088";
        Quizfragen[intLfdNr_Gesamt][4] = "KH2PO4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhexacyanoferrat(II)";
        Quizfragen[intLfdNr_Gesamt][3] = "368.363";
        Quizfragen[intLfdNr_Gesamt][4] = "K4Fe(CN)6";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhexacyanoferrat(III)";
        Quizfragen[intLfdNr_Gesamt][3] = "329.261";
        Quizfragen[intLfdNr_Gesamt][4] = "K3Fe(CN)6";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhydrogencarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "100.118";
        Quizfragen[intLfdNr_Gesamt][4] = "KHCO3";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhydrogensulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "136.17";
        Quizfragen[intLfdNr_Gesamt][4] = "KHSO4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumdihydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "136.088";
        Quizfragen[intLfdNr_Gesamt][4] = "KH2PO4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Dikaliumhydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "174.182";
        Quizfragen[intLfdNr_Gesamt][4] = "K2HPO4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumhydrogenphthalat";
        Quizfragen[intLfdNr_Gesamt][3] = "204.226";
        Quizfragen[intLfdNr_Gesamt][4] = "KC8H5O4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumthiocyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "97.184";
        Quizfragen[intLfdNr_Gesamt][4] = "KSCN";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupferacetat ";
        Quizfragen[intLfdNr_Gesamt][3] = "181.628";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu(CH3COO)2";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfer(I)-thiocyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "121.622";
        Quizfragen[intLfdNr_Gesamt][4] = "CuSCN";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "65.983";
        Quizfragen[intLfdNr_Gesamt][4] = "LiCH3COO";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumeisenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "157.756";
        Quizfragen[intLfdNr_Gesamt][4] = "LiFePO4";  // 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "142.4";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(CH3COO)2";  // Elemente 4 142.394g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumhydrogencarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "146.344";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(HCO3)2";  // Elemente 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumhydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "120.29";
        Quizfragen[intLfdNr_Gesamt][4] = "MgHPO4";  // Elemente 4  - 120.33 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiumhydrogensulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "218.448";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(HSO4)2";  // Elemente 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "173.026";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn(CH3COO)2";  // Elemente 4 – 173.03 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mangan(III)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "232.07";
        Quizfragen[intLfdNr_Gesamt][4] = "Mn(CH3COO)3";  // Elemente 4

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "82.034";
        Quizfragen[intLfdNr_Gesamt][4] = "NaCH3COO";  // Elemente 4 – 82.0343 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhexanitrocobaltat(III)";
        Quizfragen[intLfdNr_Gesamt][3] = "403.933";
        Quizfragen[intLfdNr_Gesamt][4] = "Na3Co(NO2)6";  // Elemente 4 – 82.0343 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumdihydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "119.976";
        Quizfragen[intLfdNr_Gesamt][4] = "NaH2PO4";  // Elemente 4 – 119.98 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhydrogencarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "84.006";
        Quizfragen[intLfdNr_Gesamt][4] = "NaHCO3";  // Elemente 4 – 84.007 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhydrogensulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "120.058";
        Quizfragen[intLfdNr_Gesamt][4] = "NaHSO4";  // Elemente 4 – 120.06 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Dinatriumhydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "141.958";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2HPO4";  // Elemente 4 – 141.96 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumhydrogensulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "104.059";
        Quizfragen[intLfdNr_Gesamt][4] = "NaHSO3";  // Elemente 4 – 104.061 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumthiocyanat";
        Quizfragen[intLfdNr_Gesamt][3] = "81.072";
        Quizfragen[intLfdNr_Gesamt][4] = "NaSCN";  // Elemente 4 – 81.072 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Nickel(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "176.778";
        Quizfragen[intLfdNr_Gesamt][4] = "Ni(CH3COO)2";  // Elemente 4 – 176.78 g/mol

        // P

        
        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Paladium(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "224.508";
        Quizfragen[intLfdNr_Gesamt][4] = "Pd(CH3COO)2";  // Elemente 4 – 224.5 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Platin(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "313.178";
        Quizfragen[intLfdNr_Gesamt][4] = "Pt(CH3COO)2";  // Elemente 4 – 313.172 g/mol

        // Q

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Quecksilber(II)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "318.678";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg(CH3COO)2";  // Elemente 4 – 318.7 g/mol

        // R

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Rubidiumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "144.514";
        Quizfragen[intLfdNr_Gesamt][4] = "RbCH3COO";  // Elemente 4 – 144.51 g/mol

        // S

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Silberacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "166.914";
        Quizfragen[intLfdNr_Gesamt][4] = "AgCH3COO";  // Elemente 4 – 166.91 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Strontiumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "205.708";
        Quizfragen[intLfdNr_Gesamt][4] = "Sr(CH3COO)2";  // Elemente 4 – 205,708 g/mol

        // Z

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "183.458";
        Quizfragen[intLfdNr_Gesamt][4] = "Zn(CH3COO)2";  // Elemente 4 – 183.48 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-acetat";
        Quizfragen[intLfdNr_Gesamt][3] = "327.396";
        Quizfragen[intLfdNr_Gesamt][4] = "Zr(CH3COO)4";  // Elemente 4 – 327.4 g/mol

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zirkonium(IV)-hydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "283.176";
        Quizfragen[intLfdNr_Gesamt][4] = "Zr(HPO4)2";  // Elemente 4

        //endregion

        //region Fragen für Level 6
        /*************************************************************
         ************* Einfache organische Verbindungen **************
         ************************************************************/
        /*

        intLevel = 6;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Methan";
        Quizfragen[intLfdNr_Gesamt][3] = "16.043";
        Quizfragen[intLfdNr_Gesamt][4] = "CH4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "";
        Quizfragen[intLfdNr_Gesamt][3] = "";
        Quizfragen[intLfdNr_Gesamt][4] = "";

        */

        //region Fragen für Level 6
        /*************************************************************
         ********** Trivialnamen und englisch Bezeichnungen **********
         ************************************************************/
        intLevel = 6;
        intLfdNr_Level = 0;

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antichlor";
        Quizfragen[intLfdNr_Gesamt][3] = "158.105";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ätzkali";
        Quizfragen[intLfdNr_Gesamt][3] = "56.109";
        Quizfragen[intLfdNr_Gesamt][4] = "KOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ätzkalk";
        Quizfragen[intLfdNr_Gesamt][3] = "56.079";
        Quizfragen[intLfdNr_Gesamt][4] = "CaO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ätznatron";
        Quizfragen[intLfdNr_Gesamt][3] = "39.997";
        Quizfragen[intLfdNr_Gesamt][4] = "KOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Barytsalpeter";
        Quizfragen[intLfdNr_Gesamt][3] = "261.348";
        Quizfragen[intLfdNr_Gesamt][4] = "NaOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bittersalz";
        Quizfragen[intLfdNr_Gesamt][3] = "120.372";
        Quizfragen[intLfdNr_Gesamt][4] = "MgSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bleiglätte";
        Quizfragen[intLfdNr_Gesamt][3] = "223.189";
        Quizfragen[intLfdNr_Gesamt][4] = "PbO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "rotes Blutlaugensalz";
        Quizfragen[intLfdNr_Gesamt][3] = "329.261";
        Quizfragen[intLfdNr_Gesamt][4] = "K3Fe(CN)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "gelbes Blutlaugensalz";
        Quizfragen[intLfdNr_Gesamt][3] = "368.363";
        Quizfragen[intLfdNr_Gesamt][4] = "K4Fe(CN)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Branntkalk";
        Quizfragen[intLfdNr_Gesamt][3] = "56.079";
        Quizfragen[intLfdNr_Gesamt][4] = "CaO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natron oder Bullrichsalz";
        Quizfragen[intLfdNr_Gesamt][3] = "84.006";
        Quizfragen[intLfdNr_Gesamt][4] = "NaHCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Carbid";
        Quizfragen[intLfdNr_Gesamt][3] = "64.102";
        Quizfragen[intLfdNr_Gesamt][4] = "CaC2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Carborund";
        Quizfragen[intLfdNr_Gesamt][3] = "40.097";
        Quizfragen[intLfdNr_Gesamt][4] = "SiC";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chilesalpeter";
        Quizfragen[intLfdNr_Gesamt][3] = "84.994";
        Quizfragen[intLfdNr_Gesamt][4] = "NaNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisenhammerschlag";
        Quizfragen[intLfdNr_Gesamt][3] = "231.537";
        Quizfragen[intLfdNr_Gesamt][4] = "Fe3O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Fixiersalz";
        Quizfragen[intLfdNr_Gesamt][3] = "158.105";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalkmilch (l) oder Löschkalk (s)";
        Quizfragen[intLfdNr_Gesamt][3] = "74.094";
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gips (ohne Kristallwasser)";
        Quizfragen[intLfdNr_Gesamt][3] = "136.14";
        Quizfragen[intLfdNr_Gesamt][4] = "CaSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Glaubersalz (ohne Kristallwasser)";
        Quizfragen[intLfdNr_Gesamt][3] = "142.04";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2SO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Hirschhornsalz";
        Quizfragen[intLfdNr_Gesamt][3] = "79.055";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4HCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Höllenstein";
        Quizfragen[intLfdNr_Gesamt][3] = "169.874";
        Quizfragen[intLfdNr_Gesamt][4] = "AgNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Jodsilber";
        Quizfragen[intLfdNr_Gesamt][3] = "234.77";
        Quizfragen[intLfdNr_Gesamt][4] = "AgI";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalisalpeter";
        Quizfragen[intLfdNr_Gesamt][3] = "101.106";
        Quizfragen[intLfdNr_Gesamt][4] = "KNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalk";
        Quizfragen[intLfdNr_Gesamt][3] = "100.088";
        Quizfragen[intLfdNr_Gesamt][4] = "CaCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalkstickstoff";
        Quizfragen[intLfdNr_Gesamt][3] = "80.105";
        Quizfragen[intLfdNr_Gesamt][4] = "CaCN2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Karbid";
        Quizfragen[intLfdNr_Gesamt][3] = "64.102";
        Quizfragen[intLfdNr_Gesamt][4] = "CaC2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kalomel";
        Quizfragen[intLfdNr_Gesamt][3] = "472.086";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg2Cl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kochsalz";
        Quizfragen[intLfdNr_Gesamt][3] = "58.443";
        Quizfragen[intLfdNr_Gesamt][4] = "NaCl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Knallsilber";
        Quizfragen[intLfdNr_Gesamt][3] = "149.887";
        Quizfragen[intLfdNr_Gesamt][4] = "AgCNO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Knallquecksilber";
        Quizfragen[intLfdNr_Gesamt][3] = "284.624";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg(CNO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Kupfervitiol";
        Quizfragen[intLfdNr_Gesamt][3] = "159.6";
        Quizfragen[intLfdNr_Gesamt][4] = "CuSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Marshallsche Säure";
        Quizfragen[intLfdNr_Gesamt][3] = "194.136";
        Quizfragen[intLfdNr_Gesamt][4] = "H2S2O8";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mauersalpeter";
        Quizfragen[intLfdNr_Gesamt][3] = "102.084";
        Quizfragen[intLfdNr_Gesamt][4] = "Ca(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Mennige";
        Quizfragen[intLfdNr_Gesamt][3] = "685.566";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb3O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Monosilan";
        Quizfragen[intLfdNr_Gesamt][3] = "32.118";
        Quizfragen[intLfdNr_Gesamt][4] = "SiH4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Pottasche";
        Quizfragen[intLfdNr_Gesamt][3] = "138.212";
        Quizfragen[intLfdNr_Gesamt][4] = "K2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefeleisen";
        Quizfragen[intLfdNr_Gesamt][3] = "87.911";
        Quizfragen[intLfdNr_Gesamt][4] = "FeS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Schwefelsilber";
        Quizfragen[intLfdNr_Gesamt][3] = "247.804";
        Quizfragen[intLfdNr_Gesamt][4] = "Ag2S";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Sulfamid";
        Quizfragen[intLfdNr_Gesamt][3] = "96.108";
        Quizfragen[intLfdNr_Gesamt][4] = "(NH2)2SO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stanniol";
        Quizfragen[intLfdNr_Gesamt][3] = "118.69";
        Quizfragen[intLfdNr_Gesamt][4] = "Sn";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Stannan";
        Quizfragen[intLfdNr_Gesamt][3] = "122.722";
        Quizfragen[intLfdNr_Gesamt][4] = "SnH4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Trockeneis";
        Quizfragen[intLfdNr_Gesamt][3] = "44.009";
        Quizfragen[intLfdNr_Gesamt][4] = "CO2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Theaterblut";
        Quizfragen[intLfdNr_Gesamt][3] = "230.093";
        Quizfragen[intLfdNr_Gesamt][4] = "Fe(SCN)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Waschsoda";
        Quizfragen[intLfdNr_Gesamt][3] = "105.988";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinkvitriol";
        Quizfragen[intLfdNr_Gesamt][3] = "161.43";
        Quizfragen[intLfdNr_Gesamt][4] = "ZnSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zyankali";
        Quizfragen[intLfdNr_Gesamt][3] = "65.12";
        Quizfragen[intLfdNr_Gesamt][4] = "KCN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Zinnober";
        Quizfragen[intLfdNr_Gesamt][3] = "232.654";
        Quizfragen[intLfdNr_Gesamt][4] = "HgS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Barytwasser";
        Quizfragen[intLfdNr_Gesamt][3] = "171.354";
        Quizfragen[intLfdNr_Gesamt][4] = "Ba(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Borwasser";
        Quizfragen[intLfdNr_Gesamt][3] = "61.832";
        Quizfragen[intLfdNr_Gesamt][4] = "H3BO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Carosche Säure";
        Quizfragen[intLfdNr_Gesamt][3] = "114.075";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Magnesiamilch";
        Quizfragen[intLfdNr_Gesamt][3] = "58.326";
        Quizfragen[intLfdNr_Gesamt][4] = "Mg(OH)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Oleum oder Vitriolöl";
        Quizfragen[intLfdNr_Gesamt][3] = "98.076";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Salmiakgeist";
        Quizfragen[intLfdNr_Gesamt][3] = "17.031";
        Quizfragen[intLfdNr_Gesamt][4] = "NH3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Scheidewasser";
        Quizfragen[intLfdNr_Gesamt][3] = "63.012";
        Quizfragen[intLfdNr_Gesamt][4] = "HNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Blausäure";
        Quizfragen[intLfdNr_Gesamt][3] = "27.026";
        Quizfragen[intLfdNr_Gesamt][4] = "HCN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Knallsäure";
        Quizfragen[intLfdNr_Gesamt][3] = "43.025";
        Quizfragen[intLfdNr_Gesamt][4] = "HCNO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lachgas";
        Quizfragen[intLfdNr_Gesamt][3] = "44.013";
        Quizfragen[intLfdNr_Gesamt][4] = "N2O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ozon";
        Quizfragen[intLfdNr_Gesamt][3] = "47.997";
        Quizfragen[intLfdNr_Gesamt][4] = "O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Sulfan";
        Quizfragen[intLfdNr_Gesamt][3] = "34.08";
        Quizfragen[intLfdNr_Gesamt][4] = "H2S";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Chloroform";
        Quizfragen[intLfdNr_Gesamt][3] = "119.378";
        Quizfragen[intLfdNr_Gesamt][4] = "CHCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Etylen";
        Quizfragen[intLfdNr_Gesamt][3] = "28.054";
        Quizfragen[intLfdNr_Gesamt][4] = "C2H4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Acetylen";
        Quizfragen[intLfdNr_Gesamt][3] = "26.038";
        Quizfragen[intLfdNr_Gesamt][4] = "C2H2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Spiritus oder Weingeist";
        Quizfragen[intLfdNr_Gesamt][3] = "46.069";
        Quizfragen[intLfdNr_Gesamt][4] = "C2H5OH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Formaldehyd";
        Quizfragen[intLfdNr_Gesamt][3] = "30.026";
        Quizfragen[intLfdNr_Gesamt][4] = "CH2O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ameisensäure";
        Quizfragen[intLfdNr_Gesamt][3] = "46.025";
        Quizfragen[intLfdNr_Gesamt][4] = "HCOOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Traubenzucker oder Dextrose";
        Quizfragen[intLfdNr_Gesamt][3] = "180.156";
        Quizfragen[intLfdNr_Gesamt][4] = "C6H12O6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Phosgen";
        Quizfragen[intLfdNr_Gesamt][3] = "98.916";
        Quizfragen[intLfdNr_Gesamt][4] = "Cl2CO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bleizucker";
        Quizfragen[intLfdNr_Gesamt][3] = "325.278";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Grünspan";
        Quizfragen[intLfdNr_Gesamt][3] = "181.628";
        Quizfragen[intLfdNr_Gesamt][4] = "Cu(CH3COO)2";

        // englische Begriffe

        // Salze

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "pottasium bicarbonate";
        Quizfragen[intLfdNr_Gesamt][3] = "100.118";
        Quizfragen[intLfdNr_Gesamt][4] = "KHCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "pottasium ferricyanide";
        Quizfragen[intLfdNr_Gesamt][3] = "329.261";
        Quizfragen[intLfdNr_Gesamt][4] = "K3Fe(CN)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "pottasium ferrocyanide";
        Quizfragen[intLfdNr_Gesamt][3] = "368.363";
        Quizfragen[intLfdNr_Gesamt][4] = "K4Fe(CN)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "pottasium pyroantimonate";
        Quizfragen[intLfdNr_Gesamt][3] = "262.894";
        Quizfragen[intLfdNr_Gesamt][4] = "KSb(OH)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "stannous chloride";
        Quizfragen[intLfdNr_Gesamt][3] = "189.596";
        Quizfragen[intLfdNr_Gesamt][4] = "SnCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "cupric sulfate";
        Quizfragen[intLfdNr_Gesamt][3] = "159.6";
        Quizfragen[intLfdNr_Gesamt][4] = "CuSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "cobaltous chloride";
        Quizfragen[intLfdNr_Gesamt][3] = "129.839";
        Quizfragen[intLfdNr_Gesamt][4] = "CoCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "dibasic sodium phosphate";
        Quizfragen[intLfdNr_Gesamt][3] = "141.958";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2HPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "ferric ammonium sulfate";
        Quizfragen[intLfdNr_Gesamt][3] = "266.006";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4Fe(SO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "ferrous sulfate";
        Quizfragen[intLfdNr_Gesamt][3] = "151.907";
        Quizfragen[intLfdNr_Gesamt][4] = "FeSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "lead nitrate";
        Quizfragen[intLfdNr_Gesamt][3] = "331.198";
        Quizfragen[intLfdNr_Gesamt][4] = "Pb(NO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "mercuric acetate";
        Quizfragen[intLfdNr_Gesamt][3] = "318.678";
        Quizfragen[intLfdNr_Gesamt][4] = "Hg(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "mercurous nitrate";
        Quizfragen[intLfdNr_Gesamt][3] = "262.594";
        Quizfragen[intLfdNr_Gesamt][4] = "HgNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "silver ammonia nitrate";
        Quizfragen[intLfdNr_Gesamt][3] = "187.913";
        Quizfragen[intLfdNr_Gesamt][4] = "NH4AgNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sodium acetate";
        Quizfragen[intLfdNr_Gesamt][3] = "82.034";
        Quizfragen[intLfdNr_Gesamt][4] = "NaCH3COO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sodium bisulfite";
        Quizfragen[intLfdNr_Gesamt][3] = "104.059";
        Quizfragen[intLfdNr_Gesamt][4] = "NaHSO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sodium cobaltinitrite";
        Quizfragen[intLfdNr_Gesamt][3] = "403.933";
        Quizfragen[intLfdNr_Gesamt][4] = "Na3Co(NO2)6";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sodium hydrosulfite";
        Quizfragen[intLfdNr_Gesamt][3] = "174.104";
        Quizfragen[intLfdNr_Gesamt][4] = "Na2S2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sodium hypobromite";
        Quizfragen[intLfdNr_Gesamt][3] = "118.898";
        Quizfragen[intLfdNr_Gesamt][4] = "NaBrO";

        // Säuren

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "nitric acid";
        Quizfragen[intLfdNr_Gesamt][3] = "63.012";
        Quizfragen[intLfdNr_Gesamt][4] = "HNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sulfuric acid";
        Quizfragen[intLfdNr_Gesamt][3] = "98.076";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "sulfurous acid";
        Quizfragen[intLfdNr_Gesamt][3] = "82.077";
        Quizfragen[intLfdNr_Gesamt][4] = "H2SO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "hydrochloric acid";
        Quizfragen[intLfdNr_Gesamt][3] = "36.461";
        Quizfragen[intLfdNr_Gesamt][4] = "HCl";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "formic acid";
        Quizfragen[intLfdNr_Gesamt][3] = "36.461";
        Quizfragen[intLfdNr_Gesamt][4] = "CH2O2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "carbonic acid";
        Quizfragen[intLfdNr_Gesamt][3] = "62.024";
        Quizfragen[intLfdNr_Gesamt][4] = "H2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "acetic acid";
        Quizfragen[intLfdNr_Gesamt][3] = "60.052";
        Quizfragen[intLfdNr_Gesamt][4] = "CH3COOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "perchloric acid";
        Quizfragen[intLfdNr_Gesamt][3] = "100.457";
        Quizfragen[intLfdNr_Gesamt][4] = "HClO4";

        // Laugen

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "ammonia";
        Quizfragen[intLfdNr_Gesamt][3] = "17.031";
        Quizfragen[intLfdNr_Gesamt][4] = "NH3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "hydrogen peroxide";
        Quizfragen[intLfdNr_Gesamt][3] = "34.014";
        Quizfragen[intLfdNr_Gesamt][4] = "H2O2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "hydrogen sulfide";
        Quizfragen[intLfdNr_Gesamt][3] = "34.08";
        Quizfragen[intLfdNr_Gesamt][4] = "H2S";

        // organische Verbindungen

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "methylene chloride";
        Quizfragen[intLfdNr_Gesamt][3] = "84.933";
        Quizfragen[intLfdNr_Gesamt][4] = "CH2Cl2";
        //endregion

    	intLfdNr_max = intLfdNr_Gesamt;
	} // erstelle_Quizfragen

    public static String suche_Nomenklaturnamen (String strMolmasse) {

        String strNomenklaturnamen = "";

        if (intLfdNr_max == 0) {
            erstelle_Quizfragen();
        }

        for (int intFrageNr=1; intFrageNr <=intLfdNr_max; intFrageNr++) {
            if (   (strMolmasse.equals(Quizfragen[intFrageNr][3])))
            {
                strNomenklaturnamen = Quizfragen[intFrageNr][2];

                break; // for-Schleife vorzeitig beenden
            }
        } // for...

        return strNomenklaturnamen;
    } // suche_Nomenklaturnamen

	public static void lese_Quizfrage (int pLevel, int pLfdNr) {
		mFrage       = "";
		mAntwort     = "";
		mAntwortText = "";
		for (int intFrageNr=1; intFrageNr<=intLfdNr_max; intFrageNr++) {
			if (   (Quizfragen[intFrageNr][0].equals(Integer.toString(pLevel)))
				&& (Quizfragen[intFrageNr][1].equals(Integer.toString(pLfdNr))))
			{
				mFrage       = Quizfragen[intFrageNr][2];
				mAntwort     = Quizfragen[intFrageNr][3];
				mAntwortText = Quizfragen[intFrageNr][4];
                break; // for-Schleife vorzeitig beenden
			}
		} // for...
	} // lese_Quizfrage


	public static int ermittel_LfdNr (int pLevel) {
		int intZufallszahl = 0;
		int intMax = 0; // Anzahl der Fragen im jeweiligen Level
		boolean bZufallszahl_bekannt;

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

			if (LetzteQuizfragen[9] != 0)
			{
				// Array für letzte Quiz-Fragen "ist voll"
				// Erstes Element wird "vergessen", alle weiteren rutschen eins höher
				for (int intFrageNr=0; intFrageNr<(10 - 1); intFrageNr++) {
					LetzteQuizfragen[intFrageNr] = LetzteQuizfragen[intFrageNr + 1];
				}
				LetzteQuizfragen[9] = 0;
			}

			do {
				bZufallszahl_bekannt = false;
				intZufallszahl = (int) (Math.random() * intMax) + 1;

				for (int intFrageNr=0; intFrageNr<10; intFrageNr++) {
					if (LetzteQuizfragen[intFrageNr] == 0)
					{
						LetzteQuizfragen[intFrageNr] = intZufallszahl;
						break; // for-Schleife vorzeitig beenden
					}
					else if (LetzteQuizfragen[intFrageNr] == intZufallszahl)
					{
						// die ermittelte Zufallszahl hatten wir schon
						bZufallszahl_bekannt = true;
						break; // for-Schleife vorzeitig beenden
					}
				} // for...

			} while (bZufallszahl_bekannt == true); // Schleife läuft solange die Bedingung erfüllt ist!
		}

		return intZufallszahl;
	} // ermittel_LfdNr

	} // QuizFragen
