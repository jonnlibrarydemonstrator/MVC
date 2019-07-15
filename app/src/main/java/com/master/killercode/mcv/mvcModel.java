package com.master.killercode.mcv;

import android.content.Context;

import com.quanticheart.lib.dao.DatabaseMovie;
import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

@SuppressWarnings("unused")
final class mvcModel {

    private final DatabaseMovie dbUtil;

    mvcModel(Context context) {
        dbUtil = new DatabaseMovie(context);
    }

    void addMovieInDB(BestMovieModel data) {
        dbUtil.addMovie(data);
    }

    void editMovieInDB(BestMovieModel data) {
        dbUtil.editMovie(data);
    }

    Boolean deleteMovieInDB(final String idMovie) {
        return dbUtil.deleteMovie(idMovie);
    }

    ArrayList<BestMovieModel> loadAllMovies() {
        return dbUtil.getListMovies();
    }
}