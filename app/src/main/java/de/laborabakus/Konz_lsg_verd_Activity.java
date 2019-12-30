package de.laborabakus;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import static de.laborabakus.ActivityTools.fktSignifikanteStellen;


public class Konz_lsg_verd_Activity extends Activity /*implements OnFocusChangeListener */
{
    public static double fktGehaltUmrechnenAufProzent(double dblEingabewert, String strAuswahl, String strEinheit, double dblWertigkeit, double dblMolmasse, double dblDichte)
    {
        double dblGehalt = 0;
        switch (strEinheit)
        {
            case "%":
                dblGehalt = dblEingabewert;
                break;

            case "g/l":
                dblGehalt = dblEingabewert / (dblDichte * 10);
                break;

            case "mol/l":
                dblGehalt = (dblEingabewert * dblMolmasse) / (dblDichte * 10);
                break;

            case "M":
                dblGehalt = (dblEingabewert * dblMolmasse) / (dblDichte * 10);
                break;

            case "N":
                dblGehalt = ((dblEingabewert * dblMolmasse)) / (dblDichte * 10) / dblWertigkeit;
                break;
        }
        return dblGehalt;
    }

    public static double fktGehaltUmrechnenAufGrammProLiter(double dblEingabewert, String strAuswahl, String strEinheit, double dblWertigkeit, double dblMolmasse, double dblDichte)
    {
        double dblGehalt = 0;
        switch (strEinheit)
        {
            case "%":
                dblGehalt = dblEingabewert * dblDichte *10 ;
                break;

            case "g/l":
                dblGehalt = dblEingabewert;
                break;

            case "mol/l":
                dblGehalt = dblEingabewert * dblMolmasse;
                break;

            case "M":
                dblGehalt = dblEingabewert * dblMolmasse;
                break;

            case "N":
                dblGehalt = (dblEingabewert * dblMolmasse) / dblWertigkeit;
                break;
        }
        return dblGehalt;
    }

    public static double fktGehaltUmrechnenAufMolar(double dblEingabewert, String strAuswahl, String strEinheit, double dblWertigkeit, double dblMolmasse, double dblDichte)
    {
        double dblGehalt = 0;
        switch (strEinheit)
        {
            case "%":
                dblGehalt = (dblEingabewert * dblDichte *10) / dblMolmasse;
                break;

            case "g/l":
                dblGehalt = dblEingabewert / dblMolmasse;
                break;

            case "mol/l":
                dblGehalt = dblEingabewert;
                break;

            case "M":
                dblGehalt = dblEingabewert;
                break;

            case "N":
                dblGehalt = dblEingabewert / dblWertigkeit;
                break;
        }
        return dblGehalt;
    }

    public static double fktGehaltUmrechnenAufNormal(double dblEingabewert, String strAuswahl, String strEinheit, double dblWertigkeit, double dblMolmasse, double dblDichte)
    {
        double dblGehalt = 0;

        switch (strEinheit)
        {
            case "%":
                dblGehalt = ((dblEingabewert * dblDichte * 10) / dblMolmasse);  // Umrechnung auf Molar
                break;

            case "g/l":
                dblGehalt = (dblEingabewert / dblMolmasse);                     // Umrechnung auf g/l
                break;

            case "mol/l":
                dblGehalt = dblEingabewert* dblWertigkeit;                      // Umrechnung auf Molar
                break;

            case "M":
                dblGehalt = dblEingabewert* dblWertigkeit;                      // Umrechnung auf Molar
                break;

            case "N":
                dblGehalt = dblEingabewert;
                break;
        }

        return dblGehalt;
    }

    public static double fktStringZumDouble(String strWert)
    {
        double dblWert = 0;
        strWert = strWert.replace(",", ".");
        dblWert = Double.parseDouble(strWert);
        return dblWert;
    }

    public static String fktDoubleZumString(double dblWert)
    {
        String strWert = "";
        strWert = Double.toString(dblWert);
        strWert = strWert.replace(".", ",");
        return strWert;
    }


    /********************************************
     ************** Menue Button ****************
     ********************************************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId())
        {
            case R.id.menu_Hilfe:
                intent = new Intent(this, HilfeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("Kapitel", "Konz_Lsg_Eingabe");
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
} // class Activity

