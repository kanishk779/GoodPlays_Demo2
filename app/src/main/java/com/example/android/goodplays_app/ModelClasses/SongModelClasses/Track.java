
package com.example.android.goodplays_app.ModelClasses.SongModelClasses; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

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
    @SerializedName("track_length")
    @Expose
    private long trackLength;
    @SerializedName("commontrack_id")
    @Expose
    private long commontrackId;
    @SerializedName("instrumental")
    @Expose
    private long instrumental;
    @SerializedName("explicit")
    @Expose
    private long explicit;
    @SerializedName("has_lyrics")       //WE WANT THIS!!!!
    @Expose
    private long hasLyrics;
    @SerializedName("has_lyrics_crowd")
    @Expose
    private long hasLyricsCrowd;
    @SerializedName("has_subtitles")
    @Expose
    private long hasSubtitles;
    @SerializedName("has_richsync")
    @Expose
    private long hasRichsync;
    @SerializedName("num_favourite")
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
    @SerializedName("album_coverart_350x350")
    @Expose
    private String albumCoverart350x350;
    @SerializedName("album_coverart_500x500")
    @Expose
    private String albumCoverart500x500;
    @SerializedName("album_coverart_800x800")
    @Expose
    private String albumCoverart800x800;
    @SerializedName("track_share_url")
    @Expose
    private String trackShareUrl;
    @SerializedName("track_edit_url")
    @Expose
    private String trackEditUrl;
    @SerializedName("commontrack_vanity_id")
    @Expose
    private String commontrackVanityId;
    @SerializedName("restricted")
    @Expose
    private long restricted;
    @SerializedName("first_release_date")
    @Expose
    private String firstReleaseDate;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;
    @SerializedName("primary_genres")         //WE WANT THIS!!!!
    @Expose
    private PrimaryGenres primaryGenres;
    @SerializedName("secondary_genres")
    @Expose
    private SecondaryGenres secondaryGenres;

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

    public long getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(long trackLength) {
        this.trackLength = trackLength;
    }

    public long getCommontrackId() {
        return commontrackId;
    }

    public void setCommontrackId(long commontrackId) {
        this.commontrackId = commontrackId;
    }

    public long getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(long instrumental) {
        this.instrumental = instrumental;
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

    public long getHasLyricsCrowd() {
        return hasLyricsCrowd;
    }

    public void setHasLyricsCrowd(long hasLyricsCrowd) {
        this.hasLyricsCrowd = hasLyricsCrowd;
    }

    public long getHasSubtitles() {
        return hasSubtitles;
    }

    public void setHasSubtitles(long hasSubtitles) {
        this.hasSubtitles = hasSubtitles;
    }

    public long getHasRichsync() {
        return hasRichsync;
    }

    public void setHasRichsync(long hasRichsync) {
        this.hasRichsync = hasRichsync;
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

    public String getAlbumCoverart350x350() {
        return albumCoverart350x350;
    }

    public void setAlbumCoverart350x350(String albumCoverart350x350) {
        this.albumCoverart350x350 = albumCoverart350x350;
    }

    public String getAlbumCoverart500x500() {
        return albumCoverart500x500;
    }

    public void setAlbumCoverart500x500(String albumCoverart500x500) {
        this.albumCoverart500x500 = albumCoverart500x500;
    }

    public String getAlbumCoverart800x800() {
        return albumCoverart800x800;
    }

    public void setAlbumCoverart800x800(String albumCoverart800x800) {
        this.albumCoverart800x800 = albumCoverart800x800;
    }

    public String getTrackShareUrl() {
        return trackShareUrl;
    }

    public void setTrackShareUrl(String trackShareUrl) {
        this.trackShareUrl = trackShareUrl;
    }

    public String getTrackEditUrl() {
        return trackEditUrl;
    }

    public void setTrackEditUrl(String trackEditUrl) {
        this.trackEditUrl = trackEditUrl;
    }

    public String getCommontrackVanityId() {
        return commontrackVanityId;
    }

    public void setCommontrackVanityId(String commontrackVanityId) {
        this.commontrackVanityId = commontrackVanityId;
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

    public PrimaryGenres getPrimaryGenres() {
        return primaryGenres;
    }

    public void setPrimaryGenres(PrimaryGenres primaryGenres) {
        this.primaryGenres = primaryGenres;
    }

    public SecondaryGenres getSecondaryGenres() {
        return secondaryGenres;
    }

    public void setSecondaryGenres(SecondaryGenres secondaryGenres) {
        this.secondaryGenres = secondaryGenres;
    }

}
