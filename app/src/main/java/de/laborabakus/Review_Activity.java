package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Arrays.sort(ReviewArray, new ArrayComparator(columnToSort, indexMax, true));
class ArrayComparator implements Comparator<Comparable[]> {
    private final int columnToSort;
    private final int indexMax;
    private int index;
    private final boolean ascending;

    public ArrayComparator(int columnToSort, int indexMax, boolean ascending) {
        this.columnToSort = columnToSort;
        this.indexMax = indexMax;
        this.ascending = ascending;

        this.index = 0;
    }

    public int compare(@NotNull Comparable[] c1, Comparable[] c2) {
        int cmp;

        if ((c1[columnToSort].equals("")))
            cmp = 1;
        else
            cmp = c1[columnToSort].compareTo(c2[columnToSort]);
        // führt zu: "unchecked call to compareTo(T) as a member of the raw type java.lang.Comparable”"
        //mögliche Abhilfe: https://stackoverflow.com/questions/4907683/sort-a-two-dimensional-array-based-on-one-column
        //                  https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator
        //                  https://stackoverflow.com/questions/4830400/java-unchecked-call-to-comparetot-as-a-member-of-the-raw-type-java-lang-compa
        //                  https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
        // ???

        return ascending ? cmp : -cmp;
    }
} // ArrayComparator

public class Review_Activity extends Activity /*implements OnFocusChangeListener */ {
    private static String[][] ReviewArray = new String[100][3];

    int n = 0;      // Anzahl der Messwerte
    double[] arr_x = new double[99];
    double X;   // arithmetischer Mittelwert
    double d;   // absolute Abweichung der Einzelwerte vom Mittelwert
    double s;   // Standardabweichung
    double RSD; // relative Standardabweichung in Prozent
    double dblErgebnis;
    boolean mainisopen = true;

    EditText et;
    TextView tv;
    String Eingabetext;
    String strAusgabetext;
    double Speicher;

	/** wird ausgeführt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.review_liste);

    	// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

        for (int zeile=0; zeile<100; zeile++)
        {
            for (int spalte=0; spalte<3; spalte++)
                ReviewArray[zeile][spalte] = "";
        }

        ReviewArray[0][0] = "Waage 0";
        ReviewArray[0][1] = "01.01.2019";
        ReviewArray[0][2] = "ja";

        ReviewArray[1][0] = "Waage 1";
        ReviewArray[1][1] = "01.01.2019";
        ReviewArray[1][2] = "ja";

        ReviewArray[2][0] = "KOH";
        ReviewArray[2][1] = "(11335)";
        ReviewArray[2][2] = "nein";

        ReviewArray[3][0] = "Salzsäure";
        ReviewArray[3][1] = "03.01.2019";
        ReviewArray[3][2] = "banane";

        ReviewArray[4][0] = "Titrant";
        ReviewArray[4][1] = "(54321)";
        ReviewArray[4][2] = "check";

        ReviewArray[5][0] = "Aceton";
        ReviewArray[5][1] = "(56765)";
        ReviewArray[5][2] = "check";

        ReviewArray[6][0] = "Na-sulfat";
        ReviewArray[6][1] = "(65453)";
        ReviewArray[6][2] = "check";

        ReviewArray[7][0] = "Ether";
        ReviewArray[7][1] = "(87678)";
        ReviewArray[7][2] = "check";

        ReviewArray[8][0] = "2-Propanol";
        ReviewArray[8][1] = "(23423)";
        ReviewArray[8][2] = "check";

        ReviewArray[9][0] = "Methanol";
        ReviewArray[9][1] = "(83423)";
        ReviewArray[9][2] = "check";

        ReviewArray[10][0] = "Ammoniak";
        ReviewArray[10][1] = "(7554)";
        ReviewArray[10][2] = "check";

        ReviewArray[11][0] = "DMF";
        ReviewArray[11][1] = "(35567)";
        ReviewArray[11][2] = "check";

        ReviewArray[12][0] = "TBAH";
        ReviewArray[12][1] = "(376545)";
        ReviewArray[12][2] = "check";

        ReviewArray[13][0] = "Perchlors.";
        ReviewArray[13][1] = "(66443)";
        ReviewArray[13][2] = "check";

        ReviewArray[14][0] = "Schwefels.";
        ReviewArray[14][1] = "(7765)";
        ReviewArray[14][2] = "check";

        ReviewArray[15][0] = "Salpeters.";
        ReviewArray[15][1] = "(5353)";
        ReviewArray[15][2] = "check";

        ReviewArray[16][0] = "Flusssäure";
        ReviewArray[16][1] = "(57885)";
        ReviewArray[16][2] = "check";

        ReviewArray[17][0] = "Borsäure";
        ReviewArray[17][1] = "(44567)";
        ReviewArray[17][2] = "check";

        ReviewArray[18][0] = "Kohlensäure";
        ReviewArray[18][1] = "(23534)";
        ReviewArray[18][2] = "check";

        ReviewArray[19][0] = "Essigsäure";
        ReviewArray[19][1] = "(84656)";
        ReviewArray[19][2] = "check";

        ReviewArray[20][0] = "Kalilauge";
        ReviewArray[20][1] = "(45334)";
        ReviewArray[20][2] = "check";

        ReviewArray[21][0] = "Natronlauge";
        ReviewArray[21][1] = "(76567)";
        ReviewArray[21][2] = "check";

        ReviewArray[22][0] = "Benzoes.";
        ReviewArray[22][1] = "(34345)";
        ReviewArray[22][2] = "check";

    } // onCreate

	/** wird ausgeführt, wenn Activicty angezeigt wird */
    @Override
    protected void onResume() {
        super.onResume();

        btnListe();
    } // onResume

