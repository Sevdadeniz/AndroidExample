package com.example.lenovo.gezgindostum.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.gezgindostum.R;
import com.example.lenovo.gezgindostum.activities.DetayActivity;
import com.example.lenovo.gezgindostum.adapters.CustomAdapter;
import com.example.lenovo.gezgindostum.models.SehirModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    List<SehirModel> listem = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        ListView listView = view.findViewById(R.id.listviewSehir);
        listem.add(new SehirModel(R.mipmap.ic_launcher,"İzmir","Türkiye nin en güzel şehri"));
        listem.add(new SehirModel(R.mipmap.ic_launcher,"Muğla","Türkiye nin en güzel şehri"));
        listem.add(new SehirModel(R.mipmap.ic_launcher,"Aydın","Türkiye nin en güzel şehri"));

        CustomAdapter adapter=new CustomAdapter(getLayoutInflater(),listem);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(getContext(), DetayActivity.class);

                switch (position){
                    case 0:
                        i.putExtra("isim","İzmir");
                        i.putExtra("aciklama","İzmir in Açıklaması");
                        startActivity(i);
                        break;
                    case 1:
                        i.putExtra("isim","Muğla");
                        i.putExtra("aciklama","Muğla nın Açıklaması");
                        startActivity(i);
                        break;

                    case 2:
                        i.putExtra("isim","Aydın");
                        i.putExtra("aciklama","Aydın in Açıklaması");
                        startActivity(i);
                        break;



                }
            }
        });

        return view;
    }

}
