package com.example.consultants.week2_weekend;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.consultants.week2_weekend.View.CustomerRecyclerViewActivity;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;

    private int MainContentVliew = R.layout.activity_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //set the navigation view items
        //drawer-layout navigation calling drawer_view
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        //will send the intent from the Navigation selected
                        switch (menuItem.getItemId()) {
                            case android.R.id.home: //user clicks home id -> calls start
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                //inside the overflow_view
                            case R.id.nav_Calculator:
                                Intent calcIntent = new Intent(getApplicationContext(), Calculator.class);
                                startActivity(calcIntent);
                            case R.id.nav_AddCustomer:
                                Intent custIntent = new Intent(getApplicationContext(), CustomerRecyclerViewActivity.class);
                                startActivity(custIntent);
                        }
                        return true;
                    }
                });
    }



}
