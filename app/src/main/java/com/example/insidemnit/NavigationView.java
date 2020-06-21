package com.example.insidemnit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class NavigationView extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    String fromLocationName;
    String toLocationName;
    LatLng fromLatLng;
    double fromLat;
    double fromLng;
    LatLng toLatLng;
    double toLat;
    double toLng;
    TextView fromSearch;
    TextView toSearch;
    ImageButton layer;
    ImageButton floorplan;
    MarkerOptions markerOptions;
    MarkerOptions markerOptions1;
    private static final int NO_PARENT=-1;
    double LatitudeList[]={26.865102,26.864932,26.864850,26.864779,26.864614,26.865366,26.865729,26.865679,26.865601,26.864979,26.864424,26.864657,26.864947,26.865638,26.866302,26.864812,26.866707,26.865645,26.865634,26.867020,26.864460,26.864371,26.863761,26.864123,26.863852,26.863697,26.863472,26.863531,26.863324,26.863091,26.862200,26.862064,26.862081,26.862447,26.861922,26.861153,26.861154,26.862847,26.863069,26.863255,26.863185,26.862266,26.861993,26.862046,26.863221,26.863314,26.863569,26.861984,26.862154,26.860516,26.860506,26.860505,26.859856,26.860790,26.860581,26.860141,26.861110,26.860947,26.860687,26.860581,26.860032,26.860185,26.860385,26.859945,26.859927,26.860221,26.859098,26.859098,26.858863,26.858753,26.858607,26.857060,26.861164,26.861247,26.861590,26.861682,26.862474,26.862429,26.862576,26.862630,26.862744,26.863106,26.862724,26.863369,26.863487,26.862972,26.863096,26.863029,26.863053,26.862785,26.862603,26.862914,26.862705,26.862517,26.862513,26.862303,26.862549,26.862753,26.862203,26.862137,26.861651,26.862281,26.862600,26.862137,26.862180,26.862801,26.862863,26.863426,26.864102,26.861984,26.861848,26.860749,26.861229,26.860457,26.861372,26.861279,26.861124,26.860387,26.860435,26.860282,26.859841,26.860355,26.861549,26.861751,26.862018,26.862062,26.861990,26.861933,26.861980,26.861424,26.859884,26.859651,26.859360,26.860502,26.858982,26.862165,26.861033,26.860887,26.860794,26.860928,26.862794,26.862025,26.861941,26.862053,26.862309,26.862476};
    double LongitudeList[]={75.807700,75.808467,75.808832,75.809210,75.810041,75.810242,75.810338,75.810864,75.811089,75.812200,75.812752,75.813094,75.813402,75.813826,75.814132,75.814022,75.812233,75.817368,75.817966,75.810660,75.810782,75.811174,75.811054,75.812391,75.813527,75.814414,75.814588,75.815235,75.815498,75.815600,75.815575,75.815596,75.815977,75.816034,75.815989,75.815574,75.816780,75.816841,75.816764,75.816589,75.816849,75.818380,75.819244,75.819887,75.816757,75.816376,75.816445,75.819421,75.820129,75.819962,75.819370,75.818338,75.818296,75.817821,75.817792,75.817805,75.817297,75.815560,75.815560,75.815560,75.815543,75.814818,75.814111,75.815548,75.817166,75.817318,75.815528,75.816558,75.817065,75.817133,75.817138,75.816883,75.814828,75.814625,75.814198,75.813841,75.814083,75.814361,75.813586,75.813329,75.813250,75.812149,75.812047,75.810874,75.810453,75.810786,75.810605,75.810414,75.810276,75.810193,75.810132,75.810705,75.809547,75.809489,75.809382,75.809344,75.809290,75.809327,75.809325,75.809665,75.809159,75.808906,75.808979,75.808871,75.808657,75.809034,75.808822,75.808961,75.808669,75.808605,75.808367,75.808422,75.808415,75.809742,75.809980,75.810468,75.811238,75.810181,75.810330,75.811045,75.810024,75.810732,75.811363,75.811469,75.811749,75.811867,75.812183,75.812506,75.812332,75.811335,75.810964,75.810902,75.810823,75.811104,75.810510,75.811136,75.811777,75.812086,75.812708,75.814020,75.811738,75.813970,75.814528,75.820821,75.821356,75.822596};
    int test[]=new int[100];
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        TextView back = findViewById(R.id.backBtn);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(NavigationView.this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationView.this, MainActivity.class);
                startActivity(intent);
            }
        });
        fromSearch = findViewById(R.id.searchFrom);
        toSearch = findViewById(R.id.searchTo);
        floorplan=findViewById(R.id.floorplan);
    }

    public void getIntentActivity() {
        if (getIntent().hasExtra("fromLocationName") && getIntent().hasExtra("toLocationName") && getIntent().hasExtra("fromLocationLat") && getIntent().hasExtra("fromLocationLng") && getIntent().hasExtra("toLocationLat") && getIntent().hasExtra("toLocationLng")) {
            fromLocationName = getIntent().getStringExtra("fromLocationName");
            fromLat = getIntent().getDoubleExtra("fromLocationLat", 00);
            fromLng = getIntent().getDoubleExtra("fromLocationLng", 00);
            fromLatLng = new LatLng(fromLat, fromLng);
            toLocationName = getIntent().getStringExtra("toLocationName");
            toLat = getIntent().getDoubleExtra("toLocationLat", 00);
            toLng = getIntent().getDoubleExtra("toLocationLng", 00);
            toLatLng = new LatLng(toLat, toLng);
            fromSearch.setText("  " + fromLocationName);
            toSearch.setText("  " + toLocationName);
            markerOptions = new MarkerOptions().position(fromLatLng).title(fromLocationName).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            markerOptions1 = new MarkerOptions().position(toLatLng).title(toLocationName);
            map.addMarker(markerOptions);

            if (toLocationName != null) {
                map.addMarker(markerOptions1);
                bounds((fromLat + toLat) / 2, (fromLng + toLng) / 2);
            } else {
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(fromLatLng, 17));
            }

            //String locationString = fromLat + "," + fromLng + "&&" + toLat + "," + toLng;

            //DirectionRouteSearch(locationString);


            int adjacencyMatrix[][]=new int[LatitudeList.length][LongitudeList.length];
            adjacencyMatrix[0][1]=78;
            adjacencyMatrix[1][0]=78;
            adjacencyMatrix[1][2]=37;
            adjacencyMatrix[2][1]=37;
            adjacencyMatrix[2][3]=38;
            adjacencyMatrix[3][2]=38;
            adjacencyMatrix[3][4]=84;
            adjacencyMatrix[4][3]=84;
            adjacencyMatrix[4][5]=86;
            adjacencyMatrix[5][4]=86;
            adjacencyMatrix[5][6]=41;
            adjacencyMatrix[6][5]=41;
            adjacencyMatrix[6][7]=52;
            adjacencyMatrix[7][6]=52;
            adjacencyMatrix[7][8]=24;
            adjacencyMatrix[8][7]=24;
            adjacencyMatrix[8][9]=130;
            adjacencyMatrix[9][8]=130;
            adjacencyMatrix[9][10]=82;
            adjacencyMatrix[10][9]=82;
            adjacencyMatrix[10][11]=42;
            adjacencyMatrix[11][10]=42;
            adjacencyMatrix[11][12]=44;
            adjacencyMatrix[12][11]=44;
            adjacencyMatrix[12][15]=63;
            adjacencyMatrix[15][12]=63;
            adjacencyMatrix[12][13]=87;
            adjacencyMatrix[13][12]=87;
            adjacencyMatrix[13][14]=79;
            adjacencyMatrix[14][13]=79;
            adjacencyMatrix[14][16]=193;
            adjacencyMatrix[16][14]=193;
            adjacencyMatrix[16][19]=160;
            adjacencyMatrix[19][16]=160;
            adjacencyMatrix[14][17]=329;
            adjacencyMatrix[17][14]=329;
            adjacencyMatrix[17][18]=59;
            adjacencyMatrix[18][17]=59;
            adjacencyMatrix[6][19]=147;
            adjacencyMatrix[19][6]=147;
            adjacencyMatrix[4][20]=75;
            adjacencyMatrix[20][4]=75;
            adjacencyMatrix[20][21]=40;
            adjacencyMatrix[21][20]=40;
            adjacencyMatrix[21][23]=123;
            adjacencyMatrix[23][21]=123;
            adjacencyMatrix[23][10]=49;
            adjacencyMatrix[10][23]=49;
            adjacencyMatrix[21][22]=68;
            adjacencyMatrix[22][21]=68;
            adjacencyMatrix[22][83]=47;
            adjacencyMatrix[83][22]=47;
            adjacencyMatrix[83][84]=43;
            adjacencyMatrix[84][83]=43;
            adjacencyMatrix[81][83]=129;
            adjacencyMatrix[83][81]=129;
            adjacencyMatrix[23][81]=115;
            adjacencyMatrix[81][23]=115;
            adjacencyMatrix[80][81]=120;
            adjacencyMatrix[81][80]=120;
            adjacencyMatrix[81][82]=43;
            adjacencyMatrix[82][81]=43;
            adjacencyMatrix[140][82]=30;
            adjacencyMatrix[82][140]=30;
            adjacencyMatrix[82][125]=75;
            adjacencyMatrix[125][82]=75;
            adjacencyMatrix[125][124]=12;
            adjacencyMatrix[124][125]=12;
            adjacencyMatrix[124][123]=40;
            adjacencyMatrix[123][124]=40;
            adjacencyMatrix[123][122]=24;
            adjacencyMatrix[122][123]=24;
            adjacencyMatrix[122][129]=14;
            adjacencyMatrix[129][122]=14;
            adjacencyMatrix[129][116]=34;
            adjacencyMatrix[116][129]=34;
            adjacencyMatrix[116][133]=70;
            adjacencyMatrix[133][116]=70;
            adjacencyMatrix[133][119]=25;
            adjacencyMatrix[119][133]=25;
            adjacencyMatrix[119][121]=32;
            adjacencyMatrix[121][119]=32;
            adjacencyMatrix[121][118]=40;
            adjacencyMatrix[118][121]=40;
            adjacencyMatrix[118][117]=15;
            adjacencyMatrix[117][118]=15;
            adjacencyMatrix[117][113]=44;
            adjacencyMatrix[113][117]=44;
            adjacencyMatrix[113][111]=135;
            adjacencyMatrix[111][113]=135;
            adjacencyMatrix[111][112]=53;
            adjacencyMatrix[112][111]=53;
            adjacencyMatrix[112][110]=69;
            adjacencyMatrix[110][112]=69;
            adjacencyMatrix[110][109]=28;
            adjacencyMatrix[109][110]=28;
            adjacencyMatrix[109][104]=22;
            adjacencyMatrix[104][109]=22;
            adjacencyMatrix[104][103]=21;
            adjacencyMatrix[103][104]=21;
            adjacencyMatrix[103][101]=16;
            adjacencyMatrix[101][103]=16;
            adjacencyMatrix[101][98]=42;
            adjacencyMatrix[98][101]=42;
            adjacencyMatrix[95][98]=11;
            adjacencyMatrix[98][95]=11;
            adjacencyMatrix[101][102]=36;
            adjacencyMatrix[102][101]=36;
            adjacencyMatrix[106][104]=77;
            adjacencyMatrix[104][106]=77;
            adjacencyMatrix[106][105]=22;
            adjacencyMatrix[105][106]=22;
            adjacencyMatrix[105][102]=22;
            adjacencyMatrix[102][105]=22;
            adjacencyMatrix[105][97]=29;
            adjacencyMatrix[97][105]=29;
            adjacencyMatrix[97][92]=22;
            adjacencyMatrix[92][97]=22;
            adjacencyMatrix[92][90]=59;
            adjacencyMatrix[90][92]=59;
            adjacencyMatrix[90][89]=21;
            adjacencyMatrix[89][90]=21;
            adjacencyMatrix[89][88]=30;
            adjacencyMatrix[88][89]=30;
            adjacencyMatrix[92][93]=21;
            adjacencyMatrix[93][92]=21;
            adjacencyMatrix[93][94]=10;
            adjacencyMatrix[94][93]=10;
            adjacencyMatrix[94][96]=9;
            adjacencyMatrix[96][94]=9;
            adjacencyMatrix[96][97]=22;
            adjacencyMatrix[97][96]=22;
            adjacencyMatrix[88][87]=13;
            adjacencyMatrix[87][88]=13;
            adjacencyMatrix[87][84]=51;
            adjacencyMatrix[84][87]=51;
            adjacencyMatrix[85][83]=45;
            adjacencyMatrix[83][85]=45;
            adjacencyMatrix[85][91]=10;
            adjacencyMatrix[91][85]=10;
            adjacencyMatrix[91][87]=31;
            adjacencyMatrix[87][91]=31;
            adjacencyMatrix[91][86]=22;
            adjacencyMatrix[86][91]=22;
            adjacencyMatrix[86][87]=20;
            adjacencyMatrix[87][86]=20;
            adjacencyMatrix[80][79]=14;
            adjacencyMatrix[79][80]=14;
            adjacencyMatrix[79][78]=26;
            adjacencyMatrix[78][79]=26;
            adjacencyMatrix[80][24]=126;
            adjacencyMatrix[24][80]=126;
            adjacencyMatrix[24][23]=116;
            adjacencyMatrix[23][24]=116;
            adjacencyMatrix[24][25]=89;
            adjacencyMatrix[25][24]=89;
            adjacencyMatrix[25][26]=30;
            adjacencyMatrix[26][25]=30;
            adjacencyMatrix[25][27]=83;
            adjacencyMatrix[27][25]=83;
            adjacencyMatrix[27][28]=34;
            adjacencyMatrix[28][27]=34;
            adjacencyMatrix[28][29]=27;
            adjacencyMatrix[29][28]=27;
            adjacencyMatrix[27][45]=115;
            adjacencyMatrix[45][27]=115;
            adjacencyMatrix[45][46]=29;
            adjacencyMatrix[46][45]=29;
            adjacencyMatrix[45][39]=22;
            adjacencyMatrix[39][45]=22;
            adjacencyMatrix[39][38]=27;
            adjacencyMatrix[38][39]=27;
            adjacencyMatrix[38][37]=25;
            adjacencyMatrix[37][38]=25;
            adjacencyMatrix[37][36]=188;
            adjacencyMatrix[36][37]=188;
            adjacencyMatrix[39][44]=17;
            adjacencyMatrix[44][39]=17;
            adjacencyMatrix[44][40]=9;
            adjacencyMatrix[40][44]=9;
            adjacencyMatrix[40][41]=183;
            adjacencyMatrix[41][40]=183;
            adjacencyMatrix[41][42]=90;
            adjacencyMatrix[42][41]=90;
            adjacencyMatrix[42][47]=17;
            adjacencyMatrix[47][42]=17;
            adjacencyMatrix[47][43]=46;
            adjacencyMatrix[43][47]=46;
            adjacencyMatrix[43][48]=26;
            adjacencyMatrix[48][43]=26;
            adjacencyMatrix[43][49]=170;
            adjacencyMatrix[49][43]=170;
            adjacencyMatrix[49][50]=58;
            adjacencyMatrix[50][49]=58;
            adjacencyMatrix[50][51]=102;
            adjacencyMatrix[51][50]=102;
            adjacencyMatrix[51][53]=60;
            adjacencyMatrix[53][51]=60;
            adjacencyMatrix[53][54]=23;
            adjacencyMatrix[54][53]=23;
            adjacencyMatrix[54][55]=49;
            adjacencyMatrix[55][54]=49;
            adjacencyMatrix[51][52]=72;
            adjacencyMatrix[52][51]=72;
            adjacencyMatrix[53][56]=63;
            adjacencyMatrix[56][53]=63;
            adjacencyMatrix[56][36]=51;
            adjacencyMatrix[36][56]=51;
            adjacencyMatrix[36][35]=119;
            adjacencyMatrix[35][36]=119;
            adjacencyMatrix[35][57]=22;
            adjacencyMatrix[57][35]=22;
            adjacencyMatrix[57][58]=28;
            adjacencyMatrix[58][57]=28;
            adjacencyMatrix[31][35]=101;
            adjacencyMatrix[35][31]=101;
            adjacencyMatrix[31][32]=37;
            adjacencyMatrix[32][31]=37;
            adjacencyMatrix[32][34]=17;
            adjacencyMatrix[34][32]=17;
            adjacencyMatrix[32][33]=41;
            adjacencyMatrix[33][32]=41;
            adjacencyMatrix[31][30]=15;
            adjacencyMatrix[30][31]=15;
            adjacencyMatrix[30][77]=123;
            adjacencyMatrix[77][30]=123;
            adjacencyMatrix[77][76]=28;
            adjacencyMatrix[76][77]=28;
            adjacencyMatrix[78][76]=50;
            adjacencyMatrix[76][78]=50;
            adjacencyMatrix[75][76]=91;
            adjacencyMatrix[76][75]=91;
            adjacencyMatrix[75][127]=135;
            adjacencyMatrix[127][75]=135;
            adjacencyMatrix[127][128]=18;
            adjacencyMatrix[128][127]=18;
            adjacencyMatrix[128][126]=14;
            adjacencyMatrix[126][128]=14;
            adjacencyMatrix[126][125]=32;
            adjacencyMatrix[125][126]=32;
            adjacencyMatrix[35][72]=74;
            adjacencyMatrix[72][35]=74;
            adjacencyMatrix[72][73]=22;
            adjacencyMatrix[73][72]=22;
            adjacencyMatrix[73][74]=57;
            adjacencyMatrix[74][73]=57;
            adjacencyMatrix[74][75]=36;
            adjacencyMatrix[75][74]=36;
            adjacencyMatrix[141][75]=30;
            adjacencyMatrix[75][141]=30;
            adjacencyMatrix[141][142]=40;
            adjacencyMatrix[142][141]=40;
            adjacencyMatrix[58][59]=11;
            adjacencyMatrix[59][58]=11;
            adjacencyMatrix[59][60]=61;
            adjacencyMatrix[60][59]=61;
            adjacencyMatrix[60][61]=73;
            adjacencyMatrix[61][60]=73;
            adjacencyMatrix[62][61]=74;
            adjacencyMatrix[61][62]=74;
            adjacencyMatrix[60][63]=9;
            adjacencyMatrix[63][60]=9;
            adjacencyMatrix[63][64]=160;
            adjacencyMatrix[64][63]=160;
            adjacencyMatrix[64][65]=35;
            adjacencyMatrix[65][64]=35;
            adjacencyMatrix[63][66]=94;
            adjacencyMatrix[66][63]=94;
            adjacencyMatrix[66][67]=102;
            adjacencyMatrix[67][66]=102;
            adjacencyMatrix[67][68]=56;
            adjacencyMatrix[68][67]=56;
            adjacencyMatrix[64][68]=120;
            adjacencyMatrix[68][64]=120;
            adjacencyMatrix[68][69]=13;
            adjacencyMatrix[69][68]=13;
            adjacencyMatrix[69][70]=16;
            adjacencyMatrix[70][69]=16;
            adjacencyMatrix[70][71]=174;
            adjacencyMatrix[71][70]=174;
            adjacencyMatrix[75][62]=147;
            adjacencyMatrix[62][75]=147;
            adjacencyMatrix[116][115]=78;
            adjacencyMatrix[115][116]=78;
            adjacencyMatrix[115][114]=49;
            adjacencyMatrix[114][115]=49;
            adjacencyMatrix[114][113]=104;
            adjacencyMatrix[113][114]=104;
            adjacencyMatrix[98][99]=34;
            adjacencyMatrix[99][98]=34;
            adjacencyMatrix[98][100]=63;
            adjacencyMatrix[100][98]=63;
            adjacencyMatrix[106][107]=64;
            adjacencyMatrix[107][106]=64;
            adjacencyMatrix[107][108]=80;
            adjacencyMatrix[108][107]=80;
            adjacencyMatrix[2][108]=84;
            adjacencyMatrix[108][2]=84;
            adjacencyMatrix[119][130]=45;
            adjacencyMatrix[130][119]=45;
            adjacencyMatrix[130][131]=26;
            adjacencyMatrix[131][130]=26;
            adjacencyMatrix[131][132]=33;
            adjacencyMatrix[132][131]=33;
            adjacencyMatrix[132][134]=52;
            adjacencyMatrix[134][132]=52;
            adjacencyMatrix[117][120]=62;
            adjacencyMatrix[120][117]=62;
            adjacencyMatrix[124][135]=63;
            adjacencyMatrix[135][124]=63;
            adjacencyMatrix[116][136]=54;
            adjacencyMatrix[136][116]=54;
            adjacencyMatrix[136][137]=34;
            adjacencyMatrix[137][136]=34;
            adjacencyMatrix[137][138]=62;
            adjacencyMatrix[138][137]=62;
            adjacencyMatrix[138][139]=131;
            adjacencyMatrix[139][138]=131;
            adjacencyMatrix[139][72]=84;
            adjacencyMatrix[72][139]=84;
            adjacencyMatrix[48][143]=74;
            adjacencyMatrix[143][48]=74;
            adjacencyMatrix[144][143]=60;
            adjacencyMatrix[143][144]=60;
            adjacencyMatrix[144][145]=115;
            adjacencyMatrix[145][144]=115;



            int source=0;
            int destination=0;
            for(int i=0;i<LatitudeList.length;i++) {
                if (fromLat == LatitudeList[i] && fromLng == LongitudeList[i]) {
                    source = i;
                }
                if (toLat == LatitudeList[i] && toLng == LongitudeList[i]) {
                    destination = i;
                }
            }

            dijkstra(adjacencyMatrix,source,destination);
        }
    }

    private void dijkstra(int[][] adjacencyMatrix, int startVertex, int destinationVertex) {
        int nVertices = adjacencyMatrix[0].length;

        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];

        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        shortestDistances[startVertex] = 0;
        int[] parents = new int[nVertices];
        parents[startVertex] = NO_PARENT;

        for (int i = 0; i < nVertices; i++)
        {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            added[nearestVertex] = true;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }
        printSolution(startVertex, shortestDistances, parents,destinationVertex);
    }

    private void printSolution(int startVertex,
                               int[] distances,
                               int[] parents, int destinationVertex)
    {
        int pointArray[]=printPath(startVertex,destinationVertex, parents);
        Polyline polyline;
        for(int i=0;i<pointArray.length;i++){
            Log.d("true", "printSolution: "+pointArray[i]);
            if(pointArray[i]==destinationVertex)
                break;
            polyline= map.addPolyline(new PolylineOptions().add(new LatLng(LatitudeList[pointArray[i]],LongitudeList[pointArray[i]])).add(new LatLng(LatitudeList[pointArray[i+1]],LongitudeList[pointArray[i+1]])).color(Color.RED).width(5));

        }

    }
    private int[] printPath(int startVertex, int currentVertex,
                                  int[] parents)
    {
        Log.d("new", "printPath: ");
        Log.d("point", ""+currentVertex);
        if (currentVertex == NO_PARENT)
        {
            return test;
        }
        printPath(startVertex,parents[currentVertex], parents);
        Log.d("points", ""+currentVertex);

        test[a]=currentVertex;
        Log.d("new", "print"+test[a]);
        a++;
        return test;
    }

