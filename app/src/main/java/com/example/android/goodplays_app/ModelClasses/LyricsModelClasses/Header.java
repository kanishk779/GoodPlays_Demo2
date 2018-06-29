
package com.example.android.goodplays_app.ModelClasses.LyricsModelClasses; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Header implements Serializable {

    @SerializedName("status_code")
    @Expose
    private long statusCode;
    @SerializedName("execute_time")
    @Expose
    private double executeTime;

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public double getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(double executeTime) {
        this.executeTime = executeTime;
    }

}
