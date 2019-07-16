package com.master.killercode.mcv.ui.splash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.master.killercode.mcv.R;
import com.master.killercode.mcv.project.ProjectActivity;

public class SplashActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ProjectActivity.openHome(SplashActivity.this);
                }
            }
        };
        timer.start();
    }
}