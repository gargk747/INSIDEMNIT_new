package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class NavigationView extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    String fromLocationName;
    String toLocationName;
    LatLng fromLatLng;
    LatLng toLatLng;
    TextView fromSearch;
    TextView toSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        TextView back= findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NavigationView.this,MainActivity.class);
                startActivity(intent);
            }
        });
        fromSearch=findViewById(R.id.searchFrom);
        toSearch=findViewById(R.id.searchTo);


        getIntentActivity();
    }

    public void getIntentActivity(){
        if(getIntent().hasExtra("toLocationName")){
            fromLocationName=getIntent().getStringExtra("fromLocationName");
            fromLatLng=new LatLng(getIntent().getDoubleExtra("fromLocationLat",00),getIntent().getDoubleExtra("fromLocationLng",00));
            toLocationName=getIntent().getStringExtra("toLocationName");
            toLatLng=new LatLng(getIntent().getDoubleExtra("toLocationLat",00),getIntent().getDoubleExtra("toLocationLng",00));
            fromSearch.setText("  "+fromLocationName);
            toSearch.setText("  "+toLocationName);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
    }
}
