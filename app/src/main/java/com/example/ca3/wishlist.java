package com.example.ca3;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class wishlist extends Fragment {
    EditText et;
    TextView tv;
    Button save,read;
    String filename="mywish.txt";
    String filepath="mystorage";
    File f;
    String data="";
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wishlist, container, false);
        et=rootView.findViewById(R.id.myInputText);
        tv=rootView.findViewById(R.id.response);
        save=rootView.findViewById(R.id.saveExternalStorage);
        read=rootView.findViewById(R.id.getExternalStorage);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    FileOutputStream fos=new FileOutputStream(f);
                    fos.write(et.getText().toString().getBytes());
                    Toast.makeText(getActivity(), "Details Are save "+ f.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                    fos.close();
                } catch (Exception e)
                {
                    e.printStackTrace();

                }
                et.setText("");
                tv.setText("file is saved in the absolute path"+f.getAbsolutePath());
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    FileInputStream fis=new FileInputStream(f);
                    DataInputStream in=new DataInputStream(fis);
                    BufferedReader br=new BufferedReader(new InputStreamReader(in));
                    String mydata="";
                    while((mydata=br.readLine())!=null)
                    {
                        data+=mydata;
                    }
                    in.close();

                } catch (Exception e)
                {
                    e.printStackTrace();

                }
                et.setText(data);
                tv.setText("file is retrived from the absolute path"+f.getAbsolutePath());
            }
        });
        if(!checkExternalStorageAvail() || checkExternalStorageAccess())
        {
            save.setEnabled(false);
        }
        else
        {
            f=new File(getActivity().getExternalFilesDir(filepath),filename);
        }
        return rootView;
    }



    public static boolean checkExternalStorageAvail()
    {
        String storagestate= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(storagestate))
        {
            return true;
        }
        return false;
    }
    public static boolean checkExternalStorageAccess()
    {
        String storagestate= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(storagestate))
        {
            return true;
        }
        return false;
    }


}
