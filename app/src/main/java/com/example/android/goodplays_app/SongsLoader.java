package com.example.android.goodplays_app;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 12-07-2018.
 */

public class SongsLoader extends AsyncTaskLoader<ArrayList<Track>> {
    private ArrayList<Track> songs;
    private String mUrl;
    public SongsLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }
    @Override
    public ArrayList<Track> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        songs = QueryUtils.fetchNewsData(mUrl);
        return songs;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
