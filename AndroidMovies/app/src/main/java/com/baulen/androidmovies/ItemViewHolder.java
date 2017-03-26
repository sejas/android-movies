package com.baulen.androidmovies;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = ItemViewHolder.class.getSimpleName();
    public final ImageView mImageView;

    public ItemViewHolder(View view) {
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