//    private void DirectionRouteSearch(String locationString) {
//        String location = locationString;
//        switch (location) {
//            case "26.865109,75.807679&&26.864813,75.813979":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.8641208, 75.8123802)).add(new LatLng(26.8649378, 75.8133903)).add(new LatLng(26.864816, 75.813957)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.862461,75.816039":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.862069179925147, 75.8159636393516)).add(new LatLng(26.862416612543047, 75.81600735940765)).width(5).color(Color.RED));
//                floorplan.setVisibility(View.VISIBLE);
//                break;
//            case "26.865109,75.807679&&26.861880,75.816020":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.862069179925147, 75.8159636393516)).add(new LatLng(26.861856699979494, 75.81599475307439)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.860681,75.815778":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86065394225311, 75.81556655508496)).add(new LatLng(26.860656335073237, 75.81576101523854)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.859845,75.817698":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860055735211915, 75.81780083552171)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.860589,75.817616":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860568278795263, 75.81773673074262)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.860753,75.819367":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.86053956478191, 75.81938253421053)).add(new LatLng(26.860683133972472, 75.81935866256667)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.859652,75.818441":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.859836617888302, 75.81826612962615)).add(new LatLng(26.859754782788844, 75.81841552870102)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.860344,75.819365":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.86053956478191, 75.81938253421053)).add(new LatLng(26.860359212291854, 75.81937119982214)).width(5).color(Color.RED));
//                break;
//            case "26.865109,75.807679&&26.862243,75.820118":
//                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863243488368173, 75.81676543376402)).add(new LatLng(26.86232083427693, 75.81829482937705)).add(new LatLng(26.861996372200988, 75.81941331053626)).add(new LatLng(26.862123668315306, 75.82008976368256)).width(5).color(Color.RED));
//                break;
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        getIntentActivity();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            return;
        }
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMapToolbarEnabled(false);
        layer= findViewById(R.id.layerBtn);
        layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    Toast.makeText(NavigationView.this, "SATELITE VIEW", Toast.LENGTH_SHORT).show();
                }
                else{
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    Toast.makeText(NavigationView.this, "NORMAL VIEW", Toast.LENGTH_SHORT).show();
                }
            }
        });
        floorplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentfloor= new Intent(NavigationView.this,FloorPlan.class);
                intentfloor.putExtra("toLocationName",toLocationName);
                intentfloor.putExtra("toLocationLat",toLat);
                intentfloor.putExtra("toLocationLng",toLng);
                startActivity(intentfloor);
            }
        });
    }

    private  void bounds(double lat, double lng){
        LatLng  latlng = new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latlng,15);
        map.animateCamera(cameraUpdate);

    }

}
