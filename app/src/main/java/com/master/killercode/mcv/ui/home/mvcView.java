package com.master.killercode.mcv.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.master.killercode.mcv.R;
import com.master.killercode.mcv.adapter.ListAdapter;
import com.master.killercode.mcv.base.BaseActivity;
import com.master.killercode.mcv.dialog.DialogNewMovie;
import com.master.killercode.mcv.project.ProjectActivity;
import com.master.killercode.mcv.util.MsgUtil;
import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class mvcView extends BaseActivity {

    /**
     * FindViews with ButterKnife
     */

    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @BindView(R.id.list_item)
    RecyclerView list;

    @BindView(R.id.textMsg)
    TextView textMsg;

    @BindView(R.id.btnAdd)
    FloatingActionButton btnAdd;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.flipper)
    ViewFlipper flipper;

    private ListAdapter adapter;
    private mvcController controller;

    /**
     * LifeCycle create
     */
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        controller = new mvcController(this);
        createToolbar(this, toolbar);

        initActions();
    }

    /**
     * init create view
     */
    private void initActions() {
        showLoad();
        showMsg(getString(R.string.msg_loading));

        //Create Recycler
        list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ListAdapter(new ListAdapter.OnAdapterClickListener() {
            @Override
            public void onDeleteClick(View view, BestMovieModel bestMovieModel) {
                showLoad();
                if (controller.deleteMovie(bestMovieModel.getId())) {
                    searchMovies();
                } else {
                    MsgUtil.msg(mvcView.this, getString(R.string.msg_error_delete));
                    hideLoad();
                }
            }

            @Override
            public void onEditClick(View view, BestMovieModel bestMovieModel) {
                new DialogNewMovie(mvcView.this, bestMovieModel, (id, title, desc, rating) -> {
                    showLoad();
                    if (controller.editMovie(id, title, desc, rating)) {
                        searchMovies();
                    } else {
                        MsgUtil.msg(mvcView.this, getString(R.string.msg_error_edit));
                        hideLoad();
                    }
                });
            }

            @Override
            public void onItemSelectedClick(View view, BestMovieModel bestMovieModel) {
                ProjectActivity.openDetails(mvcView.this, bestMovieModel);
            }
        });
        list.setAdapter(adapter);

        //Create Refresh
        refresh.setOnRefreshListener(() -> {
            showLoad();
            searchMovies();
        });
        searchMovies();

        //Btn Add
        btnAdd.setOnClickListener(view -> new DialogNewMovie(this, (title, desc, rating) -> {
            showLoad();
            if (controller.addMovie(title, desc, rating)) {
                searchMovies();
            } else {
                MsgUtil.msg(this, getString(R.string.msg_error_insert));
                hideLoad();
            }
        }));
    }

    /**
     * call list
     */
    private void searchMovies() {
        setDataInList(controller.getAllMovieList());
    }

    /**
     * verify and setup view
     *
     * @param list list with movies
     */
    private void setDataInList(ArrayList<BestMovieModel> list) {
        if (list.size() > 0) {
            adapter.addDataBase(list);
            showList();
        } else {
            clearLayout();
        }
        hideLoad();
    }

    /**
     * View config utils
     */

    private void showLoad() {
        if (refresh != null)
            refresh.setRefreshing(true);
    }

    private void hideLoad() {
        if (refresh != null)
            refresh.setRefreshing(false);
    }

    private void showMsg(String msg) {
        flipper.setDisplayedChild(2);
        textMsg.setText(msg);
        btnAdd.hide();
    }

    private void showList() {
        flipper.setDisplayedChild(1);
        btnAdd.hide();
    }

    private void clearLayout() {
        showMsg(getString(R.string.msg_database_empty));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuCreate:
                showLoad();
                setDataInList(controller.getFakeMovieList());
                break;
            case R.id.menuClean:
                showLoad();
                if (controller.clear()) {
                    clearLayout();
                    hideLoad();
                } else {
                    MsgUtil.msg(this, getString(R.string.msg_error_clean_database));
                }
                break;
            case R.id.resetApp:
                ProjectActivity.openSplash(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}