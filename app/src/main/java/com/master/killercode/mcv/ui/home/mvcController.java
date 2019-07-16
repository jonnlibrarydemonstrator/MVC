package com.master.killercode.mcv.ui.home;

import android.content.Context;
import android.util.Log;

import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

@SuppressWarnings("unused")
class mvcController {

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
    boolean addMovie(String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(title, description, rating);
        return model.addMovieInDB(data);
    }

    /**
     * edit movie in data base
     *
     * @param id          for edit in base
     * @param title       title
     * @param description little description
     * @param rating      rating movie
     */
    boolean editMovie(String id, String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(id, title, description, rating);
        return model.editMovieInDB(data);
    }

    /**
     * Clear database in app
     */
    Boolean clear() {
        return model.clearDatabase();
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
            Log.w("List Movies", list.toString());
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * get fake movies
     *
     * @return list fake movies
     */
    ArrayList<BestMovieModel> getFakeMovieList() {
        ArrayList<BestMovieModel> list = model.loadFakeMovies();
        if (list != null) {
            Log.w("List Movies", list.toString());
            return list;
        } else {
            return new ArrayList<>();
        }
    }

}
