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
 * Created by hp on 01-07-2018.
 */

public class SearchedSongsAdapter extends RecyclerView.Adapter<SearchedSongsAdapter.ViewHolder> {
    ArrayList<Track> list;

    private SearchedSongsAdapter.MyInterface mListener;
    public interface MyInterface{
        public void onItemClick(int position);
    }
    public void setListener1(SearchedSongsAdapter.MyInterface Listener){
        mListener = Listener;
    }
    public SearchedSongsAdapter(ArrayList<Track> list){
        this.list = list;
    }
    @NonNull
    @Override
    public SearchedSongsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song_main, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchedSongsAdapter.ViewHolder holder, int position) {
        Track song = list.get(position);
        holder.Artist.setText(song.getArtistName());
        holder.Title.setText(song.getTrackName());
    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        return list.size();
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
