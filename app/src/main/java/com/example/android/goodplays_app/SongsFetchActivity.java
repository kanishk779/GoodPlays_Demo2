package com.example.android.goodplays_app;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.goodplays_app.Adapters.SearchedSongsAdapter;
import com.example.android.goodplays_app.Adapters.SongDataAdapter;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

import java.util.ArrayList;
import java.util.List;

public class SongsFetchActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Track>>,SongDataAdapter.MyInterface{
    private static final String API_KEY = "13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL = "http://api.musixmatch.com/ws/1.1/";
    private static String SONG_NAME="";
    private static String PAGE_SIZE="";
    private static String SORT="";
    private RecyclerView seachedSongsList;
    private SearchedSongsAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private int SONG_LOADER_ID =1;
    private static String URL ;
    private static ArrayList<Track> Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_fetch);
        SONG_NAME = getIntent().getExtras().getString("song");
        PAGE_SIZE = getIntent().getExtras().getString("pageSize");
        SORT = getIntent().getExtras().getString("sort");
        URL =BASE_URL + "track.search?q=" + SONG_NAME + "&page_size="+PAGE_SIZE+"&page=1&s_track_rating="+SORT+"&apikey=" + API_KEY;
        seachedSongsList = findViewById(R.id.recycler_view_search);
        //mAdapter = new SearchedSongsAdapter(new ArrayList<Track>());
        mEmptyStateTextView =  findViewById(R.id.empty_view);
        //seachedSongsList.setEmptyView(mEmptyStateTextView);    ADD IT WHEN DATA RECEIVED IS NULL
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(SONG_LOADER_ID, null,  this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText("No Internet Connection");
        }
    }

    @Override
    public Loader<ArrayList<Track>> onCreateLoader(int id, Bundle args) {
        return new SongsLoader(this,URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Track>> loader, ArrayList<Track> data) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        if ( data!= null && !data.isEmpty()) {
            Data = data;
            mEmptyStateTextView.setVisibility(View.GONE);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            seachedSongsList.setLayoutManager(layoutManager);
            seachedSongsList.setVisibility(View.VISIBLE);
            mAdapter = new SearchedSongsAdapter(data);
            seachedSongsList.setAdapter(mAdapter);
        }
        else
        {
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            seachedSongsList.setVisibility(View.GONE);
            mEmptyStateTextView.setText("No Songs Available");
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Track>> loader) {

    }

    @Override
    public void onItemClick(int position) {
        Intent i  =new Intent(this, SeeSongDetailsActivity.class);
        //WRITE CODE FOR PASSING THE DATA OF PARTICULAR SONG TO THE ACTIVITY SONGDETAIL
        i.putExtra("track",Data.get(position));
        startActivity(i);
    }
}
