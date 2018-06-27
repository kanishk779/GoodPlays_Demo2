
package com.example.android.goodplays_app.ModelClasses.ArtistModelClasses; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistCredits {

    @SerializedName("artist_list")
    @Expose
    private List<Object> artistList = null;

    public List<Object> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Object> artistList) {
        this.artistList = artistList;
    }

}
