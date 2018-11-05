package com.example.consultants.week2_weekend;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.consultants.week2_weekend.View.CustomerRecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind the view id
        //also binds the toolbar and actionbar to view
        bindViews();

        //set the navigation view items
        //drawerlayout navigation calling drawer_view
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
                                return true;
                            //inside the overflow_view
                            case R.id.nav_Calculator:
                                Intent calcIntent = new Intent(getApplicationContext(), Calculator.class);
                                startActivity(calcIntent);
                                return true;
                            case R.id.nav_AddCustomer:
                                Intent custIntent = new Intent(getApplicationContext(), CustomerRecyclerViewActivity.class);
                                startActivity(custIntent);
                                return true;
                        }


                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                        return true;
                    }
                });

        //set the drawer response when nav opens
        //listen to the open and close events for state changes
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );


    }

    //binds all views -> toolbar, navigation bar, action bar, drawerlayout
    public void bindViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        //set the toolbar functionality to the toolbar
        setSupportActionBar(toolbar);   //passes toolbar object from layout

        //set the actionbar icon picture to 'ic_menu'
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);          //enables home button call
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu); //set pic icon
        navigationView = findViewById(R.id.nav_view);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.drawer_view, menu);

        //TODO need to somehow bind the view actions icon to menu bar
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        toolbar.hasOnClickListeners();
        MenuItem backItem = menu.findItem(R.id.action_back);
        backItem.getActionView();

        // Define the listener
//        MenuItem.OnActionExpandListener expandListener = new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                // Do something when action item collapses
//                return true;  // Return true to collapse action view
//            }
//
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                // Do something when expanded
//                return true;  // Return true to expand action view
//            }
//        };
//
//        // Get the MenuItem for the action item
//        MenuItem actionMenuItem = menu.findItem(R.id.action_search);
//
//        // Assign the listener to that action item
//        MenuItemCompat.setOnActionExpandListener(actionMenuItem, (MenuItemCompat.OnActionExpandListener) expandListener);
//
//        // Any other things you have to do when creating the options menu...

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home: //user clicks home id -> calls start
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            //inside the overflow_view
            case R.id.changeColors:

                return true;
            case R.id.btn_AddCustomer:
                mDrawerLayout.closeDrawers();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
