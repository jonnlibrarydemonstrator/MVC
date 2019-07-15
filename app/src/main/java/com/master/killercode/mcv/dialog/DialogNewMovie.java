package com.master.killercode.mcv.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.master.killercode.mcv.R;
import com.master.killercode.mcv.util.MsgUtil;

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
            String title = etTitle.getText().toString().trim();
            String desc = etDesc.getText().toString().trim();
            if (verifyString(activity, title, desc)) {
                callback.onClick(title, desc, ratingBar.getRating());
                dialog.dismiss();
            }
        });
    }

    /**
     * interface add action buttom
     */

    public interface OnAddClickListener {
        void onClick(String title, String desc, float rating);
    }

    private boolean verifyString(Activity activity, String title, String desc) {
        if (!title.isEmpty() && !desc.isEmpty()) {
            return true;
        } else {
            MsgUtil.msg(activity, "Preencha todos os campos");
            return false;
        }
    }
}
