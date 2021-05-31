package com.example.ca3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class food extends Fragment {
    CustomAdapter obj;
    ListView lv;
    String maintitle[]={"Burger","Vegetables","Salad","Fruits","Vegetables","Burger","Fruits","Salad"};

    Integer imgid[]={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f5,R.drawable.f2,R.drawable.f1,R.drawable.f5,R.drawable.f3};
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.foodmain, container, false);
        lv=rootView.findViewById(R.id.list);
        obj=new CustomAdapter(getContext(),maintitle,imgid);
        lv.setAdapter(obj);
        return rootView;
    }
}
