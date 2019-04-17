package com.example.lenovo.button_example;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class VoiceActivity extends AppCompatActivity {

    Button btnKaydet;
    Button btnDur;
    Button btnCal;

    private MediaRecorder recorder;
    private MediaPlayer player;

    private final String filepath = Environment.getExternalStorageDirectory().getPath()+ "/gizlises.3gp";

    public static final int REQUEST_AUDIO_PERMISSION_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        btnCal = findViewById(R.id.buttonCal);
        btnKaydet = findViewById(R.id.buttonKaydet);
        btnDur = findViewById(R.id.buttonDur);


            btnKaydet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(checkPermissions()) {
                        startRecord();
                    }else {
                        requestPermissions();
                        startRecord();
                    }
                    }
                    }
            );
            btnDur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopRecord();
                }
            });

            btnCal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPlay();
                }
            });


    }
    public void startRecord(){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(filepath);

        try{
            recorder.prepare();
            recorder.start();
            Toast.makeText(getApplicationContext(),"Şu an kayıt başladı.",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void stopRecord(){
        if (recorder != null){
            Toast.makeText(getApplicationContext(), "Kayıt Durdu", Toast.LENGTH_SHORT).show();
            recorder.stop();
            recorder.reset();
            recorder.release();
            recorder = null;
        }
    }
    public void startPlay(){
        player = new MediaPlayer();
        player.setVolume(1.0f, 1.0f);
        try {
            player.setDataSource(filepath);
            player.prepare();
            player.start();
            Toast.makeText(getApplicationContext(),"Kayıt Çalıyor",Toast.LENGTH_LONG).show();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer arg0) {
                    player.stop();
                    player.release();
                    player = null;
                }
            });
        } catch (Exception e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_AUDIO_PERMISSION_CODE :
                if(grantResults.length > 0){
                    boolean permitRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permitStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(permitRecord && permitStore){
                        Toast.makeText(getApplicationContext(), "İzinler mevcut", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "İzinler mevcut değil", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }
    public boolean checkPermissions(){
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),RECORD_AUDIO);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermissions(){
        ActivityCompat.requestPermissions(VoiceActivity.this,new String[] { RECORD_AUDIO,WRITE_EXTERNAL_STORAGE},REQUEST_AUDIO_PERMISSION_CODE);
    }


}
