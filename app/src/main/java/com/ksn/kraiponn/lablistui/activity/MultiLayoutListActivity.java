package com.ksn.kraiponn.lablistui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.adapter.CustomGridViewAdapter;
import com.ksn.kraiponn.lablistui.adapter.CustomListViewAdapter;
import com.ksn.kraiponn.lablistui.dao.DataPacketTemplate;
import com.ksn.kraiponn.lablistui.dao.DataPacketTemplate2;
import com.ksn.kraiponn.lablistui.manager.CustomGridViewItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiLayoutListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GridView gridView;
    private ArrayList<CustomGridViewItem> mArrList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_layout_list);
        initInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initInstance() {
        gridView = findViewById(R.id.gridView);
        toolbar = (Toolbar) findViewById(R.id.toolbar_multi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mArrList = new ArrayList<>();
        DataPacketTemplate2 data = new DataPacketTemplate2();
        mArrList = data.getArrCustomData();
        CustomGridViewAdapter adapter = new CustomGridViewAdapter(
                getBaseContext(), mArrList
        );

        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(
                    R.anim.from_top, R.anim.to_bottom
            );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(
                R.anim.from_top, R.anim.to_bottom
        );
    }
}
