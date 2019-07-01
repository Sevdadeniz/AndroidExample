package com.example.lenovo.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.newapp.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,new HomeFragment());
        transaction.commit();


    }
}
