package com.example.ca3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class callAdapter extends ArrayAdapter<CallValue> {
    List<CallValue> h;
    //activity context
     tab1 context;
    //the layout resource file for the list items
     int resource;
     Context ct;
    //constructor initializing the values
    public callAdapter(@NonNull Context context, List<CallValue> heroList) {
        super(context, R.layout.gridlayout, heroList);
        ct = context;
        h = heroList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(ct);

        View rowView = layoutInflater.inflate(R.layout.gridlayout, null, false);
        ImageView imageView =rowView.findViewById(R.id.gi);
        TextView subtitleText = rowView.findViewById(R.id.tv);
        CallValue hero = h.get(position);
        imageView.setImageDrawable(ct.getResources().getDrawable(hero.getImage()));
        subtitleText.setText(hero.getName());
        return rowView;
    }
}
