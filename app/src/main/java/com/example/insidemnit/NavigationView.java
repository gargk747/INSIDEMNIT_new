package com.example.insidemnit;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class NavigationView extends FragmentActivity implements OnMapReadyCallback{

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
    MarkerOptions markerOptions;
    MarkerOptions markerOptions1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        TextView back= findViewById(R.id.backBtn);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(NavigationView.this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NavigationView.this,MainActivity.class);
                startActivity(intent);
            }
        });
        fromSearch=findViewById(R.id.searchFrom);
        toSearch=findViewById(R.id.searchTo);
    }

    public void getIntentActivity(){
        if(getIntent().hasExtra("fromLocationName")&&getIntent().hasExtra("toLocationName")&&getIntent().hasExtra("fromLocationLat")&&getIntent().hasExtra("fromLocationLng")&&getIntent().hasExtra("toLocationLat")&&getIntent().hasExtra("toLocationLng")){
            fromLocationName=getIntent().getStringExtra("fromLocationName");
            fromLat=getIntent().getDoubleExtra("fromLocationLat",00);
            fromLng=getIntent().getDoubleExtra("fromLocationLng",00);
           // fromLatLng=new LatLng(fromLat,fromLng);
            fromLatLng= new LatLng(26.865109, 75.807679);
            toLocationName=getIntent().getStringExtra("toLocationName");
            toLat=getIntent().getDoubleExtra("toLocationLat",00);
            toLng=getIntent().getDoubleExtra("toLocationLng",00);
            toLatLng=new LatLng(toLat,toLng);
            fromSearch.setText("  "+fromLocationName);
            toSearch.setText("  "+toLocationName);
            markerOptions=new MarkerOptions().position(fromLatLng).title(fromLocationName);
            markerOptions1=new MarkerOptions().position(toLatLng).title(toLocationName);
            map.addMarker(markerOptions);

            if(toLocationName!=null){
                map.addMarker(markerOptions1);
            bounds((26.865109+toLat)/2,(75.807679+toLng)/2);}
            else{
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(fromLatLng, 17));
            }

            String locationString="26.865109&75.807679&&"+toLat+"&"+toLng;

            DirectionRouteSearch(locationString);
        }
    }

    private void DirectionRouteSearch(String locationString) {
        String loction=locationString;
        switch (loction){
            case "26.865109&75.807679&&26.864692&75.814671":
                map.addPolyline(new PolylineOptions().add(fromLatLng).add(new LatLng(26.8641208,75.8123802)).add(new LatLng(26.8649378,75.8133903)).add(new LatLng(26.864816, 75.813957)).width(5).color(Color.RED));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        getIntentActivity();
    }

    private  void bounds(double lat, double lng){
        LatLng  latlng = new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latlng,15);
        map.animateCamera(cameraUpdate);

    }

}
