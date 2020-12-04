package com.example.androidme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LegFragment extends Fragment {
  public int mVariabl;
    public LegFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.leg_view,container,false);
        final ImageView headImage=rootView.findViewById(R.id.leg_image);
       if(savedInstanceState!=null){
           mVariabl=savedInstanceState.getInt("val");
        }

        headImage.setImageResource(AndroidImageAssets.getLegs().get(mVariabl));
        headImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mVariabl==AndroidImageAssets.getLegs().size()-1){
                    mVariabl=0;
                }
                mVariabl+=1;
                headImage.setImageResource(AndroidImageAssets.getLegs().get(mVariabl));
            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("val",mVariabl);
    }
}
