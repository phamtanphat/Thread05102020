package com.example.thread05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int a , b , c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = b = c = 0;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    a = i;
                    Log.d("BBB","A : " + i);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    b = i;
                    Log.d("BBB","B : " + i);
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    c = a + b;
                    Log.d("BBB","C : " + c);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}