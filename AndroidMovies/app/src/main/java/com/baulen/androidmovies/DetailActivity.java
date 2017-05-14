package com.baulen.androidmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by macbookpro on 3/4/17.
 */

public class DetailActivity extends AppCompatActivity {
    public static String targetIntent = "movie";
    public ImageView mImageView;
    private Movie movie = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView =  (ImageView) findViewById(R.id.iv_poster);

        extractExtras();
    }

    private void extractExtras() {
        this.movie = (Movie) getIntent().getExtras().getSerializable(DetailActivity.targetIntent);
        if (movie != null) {
            Picasso.with(this).load(movie.getPoster_url()).into(this.mImageView);
        }
    }
}