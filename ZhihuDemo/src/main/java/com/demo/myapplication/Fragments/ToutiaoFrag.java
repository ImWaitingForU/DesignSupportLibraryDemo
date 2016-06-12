package com.demo.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.myapplication.R;

/**
 * Created by Administrator on 2016/3/31.
 */
public class ToutiaoFrag extends Fragment{

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.toutiao_frag,container,false);
        return view;
    }

}
