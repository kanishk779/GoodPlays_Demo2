package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

/**
 * Created by hp on 27-06-2018.
 */

public class SeeSongDetailsActivity extends AppCompatActivity {
    Track song;
    TextView title,artist,genre,album,yearOfRelease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_songs);
        Intent i = getIntent();
        song = (Track)i.getExtras().getSerializable("track");
        initViews();
        setData();
    }

    private void setData() {
        title.setText(song.getTrackName());              //MODIFY THIS WHEN WE WILL GET THE POSTER
        artist.setText(song.getArtistName());
        genre.setText(song.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
        album.setText(song.getAlbumName());
        yearOfRelease.setText(song.getFirstReleaseDate());
    }

    private void initViews() {
        title = findViewById(R.id.songtitle);
        artist = findViewById(R.id.songartist);
        genre = findViewById(R.id.genre);
        album = findViewById(R.id.album);
        yearOfRelease = findViewById(R.id.releasedetails);
    }
}
