package com.collathon.schoolbus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

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
            "⑦도서관 앞(도서관 삼거리 방향)",
            "⑧예술대학 앞",
            "⑨음악 2호관 앞",
            "⑩공동동물실험센터 입구(회차)",
            "⑪체육관 입구",
            "⑫서문(공동실험실습관앞)",
            "⑬사회과학대학 입구(한누리회관 뒤)",
            "⑭산학연교육연 구관앞",
            "⑮정심화국제문화회관"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_route);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.a_buslist);
        listview.setAdapter(adapter);

        for(int i = 0; i < Arrays.asList(a_routeList).size(); i++){
            // if 버스기사 데이터 베이스 잇으면 이미지 삽입
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_map_start), Arrays.asList(a_routeList).get(i), "1");
            // else 버스기사 데이터 없으면 이미지 X 인 데이터 삽입
        }

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
