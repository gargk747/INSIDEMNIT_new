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
    double LatitudeList[]={26.865109,26.864824,26.864954,26.864838,26.864788,26.864945};
    double LongitudeList[]={75.807679,75.808828,75.808470,75.808864,75.809230,75.813401};
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
            fromLat=26.865038;
            fromLng=75.807928;
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
                if((fromLat-LatitudeList[i]<=0.101)&&(fromLng-LongitudeList[i]<=0.101)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(fromLat>LatitudeList[i]&&LongitudeList[i]>fromLng){
                if((fromLat-LatitudeList[i]<=0.101)&&(LongitudeList[i]-fromLng<=0.101)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(LatitudeList[i]>fromLat&&fromLng>LongitudeList[i]){
                if((LatitudeList[i]-fromLat<=0.101)&&(fromLng-LongitudeList[i]<=0.101)){
                    MarkerOptions markerOptionss= new MarkerOptions().position(new LatLng(LatitudeList[i],LongitudeList[i]));
                    map.addMarker(markerOptionss);
                }
            }
            else if(LatitudeList[i]>fromLat&&LongitudeList[i]>fromLng){
                if((LatitudeList[i]-fromLat<=0.101)&&(LongitudeList[i]-fromLng<=0.101)){
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
