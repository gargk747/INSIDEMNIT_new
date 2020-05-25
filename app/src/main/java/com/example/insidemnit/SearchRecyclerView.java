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


        searchClasses.add(new SearchClass("GARGI",new LatLng(26.864692, 75.814671)));
        searchClasses.add(new SearchClass("HOSTEL 1", new LatLng(26.862076, 75.815597)));
        searchClasses.add(new SearchClass("HOSTEL 2",new LatLng(26.862057, 75.815592)));
        searchClasses.add(new SearchClass("HOSTEL 3",new LatLng(26.860678, 75.815590)));
        searchClasses.add(new SearchClass("HOSTEL 4",new LatLng(26.8600513,75.8177366)));
        searchClasses.add(new SearchClass("HOSTEL 5",new LatLng(26.8605622,75.8172779)));
        searchClasses.add(new SearchClass("HOSTEL 6",new LatLng(26.8608169,75.8190871)));
        searchClasses.add(new SearchClass("Hostel 6", new LatLng(26.8608169,75.8190871)));
        searchClasses.add(new SearchClass("Hostel 7", new LatLng(26.8596827,75.8184759)));
        searchClasses.add(new SearchClass("Hostel 8", new LatLng(26.8601717,75.8188556)));
        searchClasses.add(new SearchClass("Aurobindo", new LatLng(26.8627459,75.8202557)));


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
