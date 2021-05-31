package com.example.ca3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class clothes extends Fragment {
    ArrayList<CallValue> al;
    GridView gv;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.clothes, container, false);
        al=new ArrayList<>();
        gv=rootView.findViewById(R.id.grid);
        for(int i=0;i<7;i++){
            al.add(new CallValue(R.drawable.c1,"Jacket "+(i+1),"description1"));
            al.add(new CallValue(R.drawable.c2,"Kid wear "+(i+1) ,"description2"));
            al.add(new CallValue(R.drawable.c3,"Denim Jeans "+(i+1),"description3"));
            al.add(new CallValue(R.drawable.c5,"Baby wear "+(i+1),"description4"));

        }
        callAdapter ad=new callAdapter(getContext(),al);
        gv.setAdapter(ad);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"you have clicked on "+al.get(i).getName(), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}