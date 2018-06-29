package com.example.android.goodplays_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.ArtistList;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 26-06-2018.
 */

public class ArtistDataAdapter extends RecyclerView.Adapter<ArtistDataAdapter.MyViewHolder>{

    ArrayList<Artist> Artistlist;
    MyInterface1 mListener1;

    public interface MyInterface1{
        public void onItemClick1(int position);
    }
    public void setListener(MyInterface1 Listener){
        mListener1 = Listener;
    }
    public ArtistDataAdapter(ArrayList<Artist> list){
        Artistlist =list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,country;
        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name_of_artist);
            country = view.findViewById(R.id.country_of_artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener1!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener1.onItemClick1(position);
                        }
                    }
                }
            });
        }
    }
    @NonNull
    @Override
    public ArtistDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Artist artist = Artistlist.get(position);
        holder.name.setText(artist.getArtistName());
        holder.country.setText(artist.getArtistCountry());
    }

    @Override
    public int getItemCount() {
        if(Artistlist!=null)
        {
            return Artistlist.size();
        }
        return 0;
    }
}
