package com.collathon.schoolbus;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPOIitem;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapResourceProvider;

/**
 * Created by Larva on 2016-09-17.
 */
public class MapActivity extends NMapActivity {
    private static final String LOG_TAG = "NMapViewer";
    private static final boolean DEBUG = false;

    // set your Client ID which is registered for NMapViewer library.
    private static final String CLIENT_ID = "rN1VcLtqYSdvBmuyl0X1";

    private NMapView mMapView;
    private NMapController mMapController;

    private LinearLayout mMapLayout;


    // create resource provider
    public NMapResourceProvider mMapViewerResourceProvider;
    // create overlay manager
    private NMapOverlayManager mOverlayManager;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitNaverMap();
        InitBusStopOverlay();

    }

    private void InitNaverMap() {
        // create map view
        mMapView = new NMapView(this);
        mMapLayout = (LinearLayout)findViewById(R.id.nmap); // Layout

        // set a registered Client Id for Open MapViewer Library
        mMapView.setClientId(CLIENT_ID);

        // set the activity content to the map view
        setContentView(mMapView);

        // initialize map view
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();

        // use map controller to zoom in/out, pan and set map center, zoom level etc.
        mMapController = mMapView.getMapController();
    }

    private void InitBusStopOverlay() {
        // create resource provider
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

        // create overlay manager
        mOverlayManager = new NMapOverlayManager(this, mMapView, mMapViewerResourceProvider);

        int markerId = NMapPOIflagType.PIN;

        // set POI data
        NMapPOIdata poiData = new NMapPOIdata(12, mMapViewerResourceProvider);
        poiData.beginPOIdata(12);
        poiData.addPOIitem(127.3452124, 36.3639612, "정심화국제문화회관", markerId, 0);
        poiData.addPOIitem(127.3457740, 36.3672940, "경상대학앞", markerId, 0);
        poiData.addPOIitem(127.3467570, 36.3695420, "도서관 앞(농대방향)", markerId, 0);
        poiData.addPOIitem(127.3462540, 36.3723520, "학생생활관3거리", markerId, 0);
        poiData.addPOIitem(127.3522070, 36.3667740, "농업생명과학대학앞", markerId, 0);
        poiData.addPOIitem(127.3465320, 36.3696210, "도서관 앞(도서관 삼거리 방향)", markerId, 0);
        poiData.addPOIitem(127.3439250, 36.3704950, "예술대학 앞", markerId, 0);
        poiData.addPOIitem(127.3439260, 36.3742470, "음악 2호관 앞", markerId, 0);
        poiData.addPOIitem(127.3441170, 36.3765390, "공동동물실험센터 입구(회차)", markerId, 0);
        poiData.addPOIitem(127.3428990, 36.3716340, "체육관 입구", markerId, 0);
        poiData.addPOIitem(127.3424790, 36.3670980, "사회과학대학 입구(한누리회관 뒤)", markerId, 0);
        poiData.addPOIitem(127.3452790, 36.3639690, "정심화국제문화회관", markerId, 0);
        poiData.endPOIdata();

        // create POI data overlay
        NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);

        // show all POI data
        poiDataOverlay.showAllPOIdata(0);

        // set event listener to the overlay
        poiDataOverlay.setOnStateChangeListener(onPOIdataStateChangeListener);
    }

    public void onCalloutClick(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
        // [[TEMP]] handle a click event of the callout
        Toast.makeText(MapActivity.this, "onCalloutClick: " + item.getTitle(), Toast.LENGTH_LONG).show();
    }

    public void onFocusChanged(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
        if (item != null) {
            Log.i(LOG_TAG, "onFocusChanged: " + item.toString());
        } else {
            Log.i(LOG_TAG, "onFocusChanged: ");
        }
    }

    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            mMapController.setMapCenter(new NGeoPoint(36.3639612, 127.3452124), 5);
        } else { // fail
            android.util.Log.e(LOG_TAG, "onMapInitHandler : error = " + errorInfo.toString());
        }
    }

    /* POI data State Change Listener*/
    private final NMapPOIdataOverlay.OnStateChangeListener onPOIdataStateChangeListener = new NMapPOIdataOverlay.OnStateChangeListener() {

        @Override
        public void onCalloutClick(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
            if (DEBUG) {
                Log.i(LOG_TAG, "onCalloutClick: title=" + item.getTitle());
            }

            // [[TEMP]] handle a click event of the callout
            Toast.makeText(MapActivity.this, "onCalloutClick: " + item.getTitle(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFocusChanged(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
            if (DEBUG) {
                if (item != null) {
                    Log.i(LOG_TAG, "onFocusChanged: " + item.toString());
                } else {
                    Log.i(LOG_TAG, "onFocusChanged: ");
                }
            }
        }
    };
}