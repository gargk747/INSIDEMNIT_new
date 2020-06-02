package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
            fromLatLng=new LatLng(fromLat,fromLng);
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
            bounds((fromLat+toLat)/2,(fromLng+toLng)/2);}
            else{
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(fromLatLng, 15));
            }

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        getIntentActivity();



    }

    private  void bounds(double lat, double lng){
        LatLng  latlng = new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latlng,5);
        map.animateCamera(cameraUpdate);

    }
}
