package com.baulen.androidmovies.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.baulen.androidmovies.ItemViewHolder;
import com.baulen.androidmovies.Movie;
import com.baulen.androidmovies.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by macbookpro on 26/3/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolderNew> {
    private Context mContext;
    private ArrayList<Movie> mMovies;
    public ImageAdapter() {
    }


    public ImageAdapter(Context context, ArrayList<Movie> movies) {
        this.mMovies = mMovies;
        this.mContext = context;
    }

    @Override
    public ItemViewHolderNew onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolderNew(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolderNew holder, int position) {
        //Set the right image
        Movie movie = mMovies.get(position);
        Picasso.with(mContext).load(movie.getPoster_url()).fit().into(holder.mImageView);    //.resize(220, 300)
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mMovies != null) {
            count = mMovies.size();
        }
        return count;
    }


    public void updateMovies(ArrayList<Movie> movies){
        mMovies = movies;
        notifyDataSetChanged();
    }


    public class ItemViewHolderNew extends RecyclerView.ViewHolder implements View.OnClickListener {
        private String TAG = "com.baulen.androidmovies.ItemViewHolderNew";
        public ImageView mImageView;

        public ItemViewHolderNew(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.iv_poster);
            //view.setOnClickListener(this);
        }

        /**
         * This gets called by the child views during a click.
         *
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            Log.v(TAG,"");
            //int adapterPosition = getAdapterPosition();
            //String weatherForDay = mWeatherData[adapterPosition];
            //mClickHandler.onClick(weatherForDay);
        }
    }



}