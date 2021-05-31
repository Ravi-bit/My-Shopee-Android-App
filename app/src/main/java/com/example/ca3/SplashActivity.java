package com.example.ca3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Handler h;
    Runnable r;
    Long delayTime;
    Long t=8000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        h= new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
                String lstr = mPrefs.getString("LoggedIn", "");
                if(lstr.equals("true")){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else {
                    Intent i = new Intent(SplashActivity.this, Login.class);
                    startActivity(i);
                    finish();
                }

            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        h.postDelayed(r, t);
        t=System.currentTimeMillis();

    }

    @Override
    protected void onStop() {
        super.onStop();
        h.removeCallbacks(r);
    }


}

