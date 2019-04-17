package com.example.lenovo.samar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PasswordForgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgot);
    }
    public void btnconfirm(View view){
        startActivity(new Intent(getApplicationContext(),VerifyCode.class));
    }

}
