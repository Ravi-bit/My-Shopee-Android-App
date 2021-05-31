package com.example.ca3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.ca3.R.drawable.liked;

public class CustomAdapterRemove extends ArrayAdapter<ItemClass>{
   int pos=0;
    ArrayList<ItemClass> al;

    Context ct;
    ImageButton btn1,btn2;
    TextView tvTitle, tvSubTitle,tdate;
    ImageView img;

    public CustomAdapterRemove(@NonNull Context context, ArrayList<ItemClass> al) {
        super(context, R.layout.custom_list_content, al);
        ct = context;
        this.al = al;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View v = inflater.inflate(R.layout.custom_list_content, null, false);
        btn1 = (ImageButton)v.findViewById(R.id.buttonDelete);
        btn2=(ImageButton)v.findViewById(R.id.likeBtn);
        tvTitle = v.findViewById(R.id.title);
        tvSubTitle = v.findViewById(R.id.subtitle);
        tdate=v.findViewById(R.id.date);
        img = v.findViewById(R.id.icon);
        tvTitle.setText(al.get(position).mainTitle);
        tvSubTitle.setText(al.get(position).subTitle);
        tdate.setText(al.get(position).date);
        img.setImageResource(al.get(position).img);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAlert(position);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundResource(liked);

            }
        });

        return v;
    }


    public void addNewItem(String titleText,String subTitle,String date) {
        ItemClass obj = new ItemClass(pos, R.drawable.man, titleText,subTitle,date);
        al.add(obj);
        pos++;
        notifyDataSetChanged();
    }

    public void callAlert(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ct);
        builder.setTitle("Are you sure you want to delete");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                al.remove(position);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog ad = builder.create();
        ad.show();

    }
}

class ItemClass{
    int img;
    int position;
    String mainTitle, subTitle,date;
    ItemClass(int pos, int img, String main, String sub,String date) {
        this.img = img;
        this.mainTitle = main;
        this.subTitle = sub;
        this.position = pos;
        this.date=date;

    }


}

