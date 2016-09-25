package com.collathon.schoolbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<Map<String, String>> groupData = new ArrayList<Map<String, String>>() {{
        for(int i=0; i<a_routeList.length; i++) {
            addList(a_routeList.get(i));
        }
    }

        private void addList(final String Item, final String subItem) {
            add(new HashMap<String, String>() {{
                put(Item, subItem);
            }});
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_route);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_2, a_routeList);

        ExpaListView list = (ListView)findViewById(R.id.a_buslist);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
