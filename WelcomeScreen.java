package com.alacriti.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_splash);

        Thread timeraThread = new Thread(){

            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent mainIntent = new Intent(WelcomeScreen.this, MainActivity.class);
                    startActivity(mainIntent);
                }
            }
        };

        timeraThread.start();
    }

    protected void onPause(){

        super.onPause();
        finish();
    }
}

