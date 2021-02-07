package com.example.m2dayanand;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MylistAdpter extends ArrayAdapter {

    Activity context;
     Integer[] img;
    String[] name;
    String[] detail;
    String[] time;
    String[] task;
    String[] detail1;
    public MylistAdpter(@NonNull Activity context,Integer[] img,String[] name,String[]detail,String[] time,String[] task,String[] detail1) {
        super(context,R.layout.customlistview,img);
        this.context=context;
        this.img=img;
       this.name=name;
        this.detail=detail;
        this.time=time;
        this.task=task;
        this.detail1=detail1;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.customlistview, null,true);
        ImageView profile=rowView.findViewById(R.id.ivprofileimg);
        TextView name1 =rowView.findViewById(R.id.tvname);
        TextView detail2 =rowView.findViewById(R.id.tvdetail);
        TextView time1 =rowView.findViewById(R.id.tvtime);
        TextView task1 =rowView.findViewById(R.id.tvtask);
        TextView details=rowView.findViewById(R.id.tvdetail2);

        profile.setImageResource(img[position]);
       name1.setText(name[position]);
        detail2.setText(detail[position]);
        time1.setText(time[position]);
        task1.setText(task[position]);
        details.setText(detail1[position]);
return rowView;
    }
}
