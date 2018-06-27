
package com.example.android.goodplays_app.ModelClasses.ArtistModelClasses; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicGenre {

    @SerializedName("music_genre_id")
    @Expose
    private long musicGenreId;
    @SerializedName("music_genre_parent_id")
    @Expose
    private long musicGenreParentId;
    @SerializedName("music_genre_name")     //WE WANT THIS!!!!
    @Expose
    private String musicGenreName;
    @SerializedName("music_genre_name_extended")
    @Expose
    private String musicGenreNameExtended;
    @SerializedName("music_genre_vanity")
    @Expose
    private String musicGenreVanity;

    public long getMusicGenreId() {
        return musicGenreId;
    }

    public void setMusicGenreId(long musicGenreId) {
        this.musicGenreId = musicGenreId;
    }

    public long getMusicGenreParentId() {
        return musicGenreParentId;
    }

    public void setMusicGenreParentId(long musicGenreParentId) {
        this.musicGenreParentId = musicGenreParentId;
    }

    public String getMusicGenreName() {
        return musicGenreName;
    }

    public void setMusicGenreName(String musicGenreName) {
        this.musicGenreName = musicGenreName;
    }

    public String getMusicGenreNameExtended() {
        return musicGenreNameExtended;
    }

    public void setMusicGenreNameExtended(String musicGenreNameExtended) {
        this.musicGenreNameExtended = musicGenreNameExtended;
    }

    public String getMusicGenreVanity() {
        return musicGenreVanity;
    }

    public void setMusicGenreVanity(String musicGenreVanity) {
        this.musicGenreVanity = musicGenreVanity;
    }

}
