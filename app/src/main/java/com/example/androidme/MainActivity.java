package com.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
int g=8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[]theListFromIntent= getIntent().getIntArrayExtra("v");


if(savedInstanceState==null){
            FrameLayout theContainer = (FrameLayout) findViewById(R.id.frame_container);
            BodyFragment mFragment = new BodyFragment();

            mFragment.mVar=theListFromIntent[1];

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.frame_container, mFragment).commit();

            HeadFragment mHeadFragment = new HeadFragment();
            mHeadFragment.mVariable=theListFromIntent[0];

            fragmentManager.beginTransaction().add(R.id.frame_container_head, mHeadFragment).commit();
            LegFragment mLegFragment = new LegFragment();

            mLegFragment.mVariabl=theListFromIntent[2];
            fragmentManager.beginTransaction().add(R.id.frame_container_leg, mLegFragment).commit();


    }


}


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }
}
