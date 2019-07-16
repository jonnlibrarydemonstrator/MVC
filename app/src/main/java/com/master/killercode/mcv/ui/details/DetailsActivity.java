package com.master.killercode.mcv.ui.details;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.master.killercode.mcv.R;
import com.master.killercode.mcv.base.BaseActivity;
import com.master.killercode.mcv.project.ProjectActivity;
import com.master.killercode.mcv.util.MsgUtil;
import com.quanticheart.lib.dao.model.BestMovieModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.detailsTitle)
    TextView title;

    @BindView(R.id.detailsDesc)
    TextView desc;

    @BindView(R.id.detailsRating)
    RatingBar ratingBar;

    @BindView(R.id.toolbarDetails)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        ButterKnife.bind(this);

        BestMovieModel extra = (BestMovieModel) getIntent().getSerializableExtra(ProjectActivity.KEY_PUTEXTRA_DETAILS_DATA);
        if (extra != null) {
            createBackToolbar(this, toolbar, extra.getTitleMovie());
            title.setText(extra.getTitleMovie());
            desc.setText(extra.getLitleDescMovie());
            ratingBar.setRating(extra.getRattingMovie());
        }else{
            MsgUtil.msg(this, getString(R.string.msg_error_get_data));
            finish();
        }
    }
}
