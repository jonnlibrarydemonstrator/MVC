package com.master.killercode.mcv.util;

import android.app.Activity;
import android.widget.Toast;

public class MsgUtil {

    public static void msg(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

}
