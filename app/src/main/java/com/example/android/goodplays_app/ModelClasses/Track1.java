package com.example.android.goodplays_app.ModelClasses;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.PrimaryGenres;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hp on 26-06-2018.
 */

public class Track1 {
    @SerializedName("primary_genres")         //WE WANT THIS!!!!
    @Expose
    private PrimaryGenres primaryGenres;
    private float stars;
    @SerializedName("track_id")
    @Expose
    private long trackId;
    @SerializedName("track_mbid")
    @Expose
    private String trackMbid;
    @SerializedName("track_isrc")
    @Expose
    private String trackIsrc;
    @SerializedName("track_spotify_id")
    @Expose
    private String trackSpotifyId;
    @SerializedName("track_soundcloud_id")
    @Expose
    private String trackSoundcloudId;
    @SerializedName("track_xboxmusic_id")
    @Expose
    private String trackXboxmusicId;
    @SerializedName("track_name")     //WE WANT THIS!!!!
    @Expose
    private String trackName;
    @SerializedName("track_name_translation_list")
    @Expose
    private List<Object> trackNameTranslationList = null;
    @SerializedName("track_rating")     //WE WANT THIS!!!!
    @Expose
    private long trackRating;
    @Expose
    private long explicit;
    @SerializedName("has_lyrics")       //WE WANT THIS!!!!
    @Expose
    private long hasLyrics;
    @Expose
    private long numFavourite;
    @SerializedName("lyrics_id")      //WE WANT THIS!!!!
    @Expose
    private long lyricsId;
    @SerializedName("subtitle_id")
    @Expose
    private long subtitleId;
    @SerializedName("album_id")
    @Expose
    private long albumId;
    @SerializedName("album_name")     //WE WANT THIS!!!!
    @Expose
    private String albumName;
    @SerializedName("artist_id")
    @Expose
    private long artistId;
    @SerializedName("artist_mbid")
    @Expose
    private String artistMbid;
    @SerializedName("artist_name")     //WE WANT THIS!!!!
    @Expose
    private String artistName;
    @SerializedName("album_coverart_100x100")    //WE WANT THIS!!!! FOR OBTAINING POSTER
    @Expose
    private String albumCoverart100x100;
    private long restricted;
    @SerializedName("first_release_date")
    @Expose
    private String firstReleaseDate;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    public PrimaryGenres getPrimaryGenres() {
        return primaryGenres;
    }

    public void setPrimaryGenres(PrimaryGenres primaryGenres) {
        this.primaryGenres = primaryGenres;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackMbid() {
        return trackMbid;
    }

    public void setTrackMbid(String trackMbid) {
        this.trackMbid = trackMbid;
    }

    public String getTrackIsrc() {
        return trackIsrc;
    }

    public void setTrackIsrc(String trackIsrc) {
        this.trackIsrc = trackIsrc;
    }

    public String getTrackSpotifyId() {
        return trackSpotifyId;
    }

    public void setTrackSpotifyId(String trackSpotifyId) {
        this.trackSpotifyId = trackSpotifyId;
    }

    public String getTrackSoundcloudId() {
        return trackSoundcloudId;
    }

    public void setTrackSoundcloudId(String trackSoundcloudId) {
        this.trackSoundcloudId = trackSoundcloudId;
    }

    public String getTrackXboxmusicId() {
        return trackXboxmusicId;
    }

    public void setTrackXboxmusicId(String trackXboxmusicId) {
        this.trackXboxmusicId = trackXboxmusicId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Object> getTrackNameTranslationList() {
        return trackNameTranslationList;
    }

    public void setTrackNameTranslationList(List<Object> trackNameTranslationList) {
        this.trackNameTranslationList = trackNameTranslationList;
    }

    public long getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(long trackRating) {
        this.trackRating = trackRating;
    }


    public long getExplicit() {
        return explicit;
    }

    public void setExplicit(long explicit) {
        this.explicit = explicit;
    }

    public long getHasLyrics() {
        return hasLyrics;
    }

    public void setHasLyrics(long hasLyrics) {
        this.hasLyrics = hasLyrics;
    }

    public long getNumFavourite() {
        return numFavourite;
    }

    public void setNumFavourite(long numFavourite) {
        this.numFavourite = numFavourite;
    }

    public long getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(long lyricsId) {
        this.lyricsId = lyricsId;
    }

    public long getSubtitleId() {
        return subtitleId;
    }

    public void setSubtitleId(long subtitleId) {
        this.subtitleId = subtitleId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getArtistMbid() {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid) {
        this.artistMbid = artistMbid;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumCoverart100x100() {
        return albumCoverart100x100;
    }

    public void setAlbumCoverart100x100(String albumCoverart100x100) {
        this.albumCoverart100x100 = albumCoverart100x100;
    }

    public long getRestricted() {
        return restricted;
    }

    public void setRestricted(long restricted) {
        this.restricted = restricted;
    }

    public String getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(String firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
