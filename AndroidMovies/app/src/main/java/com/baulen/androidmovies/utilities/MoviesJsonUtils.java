package com.baulen.androidmovies.utilities;

import android.content.Context;
import android.util.Log;

import com.baulen.androidmovies.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by macbookpro on 26/3/17.
 */

public class MoviesJsonUtils {
    private static final String TAG = MoviesJsonUtils.class.getSimpleName();

    public static ArrayList<Movie> getImagesFromJson(Context context, String jsonResponse)  throws JSONException {
        final String RESULTS = "results";
        if (jsonResponse != null) {
            Log.d(TAG, jsonResponse);
            ArrayList<Movie> movies = new ArrayList<Movie>();
            JSONObject moviesJson = new JSONObject(jsonResponse);
            if (moviesJson.has(RESULTS)){
                JSONArray moviesArrayJson = moviesJson.getJSONArray(RESULTS);
                for (int i = 0; i < moviesArrayJson.length(); i++) {
                    JSONObject movieJson =  moviesArrayJson.getJSONObject(i);
                    movies.add(new Movie(movieJson));
                }
            }


            return movies;
        } else {
            Log.d(TAG, "NUUULLLL STRING");
            ArrayList<Movie> movies = new ArrayList<Movie>();
            return movies;
        }
    }
}
