package com.example.ca3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class profile extends Fragment {
    String user,em,psw;
    TextView t1,t2,t3;
    public profile(String user,String em,String psw){
        this.user=user;
        this.em=em;
        this.psw=psw;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile, container, false);
        t1=(TextView)rootView.findViewById(R.id.pu);
        t2=(TextView)rootView.findViewById(R.id.pe);
        t3=(TextView)rootView.findViewById(R.id.pp);
        t1.setText("Username: "+user);
        t2.setText("Email: "+em);
        t3.setText("Password: "+psw);
        return rootView;
    }


}
