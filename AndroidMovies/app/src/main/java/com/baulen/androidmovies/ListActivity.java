package com.baulen.androidmovies;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baulen.androidmovies.utilities.ImageAdapter;
import com.baulen.androidmovies.utilities.Themoviedb;

import static android.R.attr.id;

public class ListActivity extends AppCompatActivity {
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

        GridLayoutManager layoutManager
                = new GridLayoutManager(this, 2);
        recyclerview_movies.setLayoutManager(layoutManager);
        mImageAdapter = new ImageAdapter ();
        recyclerview_movies.setAdapter(mImageAdapter );


        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
        mthemoviedb.setElements(pb_loading,ListActivity.this,mImageAdapter);

        loadMoviesrData();
    }


    public static Context getContext(){
        return mContext;
    }

    private void loadMoviesrData() {
        //new Themoviedb.FetchThemoviedbTask.execute("something");
        mthemoviedb.themoviedbTask.execute("something");
    }
}
