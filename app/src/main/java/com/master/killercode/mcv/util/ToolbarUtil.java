package com.master.killercode.mcv.util;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.master.killercode.mcv.R;

@SuppressWarnings("unused")
public class ToolbarUtil {

    public static void createBackToolbar(Activity activity, Toolbar toolbar) {
        AppCompatActivity a = (AppCompatActivity) activity;
        a.setSupportActionBar(toolbar);
        ActionBar bar = a.getSupportActionBar();
        assert bar != null;
        bar.setTitle(activity.getResources().getString(R.string.app_name));
        bar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(activity.getResources().getDrawable(R.drawable.ic_arrow_back, null));
        toolbar.setNavigationOnClickListener(view -> activity.onBackPressed());
    }

}
