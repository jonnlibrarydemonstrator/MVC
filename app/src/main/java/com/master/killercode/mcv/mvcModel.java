package com.master.killercode.mcv;

import android.content.Context;

import com.quanticheart.lib.dao.DatabaseMovie;
import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

@SuppressWarnings("unused")
final class mvcModel {

    /**
     * class database for constructor
     */
    private final DatabaseMovie dbUtil;

    /**
     * constructor
     * @param context for access database class
     */
    mvcModel(Context context) {
        dbUtil = new DatabaseMovie(context);
    }

    /**
     * add new movie data
     * @param data model with data for insert
     */
    void addMovieInDB(BestMovieModel data) {
        dbUtil.addMovie(data);
    }

    /**
     * edit movie data
     * @param data model with data for edit
     */
    void editMovieInDB(BestMovieModel data) {
        dbUtil.editMovie(data);
    }

    /**
     * delete movie
     * @param idMovie for search in database
     * @return if success deleted
     */
    Boolean deleteMovieInDB(final String idMovie) {
        return dbUtil.deleteMovie(idMovie);
    }

    /**
     * get all movies list
     * @return list
     */
    ArrayList<BestMovieModel> loadAllMovies() {
        return dbUtil.getListMovies();
    }
}