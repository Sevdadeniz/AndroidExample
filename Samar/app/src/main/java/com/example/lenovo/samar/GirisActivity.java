package com.example.lenovo.samar;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class GirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        ImageView image = findViewById(R.id.image);

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

    }
}
