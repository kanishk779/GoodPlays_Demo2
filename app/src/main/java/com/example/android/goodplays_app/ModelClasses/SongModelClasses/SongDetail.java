
package com.example.android.goodplays_app.ModelClasses.SongModelClasses; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongDetail {

    @SerializedName("message")
    @Expose
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
