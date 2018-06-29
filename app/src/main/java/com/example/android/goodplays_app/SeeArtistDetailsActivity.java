package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;

/**
 * Created by hp on 27-06-2018.
 */

public class SeeArtistDetailsActivity extends AppCompatActivity {
    Artist artist;
    TextView name,country,genre,rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_artist);
        //GET THE DETAILS OF THE PARTICULAR ARTIST AND FILL THE RESPECTIVE VIEWS
        Intent i = getIntent();
        artist = (Artist) i.getExtras().getSerializable("artist");
        initViews();
        setData();
    }

    private void setData() {
        name.setText(artist.getArtistName());
        country.setText(artist.getArtistCountry());
        genre.setText(artist.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
        rating.setText("" + artist.getArtistRating());
    }

    private void initViews() {
        name = findViewById(R.id.artistname);
        country = findViewById(R.id.artistcountry);
        genre = findViewById(R.id.artistgenre);
        rating = findViewById(R.id.artistrating);
    }
}
