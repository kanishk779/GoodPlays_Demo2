package com.example.android.goodplays_app.Fragments;

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
import android.widget.TextView;

import com.example.android.goodplays_app.Adapters.FavouriteDataAdapter;
import com.example.android.goodplays_app.Adapters.SongDataAdapter;
import com.example.android.goodplays_app.DataBases.FavouriteSongs;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.SongDetail;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.TrackList;
import com.example.android.goodplays_app.ModelClasses.Track1;
import com.example.android.goodplays_app.R;
import com.example.android.goodplays_app.RequestInterfaceRetrofit;
import com.example.android.goodplays_app.SeeFavouriteSongActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 26-06-2018.
 */

public class FavouriteFragment extends Fragment implements FavouriteDataAdapter.MyInterface2 {
    private static  final String API_KEY="13c8bfd76a0c573ff72cb0be3f1201b9";
    private static final String BASE_URL="http://api.musixmatch.com/ws/1.1/";
    private RecyclerView recyclerView;
    private ArrayList<Track1> data;
    private FavouriteDataAdapter adapter;
    private FavouriteSongs db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourite,container,false);
        Log.e("IN","Favourite FragmentOnCREATE");
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("IN","Favourite Fragment OnCREATED");
        recyclerView = view.findViewById(R.id.recycler_view_favourite);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        db = new FavouriteSongs(getContext());
        try{
            db.openRead();
            data = db.readAll();
            db.closeRead();
        }
        catch (Exception e){
            Log.e("error",e.toString());
        }
        adapter = new FavouriteDataAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick2(View view) {
        Intent i = new Intent(getContext(), SeeFavouriteSongActivity.class);
        //SEND THE DATA TO THE SONG SAVED BY USER AS FAVOURITE FROM DATABASE
        TextView songTitle = view.findViewById(R.id.favourite_song_title);
        db.openRead();
        Track1 track = db.read(songTitle.getText().toString().trim());
        db.closeRead();
        i.putExtra("favouriteSong",track);
        startActivity(i);
    }
}
