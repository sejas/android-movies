package com.baulen.androidmovies.utilities;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.baulen.androidmovies.Movie;
import com.baulen.androidmovies.utilities.MoviesJsonUtils;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by macbookpro on 25/3/17.
 */

public class Themoviedb {

    private ProgressBar mLoadingIndicator;
    private Context contextParent;
    private ImageAdapter mImageAdapter;

    public void setElements(ProgressBar loading, Context c, ImageAdapter mImageAdapter) {
        mLoadingIndicator = loading;
        contextParent = c;
        this.mImageAdapter = mImageAdapter;
    }

    public FetchThemoviedbTask themoviedbTask =  new FetchThemoviedbTask();

    public class FetchThemoviedbTask extends AsyncTask<String, Void, ArrayList<Movie>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Movie> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }
            String toprated = params[0];
            URL moviesURL = NetworkUtils.buildUrlPopular();
            if ("toprated".equals(toprated)){
                moviesURL = NetworkUtils.buildUrlTopRated();
            }
            try {
                String jsonResponse = NetworkUtils
                        .getResponseFromHttpUrl(moviesURL);

                ArrayList<Movie> simpleJsonMoviesData = MoviesJsonUtils
                        .getImagesFromJson(contextParent, jsonResponse);

                return simpleJsonMoviesData;

            } catch (Exception e) {

                e.printStackTrace();
                // TODO: REMOVE THIS LINE
                //return  MoviesJsonUtils.getImagesFromJson(contextParent, ""); //DEBUG
                return null;

                //return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (movies != null) {
                mImageAdapter.updateMovies(movies);
            } else {
                //showErrorMessage();
            }
        }
    }
}
