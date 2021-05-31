package com.example.ca3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import androidx.drawerlayout.widget.DrawerLayout;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class review extends AppCompatActivity {

    CustomAdapterRemove adapter;
    ListView lv;
    Button addBTN;


    EditText addEditText1;
   private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        addBTN = findViewById(R.id.addBTN);
        addEditText1 = findViewById(R.id.Field1);
        final ArrayList<ItemClass> al = new ArrayList<>();
        lv = findViewById(R.id.listCustom);
        adapter = new CustomAdapterRemove(this,al);
        lv.setAdapter(adapter);
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1 = addEditText1.getText().toString();
                String rev="Review : "+title1;
                SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
                String str = mPrefs.getString("User", "");
                String user="User: "+str;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date1=dtf.format(now);
                String date="posted at :"+date1;
                adapter.addNewItem(user,rev,date);
            }
        });


    }

}
