package com.example.insidemnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    TextView searchbar;
    ImageButton layer;
    ImageButton locationBtn;
    ImageButton MNIT_locationBtn;
    ImageButton navBtn;
    double defalutLat = 26.8625892;
    double defaultLng = 75.8143854;
    Location mlocation;
    double locationLat;
    double locationLng;
    String locationName1;
    GoogleApiClient googleApiClient;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int Request_code = 101;
    String api_key = "AIzaSyAPEBZCsV9z-g0QlLU33GNuVO1C4h3GoO8";
    private long backPressedtime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchbar = findViewById(R.id.searchbar);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getlastLocation();

    }

    private void getIncomingIntent() {
        Log.d("MainActivity", "Incoming Intent");
        if (getIntent().hasExtra("locationName") && getIntent().hasExtra("locationLat") && getIntent().hasExtra("locationLng")) {
            locationName1 = getIntent().getStringExtra("locationName");
            locationLat = getIntent().getDoubleExtra("locationLat", 00);
            locationLng = getIntent().getDoubleExtra("locationLng", 00);
            searchbar.setText(locationName1);
            LatLng latLng111 = new LatLng(locationLat, locationLng);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng111).title(locationName1);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng111, 17));
            map.addMarker(markerOptions);
        }
    }

    private void getlastLocation() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                new AlertDialog.Builder(this)
                        .setTitle("Required Location Permission")
                        .setMessage("You have to give this permission to access the features")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]
                                        {Manifest.permission.ACCESS_COARSE_LOCATION}, Request_code);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]
                        {Manifest.permission.ACCESS_FINE_LOCATION}, Request_code);
            }
        }
        else {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        mlocation = location;
                        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                        mapFragment.getMapAsync(MainActivity.this);
                    }
                }
            });
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMapToolbarEnabled(false);
        searchbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SearchRecyclerView.class);
                intent.putExtra("currentLocation","Current Location");
                intent.putExtra("curLocationLat",mlocation.getLatitude());
                intent.putExtra("curLocationLng",mlocation.getLongitude());

                startActivity(intent);
            }
        });

        getIncomingIntent();

        navBtn=findViewById(R.id.nav_btn);
        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,NearestPointSelector.class);
                intent1.putExtra("fromLocationName","Current Location");
                intent1.putExtra("fromLocationLat",mlocation.getLatitude());
                intent1.putExtra("fromLocationLng",mlocation.getLongitude());
                intent1.putExtra("toLocationName",locationName1);
                intent1.putExtra("toLocationLat",locationLat);
                intent1.putExtra("toLocationLng",locationLng);
                startActivity(intent1);

            }
        });

        layer= findViewById(R.id.layerBtn);
        layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    Toast.makeText(MainActivity.this, "SATELITE VIEW", Toast.LENGTH_SHORT).show();
                }
                else{
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    Toast.makeText(MainActivity.this, "NORMAL VIEW", Toast.LENGTH_SHORT).show();
                }
            }
        });
        locationBtn = findViewById(R.id.locationBtn);
        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.clear();
                LatLng latLng = new LatLng(mlocation.getLatitude(), mlocation.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Current Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                map.addMarker(markerOptions);
                Toast.makeText(MainActivity.this, "CURRENT LOCATION", Toast.LENGTH_SHORT).show();
            }
        });
        MNIT_locationBtn=findViewById(R.id.locationMNITBtn);
        MNIT_locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.clear();
                bounds(defalutLat,defaultLng);
                Toast.makeText(MainActivity.this, "MALAVIYA NATIONAL INSTITUTE OF TECHNOLOGY", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private  void bounds(double lat, double lng){
        LatLng  latlng = new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latlng,15);
        map.animateCamera(cameraUpdate);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Intent a = new Intent(Intent.ACTION_MAIN);
                            a.addCategory(Intent.CATEGORY_HOME);
                            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(a);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Request_code && grantResults.length > 0) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getlastLocation();
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
