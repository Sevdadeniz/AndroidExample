package com.example.lenovo.cocuklaricindortislem.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.cocuklaricindortislem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToplamaFragment extends Fragment {


    public ToplamaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toplama, container, false);
    }

}
