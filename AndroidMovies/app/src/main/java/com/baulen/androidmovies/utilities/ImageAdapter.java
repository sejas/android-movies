package com.baulen.androidmovies.utilities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.baulen.androidmovies.R;
import com.squareup.picasso.Picasso;

/**
 * Created by macbookpro on 26/3/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mThumbUrls;
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbUrls.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbUrls[position]);
        Picasso.with(context).load(mThumbUrls[position]).into(imageView);
        return imageView;
    }

    public  void setImages(String[] thumbUrls){
        mThumbUrls = thumbUrls;
    }



}