package com.master.killercode.mcv.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

class DialogUtil {

    /**
     * for create/inflate view
     *
     * @param activity for inflate
     * @param layout   layout id
     * @return view
     */
    @SuppressWarnings("SameParameterValue")
    static View createView(Activity activity, int layout) {
        return LayoutInflater.from(activity).inflate(layout, null, false);
    }

    /**
     * create dialog
     *
     * @param activity        for create dialog
     * @param layoutForDialog view for insert dialog
     * @return dialog
     */
    static Dialog createDialog(Activity activity, View layoutForDialog) {
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(layoutForDialog);
        dialog.show();
        return dialog;
    }

}
