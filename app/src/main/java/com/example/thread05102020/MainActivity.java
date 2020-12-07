package com.example.thread05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                showLog("A");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                showLog("B");
            }
        });

        threadA.start();
        threadB.start();
    }
    private void showLog(String name){
        for (int i = 0; i < 1000 ; i++) {
            Log.d("BBB", name + " : " + i);
        }
    }
}