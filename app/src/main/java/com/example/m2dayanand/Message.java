package com.example.m2dayanand;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Message extends Fragment {

    ListView listView;
    Integer[] img={R.drawable.profile,R.drawable.dp,R.drawable.p,R.drawable.ph,
            R.drawable.pr,R.drawable.prf,R.drawable.profile,R.drawable.dp,R.drawable.p,R.drawable.ph,
            R.drawable.pr,R.drawable.prf};
    String[] name={"Rahul","Deepak","Rajesh","Sachin","Narag","Naveen","Rahul","Deepak","Rajesh","Sachin","Narag","Naveen"};
    String[] detai={"i am not robat","i am not robat","i am not robat","i am not robat",
            "i am not robat","i am not robat","i am not robat","i am not robat","i am not robat","i am not robat","i am not robat",
            "i am not robat",};
    String[] detaisend={"i am not robat","i am not robat","i am not robat","i am not robat","i am not robat","i am not robat",
            "i am not robat","i am not robat","i am not robat","i am not robat","i am not robat",
            "i am not robat"};
    String[] time={"9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM","9:10 PM",};
    String[] task={"2","2","2","2","2","2","2","2","2","2","2","2",};


    public Message() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        ListView listView=view.findViewById(R.id.listview);
        MylistAdpter mylistAdpter=new MylistAdpter(getActivity(),img,name,detai,time,task,detaisend);
        listView.setAdapter(mylistAdpter);
        LinearLayout listitem;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(),"You selected : "+name[position],Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

}
