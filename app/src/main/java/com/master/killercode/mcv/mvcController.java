package com.master.killercode.mcv;

import android.content.Context;

import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class mvcController {

    /**
     * Var model for create in constructor
     */
    private final mvcModel model;

    /**
     * Constructor
     *
     * @param context for create model
     */
    mvcController(Context context) {
        model = new mvcModel(context);
    }

    /**
     * Add new movie in data base
     *
     * @param title       title
     * @param description little description
     * @param rating      rating movie
     */
    public void addMovie(String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(title, description, rating);
        model.addMovieInDB(data);
    }

    /**
     * edit movie in data base
     *
     * @param id          for edit in base
     * @param title       title
     * @param description little description
     * @param rating      rating movie
     */
    public void editMovie(String id, String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(title, description, rating);
        model.editMovieInDB(data);
    }

    /**
     * delete movie in data base
     *
     * @param id for delete in base
     * @return if success delete
     */
    Boolean deleteMovie(final String id) {
        return model.deleteMovieInDB(id);
    }

    /**
     * get all list movies in database
     *
     * @return list all movies
     */
    ArrayList<BestMovieModel> getAllMovieList() {
        ArrayList<BestMovieModel> list = model.loadAllMovies();
        if (list != null) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }
}
