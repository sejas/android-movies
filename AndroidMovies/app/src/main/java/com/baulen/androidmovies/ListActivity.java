package com.baulen.androidmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baulen.androidmovies.utilities.ImageAdapter;
import com.baulen.androidmovies.utilities.Themoviedb;

public class ListActivity extends AppCompatActivity implements ImageAdapter.ImageAdapterOnClickHandler {
    private Themoviedb mthemoviedb = new Themoviedb();
    private ProgressBar pb_loading;
    private RecyclerView recyclerview_movies;
    private ImageAdapter mImageAdapter;
    private Boolean toprated = false;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search){
            Context context = ListActivity.this;
            Toast.makeText(context, R.string.toastToggle, Toast.LENGTH_SHORT).show();
            this.toprated = ! this.toprated;
            if(this.toprated){
                mthemoviedb.getMoviesTopRated();
            }else{
                mthemoviedb.getMoviesLatest();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public static Context getContext(){
        return mContext;
    }

    private void loadMoviesrData() {
        mthemoviedb.getMoviesLatest();
    }

    @Override
    public void onClick(Movie movie) {
        Context context = this;
        Class destinationClass = DetailActivity.class;
        Intent intentToStartDetailActivity = new Intent(context, destinationClass);
        intentToStartDetailActivity.putExtra(DetailActivity.targetIntent, movie);
        startActivity(intentToStartDetailActivity);

    }
}