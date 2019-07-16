package com.master.killercode.mcv.base;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.master.killercode.mcv.R;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * create simple toolbar
     *
     * @param activity call new toolbar
     * @param toolbar  layout toolbar
     */
    protected void createToolbar(Activity activity, Toolbar toolbar) {
        AppCompatActivity a = (AppCompatActivity) activity;
        a.setSupportActionBar(toolbar);
        ActionBar bar = a.getSupportActionBar();
        assert bar != null;
        bar.setTitle(activity.getResources().getString(R.string.app_name));
    }

    /**
     * create simple toolbar
     *
     * @param activity call new toolbar
     * @param toolbar  layout toolbar
     */
    protected void createBackToolbar(Activity activity, Toolbar toolbar, String title) {
        AppCompatActivity a = (AppCompatActivity) activity;
        a.setSupportActionBar(toolbar);
        ActionBar bar = a.getSupportActionBar();
        assert bar != null;
        bar.setTitle(title);
        bar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> activity.finish());
    }

}
