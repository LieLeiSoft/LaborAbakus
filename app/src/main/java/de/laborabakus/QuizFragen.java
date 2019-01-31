package de.laborabakus;

public class QuizFragen {
	private static String[][] Quizfragen = new String[700][5];
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
        Quizfragen[intLfdNr_Gesamt][3] = "266.70898";
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
        Quizfragen[intLfdNr_Gesamt][3] = "133.34099";
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
        Quizfragen[intLfdNr_Gesamt][3] = "178.74399";
       Quizfragen[intLfdNr_Gesamt][4] = "SbF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(V)-fluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "216.73999";
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
        Quizfragen[intLfdNr_Gesamt][3] = "339.69202";
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
        Quizfragen[intLfdNr_Gesamt][3] = "229.83899";
       Quizfragen[intLfdNr_Gesamt][4] = "As2O5";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "181.28099";
       Quizfragen[intLfdNr_Gesamt][4] = "AsCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Arsen(III)-oxid";
        Quizfragen[intLfdNr_Gesamt][3] = "197.84099";
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
        Quizfragen[intLfdNr_Gesamt][3] = "153.33899";
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
        Quizfragen[intLfdNr_Gesamt][3] = "169.40399";
       Quizfragen[intLfdNr_Gesamt][4] = "BaS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Berylliumbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "168.82999";
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
        Quizfragen[intLfdNr_Gesamt][3] = "47.007996";
       Quizfragen[intLfdNr_Gesamt][4] = "BeF2";

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
        Quizfragen[intLfdNr_Gesamt][2] = "Bortrichlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "117.17";
       Quizfragen[intLfdNr_Gesamt][4] = "BCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bortrifluorid";
        Quizfragen[intLfdNr_Gesamt][3] = "67.80499";
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
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumbromid"; //CaBr2
        Quizfragen[intLfdNr_Gesamt][3] = "199.898"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "CaBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumchlorid"; // CaCl2
        Quizfragen[intLfdNr_Gesamt][3] = "110.98601"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "CaCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumcarbid"; // CaC2
        Quizfragen[intLfdNr_Gesamt][3] = "64.102005"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "CaC2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumfluorid"; // CaF2
        Quizfragen[intLfdNr_Gesamt][3] = "78.076004"; // 2
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
        Quizfragen[intLfdNr_Gesamt][3] = "56.079002"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "CaO";

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
        Quizfragen[intLfdNr_Gesamt][3] = "83.993996"; // 2
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
        Quizfragen[intLfdNr_Gesamt][2] = "Chlortrifluorid"; // ClF3
        Quizfragen[intLfdNr_Gesamt][3] = "92.44699"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "ClF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-bromid"; // CoBr2
        Quizfragen[intLfdNr_Gesamt][3] = "218.75099"; // 2
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
        Quizfragen[intLfdNr_Gesamt][3] = "165.86299"; // 2
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
        Quizfragen[intLfdNr_Gesamt][3] = "90.996994"; // 2
       Quizfragen[intLfdNr_Gesamt][4] = "CoS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-bromid"; // FeBr2
        Quizfragen[intLfdNr_Gesamt][3] = "215.665";  // 2   215,65
       Quizfragen[intLfdNr_Gesamt][4] = "FeBr2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-bromid"; // FeBr3
        Quizfragen[intLfdNr_Gesamt][3] = "295.57397";  // 2   295,56
       Quizfragen[intLfdNr_Gesamt][4] = "FeBr3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-chlorid"; //  FeCl2
        Quizfragen[intLfdNr_Gesamt][3] = "126.753006";  // 2   126,75
       Quizfragen[intLfdNr_Gesamt][4] = "FeCl2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-chlorid"; // FeCl3
        Quizfragen[intLfdNr_Gesamt][3] = "162.206";  // 2   162,2
       Quizfragen[intLfdNr_Gesamt][4] = "FeCl3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-fluorid"; // FeF2
        Quizfragen[intLfdNr_Gesamt][3] = "93.843";  // 2   98,84
       Quizfragen[intLfdNr_Gesamt][4] = "FeF2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-fluorid"; // FeF3
        Quizfragen[intLfdNr_Gesamt][3] = "112.840996";  // 2   112,84
       Quizfragen[intLfdNr_Gesamt][4] = "FeF3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-iodid"; // FeI2
        Quizfragen[intLfdNr_Gesamt][3] = "309.647";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "FeI2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-iodid"; // FeI3
        Quizfragen[intLfdNr_Gesamt][3] = "436.54703";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "FeI3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(I)-oxid"; // Fe2O
        Quizfragen[intLfdNr_Gesamt][3] = "127.693";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "Fe2O";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-oxid"; // FeO
        Quizfragen[intLfdNr_Gesamt][3] = "71.846";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "FeO";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-oxid"; // Fe2O3
        Quizfragen[intLfdNr_Gesamt][3] = "159.691";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "Fe2O3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-sulfid"; // FeS
        Quizfragen[intLfdNr_Gesamt][3] = "87.910995";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "FeS";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-disulfid"; // FeS2
        Quizfragen[intLfdNr_Gesamt][3] = "119.97499";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "FeS2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-sulfid"; // Fe2S3
        Quizfragen[intLfdNr_Gesamt][3] = "207.886";  // 2
       Quizfragen[intLfdNr_Gesamt][4] = "Fe2S3";

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
        Quizfragen[intLfdNr_Gesamt][3] = "83.727005";
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
        Quizfragen[intLfdNr_Gesamt][3] = "76.621994";
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
        Quizfragen[intLfdNr_Gesamt][3] = "104.65399";
       Quizfragen[intLfdNr_Gesamt][4] = "GeS";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Germanium(IV)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "136.71799";
       Quizfragen[intLfdNr_Gesamt][4] = "GeS2";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Gold(III)-chlorid";
        Quizfragen[intLfdNr_Gesamt][3] = "303.32898";
       Quizfragen[intLfdNr_Gesamt][4] = "AuCl3";  // 2

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
        Quizfragen[intLfdNr_Gesamt][3] = "221.17899";
       Quizfragen[intLfdNr_Gesamt][4] = "InCl3";  // 2

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
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-phosphid";
        Quizfragen[intLfdNr_Gesamt][3] = "145.794";
       Quizfragen[intLfdNr_Gesamt][4] = "InP";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-sulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "325.83203";
       Quizfragen[intLfdNr_Gesamt][4] = "In2S3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Iodbromid";
        Quizfragen[intLfdNr_Gesamt][3] = "206.80899";
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
        Quizfragen[intLfdNr_Gesamt][3] = "240.19699";
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
        Quizfragen[intLfdNr_Gesamt][2] = "Kaliumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "110.268005";
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
        Quizfragen[intLfdNr_Gesamt][3] = "28.009998";
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
        Quizfragen[intLfdNr_Gesamt][3] = "101.535995";
        Quizfragen[intLfdNr_Gesamt][4] = "CuF2";  // 2

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
        Quizfragen[intLfdNr_Gesamt][3] = "95.604004";
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
        Quizfragen[intLfdNr_Gesamt][3] = "195.90399";
        Quizfragen[intLfdNr_Gesamt][4] = "LaF3";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lanthanoxid";
        Quizfragen[intLfdNr_Gesamt][3] = "325.81702";
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
        Quizfragen[intLfdNr_Gesamt][3] = "29.876999";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2O";  // 2

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumsulfid";
        Quizfragen[intLfdNr_Gesamt][3] = "45.942";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2S";  // 2
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
        Quizfragen[intLfdNr_Gesamt][3] = "233.98799";
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
        Quizfragen[intLfdNr_Gesamt][3] = "212.99399";
       Quizfragen[intLfdNr_Gesamt][4] = "Al(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "121.951996";
       Quizfragen[intLfdNr_Gesamt][4] = "AlPO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "342.14398";
       Quizfragen[intLfdNr_Gesamt][4] = "Al2(SO4)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Aluminiumsulfit";
        Quizfragen[intLfdNr_Gesamt][3] = "342.14398";
       Quizfragen[intLfdNr_Gesamt][4] = "Al2S3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(III)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "172.77098";
       Quizfragen[intLfdNr_Gesamt][4] = "Sb(OH)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Antimon(V)-hydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "206.78499";
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
        Quizfragen[intLfdNr_Gesamt][3] = "53.491997";
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
        Quizfragen[intLfdNr_Gesamt][3] = "393.15198";
       Quizfragen[intLfdNr_Gesamt][4] = "Ba(BrO3)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "197.34799";
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
        Quizfragen[intLfdNr_Gesamt][3] = "171.35397";
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
        Quizfragen[intLfdNr_Gesamt][3] = "601.95996";
       Quizfragen[intLfdNr_Gesamt][4] = "Ba3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumperchlorat";
        Quizfragen[intLfdNr_Gesamt][3] = "336.23798";
       Quizfragen[intLfdNr_Gesamt][4] = "Ba(ClO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumpermanganat";
        Quizfragen[intLfdNr_Gesamt][3] = "375.20798";
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
        Quizfragen[intLfdNr_Gesamt][3] = "217.40099";
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
        Quizfragen[intLfdNr_Gesamt][3] = "241.20398";
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
        Quizfragen[intLfdNr_Gesamt][3] = "811.50995";
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
        Quizfragen[intLfdNr_Gesamt][3] = "142.98401"; // 3
       Quizfragen[intLfdNr_Gesamt][4] = "Ca(ClO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumiodat"; // Ca(IO3)2
        Quizfragen[intLfdNr_Gesamt][3] = "389.87402"; // 3
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
        Quizfragen[intLfdNr_Gesamt][3] = "120.14099"; // 2
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
        Quizfragen[intLfdNr_Gesamt][3] = "236.40799"; // 3
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
        Quizfragen[intLfdNr_Gesamt][3] = "149.91699"; // 3
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
        Quizfragen[intLfdNr_Gesamt][3] = "118.940994"; // 3
       Quizfragen[intLfdNr_Gesamt][4] = "CoCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cobalt(II)-hydroxid"; // Co(OH)2
        Quizfragen[intLfdNr_Gesamt][3] = "92.94701"; // 3
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
        Quizfragen[intLfdNr_Gesamt][3] = "241.859";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "Fe(NO3)3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-oxalat"; // FeC2O4
        Quizfragen[intLfdNr_Gesamt][3] = "143.865";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "FeC2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-phosphat"; // Fe3(PO4)2
        Quizfragen[intLfdNr_Gesamt][3] = "357.481";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "Fe3(PO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-phosphat"; // FePO4
        Quizfragen[intLfdNr_Gesamt][3] = "150.817";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "FePO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(II)-sulfat"; // FeSO4
        Quizfragen[intLfdNr_Gesamt][3] = "151.907";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "FeSO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-sulfat"; // Fe2(SO4)3
        Quizfragen[intLfdNr_Gesamt][3] = "399.874";  // 3
       Quizfragen[intLfdNr_Gesamt][4] = "Fe2(SO4)3";

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
        Quizfragen[intLfdNr_Gesamt][3] = "165.84099";
       Quizfragen[intLfdNr_Gesamt][4] = "In(OH)3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Indium(III)-nitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "300.83197";
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
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumhydroxid";
        Quizfragen[intLfdNr_Gesamt][3] = "23.946";
       Quizfragen[intLfdNr_Gesamt][4] = "LiOH";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumcarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "105.98799";
       Quizfragen[intLfdNr_Gesamt][4] = "Na2CO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumnitrat";
        Quizfragen[intLfdNr_Gesamt][3] = "84.994";
       Quizfragen[intLfdNr_Gesamt][4] = "NaNO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Natriumsulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "142.04";
       Quizfragen[intLfdNr_Gesamt][4] = "Na2SO4";

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
        Quizfragen[intLfdNr_Gesamt][3] = "65.119995";
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
        Quizfragen[intLfdNr_Gesamt][3] = "294.18896";
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
        Quizfragen[intLfdNr_Gesamt][3] = "187.54799";
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
        Quizfragen[intLfdNr_Gesamt][3] = "37.953003";
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
        Quizfragen[intLfdNr_Gesamt][3] = "68.94299";
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
        Quizfragen[intLfdNr_Gesamt][3] = "235.88599";
        Quizfragen[intLfdNr_Gesamt][4] = "LiTaO3";  // 3

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Lithiumtetraborat";
        Quizfragen[intLfdNr_Gesamt][3] = "169.11499";
        Quizfragen[intLfdNr_Gesamt][4] = "Li2B4O7";  // 3
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
        Quizfragen[intLfdNr_Gesamt][3] = "204.11398";
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
        Quizfragen[intLfdNr_Gesamt][3] = "60.055996";
       Quizfragen[intLfdNr_Gesamt][4] = "NH4OCN";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumdichromat";
        Quizfragen[intLfdNr_Gesamt][3] = "252.06299";
       Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2Cr2O7";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumhydrogencarbonat";
        Quizfragen[intLfdNr_Gesamt][3] = "79.05499";
       Quizfragen[intLfdNr_Gesamt][4] = "NH4HCO3";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumdihydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "115.024994";
       Quizfragen[intLfdNr_Gesamt][4] = "NH4H2PO4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Diammoniumhydrogenphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "96.086";
       Quizfragen[intLfdNr_Gesamt][4] = "NH4H2PO4";

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
        Quizfragen[intLfdNr_Gesamt][3] = "115.106995";
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
        Quizfragen[intLfdNr_Gesamt][3] = "284.04498";
       Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2Fe(SO4)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumeisen(III)-sulfat";
        Quizfragen[intLfdNr_Gesamt][3] = "266.00598";
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
        Quizfragen[intLfdNr_Gesamt][3] = "124.09599";
       Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2C2O4";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Ammoniumphosphat";
        Quizfragen[intLfdNr_Gesamt][3] = "149.08699";
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
        Quizfragen[intLfdNr_Gesamt][3] = "117.48799";
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
        Quizfragen[intLfdNr_Gesamt][3] = "116.13899";
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
        Quizfragen[intLfdNr_Gesamt][3] = "148.20299";
       Quizfragen[intLfdNr_Gesamt][4] = "(NH4)2S2O3";
        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Bariumacetat";
        Quizfragen[intLfdNr_Gesamt][3] = "252.428";
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
        Quizfragen[intLfdNr_Gesamt][2] = "Calciumthiosulfat"; // Ca(SCN)2
        Quizfragen[intLfdNr_Gesamt][3] = "156.244"; // 4
       Quizfragen[intLfdNr_Gesamt][4] = "Ca(SCN)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Cadmiumacetat"; // Cd(CH3COO)2
        Quizfragen[intLfdNr_Gesamt][3] = "230.48798"; // 5
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
        Quizfragen[intLfdNr_Gesamt][3] = "173.935";  // 4
       Quizfragen[intLfdNr_Gesamt][4] = "Fe(CH3COO)2";

        intLfdNr_Level++;
        intLfdNr_Gesamt++;
        Quizfragen[intLfdNr_Gesamt][0] = Integer.toString(intLevel);
        Quizfragen[intLfdNr_Gesamt][1] = Integer.toString(intLfdNr_Level);
        Quizfragen[intLfdNr_Gesamt][2] = "Eisen(III)-thiocyanat"; // Fe(SCN)3
        Quizfragen[intLfdNr_Gesamt][3] = "230.09299";  // 4
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
        Quizfragen[intLfdNr_Gesamt][3] = "258.20398";
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
        Quizfragen[intLfdNr_Gesamt][3] = "97.184006";
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
        Quizfragen[intLfdNr_Gesamt][3] = "121.62201";
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

        //endregion

		//region Fragen für Level 6
		/**********************************
		 ********** Trivialnamen **********
		 **********************************/
		intLevel = 6;
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
        //endregion

		intLfdNr_max = intLfdNr_Gesamt;
	} // erstelle_Quizfragen

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
