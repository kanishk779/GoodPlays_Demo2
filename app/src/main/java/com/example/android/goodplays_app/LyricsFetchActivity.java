package com.example.android.goodplays_app;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.goodplays_app.Adapters.SearchedSongsAdapter;
import com.example.android.goodplays_app.ModelClasses.LyricsModelClasses.Lyrics;

public class LyricsFetchActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Lyrics>{
    private static final String API_KEY = "13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL = "http://api.musixmatch.com/ws/1.1/";
    private static String URL = BASE_URL + "track.lyrics.get";  //USE URI bUILDER TO COMPLETE THIS
    private long TRACK_ID=0;
    private TextView mEmptyStateTextView,LyricsView;
    private int LYRICS_LOADER_ID =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics_fetch);
        TRACK_ID = getIntent().getExtras().getLong("track_id");
        Toast.makeText(this, ""+TRACK_ID, Toast.LENGTH_LONG).show();
        mEmptyStateTextView =  findViewById(R.id.empty_view);
        LyricsView = findViewById(R.id.lyricsTextViewLoad);
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
            loaderManager.initLoader(LYRICS_LOADER_ID, null,  this);
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
    public Loader<Lyrics> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.appendQueryParameter("track_id",String.valueOf(TRACK_ID));
        uriBuilder.appendQueryParameter("apiKey",API_KEY);
        return new LyricsLoader(this,uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<Lyrics> loader, Lyrics data) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        if ( data!= null) {
            mEmptyStateTextView.setVisibility(View.GONE);
            LyricsView.setText(data.getLyricsBody());
        }
    }

    @Override
    public void onLoaderReset(Loader<Lyrics> loader) {

    }
}
