package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class FloorPlan extends AppCompatActivity {

    int[]images;
    private ViewPager pager;
    private ViewPagerAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);

        images= new int[]{R.drawable.director,R.drawable.nav_new,R.drawable.pin2};
        pager=findViewById(R.id.ViewPagerFloorplan);
        adp= new ViewPagerAdapter(this,images);
        pager.setAdapter(adp);
    }
}
