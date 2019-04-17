package com.example.lenovo.fragmentyapisi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.fragmentyapisi.R;
import com.example.lenovo.fragmentyapisi.adapter.diet_list_adapter;
import com.example.lenovo.fragmentyapisi.models.Diets;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Diet extends Fragment {


    public Diet() {
        // Required empty public constructor
    }

    List<Diets> dietsList= new ArrayList<Diets>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_diet, container, false);
        // Inflate the layout for this fragment

        dietsList.add(new Diets("5000","Patates Kızartması",R.drawable.potato));
        dietsList.add(new Diets("10000","Burger",R.drawable.bb));
        dietsList.add(new Diets("8000","Çikolata",R.drawable.cikolata));
        dietsList.add(new Diets("6000","Cips",R.drawable.cips));

        ListView list = view.findViewById(R.id.custom_list);
        diet_list_adapter adapter = new diet_list_adapter(getLayoutInflater(),dietsList);
        list.setAdapter(adapter);

        return view;
    }

}
