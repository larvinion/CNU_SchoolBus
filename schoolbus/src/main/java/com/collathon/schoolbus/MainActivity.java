package com.collathon.schoolbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    Button btnA_bus, btnB_bus, btnC_bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setButton();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        MapActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    // 메뉴의 버튼에 대한 변수
    public void setButton(){
        btnA_bus = (Button) findViewById(R.id.a_bus);
        btnA_bus.setOnClickListener(clickListener);

        btnB_bus = (Button) findViewById(R.id.b_bus);
        btnB_bus.setOnClickListener(clickListener);

        btnC_bus = (Button) findViewById(R.id.c_bus);
        btnC_bus.setOnClickListener(clickListener);
    }

    OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == btnA_bus){
                Intent aRouteIntent = new Intent(getApplicationContext(),
                        ARouteActivity.class);
                aRouteIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(aRouteIntent);
            }
            if(v == btnB_bus){
                Intent bRouteIntent = new Intent(getApplicationContext(),
                        BRouteActivity.class);
                bRouteIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(bRouteIntent);
            }
            if(v == btnC_bus){
                Intent cRouteIntent = new Intent(getApplicationContext(),
                        CRouteActivity.class);
                cRouteIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(cRouteIntent);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
