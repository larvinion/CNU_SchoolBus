package com.collathon.schoolbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ssh91 on 2016-09-21.
 */
public class ARouteActivity extends Activity implements AdapterView.OnItemClickListener {

    private String[] a_routeList ={
        "①정심화국제문화회관",
            "②경상대학앞",
            "③도서관 앞(농대방향)",
        "④학생생활관3거리",
        "⑤동문주차장",
        "⑥농업생명과학대학앞",
        "⑦도서관 앞(도서관 삼거리)",
        "⑧예술대학 앞",
        "⑨음악 2호관 앞",
        "⑩공동동물실험센터 입구(회차)",
        "⑪체육관 입구",
        "⑫서문(공동실험실습관앞)",
        "⑬사회과학대학 입구(한누리 회관 뒤)",
        "⑭산학연교육연 구관앞",
        "⑮정심화국제문화회관"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_route);

        ArrayList<HashMap<String, String>> busDatas = new ArrayList<HashMap<String, String>> ();
        HashMap<String, String> busData;

        for(int i = 0; i<Arrays.asList(a_routeList).size(); i++ ) {
            busData = new HashMap<String, String>();

            busData.put("item1", Arrays.asList(a_routeList).get(i));
            busData.put("item2", " ");

            busDatas.add(busData);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, busDatas,
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
