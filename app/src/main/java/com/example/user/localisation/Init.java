package com.example.user.localisation;

import java.util.HashMap;

/**
 * Created by USER on 03/03/2016.
 */
public class Init {
    public static void Initialiser(HashMap<String, Stand> StandMap, HashMap<String, Node> BeaconMap/*, HashMap standnodes, HashMap beaconnodes*/){


        MainActivity.n1 = new Node(128,35,10);
        MainActivity.n2 = new Node(270, 35, 10);
        MainActivity.n3 = new Node(384, 35, 10);
        MainActivity.n4 = new Node(479,35, 10);
        MainActivity.n5 = new Node(613,35, 10);
        MainActivity.n6 = new Node(718,35, 10);
        MainActivity.n7 = new Node(801,35, 10);
        MainActivity.n8 = new Node(890,35, 10);
        MainActivity.n9 = new Node(128,110, 10);
        MainActivity.n10 = new Node(384,110, 10);
        MainActivity.n11 = new Node(718,110, 10);
        MainActivity.n12 = new Node(890,114, 10);
        MainActivity.n13 = new Node(128,195, 10);
        MainActivity.n14 = new Node(211,195, 10);
        MainActivity.n15 = new Node(314,195, 10);
        MainActivity.n16 = new Node(384,195, 10);
        MainActivity.n17 = new Node(438,195, 10);
        MainActivity.n18 = new Node(556,195, 10);
        MainActivity.n19 = new Node(666,195, 10);
        MainActivity.n20 = new Node(718,195, 10);
        MainActivity.n21 = new Node(808,195, 10);
        MainActivity.n22 = new Node(890,195, 10);
        MainActivity.n23 = new Node(1013,195, 10);
        MainActivity.n24 = new Node(1065,195, 10);
        MainActivity.n25 = new Node(128,275, 10);
        MainActivity.n26 = new Node(384,275, 10);
        MainActivity.n27 = new Node(718,278, 10);
        MainActivity.n28 = new Node(1013,250, 10);
        MainActivity.n29 = new Node(128,356, 10);
        MainActivity.n30 = new Node(222,356, 10);
        MainActivity.n31 = new Node(384,356, 10);
        MainActivity.n32 = new Node(440,397, 10);
        MainActivity.n33 = new Node(544,397, 10);
        MainActivity.n34 = new Node(602,397, 10);
        MainActivity.n35 = new Node(672,397, 10);
        MainActivity.n36 = new Node(718,397, 10);
        MainActivity.n37 = new Node(718,357, 10);
        MainActivity.n38 = new Node(787,357, 10);
        MainActivity.n39 = new Node(850,357, 10);
        MainActivity.n40 = new Node(936,357, 10);
        MainActivity.n41 = new Node(1013,357, 10);
        MainActivity.n42 = new Node(321,356, 10);
        MainActivity.n43 = new Node(128,417, 10);
        MainActivity.n44 = new Node(384,397, 10);
        MainActivity.n45 = new Node(128,473, 10);
        MainActivity.n46 = new Node(275,473, 10);
        MainActivity.n47 = new Node(384,473, 10);
        MainActivity.n48 = new Node(544,473, 10);
        MainActivity.n49 = new Node(718,473, 10);
        MainActivity.n50 = new Node(1013,408, 10);
        MainActivity.n51 = new Node(1013,470, 10);
        MainActivity.n52 = new Node(384,558, 10);
        MainActivity.n53 = new Node(465,558, 10);
        MainActivity.n54 = new Node(544,558, 10);
        MainActivity.n55 = new Node(640,558, 10);
        MainActivity.n56 = new Node(718,558, 10);
        MainActivity.n57 = new Node(844,558, 10);
        MainActivity.n58 = new Node(718,514, 10);
        MainActivity.n59 = new Node(800,514, 10);
        MainActivity.n60 = new Node(844,514, 10);
        MainActivity.n61 = new Node(895,514, 10);
        MainActivity.n62 = new Node(1013,514, 10);


        MainActivity.n1.neighbors.add(MainActivity.n2);
        MainActivity.n1.neighbors.add(MainActivity.n9);

        MainActivity.n2.neighbors.add(MainActivity.n1);
        MainActivity.n2.neighbors.add(MainActivity.n3);

        MainActivity.n3.neighbors.add(MainActivity.n2);
        MainActivity.n3.neighbors.add(MainActivity.n4);
        MainActivity.n3.neighbors.add(MainActivity.n10);

        MainActivity.n4.neighbors.add(MainActivity.n3);
        MainActivity.n4.neighbors.add(MainActivity.n5);

        MainActivity.n5.neighbors.add(MainActivity.n4);
        MainActivity.n5.neighbors.add(MainActivity.n6);

        MainActivity.n6.neighbors.add(MainActivity.n5);
        MainActivity.n6.neighbors.add(MainActivity.n7);
        MainActivity.n6.neighbors.add(MainActivity.n11);

        MainActivity.n7.neighbors.add(MainActivity.n6);
        MainActivity.n7.neighbors.add(MainActivity.n8);

        MainActivity.n8.neighbors.add(MainActivity.n7);
        MainActivity.n8.neighbors.add(MainActivity.n12);

        MainActivity.n9.neighbors.add(MainActivity.n1);
        MainActivity.n9.neighbors.add(MainActivity.n13);

        MainActivity.n10.neighbors.add(MainActivity.n3);
        MainActivity.n10.neighbors.add(MainActivity.n16);

        MainActivity.n11.neighbors.add(MainActivity.n6);
        MainActivity.n11.neighbors.add(MainActivity.n20);

        MainActivity.n12.neighbors.add(MainActivity.n8);
        MainActivity.n12.neighbors.add(MainActivity.n22);

        MainActivity.n13.neighbors.add(MainActivity.n9);
        MainActivity.n13.neighbors.add(MainActivity.n14);
        MainActivity.n13.neighbors.add(MainActivity.n25);

        MainActivity.n14.neighbors.add(MainActivity.n13);
        MainActivity.n14.neighbors.add(MainActivity.n15);

        MainActivity.n15.neighbors.add(MainActivity.n14);
        MainActivity.n15.neighbors.add(MainActivity.n16);

        MainActivity.n16.neighbors.add(MainActivity.n10);
        MainActivity.n16.neighbors.add(MainActivity.n15);
        MainActivity.n16.neighbors.add(MainActivity.n17);
        MainActivity.n16.neighbors.add(MainActivity.n26);

        MainActivity.n17.neighbors.add(MainActivity.n16);
        MainActivity.n17.neighbors.add(MainActivity.n18);

        MainActivity.n18.neighbors.add(MainActivity.n17);
        MainActivity.n18.neighbors.add(MainActivity.n19);

        MainActivity.n19.neighbors.add(MainActivity.n18);
        MainActivity.n19.neighbors.add(MainActivity.n20);

        MainActivity.n20.neighbors.add(MainActivity.n11);
        MainActivity.n20.neighbors.add(MainActivity.n19);
        MainActivity.n20.neighbors.add(MainActivity.n21);
        MainActivity.n20.neighbors.add(MainActivity.n27);

        MainActivity.n21.neighbors.add(MainActivity.n20);
        MainActivity.n21.neighbors.add(MainActivity.n22);

        MainActivity.n22.neighbors.add(MainActivity.n12);
        MainActivity.n22.neighbors.add(MainActivity.n21);
        MainActivity.n22.neighbors.add(MainActivity.n23);

        MainActivity.n23.neighbors.add(MainActivity.n22);
        MainActivity.n23.neighbors.add(MainActivity.n24);
        MainActivity.n23.neighbors.add(MainActivity.n28);

        MainActivity.n24.neighbors.add(MainActivity.n23);

        MainActivity.n25.neighbors.add(MainActivity.n13);
        MainActivity.n25.neighbors.add(MainActivity.n29);

        MainActivity.n26.neighbors.add(MainActivity.n16);
        MainActivity.n26.neighbors.add(MainActivity.n31);

        MainActivity.n27.neighbors.add(MainActivity.n20);
        MainActivity.n27.neighbors.add(MainActivity.n37);

        MainActivity.n28.neighbors.add(MainActivity.n23);
        MainActivity.n28.neighbors.add(MainActivity.n41);

        MainActivity.n29.neighbors.add(MainActivity.n25);
        MainActivity.n29.neighbors.add(MainActivity.n30);
        MainActivity.n29.neighbors.add(MainActivity.n43);

        MainActivity.n30.neighbors.add(MainActivity.n29);
        MainActivity.n30.neighbors.add(MainActivity.n42);

        MainActivity.n31.neighbors.add(MainActivity.n26);
        MainActivity.n31.neighbors.add(MainActivity.n42);
        MainActivity.n31.neighbors.add(MainActivity.n44);

        MainActivity.n32.neighbors.add(MainActivity.n44);
        MainActivity.n32.neighbors.add(MainActivity.n33);

        MainActivity.n33.neighbors.add(MainActivity.n32);
        MainActivity.n33.neighbors.add(MainActivity.n34);
        MainActivity.n33.neighbors.add(MainActivity.n48);

        MainActivity.n34.neighbors.add(MainActivity.n33);
        MainActivity.n34.neighbors.add(MainActivity.n35);

        MainActivity.n35.neighbors.add(MainActivity.n34);
        MainActivity.n35.neighbors.add(MainActivity.n36);

        MainActivity.n36.neighbors.add(MainActivity.n35);
        MainActivity.n36.neighbors.add(MainActivity.n37);
        MainActivity.n36.neighbors.add(MainActivity.n49);

        MainActivity.n37.neighbors.add(MainActivity.n27);
        MainActivity.n37.neighbors.add(MainActivity.n36);
        MainActivity.n37.neighbors.add(MainActivity.n38);

        MainActivity.n38.neighbors.add(MainActivity.n37);
        MainActivity.n38.neighbors.add(MainActivity.n39);

        MainActivity.n39.neighbors.add(MainActivity.n38);
        MainActivity.n39.neighbors.add(MainActivity.n40);

        MainActivity.n40.neighbors.add(MainActivity.n39);
        MainActivity.n40.neighbors.add(MainActivity.n41);

        MainActivity.n41.neighbors.add(MainActivity.n28);
        MainActivity.n41.neighbors.add(MainActivity.n40);
        MainActivity.n41.neighbors.add(MainActivity.n50);

        MainActivity.n42.neighbors.add(MainActivity.n30);
        MainActivity.n42.neighbors.add(MainActivity.n31);

        MainActivity.n43.neighbors.add(MainActivity.n29);
        MainActivity.n43.neighbors.add(MainActivity.n45);

        MainActivity.n44.neighbors.add(MainActivity.n31);
        MainActivity.n44.neighbors.add(MainActivity.n32);
        MainActivity.n44.neighbors.add(MainActivity.n47);

        MainActivity.n45.neighbors.add(MainActivity.n43);
        MainActivity.n45.neighbors.add(MainActivity.n46);

        MainActivity.n46.neighbors.add(MainActivity.n45);
        MainActivity.n46.neighbors.add(MainActivity.n47);

        MainActivity.n47.neighbors.add(MainActivity.n44);
        MainActivity.n47.neighbors.add(MainActivity.n46);
        MainActivity.n47.neighbors.add(MainActivity.n52);

        MainActivity.n48.neighbors.add(MainActivity.n33);
        MainActivity.n48.neighbors.add(MainActivity.n54);

        MainActivity.n49.neighbors.add(MainActivity.n36);
        MainActivity.n49.neighbors.add(MainActivity.n58);

        MainActivity.n50.neighbors.add(MainActivity.n41);
        MainActivity.n50.neighbors.add(MainActivity.n51);

        MainActivity.n51.neighbors.add(MainActivity.n50);
        MainActivity.n51.neighbors.add(MainActivity.n62);

        MainActivity.n52.neighbors.add(MainActivity.n47);
        MainActivity.n52.neighbors.add(MainActivity.n53);

        MainActivity.n53.neighbors.add(MainActivity.n52);
        MainActivity.n53.neighbors.add(MainActivity.n54);

        MainActivity.n54.neighbors.add(MainActivity.n48);
        MainActivity.n54.neighbors.add(MainActivity.n53);
        MainActivity.n54.neighbors.add(MainActivity.n55);

        MainActivity.n55.neighbors.add(MainActivity.n54);
        MainActivity.n55.neighbors.add(MainActivity.n56);

        MainActivity.n56.neighbors.add(MainActivity.n55);
        MainActivity.n56.neighbors.add(MainActivity.n57);
        MainActivity.n56.neighbors.add(MainActivity.n58);

        MainActivity.n57.neighbors.add(MainActivity.n56);
        MainActivity.n57.neighbors.add(MainActivity.n60);

        MainActivity.n58.neighbors.add(MainActivity.n49);
        MainActivity.n58.neighbors.add(MainActivity.n56);
        MainActivity.n58.neighbors.add(MainActivity.n59);

        MainActivity.n59.neighbors.add(MainActivity.n58);
        MainActivity.n59.neighbors.add(MainActivity.n60);

        MainActivity.n60.neighbors.add(MainActivity.n59);
        MainActivity.n60.neighbors.add(MainActivity.n61);

        MainActivity.n61.neighbors.add(MainActivity.n60);
        MainActivity.n61.neighbors.add(MainActivity.n62);

        MainActivity.n62.neighbors.add(MainActivity.n51);
        MainActivity.n62.neighbors.add(MainActivity.n61);

        Stand s1= new Stand("IMA SPA", 172,76, 370, 194, MainActivity.n15,MainActivity.n15);

        StandMap.put("IMA SPA", s1);


        Stand s2= new Stand("JOKTAL", 410,77, 549, 194,MainActivity.n17,MainActivity.n17);

        StandMap.put("JOKTAL", s2);


        Stand s3= new Stand("COMINOX SARL", 549,76,687,194,MainActivity.n18,MainActivity.n19);

        StandMap.put("COMINOX SARL", s3);


        Stand s4= new Stand("IXAPACK 6 AUCOUTURIER-SELVEX", 737,76, 874,194,MainActivity.n21,MainActivity.n21);

        StandMap.put("IXAPACK 6 AUCOUTURIER-SELVEX", s4);


        Stand s5= new Stand("POLYMA INDUSTRY SARL", 915,37,1093,194,MainActivity.n12,MainActivity.n23);

        StandMap.put("POLYMA INDUSTRY SARL", s5);


        Stand s6= new Stand("GROUPEMENT STAF INTER GIE", 172, 234, 271, 253,MainActivity.n14,MainActivity.n30);

        StandMap.put("GROUPEMENT STAF INTER GIE", s6);


        Stand s7= new Stand("GUNTER GMBH & CO.KG", 271, 234, 370, 294,MainActivity.n15,MainActivity.n26);

        StandMap.put("GUNTER GMBH & CO.KG", s7);


        Stand s8= new Stand("FLCOWA", 271, 294, 370, 353, MainActivity.n42);

        StandMap.put("FLCOWA", s8);


        Stand s9= new Stand("ATMC HYGIENE", 410, 234, 469, 333, MainActivity.n26);

        StandMap.put("ATMC HYGIENE", s9);


        Stand s10= new Stand("ACEMIA/ACINOX", 410, 333, 469, 393,MainActivity.n32);

        StandMap.put("ACEMIA/ACINOX", s10);


        Stand s11= new Stand("ESCALIER", 479, 234, 638, 393,MainActivity.n33,MainActivity.n18);

        StandMap.put("ESCALIER", s11);


        Stand s12= new Stand("MISTOUN HYGIENE CHIMIE INDUSTRIELLE", 648, 235, 707, 333,MainActivity.n27);

        StandMap.put("MISTOUN HYGIENE CHIMIE INDUSTRIELLE", s12);


        Stand s13= new Stand("AXFLOW", 648, 333, 707, 392,MainActivity.n35);

        StandMap.put("AXFLOW", s13);


        Stand s14= new Stand("UROLA S.COOP", 747, 234, 865, 294,MainActivity.n21);

        StandMap.put("UROLA S.COOP", s14);


        Stand s15= new Stand("EUREQUAT ALGERIE", 747, 294, 826, 353, MainActivity.n38);

        StandMap.put("EUREQUAT ALGERIE", s15);


        Stand s16= new Stand("EL DJAZAIR ISTITHMAR", 826, 294, 885, 353,MainActivity.n39);

        StandMap.put("EL DJAZAIR ISTITHMAR", s16);


        Stand s17= new Stand("MEDPACK SOLUTIONS", 885, 294, 994, 353,MainActivity.n40);

        StandMap.put("MEDPACK SOLUTIONS", s17);


        Stand s18= new Stand("BRAMBATI SPA", 865, 234, 994, 294,MainActivity.n28);

        StandMap.put("BRAMBATI SPA", s18);


        Stand s19= new Stand("ICE SAS", 172, 393, 370, 472,MainActivity.n46,MainActivity.n46);

        StandMap.put("ICE SAS", s19);


        Stand s20= new Stand("OMS MAGHREB", 410, 432, 529, 551,MainActivity.n32,MainActivity.n47);

        StandMap.put("OMS MAGHREB", s20);


        Stand s21= new Stand("COLD ENERGY", 568, 432,638, 552,MainActivity.n34,MainActivity.n48);

        StandMap.put("COLD ENERGY", s21);


        Stand s22= new Stand("PRINCONFLEX SARL", 638, 433, 707, 552,MainActivity.n35,MainActivity.n49);

        StandMap.put("PRINCONFLEX SARL", s22);


        Stand s23= new Stand("SIPA EMBALLAGE", 747, 453, 865, 511,MainActivity.n59);

        StandMap.put("SIPA EMBALLAGE", s23);


        Stand s24= new Stand("ROBERT BOSCH MIDDLE EAST", 865, 552, 925, 511,MainActivity.n61);

        StandMap.put("ROBERT BOSCH MIDDLE EAST", s24);


        Stand s25= new Stand("TAVIL", 925, 452, 984, 511,MainActivity.n51);

        StandMap.put("TAVIL", s25);


        Stand s26= new Stand("LODIGE", 885, 393, 984, 452,MainActivity.n50);

        StandMap.put("LODIGE", s26);


        Stand s27= new Stand("OPEM SPA", 747, 393, 885, 452,MainActivity.n38);

        StandMap.put("OPEM SPA", s27);


        Stand s28= new Stand("SIAPI AFRICA", 865, 547, 984, 606,MainActivity.n61);

        StandMap.put("SIAPI AFRICA", s28);


        Stand s29= new Stand("FLEXOMED", 984, 547, 1093,606, 1034, 507,MainActivity.n62);

        StandMap.put("FLEXOMED", s29);


        Stand s30= new Stand("TECAIRE", 1034, 428, 1093, 507,MainActivity.n51);

        StandMap.put("TECAIRE", s30);


        Stand s31= new Stand("MAXFLOW", 1034, 290, 1093, 428,MainActivity.n41);

        StandMap.put("MAXFLOW", s31);


        Stand s32= new Stand("ASIBEX OPTION", 1034, 232, 1093, 290,MainActivity.n28);

        StandMap.put("ASIBEX OPTION", s32);

        Stand s33= new Stand("ENTREE", MainActivity.n29);

        StandMap.put("ENTREE", s33);

        Stand s34= new Stand("SORTIE", MainActivity.n57);

        StandMap.put("SORTIE", s34);




        BeaconMap.put("00000000-0000-0000-0000-000000000001",MainActivity.n1);
        BeaconMap.put("00000000-0000-0000-0000-000000000002",MainActivity.n2);
        BeaconMap.put("00000000-0000-0000-0000-000000000003",MainActivity.n3);
        BeaconMap.put("00000000-0000-0000-0000-000000000004",MainActivity.n4);
        BeaconMap.put("00000000-0000-0000-0000-000000000005",MainActivity.n5);
        BeaconMap.put("00000000-0000-0000-0000-000000000006",MainActivity.n61);
        BeaconMap.put("00000000-0000-0000-0000-000000000007",MainActivity.n56);
        BeaconMap.put("00000000-0000-0000-0000-000000000008",MainActivity.n54);
        BeaconMap.put("00000000-0000-0000-0000-000000000009",MainActivity.n52);
        BeaconMap.put("00000000-0000-0000-0000-000000000010",MainActivity.n40);
        BeaconMap.put("00000000-0000-0000-0000-000000000011",MainActivity.n11);
        BeaconMap.put("00000000-0000-0000-0000-000000000012",MainActivity.n12);
        BeaconMap.put("00000000-0000-0000-0000-000000000013",MainActivity.n13);
        BeaconMap.put("00000000-0000-0000-0000-000000000014",MainActivity.n14);
        BeaconMap.put("00000000-0000-0000-0000-000000000015",MainActivity.n15);
        BeaconMap.put("00000000-0000-0000-0000-000000000016",MainActivity.n16);
        BeaconMap.put("00000000-0000-0000-0000-000000000017",MainActivity.n17);
        BeaconMap.put("00000000-0000-0000-0000-000000000018",MainActivity.n18);
        BeaconMap.put("00000000-0000-0000-0000-000000000019",MainActivity.n19);
        BeaconMap.put("00000000-0000-0000-0000-000000000020",MainActivity.n20);
        BeaconMap.put("00000000-0000-0000-0000-000000000021",MainActivity.n21);
        BeaconMap.put("00000000-0000-0000-0000-000000000022",MainActivity.n22);
        BeaconMap.put("00000000-0000-0000-0000-000000000023",MainActivity.n23);
        BeaconMap.put("00000000-0000-0000-0000-000000000024",MainActivity.n24);
        BeaconMap.put("00000000-0000-0000-0000-000000000025",MainActivity.n25);
        BeaconMap.put("00000000-0000-0000-0000-000000000026",MainActivity.n26);
        BeaconMap.put("00000000-0000-0000-0000-000000000027",MainActivity.n27);
        BeaconMap.put("00000000-0000-0000-0000-000000000028",MainActivity.n28);
        BeaconMap.put("00000000-0000-0000-0000-000000000029",MainActivity.n29);
        BeaconMap.put("00000000-0000-0000-0000-000000000030",MainActivity.n30);
        BeaconMap.put("00000000-0000-0000-0000-000000000031",MainActivity.n31);
        BeaconMap.put("00000000-0000-0000-0000-000000000032",MainActivity.n32);
        BeaconMap.put("00000000-0000-0000-0000-000000000033",MainActivity.n33);
        BeaconMap.put("00000000-0000-0000-0000-000000000034",MainActivity.n34);
        BeaconMap.put("00000000-0000-0000-0000-000000000035",MainActivity.n35);
        BeaconMap.put("00000000-0000-0000-0000-000000000036",MainActivity.n36);
        BeaconMap.put("00000000-0000-0000-0000-000000000037",MainActivity.n37);
        BeaconMap.put("00000000-0000-0000-0000-000000000038",MainActivity.n38);
        BeaconMap.put("00000000-0000-0000-0000-000000000039",MainActivity.n39);
        BeaconMap.put("00000000-0000-0000-0000-000000000040",MainActivity.n40);
        BeaconMap.put("00000000-0000-0000-0000-000000000041",MainActivity.n41);
        BeaconMap.put("00000000-0000-0000-0000-000000000042",MainActivity.n42);
        BeaconMap.put("00000000-0000-0000-0000-000000000043",MainActivity.n43);
        BeaconMap.put("00000000-0000-0000-0000-000000000044",MainActivity.n44);
        BeaconMap.put("00000000-0000-0000-0000-000000000045",MainActivity.n45);
        BeaconMap.put("00000000-0000-0000-0000-000000000046",MainActivity.n46);
        BeaconMap.put("00000000-0000-0000-0000-000000000047",MainActivity.n47);
        BeaconMap.put("00000000-0000-0000-0000-000000000048",MainActivity.n48);
        BeaconMap.put("00000000-0000-0000-0000-000000000049",MainActivity.n49);
        BeaconMap.put("00000000-0000-0000-0000-000000000050",MainActivity.n51);








    }
}
