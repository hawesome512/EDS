package com.hawesome.edsdemo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by haisheng on 2016/2/26.
 */
public class TabFragment extends Fragment {

    static TabFragment newInstance(int i){
        TabFragment tabFragment=new TabFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",i);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int id=getArguments().getInt("id");
        View view=inflater.inflate(id,container,false);
        return view;
    }
}
