package com.example.android.goodplays_app;

/**
 * Created by hp on 28-06-2018.
 */

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SplashFile extends AppCompatActivity {
    Button start;
    ArrayList<Track> listTrack;
    ArrayList<Artist> listArtist;
    private static final String API_KEY = "13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL = "http://api.musixmatch.com/ws/1.1/";
   // private static final String URL1 = BASE_URL + "chart.tracks.get?page=1&page_size=20&country=in&f_has_lyrics=1&apikey=" + API_KEY;
    private static final String URL2 = BASE_URL + "chart.artists.get?page=1&page_size=30&country=in&apikey=" + API_KEY;
    private static final String URL1 = BASE_URL + "chart.tracks.get?page=1&page_size=30&country=in&apikey=" + API_KEY;        //CHECK IF U NEED TO ADD '?'
    Uri.Builder uriBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_file);
        start = findViewById(R.id.startApp);
        listTrack = new ArrayList<>();
        listArtist = new ArrayList<>();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncCaller().execute();
            }
        });
    }
    private class AsyncCaller extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            StringRequest sr = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Gson g = new Gson();
                        JSONObject jo1 = new JSONObject(response);
                        JSONObject jo2 = jo1.getJSONObject("message");
                        JSONObject jo3 = jo2.getJSONObject("body");
                        JSONArray ja1 = jo3.getJSONArray("track_list");
                        for (int i = 0; i < ja1.length(); i++) {
                            JSONObject joo = ja1.getJSONObject(i);
                            JSONObject joo1 = joo.getJSONObject("track");
                            Track tc = g.fromJson(joo1.toString(), Track.class);
                            listTrack.add(tc);
                        }
                    }
                    catch (Exception e) {
                        Toast.makeText(SplashFile.this, "SplashFile Songs" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
                }
            });
            Volley.newRequestQueue(SplashFile.this).add(sr);

            StringRequest sr1 = new StringRequest(Request.Method.GET, URL2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Gson g = new Gson();
                        JSONObject jo1 = new JSONObject(response);
                        JSONObject jo2 = jo1.getJSONObject("message");
                        JSONObject jo3 = jo2.getJSONObject("body");
                        JSONArray ja1 = jo3.getJSONArray("artist_list");
                        for (int i = 0; i < ja1.length(); i++) {
                            JSONObject joo = ja1.getJSONObject(i);
                            JSONObject joo1 = joo.getJSONObject("artist");
                            Artist tc = g.fromJson(joo1.toString(), Artist.class);
                            listArtist.add(tc);
                        }
                    } catch (Exception e) {
                        Toast.makeText(SplashFile.this, "SplashFile Artist" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
                }
            });
            Volley.newRequestQueue(SplashFile.this).add(sr1);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            /*Toast.makeText(SplashFile.this, ""+listTrack, Toast.LENGTH_LONG).show();
            Toast.makeText(SplashFile.this, ""+listArtist, Toast.LENGTH_LONG).show();*/
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            in.putExtra("listartist", listArtist);
            in.putExtra("listtracks",listTrack);
            startActivity(in);
        }

    }

}

        /*SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String pages = sharedPrefs.getString("no_of_pages","1");
        String songs = sharedPrefs.getString("songs_on_each_page","10");
        String country = sharedPrefs.getString("country","in");
        Uri baseUri = Uri.parse(BASE_URL);
        uriBuilder = baseUri.buildUpon();
        uriBuilder.appendQueryParameter("page",pages);
        uriBuilder.appendQueryParameter("page_size",songs);
        uriBuilder.appendQueryParameter("country",country);
        uriBuilder.appendQueryParameter("f_has_lyrics","1");
        uriBuilder.appendQueryParameter("apikey",API_KEY);*/
        /*setDataFromServer1();
        setDataFromServer();*/



/*public static class TracksPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.user_settings);

            Preference pages = findPreference("no_of_pages");
            Preference songOnEachPage = findPreference("songs_on_each_page");
            Preference Country = findPreference("country");
            bindPreferenceSummaryToValues(pages);
            bindPreferenceSummaryToValues(songOnEachPage);
            bindPreferenceSummaryToValues(Country);
        }

        private void bindPreferenceSummaryToValues(Preference preference)
        {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = sharedPreferences.getString(preference.getKey(),"");
            onPreferenceChange(preference,preferenceString);
        }


        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String stringValue = newValue.toString();
            if(preference instanceof ListPreference)
            {
                ListPreference lp = (ListPreference)preference;
                int prefIndex = lp.findIndexOfValue(stringValue);
                if(prefIndex>=0)
                {
                    CharSequence[] labels = lp.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            }
            else {
                preference.setSummary(stringValue);
            }
            return true;
        }
    }*/





