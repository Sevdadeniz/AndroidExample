package com.example.lenovo.denemee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GirisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
    }
    public void click(View v){
        switch (v.getId()){
            case R.id.btnKaydol:
                startActivity(new Intent(GirisEkrani.this,KayitEkrani.class));
                break;
        }

    }

}
