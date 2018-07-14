package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.goodplays_app.ModelClasses.Track1;

/**
 * Created by hp on 27-06-2018.
 */

public class SeeFavouriteSongActivity extends AppCompatActivity {
    TextView title,artist,genre,album,yearOfRelease,rating;
    Track1 track=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_song_saved);
        Intent i = getIntent();
        try{
            track = (Track1) i.getExtras().getSerializable("track");
        }
        catch(Exception e)
        {
            Toast.makeText(this,"IN SeeFavouriteSong" +e.toString(), Toast.LENGTH_SHORT).show();
        }
        initViews();
        setData();
    }

    private void setData() {
        title.setText(track.getTrackName());
        artist.setText(track.getArtistName());
        //genre.setText(track.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
        album.setText(track.getAlbumName());
        yearOfRelease.setText(track.getFirstReleaseDate());
        rating.setText("" + track.getStars());
    }

    private void initViews() {
        title = findViewById(R.id.songtitleSaved);
        artist = findViewById(R.id.songartistSaved);
        //genre = findViewById(R.id.genreSaved);
        album = findViewById(R.id.albumSaved);
        yearOfRelease = findViewById(R.id.year_of_releaseSaved);
        rating = findViewById(R.id.ratingSaved);
    }
}
