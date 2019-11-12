package de.laborabakus;

import android.app.Activity;



public class Konz_lsg_Gegeben_Activity extends Activity /*implements OnFocusChangeListener */
{

    public static double fktDichtetabellen(String strKonzAuswahl, double dblKonzGehalt, double dblKonzMenge, double dblVerdMenge, String strVerdGehalt, String strVerdGehaltEinheit)
    {
        double dblVerdDichte = 1;
        double dblVerdMasse;
        double dblVerdGehalt = 0;
        double dblObereDichte = 0;
        double dblUntereDichte = 0;
        double dblUntererGehalt = 0;
        double dblObererGehalt = 0;
        double dblWert1;
        double dblWert2;
        int intCounter = 0;
        int d = 0;
        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        // String [] splitResult = new String [2];
        String[][] arrWert = new String [4][102];

        arrWert [2][0]  = "1_0";             arrWert [3][0]  = "1_0";               arrWert [1][0]  = "1_0";
        arrWert [2][1]  = "1.0051_0.1025";   arrWert [3][1]  = "1.004_0.1593";      arrWert [1][1]  = "1.003_0.2751";
        arrWert [2][2]  = "1.0118_0.2063";   arrWert [3][2]  = "1.009_0.3203";      arrWert [1][2]  = "1.008_0.5529";
        arrWert [2][3]  = "1.0184_0.3115";   arrWert [3][3]  = "1.015_0.4832";      arrWert [1][3]  = "1.013_0.8335";
        arrWert [2][4]  = "1.0250_0.4180";   arrWert [3][4]  = "1.020_0.6475";      arrWert [1][4]  = "1.018_1.1168";
        arrWert [2][5]  = "1.0317_0.5260";   arrWert [3][5]  = "1.026_0.8141";      arrWert [1][5]  = "1.023_1.4029";
        arrWert [2][6]  = "1.0385_0.6353";   arrWert [3][6]  = "1.031_0.9817";      arrWert [1][6]  = "1.028_1.6917";
        arrWert [2][7]  = "1.0453_0.7460";   arrWert [3][7]  = "1.037_1.1520";      arrWert [1][7]  = "1.033_1.9832";
        arrWert [2][8]  = "1.0522_0.8583";   arrWert [3][8]  = "1.043_1.3242";      arrWert [1][8]  = "1.038_2.2775";
        arrWert [2][9]  = "1.0591_0.9719";   arrWert [3][9]  = "1.049_1.4983";      arrWert [1][9]  = "1.043_2.5745";
        arrWert [2][10] = "1.0661_1.0870";   arrWert [3][10] = "1.054_1.6727";      arrWert [1][10] = "1.048_2.8743";
        arrWert [2][11] = "1.0731_1.2035";   arrWert [3][11] = "1.060_1.8504";      arrWert [1][11] = "1.053_3.1768";
        arrWert [2][12] = "1.0802_1.3216";   arrWert [3][12] = "1.066_2.0301";      arrWert [1][12] = "1.058_3.4821";
        arrWert [2][13] = "1.0874_1.4413";   arrWert [3][13] = "1.072_2.2116";      arrWert [1][13] = "1.063_3.7901";
        arrWert [2][14] = "1.0947_1.5626";   arrWert [3][14] = "1.078_2.3951";      arrWert [1][14] = "1.068_4.1008";
        arrWert [2][15] = "1.1020_1.6854";   arrWert [3][15] = "1.084_2.5804";      arrWert [1][15] = "1.073_4.4143";
        arrWert [2][16] = "1.1094_1.8098";   arrWert [3][16] = "1.090_2.7677";      arrWert [1][16] = "1.078_4.7305";
        arrWert [2][17] = "1.1168_1.9358";   arrWert [3][17] = "1.096_2.9569";      arrWert [1][17] = "1.083_5.0495";
        arrWert [2][18] = "1.1234_2.0617";   arrWert [3][18] = "1.103_3.1508";      arrWert [1][18] = "1.088_5.3712";
        arrWert [2][19] = "1.1318_2.1925";   arrWert [3][19] = "1.119_3.3439";      arrWert [1][19] = "1.093_5.6957";
        arrWert [2][20] = "1.1394_2.3234";   arrWert [3][20] = "1.115_3.5390";      arrWert [1][20] = "1.098_6.0229";
        arrWert [2][21] = "1.1471_2.4561";   arrWert [3][21] = "1.121_3.7359";      arrWert [1][21] = "1.103_6.3528";
        arrWert [2][22] = "1.1548_2.5903";   arrWert [3][22] = "1.128_3.9382";      arrWert [1][22] = "1.108_6.6855";
        arrWert [2][23] = "1.1626_2.7264";   arrWert [3][23] = "1.134_4.1392";      arrWert [1][23] = "1.113_7.0209";
        arrWert [2][24] = "1.1704_2.8640";   arrWert [3][24] = "1.140_4.3420";      arrWert [1][24] = "1.118_7.3591";
        arrWert [2][25] = "1.1783_3.0035";   arrWert [3][25] = "1.147_4.5507";      arrWert [1][25] = "1.123_7.7000";
        arrWert [2][26] = "1.1862_3.1445";   arrWert [3][26] = "1.153_4.7574";      arrWert [1][26] = "1.129_8.0508";
        arrWert [2][27] = "1.1942_3.2875";   arrWert [3][27] = "1.160_4.9704";      arrWert [1][27] = "1.133_8.3901";
        arrWert [2][28] = "1.2023_3.4324";   arrWert [3][28] = "1.167_5.1856";      arrWert [1][28] = "1.138_8.7392";
        arrWert [2][29] = "1.2104_3.5789";   arrWert [3][29] = "1.173_5.3984";      arrWert [1][29] = "1.143_9.0911";
        arrWert [2][30] = "1.2185_3.7271";   arrWert [3][30] = "1.180_5.6179";      arrWert [1][30] = "1.148_9.4457";
        arrWert [2][31] = "1.2267_3.8773";   arrWert [3][31] = "1.187_5.8396";      arrWert [1][31] = "1.153_9.8031";
        arrWert [2][32] = "1.2349_4.0291";   arrWert [3][32] = "1.193_6.0585";      arrWert [1][32] = "1.158_10.1632";
        arrWert [2][33] = "1.2432_4.1829";   arrWert [3][33] = "1.200_6.2844";      arrWert [1][33] = "1.163_10.5261";
        arrWert [2][34] = "1.2515_4.3385";   arrWert [3][34] = "1.207_6.5126";      arrWert [1][34] = "1.168_10.8917";
        arrWert [2][35] = "1.2599_4.4960";   arrWert [3][35] = "1.214_6.7431";      arrWert [1][35] = "1.173_11.2600";
        arrWert [2][36] = "1.2684_4.6557";   arrWert [3][36] = "1.221_6.9757";      arrWert [1][36] = "1.179_11.6409";
        arrWert [2][37] = "1.2769_4.8171";   arrWert [3][37] = "1.227_7.2047";      arrWert [1][37] = "1.183_12.0049";
        arrWert [2][38] = "1.2855_4.9806";   arrWert [3][38] = "1.234_7.4417";      arrWert [1][38] = "1.188_12.3815";
        arrWert [2][39] = "1.2941_5.1459";   arrWert [3][39] = "1.240_7.6746";      arrWert [1][39] = "1.193_12.7608";
        arrWert [2][40] = "1.3028_5.3133";   arrWert [3][40] = "1.246_7.9095";      arrWert [1][40] = "1.198_13.1428";
        arrWert [2][41] = "1.3116_5.4829";   arrWert [3][41] = "1.253_8.1528";      arrWert [1][41] = "0_0";
        arrWert [2][42] = "1.3205_5.6548";   arrWert [3][42] = "1.259_8.3916";      arrWert [1][42] = "0_0";
        arrWert [2][43] = "1.3294_5.8284";   arrWert [3][43] = "1.266_8.6392";      arrWert [1][43] = "0_0";
        arrWert [2][44] = "1.3384_6.0043";   arrWert [3][44] = "1.272_8.8820";      arrWert [1][44] = "0_0";
        arrWert [2][45] = "1.3476_6.1830";   arrWert [3][45] = "1.278_9.1267";      arrWert [1][45] = "0_0";
        arrWert [2][46] = "1.3569_6.3640";   arrWert [3][46] = "1.284_9.3733";      arrWert [1][46] = "0_0";
        arrWert [2][47] = "1.3663_6.5474";   arrWert [3][47] = "1.291_9.6293";      arrWert [1][47] = "0_0";
        arrWert [2][48] = "1.3758_6.7332";   arrWert [3][48] = "1.298_9.8875";      arrWert [1][48] = "0_0";
        arrWert [2][49] = "1.3854_6.9215";   arrWert [3][49] = "1.304_10.1402";     arrWert [1][49] = "0_0";
        arrWert [2][50] = "1.3951_7.1122";   arrWert [3][50] = "1.310_10.3974";     arrWert [1][50] = "0_0";
        arrWert [2][51] = "1.4049_7.3054";   arrWert [3][51] = "1.316_10.6512";     arrWert [1][51] = "0_0";
        arrWert [2][52] = "1.4148_7.5011";   arrWert [3][52] = "1.322_10.9095";     arrWert [1][52] = "0_0";
        arrWert [2][53] = "1.4248_7.6994";   arrWert [3][53] = "1.326_11.1530";     arrWert [1][53] = "0_0";
        arrWert [2][54] = "1.4350_7.9008";   arrWert [3][54] = "1.334_11.4320";     arrWert [1][54] = "0_0";
        arrWert [2][55] = "1.4453_8.1049";   arrWert [3][55] = "1.340_11.6960";     arrWert [1][55] = "0_0";
        arrWert [2][56] = "1.4557_8.3116";   arrWert [3][56] = "1.345_11.9531";     arrWert [1][56] = "0_0";
        arrWert [2][57] = "1.4662_8.5211";   arrWert [3][57] = "1.351_12.2209";     arrWert [1][57] = "0_0";
        arrWert [2][58] = "1.4768_8.7332";   arrWert [3][58] = "1.356_12.4813";     arrWert [1][58] = "0_0";
        arrWert [2][59] = "1.4875_8.9482";   arrWert [3][59] = "1.361_12.7433";     arrWert [1][59] = "0_0";
        arrWert [2][60] = "1.4983_9.1659";   arrWert [3][60] = "1.367_13.0164";     arrWert [1][60] = "0_0";
        arrWert [2][61] = "1.5091_9.3859";   arrWert [3][61] = "1.372_13.2817";     arrWert [1][61] = "0_0";
        arrWert [2][62] = "1.5200_9.6086";   arrWert [3][62] = "1.377_13.5487";     arrWert [1][62] = "0_0";
        arrWert [2][63] = "1.5310_9.8343";   arrWert [3][63] = "1.382_13.8172";     arrWert [1][63] = "0_0";
        arrWert [2][64] = "1.5421_10.0628";  arrWert [3][64] = "1.387_14.0873";     arrWert [1][64] = "0_0";
        arrWert [2][65] = "1.5533_10.2943";  arrWert [3][65] = "1.391_14.3487";     arrWert [1][65] = "0_0";
        arrWert [2][66] = "1.5646_10.5287";  arrWert [3][66] = "1.396_14.6218";     arrWert [1][66] = "0_0";
        arrWert [2][67] = "1.5760_10.7661";  arrWert [3][67] = "1.400_14.8859";     arrWert [1][67] = "0_0";
        arrWert [2][68] = "1.5874_11.0058";  arrWert [3][68] = "1.404_15.1512";     arrWert [1][68] = "0_0";
        arrWert [2][69] = "1.5989_11.2486";  arrWert [3][69] = "1.409_15.4288";     arrWert [1][69] = "0_0";
        arrWert [2][70] = "1.6105_11.4944";  arrWert [3][70] = "1.413_15.6968";     arrWert [1][70] = "0_0";
        arrWert [2][71] = "1.6221_11.7425";  arrWert [3][71] = "1.418_15.9774";     arrWert [1][71] = "0_0";
        arrWert [2][72] = "1.6338_11.9938";  arrWert [3][72] = "1.422_16.2481";     arrWert [1][72] = "0_0";
        arrWert [2][73] = "1.6456_12.2482";  arrWert [3][73] = "1.426_16.5201";     arrWert [1][73] = "0_0";
        arrWert [2][74] = "1.6574_12.5050";  arrWert [3][74] = "1.430_16.7934";     arrWert [1][74] = "0_0";
        arrWert [2][75] = "1.6692_12.7643";  arrWert [3][75] = "1.434_17.0680";     arrWert [1][75] = "0_0";
        arrWert [2][76] = "1.6810_13.0259";  arrWert [3][76] = "1.438_17.3438";     arrWert [1][76] = "0_0";
        arrWert [2][77] = "1.6927_13.2891";  arrWert [3][77] = "1.441_17.6086";     arrWert [1][77] = "0_0";
        arrWert [2][78] = "1.7043_13.5540";  arrWert [3][78] = "1.445_17.8868";     arrWert [1][78] = "0_0";
        arrWert [2][79] = "1.7158_13.8204";  arrWert [3][79] = "1.449_18.1663";     arrWert [1][79] = "0_0";
        arrWert [2][80] = "1.7270_14.0867";  arrWert [3][80] = "1.452_18.4343";     arrWert [1][80] = "0_0";
        arrWert [2][81] = "1.7383_14.3561";  arrWert [3][81] = "1.455_18.7033";     arrWert [1][81] = "0_0";
        arrWert [2][82] = "1.7491_14.6236";  arrWert [3][82] = "1.459_18.9863";     arrWert [1][82] = "0_0";
        arrWert [2][83] = "1.7594_14.8891";  arrWert [3][83] = "1.462_19.2574";     arrWert [1][83] = "0_0";
        arrWert [2][84] = "1.7693_15.1533";  arrWert [3][84] = "1.466_19.5427";     arrWert [1][84] = "0_0";
        arrWert [2][85] = "1.7786_15.4143";  arrWert [3][85] = "1.469_19.8158";     arrWert [1][85] = "0_0";
        arrWert [2][86] = "1.7872_15.6710";  arrWert [3][86] = "1.472_20.0899";     arrWert [1][86] = "0_0";
        arrWert [2][87] = "1.7951_15.9233";  arrWert [3][87] = "1.475_20.3649";     arrWert [1][87] = "0_0";
        arrWert [2][88] = "1.8022_16.1701";  arrWert [3][88] = "1.477_20.6269";     arrWert [1][88] = "0_0";
        arrWert [2][89] = "1.8087_16.4128";  arrWert [3][89] = "1.480_20.9037";     arrWert [1][89] = "0_0";
        arrWert [2][90] = "1.8144_16.6495";  arrWert [3][90] = "1.483_21.1814";     arrWert [1][90] = "0_0";
        arrWert [2][91] = "1.8195_16.8818";  arrWert [3][91] = "1.485_21.4456";     arrWert [1][91] = "0_0";
        arrWert [2][92] = "1.8240_17.1096";  arrWert [3][92] = "1.487_21.7105";     arrWert [1][92] = "0_0";
        arrWert [2][93] = "1.8279_17.3325";  arrWert [3][93] = "1.489_21.9760";     arrWert [1][93] = "0_0";
        arrWert [2][94] = "1.8312_17.5505";  arrWert [3][94] = "1.491_22.2421";     arrWert [1][94] = "0_0";
        arrWert [2][95] = "1.8337_17.7614";  arrWert [3][95] = "1.493_22.5089";     arrWert [1][95] = "0_0";
        arrWert [2][96] = "1.8355_17.9660";  arrWert [3][96] = "1.495_22.7763";     arrWert [1][96] = "0_0";
        arrWert [2][97] = "1.8364_18.1621";  arrWert [3][97] = "1.497_23.0444";     arrWert [1][97] = "0_0";
        arrWert [2][98] = "1.8361_18.3463";  arrWert [3][98] = "1.501_23.3441";     arrWert [1][98] = "0_0";
        arrWert [2][99] = "1.8362_18.5143";  arrWert [3][99] = "1.506_23.6609";     arrWert [1][99] = "0_0";
        arrWert [2][100]= "1.8305_18.6636";  arrWert [3][100]= "1.513_24.0110";     arrWert [1][100]= "0_0";
        arrWert [2][101]= "Schwefelsäure";   arrWert [3][101]= "Salpetersäure";     arrWert [1][101]= "Salzsäure";


        double dblVerdMenge1 = 0;
        double dblVerdMenge2;
        double dblWert = 0;
        int intUntereDichte = 1;
        int intObereDichte = 1;
        int intUntererGehalt = 1;
        int intObererGehalt = 1;


        if(dblKonzGehalt != 0) // Bei Routine 5 und 6, wo die Masse (das Volumen) unbekannt ist und der Gehalt gesucht wird.
        {
            for (z=1; z<=3; z++)
            {
                if (arrWert[z][101].equals(strKonzAuswahl) == true)             // Hier wird die entspechende Tabelle (Salzsäure etc) ausgewählt
                {
                    for (w = 0; w <= 100; w++)
                    {
                        String[] splitResult = arrWert[z][w].split("_");

                        dblVerdDichte = Double.parseDouble(splitResult[0]);

                        if(strVerdGehaltEinheit.equals("%") == true)                // wenn die Einheit % ist
                        {
                            dblVerdGehalt = w;                                      // dblVerdGehalt = % Wert
                            dblVerdMenge1 = dblVerdMenge * dblVerdDichte;           // Masse wird berechnet
                        }
                        else                                                        // wenn die Einheit mol/l ist
                        {
                            dblVerdGehalt = Double.parseDouble(splitResult[1]);     // dblVerdGehalt = mol/l Wert
                            dblVerdMenge1 = dblVerdMenge / dblVerdDichte;           // Volumen wird berechnet
                        }

                        dblVerdMenge2 = (dblKonzGehalt * dblKonzMenge) / dblVerdGehalt;

                        if ((dblVerdMenge1 > dblVerdMenge2)&& (intCounter == 0))
                        {
                            intCounter = 1;
                            dblObereDichte = dblVerdDichte;
                            dblObererGehalt = dblVerdGehalt;
                            intObereDichte = fktvomDoublezumInt(dblVerdDichte, 10000);
                            intObererGehalt = fktvomDoublezumInt(dblVerdGehalt, 10000);

                        }
                        if ((dblVerdMenge1 <= dblVerdMenge2) && (intCounter == 0))
                        {
                            dblUntereDichte = dblVerdDichte;
                            intUntereDichte = fktvomDoublezumInt(dblVerdDichte, 10000);


                            if (dblVerdGehalt != 0)
                            {
                                dblUntererGehalt = dblVerdGehalt;
                                intUntererGehalt = fktvomDoublezumInt(dblVerdGehalt, 10000);
                            }
                            else
                            {
                                intUntererGehalt = 0;
                            }
                        }
                    }

                    for (d = intUntererGehalt; d <= intObererGehalt; d++)
                    {
                        dblWert = (((double) d) / 10000); // aktueller Gehalt

                        // Interpolation
                        dblWert1 = dblUntereDichte + ((dblObereDichte - dblUntereDichte) / (dblObererGehalt - dblUntererGehalt)) * (dblWert - dblUntererGehalt);

                        dblWert2 = (dblKonzMenge * dblKonzGehalt) / (dblVerdMenge * dblWert);

                        if (dblWert1 >= dblWert2 && (intCounter == 1))
                        {
                            dblVerdDichte = dblWert1;
                            intCounter = 2;
                        }

                    }


                    /*
                    intUntereDichte = intUntereDichte * 100;
                    intObereDichte = intObereDichte * 100;

                    for (d = intUntereDichte; d <= intObereDichte; d++)
                    {
                        dblWert1 = (((double) d) / 1000000); // aktuelle Dichte

                        // Interpolation
                        dblVerdGehalt = dblUntererGehalt + ((dblObererGehalt - dblUntererGehalt) / (dblObereDichte - dblUntereDichte)) * (dblWert1 - dblUntereDichte);

                        dblVerdMasse = (dblKonzMenge * dblKonzGehalt) / dblVerdGehalt;   // Masse Verd = (Gehalt Konz x Masse Konz) / Gehalt Verd

                        dblWert2 = dblVerdMasse / dblVerdMenge;             // Dichte = Masse / Volumen

                        if (dblWert1 >= dblWert2 && (intCounter == 1))
                        {
                            dblVerdDichte = dblWert1;
                            intCounter = 2;
                        }
                    }*/
                }
            }
        }
        else
        {
            if(strVerdGehaltEinheit.equals("%") == true) // Bei Routine 1 bis 4
            {
                for (x=1; x<=3; x++)
                {
                    if (arrWert[x][101].equals(strKonzAuswahl) == true)
                    {
                        strVerdGehalt = strVerdGehalt.replace(".", "_");
                        String[] splitResult = strVerdGehalt.split("_");   // splitt funktioniert nicht mit Punkt .

                        String strUntererGehalt = splitResult[0];
                        intUntererGehalt = Integer.parseInt(strUntererGehalt);

                        // **************************************
                        // ************ untere Dichte ***********
                        // **************************************
                        String strUntererWert = arrWert [x][intUntererGehalt];

                        splitResult = strUntererWert.split("_");

                        dblUntereDichte = Double.parseDouble(splitResult[0]);

                        // **************************************
                        // ************ obere Dichte ***********
                        // **************************************
                        String strObererWert = arrWert [x][intUntererGehalt + 1];

                        splitResult = strObererWert.split("_");

                        dblObereDichte = Double.parseDouble(splitResult[0]);

                        strVerdGehalt = strVerdGehalt.replace("_", ".");

                        dblVerdGehalt = Double.parseDouble(strVerdGehalt);

                        dblUntererGehalt = Double.parseDouble(strUntererGehalt);

                        // **************************************
                        // ************ Interpolieren ***********
                        // **************************************

                        dblVerdDichte = dblUntereDichte + ((dblObereDichte - dblUntereDichte)/((dblUntererGehalt +1) - dblUntererGehalt)) * (dblVerdGehalt - dblUntererGehalt);
                    }
                }
            }
            else
            {
                dblVerdGehalt = Double.parseDouble(strVerdGehalt);

                for (x=1; x<=3; x++)
                {
                    if (arrWert[x][101].equals(strKonzAuswahl) == true)
                    {
                        for (y = 0; y <= 100; y++)
                        {
                            String[] splitResult = arrWert[x][y].split("_");

                            dblObereDichte = Double.parseDouble(splitResult[0]);
                            dblObererGehalt = Double.parseDouble(splitResult[1]);


                            if ((dblObererGehalt > dblVerdGehalt) && (intCounter == 0))
                            {
                                // **************************************
                                // ************ Interpolieren ***********
                                // **************************************

                                dblVerdDichte = dblUntereDichte + ((dblObereDichte - dblUntereDichte)/((dblObererGehalt) - dblUntererGehalt)) * (dblVerdGehalt - dblUntererGehalt);

                                intCounter = 1;
                            }
                            dblUntereDichte = dblObereDichte;
                            dblUntererGehalt = dblObererGehalt;
                        }
                    }
                }
            }
        }
        return dblVerdDichte;
    }

    public static int fktvomDoublezumInt(double dblDouble, int intMultiplikator)
    {
        int intIntega = 0;

        String strErgebnis = Double.toString((dblDouble * intMultiplikator));
        strErgebnis = strErgebnis.replace(".", "_");
        String[] splitErgebnis = strErgebnis.split("_",2);   // –> splitten am Punkt
        intIntega = Integer.parseInt(splitErgebnis[0]);

        return intIntega;
    }

} // class Konz_lsg_Auswahl

