package com.collathon.schoolbus;

import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;

/**
 * Created by ssh91 on 2016-09-21.
 */
public class BRouteActivity extends NMapActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nmap);
    }
}
