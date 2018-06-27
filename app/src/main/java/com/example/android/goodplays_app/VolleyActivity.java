package com.example.android.goodplays_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.goodplays_app.Adapters.SongDataAdapter;
import com.example.android.goodplays_app.Fragments.SongFragment;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.SongDetail;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.TrackList;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VolleyActivity extends AppCompatActivity {
    private static  final String API_KEY="13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL="http://api.musixmatch.com/ws/1.1/";
    private static final String URL1 = BASE_URL+"chart.tracks.get?page=1&page_size=2&country=it&f_has_lyrics=1&apikey="+API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        //getDataFromServer(URL1);
        loadJSON();
    }
    /*private void getDataFromServer(String url) {

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //refresh.setRefreshing(false);
                try {
                    Toast.makeText(VolleyActivity.this, response, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        Volley.newRequestQueue(this).add(sr);
    }*/
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterfaceRetrofit request = retrofit.create(RequestInterfaceRetrofit.class);
        Call<SongDetail> call = request.getSongJSON(5,1,"it",1,API_KEY);
        call.enqueue(new Callback<SongDetail>() {
            @Override
            public void onResponse(Call<SongDetail> call, retrofit2.Response<SongDetail> response) {
                if(response.isSuccessful())
                {
                    ArrayList<Track> resultList=new ArrayList<>();
                    Gson g = new Gson();
                    //g.fr
                    String jsonResponse = response.body().toString();

                    if(TextUtils.isEmpty(jsonResponse))
                        Toast.makeText(VolleyActivity.this, "RESPONSE IS EMPTY", Toast.LENGTH_SHORT).show();
                   // ArrayList<TrackList> list1= (ArrayList<TrackList>) jsonResponse.getMessage().getBody().getTrackList();
                    /*for(int i=0;i<list1.size();i++)
                    {
                        TrackList trackList = list1.get(i);
                        Track track = trackList.getTrack();
                        resultList.add(track);
                    }*/
                    //String jsonResponse = g.toJson(resultList.get(0));
                    Toast.makeText(VolleyActivity.this, jsonResponse, Toast.LENGTH_LONG).show();
                    Log.e("Data",jsonResponse);
                /*adapter = new SongDataAdapter(resultList);
                recyclerView.setAdapter(adapter);
                adapter.setListener(SongFragment.this);*/
                }
            }

            @Override
            public void onFailure(Call<SongDetail> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
