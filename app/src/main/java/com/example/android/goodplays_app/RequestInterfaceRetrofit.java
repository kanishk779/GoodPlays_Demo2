package com.example.android.goodplays_app;

import android.content.Intent;

import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.ArtistDetail;
import com.example.android.goodplays_app.ModelClasses.LyricsModelClasses.SongLyrics;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.SongDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp on 26-06-2018.
 */

public interface RequestInterfaceRetrofit {
    @GET("chart.tracks.get")
    Call<SongDetail> getSongJSON(
            @Query("page") Integer page,
            @Query("page_size") Integer page_size,
            @Query("country") String country,
            @Query("f_has_lyrics") Integer trueOrFalse,
            @Query("apikey") String key
            );

    @GET("chart.artists.get")
    Call<ArtistDetail> getArtistJSON(
            @Query("page") Integer page,
            @Query("page_size") Integer page_size,
            @Query("country") String country,
            @Query("apikey") String key
    );
    @GET("track.lyrics.get")
    Call<SongLyrics> getLyricsJSON(
            @Query("track_id") long track_id,
            @Query("apikey") String key
    );
}
