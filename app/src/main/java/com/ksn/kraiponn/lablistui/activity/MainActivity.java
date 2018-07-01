package com.ksn.kraiponn.lablistui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navDrawer;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initInstance();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container
                            , MainFragment.newInstance())
                    .commit();
        }
    }

    private void initInstance() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout, toolbar,
                R.string.open_menu,
                R.string.close_menu
        );
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initNavDrawer();
    }

    private void initNavDrawer() {
        navDrawer = findViewById(R.id.nav_view);
        TextView navTextView1 = new TextView(this);
        navTextView1.setGravity(Gravity.CENTER);
        navTextView1.setText("+99");
        navDrawer.getMenu().findItem(R.id.nav_account)
                .setActionView(navTextView1);

        navDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item;
        SpannableStringBuilder builder;
        Drawable drawable;
        ImageSpan imageSpan;

        for (int i=0; i<menu.size(); i++) {
            item = menu.getItem(i);
            builder = new SpannableStringBuilder()
                    .append("   ")
                    .append(item.getTitle());

            if (item.getIcon() != null &&
                    item.getIcon().getConstantState() != null) {
                drawable = item.getIcon().getConstantState().newDrawable();
                drawable.setBounds(
                        0, 0,
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight()
                );

                imageSpan = new ImageSpan(drawable);
                builder.setSpan(imageSpan,
                        0, 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                item.setTitle(builder);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_second_ativity: {
                startActivity(new Intent(
                        MainActivity.this,
                        Main2Activity.class
                ));
                overridePendingTransition(
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                );
                return true;
            }
            case R.id.action_tab_effect_activity: {
                startActivity(new Intent(
                        MainActivity.this,
                        TabEffectActivity.class
                ));
                overridePendingTransition(
                        R.anim.from_bottom,
                        R.anim.to_top
                );
                return true;
            }
            case R.id.action_listview: {
                startActivity(
                        new Intent(
                                MainActivity.this,
                                LabListViewActivity.class
                        )
                );

                overridePendingTransition(
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                );
                return true;
            }
            case R.id.action_custom_list: {
                startActivity(
                        new Intent(
                                MainActivity.this,
                                CustomListActivity.class
                        )
                );

                overridePendingTransition(
                        R.anim.from_bottom, R.anim.to_top
                );
                return true;
            }
            case R.id.action_multiple_layout_listview: {
                startActivity(
                        new Intent(
                                MainActivity.this,
                                MultiLayoutListActivity.class
                        )
                );

                overridePendingTransition(
                        R.anim.from_bottom, R.anim.to_top
                );
                return true;
            }
            case R.id.action_recycler: {
                startActivity(
                        new Intent(
                                MainActivity.this,
                                RecyclerActivity.class
                        )
                );

                overridePendingTransition(
                        R.anim.from_bottom, R.anim.to_top
                );
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
        );
    }
}
