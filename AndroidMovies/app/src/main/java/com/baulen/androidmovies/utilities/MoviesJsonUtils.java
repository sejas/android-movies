package com.baulen.androidmovies.utilities;

import android.content.Context;
import android.util.Log;

import com.baulen.androidmovies.Movie;

import java.util.ArrayList;

/**
 * Created by macbookpro on 26/3/17.
 */

public class MoviesJsonUtils {
    private static final String TAG = MoviesJsonUtils.class.getSimpleName();
    public static ArrayList<Movie> getImagesFromJson(Context context, String jsonResponse) {
        if (jsonResponse != null) {
            Log.d(TAG, jsonResponse);
            ArrayList<Movie> movies = new ArrayList<Movie>();

            return movies;
        } else {
            Log.d(TAG, "NUUULLLL STRING");
            ArrayList<Movie> movies = new ArrayList<Movie>();
            movies.add(new Movie("http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));

            return movies;
        }
    }
}
