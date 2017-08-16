package com.simpleapps.vigneshr.mydoctor;

/**
 * Created by vigneshr on 8/15/2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class ScanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
       // fab.setVisibility(View.INVISIBLE);


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Obstetrics");
        listDataHeader.add("Gynaecology");
        listDataHeader.add("General");
        listDataHeader.add("Color Doppler");

        // Adding child data
        List<String> Obstetrics = new ArrayList<String>();
        Obstetrics.add("Viablity / Dating");
        Obstetrics.add("NT Scan");
        Obstetrics.add("First Trimester Screening+NT");
        Obstetrics.add("Triple Screening");
        Obstetrics.add("Anomaly Scan");
        Obstetrics.add("Obstetrics 3D,4D");
        Obstetrics.add("Cervical Length");
        Obstetrics.add("Growth Scan");
        Obstetrics.add("Obstetric Doppler");
        Obstetrics.add("Liquor level");


        List<String> Gynaecology = new ArrayList<String>();
        Gynaecology.add("Follicular Study");
        Gynaecology.add("Transvaginal Pelvic Scan");
        Gynaecology.add("Transabdominal Pelvic Scan");
        Gynaecology.add("3D Pelvic Scan");

        List<String> General = new ArrayList<String>();
        General.add("Whole Abdomen");
        General.add("Upper Abdomen");
        General.add("KUB");
        General.add("Thyroid");
        General.add("Neck");
        General.add("Breast");
        General.add("Scrotum");
        General.add("Musculoskeletal");
        General.add("Superficial Swelling");


        List<String> Color  = new ArrayList<String>();
        Color.add("Carotid and Vertebral");
        Color.add("Portal Venous System");
        Color.add("IVC and hepatic Veins");
        Color.add("Aorta and Renal Arteries");
        Color.add("Scrotal Doppler Study");
        Color.add("Lliac Vessels – Arteries / Venis");
        Color.add("Peripheral Vascular Study");

        listDataChild.put(listDataHeader.get(0), Obstetrics); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Gynaecology);
        listDataChild.put(listDataHeader.get(2), General);
        listDataChild.put(listDataHeader.get(3), Color);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_home){
            startActivity(new Intent(ScanActivity.this,MainActivity.class));
        }
        return true;
    }
}
