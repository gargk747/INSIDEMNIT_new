package com.example.insidemnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.ScaleAnimation;

public class FloorPlan extends AppCompatActivity {

    private float mscale= 1f;
    private ScaleGestureDetector mScaleDeetector;
    GestureDetector gestureDetector;
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

//        gestureDetector = new GestureDetector(this,new GestureListener());
//        mScaleDeetector= new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener(){
//            @Override
//            public boolean onScale(ScaleGestureDetector detector) {
//                float scale= 1-detector.getScaleFactor();
//
//                float preScale=mscale;
//                mscale+=scale;
//
//                if(mscale<0.1f)
//                    mscale=0.1f;
//                if(mscale>10f)
//                    mscale=10f;
//
//                ScaleAnimation scaleAnimation= new ScaleAnimation(1f/preScale,1f/mscale,1f/preScale,1f/mscale,detector.getFocusX(),detector.getFocusY());
//                scaleAnimation.setDuration(0);
//                scaleAnimation.setFillAfter(true);
//                pager.startAnimation(scaleAnimation);
//                return true;
//            }
//        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        super.dispatchTouchEvent(ev);
//        mScaleDeetector.onTouchEvent(ev);
//        gestureDetector.onTouchEvent(ev);
//        return gestureDetector.onTouchEvent(ev);
//    }
//
//    private  class GestureListener extends GestureDetector.SimpleOnGestureListener{
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return true;
//        }
//
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//            return true;
//        }
//    }
}
