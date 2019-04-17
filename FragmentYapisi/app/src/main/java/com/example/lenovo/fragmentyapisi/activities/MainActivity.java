package com.example.lenovo.fragmentyapisi.activities;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lenovo.fragmentyapisi.R;
import com.example.lenovo.fragmentyapisi.fragments.Diet;
import com.example.lenovo.fragmentyapisi.fragments.Health;
import com.example.lenovo.fragmentyapisi.fragments.Home;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,new Home());
        transaction.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFragment= new Home();
                    break;
                case R.id.nav_health:
                    selectedFragment= new Health();
                    break;

                case R.id.nav_diet:
                    selectedFragment= new Diet();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,selectedFragment);
            transaction.commit();


            return true;
        }
    };


}
