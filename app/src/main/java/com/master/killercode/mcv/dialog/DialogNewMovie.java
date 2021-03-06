package com.master.killercode.mcv.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.master.killercode.mcv.R;
import com.master.killercode.mcv.util.MsgUtil;
import com.quanticheart.lib.dao.model.BestMovieModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogNewMovie {

    /**
     * Butterknife BindView
     */
    @BindView(R.id.editTitle)
    EditText etTitle;

    @BindView(R.id.editDesc)
    EditText etDesc;

    @BindView(R.id.rating)
    RatingBar ratingBar;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    /**
     * Dialog constructor
     *
     * @param activity for create dialog and inflate view
     * @param callback for result in dialog
     */
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
     * Dialog constructor
     *
     * @param activity for create dialog and inflate view
     * @param callback for result in dialog
     */
    @SuppressLint("SetTextI18n")
    public DialogNewMovie(Activity activity, BestMovieModel model, OnEditClickListener callback) {

        View v = DialogUtil.createView(activity, R.layout.dialog);
        Dialog dialog = DialogUtil.createDialog(activity, v);
        ButterKnife.bind(this, v);

        etTitle.setText(model.getTitleMovie());
        etDesc.setText(model.getLitleDescMovie());
        ratingBar.setRating(model.getRattingMovie());

        btnAdd.setText(
                String.format(
                activity.getResources().getString(R.string.label_edit),
                model.getTitleMovie()
                )
        );
        btnAdd.setOnClickListener(view -> {
            String title = etTitle.getText().toString().trim();
            String desc = etDesc.getText().toString().trim();
            if (verifyString(activity, title, desc)) {
                callback.onClick(model.getId(), title, desc, ratingBar.getRating());
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

    public interface OnEditClickListener {
        void onClick(String id, String title, String desc, float rating);
    }

    /**
     * for verify string
     *
     * @param activity for show msg
     * @param title    string for verify
     * @param desc     string for verify
     * @return is text not empty
     */
    private boolean verifyString(Activity activity, String title, String desc) {
        if (!title.isEmpty() && !desc.isEmpty()) {
            return true;
        } else {
            MsgUtil.msg(activity, activity.getString(R.string.msg_field_empty));
            return false;
        }
    }
}
