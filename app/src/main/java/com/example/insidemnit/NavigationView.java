package com.example.insidemnit;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    MarkerOptions markerOptions;
    MarkerOptions markerOptions1;

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

            String locationString = fromLat + "," + fromLng + "&&" + toLat + "," + toLng;

            DirectionRouteSearch(locationString);
        }
    }

    private void DirectionRouteSearch(String locationString) {
        String location = locationString;
        switch (location) {
            case "26.865109,75.807679&&26.864813,75.813979":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.8641208, 75.8123802)).add(new LatLng(26.8649378, 75.8133903)).add(new LatLng(26.864816, 75.813957)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.862461,75.816039":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.862069179925147, 75.8159636393516)).add(new LatLng(26.862416612543047, 75.81600735940765)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.861880,75.816020":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.862069179925147, 75.8159636393516)).add(new LatLng(26.861856699979494, 75.81599475307439)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.860681,75.815778":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86065394225311, 75.81556655508496)).add(new LatLng(26.860656335073237, 75.81576101523854)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.859845,75.817698":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860055735211915, 75.81780083552171)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.860589,75.817616":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860568278795263, 75.81773673074262)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.860753,75.819367":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.86053956478191, 75.81938253421053)).add(new LatLng(26.860683133972472, 75.81935866256667)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.859652,75.818441":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.859836617888302, 75.81826612962615)).add(new LatLng(26.859754782788844, 75.81841552870102)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.860344,75.819365":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863408, 75.815399)).add(new LatLng(26.86321149227327, 75.815559966813)).add(new LatLng(26.863053091019935, 75.81559993171095)).add(new LatLng(26.86207444411098, 75.81559322618841)).add(new LatLng(26.86117748986232, 75.81556601877412)).add(new LatLng(26.8611449477125, 75.81720270291146)).add(new LatLng(26.86081761059908, 75.8177686490136)).add(new LatLng(26.860520900866508, 75.81835068836976)).add(new LatLng(26.86053956478191, 75.81938253421053)).add(new LatLng(26.860359212291854, 75.81937119982214)).width(5).color(Color.RED));
                break;
            case "26.865109,75.807679&&26.862243,75.820118":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.863548, 75.815149)).add(new LatLng(26.863243488368173, 75.81676543376402)).add(new LatLng(26.86232083427693, 75.81829482937705)).add(new LatLng(26.861996372200988, 75.81941331053626)).add(new LatLng(26.862123668315306, 75.82008976368256)).width(5).color(Color.RED));
                break;
        }
    }

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
        layer= findViewById(R.id.layerBtn);
        layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    Toast.makeText(NavigationView.this, "SATELITE VIEW", Toast.LENGTH_SHORT).show();
                }
                else{
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    Toast.makeText(NavigationView.this, "NORMAL VIEW", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  void bounds(double lat, double lng){
        LatLng  latlng = new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latlng,15);
        map.animateCamera(cameraUpdate);

    }

}
