package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.CENTER;

public class rate extends AppCompatActivity {
    Button b1,b2;
    RatingBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        bar=(RatingBar)findViewById(R.id.rating_bar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.setRating(0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float rat=bar.getRating();
                if(rat>0 && rat<=1.0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.one, (ViewGroup) findViewById(R.id.oneR));
                    Toast t = new Toast(getApplicationContext());
                    TextView tv = layout.findViewById(R.id.tt1);
                    TextView tv1 = layout.findViewById(R.id.tt2);
                    tv.setText("You gave " + rat+" rating");
                    tv1.setText("Sorry for the bad experience");
                    t.setGravity(CENTER, 0, 0);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }else if(rat>1.0 && rat<=2.0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.two, (ViewGroup) findViewById(R.id.twoR));
                    Toast t = new Toast(getApplicationContext());
                    TextView tv = layout.findViewById(R.id.tt1);
                    TextView tv1 = layout.findViewById(R.id.tt2);
                    tv.setText("You gave " + rat+" rating");
                    tv1.setText("Sorry for the disappointment");
                    t.setGravity(CENTER, 0, 0);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }else if(rat>2.0 && rat<=3.0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.three, (ViewGroup) findViewById(R.id.threeR));
                    Toast t = new Toast(getApplicationContext());
                    TextView tv = layout.findViewById(R.id.tt1);
                    TextView tv1 = layout.findViewById(R.id.tt2);
                    tv.setText("You gave " + rat+" rating");
                    tv1.setText("Good enough!");
                    t.setGravity(CENTER, 0, 0);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }else if(rat>3.0 && rat<=4.0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.four, (ViewGroup) findViewById(R.id.fourR));
                    Toast t = new Toast(getApplicationContext());
                    TextView tv = layout.findViewById(R.id.tt1);
                    TextView tv1 = layout.findViewById(R.id.tt2);
                    tv.setText("You gave " + rat+" rating");
                    tv1.setText("Great! Thank you!");
                    t.setGravity(CENTER, 0, 0);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }else if(rat>4.0 && rat<=5.0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.five, (ViewGroup) findViewById(R.id.fiveR));
                    Toast t = new Toast(getApplicationContext());
                    TextView tv = layout.findViewById(R.id.tt1);
                    TextView tv1 = layout.findViewById(R.id.tt2);
                    tv.setText("You gave " + rat+" rating");
                    tv1.setText("Awesome! You are the best!");
                    t.setGravity(CENTER, 0, 0);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }else{
                    Toast.makeText(getApplicationContext(),"Please select the stars!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}