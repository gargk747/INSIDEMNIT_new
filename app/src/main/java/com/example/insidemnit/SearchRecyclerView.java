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
        searchClasses.add(new SearchClass("GARGI",new LatLng(26.864945, 75.813401)));
        searchClasses.add(new SearchClass("HOSTEL 1 PARIJAT", new LatLng(26.862461, 75.816039)));
        searchClasses.add(new SearchClass("HOSTEL 2 CHAITANYA",new LatLng(26.861880, 75.816020)));
        searchClasses.add(new SearchClass("HOSTEL 3",new LatLng(26.860681, 75.815778)));
        searchClasses.add(new SearchClass("HOSTEL 4 LOHIT",new LatLng(26.859845, 75.817698)));
        searchClasses.add(new SearchClass("HOSTEL 5 VRIHASPATI",new LatLng(26.860589, 75.817616)));
        searchClasses.add(new SearchClass("HOSTEL 6 KABIR",new LatLng(26.860753, 75.819367)));
        searchClasses.add(new SearchClass("HOSTEL 7 DRONA", new LatLng(26.859652, 75.818441)));
        searchClasses.add(new SearchClass("HOSTEL 8 VARUN", new LatLng(26.860344, 75.819365)));
        searchClasses.add(new SearchClass("AUROBINDO", new LatLng(26.862243, 75.820118)));
        searchClasses.add(new SearchClass("MAIN GATE", new LatLng(26.865074, 75.807794)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN", new LatLng(26.864270, 75.810724)));
        searchClasses.add(new SearchClass("PMC", new LatLng(26.864103, 75.812421)));
        searchClasses.add(new SearchClass("VLTC FRONT PORCH", new LatLng(26.863489, 75.814605)));
        searchClasses.add(new SearchClass("GANGA", new LatLng(26.863545, 75.816433)));
        searchClasses.add(new SearchClass("HOSTEL PG", new LatLng(26.863150, 75.815929)));
        searchClasses.add(new SearchClass("HOSTEL OFFICE", new LatLng(26.862088, 75.815990)));
        searchClasses.add(new SearchClass("TENNIS COURT", new LatLng(26.860368, 75.814816)));
        searchClasses.add(new SearchClass("FOOTBALL GROUND", new LatLng(26.860214, 75.814705)));
        searchClasses.add(new SearchClass("LOHIT CANTEEN", new LatLng(26.859867, 75.817861)));
        searchClasses.add(new SearchClass("MAI KI THADI", new LatLng(26.858919, 75.815528)));
        searchClasses.add(new SearchClass("JHALANA GATE", new LatLng(26.862490, 75.822631)));
        searchClasses.add(new SearchClass("BACK GATE", new LatLng(26.856983, 75.816861)));
        searchClasses.add(new SearchClass("ACHARYA BHAWAN", new LatLng(26.865616, 75.818008)));



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
