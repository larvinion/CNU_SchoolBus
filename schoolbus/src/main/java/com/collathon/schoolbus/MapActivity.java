package com.collathon.schoolbus;

import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;

/**
 * Created by Larva on 2016-09-17.
 */
public class MapActivity extends NMapActivity {
    private static final String LOG_TAG = "NMapViewer";

    // set your Client ID which is registered for NMapViewer library.
    private static final String CLIENT_ID = "rN1VcLtqYSdvBmuyl0X1";

    private MapContainerView mMapContainerView;

    private NMapView nMapView;
    private NMapController nMapController;

    private LinearLayout nMapLayout;

    private NMapOverlayManager mOverlayManager;

    private static boolean USE_XML_LAYOUT = false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create map view
        nMapView = new NMapView(this);
        nMapLayout = (LinearLayout)findViewById(R.id.nmap); // Layout

        // set a registered Client Id for Open MapViewer Library
        nMapView.setClientId(CLIENT_ID);

        // set the activity content to the map view
        setContentView(nMapView);

        // initialize map view
        nMapView.setClickable(true);
        nMapView.setEnabled(true);
        nMapView.setFocusable(true);
        nMapView.setFocusableInTouchMode(true);
        nMapView.requestFocus();

        nMapView.executeNaverMap();
    }

    public void onMapInitHandler(NMapView arg0, NMapError errorInfo){
        if(errorInfo == null){
        }else{
            android.util.Log.e("NMapViewer", "onMapInitHandler : error = " + errorInfo.toString());
        }
    }

    /**
     * Container view class to rotate map view.
     */
    private class MapContainerView extends ViewGroup {

        public MapContainerView(Context context) {
            super(context);
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            final int width = getWidth();
            final int height = getHeight();
            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                final View view = getChildAt(i);
                final int childWidth = view.getMeasuredWidth();
                final int childHeight = view.getMeasuredHeight();
                final int childLeft = (width - childWidth) / 2;
                final int childTop = (height - childHeight) / 2;
                view.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
            }

            if (changed) {
                mOverlayManager.onSizeChanged(width, height);
            }
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int w = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
            int h = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
            int sizeSpecWidth = widthMeasureSpec;
            int sizeSpecHeight = heightMeasureSpec;

            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                final View view = getChildAt(i);

                if (view instanceof NMapView) {
                    if (nMapView.isAutoRotateEnabled()) {
                        int diag = (((int)(Math.sqrt(w * w + h * h)) + 1) / 2 * 2);
                        sizeSpecWidth = MeasureSpec.makeMeasureSpec(diag, MeasureSpec.EXACTLY);
                        sizeSpecHeight = sizeSpecWidth;
                    }
                }

                view.measure(sizeSpecWidth, sizeSpecHeight);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}