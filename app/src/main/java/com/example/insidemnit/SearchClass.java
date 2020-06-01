package com.example.insidemnit;

import com.google.android.gms.maps.model.LatLng;
import java.io.Serializable;

public class SearchClass implements Serializable {
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
