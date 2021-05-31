package com.example.ca3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
   TextView tx,tx1;
   Toolbar t2;
   String str,str1,str2;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2=findViewById(R.id.toolbar1);
        setSupportActionBar(t2);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tx=(TextView)headerView.findViewById(R.id.navText);
        tx1=(TextView)headerView.findViewById(R.id.navEmail);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
         str = mPrefs.getString("User", "");
        str1 = mPrefs.getString("Name", "");
        str2=mPrefs.getString("Password","");
        if(str!=null && str1!=null){
            tx.setText("Hi! "+str);
            tx1.setText("Eamil: "+str1);
        }else{
            tx.setText("Hey! Sign In");
            tx1.setText("Enter Email!");
        }
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawer,t2, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new profile(str,str1,str2)).commit();
                break;
            case R.id.electronics:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new tab1()).commit();
                break;
            case R.id.cloth:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new clothes()).commit();
                break;
            case R.id.food:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new food()).commit();
                break;
            case R.id.popular:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new popular()).commit();
                break;
            case R.id.recommend:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new recommend()).commit();
                break;
            case R.id.logout:
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.review:
                Intent intent1 = new Intent(this, review.class);
                startActivity(intent1);
                break;
            case  R.id.rateus:
                Intent intent2 = new Intent(this, rate.class);
                startActivity(intent2);
                break;
            case R.id.wish:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout,new wishlist()).commit();
                break;
                
            case R.id.exit:
                MainActivity.this.finish();
                System.exit(0);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}