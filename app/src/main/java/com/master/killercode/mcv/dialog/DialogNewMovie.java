package com.master.killercode.mcv.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.master.killercode.mcv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogNewMovie {

    @BindView(R.id.editTitle)
    EditText etTitle;

    @BindView(R.id.editDesc)
    EditText etDesc;

    @BindView(R.id.rating)
    RatingBar ratingBar;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    public DialogNewMovie(Activity activity, OnAddClickListener callback) {

        View v = DialogUtil.createView(activity, R.layout.dialog);
        Dialog dialog = DialogUtil.createDialog(activity, v);
        ButterKnife.bind(this, v);

        btnAdd.setOnClickListener(view -> {
            callback.onClick();
            dialog.dismiss();
        });

    }

    /**
     * interface add action buttom
     */

    public interface OnAddClickListener {
        void onClick();
    }
}
