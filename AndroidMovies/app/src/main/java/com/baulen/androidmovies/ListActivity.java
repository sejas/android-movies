package com.baulen.androidmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.baulen.androidmovies.utilities.ImageAdapter;
import com.baulen.androidmovies.utilities.Themoviedb;

public class ListActivity extends AppCompatActivity implements ImageAdapter.ImageAdapterOnClickHandler {
    private Themoviedb mthemoviedb = new Themoviedb();
    private ProgressBar pb_loading;
    private RecyclerView recyclerview_movies;
    private ImageAdapter mImageAdapter;

    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mContext = this;

        recyclerview_movies = (RecyclerView) findViewById(R.id.recyclerview_movies);

        //I tried to remove the space between columns
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerview_movies.setLayoutManager(layoutManager);

        mImageAdapter = new ImageAdapter (mContext,null, this);
        recyclerview_movies.setAdapter(mImageAdapter );


        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
        mthemoviedb.setElements(pb_loading,ListActivity.this,mImageAdapter);

        loadMoviesrData();
    }


    public static Context getContext(){
        return mContext;
    }

    private void loadMoviesrData() {
        mthemoviedb.themoviedbTask.execute("something");
    }

    @Override
    public void onClick(Movie movie) {
        Context context = this;
        Class destinationClass = DetailActivity.class;
        Intent intentToStartDetailActivity = new Intent(context, destinationClass);
        startActivity(intentToStartDetailActivity);
    }
}