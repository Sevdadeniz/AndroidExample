package com.example.lenovo.samar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.samar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiyasetFragment extends Fragment {


    public SiyasetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_siyaset, container, false);
    }

}
