package com.master.killercode.mcv;

import android.content.Context;

import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class mvcController {
    private final mvcModel model;

    mvcController(Context context) {
        model = new mvcModel(context);
    }

    public void addMovie(String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(title, description, rating);
        model.addMovieInDB(data);
    }

    public void editMovie(String id, String title, String description, Float rating) {
        BestMovieModel data = new BestMovieModel(title, description, rating);
        model.editMovieInDB(data);
    }

    Boolean deleteMovie(final String id) {
        return model.deleteMovieInDB(id);
    }

    ArrayList<BestMovieModel> getAllMovieList() {
        ArrayList<BestMovieModel> list = model.loadAllMovies();
        if (list != null) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }
}