    @Override
    protected void onPause() {
        super.onPause();

    } // onPause

    // ******************************************************************************************
    // ******************* Button Liste *********************************************************
    // ******************************************************************************************
    public void btnListe()
    {
        List<String> Review_Liste = new ArrayList<String>();

        try {
            setContentView(R.layout.review_liste);

            int columnToSort = 0;
            int indexMax = 0;

            while ((indexMax < ReviewArray.length) && (ReviewArray[indexMax][columnToSort] != null)) {
                indexMax++;
            }
            // bei 5 Elementen muss indexMaxx = 8 sein, damit richtig sortiert wird - warum???
            indexMax = 23;
            Arrays.sort(ReviewArray, new ArrayComparator(columnToSort, indexMax, true));

            for (int t=0; t<indexMax; t++)
            {
                Review_Liste.add(ReviewArray[t][0]);
                Review_Liste.add(ReviewArray[t][1]);
                Review_Liste.add(ReviewArray[t][2]);
            };

            //Review_Liste.sort();
            //Collections.sort(Review_Liste[][]);

            GridView gridView = (GridView)findViewById(R.id.gridview_review);
            Review_ListeAdapter review_listeAdapter = new Review_ListeAdapter(this, Review_Liste);
            gridView.setAdapter(review_listeAdapter);

        } // try ...
        catch (Exception e)
        {
            Log.i("Review_Activity", "btnListe: " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    } // btnListe

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && mainisopen == false) {
            mainisopen = true;
            setContentView(R.layout.eingabe_rsd);

            // *********** Ausgabe Anzahl Me�werte *************
            strAusgabetext = Integer.toString(n);; // 0 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvAnzahl_Messwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Mittelwert *************
            Speicher = X; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tv_Mittelwert);
            tv.setText(strAusgabetext);

            // *********** Ausgabe Standardabweichung *************
            Speicher = s; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, 4); // 4 Nachkommastellen
            tv = (TextView) findViewById(R.id.tvStandardabweichung);
            tv.setText(strAusgabetext);

            //***********************************************************************
            //********* Auslesen der Nachkommastellen *******************************
            //***********************************************************************
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            int AnzahlStellen = prefs.getInt("NachkommastellenRSD", 2);

            // *********** Ausgabe relative Standardabweichung % *************
            Speicher = RSD; // nur die Ausgabe soll gerundet werden
            strAusgabetext = ActivityTools.fktDoubleToStringFormat(Speicher, AnzahlStellen);
            tv = (TextView) findViewById(R.id.tvRSD);
            tv.setText(strAusgabetext);

            // Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten
            et = (EditText) findViewById(R.id.Eingabewert);
            et.requestFocus();
            showSoftKeyboard(findViewById(R.id.Eingabewert));

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

	/********************************************
	 ************** Menue Button ****************
	 ********************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }   
    
    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
    	Intent intent = null;
        switch (item.getItemId()) 
        {
        	case R.id.menu_Einstellungen:
            	intent = new Intent(this, Einstellungen_Nachkomma_Activity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "RSD");
            	startActivity(intent);
                return true;
                
            case R.id.menu_Menue:
            	ActivityRegistry.finishAll();
            	intent = new Intent(this, HauptmenueActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
                
            case R.id.menu_Aus:	
                ActivityRegistry.finishAll();
                finish(); 
                System.exit(0);
                
            default:
                return super.onOptionsItemSelected(item);
        }
	} // onOptionsItemSelected

    /**
     * Hides the soft keyboard
     */
    private void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    private void showSoftKeyboard(@org.jetbrains.annotations.NotNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }
} // class Review_Activity

