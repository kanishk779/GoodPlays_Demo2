package com.example.android.goodplays_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.Track1;
import com.example.android.goodplays_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 26-06-2018.
 */

public class FavouriteDataAdapter extends RecyclerView.Adapter<FavouriteDataAdapter.MyViewHolder> {

    ArrayList<Track1> FavouriteList;
    MyInterface2 mListener2;

    public interface MyInterface2{
        public void onItemClick2(int position);                     //YOU CAN ALSO PASS POSITION
    }
    public void setListener(MyInterface2 Listener){
        mListener2 = Listener;
    }
    public FavouriteDataAdapter(ArrayList<Track1> list){
        FavouriteList = list;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Title,Artist;
        public MyViewHolder(final View view){
            super(view);
            Title = view.findViewById(R.id.favourite_song_title);
            Artist = view.findViewById(R.id.favourite_song_artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener2!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener2.onItemClick2(position);            //YOU CAN ALSO PASS POSITION
                        }
                    }
                }
            });
        }
    }
    @NonNull
    @Override
    public FavouriteDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favourite_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteDataAdapter.MyViewHolder holder, int position) {
        Track1 song = FavouriteList.get(position);
        holder.Artist.setText(song.getArtistName());
        holder.Title.setText(song.getTrackName());
    }

    @Override
    public int getItemCount() {
        return FavouriteList.size();
    }
}
