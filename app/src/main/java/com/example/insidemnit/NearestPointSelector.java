package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class NearestPointSelector extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    String fromLocationName;
    String toLocationName;
    LatLng fromLatLng;
    double fromLat;
    double fromLng;
    LatLng toLatLng;
    double toLat;
    double toLng;
    MarkerOptions markerOptions;
    ImageButton layer;
    double LatitudeList[]={26.865102,26.864932,26.864850,26.864779,26.864614,26.865366,26.865729,26.865679,26.865601,26.864979,26.864424,26.864657,26.864947,26.865638,26.866302,26.864812,26.866707,26.865645,26.865634,26.867020,26.864460,26.864371,26.863761,26.864123,26.863852,26.863697,26.863472,26.863531,26.863324,26.863091,26.862200,26.862064,26.862081,26.862447,26.861922,26.861153,26.861154,26.862847,26.863069,26.863255,26.863185,26.862266,26.861993,26.862046,26.863221,26.863314,26.863569,26.861984,26.862154,26.860516,26.860506,26.860505,26.859856,26.860790,26.860581,26.860141,26.861110,26.860947,26.860687,26.860581,26.860032,26.860185,26.860385,26.859945,26.859927,26.860221,26.859098,26.859098,26.858863,26.858753,26.858607,26.857060,26.861164,26.861247,26.861590,26.861682,26.862474,26.862429,26.862576,26.862630,26.862744,26.863106,26.862724,26.863369,26.863487,26.862972,26.863096,26.863029,26.863053,26.862785,26.862603,26.862914,26.862705,26.862517,26.862513,26.862303,26.862549,26.862753,26.862203,26.862137,26.861651,26.862281,26.862600,26.862137,26.862180,26.862801,26.862863,26.863426,26.864102,26.861984,26.861848,26.860749,26.861229,26.860457,26.861372,26.861279,26.861124,26.860387,26.860435,26.860282,26.859841,26.860355,26.861549,26.861751,26.862018,26.862062,26.861990,26.861933,26.861980,26.861424,26.859884,26.859651,26.859360,26.860502,26.858982,26.862165,26.861033,26.860887,26.860794,26.860928,26.862794,26.862025,26.861941};
    double LongitudeList[]={75.807700,75.808467,75.808832,75.809210,75.810041,75.810242,75.810338,75.810864,75.811089,75.812200,75.812752,75.813094,75.813402,75.813826,75.814132,75.814022,75.812233,75.817368,75.817966,75.810660,75.810782,75.811174,75.811054,75.812391,75.813527,75.814414,75.814588,75.815235,75.815498,75.815600,75.815575,75.815596,75.815977,75.816034,75.815989,75.815574,75.816780,75.816841,75.816764,75.816589,75.816849,75.818380,75.819244,75.819887,75.816757,75.816376,75.816445,75.819421,75.820129,75.819962,75.819370,75.818338,75.818296,75.817821,75.817792,75.817805,75.817297,75.815560,75.815560,75.815560,75.815543,75.814818,75.814111,75.815548,75.817166,75.817318,75.815528,75.816558,75.817065,75.817133,75.817138,75.816883,75.814828,75.814625,75.814198,75.813841,75.814083,75.814361,75.813586,75.813329,75.813250,75.812149,75.812047,75.810874,75.810453,75.810786,75.810605,75.810414,75.810276,75.810193,75.810132,75.810705,75.809547,75.809489,75.809382,75.809344,75.809290,75.809327,75.809325,75.809665,75.809159,75.808906,75.808979,75.808871,75.808657,75.809034,75.808822,75.808961,75.808669,75.808605,75.808367,75.808422,75.808415,75.809742,75.809980,75.810468,75.811238,75.810181,75.810330,75.811045,75.810024,75.810732,75.811363,75.811469,75.811749,75.811867,75.812183,75.812506,75.812332,75.811335,75.810964,75.810902,75.810823,75.811104,75.810510,75.811136,75.811777,75.812086,75.812708,75.814020,75.811738,75.813970,75.814528};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_point_selector);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(NearestPointSelector.this);
    }

    public void getIntentActivity(){
        if(getIntent().hasExtra("fromLocationName")&&getIntent().hasExtra("toLocationName")&&getIntent().hasExtra("fromLocationLat")&&getIntent().hasExtra("fromLocationLng")&&getIntent().hasExtra("toLocationLat")&&getIntent().hasExtra("toLocationLng")){
            fromLocationName=getIntent().getStringExtra("fromLocationName");
//            fromLat=getIntent().getDoubleExtra("fromLocationLat",00);
//            fromLng=getIntent().getDoubleExtra("fromLocationLng",00);
//            fromLatLng=new LatLng(fromLat,fromLng);
            fromLat=26.865102;
            fromLng=75.807700;
            fromLatLng= new LatLng(fromLat,fromLng);
            toLocationName=getIntent().getStringExtra("toLocationName");
            toLat=getIntent().getDoubleExtra("toLocationLat",00);
            toLng=getIntent().getDoubleExtra("toLocationLng",00);
            toLatLng=new LatLng(toLat,toLng);
            markerOptions=new MarkerOptions().position(fromLatLng).title(fromLocationName).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            map.addMarker(markerOptions);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(fromLatLng,18));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        map.getUiSettings().setMapToolbarEnabled(false);
        getIntentActivity();
        layer= findViewById(R.id.layerBtn);
        layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    Toast.makeText(NearestPointSelector.this, "SATELITE VIEW", Toast.LENGTH_SHORT).show();
                }
                else{
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    Toast.makeText(NearestPointSelector.this, "NORMAL VIEW", Toast.LENGTH_SHORT).show();
                }
            }
        });

        for(int i=0;i<LatitudeList.length;i++){
            if(fromLat>LatitudeList[i]&&fromLng>LongitudeList[i]){
                if((fromLat-LatitudeList[i]<=0.002)&&(fromLng-LongitudeList[i]<=0.002)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(fromLat>LatitudeList[i]&&LongitudeList[i]>fromLng){
                if((fromLat-LatitudeList[i]<=0.002)&&(LongitudeList[i]-fromLng<=0.002)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(LatitudeList[i]>fromLat&&fromLng>LongitudeList[i]){
                if((LatitudeList[i]-fromLat<=0.002)&&(fromLng-LongitudeList[i]<=0.002)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(LatitudeList[i]>fromLat&&LongitudeList[i]>fromLng){
                if((LatitudeList[i]-fromLat<=0.002)&&(LongitudeList[i]-fromLng<=0.002)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
        }
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Intent intent1=new Intent(NearestPointSelector.this,NavigationView.class);
                intent1.putExtra("fromLocationName","Current Location");
                intent1.putExtra("fromLocationLat",marker.getPosition().latitude);
                intent1.putExtra("fromLocationLng",marker.getPosition().longitude);
                intent1.putExtra("toLocationName",toLocationName);
                intent1.putExtra("toLocationLat",toLat);
                intent1.putExtra("toLocationLng",toLng);
                startActivity(intent1);
                return false;
            }
        });
    }


}
