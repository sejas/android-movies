/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baulen.androidmovies.utilities;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.baulen.androidmovies.ListActivity;
import com.baulen.androidmovies.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the https://www.themoviedb.org API.
 */
public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String URL_POPULAR = BASE_URL+"movie/popular";
    private static final String URL_TOPRATED= BASE_URL+"movie/top_rated";
    private static final HashMap<String, String> queryParams = createQueryParams();
    private static HashMap<String, String> createQueryParams()
    {
        HashMap<String,String> queryParams = new HashMap<String,String>();
        queryParams.put("api_key", ListActivity.getContext().getString(R.string.apikey));
        queryParams.put("language", "en-US");
        queryParams.put("page", "1");
        return queryParams;
    }

    /**
     * Builds the URL used to talk to the weather server using a location. This location is based
     * on the query capabilities of the weather provider that we are using.
     *
     * @param urlString The location that will be queried for.
     * @return The URL to use to query the weather server.
     */
    public static URL buildUrlGeneric(String urlString) {
        Log.d("----->>>>> NetworkUtils", "buildUrlGeneric");
        Uri.Builder partialBuiltUri = Uri.parse(urlString).buildUpon();
        Log.d("----->>>>> NetworkUtils", "buildUrlGeneric2");
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            partialBuiltUri .appendQueryParameter(entry.getKey(), entry.getValue());
        }
        Uri builtUri = partialBuiltUri .build();

        Log.d("----->>>>> NetworkUtils", builtUri.toString());

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.d("----->>>>> NetworkUtils", "ERROR TRY buildUrlGeneric");
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    public static URL buildUrlPopular() {
        Log.d("----->>>>> NetworkUtils", "buildUrlPopular");
     return buildUrlGeneric(URL_POPULAR);
    }
    public static URL buildUrlTopRated() {
        Log.d("----->>>>> NetworkUtils", "buildUrlTopRated");
        return buildUrlGeneric(URL_TOPRATED);
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (Exception e){
            Log.d("ERROR FETCHING URL",url.toString());
            e.printStackTrace();
            return null;
        }finally {
            urlConnection.disconnect();
        }
    }
}