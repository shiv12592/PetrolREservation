package com.example.kamran.loginsignupmix;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sideBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button button_press_to_continue=(Button)findViewById(R.id.button_press_to_continue);
        button_press_to_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sideBar.this,map.class));
            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.side_bar, menu);
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
            startActivity(new Intent(sideBar.this, Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        int id = item.getItemId();
        switch (id) {
            case R.id.location:
                Intent it = new Intent(sideBar.this, map.class);
                startActivity(it);

                return true;
            case R.id.about:
                Intent intent = new Intent(sideBar.this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.petrol_pump:
                Intent it2 = new Intent(sideBar.this, NearByPetrolPumps.class);
                startActivity(it2);
                return true;
            case R.id.settings:
                Intent it3 = new Intent(sideBar.this, Settings.class);
                startActivity(it3);
                return true;
            case R.id.help:
                Intent it4 = new Intent(sideBar.this, HelpScreen.class);
                startActivity(it4);
                return true;
            case R.id.signout:
                Intent it5 = new Intent(sideBar.this, login.class);
                startActivity(it5);
                return true;
            default:
                return true;


        }
//        if (id == R.id.search) {
//            // Handle the camera action
//
//        } else if (id == R.id.location) {
//
//
//            Intent it = new Intent(sideBar.this, map.class);
//            startActivity(it);
//
//
//        } else if (id == R.id.petrol_pump) {
//
//        } else if (id == R.id.settings) {
//            setContentView(R.layout.settings);
//
//        } else if (id == R.id.help) {
//            setContentView(R.layout.help);
//
//        } else if (id == R.id.about) {
//            Intent it = new Intent(sideBar.this, about.class);
//            startActivity(it);
//            finish();
//
//        } else if (id == R.id.signout) {
//            Intent it = new Intent(sideBar.this, login.class);
//            startActivity(it);
//            finish();
//
//        }




    }
}
