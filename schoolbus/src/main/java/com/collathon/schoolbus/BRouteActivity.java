package com.collathon.schoolbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ssh91 on 2016-09-21.
 */
public class BRouteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] b_routeList ={
            "①정심화국제문화회관",
            "②사회과학대학입구(한누리회관뒤)",
            "③서문(공동실험실습관앞)",
            "④음악2호관앞",
            "⑤공동동물실험센터입구(회차)",
            "⑥체육관입구",
            "⑦예술대학앞",
            "⑧도서관앞(대학본부옆농대방향)",
            "⑨동문주차장",
            "⑩농업생명과학대학앞",
            "⑪학생생활관3거리",
            "⑫도서관앞(도서관삼거리 방향)",
            "⑬공과대학앞",
            "⑭산학연교육연구관앞",
            "⑮정심화국제문화회관"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_route);

        ArrayList<HashMap<String, String>> busStops = new ArrayList<HashMap<String, String>> ();
        HashMap<String, String> busStop;

        for(int i = 0; i< Arrays.asList(b_routeList).size(); i++ ) {
            busStop = new HashMap<String, String>();

            busStop.put("item1", Arrays.asList(b_routeList).get(i));

            /* 이 부분에 조건 달아서 해당 버스가 이 정거장일 경우 버스 번호 표시*/
            busStop.put("item2", "Item " + i);

            busStops.add(busStop);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, busStops,
                android.R.layout.simple_list_item_2, new String[]{"item1", "item2"},
                new int[]{android.R.id.text1, android.R.id.text2});

        ListView listView = (ListView) findViewById(R.id.a_buslist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_navermap:
                Toast.makeText(this, "navermap", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
