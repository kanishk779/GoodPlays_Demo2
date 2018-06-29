package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.goodplays_app.DataBases.FavouriteSongs;
import com.example.android.goodplays_app.Fragments.SongFragment;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
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
    Track incomingTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_song);
        initViews();
        Intent i = getIntent();
        incomingTrack = (Track)i.getExtras().getSerializable("track");         //WHY THIS IS NOT WORKING AND NULL??
        SongTitle.setText(incomingTrack.getTrackName());
        SongArtist.setText(incomingTrack.getArtistName());
        Genre.setText(incomingTrack.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
        Album.setText(incomingTrack.getAlbumName());
        YearOfRelease.setText(incomingTrack.getFirstReleaseDate());
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
                if(isValid()){
                    db.openWrite();
                    db.insert(track);
                    db.closeWrite();
                    Intent in = new Intent(SetFavouriteSongActivity.this, MainActivity.class);    //CHECK THIS IF IT LAUNCHES THE DESIRED FRAGMENT
                    startActivity(in);        //HOW TO START SONG FRAGMENT AFTER CLICKING THE SAVE BUTTON??
                }
            }
        });
    }

    private boolean isValid() {
        if(rating.getRating()==0.0)
        {
            Toast.makeText(this, "Please give the rating !!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private void initViews() {
        rating = findViewById(R.id.ratingfavourite);
        save = findViewById(R.id.saveDetailsInDatabase);
        SongArtist = findViewById(R.id.songartist);
        SongTitle = findViewById(R.id.songtitle);
        Genre = findViewById(R.id.genre);
        Album = findViewById(R.id.album);
        YearOfRelease = findViewById(R.id.year_of_releasefavourite);
    }
}
