package com.example.android.goodplays_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

/**
 * Created by hp on 27-06-2018.
 */

public class SeeSongDetailsActivity extends AppCompatActivity {
    Track song;
    TextView title,artist,genre,album,yearOfRelease;
    Button lyrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_songs);
        Intent i = getIntent();
        song = (Track)i.getExtras().getSerializable("track");
        initViews();
        setData();
        lyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(SeeSongDetailsActivity.this,LyricsFetchActivity.class);
                i.putExtra("track_id",song.getTrackId());
                startActivity(i);*/
                String str = song.getTrackShareUrl();
                StringBuilder url= new StringBuilder();
                String arr[] = str.split("\\\\");
                for(int i=0;i<arr.length;i++)
                {
                    url.append(arr[i]);
                }
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url.toString()));
                startActivity(in);
            }
        });
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
        lyrics = findViewById(R.id.getLyrics);
    }
}
