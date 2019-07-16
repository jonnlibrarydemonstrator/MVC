package com.master.killercode.mcv.ui.home;

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
     *
     * @param context for access database class
     */
    mvcModel(Context context) {
        dbUtil = new DatabaseMovie(context, true);
    }

    /**
     * add new movie data
     *
     * @param data model with data for insert
     */
    boolean addMovieInDB(BestMovieModel data) {
        return dbUtil.addMovie(data);
    }

    /**
     * edit movie data
     *
     * @param data model with data for edit
     */
    boolean editMovieInDB(BestMovieModel data) {
        return dbUtil.editMovie(data);
    }

    /**
     * delete movie
     *
     * @param idMovie for search in database
     * @return if success deleted
     */
    boolean deleteMovieInDB(final String idMovie) {
        return dbUtil.deleteMovie(idMovie);
    }

    /**
     * get all movies list
     *
     * @return list
     */
    ArrayList<BestMovieModel> loadAllMovies() {
        return dbUtil.getListMovies();
    }

    /**
     * get fake movie list
     *
     * @return fake list
     */
    ArrayList<BestMovieModel> loadFakeMovies() {
        ArrayList<BestMovieModel> list = dbUtil.createInitList(DatabaseMovie.LONG_LIST);

        for (int i = 0; i < list.size(); i++) {
            dbUtil.addMovie(list.get(i));
        }

        return dbUtil.getListMovies();
    }

    /**
     * clean database
     *
     * @return if success deleted
     */
    Boolean clearDatabase() {
        return dbUtil.cleanTable();
    }

}