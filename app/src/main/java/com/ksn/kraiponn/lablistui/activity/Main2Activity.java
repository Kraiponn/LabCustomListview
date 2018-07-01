package com.ksn.kraiponn.lablistui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.ksn.kraiponn.lablistui.R;

public class Main2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingNavigationView floatNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initInstance();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        if (savedInstanceState == null) {
            //
        }
    }

    private void initInstance() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_2nd_activity);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        setSupportActionBar(toolbar);

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);*/

        floatNavView = findViewById(R.id.floating_navigation_view);
        floatNavView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatNavView.open();
                Toast.makeText(Main2Activity.this,
                        "Floating Navigation View Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
        floatNavView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        floatNavView.close();
                        return false;
                    }
                }
        );
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
            );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (floatNavView.isOpened()) {
            floatNavView.close();
        } else {
            super.onBackPressed();
        }

        finish();
        overridePendingTransition(
                R.anim.slide_in_left,
                R.anim.slide_out_right
        );
    }
}
