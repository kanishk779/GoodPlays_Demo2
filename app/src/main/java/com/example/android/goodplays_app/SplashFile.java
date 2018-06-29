package com.example.android.goodplays_app;

/**
 * Created by hp on 28-06-2018.
 */

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
    Boolean completedSong, completedArtist;
    ProgressDialog pd;
    ArrayList<Track> listTrack;
    ArrayList<Artist> listArtist;
    private static final String API_KEY = "13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL = "http://api.musixmatch.com/ws/1.1/";
    private static final String URL1 = BASE_URL + "chart.tracks.get?page=1&page_size=20&country=in&f_has_lyrics=1&apikey=" + API_KEY;
    private static final String URL2 = BASE_URL + "chart.artists.get?page=1&page_size=30&country=in&apikey=" + API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_file);
        start = findViewById(R.id.startApp);
        pd = new ProgressDialog(this);
        completedSong = false;
        completedArtist = false;
        listTrack = new ArrayList<>();
        listArtist = new ArrayList<>();
        /*setDataFromServer1();
        setDataFromServer();*/

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncCaller().execute();
            }
        });
    }

    private void setDataFromServer() {
        //pd.show();
        StringRequest sr = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                completedSong = true;
                //if (completedArtist)
                    //pd.dismiss();
                //Toast.makeText(SplashFile.this, response, Toast.LENGTH_SHORT).show();
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

                    /*Intent in = new Intent(SplashFile.this, MainActivity.class);
                    in.putExtra("listtracks", listTrack);
                    //Toast.makeText(SplashFile.this, ""+listTrack.get(0), Toast.LENGTH_SHORT).show();
                    //if (completedArtist)
                        startActivity(in);*/

                } catch (Exception e) {
                    Toast.makeText(SplashFile.this, "Deep" + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //pd.dismiss();
                Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(sr);

    }

    private void setDataFromServer1() {
        //pd.show();
        StringRequest sr = new StringRequest(Request.Method.GET, URL2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                completedArtist = true;
                //if (completedSong)
                    //pd.dismiss();

                //Toast.makeText(SplashFile.this, response, Toast.LENGTH_SHORT).show();
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

                    /*Intent in = new Intent(SplashFile.this, MainActivity.class);
                    in.putExtra("listartist", listArtist);
                    //Toast.makeText(SplashFile.this, ""+listTrack.get(0), Toast.LENGTH_SHORT).show();
                    //if (completedSong)
                        startActivity(in);*/

                } catch (Exception e) {
                    Toast.makeText(SplashFile.this, "Deep" + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //pd.dismiss();
                Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(sr);

    }
    private class AsyncCaller extends AsyncTask<Void, Void, String> {
        //ProgressDialog pdLoading = new ProgressDialog(AsyncExample.this);
       // pd = new ProgressDialog(this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            //pd.setMessage("\tLoading...");
            //pd.show();
        }

        @Override
        protected String doInBackground(Void... params) {

            //this method will be running on background thread so don't update UI frome here
            //do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here
            //();
            //setDataFromServer();
            StringRequest sr = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    completedSong = true;
                    //if (completedArtist)
                    //pd.dismiss();
                    //Toast.makeText(SplashFile.this, response, Toast.LENGTH_SHORT).show();
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

                    /*Intent in = new Intent(SplashFile.this, MainActivity.class);
                    in.putExtra("listtracks", listTrack);
                    //Toast.makeText(SplashFile.this, ""+listTrack.get(0), Toast.LENGTH_SHORT).show();
                    //if (completedArtist)
                        startActivity(in);*/

                    } catch (Exception e) {
                        Toast.makeText(SplashFile.this, "Deep" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //pd.dismiss();
                    Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
                }
            });
            Volley.newRequestQueue(SplashFile.this).add(sr);
            StringRequest sr1 = new StringRequest(Request.Method.GET, URL2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    completedArtist = true;
                    //if (completedSong)
                    //pd.dismiss();

                    //Toast.makeText(SplashFile.this, response, Toast.LENGTH_SHORT).show();
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

                    /*Intent in = new Intent(SplashFile.this, MainActivity.class);
                    in.putExtra("listartist", listArtist);
                    //Toast.makeText(SplashFile.this, ""+listTrack.get(0), Toast.LENGTH_SHORT).show();
                    //if (completedSong)
                        startActivity(in);*/

                    } catch (Exception e) {
                        Toast.makeText(SplashFile.this, "Deep" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //pd.dismiss();
                    Toast.makeText(SplashFile.this, "" + error, Toast.LENGTH_SHORT).show();
                }
            });
            Volley.newRequestQueue(SplashFile.this).add(sr1);
            return "success";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            //this method will be running on UI thread

            if(result.equalsIgnoreCase("success"))
            {
                //pd.dismiss();
                Intent in = new Intent(SplashFile.this, MainActivity.class);
                in.putExtra("listtracks",listTrack);
                in.putExtra("listartist", listArtist);
                Toast.makeText(SplashFile.this, ""+listArtist, Toast.LENGTH_SHORT).show();
                Toast.makeText(SplashFile.this, ""+listTrack, Toast.LENGTH_SHORT).show();
                startActivity(in);
            }
            //startActivity(in);
        }

    }

}







