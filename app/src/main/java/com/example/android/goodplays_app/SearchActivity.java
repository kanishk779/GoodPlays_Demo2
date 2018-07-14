package com.example.android.goodplays_app;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.goodplays_app.Adapters.SearchedSongsAdapter;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity  {

    private static String SONG_NAME="";
    private static String PAGE_SIZE="";
    private static String SORT="";
    Button result;
    EditText songQueryBox,pageQuery;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Intent in = new Intent(SearchActivity.this,SongsFetchActivity.class);
                    in.putExtra("song",SONG_NAME);
                    in.putExtra("pageSize",PAGE_SIZE);
                    in.putExtra("sort",SORT);
                    startActivity(in);
                }
            }
        });
    }

    private void initViews() {
        result = findViewById(R.id.songQuerybtn);
        songQueryBox = findViewById(R.id.songQuery);
        pageQuery = findViewById(R.id.noOfSongs);
        spinner = findViewById(R.id.sortBySpinner);
    }

    private boolean isValid() {
        SONG_NAME = songQueryBox.getText().toString().trim();
        PAGE_SIZE = pageQuery.getText().toString().trim();
        SORT = spinner.getSelectedItem().toString().trim();
        if (TextUtils.isEmpty(SONG_NAME))
            return false;
        if(TextUtils.isEmpty(PAGE_SIZE))
            return false;
        return true;
    }
}
