
package com.example.android.goodplays_app.ModelClasses.LyricsModelClasses; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lyrics {

    @SerializedName("lyrics_id")      //WE WANT THIS!!!!
    @Expose
    private long lyricsId;
    @SerializedName("can_edit")
    @Expose
    private long canEdit;
    @SerializedName("locked")
    @Expose
    private long locked;
    @SerializedName("published_status")
    @Expose
    private long publishedStatus;
    @SerializedName("action_requested")
    @Expose
    private String actionRequested;
    @SerializedName("verified")
    @Expose
    private long verified;
    @SerializedName("restricted")
    @Expose
    private long restricted;
    @SerializedName("instrumental")
    @Expose
    private long instrumental;
    @SerializedName("explicit")
    @Expose
    private long explicit;
    @SerializedName("lyrics_body")
    @Expose
    private String lyricsBody;      //WE WANT THIS!!!! THIS IS THE ACTUAL LYRICS
    @SerializedName("lyrics_language")
    @Expose
    private String lyricsLanguage;
    @SerializedName("lyrics_language_description")
    @Expose
    private String lyricsLanguageDescription;
    @SerializedName("script_tracking_url")
    @Expose
    private String scriptTrackingUrl;
    @SerializedName("pixel_tracking_url")
    @Expose
    private String pixelTrackingUrl;     //WE MIGHT NEED THIS!!!
    @SerializedName("html_tracking_url")
    @Expose
    private String htmlTrackingUrl;
    @SerializedName("lyrics_copyright")
    @Expose
    private String lyricsCopyright;
    @SerializedName("writer_list")
    @Expose
    private List<Object> writerList = null;
    @SerializedName("publisher_list")
    @Expose
    private List<Object> publisherList = null;
    @SerializedName("backlink_url")
    @Expose
    private String backlinkUrl;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    public long getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(long lyricsId) {
        this.lyricsId = lyricsId;
    }

    public long getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(long canEdit) {
        this.canEdit = canEdit;
    }

    public long getLocked() {
        return locked;
    }

    public void setLocked(long locked) {
        this.locked = locked;
    }

    public long getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(long publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    public String getActionRequested() {
        return actionRequested;
    }

    public void setActionRequested(String actionRequested) {
        this.actionRequested = actionRequested;
    }

    public long getVerified() {
        return verified;
    }

    public void setVerified(long verified) {
        this.verified = verified;
    }

    public long getRestricted() {
        return restricted;
    }

    public void setRestricted(long restricted) {
        this.restricted = restricted;
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

    public String getLyricsBody() {
        return lyricsBody;
    }

    public void setLyricsBody(String lyricsBody) {
        this.lyricsBody = lyricsBody;
    }

    public String getLyricsLanguage() {
        return lyricsLanguage;
    }

    public void setLyricsLanguage(String lyricsLanguage) {
        this.lyricsLanguage = lyricsLanguage;
    }

    public String getLyricsLanguageDescription() {
        return lyricsLanguageDescription;
    }

    public void setLyricsLanguageDescription(String lyricsLanguageDescription) {
        this.lyricsLanguageDescription = lyricsLanguageDescription;
    }

    public String getScriptTrackingUrl() {
        return scriptTrackingUrl;
    }

    public void setScriptTrackingUrl(String scriptTrackingUrl) {
        this.scriptTrackingUrl = scriptTrackingUrl;
    }

    public String getPixelTrackingUrl() {
        return pixelTrackingUrl;
    }

    public void setPixelTrackingUrl(String pixelTrackingUrl) {
        this.pixelTrackingUrl = pixelTrackingUrl;
    }

    public String getHtmlTrackingUrl() {
        return htmlTrackingUrl;
    }

    public void setHtmlTrackingUrl(String htmlTrackingUrl) {
        this.htmlTrackingUrl = htmlTrackingUrl;
    }

    public String getLyricsCopyright() {
        return lyricsCopyright;
    }

    public void setLyricsCopyright(String lyricsCopyright) {
        this.lyricsCopyright = lyricsCopyright;
    }

    public List<Object> getWriterList() {
        return writerList;
    }

    public void setWriterList(List<Object> writerList) {
        this.writerList = writerList;
    }

    public List<Object> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Object> publisherList) {
        this.publisherList = publisherList;
    }

    public String getBacklinkUrl() {
        return backlinkUrl;
    }

    public void setBacklinkUrl(String backlinkUrl) {
        this.backlinkUrl = backlinkUrl;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
