package com.baulen.androidmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by macbookpro on 3/4/17.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}