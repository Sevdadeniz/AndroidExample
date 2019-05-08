package com.example.lenovo.dortislem.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.dortislem.R;

import java.util.Random;

public class ToplamaFragment extends Fragment {
    public ToplamaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_toplama, container, false);
        final TextView t1 =view.findViewById(R.id.top1);
        t1.setText(String.valueOf(giveFirstNumber()));
        setupUI(view);
        final TextView t2 =view.findViewById(R.id.top2);
        t2.setText(String.valueOf(giveSecondNumber()));

        final TextView tS =view.findViewById(R.id.dogrutoplam);

        final EditText sonuccevabi =view.findViewById(R.id.sonuctoplam);
        Button button2 = view.findViewById(R.id.toplamsonucu);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cevap(sonuccevabi.getText().toString(),String.valueOf(sonuc(t1.getText().toString(),t2.getText().toString())))){
                    sonuccevabi.setText("");
                    tS.setText("Doğru Cevap");

                    //sonuccevabi.setText(String.valueOf(sonuc(t1.getText().toString(),t2.getText().toString())));
                }
                else {
                    sonuccevabi.setText("");
                    tS.setText("Yanlış Cevap"+"\nDoğru Cevap: "+String.valueOf(sonuc(t1.getText().toString(),t2.getText().toString())));
                }

            }
        });

        Button button = view.findViewById(R.id.buttonYenile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(String.valueOf(giveFirstNumber()));
                t2.setText(String.valueOf(giveSecondNumber()));
            }
        });
        return view;



    }

    private int giveFirstNumber(){
        return  new Random().nextInt(10)+1;
    }

    private int giveSecondNumber(){
        return  new Random().nextInt(5)+1;
    }

    private int  sonuc(String text1,String text2){
        int tv1 = Integer.parseInt(text1);
        int tv2 = Integer.parseInt(text2);
        return tv1+tv2;
    }
    private boolean cevap(String snc,String fonk){
        if(snc.equals(fonk)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(getActivity());
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
