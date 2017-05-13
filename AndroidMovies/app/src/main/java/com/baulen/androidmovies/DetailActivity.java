package com.baulen.androidmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by macbookpro on 3/4/17.
 */

public class DetailActivity extends AppCompatActivity {
    public ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView =  (ImageView) findViewById(R.id.iv_poster);


    }
}