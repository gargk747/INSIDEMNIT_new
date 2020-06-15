package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class SearchRecyclerView extends AppCompatActivity {

    ArrayList<SearchClass> searchClasses= new ArrayList<>();
    private RecyclerView rvSearch;
    private SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recycler_view);


        searchClasses.add(new SearchClass(getIntent().getStringExtra("currentLocation"),new LatLng(getIntent().getDoubleExtra("curLocationLat",0),getIntent().getDoubleExtra("curLocationLng",0))));
        searchClasses.add(new SearchClass("GARGI",new LatLng(26.864692, 75.814671)));
        searchClasses.add(new SearchClass("HOSTEL 1 PARIJAT", new LatLng(26.862416, 75.816007)));
        searchClasses.add(new SearchClass("HOSTEL 2 CHAITANYA",new LatLng(26.861856,75.815994)));
        searchClasses.add(new SearchClass("HOSTEL 3",new LatLng(26.860658,75.815774)));
        searchClasses.add(new SearchClass("HOSTEL 4 LOHIT",new LatLng(26.8600513,75.8177366)));
        searchClasses.add(new SearchClass("HOSTEL 5 VRIHASPATI",new LatLng(26.8605622,75.8172779)));
        searchClasses.add(new SearchClass("HOSTEL 6 KABIR",new LatLng(26.8608169,75.8190871)));
        searchClasses.add(new SearchClass("HOSTEL 7 DRONA", new LatLng(26.8596827,75.8184759)));
        searchClasses.add(new SearchClass("HOSTEL 8 VARUN", new LatLng(26.8601717,75.8188556)));
        searchClasses.add(new SearchClass("AUROBINDO", new LatLng(26.8627459,75.8202557)));
        searchClasses.add(new SearchClass("MAIN GATE", new LatLng(26.865099,75.807766)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN", new LatLng(26.864186,75.810712)));
        searchClasses.add(new SearchClass("PMC", new LatLng(26.864120,75.812395)));
        searchClasses.add(new SearchClass("VLTC FRONT PORCH", new LatLng(26.863437,75.814604)));
        searchClasses.add(new SearchClass("GANGA", new LatLng(26.863538,75.816441)));
        searchClasses.add(new SearchClass("HOSTEL PG", new LatLng(26.863125,75.815942)));
        searchClasses.add(new SearchClass("HOSTEL OFFICE", new LatLng(26.862049,75.816040)));
        searchClasses.add(new SearchClass("TENNIS COURT", new LatLng(26.860332,75.814825)));
        searchClasses.add(new SearchClass("FOOTBALL GROUND", new LatLng(26.860166,75.814716)));
        searchClasses.add(new SearchClass("LOHIT CANTEEN", new LatLng(26.859827,75.817864)));
        searchClasses.add(new SearchClass("MAI KI THADI", new LatLng(26.858945,75.815514)));
        searchClasses.add(new SearchClass("JHALANA GATE", new LatLng(26.862462,75.822613)));
        searchClasses.add(new SearchClass("BACK GATE", new LatLng(26.856941,75.816912)));
        searchClasses.add(new SearchClass("ACHARYA BHAWAN", new LatLng(26.865562,75.818024)));




        rvSearch= findViewById(R.id.rvSearch);
        search= findViewById(R.id.search);

        final  SearchAdapter adapter = new SearchAdapter(SearchRecyclerView.this,searchClasses);
        rvSearch.setAdapter(adapter);

        search.setActivated(true);
        search.setQueryHint("Name");
        search.onActionViewExpanded();
        search.setIconified(false);
        search.clearFocus();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }


}
