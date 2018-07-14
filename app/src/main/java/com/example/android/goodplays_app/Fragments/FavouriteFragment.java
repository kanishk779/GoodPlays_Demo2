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
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.android.goodplays_app.SeeSongDetailsActivity;
import com.example.android.goodplays_app.SetFavouriteSongActivity;
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
        adapter.setListener(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick2(final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("Choose what u want to do ?");
        dialog.setTitle("Welcome user!");
        dialog.setNeutralButton("See Details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getContext(), SeeFavouriteSongActivity.class);
                Track1 track = data.get(position);
                i.putExtra("track",track);
                startActivity(i);
            }
        });
        dialog.setPositiveButton("Delete From Favourite", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                long i=0;
                Track1 track = data.get(position);
                db = new FavouriteSongs(getContext());
                db.openWrite();
                i = db.delete(track.getTrackName());
                db.closeWrite();
                if(i>0)
                    Toast.makeText(getContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Could Not Be Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
