package com.ksn.kraiponn.lablistui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.adapter.RecyclerAdapter;
import com.ksn.kraiponn.lablistui.fragment.RecyclerMultiLayoutFragment;
import com.ksn.kraiponn.lablistui.manager.RecyclerItem;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    /*mPlayer = MediaPlayer.create(this, R.raw.beep);
                  try {
        mPlayer.prepare();
    }
    mPlayer.start();*/
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerItem> mArrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container,
                            RecyclerMultiLayoutFragment.newInstance())
                    .commit();
        }
    }

    private void initInstance() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initData() {
        mArrList = new ArrayList<>();
        mArrList.add(new RecyclerItem(
                R.drawable.ic_android,
                "Android Dev",
                "Hello Android World"
        ));
        mArrList.add(new RecyclerItem(
                R.drawable.ic_bluetooth,
                "Bluetooth",
                "IOT interface learning"
        ));
        mArrList.add(new RecyclerItem(
                R.drawable.ic_account,
                "Account",
                "User account for customer"
        ));
        mArrList.add(new RecyclerItem(
                R.drawable.ic_computer,
                "Computer",
                "IT service our company"
        ));

        /*for(int i=0; i<20; i++) {
            items.add(new RecyclerItem(
                    R.drawable.ic_android,
                    "Android Dev",
                    "Hello Android World"
            ));

            items.add(new RecyclerItem(
                    R.drawable.ic_bluetooth,
                    "IOS Dev",
                    "Hello IOS World"
            ));
        }*/
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
