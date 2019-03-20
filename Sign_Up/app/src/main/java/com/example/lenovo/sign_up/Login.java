package com.example.lenovo.sign_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Giriş Yap");

    }

    public void btn_kaydol(View view){
        startActivity(new Intent(getApplicationContext(),Sign_up.class));
    }


}
