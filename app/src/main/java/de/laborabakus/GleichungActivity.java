package de.laborabakus;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spannable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GleichungActivity extends Activity {

	public TextView tv;
	public EditText et;
	public int intAnzahlOxi = 0;
	public int intAnzahlElemente;
	public int intOxi;
	public int Ende = 0;
	public int Zaehler = 0;
	public int cMax_Oxi = 12; // maximale Anzahl an Oxidationsstufen (= 9 Stufen + Spalte 0 für Positionsmerker)

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gleichung);       
   
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	   
	    
	    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    SharedPreferences.Editor prefEditor = prefs.edit(); 											// Haupt- und Nebengruppenelemente inklusive ihrer Atommassen 
	    																								// werden in die Konfigurationsdatei eingelesen.
	    // 375  // PONSO (alt)
	    // prefEditor.putString("Oxi_H" ,"1,-1");
	    prefEditor.putString("Oxi_Li","1");
	    prefEditor.putString("Oxi_Be","2");
	    prefEditor.putString("Oxi_B" ,"3");
	    // prefEditor.putString("Oxi_C" ,"-4,-3,-2,-1,0,1,2,3,4");
	    prefEditor.putString("Oxi_N" ,"-3,-2,-1,1,2,3,4,5");
		// prefEditor.putString("Oxi_O" ,"-2,1");  wird im onResume gesetzt, weil der Wert bei einigen Verbindungen umgeschrieben wird.
	    prefEditor.putString("Oxi_F" ,"-1");
	    prefEditor.putString("Oxi_Na","1");
	    prefEditor.putString("Oxi_Mg","2");
	    prefEditor.putString("Oxi_Al","3");
	    prefEditor.putString("Oxi_Si","-4,4");
	    prefEditor.putString("Oxi_P" ,"-3,3,5");
	    prefEditor.putString("Oxi_S" ,"-2,2,4,6");
	    prefEditor.putString("Oxi_Cl","-1,1,3,5,7");
	    prefEditor.putString("Oxi_K" ,"1");
	    prefEditor.putString("Oxi_Ca","2");
	    prefEditor.putString("Oxi_Sc","3");
	    prefEditor.putString("Oxi_Ti","2,3,4");
	    prefEditor.putString("Oxi_V" ,"0,2,3,4,5");
	    prefEditor.putString("Oxi_Cr","0,2,3,4,5,6");
	    prefEditor.putString("Oxi_Mn","-1,0,2,3,4,6,7");
	    prefEditor.putString("Oxi_Fe","-2,0,2,3,4,6");
	    prefEditor.putString("Oxi_Co","-1,0,2,3");
	    prefEditor.putString("Oxi_Ni","0,2,3,4");
	    prefEditor.putString("Oxi_Cu","1,2");
	    prefEditor.putString("Oxi_Zn","2");
	    prefEditor.putString("Oxi_Ga","3");
	    prefEditor.putString("Oxi_Ge","2,4");
	    prefEditor.putString("Oxi_As","-3,3,5");
	    prefEditor.putString("Oxi_Se","-2,4,6");
	    prefEditor.putString("Oxi_Br","-1,1,3,5,7");
	    prefEditor.putString("Oxi_Rb","1");
	    prefEditor.putString("Oxi_Sr","2");
	    prefEditor.putString("Oxi_Y" ,"3");
	    prefEditor.putString("Oxi_Zr","2,3,4");
	    prefEditor.putString("Oxi_Nb","2,3,5");
	    prefEditor.putString("Oxi_Mo","0,2,3,4,5,6");
	    prefEditor.putString("Oxi_Tc","4,7");
	    prefEditor.putString("Oxi_Ru","-2,0,2,3,4,5,6,7,8");
	    prefEditor.putString("Oxi_Rh","0,1,2,3,4,5,6");
	    prefEditor.putString("Oxi_Pd","0,2,4");
	    prefEditor.putString("Oxi_Ag","1,2");
	    prefEditor.putString("Oxi_Cd","2");
	    prefEditor.putString("Oxi_In","1,3");
	    prefEditor.putString("Oxi_Sn","2,4");
	    prefEditor.putString("Oxi_Sb","-3,3,5");
	    prefEditor.putString("Oxi_Te","-2,4,6");
	    prefEditor.putString("Oxi_I" ,"-1,1,3,5,7");
	    prefEditor.putString("Oxi_Cs","1");
	    prefEditor.putString("Oxi_Ba","2");
	    prefEditor.putString("Oxi_La","3");
	    prefEditor.putString("Oxi_Hf","2,4");
	    prefEditor.putString("Oxi_Ta","5");
	    prefEditor.putString("Oxi_W" ,"0,2,3,4,5,6");
	    prefEditor.putString("Oxi_Re","0,2,3,4,6,7");
	    prefEditor.putString("Oxi_Os","-2,0,2,3,4,5,6,7,8");
	    prefEditor.putString("Oxi_Ir","-1,0,1,2,3,4,5,6");
	    prefEditor.putString("Oxi_Pt","0,2,4,5,6");
	    prefEditor.putString("Oxi_Au","1,3");
	    prefEditor.putString("Oxi_Hg","1,2");
	    prefEditor.putString("Oxi_Tl","1,3");
	    prefEditor.putString("Oxi_Pb","2,4");
	    prefEditor.putString("Oxi_Bi","3,5");
	    prefEditor.putString("Oxi_Po","2,4,6");
	    prefEditor.putString("Oxi_At","-1,1,3,5,7");
	    prefEditor.putString("Oxi_Fr","1");
	    prefEditor.putString("Oxi_Ra","2");

	    prefEditor.apply();

	    ListView lv = (ListView) findViewById(R.id.lvOxiListe);
	    // hier wird festgelegt, was passieren soll, wenn der Anwender eine Zeile anklickt:
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
	            // es ist bekannt, dass der angeklickte View eine TextView ist; er wird daher als solcher angesprochen 
	            TextView clickedView = (TextView) view;
             	
    			AlertDialog.Builder builder = new AlertDialog.Builder(GleichungActivity.this);
    			builder.setTitle("Oxidationsstufen");
    			builder.setMessage(clickedView.getText().toString());
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
	         } // onItemClick
	    }); // setOnItemClickListener	    
	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	@Override
	public void onResume() {
		super.onResume();

		SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs2.edit();
		prefEditor.putString("Oxi_O" ,"-2");
        prefEditor.putString("Oxi_C" ,"-4,-3,-2,-1,0,1,2,3,4");
        prefEditor.putString("Oxi_H" ,"1");
        prefEditor.apply();

	
		TextView tv;
		String strFormel;
		String strElement = "";
		String strName;
		String strKey;
		String strZeichen;
		String strOxi;
		String strIndex = "";
		String strMolmasse;
		String strNomenklaturnamen;
		float fltMolmasse;
		int Position;
		int Nummer;
		int Element = 0;
		int intIndex = 1;
		int intAnzahlZeichen;
		
		int intKlammerIndex = 1;
		char chZeichen;
		
		ArrayList<Spannable> OxiListe = new ArrayList<Spannable>();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		intAnzahlElemente = prefs.getInt("AnzahlElemente", 1);
		
		// **************************************************************
		// ********** Zeichenlänge der Formel bestimmen *****************
		// **************************************************************

		strFormel = prefs.getString("Formel", "");
		fltMolmasse = prefs.getFloat("Molmasse", 0);

		strMolmasse = Float.toString(fltMolmasse);

		// **************************************************************
		// ********** Hier wir der anorganische Name ermittelt **********
		// **************************************************************

		strNomenklaturnamen = QuizFragen.suche_Nomenklaturnamen(strMolmasse);

        // **************************************************************
        // ********** Ausnahmen für bestimmte Oxidationsstufen **********
        // **************************************************************

		boolean bo_hydride1 = strNomenklaturnamen.contains("Monosilan");
        boolean bo_hydride2 = strNomenklaturnamen.contains("Stannan");
        boolean bo_hydride3 = strNomenklaturnamen.contains("hydrid");

		if((bo_hydride1 == true )||(bo_hydride2 == true )||(bo_hydride3 == true ))
		{
            prefEditor.putString("Oxi_H" ,"-1");
            prefEditor.apply();
		}

		boolean bo_acetat1 = strNomenklaturnamen.contains("acetat");
        boolean bo_acetat2 = strNomenklaturnamen.contains("Essigsäure");

        if((bo_acetat1 == true )||(bo_acetat2 == true ))
        {
            prefEditor.putString("Oxi_C" ,"3,-3");
            prefEditor.apply();
        }

        boolean bo_peroxid = strNomenklaturnamen.contains("peroxid");

		if(bo_peroxid == true)
		{
			prefEditor.putString("Oxi_O" ,"-1");
			prefEditor.apply();
		}

		if(strMolmasse.equals("69.994"))                   		      //strFormel.equals("O2F2"))
		{
			prefEditor.putString("Oxi_O" ,"1");
			prefEditor.apply();
		}

		if(strMolmasse.equals("53.995"))              					//strFormel.equals("OF2"))
		{
			prefEditor.putString("Oxi_O" ,"2");
			prefEditor.apply();
		}

			tv = (TextView) findViewById(R.id.tvNomenklaturnamen);
			tv.setText(strNomenklaturnamen);


			// **************************************************************

			intAnzahlZeichen = strFormel.length();

			//double[] arrZahl = new double[10]; // Erzeugt 10 Felder, keine 11!
			String[][] arrElement = new String[intAnzahlElemente + 1][3];
			int[][] arrFormel = new int[intAnzahlElemente + 1][cMax_Oxi];        // Array [Anzahl Elemente][max Anzahl Oxidationsstufen]

			// *********************************************************************************************
			// ********** Formel wird von hinten nach vorne Zeichen für Zeichen ausgelesen *****************
			// *********************************************************************************************

			for (Position = intAnzahlZeichen; Position >= (1); Position--) {
				chZeichen = strFormel.charAt(Position - 1); // charAt fängt bei 0 an zu zählen, wird durch +1 ausgegleichen.
				strZeichen = "" + chZeichen;

				// ****************************************************************
				// ********* Zeichen: Element oder Klammer ************************
				// ****************************************************************

				if (strZeichen.matches("[0-9]") == false) {
					if (strZeichen.equals("(")) {
						intKlammerIndex = 1;                // Klammer wird geschlossen somit wird KlammerIndex wieder zu 1
					} else {
						if (strZeichen.equals(")")) {
							intKlammerIndex = intIndex;    // Index wird zum KlammerIndex
							intIndex = 1;                    // Index selber wird wieder zu 1
							strIndex = "";                    // und string wird gelöscht
						}

						// ****************************
						// ***** Zeichen: Element *****
						// ****************************
						else {
							strElement = strZeichen + strElement;

							for (Nummer = 1; Nummer <= 38; Nummer++)        // Hauptgruppenelemente
							{
								strKey = "HE_" + Integer.toString(Nummer);    // strKey ist ein zusammen gesetzter Name der Konfig Datei
								strName = prefs.getString(strKey, "");

								if (strName.equals(strElement) == true)        // zusammen gesetzter Name wird wird Konfig Name verglichen
								{
									intIndex = intIndex * intKlammerIndex;    // Index wird mit KlammerIndex multipliziert
									strIndex = Integer.toString(intIndex);

									Element = Element + 1;
									arrElement[Element][1] = strName;        // und in zweidimensionales array gespeichert
									arrElement[Element][2] = strIndex;

									strIndex = "";                            // altes Element abgeschlossen
									intIndex = 1;                            // altes Element abgeschlossen
									strElement = "";                            // altes Element abgeschlossen

									break;
								}
							}

							if (strElement.equals("") == false)                    // wenn die 38 Hauptgruppenelemente nicht durchlaufen wurden
							{
								for (Nummer = 1; Nummer <= 43; Nummer++)        // Nebengruppenelemente
								{
									strKey = "NE_" + Integer.toString(Nummer);    // strKey ist ein zusammen gesetzter Name der Konfig Datei
									strName = prefs.getString(strKey, "");

									if (strName.equals(strElement) == true)        // zusammen gesetzter Name wird wird Konfig Name verglichen
									{
										intIndex = intIndex * intKlammerIndex;    // Index wird mit KlammerIndex multipliziert
										strIndex = Integer.toString(intIndex);

										Element = Element + 1;
										arrElement[Element][1] = strName;        // und in zweidimensionales array gespeichert
										arrElement[Element][2] = strIndex;

										strIndex = "";                            // altes Element abgeschlossen
										intIndex = 1;                            // altes Element abgeschlossen
										strElement = "";                            // altes Element abgeschlossen

										break;
									}
								}
							}
						}
					}
				}

				// ************************************************
				// ********* Zeichen: Zahl ************************
				// ************************************************

				if (strZeichen.matches("[0-9]") == true) {
					strIndex = strZeichen + strIndex;                        // bei mehrstelligen Zahlen wird strIndex zusammen addiert
					intIndex = Integer.parseInt(strIndex);
				}
			}

			// *********************************************
			// ******* Formel Textfeld wird angezeigt ******
			// *********************************************

			tv = (TextView) findViewById(R.id.tvEdukt_1);

			// Ziffern 0 bis 9 werden mittels HTML-Code tiefgestellt
			for (intIndex = 0; intIndex <= (9); intIndex++) {
				strFormel = strFormel.replaceAll(Integer.toString(intIndex), "<sub><small>" + Integer.toString(intIndex) + "</sub></small>");
			}
			tv.setText(Html.fromHtml(strFormel));


			// ********************************************************************
			// ********** Oxidationszahlen der Formel werden raus gesucht *********
			// ********** und als Integer in ein Formel Array gespeichert *********
			// ********************************************************************

			for (Element = 1; Element <= intAnzahlElemente; Element++) {
				strKey = "Oxi_" + arrElement[Element][1];                // strKey ist ein zusammen gesetzter Name ...
				strOxi = prefs.getString(strKey, "");                    // ... für die Konfig Datei

				String[] items = strOxi.split(",");                        // String wird beim "," aufgesplittet ...

				for (int i = 1; i < cMax_Oxi; i++) {
					if (i <= items.length) {
						arrFormel[Element][i] = Integer.parseInt(items[i - 1]);    // ... und einzeln in Array gespeichert
					} else {
						arrFormel[Element][i] = 99;                        // Abbruchzahl für später und damit er die Oxidationsstufe 0 von einem nicht belegtem Array unterscheiden kann.
					}
				}
			}


			// *****************************************************************
			// ********** Oxidationszahlen der Formel werden berechnet *********
			// *****************************************************************

			Zaehler = 0;
			intAnzahlOxi = 0;

			fktBerechne_OxiZahlen(arrFormel, arrElement, OxiListe);

			String strAnzahlOxi = Integer.toString(intAnzahlOxi);
			String strZaehler = Integer.toString(Zaehler);

			// *****************************************************************
			// ********** Ausgabe eines Dialogfeldes bei AnzahlOxi 0 ***********
			// *****************************************************************
			if (intAnzahlElemente == 1) {
				AlertDialog.Builder builder = new AlertDialog.Builder(GleichungActivity.this);
				builder.setTitle("Oxidationsstufe = ±0");
				builder.setMessage("Da es sich um keine Verbindung handelt,"
						+ " sondern um ein einzelnes Element, ist die Oxidationsstufe immer ±0.");
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			} else {
				if (intAnzahlOxi == 0) {
					AlertDialog.Builder builder = new AlertDialog.Builder(GleichungActivity.this);
					builder.setTitle("Formel korrekt?");
					builder.setMessage("Achtung! Eine Berechnung der Oxidationsstufen der Elemente"
							+ " ist bei der eingegebenen Formel nicht möglich. Wahrscheinliche Ursache:"
							+ " Fehlerhafte Formel!");
					builder.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.dismiss();
								}
							});
					AlertDialog dialog = builder.create();
					dialog.show();
				}
			}


			tv = (TextView) findViewById(R.id.tvAnzahlOxi);
			tv.setText("Anzahl mögliche Kombination:  " + strAnzahlOxi);

			tv = (TextView) findViewById(R.id.tvZaehler);
			tv.setText("Anzahl Kombination insgesamt: " + strZaehler);

			ListAdapter listenAdapter = new ArrayAdapter<Spannable>(this, android.R.layout.simple_list_item_1, OxiListe);

			// Die ListView-Komponente kommt aus dem Layout
			ListView lv = (ListView) findViewById(R.id.lvOxiListe);
			lv.setAdapter(listenAdapter);

	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
    } // onPause

	
	 /************************************************************************************
	  ******************************* Button "Zurueck" ************************************
	  ************************************************************************************/
	
	public void btnZurueck(View v) 
	{
		Intent myIntent = new Intent(this, MolmassenActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
		               
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 
		     	             
		prefEditor.putInt("AnzahlElemente", 0);
		prefEditor.apply();
		

    } // btnZurueck
	
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
           		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
           		SharedPreferences.Editor prefEditor = prefs.edit();
           		prefEditor.putString("Einstellungen", "3");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Oxidationsstufen");
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
        } // switch (item.getItemId())
    } // onOptionsItemSelected
    
	private String fktRoemischeZiffer(int intZahl)
	{
		String strResult;
		
		strResult = "0";

		if (intZahl != 0)
		{
			switch (intZahl) 
			{
			case -1:
				strResult = "-I"; break;
			case -2:			
				strResult = "-II"; break;
			case -3:			
				strResult = "-III"; break;
			case -4:			
				strResult = "-IV"; break;
			case -5:			
				strResult = "-V"; break;
			case -6:			
				strResult = "-VI"; break;
			case -7:			
				strResult = "-VII"; break;
			case -8:			
				strResult = "-VIII"; break;
			case 1:
				strResult = "+I"; break;
			case 2:			
				strResult = "+II"; break;
			case 3:			
				strResult = "+III"; break;
			case 4:			
				strResult = "+IV"; break;
			case 5:			
				strResult = "+V"; break;
			case 6:			
				strResult = "+VI"; break;
			case 7:			
				strResult = "+VII"; break;
			case 8:			
				strResult = "+VIII"; break;
			} // switch (intZahl)
		} // if (intZahl != 0)
			
		return strResult;
	} // fktRoemischeZiffer   

	public void fktBerechne_OxiZahlen (int[][] arrFormel, String [][] arrElement, ArrayList<Spannable> OxiListe)
	{
		String cLogTag = "fktBerechne_OxiZahlen";
		int cOxi_Ende = 99;
		
	    int intElement;
	    int intElement_Aktuell;
	    
	    int intOxi;
	    int intOxi_Summe;
	    int intIndex;
	    
	    String strOxiListe;
	    
	    boolean bSchleifenEnde;
		
	    // Zähler für Oxi-Stufen in Spalte 0 initialisieren
		for (intElement = 1; intElement <= intAnzahlElemente; intElement++)
		{
			arrFormel[intElement][0] = 1;
		}
		
	    do
	    {
	        // Kombination ausgeben
	        Zaehler = Zaehler + 1;
	        intOxi_Summe = 0;

			for (intElement = intAnzahlElemente; intElement >= 1; intElement--)
			{
	            intOxi = arrFormel[intElement][0];
	            intIndex = Integer.parseInt(arrElement [intElement][2]);
	            intOxi_Summe = intOxi_Summe + arrFormel[intElement][intOxi] * intIndex;
		        //Log.i(cLogTag, Integer.toString(arrFormel[intElement][intOxi]));			
			}
	        
			//Log.i(cLogTag, " = " + Integer.toString(intOxi_Summe));
			
			if (intOxi_Summe == 0)
			{
				intAnzahlOxi++;
				
		        Log.i(cLogTag, "Kombination #" + Integer.toString(Zaehler));
				strOxiListe = "";    //alt:  strOxiListe = Integer.toString(Zaehler)+ ". ";
				for (intElement = intAnzahlElemente; intElement >= 1; intElement--)
				{
		            intOxi = arrFormel[intElement][0];
		            strOxiListe = strOxiListe + arrElement[intElement][1] + " " + fktRoemischeZiffer(arrFormel[intElement][intOxi]) + ", " ;
		            
				}				
				strOxiListe = strOxiListe.substring(0, strOxiListe.length()-2); // überflüssiges ", " am Ende des Strings entfernen

				OxiListe.add((Spannable) Html.fromHtml(strOxiListe));
								
		        Log.i(cLogTag, strOxiListe);		
			}
	    
	        intElement_Aktuell = intAnzahlElemente;
	        do
	        {
	            intOxi = arrFormel[intElement_Aktuell][0] + 1;
	            if (arrFormel[intElement_Aktuell][intOxi] == cOxi_Ende)
	            {
	            	arrFormel[intElement_Aktuell][0] = 1;
	                intElement_Aktuell = intElement_Aktuell - 1;
	                intOxi = arrFormel[intElement_Aktuell][0] + 1;
	            }
	            arrFormel[intElement_Aktuell][0] = intOxi;
	            bSchleifenEnde = (arrFormel[intElement_Aktuell][intOxi] != cOxi_Ende) || (intElement_Aktuell == 0);	            	            
	            
		    } while (bSchleifenEnde == false);
	        
	    } while (intElement_Aktuell != 0);
	} // fktBerechne_OxiZahlen


	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		String text = "\n   Bitte Zurück Taste benutzen!   \n";
		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		Meldung.setGravity(Gravity.BOTTOM, 0, 0);
		Meldung.show();

		return true;
	} // onKeyDown


} // GleichungActivity 

