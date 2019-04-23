package com.example.lenovo.gezgindostum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.gezgindostum.R;
import com.example.lenovo.gezgindostum.models.SehirModel;

import java.util.List;



    public  class CustomAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;
        List<SehirModel> sehirModelList;

        public CustomAdapter(LayoutInflater layoutInflater,List<SehirModel> sehirModels){

            this.layoutInflater=layoutInflater;
            this.sehirModelList=sehirModels;
        }

        @Override
        public int getCount() {
            return sehirModelList.size();
        }

        @Override
        public Object getItem(int position) {

            return sehirModelList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            View listeView= layoutInflater.inflate(R.layout.liste,null);
            ImageView imageView = listeView.findViewById(R.id.image);
            TextView baslik = listeView.findViewById(R.id.sehiradi);
            TextView aciklama = listeView.findViewById(R.id.sehiraciklama);

            SehirModel sehirModel=sehirModelList.get(position);
            imageView.setImageResource(sehirModel.getResim());
            baslik.setText(sehirModel.getIsim());
            aciklama.setText(sehirModel.getAciklama());


            return listeView;
        }
    }




