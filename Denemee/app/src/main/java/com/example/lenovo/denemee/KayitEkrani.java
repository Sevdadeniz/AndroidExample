package com.example.lenovo.denemee;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class KayitEkrani extends AppCompatActivity {

    private TextInputLayout tilad,tilmail,tilkullaniciadi,tilsifre,tilsifretekrar;
    private TextInputEditText adsoyad,mail,kullaniciadi,sifre,sifretekrar;
    private RequestQueue requestQueue;
    private static final String url_kayit = "http://10.0.2.2/kişiler2/register.php";  //php dosyasının linki



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);

        adsoyad =findViewById(R.id.kaydolAdSoyad);
        mail =findViewById(R.id.kaydolEposta);
        kullaniciadi =findViewById(R.id.kaydolKadi);
        sifre =findViewById(R.id.kaydolSifre);


        requestQueue = Volley.newRequestQueue(getApplicationContext());


        findViewById(R.id.zatenbirhesabimvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KayitEkrani.this,GirisEkrani.class));

            }
        });
        findViewById(R.id.kaydolbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean durumadsoyad  = TextUtils.isEmpty(adsoyad.getText());
                boolean durumeposta  = TextUtils.isEmpty(mail.getText());
                boolean durumsifre  = TextUtils.isEmpty(sifre.getText());
                boolean durumkullaniciadi  = TextUtils.isEmpty(kullaniciadi.getText());

                if(durumadsoyad || durumsifre || durumkullaniciadi  || !mail.getText().toString().contains("@")){
                    if(durumadsoyad || durumsifre || durumkullaniciadi || durumeposta){
                        AlertDialog.Builder builder = new AlertDialog.Builder(KayitEkrani.this);
                        builder.setTitle("Uyarı");
                        builder.setMessage("Boş alanı doldurunuz!!!");
                        builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }
                    if(durumeposta){
                        AlertDialog.Builder builder = new AlertDialog.Builder(KayitEkrani.this);
                        builder.setTitle("Uyarı");
                        builder.setMessage("Boş alanı doldurunuz!!!");
                        builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }
                    else if(!mail.getText().toString().contains("@")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(KayitEkrani.this);
                        builder.setTitle("Uyarı");
                        builder.setMessage("Lütfen geçerli bir mail adresi giriniz!!!");
                        builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }
                }
                else{
                    //kayıt istegi gönderilecek
                    istekgonder();
                }

            }
        });



    }

    private void istekgonder() {
        StringRequest request = new StringRequest(Request.Method.POST, url_kayit, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Json verisi",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> degerler= new HashMap<>();
                degerler.put("kullaniciadi",kullaniciadi.getText().toString());
                degerler.put("sifre",sifre.getText().toString());
                degerler.put("adsoyad",adsoyad.getText().toString());
                degerler.put("mail",mail.getText().toString());
                return degerler;
            }
        };

        requestQueue.add(request);
    }

}
