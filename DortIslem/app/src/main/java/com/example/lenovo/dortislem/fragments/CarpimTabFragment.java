package com.example.lenovo.dortislem.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.dortislem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarpimTabFragment extends Fragment {


    public CarpimTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carpim_tab, container, false);
    }

}
