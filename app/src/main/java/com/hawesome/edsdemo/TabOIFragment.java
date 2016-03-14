package com.hawesome.edsdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * Created by haisheng on 2016/3/7.
 */
public class TabOIFragment extends Fragment {

    Switch aSwitch;
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_tab3,container,false);
        aSwitch= (Switch) view.findViewById(R.id.switch1);
        imageView= (ImageView) view.findViewById(R.id.imageView);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    imageView.setImageResource(R.drawable.close);
                }else {
                    imageView.setImageResource(R.drawable.open);
                }
            }
        });
        return view;
    }
}
