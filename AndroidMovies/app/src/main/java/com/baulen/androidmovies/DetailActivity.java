package com.baulen.androidmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by macbookpro on 3/4/17.
 */

public class DetailActivity extends AppCompatActivity {
    public static String targetIntent = "movie";
    public ImageView mImageView;
    public TextView mTitlte;
    public TextView mRelease;
    public TextView mVote;
    public TextView mSynopsis;

    private Movie movie = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView =  (ImageView) findViewById(R.id.iv_poster);

        mTitlte =  (TextView) findViewById(R.id.detail_title);
        mRelease =  (TextView) findViewById(R.id.detail_release);
        mVote =  (TextView) findViewById(R.id.detail_vote);
        mSynopsis =  (TextView) findViewById(R.id.detail_synopsis);


        extractExtras();
    }

    private void extractExtras() {
        this.movie = (Movie) getIntent().getExtras().getSerializable(DetailActivity.targetIntent);
        if (movie != null) {
            Picasso.with(this).load(movie.getPoster_url()).into(this.mImageView);
            mTitlte.setText(movie.getTitle());
            mRelease.setText(movie.getRelease());
            mVote.setText(movie.getVote());
            mSynopsis.setText(movie.getSynopsis());
        }
    }
}