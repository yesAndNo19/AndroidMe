package com.example.androidme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BodyFragment extends Fragment {
public int mVar=0;
public void valueChanger(int value){
    mVar=value;
}
    public BodyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.body_view,container,false);
        final ImageView theBodyImage= (ImageView) rootView.findViewById(R.id.body_image);
        final AndroidImageAssets ListsClass=new AndroidImageAssets();

        if(savedInstanceState!=null){
            mVar=savedInstanceState.getInt("var");}

        theBodyImage.setImageResource(AndroidImageAssets.getBodies().get(mVar));
        theBodyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mVar==ListsClass.getBodies().size()-1){

                    mVar=0;
                }
                mVar+=1;
                theBodyImage.setImageResource(ListsClass.getBodies().get(mVar));

            }
        });
return  rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("var",mVar);
        super.onSaveInstanceState(outState);
    }
}
