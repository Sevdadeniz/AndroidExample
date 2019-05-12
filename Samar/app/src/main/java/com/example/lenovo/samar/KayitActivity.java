package com.example.lenovo.samar;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class KayitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        ImageView image = findViewById(R.id.imagekayit);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm = window.getWindowManager();


        Display ekran = wm.getDefaultDisplay();
        Point point =new Point();
        ekran.getSize(point);

        int genislik = point.x;
        int yukseklik = point.y;

        image.getLayoutParams().width = (int) (yukseklik*1.6);
        image.getLayoutParams().height =  yukseklik;

        //Animasyon yapımı
        ObjectAnimator animator =ObjectAnimator.ofFloat(image,"x",0,-(yukseklik*1.6f-genislik),0,-(yukseklik*1.6f-genislik));
        animator.setDuration(210000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();

        findViewById(R.id.kaydet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KayitActivity.this, GirisActivity.class);
                NavUtils.navigateUpTo(KayitActivity.this, intent);
            }
        });
    }
}
