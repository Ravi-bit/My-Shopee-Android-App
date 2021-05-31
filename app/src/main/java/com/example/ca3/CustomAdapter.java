package com.example.ca3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String>
{
    Context ct;
    String maintitle[];
    Integer imgid[];
    Button b;
    TextView tv1,tv2;
    ImageView img;
    public CustomAdapter(@NonNull Context context, String maintitle[], Integer imgid[]) {
        super(context, R.layout.food,maintitle);
        ct=context;
        this.maintitle=maintitle;
        this.imgid=imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ct);
        View v=inflater.inflate(R.layout.food,null,false);
        tv1=v.findViewById(R.id.title);

        img=v.findViewById(R.id.icon);
        tv1.setText(maintitle[position]);

        img.setImageResource(imgid[position]);



        return v;
    }
}
