package com.example.androidme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HeadFragment extends Fragment {
   int mVariable;
    public HeadFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.head_view,container,false);
        final ImageView headImage=rootView.findViewById(R.id.head_image);
        if(savedInstanceState!=null){

            mVariable=savedInstanceState.getInt("van");
        }
        headImage.setImageResource(AndroidImageAssets.getHeads().get(mVariable));
        headImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mVariable==AndroidImageAssets.getHeads().size()-1){
                    mVariable=0;
                }
                mVariable+=1;
                headImage.setImageResource(AndroidImageAssets.getHeads().get(mVariable));

            }
        });
return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("van",mVariable);
    }
}
