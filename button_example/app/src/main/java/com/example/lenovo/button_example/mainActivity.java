package com.example.lenovo.button_example;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainActivity extends AppCompatActivity implements View.OnClickListener{

        Button openWeb;
        Button openMap;
        Button sendSms;
        Button dialCall;
        Button openfotoandvideo;
        Button openvoice;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.open_map);
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(getResources().getColor(R.color.btn1));
        gdDefault.setCornerRadius(20);
        btn.setBackgroundDrawable(gdDefault);

        Button btn2 = findViewById(R.id.open_web);
        GradientDrawable gdDefault2 = new GradientDrawable();
        gdDefault2.setColor(getResources().getColor(R.color.btn2));
        gdDefault2.setCornerRadius(20);
        btn2.setBackgroundDrawable(gdDefault2);

        Button btn3 = findViewById(R.id.send_sms);
        GradientDrawable gdDefault3 = new GradientDrawable();
        gdDefault3.setColor(getResources().getColor(R.color.btn3));
        gdDefault3.setCornerRadius(20);
        btn3.setBackgroundDrawable(gdDefault3);

        Button btn4 = findViewById(R.id.dial_call);
        GradientDrawable gdDefault4 = new GradientDrawable();
        gdDefault4.setColor(getResources().getColor(R.color.btn4));
        gdDefault4.setCornerRadius(20);
        btn4.setBackgroundDrawable(gdDefault4);

        Button btn5 = findViewById(R.id.open_foto_and_video);
        GradientDrawable gdDefault5 = new GradientDrawable();
        gdDefault5.setColor(getResources().getColor(R.color.btn5));
        gdDefault5.setCornerRadius(20);
        btn5.setBackgroundDrawable(gdDefault5);

        Button btn6 = findViewById(R.id.open_voice);
        GradientDrawable gdDefault6 = new GradientDrawable();
        gdDefault6.setColor(getResources().getColor(R.color.btn6));
        gdDefault6.setCornerRadius(20);
        btn6.setBackgroundDrawable(gdDefault6);





        openWeb = (Button) findViewById(R.id.open_web);
        openWeb.setOnClickListener(this);

        openMap = (Button) findViewById(R.id.open_map);
        openMap.setOnClickListener(this);

        sendSms = (Button) findViewById(R.id.send_sms);
        sendSms.setOnClickListener(this);

        dialCall = (Button) findViewById(R.id.dial_call);
        dialCall.setOnClickListener(this);

        openfotoandvideo = (Button) findViewById(R.id.open_foto_and_video);
        openfotoandvideo.setOnClickListener(this);

        openvoice = (Button) findViewById(R.id.open_voice);
        openvoice.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == openfotoandvideo){
            Intent photoAndVideoIntent = new Intent(mainActivity.this,cameraActivity.class);
            startActivity(photoAndVideoIntent);

        } else if(view == openvoice){
            Intent voiceIntent = new Intent(mainActivity.this,VoiceActivity.class);
            startActivity(voiceIntent);

        } else if(view == openMap){
            Intent mapIntent = new Intent(mainActivity.this,MapActivity.class);
            startActivity(mapIntent);

        } else if(view == openWeb){
            Intent webIntent = new Intent(mainActivity.this,WebActivity.class);
            startActivity(webIntent);

        } else if(view == dialCall){
            Intent callIntent = new Intent(mainActivity.this,activityCall.class);
            startActivity(callIntent);
        } else if(view == sendSms) {
            Intent smsIntent = new Intent(mainActivity.this,SmsActivity.class);
            startActivity(smsIntent);
        }
    }
}
