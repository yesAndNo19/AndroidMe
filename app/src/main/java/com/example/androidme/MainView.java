package com.example.androidme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainView extends AppCompatActivity {
    int headIndex=0;
    int bodyIndex=0;
    int legIndex=0;
    int screenOrientation;
 Context mContext=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation==1) {
            setContentView(R.layout.grid_view_list);

            GridView ListOfImages = (GridView) findViewById(R.id.list_view);
            MasterListAdapter myAdapter = new MasterListAdapter(this, AndroidImageAssets.getAll());
            ListOfImages.setAdapter(myAdapter);
            final Intent intent = new Intent(this, MainActivity.class);

            ListOfImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.v("MainView", "iiiiiiiiiiiiiiiiiiiiii" + position);
                    if (position <= 11) {
                        headIndex = position;

                    }

                    if (position > 11 && position <= 23) {
                        bodyIndex = position - 12;

                    }
                    if (position > 23) {
                        legIndex = position - 24;

                    }

                    int[] valuesList = {headIndex, bodyIndex, legIndex};
                    intent.putExtra("v", valuesList);
                }

            });

            Button toPreviewButton = (Button) findViewById(R.id.go_to_preview);
            toPreviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (intent.hasExtra("v")) {
                        startActivityForResult(intent, 1);
                    } else {
                        int[] k = {0, 0, 0};
                        intent.putExtra("v", k);
                        startActivityForResult(intent, 2);
                    }
                }
            });
        }
        else{setContentView(R.layout.tablet_layout);

            GridView ListOfImages = (GridView) findViewById(R.id.list_view);
            MasterListAdapter myAdapter = new MasterListAdapter(this, AndroidImageAssets.getAll());
            ListOfImages.setAdapter(myAdapter);

            BodyFragment mFragment = new BodyFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.frame_container, mFragment).commit();
            HeadFragment mHeadFragment = new HeadFragment();

            fragmentManager.beginTransaction().add(R.id.frame_container_head, mHeadFragment).commit();
            LegFragment mLegFragment = new LegFragment();

            fragmentManager.beginTransaction().add(R.id.frame_container_leg, mLegFragment).commit();
            ListOfImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.v("MainView", "iiiiiiiiiiiiiiiiiiiiii" + position);
                    if (position <= 11) {
                        headIndex = position;

                    }

                    if (position > 11 && position <= 23) {
                        bodyIndex = position - 12;

                    }
                    if (position > 23) {
                        legIndex = position - 24;

                    }

                    int[] theListFromIntent = {headIndex, bodyIndex, legIndex};
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

            });

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
