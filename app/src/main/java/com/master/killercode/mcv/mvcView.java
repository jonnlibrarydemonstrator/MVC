package com.master.killercode.mcv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.master.killercode.mcv.adapter.ListAdapter;
import com.master.killercode.mcv.dialog.DialogNewMovie;
import com.master.killercode.mcv.util.MsgUtil;
import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class mvcView extends AppCompatActivity {

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

    private ListAdapter adapter;
    private mvcController controller;

    /**
     * LifeCicle create
     */
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        ButterKnife.bind(this);

        controller = new mvcController(this);
        initActions();
    }

    /**
     * init create view
     */
    private void initActions() {
        showLoad();
        showMsg("Carregando...");

        //Create Recycler
        list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ListAdapter();
        list.setAdapter(adapter);

        //Create Refresh
        refresh.setOnRefreshListener(() -> {
            showLoad();
            searchMovies();
        });
        searchMovies();

        //Btn Add
        btnAdd.setOnClickListener(view -> new DialogNewMovie(this, (String title, String desc, float rating) -> {

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
            adapter.setDeleteOnClickListener((view, bestMovieModel) -> {
                showLoad();
                if (controller.deleteMovie(bestMovieModel.getId())) {
                    searchMovies();
                } else {
                    MsgUtil.msg(this, "Erro ao deletar");
                    hideLoad();
                }
            });
            adapter.setEditOnClickListener((view, bestMovieModel) -> {

            });
            showList();
        } else {
            showMsg("Nada Adicionado");
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

    private void showList() {
        if (list != null)
            list.setVisibility(View.VISIBLE);

        if (textMsg != null)
            textMsg.setVisibility(View.GONE);
    }

    private void showMsg(String msg) {
        if (textMsg != null) {
            textMsg.setText(msg);
            textMsg.setVisibility(View.VISIBLE);
        }

        if (list != null)
            list.setVisibility(View.GONE);
    }

}