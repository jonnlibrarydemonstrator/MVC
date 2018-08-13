package com.master.killercode.mcv.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.master.killercode.mcv.R;
import com.master.killercode.mcv.mvcView;

public class Splash extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, mvcView.class);
                    startActivity(intent);
                }
            }
        };

        timer.start();
    }
}
