package com.collathon.schoolbus;

import android.graphics.drawable.Drawable;

/**
 * Created by ssh91 on 2016-10-02.
 */
public class ListViewItem {
    private Drawable iconDrawable;
    private String busStopName;
    private String busStopCount;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public String getBusStopCount() {
        return busStopCount;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public void setBusStopCount(String busStopCount) {
        this.busStopCount = busStopCount;
    }
}
