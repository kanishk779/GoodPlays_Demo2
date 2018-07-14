package com.example.android.goodplays_app.Fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.android.goodplays_app.Adapters.SongDataAdapter;
import com.example.android.goodplays_app.MainActivity;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.SongDetail;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.TrackList;
import com.example.android.goodplays_app.R;
import com.example.android.goodplays_app.RequestInterfaceRetrofit;
import com.example.android.goodplays_app.SeeSongDetailsActivity;
import com.example.android.goodplays_app.SetFavouriteSongActivity;
import com.example.android.goodplays_app.SplashFile;
import com.example.android.goodplays_app.VolleyActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
//import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by hp on 26-06-2018.
 */

public class SongFragment extends Fragment implements SongDataAdapter.MyInterface {
    private static  final String API_KEY="13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL="http://api.musixmatch.com/ws/1.1/";
    private static final String URL1 = BASE_URL+"chart.tracks.get?page=1&page_size=2&country=it&f_has_lyrics=1&apikey="+API_KEY;
    private RecyclerView recyclerView;
    private ArrayList<Track> data;
    private SongDataAdapter adapter;
    Gson g = new Gson();
    ProgressDialog pd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top_song,container,false);
        //Toast.makeText(getContext(), "PD is Culprit", Toast.LENGTH_SHORT).show();
        pd = new ProgressDialog(getContext());
        try{
            data = (ArrayList<Track>) getArguments().getSerializable("listtracks");
        }
        catch(Exception e)
        {
            Toast.makeText(getContext(),"IN Song Fragment" + e.toString(), Toast.LENGTH_SHORT).show();
        }
        Log.e("IN","Song FragmentOnCREATE");
        //getDataFromServer1(URL1);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("IN","SongFragment OnCREATED");
        recyclerView = view.findViewById(R.id.recycler_view_songs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SongDataAdapter(data);
        recyclerView.setAdapter(adapter);
        adapter.setListener(SongFragment.this);
    }
    @Override
    public void onItemClick(final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("Choose what u want to do ?");
        dialog.setTitle("Welcome user!");
        dialog.setNeutralButton("See Details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i  =new Intent(getContext(), SeeSongDetailsActivity.class);
                //WRITE CODE FOR PASSING THE DATA OF PARTICULAR SONG TO THE ACTIVITY SONGDETAIL
                i.putExtra("track",data.get(position));
                startActivity(i);
            }
        });
        dialog.setPositiveButton("Save As Favourite", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent j =new Intent(getContext(), SetFavouriteSongActivity.class);
                //WRITE CODE FOR PASSING THE DATA OF PARTICULAR SONG TO THE ACTIVITY SONGDETAIL
                j.putExtra("track",data.get(position));
                startActivity(j);
            }
        });
        dialog.show();
    }
}


/*private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterfaceRetrofit request = retrofit.create(RequestInterfaceRetrofit.class);
        Call<SongDetail> call = request.getSongJSON(5,10,"in",1,API_KEY);
        call.enqueue(new Callback<SongDetail>() {
            @Override
            public void onResponse(Call<SongDetail> call, Response<SongDetail> response) {
                ArrayList<Track> resultList=new ArrayList<>();
                Gson g = new Gson();
                SongDetail jsonResponse = response.body();
                ArrayList<TrackList> list1= (ArrayList<TrackList>) jsonResponse.getMessage().getBody().getTrackList();
                for(int i=0;i<list1.size();i++)
                {
                    TrackList trackList = list1.get(i);
                    Track track = trackList.getTrack();
                    resultList.add(track);
                }
                adapter = new SongDataAdapter(resultList);
                recyclerView.setAdapter(adapter);
                adapter.setListener(SongFragment.this);
            }

            @Override
            public void onFailure(Call<SongDetail> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }*/




/*private void getDataFromServer1(String url)
    {
        pd.show();
        StringRequest sr = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
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
                        data.add(tc);
                    }
                    adapter = new SongDataAdapter(data);
                    recyclerView.setAdapter(adapter);

                    adapter.setListener(SongFragment.this);
                    Toast.makeText(getContext(), "CULprit is CONTEXT", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Deep" + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                Toast.makeText(getContext(), "" + error, Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(sr);
    }*/



/*private void getDataFromServer(String url) {

        StringRequest sr = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ArrayList<Track> resultList=new ArrayList<>();
                //refresh.setRefreshing(false);
                try {
                    //Toast.makeText(VolleyActivity.this, response, Toast.LENGTH_LONG).show();
                     SongDetail sd = g.fromJson(response,SongDetail.class);
                    ArrayList<TrackList> list1= (ArrayList<TrackList>) sd.getMessage().getBody().getTrackList();
                    for(int i=0;i<list1.size();i++)
                    {
                        TrackList trackList = list1.get(i);
                        Track track = trackList.getTrack();
                        resultList.add(track);
                    }
                    adapter = new SongDataAdapter(resultList);
                    recyclerView.setAdapter(adapter);
                    adapter.setListener(SongFragment.this);
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(sr);
    }*/