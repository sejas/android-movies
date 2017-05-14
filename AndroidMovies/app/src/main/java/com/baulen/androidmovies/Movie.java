package com.baulen.androidmovies;

import java.io.Serializable;

/**
 * Created by macbookpro on 26/3/17.
 */

public class Movie implements Serializable{
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
