package com.example.lenovo.fragmentyapisi.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fragmentyapisi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }

    EditText edtKilo;
    EditText edtBoy;
    TextView txtSonuc;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        edtBoy = view.findViewById(R.id.home_fragment_user_length_et);
        edtKilo = view.findViewById(R.id.home_fragment_user_weight_et);
        txtSonuc = view.findViewById(R.id.home_fragment_result_tv);
        button = view.findViewById(R.id.home_fragment_calculate_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hesapla();
            }
        });

        return view;
    }

    public void hesapla(){

        if(edtBoy.getText().toString().length() > 0 && edtKilo.getText().toString().length() > 0 ){
            double boy = Double.parseDouble(edtBoy.getText().toString());
            double kilo = Double.parseDouble(edtKilo.getText().toString());
            String cevap = "";
            boy= boy/100;
            double sonuc= (kilo/(boy*boy));

            if(sonuc<15){
                cevap = "Aşırı Zayıf";
            }
            else if(sonuc>15 && sonuc <=30){
                cevap = "Zayıf";
            }
            else if(sonuc>30 && sonuc <=40){
                cevap = "Normal";
            }
            else if(sonuc>40 ){
                cevap = "Azıcık Fazla";
            }
            else{
                cevap = "Azıcık Fazla";
            }
            txtSonuc.setText("Vücut kilo endeksiniz: "+sonuc+"\n"+"Durum:"+cevap);

        }
        else{
            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Hata");
            builder.setMessage("Alanlar boş geçilmez!");
            builder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();

        }


    }


}
