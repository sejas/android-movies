package com.baulen.androidmovies;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by macbookpro on 26/3/17.
 */

public class Movie implements Serializable{
    private String poster_url;
    private String title;
    private String release;
    private String vote;
    private String synopsis;

    //JSON keys for mapping Movie Object
    final String POSTER= "poster_path";
    final String TITLE= "title";
    final String RELEASE= "release_date";
    final String VOTE= "vote_average";
    final String SYNOPSIS= "overview";
    //Constant for image width
    final String WIDTH = "320";


    public Movie(JSONObject movieJson) throws JSONException {
        poster_url = "http://image.tmdb.org/t/p/w"+this.WIDTH+"/"+movieJson.getString(POSTER);
        title = movieJson.getString(TITLE);
        release = movieJson.getString(RELEASE);
        vote = movieJson.getString(VOTE);
        synopsis = movieJson.getString(SYNOPSIS);
    }

    //Getters
    public String getPoster_url() {
        return poster_url;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease() {
        return release;
    }

    public String getVote() {
        return vote;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
