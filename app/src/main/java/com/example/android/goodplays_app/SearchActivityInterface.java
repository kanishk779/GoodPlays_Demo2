package com.example.android.goodplays_app;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

import java.util.ArrayList;

/**
 * Created by hp on 01-07-2018.
 */

public interface SearchActivityInterface {
    void returnList(ArrayList<Track> songs);
    void onError(String error);
    void setAdapter(String response);
}
