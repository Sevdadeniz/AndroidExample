package com.example.lenovo.newapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lenovo.newapp.fragments.HomeFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        findViewById(R.id.btnAnasayfa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, HomeFragment.class);
                NavUtils.navigateUpTo(StartActivity.this, intent);
                startActivity(intent);

            }
        });

    }

}
