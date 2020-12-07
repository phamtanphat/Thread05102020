package com.example.thread05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int a , b , c;
    MyFlag mMyFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = b = c = 0;
        mMyFlag = new MyFlag(0);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 0; i <= 10 ; ) {
                        if (mMyFlag.index == 0){
                            a = i;
                            Log.d("BBB","A : " + i);
                            i++;
                            mMyFlag.index = 1;
                            mMyFlag.notifyAll();
                        }else{
                            try {
                                mMyFlag.wait();
                            }catch (Exception e){

                            }
                        }

                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 0; i <= 10 ;) {
                        if (mMyFlag.index == 1){
                            b = i;
                            Log.d("BBB","B : " + i);
                            i++;
                            mMyFlag.index = 2;
                            mMyFlag.notifyAll();
                        }else{
                            try {
                                mMyFlag.wait();
                            }catch (Exception e){

                            }
                        }

                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 0; i <= 10 ; ) {
                        if (mMyFlag.index == 2){
                            c = a + b;
                            Log.d("BBB","C : " + c);
                            i++;
                            mMyFlag.index = 0;
                            mMyFlag.notifyAll();
                        }else{
                            try {
                                mMyFlag.wait();
                            }catch (Exception e){

                            }
                        }

                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}