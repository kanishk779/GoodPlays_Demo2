
package com.example.android.goodplays_app.ModelClasses.SongModelClasses; ;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondaryGenres implements Serializable{

    @SerializedName("music_genre_list")
    @Expose
    private List<Object> musicGenreList = null;

    public List<Object> getMusicGenreList() {
        return musicGenreList;
    }

    public void setMusicGenreList(List<Object> musicGenreList) {
        this.musicGenreList = musicGenreList;
    }

}
