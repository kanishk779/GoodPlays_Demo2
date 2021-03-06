
package com.example.android.goodplays_app.ModelClasses.ArtistModelClasses; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArtistNameTranslationList implements Serializable {

    @SerializedName("artist_name_translation")
    @Expose
    private ArtistNameTranslation artistNameTranslation;

    public ArtistNameTranslation getArtistNameTranslation() {
        return artistNameTranslation;
    }

    public void setArtistNameTranslation(ArtistNameTranslation artistNameTranslation) {
        this.artistNameTranslation = artistNameTranslation;
    }

}
