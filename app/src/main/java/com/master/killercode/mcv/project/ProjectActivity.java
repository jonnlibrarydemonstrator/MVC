package com.master.killercode.mcv.project;

import android.app.Activity;
import android.content.Intent;

import com.master.killercode.mcv.ui.details.DetailsActivity;
import com.master.killercode.mcv.ui.home.mvcView;
import com.master.killercode.mcv.ui.splash.SplashActivity;
import com.quanticheart.lib.dao.model.BestMovieModel;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ProjectActivity {

    /**
     * Open splash_activity activity
     *
     * @param activity for create intent and start activity
     */
    public static void openSplash(Activity activity) {
        Intent i = new Intent(activity, SplashActivity.class);
        activity.startActivity(i);
        activity.finish();
    }

    /**
     * Open splash_activity activity
     *
     * @param activity for create intent and start activity
     */
    public static void openHome(Activity activity) {
        Intent i = new Intent(activity, mvcView.class);
        activity.startActivity(i);
        activity.finish();
    }

    /**
     * Key for transfer data to Details Activity
     */
    public static final String KEY_PUTEXTRA_DETAILS_DATA = "key_putextra_details_data";

    /**
     * Open splash_activity activity
     *
     * @param activity for create intent and start activity
     */
    public static void openDetails(Activity activity, BestMovieModel data) {
        Intent i = new Intent(activity, DetailsActivity.class);
        i.putExtra(KEY_PUTEXTRA_DETAILS_DATA, data);
        activity.startActivity(i);
    }

}
