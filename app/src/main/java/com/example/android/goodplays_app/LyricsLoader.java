package com.example.android.goodplays_app;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.android.goodplays_app.ModelClasses.LyricsModelClasses.Lyrics;

/**
 * Created by hp on 13-07-2018.
 */

public class LyricsLoader extends AsyncTaskLoader<Lyrics> {
    Lyrics lyrics;
    String mUrl;
    public LyricsLoader(Context context,String Url)
    {
        super(context);
        mUrl = Url;
    }

    @Override
    public Lyrics loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        lyrics = QueryUtilsLyrics.fetchLyrics(mUrl);
        return lyrics;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
