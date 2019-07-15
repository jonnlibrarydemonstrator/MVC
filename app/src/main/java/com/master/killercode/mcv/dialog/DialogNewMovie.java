package com.master.killercode.mcv.dialog;

import android.app.Activity;
import android.app.Dialog;

import com.master.killercode.mcv.R;

public class DialogNewMovie {

    public DialogNewMovie(Activity activity, OnAddClickListener callback) {

        Dialog dialog = DialogUtil.createDialog(activity, DialogUtil.createView(activity, R.layout.dialog));

    }

    /**
     * interface add action buttom
     */

    interface OnAddClickListener {
        void onClick();
    }
}
