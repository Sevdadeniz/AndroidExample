package com.example.lenovo.newapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtKullanici = findViewById(R.id.editTextKullanici_Adi);
        final EditText edtSifre = findViewById(R.id.editTextSifre);
        Button butongiris = findViewById(R.id.buttonGiris);

        butongiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kad = edtKullanici.getText().toString();
                String sifre = edtSifre.getText().toString();

                if(kad.equals("sevda") && sifre.equals("123")){
                    Intent gecis = new Intent(MainActivity.this,GirisBasarili.class);
                    startActivity(gecis);
                }else{
                    Toast.makeText(getApplicationContext(),"Şifreniz yanlış",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
