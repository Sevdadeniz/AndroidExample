package com.example.lenovo.samar;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        TextView txtview = (TextView) findViewById(R.id.textviewSUnuttum);
        txtview.setPaintFlags(txtview.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

        TextView txtview2 = (TextView) findViewById(R.id.textviewKayit);
        txtview2.setPaintFlags(txtview2.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

    }


    public void btnkaydol(View view){
        startActivity(new Intent(getApplicationContext(),HomeScreen.class));
    }
    public void textviewSUnuttum(View view){
        startActivity(new Intent(getApplicationContext(),PasswordForgot.class));
    }
    public void textviewKayit(View view){
        startActivity(new Intent(getApplicationContext(),SignupScreen.class));
    }

}
