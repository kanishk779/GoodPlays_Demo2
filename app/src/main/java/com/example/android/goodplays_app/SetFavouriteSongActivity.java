package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.goodplays_app.DataBases.FavouriteSongs;
import com.example.android.goodplays_app.Fragments.SongFragment;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.Track1;

import java.util.ArrayList;

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
    Track incomingTrack=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_song);
        track = new Track1();
        db = new FavouriteSongs(this);
        initViews();
        Intent i = getIntent();
        incomingTrack = (Track)(i.getExtras().getSerializable("track"));//WHY THIS IS NOT WORKING AND NULL??
        Log.e("SetFavouriteSong",""+incomingTrack);
        setData();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                track.setStars(stars);
                track.setFirstReleaseDate(yearOfRelease);
                track.setArtistName(songArtist);
                track.setAlbumName(album);
                track.setTrackName(songTitle);
                //track.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().setMusicGenreName(genre);
                if(isValid()){
                    Track1 track1 = new Track1();
                    ArrayList<Track1> listOfStoredTracks = new ArrayList<>();
                    db.openRead();
                    listOfStoredTracks = db.readAll();
                    db.closeRead();
                    Boolean cond = true;
                    for(int i=0;i<listOfStoredTracks.size();i++)
                    {
                        track1 = listOfStoredTracks.get(i);
                        if(track1.getTrackName().equalsIgnoreCase(track.getTrackName()))
                        {
                            cond = false;
                            break;
                        }
                    }
                    long i=0;
                    if(cond)
                    {
                        db.openWrite();
                        i=db.insert(track);
                        db.closeWrite();
                    }
                    if(i>0)
                    {
                        Toast.makeText(SetFavouriteSongActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SetFavouriteSongActivity.this, "Already Present In Database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void getValues() {
        stars = rating.getRating();
        songArtist = SongArtist.getText().toString().trim();
        songTitle = SongTitle.getText().toString().trim();
        //genre = Genre.getText().toString().trim();
        album = Album.getText().toString().trim();
        yearOfRelease = YearOfRelease.getText().toString().trim();
    }

    private void setData() {
        SongTitle.setText(incomingTrack.getTrackName());
        SongArtist.setText(incomingTrack.getArtistName());
        //Genre.setText(incomingTrack.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
        Album.setText(incomingTrack.getAlbumName());
        YearOfRelease.setText(incomingTrack.getFirstReleaseDate());
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
        SongArtist = findViewById(R.id.songartistfavourite);
        SongTitle = findViewById(R.id.songtitlefavourite);
        //Genre = findViewById(R.id.genrefavourite);
        Album = findViewById(R.id.albumfavourite);
        YearOfRelease = findViewById(R.id.year_of_releasefavourite);
    }
}
