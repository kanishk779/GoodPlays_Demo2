
package com.example.android.goodplays_app.ModelClasses.ArtistModelClasses; ;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body implements Serializable {

    @SerializedName("artist_list")
    @Expose
    private List<ArtistList> artistList = null;

    public List<ArtistList> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<ArtistList> artistList) {
        this.artistList = artistList;
    }

}
