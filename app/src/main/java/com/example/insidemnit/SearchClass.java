package com.example.insidemnit;

import android.view.LayoutInflater;
import android.widget.SearchView;

import com.google.android.gms.maps.model.LatLng;

public class SearchClass {
    private String location;
    private LatLng latLng;

    public SearchClass(String location, LatLng latLng){
        this.location=location;
        this.latLng=latLng;
    }

    public LatLng getLatLng(){
        return latLng;
    }
    public String getLocation1(){
        return location;
    }
}
