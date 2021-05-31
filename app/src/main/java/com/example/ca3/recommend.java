package com.example.ca3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class recommend extends Fragment {
    CustomAdapter obj;
    ListView lv;
    String maintitle[]={"Chips","Smart phone","Jeans","Fruits","Headset","Baby wear","Burger","Desktop"};

    Integer imgid[]={R.drawable.f4,R.drawable.e1,R.drawable.c4,R.drawable.f5,R.drawable.e2,R.drawable.c5,R.drawable.f1,R.drawable.e5};
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recommend, container, false);
        lv=rootView.findViewById(R.id.list);
        obj=new CustomAdapter(getContext(),maintitle,imgid);
        lv.setAdapter(obj);
        return rootView;
    }
}
