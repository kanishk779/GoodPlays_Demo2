package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.goodplays_app.DataBases.FavouriteSongs;
import com.example.android.goodplays_app.Fragments.SongFragment;
import com.example.android.goodplays_app.ModelClasses.Track1;

/**
 * Created by hp on 27-06-2018.
 */

public class SetFavouriteSongActivity extends AppCompatActivity {
    FavouriteSongs db;
    Button save;
    RatingBar rating;
    TextView SongTitle,SongArtist,Genre,Album,YearOfRelease;
    float stars;
    String songTitle,songArtist,genre,album,yearOfRelease;
    Track1 track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_song);
        initViews();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stars = rating.getRating();
                songArtist = SongArtist.getText().toString().trim();
                songTitle = SongTitle.getText().toString().trim();
                genre = Genre.getText().toString().trim();
                album = Album.getText().toString().trim();
                yearOfRelease = YearOfRelease.getText().toString().trim();

                track.setStars(stars);
                track.setFirstReleaseDate(yearOfRelease);
                track.setArtistName(songArtist);
                track.setAlbumName(album);
                track.setTrackName(songTitle);
                track.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().setMusicGenreName(genre);
                db.openWrite();
                db.insert(track);
                db.closeWrite();
                Intent in = new Intent(SetFavouriteSongActivity.this, MainActivity.class);
                startActivity(in);        //HOW TO START SONG FRAGMENT AFTER CLICKING THE SAVE BUTTON??
            }
        });
    }

    private void initViews() {
        rating = findViewById(R.id.rating);
        save = findViewById(R.id.saveDetailsInDatabase);
        SongArtist = findViewById(R.id.songartist);
        SongTitle = findViewById(R.id.songtitle);
        Genre = findViewById(R.id.genre);
        Album = findViewById(R.id.album);
        YearOfRelease = findViewById(R.id.year_of_release);
    }
}
