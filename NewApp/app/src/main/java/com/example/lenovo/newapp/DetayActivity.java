package com.example.lenovo.newapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    TextView baslik;
    TextView aciklama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        baslik=findViewById(R.id.SehirBaslik);
        aciklama=findViewById(R.id.Detay);

        Bundle bundle=getIntent().getExtras();
        String baslik_deger = bundle.getString("isim");
        String aciklama_deger = bundle.getString("aciklama");

        baslik.setText(baslik_deger);
        aciklama.setText(aciklama_deger);


    }
}
