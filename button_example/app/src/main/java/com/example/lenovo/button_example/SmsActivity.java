package com.example.lenovo.button_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    private EditText edtNumber;
    private EditText edtMessage;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtMessage =findViewById(R.id.editTextMessage);
        edtNumber = findViewById(R.id.editTextNumber);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = edtNumber.getText().toString();
                    Log.d("NUMBER",number);   String message = edtMessage.getText().toString();
                    Log.d("MESAJ",message);

                    Uri uri = Uri.parse("smsto:"+number);
                    Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                    intent.putExtra("sms_body",message);
                    startActivity(intent);




            }
        });


    }
}
