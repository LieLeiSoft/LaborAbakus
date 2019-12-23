package de.laborabakus;

import android.app.Activity;



public class Konz_lsg_Gegeben_Activity extends Activity /*implements OnFocusChangeListener */
{

    public static double fktDichtetabellen(String strKonzAuswahl, double dblKonzGehalt, double dblKonzMenge, double dblVerdMenge, String strVerdGehalt, String strVerdGehaltEinheit)
    {
        double dblVerdDichte = 1;
        double dblVerdDichte1 = 1;
        double dblVerdDichte2 = 1;
        double dblGehalt = 0;
        double dblVerdGehalt = 0;
        double dblVerdGehalt1 = 0;
        double dblVerdGehalt2 = 0;
        double dblVerdMenge1 = 0;
        double dblObereDichte = 0;
        double dblUntereDichte = 0;
        double dblUntererGehalt = 0;
        double dblObererGehalt = 0;
        int intProzent = 0;
        int intStop = 0;
        int intGehalt = 0;
        int intObererGehalt = 0;
        int intUntererGehalt = 0;
        int intAuswahl = 0;


        String [] splitResult = new String [2];
        String[][] arrWert = new String [10][102];

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


        arrWert [4][0]  = "1_0";            arrWert [5][0]  = "1_0";               arrWert [6][0]  = "1_0";
        arrWert [4][1]  = "1.004_0.1025";   arrWert [5][1]  = "1.000_0.1665";      arrWert [6][1]  = "1.010_0.2525";
        arrWert [4][2]  = "1.009_0.2059";   arrWert [5][2]  = "1.001_0.3334";      arrWert [6][2]  = "1.021_0.5105";
        arrWert [4][3]  = "1.015_0.3107";   arrWert [5][3]  = "1.003_0.5011";      arrWert [6][3]  = "1.032_0.7741";
        arrWert [4][4]  = "1.020_0.4163";   arrWert [5][4]  = "1.004_0.6688";      arrWert [6][4]  = "1.043_1.0431";
        arrWert [4][5]  = "1.026_0.5235";   arrWert [5][5]  = "1.005_0.8368";      arrWert [6][5]  = "1.054_1.3176";
        arrWert [4][6]  = "1.031_0.6313";   arrWert [5][6]  = "1.007_1.0061";      arrWert [6][6]  = "1.065_1.5976";
        arrWert [4][7]  = "1.037_0.7408";   arrWert [5][7]  = "1.008_1.1750";      arrWert [6][7]  = "1.076_1.8831";
        arrWert [4][8]  = "1.042_0.8507";   arrWert [5][8]  = "1.009_1.3442";      arrWert [6][8]  = "1.087_2.1742";
        arrWert [4][9]  = "1.048_0.9625";   arrWert [5][9]  = "1.011_1.5152";      arrWert [6][9]  = "1.098_2.4707";
        arrWert [4][10] = "1.053_1.0745";   arrWert [5][10] = "1.012_1.6852";      arrWert [6][10] = "1.109_2.7727";
        arrWert [4][11] = "1.059_1.1887";   arrWert [5][11] = "1.013_1.8556";      arrWert [6][11] = "1.120_3.0802";
        arrWert [4][12] = "1.065_1.3041";   arrWert [5][12] = "1.015_2.0282";      arrWert [6][12] = "1.131_3.3932";
        arrWert [4][13] = "1.071_1.4208";   arrWert [5][13] = "1.016_2.1994";      arrWert [6][13] = "1.142_3.7118";
        arrWert [4][14] = "1.076_1.5372";   arrWert [5][14] = "1.017_2.3709";      arrWert [6][14] = "1.153_4.0358";
        arrWert [4][15] = "1.082_1.6562";   arrWert [5][15] = "1.018_2.5428";      arrWert [6][15] = "1.164_4.3653";
        arrWert [4][16] = "1.088_1.7764";   arrWert [5][16] = "1.020_2.7176";      arrWert [6][16] = "1.175_4.7003";
        arrWert [4][17] = "1.095_1.8996";   arrWert [5][17] = "1.021_2.8903";      arrWert [6][17] = "1.186_5.0409";
        arrWert [4][18] = "1.101_2.0223";   arrWert [5][18] = "1.022_3.0633";      arrWert [6][18] = "1.197_5.3869";
        arrWert [4][19] = "1.107_2.1463";   arrWert [5][19] = "1.024_3.2399";      arrWert [6][19] = "1.208_5.7384";
        arrWert [4][20] = "1.113_2.2715";   arrWert [5][20] = "1.025_3.4137";      arrWert [6][20] = "1.219_6.0954";
        arrWert [4][21] = "1.120_2.4001";   arrWert [5][21] = "1.026_3.5879";      arrWert [6][21] = "1.230_6.4580";
        arrWert [4][22] = "1.126_2.5279";   arrWert [5][22] = "1.028_3.7661";      arrWert [6][22] = "1.241_6.8260";
        arrWert [4][23] = "1.133_2.6592";   arrWert [5][23] = "1.029_3.9411";      arrWert [6][23] = "1.252_7.1995";
        arrWert [4][24] = "1.140_2.7920";   arrWert [5][24] = "1.030_4.1164";      arrWert [6][24] = "1.263_7.5785";
        arrWert [4][25] = "1.146_2.9236";   arrWert [5][25] = "1.031_4.2921";      arrWert [6][25] = "1.274_7.9631";
        arrWert [4][26] = "1.153_3.0591";   arrWert [5][26] = "1.032_4.4681";      arrWert [6][26] = "1.285_8.3531";
        arrWert [4][27] = "1.160_3.1961";   arrWert [5][27] = "1.033_4.6445";      arrWert [6][27] = "1.296_8.7486";
        arrWert [4][28] = "1.166_3.3316";   arrWert [5][28] = "1.035_4.8258";      arrWert [6][28] = "1.306_9.1427";
        arrWert [4][29] = "1.174_3.4743";   arrWert [5][29] = "1.036_5.0030";      arrWert [6][29] = "1.317_9.5489";
        arrWert [4][30] = "1.181_3.6155";   arrWert [5][30] = "1.037_5.1805";      arrWert [6][30] = "1.328_9.9607";
        arrWert [4][31] = "1.187_3.7550";   arrWert [5][31] = "1.038_5.3584";      arrWert [6][31] = "1.339_10.3780";
        arrWert [4][32] = "1.194_3.8990";   arrWert [5][32] = "1.039_5.5365";      arrWert [6][32] = "1.349_10.7928";
        arrWert [4][33] = "1.201_4.0444";   arrWert [5][33] = "1.040_5.7150";      arrWert [6][33] = "1.359_11.2126";
        arrWert [4][34] = "1.209_4.1947";   arrWert [5][34] = "1.041_5.8939";      arrWert [6][34] = "1.370_11.6458";
        arrWert [4][35] = "1.216_4.3431";   arrWert [5][35] = "1.042_6.0731";      arrWert [6][35] = "1.380_12.0759";
        arrWert [4][36] = "1.224_4.4965";   arrWert [5][36] = "1.043_6.2526";      arrWert [6][36] = "1.390_12.5109";
        arrWert [4][37] = "1.231_4.6479";   arrWert [5][37] = "1.044_6.4324";      arrWert [6][37] = "1.400_12.9509";
        arrWert [4][38] = "1.239_4.8045";   arrWert [5][38] = "1.045_6.6126";      arrWert [6][38] = "1.410_13.3960";
        arrWert [4][39] = "1.246_4.9588";   arrWert [5][39] = "1.046_6.7931";      arrWert [6][39] = "1.420_13.8460";
        arrWert [4][40] = "1.254_5.1186";   arrWert [5][40] = "1.047_6.9740";      arrWert [6][40] = "1.430_14.3010";
        arrWert [4][41] = "1.262_5.2801";   arrWert [5][41] = "1.048_7.1551";      arrWert [6][41] = "1.440_14.7611";
        arrWert [4][42] = "1.270_5.4431";   arrWert [5][42] = "1.049_7.3366";      arrWert [6][42] = "1.449_15.2156";
        arrWert [4][43] = "1.277_5.6034";   arrWert [5][43] = "1.050_7.5185";      arrWert [6][43] = "1.459_15.6854";
        arrWert [4][44] = "1.285_5.7697";   arrWert [5][44] = "1.051_7.7007";      arrWert [6][44] = "1.469_16.1602";
        arrWert [4][45] = "1.293_5.9375";   arrWert [5][45] = "1.051_7.8757";      arrWert [6][45] = "1.478_16.6287";
        arrWert [4][46] = "1.301_6.1070";   arrWert [5][46] = "1.052_8.0583";      arrWert [6][46] = "1.488_17.1132";
        arrWert [4][47] = "1.310_6.2830";   arrWert [5][47] = "1.053_8.2414";      arrWert [6][47] = "1.497_17.5910";
        arrWert [4][48] = "1.318_6.4558";   arrWert [5][48] = "1.054_8.4247";      arrWert [6][48] = "1.507_18.0853";
        arrWert [4][49] = "1.327_6.6353";   arrWert [5][49] = "1.055_8.6084";      arrWert [6][49] = "1.516_18.5723";
        arrWert [4][50] = "1.335_6.8116";   arrWert [5][50] = "1.056_8.7924";      arrWert [6][50] = "1.526_19.0764";
        arrWert [4][51] = "1.344_6.9946";   arrWert [5][51] = "1.056_8.9682";      arrWert [6][51] = "1.535_19.5727";
        arrWert [4][52] = "1.353_7.1795";   arrWert [5][52] = "1.057_9.1527";      arrWert [6][52] = "1.545_20.0865";
        arrWert [4][53] = "1.362_7.3663";   arrWert [5][53] = "1.058_9.3376";      arrWert [6][53] = "1.555_20.6052";
        arrWert [4][54] = "1.371_7.5549";   arrWert [5][54] = "1.058_9.5138";      arrWert [6][54] = "1.565_21.1290";
        arrWert [4][55] = "1.379_7.7397";   arrWert [5][55] = "1.059_9.6991";      arrWert [6][55] = "0_0";
        arrWert [4][56] = "1.389_7.9375";   arrWert [5][56] = "1.060_9.8848";      arrWert [6][56] = "0_0";
        arrWert [4][57] = "1.398_8.1316";   arrWert [5][57] = "1.061_10.0708";     arrWert [6][57] = "0_0";
        arrWert [4][58] = "1.408_8.3335";   arrWert [5][58] = "1.061_10.2475";     arrWert [6][58] = "0_0";
        arrWert [4][59] = "1.417_8.5313";   arrWert [5][59] = "1.062_10.4340";     arrWert [6][59] = "0_0";
        arrWert [4][60] = "1.426_8.7310";   arrWert [5][60] = "1.063_10.6208";     arrWert [6][60] = "0_0";
        arrWert [4][61] = "1.436_8.9388";   arrWert [5][61] = "1.063_10.7978";     arrWert [6][61] = "0_0";
        arrWert [4][62] = "1.446_9.1486";   arrWert [5][62] = "1.064_10.9851";     arrWert [6][62] = "0_0";
        arrWert [4][63] = "1.456_9.3605";   arrWert [5][63] = "1.064_11.1623";     arrWert [6][63] = "0_0";
        arrWert [4][64] = "1.466_9.5743";   arrWert [5][64] = "1.065_11.3502";     arrWert [6][64] = "0_0";
        arrWert [4][65] = "1.476_9.7903";   arrWert [5][65] = "1.065_11.5275";     arrWert [6][65] = "0_0";
        arrWert [4][66] = "1.486_10.0082";  arrWert [5][66] = "1.066_11.8934";     arrWert [6][66] = "0_0";
        arrWert [4][67] = "1.497_10.2351";  arrWert [5][67] = "1.066_11.8934";     arrWert [6][67] = "0_0";
        arrWert [4][68] = "1.506_10.4503";  arrWert [5][68] = "1.066_12.0709";     arrWert [6][68] = "0_0";
        arrWert [4][69] = "1.516_10.6744";  arrWert [5][69] = "1.067_12.2599";     arrWert [6][69] = "0_0";
        arrWert [4][70] = "1.526_10.9005";  arrWert [5][70] = "1.067_12.4376";     arrWert [6][70] = "0_0";
        arrWert [4][71] = "1.537_11.1360";  arrWert [5][71] = "1.067_12.6152";     arrWert [6][71] = "0_0";
        arrWert [4][72] = "1.547_11.3663";  arrWert [5][72] = "1.067_12.7929";     arrWert [6][72] = "0_0";
        arrWert [4][73] = "1.558_11.6061";  arrWert [5][73] = "1.067_12.9706";     arrWert [6][73] = "0_0";
        arrWert [4][74] = "1.568_11.8406";  arrWert [5][74] = "1.067_13.1483";     arrWert [6][74] = "0_0";
        arrWert [4][75] = "1.579_12.0848";  arrWert [5][75] = "1.067_13.3260";     arrWert [6][75] = "0_0";
        arrWert [4][76] = "1.589_12.3235";  arrWert [5][76] = "1.067_13.5036";     arrWert [6][76] = "0_0";
        arrWert [4][77] = "1.600_12.5720";  arrWert [5][77] = "1.068_13.6941";     arrWert [6][77] = "0_0";
        arrWert [4][78] = "1.612_12.8308";  arrWert [5][78] = "1.068_13.8720";     arrWert [6][78] = "0_0";
        arrWert [4][79] = "1.622_13.0759";  arrWert [5][79] = "1.068_14.0498";     arrWert [6][79] = "0_0";
        arrWert [4][80] = "1.633_13.3313";  arrWert [5][80] = "1.068_14.2277";     arrWert [6][80] = "0_0";
        arrWert [4][81] = "1.644_13.5888";  arrWert [5][81] = "1.069_14.4190";     arrWert [6][81] = "0_0";
        arrWert [4][82] = "1.655_13.8486";  arrWert [5][82] = "1.068_14.5834";     arrWert [6][82] = "0_0";
        arrWert [4][83] = "1.667_14.1192";  arrWert [5][83] = "1.068_14.7612";     arrWert [6][83] = "0_0";
        arrWert [4][84] = "1.678_14.3836";  arrWert [5][84] = "1.067_14.9251";     arrWert [6][84] = "0_0";
        arrWert [4][85] = "1.689_14.6502";  arrWert [5][85] = "1.067_15.1027";     arrWert [6][85] = "0_0";
        arrWert [4][86] = "1.700_14.9191";  arrWert [5][86] = "1.066_15.2661";     arrWert [6][86] = "0_0";
        arrWert [4][87] = "1.712_15.1991";  arrWert [5][87] = "1.066_15.4436";     arrWert [6][87] = "0_0";
        arrWert [4][88] = "1.723_15.4726";  arrWert [5][88] = "1.065_15.6065";     arrWert [6][88] = "0_0";
        arrWert [4][89] = "1.735_15.7574";  arrWert [5][89] = "1.065_15.7838";     arrWert [6][89] = "0_0";
        arrWert [4][90] = "1.746_16.0355";  arrWert [5][90] = "1.064_15.9462";     arrWert [6][90] = "0_0";
        arrWert [4][91] = "1.758_16.3251";  arrWert [5][91] = "1.064_16.1234";     arrWert [6][91] = "0_0";
        arrWert [4][92] = "1.770_16.6171";  arrWert [5][92] = "1.063_16.2852";     arrWert [6][92] = "0_0";
        arrWert [4][93] = "1.783_16.9211";  arrWert [5][93] = "1.062_16.4467";     arrWert [6][93] = "0_0";
        arrWert [4][94] = "1.794_17.2086";  arrWert [5][94] = "1.061_16.6079";     arrWert [6][94] = "0_0";
        arrWert [4][95] = "1.807_17.5177";  arrWert [5][95] = "1.060_16.7688";     arrWert [6][95] = "0_0";
        arrWert [4][96] = "1.819_17.8196";  arrWert [5][96] = "1.058_16.9133";     arrWert [6][96] = "0_0";
        arrWert [4][97] = "1.832_18.1339";  arrWert [5][97] = "1.056_17.0572";     arrWert [6][97] = "0_0";
        arrWert [4][98] = "1.844_18.4409";  arrWert [5][98] = "1.054_17.2004";     arrWert [6][98] = "0_0";
        arrWert [4][99] = "1.857_18.7604";  arrWert [5][99] = "1.051_17.3265";     arrWert [6][99] = "0_0";
        arrWert [4][100]= "1.870_19.0826";  arrWert [5][100]= "1.048_17.4515";     arrWert [6][100]= "0_0";
        arrWert [4][101]= "Phosphorsäure";  arrWert [5][101]= "Essigsäure";        arrWert [6][101]= "Natronlauge";

        // Kontrolle der Eingaben!

        arrWert [7][0]  = "1_0";            arrWert [8][0]  = "1_0";               arrWert [9][0]  = "1_0";
        arrWert [7][1]  = "1.003_0.2949";   arrWert [8][1]  = "1.007_0.1795";      arrWert [9][1]  = "0.994_0.5837";
        arrWert [7][2]  = "1.006_0.5915";   arrWert [8][2]  = "1.016_0.3622";      arrWert [9][2]  = "0.990_1.1626";
        arrWert [7][3]  = "1.010_0.8908";   arrWert [8][3]  = "1.024_0.5475";      arrWert [9][3]  = "0.985_1.7351";
        arrWert [7][4]  = "1.013_1.1912";   arrWert [8][4]  = "1.033_0.7365";      arrWert [9][4]  = "0.981_2.3041";
        arrWert [7][5]  = "1.017_1.4949";   arrWert [8][5]  = "1.042_0.9286";      arrWert [9][5]  = "0.977_2.8684";
        arrWert [7][6]  = "1.020_1.7992";   arrWert [8][6]  = "1.051_1.1240";      arrWert [9][6]  = "0.973_3.4280";
        arrWert [7][7]  = "1.024_2.1073";   arrWert [8][7]  = "1.060_1.3225";      arrWert [9][7]  = "0.969_3.9829";
        arrWert [7][8]  = "1.028_2.4178";   arrWert [8][8]  = "1.069_1.5243";      arrWert [9][8]  = "0.965_4.5330";
        arrWert [7][9]  = "1.031_2.7279";   arrWert [8][9]  = "1.078_1.7292";      arrWert [9][9]  = "0.961_5.0785";
        arrWert [7][10] = "1.035_3.0428";   arrWert [8][10] = "1.087_1.9374";      arrWert [9][10] = "0.957_5.6193";
        arrWert [7][11] = "1.039_3.3600";   arrWert [8][11] = "1.097_2.1508";      arrWert [9][11] = "0.954_6.1619";
        arrWert [7][12] = "1.042_3.6761";   arrWert [8][12] = "1.106_2.3655";      arrWert [9][12] = "0.950_6.6939";
        arrWert [7][13] = "1.046_3.9977";   arrWert [8][13] = "1.115_2.5835";      arrWert [9][13] = "0.946_7.2212";
        arrWert [7][14] = "1.050_4.3217";   arrWert [8][14] = "1.125_2.8072";      arrWert [9][14] = "0.943_7.7520";
        arrWert [7][15] = "1.054_4.6480";   arrWert [8][15] = "1.134_3.0318";      arrWert [9][15] = "0.940_8.2793";
        arrWert [7][16] = "1.057_4.9720";   arrWert [8][16] = "1.144_3.2624";      arrWert [9][16] = "0.936_8.7936";
        arrWert [7][17] = "1.061_5.3027";   arrWert [8][17] = "1.153_3.4936";      arrWert [9][17] = "0.933_9.3133";
        arrWert [7][18] = "1.065_5.6358";   arrWert [8][18] = "1.163_3.7312";      arrWert [9][18] = "0.930_9.8294";
        arrWert [7][19] = "1.069_5.9712";   arrWert [8][19] = "1.172_3.9689";      arrWert [9][19] = "0.926_10.3309";
        arrWert [7][20] = "1.073_6.3090";   arrWert [8][20] = "1.182_4.2135";      arrWert [9][20] = "0.923_10.8394";
        arrWert [7][21] = "1.076_6.6430";   arrWert [8][21] = "1.192_4.4616";      arrWert [9][21] = "0.919_11.3320";
        arrWert [7][22] = "1.080_6.9852";   arrWert [8][22] = "1.201_4.7093";      arrWert [9][22] = "0.916_11.8329";
        arrWert [7][23] = "1.084_7.3298";   arrWert [8][23] = "1.211_4.9644";      arrWert [9][23] = "0.913_12.3302";
        arrWert [7][24] = "1.088_7.6767";   arrWert [8][24] = "1.221_5.4852";      arrWert [9][24] = "0.910_12.8241";
        arrWert [7][25] = "1.092_8.0259";   arrWert [8][25] = "1.231_5.7509";      arrWert [9][25] = "0.907_13.3143";
        arrWert [7][26] = "1.096_8.3776";   arrWert [8][26] = "1.241_6.0203";      arrWert [9][26] = "0.904_13.8011";
        arrWert [7][27] = "1.100_8.7315";   arrWert [8][27] = "1.251_6.2931";      arrWert [9][27] = "0.901_14.2844";
        arrWert [7][28] = "1.104_9.0878";   arrWert [8][28] = "1.261_6.2931";      arrWert [9][28] = "0.898_14.7641";
        arrWert [7][29] = "1.108_9.4465";   arrWert [8][29] = "1.271_6.5696";      arrWert [9][29] = "0.895_15.2403";
        arrWert [7][30] = "1.112_9.8075";   arrWert [8][30] = "1.281_6.8496";      arrWert [9][30] = "0.892_15.7130";
        arrWert [7][31] = "1.116_10.9047";  arrWert [8][31] = "1.292_7.1387";      arrWert [9][31] = "0.889_16.1821";
        arrWert [7][32] = "1.120_10.5366";  arrWert [8][32] = "1.302_7.4260";      arrWert [9][32] = "0.886_16.6478";
        arrWert [7][33] = "1.124_10.9047";  arrWert [8][33] = "1.313_7.7228";      arrWert [9][33] = "0.883_17.1099";
        arrWert [7][34] = "1.128_11.2751";  arrWert [8][34] = "1.323_8.0174";      arrWert [9][34] = "0.881_17.5884";
        arrWert [7][35] = "1.132_11.6479";  arrWert [8][35] = "1.334_8.3218";      arrWert [9][35] = "0_0";
        arrWert [7][36] = "1.136_12.0230";  arrWert [8][36] = "1.344_8.6237";      arrWert [9][36] = "0_0";
        arrWert [7][37] = "1.140_12.4005";  arrWert [8][37] = "1.355_8.9358";      arrWert [9][37] = "0_0";
        arrWert [7][38] = "1.145_12.7915";  arrWert [8][38] = "1.366_9.2518";      arrWert [9][38] = "0_0";
        arrWert [7][39] = "1.149_13.1740";  arrWert [8][39] = "1.377_9.5718";      arrWert [9][39] = "0_0";
        arrWert [7][40] = "1.153_13.5588";  arrWert [8][40] = "1.388_9.8956";      arrWert [9][40] = "0_0";
        arrWert [7][41] = "1.157_13.9460";  arrWert [8][41] = "1.399_10.2234";     arrWert [9][41] = "0_0";
        arrWert [7][42] = "1.161_14.3356";  arrWert [8][42] = "1.410_10.5551";     arrWert [9][42] = "0_0";
        arrWert [7][43] = "1.166_14.7401";  arrWert [8][43] = "1.422_10.8984";     arrWert [9][43] = "0_0";
        arrWert [7][44] = "1.170_15.1346";  arrWert [8][44] = "1.433_11.2381";     arrWert [9][44] = "0_0";
        arrWert [7][45] = "1.174_15.5315";  arrWert [8][45] = "1.445_11.5898";     arrWert [9][45] = "0_0";
        arrWert [7][46] = "1.179_15.9443";  arrWert [8][46] = "1.456_11.9375";     arrWert [9][46] = "0_0";
        arrWert [7][47] = "1.183_16.3462";  arrWert [8][47] = "1.468_12.2975";     arrWert [9][47] = "0_0";
        arrWert [7][48] = "1.187_16.7504";  arrWert [8][48] = "1.479_12.6533";     arrWert [9][48] = "0_0";
        arrWert [7][49] = "1.192_17.1714";  arrWert [8][49] = "1.491_13.0217";     arrWert [9][49] = "0_0";
        arrWert [7][50] = "1.196_17.5806";  arrWert [8][50] = "1.503_13.3944";     arrWert [9][50] = "0_0";
        arrWert [7][51] = "1.201_18.0072";  arrWert [8][51] = "1.514_13.7623";     arrWert [9][51] = "0_0";
        arrWert [7][52] = "1.205_18.4214";  arrWert [8][52] = "1.527_14.1526";     arrWert [9][52] = "0_0";
        arrWert [7][53] = "1.210_18.8536";  arrWert [8][53] = "0_0";               arrWert [9][53] = "0_0";
        arrWert [7][54] = "1.214_19.2728";  arrWert [8][54] = "0_0";               arrWert [9][54] = "0_0";
        arrWert [7][55] = "1.219_19.7106";  arrWert [8][55] = "0_0";               arrWert [9][55] = "0_0";
        arrWert [7][56] = "1.223_20.1348";  arrWert [8][56] = "0_0";               arrWert [9][56] = "0_0";
        arrWert [7][57] = "1.228_20.5782";  arrWert [8][57] = "0_0";               arrWert [9][57] = "0_0";
        arrWert [7][58] = "1.232_21.0074";  arrWert [8][58] = "0_0";               arrWert [9][58] = "0_0";
        arrWert [7][59] = "1.237_21.4563";  arrWert [8][59] = "0_0";               arrWert [9][59] = "0_0";
        arrWert [7][60] = "1.242_21.9082";  arrWert [8][60] = "0_0";               arrWert [9][60] = "0_0";
        arrWert [7][61] = "1.247_22.3630";  arrWert [8][61] = "0_0";               arrWert [9][61] = "0_0";
        arrWert [7][62] = "1.251_22.8025";  arrWert [8][62] = "0_0";               arrWert [9][62] = "0_0";
        arrWert [7][63] = "1.256_23_2629";  arrWert [8][63] = "0_0";               arrWert [9][63] = "0_0";
        arrWert [7][64] = "1.261_23.7262";  arrWert [8][64] = "0_0";               arrWert [9][64] = "0_0";
        arrWert [7][65] = "1.266_24.1925";  arrWert [8][65] = "0_0";               arrWert [9][65] = "0_0";
        arrWert [7][66] = "1.270_24.6423";  arrWert [8][66] = "0_0";               arrWert [9][66] = "0_0";
        arrWert [7][67] = "1.275_25.1141";  arrWert [8][67] = "0_0";               arrWert [9][67] = "0_0";
        arrWert [7][68] = "1.280_25.5889";  arrWert [8][68] = "0_0";               arrWert [9][68] = "0_0";
        arrWert [7][69] = "1.285_26.0667";  arrWert [8][69] = "0_0";               arrWert [9][69] = "0_0";
        arrWert [7][70] = "1.290_26.5473";  arrWert [8][70] = "0_0";               arrWert [9][70] = "0_0";
        arrWert [7][71] = "1.295_27.0310";  arrWert [8][71] = "0_0";               arrWert [9][71] = "0_0";
        arrWert [7][72] = "1.300_27.5175";  arrWert [8][72] = "0_0";               arrWert [9][72] = "0_0";
        arrWert [7][73] = "1.305_28.0070";  arrWert [8][73] = "0_0";               arrWert [9][73] = "0_0";
        arrWert [7][74] = "1.310_28.4994";  arrWert [8][74] = "0_0";               arrWert [9][74] = "0_0";
        arrWert [7][75] = "1.315_28.9948";  arrWert [8][75] = "0_0";               arrWert [9][75] = "0_0";
        arrWert [7][76] = "1.320_29.4931";  arrWert [8][76] = "0_0";               arrWert [9][76] = "0_0";
        arrWert [7][77] = "1.325_29.9944";  arrWert [8][77] = "0_0";               arrWert [9][77] = "0_0";
        arrWert [7][78] = "1.331_30.5215";  arrWert [8][78] = "0_0";               arrWert [9][78] = "0_0";
        arrWert [7][79] = "1.336_31.0289";  arrWert [8][79] = "0_0";               arrWert [9][79] = "0_0";
        arrWert [7][80] = "1.341_31.5393";  arrWert [8][80] = "0_0";               arrWert [9][80] = "0_0";
        arrWert [7][81] = "1.346_32.0526";  arrWert [8][81] = "0_0";               arrWert [9][81] = "0_0";
        arrWert [7][82] = "1.351_32.5689";  arrWert [8][82] = "0_0";               arrWert [9][82] = "0_0";
        arrWert [7][83] = "1.357_33.1124";  arrWert [8][83] = "0_0";               arrWert [9][83] = "0_0";
        arrWert [7][84] = "1.362_33.6349";  arrWert [8][84] = "0_0";               arrWert [9][84] = "0_0";
        arrWert [7][85] = "1.368_34.1852";  arrWert [8][85] = "0_0";               arrWert [9][85] = "0_0";
        arrWert [7][86] = "1.373_34.7138";  arrWert [8][86] = "0_0";               arrWert [9][86] = "0_0";
        arrWert [7][87] = "1.378_35.2453";  arrWert [8][87] = "0_0";               arrWert [9][87] = "0_0";
        arrWert [7][88] = "1.384_35.8057";  arrWert [8][88] = "0_0";               arrWert [9][88] = "0_0";
        arrWert [7][89] = "1.389_36.3434";  arrWert [8][89] = "0_0";               arrWert [9][89] = "0_0";
        arrWert [7][90] = "1.395_36.9105";  arrWert [8][90] = "0_0";               arrWert [9][90] = "0_0";
        arrWert [7][91] = "1.400_37.4544";  arrWert [8][91] = "0_0";               arrWert [9][91] = "0_0";
        arrWert [7][92] = "1.406_38.0283";  arrWert [8][92] = "0_0";               arrWert [9][92] = "0_0";
        arrWert [7][93] = "1.412_38.6057";  arrWert [8][93] = "0_0";               arrWert [9][93] = "0_0";
        arrWert [7][94] = "1.417_39.1590";  arrWert [8][94] = "0_0";               arrWert [9][94] = "0_0";
        arrWert [7][95] = "1.423_39.7431";  arrWert [8][95] = "0_0";               arrWert [9][95] = "0_0";
        arrWert [7][96] = "1.429_40.3308";  arrWert [8][96] = "0_0";               arrWert [9][96] = "0_0";
        arrWert [7][97] = "1.435_40.9220";  arrWert [8][97] = "0_0";               arrWert [9][97] = "0_0";
        arrWert [7][98] = "1.440_41.4879";  arrWert [8][98] = "0_0";               arrWert [9][98] = "0_0";
        arrWert [7][99] = "1.446_42.0859";  arrWert [8][99] = "0_0";               arrWert [9][99] = "0_0";
        arrWert [7][100]= "1.452_42.6874";  arrWert [8][100]= "0_0";               arrWert [9][100]= "0_0";
        arrWert [7][101]= "Wasserstoffperoxid";arrWert [8][101]= "Kalilauge";      arrWert [9][101]= "Ammoniaklösung";

        // Kontrolle der Eingaben!


        for (intAuswahl=1; intAuswahl<=9; intAuswahl++)
        {
            if (arrWert[intAuswahl][101].equals(strKonzAuswahl) == true)    // Hier wird die entspechende Tabelle (Salzsäure etc) ausgewählt
            {
                for (intProzent = 0; intProzent <= 100; intProzent++)
                {
                    if (intStop == 0)
                    {
                        splitResult = arrWert[intAuswahl][intProzent].split("_"); // splitt funktioniert nicht mit Punkt .

                        if (dblKonzGehalt != 0) // Wenn der Gehalt berechnet werden soll Routine 5 oder 6
                        {
                            dblVerdDichte = Double.parseDouble(splitResult[0]);

                            if(strVerdGehaltEinheit.equals("%") == true)                // wenn die Einheit % ist
                            {
                                dblVerdGehalt1 = (double) intProzent;                    // dblVerdGehalt = % Wert
                                dblVerdGehalt2 = (dblKonzGehalt * dblKonzMenge) / (dblVerdMenge * dblVerdDichte);// % wird berechnet

                            }
                            else                                                        // wenn die Einheit mol/l ist
                            {
                                dblVerdGehalt1 = Double.parseDouble(splitResult[1]);     // dblVerdGehalt = mol/l Wert
                                dblVerdGehalt2 = (dblKonzGehalt * dblKonzMenge) / (dblVerdMenge / dblVerdDichte);// mol/l wird berechnet           // Volumen wird berechnet
                            }

                            if (dblVerdGehalt1 > dblVerdGehalt2)
                            {
                                dblObereDichte = dblVerdDichte;
                                dblObererGehalt = dblVerdGehalt1;
                                intObererGehalt = fktvomDoublezumInt(dblVerdGehalt1, 100000);
                                intStop = 1;

                                for (intGehalt = intUntererGehalt; intGehalt <= intObererGehalt; intGehalt++)
                                {
                                    dblGehalt = intGehalt; // aktueller Gehalt

                                    dblGehalt = dblGehalt / 100000;

                                    dblVerdMenge1 = (dblKonzGehalt * dblKonzMenge) / dblGehalt;

                                    if (strVerdGehaltEinheit.equals("%") == true)
                                    {
                                        dblVerdDichte2 = dblVerdMenge1 / dblVerdMenge;  // dblVerdMenge1 = Masse

                                        // Interpolation
                                        dblVerdDichte1 = dblUntereDichte + (((dblObereDichte - dblUntereDichte) / (dblObererGehalt - dblUntererGehalt)) * (dblGehalt - dblUntererGehalt));

                                        if((dblVerdDichte1 > dblVerdDichte2) && (intStop == 1))
                                        {
                                            dblVerdDichte = dblVerdDichte1;
                                            intStop = 2;
                                        }
                                    }
                                    else
                                    {
                                        dblVerdDichte2 = dblVerdMenge / dblVerdMenge1;  // dblVerdMenge1 = Volumen

                                        // Interpolation
                                        dblVerdDichte1 = dblUntereDichte + (((dblObereDichte - dblUntereDichte) / (dblObererGehalt - dblUntererGehalt)) * (dblGehalt - dblUntererGehalt));

                                        if((dblVerdDichte1 < dblVerdDichte2) && (intStop == 1))
                                        {
                                            dblVerdDichte = dblVerdDichte1;
                                            intStop = 2;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                dblUntereDichte = dblVerdDichte;
                                dblUntererGehalt = dblVerdGehalt1;
                                intUntererGehalt = fktvomDoublezumInt(dblVerdGehalt1, 100000);
                            }
                        }
                        else                                // Wenn der Gehalt bekannt ist: Routine 1 bis 4
                        {
                            // intProzent Schleife von 0 bis 100

                            if (strVerdGehaltEinheit.equals("%") == true)                   // wenn die Einheit der Verdünnung % ist
                            {
                                dblGehalt = (double) intProzent; // aktueller Gehalt
                            }
                            else
                            {
                                dblGehalt = Double.parseDouble(splitResult[1]);
                            }


                            dblVerdGehalt = Double.parseDouble(strVerdGehalt);

                            if (dblGehalt >= dblVerdGehalt)
                            {
                                dblObererGehalt  = dblGehalt;               // oberer Gehalt
                                dblObereDichte = Double.parseDouble(splitResult[0]);
                                // Interpolation
                                dblVerdDichte = dblUntereDichte + (((dblObereDichte - dblUntereDichte) / (dblObererGehalt - dblUntererGehalt)) * (dblVerdGehalt - dblUntererGehalt));
                                intStop = 1;
                            }
                            else
                            {
                                dblUntererGehalt = dblGehalt;               // unterer Gehalt
                                dblUntereDichte = Double.parseDouble(splitResult[0]);
                            }
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

