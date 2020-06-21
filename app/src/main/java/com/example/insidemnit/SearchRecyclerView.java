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
        searchClasses.add(new SearchClass("ACHARYA BHAWAN", new LatLng(26.865634, 75.817966)));
        searchClasses.add(new SearchClass("AMUL", new LatLng(26.861933,75.812506)));
        searchClasses.add(new SearchClass("ANAAPURNA", new LatLng(26.863096, 75.810605)));
        searchClasses.add(new SearchClass("ARCHITECTURE DEPARTMENT", new LatLng(26.862165,75.811136)));
        searchClasses.add(new SearchClass("ATM (ICICI)", new LatLng(26.861980, 75.812332)));
        searchClasses.add(new SearchClass("AUROBINDO", new LatLng(26.862154,75.820129)));
        searchClasses.add(new SearchClass("BACK GATE", new LatLng(26.857060, 75.816883)));
        searchClasses.add(new SearchClass("BARBER SHOP", new LatLng(26.860947, 75.815560)));
        searchClasses.add(new SearchClass("BASKETBALL COURT", new LatLng(26.861941, 75.814528)));
        searchClasses.add(new SearchClass("CC", new LatLng(26.863487, 75.810453)));
        searchClasses.add(new SearchClass("CENTRAL LAWN", new LatLng(26.862203, 75.809325)));
        searchClasses.add(new SearchClass("CHILDRENS PARK", new LatLng(26.865366, 75.810242)));
        searchClasses.add(new SearchClass("CIVIL DEPARTMENT", new LatLng(26.861651, 75.809159)));
        searchClasses.add(new SearchClass("CSE DEPARTMENT", new LatLng(26.862914, 75.810705)));
        searchClasses.add(new SearchClass("DEAN'S GATE", new LatLng(26.858982, 75.810510)));
        searchClasses.add(new SearchClass("ECE DEPARTMENT", new LatLng(26.862794,75.811738)));
        searchClasses.add(new SearchClass("ESTATE SECTION", new LatLng(26.859651, 75.810902)));
        searchClasses.add(new SearchClass("FOOTBALL GROUND", new LatLng(26.860185, 75.814818)));
        searchClasses.add(new SearchClass("GANGA", new LatLng(26.863569, 75.816445)));
        searchClasses.add(new SearchClass("GARGI",new LatLng(26.864812, 75.814022)));
        searchClasses.add(new SearchClass("HOSTEL 1 PARIJAT", new LatLng(26.862447, 75.816034)));
        searchClasses.add(new SearchClass("HOSTEL 2 CHAITANYA",new LatLng(26.861922, 75.815989)));
        searchClasses.add(new SearchClass("HOSTEL 3",new LatLng(26.860687,75.815560)));
        searchClasses.add(new SearchClass("HOSTEL 4 LOHIT",new LatLng(26.860141, 75.817805)));
        searchClasses.add(new SearchClass("HOSTEL 5 VRIHASPATI",new LatLng(26.860581, 75.817792)));
        searchClasses.add(new SearchClass("HOSTEL 6 KABIR",new LatLng(26.860506,75.819370)));
        searchClasses.add(new SearchClass("HOSTEL 7 DRONA", new LatLng(26.859856, 75.818296)));
        searchClasses.add(new SearchClass("HOSTEL 8 VARUN", new LatLng(26.860506,75.819370)));
        searchClasses.add(new SearchClass("HOSTEL OFFICE", new LatLng(26.862081, 75.815977)));
        searchClasses.add(new SearchClass("HOSTEL PG", new LatLng(26.863091, 75.815600)));
        searchClasses.add(new SearchClass("INDRADHANUSH GUEST HOUSE", new LatLng(26.865679, 75.810864)));
        searchClasses.add(new SearchClass("JHALANA GATE", new LatLng(26.862476, 75.822596)));
        searchClasses.add(new SearchClass("LIBRARY", new LatLng(26.862137,75.808871)));
        searchClasses.add(new SearchClass("LOHIT CANTEEN", new LatLng(26.860141, 75.817805)));
        searchClasses.add(new SearchClass("MAI KI THADI", new LatLng(26.859098, 75.815528)));
        searchClasses.add(new SearchClass("MAIN GATE", new LatLng(26.865102, 75.807700)));
        searchClasses.add(new SearchClass("MATERIAL RESEARCH CENTER", new LatLng(26.861549, 75.811363)));
        searchClasses.add(new SearchClass("MBA DEPARTMENT", new LatLng(26.862600, 75.808979)));
        searchClasses.add(new SearchClass("METALLURGY DEPARTMENT", new LatLng(26.862137, 75.809665)));
        searchClasses.add(new SearchClass("MIIC", new LatLng(26.860749,75.808422)));
        searchClasses.add(new SearchClass("MNIT TEMPLE", new LatLng(26.866707, 75.812233)));
        searchClasses.add(new SearchClass("NEW CHEMICAL DEPARMENT", new LatLng(26.861424, 75.811335)));
        searchClasses.add(new SearchClass("PMC", new LatLng(26.864123, 75.812391)));
        searchClasses.add(new SearchClass("STAFF'S GATE", new LatLng(26.867020, 75.810660)));
        searchClasses.add(new SearchClass("SURYODAY GUEST HOUSE", new LatLng(26.865601, 75.811089)));
        searchClasses.add(new SearchClass("TENNIS COURT", new LatLng(26.860185, 75.814818)));
        searchClasses.add(new SearchClass("TRIBOLOGY LAB", new LatLng(26.859841, 75.810024)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN (MAIN ENTRY)", new LatLng(26.864460, 75.810782)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN PARKING", new LatLng(26.863761, 75.811054)));
        searchClasses.add(new SearchClass("VLTC BACK PORCH", new LatLng(26.862429,75.814361)));
        searchClasses.add(new SearchClass("VLTC CANTEEN", new LatLng(26.862474, 75.814083)));
        searchClasses.add(new SearchClass("VLTC FRONT PORCH", new LatLng(26.863472, 75.814588)));
        searchClasses.add(new SearchClass("VOLLEYBALL COURT", new LatLng(26.862025, 75.813970)));


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
