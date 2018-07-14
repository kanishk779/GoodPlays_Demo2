package com.example.android.goodplays_app.Fragments;

import android.app.AlertDialog;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.goodplays_app.Adapters.ArtistDataAdapter;
import com.example.android.goodplays_app.Adapters.SongDataAdapter;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.ArtistDetail;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.ArtistList;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.SongDetail;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.TrackList;
import com.example.android.goodplays_app.R;
import com.example.android.goodplays_app.RequestInterfaceRetrofit;
import com.example.android.goodplays_app.SeeArtistDetailsActivity;
import com.example.android.goodplays_app.SeeSongDetailsActivity;
import com.example.android.goodplays_app.SetFavouriteSongActivity;
import com.example.android.goodplays_app.SplashFile;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 26-06-2018.
 */

public class ArtistsFragment extends Fragment implements ArtistDataAdapter.MyInterface1{
    private static  final String API_KEY="13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL="http://api.musixmatch.com/ws/1.1/";
    private static final String URL2 = BASE_URL+"chart.artists.get?page=1&page_size=3&country=in&apikey="+API_KEY;
    private RecyclerView recyclerView;
    private ArrayList<Artist> data;
    private ArtistDataAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top_artists,container,false);
        try{
            data = (ArrayList<Artist>) getArguments().getSerializable("listartist");
        }
        catch(Exception e)
        {
            Toast.makeText(getContext(), "IN Artist Fragment" + e.toString(), Toast.LENGTH_SHORT).show();
        }
        Log.e("IN","ArtisFragmentOnCREATE");
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("IN","ArtisFragment  OnCREATED");
        recyclerView = view.findViewById(R.id.recycler_view_artists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ArtistDataAdapter(data);
        recyclerView.setAdapter(adapter);
        adapter.setListener(ArtistsFragment.this);
        //loadJSON();
    }

    @Override
    public void onItemClick1(final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("Choose what u want to do ?");
        dialog.setTitle("Welcome user!");
        dialog.setNeutralButton("See Details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i  =new Intent(getContext(), SeeArtistDetailsActivity.class);
                //WRITE CODE FOR PASSING THE DATA OF PARTICULAR Artist TO THE ACTIVITY ARRTISTDETAIL
                i.putExtra("artist",data.get(position));
                startActivity(i);
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
        Call<ArtistDetail> call = request.getArtistJSON(5,10,"in",API_KEY);
        call.enqueue(new Callback<ArtistDetail>() {
            @Override
            public void onResponse(Call<ArtistDetail> call, Response<ArtistDetail> response) {
                ArrayList<Artist> resultList=new ArrayList<>();
                Gson g = new Gson();
                ArtistDetail jsonResponse = response.body();
                ArrayList<ArtistList> list1= (ArrayList<ArtistList>) jsonResponse.getMessage().getBody().getArtistList();
                for(int i=0;i<list1.size();i++)
                {
                    ArtistList artistList = list1.get(i);
                    Artist artist = artistList.getArtist();
                    resultList.add(artist);
                }
                adapter = new ArtistDataAdapter(resultList);
                recyclerView.setAdapter(adapter);
                adapter.setListener(ArtistsFragment.this);
            }

            @Override
            public void onFailure(Call<ArtistDetail> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }*/



    /*private void setDataFromServer1() {
        //pd.show();
        StringRequest sr = new StringRequest(Request.Method.GET, URL2, new com.android.volley.Response.Listener<String>() {
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
                        //listArtist.add(tc);
                        data.add(tc);
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Deep" + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //pd.dismiss();
                Toast.makeText(getContext(), "" + error, Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(sr);

    }*/