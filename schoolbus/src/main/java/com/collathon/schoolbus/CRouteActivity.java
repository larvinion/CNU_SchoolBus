package com.collathon.schoolbus;

import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;

/**
 * Created by ssh91 on 2016-09-21.
 */
public class CRouteActivity extends NMapActivity {

    private String[] c_routeList ={
            "①골프연습장주차장(출발)",
            "②도서관앞",
            "③산학연구관",
            "④GS주유소",
            "⑤유성온천역 4번출구 옆시내버스정류장",
            "⑥유성온천역(7번)",
            "⑦정심화국제문화회관",
            "⑧도서관",
            "⑨골프연습장주차장"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nmap);
    }
}
