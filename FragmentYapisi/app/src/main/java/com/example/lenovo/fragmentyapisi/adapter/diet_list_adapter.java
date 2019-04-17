package com.example.lenovo.fragmentyapisi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.fragmentyapisi.R;
import com.example.lenovo.fragmentyapisi.fragments.Diet;
import com.example.lenovo.fragmentyapisi.models.Diets;

import java.util.List;

public class diet_list_adapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Diets> dietsList;

    public diet_list_adapter(LayoutInflater layoutInflater, List<Diets> dietsList) {
        this.layoutInflater = layoutInflater;
        this.dietsList = dietsList;
    }

    @Override
    public int getCount() {
        return dietsList.size();
    }

    @Override
    public Object getItem(int i) {
        return dietsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View dietView = layoutInflater.inflate(R.layout.custom_adapter_list,null);
        ImageView resim = dietView.findViewById(R.id.imageView);
        TextView besinIsmi = dietView.findViewById(R.id.custom_textView);
        TextView kalori = dietView.findViewById(R.id.custom_tv_textView);

        Diets diet =dietsList.get(i);
        resim.setImageResource(diet.getResim());
        besinIsmi.setText(diet.getBesinAdi());
        kalori.setText(diet.getKalori());
        return dietView;
    }
}
