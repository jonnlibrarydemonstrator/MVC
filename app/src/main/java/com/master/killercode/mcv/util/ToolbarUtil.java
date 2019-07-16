package com.master.killercode.mcv.util;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.master.killercode.mcv.R;

@SuppressWarnings("unused")
public class ToolbarUtil {

    /**
     * create simple toolbar
     * @param activity call new toolbar
     * @param toolbar layout toolbar
     */
    public static void createBackToolbar(Activity activity, Toolbar toolbar) {
        AppCompatActivity a = (AppCompatActivity) activity;
        a.setSupportActionBar(toolbar);
        ActionBar bar = a.getSupportActionBar();
        assert bar != null;
        bar.setTitle(activity.getResources().getString(R.string.app_name));
//        bar.getThemedContext().setTheme(android.R.style.Theme_NoTitleBar);
    }

}
