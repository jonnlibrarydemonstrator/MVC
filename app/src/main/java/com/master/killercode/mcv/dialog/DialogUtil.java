package com.master.killercode.mcv.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

public class DialogUtil {

    public static View createView(Activity activity, int layout) {
        return LayoutInflater.from(activity).inflate(layout, null, false);
    }

    public static Dialog createDialog(Activity activity, View layoutForDialog) {
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(layoutForDialog);
        dialog.show();
        return dialog;
    }

}
