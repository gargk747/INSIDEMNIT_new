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
        searchClasses.add(new SearchClass("ACHARYA BHAWAN", new LatLng(26.8656339444998, 75.81796628679359)));
        searchClasses.add(new SearchClass("AMUL", new LatLng(26.861932963012634,75.81250647918301)));
        searchClasses.add(new SearchClass("ANAAPURNA", new LatLng(26.863096157224803, 75.81060479318785)));
        searchClasses.add(new SearchClass("ARCHITECTURE DEPARTMENT", new LatLng(26.862164953887216,75.81113620237582)));
        searchClasses.add(new SearchClass("ATM (ICICI)", new LatLng(26.861979622468567, 75.81233213559705)));
        searchClasses.add(new SearchClass("AUROBINDO", new LatLng(26.862154388040576, 75.8201289315467)));
        searchClasses.add(new SearchClass("BACK GATE", new LatLng(26.85705979574428, 75.81688310599297)));
        searchClasses.add(new SearchClass("BARBER SHOP", new LatLng(26.86094699106357, 75.81555972949707)));
        searchClasses.add(new SearchClass("CC", new LatLng(26.863487374198115, 75.81045324837851)));
        searchClasses.add(new SearchClass("CENTRAL LAWN", new LatLng(26.862202859721016, 75.80932523469406)));
        searchClasses.add(new SearchClass("CHILDRENS PARK", new LatLng(26.865366059818353, 75.81024154635591)));
        searchClasses.add(new SearchClass("CIVIL DEPARTMENT", new LatLng(26.861651368060755, 75.80915896123976)));
        searchClasses.add(new SearchClass("CSE DEPARTMENT", new LatLng(26.862913614038472, 75.81070516630007)));
        searchClasses.add(new SearchClass("DEAN'S GATE", new LatLng(26.858981543619592, 75.81050955197658)));
        searchClasses.add(new SearchClass("ESTATE SECTION", new LatLng(26.859651480310475, 75.81090192702459)));
        searchClasses.add(new SearchClass("FOOTBALL GROUND", new LatLng(26.860185283348798, 75.81481842360607)));
        searchClasses.add(new SearchClass("GANGA", new LatLng(26.863568704937194, 75.81644455122755)));
        searchClasses.add(new SearchClass("GARGI",new LatLng(26.86481157592848, 75.8140218717536)));
        searchClasses.add(new SearchClass("HOSTEL 1 PARIJAT", new LatLng(26.8624467438315, 75.8160336221946)));
        searchClasses.add(new SearchClass("HOSTEL 2 CHAITANYA",new LatLng(26.861921526911118, 75.81598936574585)));
        searchClasses.add(new SearchClass("HOSTEL 3",new LatLng(26.86068737045096,75.81555972949707)));
        searchClasses.add(new SearchClass("HOSTEL 4 LOHIT",new LatLng(26.86014078461353, 75.81780538226457)));
        searchClasses.add(new SearchClass("HOSTEL 5 VRIHASPATI",new LatLng(26.86058106466288, 75.81779197121949)));
        searchClasses.add(new SearchClass("HOSTEL 6 KABIR",new LatLng(26.86050609930755,75.81937035420157)));
        searchClasses.add(new SearchClass("HOSTEL 7 DRONA", new LatLng(26.859855811013706, 75.8182962731635)));
        searchClasses.add(new SearchClass("HOSTEL 8 VARUN", new LatLng(26.86050609930755,75.81937035420157)));
        searchClasses.add(new SearchClass("HOSTEL OFFICE", new LatLng(26.862080647556773, 75.81597729580528)));
        searchClasses.add(new SearchClass("HOSTEL PG", new LatLng(26.863090629804013, 75.8155997602106)));
        searchClasses.add(new SearchClass("INDRADHANUSH GUEST HOUSE", new LatLng(26.865679474293216, 75.81086394709091)));
        searchClasses.add(new SearchClass("JHALANA GATE", new LatLng(26.862490, 75.822631)));
        searchClasses.add(new SearchClass("LIBRARY", new LatLng(26.862137351152054,75.80887139533168)));
        searchClasses.add(new SearchClass("LOHIT CANTEEN", new LatLng(26.86014078461353, 75.81780538226457)));
        searchClasses.add(new SearchClass("MAI KI THADI", new LatLng(26.8590984315442, 75.81552805950615)));
        searchClasses.add(new SearchClass("MAIN GATE", new LatLng(26.865101662250517, 75.80770027096875)));
        searchClasses.add(new SearchClass("MATERIAL RESEARCH CENTER", new LatLng(26.861549269372933, 75.81136274512174)));
        searchClasses.add(new SearchClass("MBA DEPARTMENT", new LatLng(26.86260037342677, 75.80897860259563)));
        searchClasses.add(new SearchClass("METALLURGY DEPARTMENT", new LatLng(26.862137058048493, 75.80966453413444)));
        searchClasses.add(new SearchClass("MIIC", new LatLng(26.860748633559105,75.80842216246474)));
        searchClasses.add(new SearchClass("MNIT TEMPLE", new LatLng(26.86670726912214, 75.81223282640205)));
        searchClasses.add(new SearchClass("NEW CHEMICAL DEPARMENT", new LatLng(26.86142367591516, 75.81133519674249)));
        searchClasses.add(new SearchClass("PMC", new LatLng(26.86412287676916, 75.81239104270935)));
        searchClasses.add(new SearchClass("STAFF'S GATE", new LatLng(26.867019602792364, 75.81065958579379)));
        searchClasses.add(new SearchClass("SURYODAY GUEST HOUSE", new LatLng(26.865600966665617, 75.81108912071309)));
        searchClasses.add(new SearchClass("TENNIS COURT", new LatLng(26.860185283348798, 75.81481842360607)));
        searchClasses.add(new SearchClass("TRIBOLOGY LAB", new LatLng(26.859840587040257, 75.81002430909746)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN (MAIN ENTRY)", new LatLng(26.864459655095548, 75.81078208124909)));
        searchClasses.add(new SearchClass("PRABHA BHAWAN PARKING", new LatLng(26.863760734129084, 75.81105385789104)));
        searchClasses.add(new SearchClass("VLTC BACK PORCH", new LatLng(26.862429380987724,75.81436108237666)));
        searchClasses.add(new SearchClass("VLTC CANTEEN", new LatLng(26.862473647457264, 75.81408347374362)));
        searchClasses.add(new SearchClass("VLTC FRONT PORCH", new LatLng(26.863471891195946, 75.81458796607814)));


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
