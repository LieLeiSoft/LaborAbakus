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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public int compare(Comparable[] c1, Comparable[] c2) {
        int cmp;

        if ((c1[columnToSort].equals("")))
            cmp = 1;
        else
            cmp = c1[columnToSort].compareTo(c2[columnToSort]);

        return ascending ? cmp : -cmp;
    }
}

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


	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.review_liste);

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
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

        ReviewArray[2][0] = "Chemikalie";
        ReviewArray[2][1] = "02.01.2019";
        ReviewArray[2][2] = "nein";

        ReviewArray[3][0] = "Reagenz";
        ReviewArray[3][1] = "03.01.2019";
        ReviewArray[3][2] = "banane";

        ReviewArray[4][0] = "Chemikalie 2";
        ReviewArray[4][1] = "04.01.2019";
        ReviewArray[4][2] = "weiss nicht";
    } // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */

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
	// ******************* Button Weiter ********************************************************
	// ******************************************************************************************

    // ******************************************************************************************
    // ******************* Button Liste *********************************************************
    // ******************************************************************************************

    public void btnListe()
    {
        List<String> Review_Liste = new ArrayList<String>();

        try {
            setContentView(R.layout.review_liste);

            //Arrays.sort(ReviewArray, (String[] s1, String[] s2) -> s1[0].compareTo(s2[0])); //LAMBDA erst ab Java 8 möglich

            String[][] data = new String[][] {
                    { "2009.07.25 20:17", "Message G" },
                    { "2009.07.25 20:25", "Message B" },
                    { "2009.07.25 20:30", "Message D" },
                    { "2009.07.25 20:01", "Message F" },
                    { "2009.07.25 21:08", "Message E" },
                    { "2009.07.25 19:54", "Message R" }
            };

            Arrays.sort(data, new Comparator<String[]>() {
                @Override
                public int compare(String[] s1, String[] s2) {
                    String t1 = s1[0];
                    String t2 = s2[0];
                    return t1.compareTo(t2);
                }
            });

/*
            Arrays.sort(ReviewArray, new Comparator<String[]>() {
                @Override
                public int compare(String[] s1, String[] s2) {
                    String t1 = s1[0];
                    String t2 = s2[0];
                    return t1.compareTo(t2);
                }
            });
*/
            int columnToSort = 0;
            int indexMax = 0;

            while ((indexMax < ReviewArray.length) && (ReviewArray[indexMax][columnToSort] != null)) {
                indexMax++;
            }
            // bei 5 Elementen muss indexMaxx = 8 sein, damit richtig sortiert wird - warum???
            indexMax = 8;
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
    public boolean onOptionsItemSelected(MenuItem item) {
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
    private void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }
} // class RSD_Activity

