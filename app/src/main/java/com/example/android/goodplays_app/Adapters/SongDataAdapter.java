package com.example.android.goodplays_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.R;

import java.util.ArrayList;

/**
 * Created by hp on 26-06-2018.
 */

public class SongDataAdapter extends RecyclerView.Adapter<SongDataAdapter.ViewHolder> {
    private ArrayList<Track> songList;
    private MyInterface mListener;
    public interface MyInterface{
        public void onItemClick(int position);
    }
    public void setListener(MyInterface Listener){
        mListener = Listener;
    }
    public SongDataAdapter(ArrayList<Track> list)
    {
        songList = list;
    }
    @NonNull
    @Override
    public SongDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song_main, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongDataAdapter.ViewHolder holder, int position) {
        Track song = songList.get(position);
        holder.Artist.setText(song.getArtistName());
        holder.Title.setText(song.getTrackName());
       // song.get                              ASK HOW TO SET IMAGE???
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Title,Artist;
        public ImageView poster;
        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.song_title);
            Artist = itemView.findViewById(R.id.song_artist);
            poster = itemView.findViewById(R.id.song_poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
