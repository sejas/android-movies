package com.baulen.androidmovies;

/**
 * Created by macbookpro on 26/3/17.
 */

public class Movie {
    private String poster_url;
    private String title;
    private String release;
    private String backdrop;
    private String vote;
    private String synopsis;

    public Movie(String poster){
        poster_url = poster;
    }

    public String getPoster_url() {
        return poster_url;
    }
}
