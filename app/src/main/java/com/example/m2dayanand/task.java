package com.example.m2dayanand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class task extends AppCompatActivity {
    PageAdapter pageAdapter;

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabMessage;
    TabItem tabContact;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tabLayout = findViewById(R.id.tablayout);
        tabMessage = findViewById(R.id.tabMessage);
        tabContact = findViewById(R.id.tabContact);
        viewPager = findViewById(R.id.viewPager);
        textView=findViewById(R.id.Titeltext);
        toolbar=findViewById(R.id.toolbar);
        ImageView back=findViewById(R.id.back);
        setSupportActionBar(toolbar);
        textView.setText("Message");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(task.this,Login.class);
                startActivity(intent);
            }
        });

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tabTitles[]={"Message","Contact"};
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 1) {


                  /*  toolbar.setBackgroundColor(ContextCompat.getColor(task.this,
                            R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(task.this,
                            R.color.colorAccent));*/
                    textView.setText("Contact");



                } else if (tab.getPosition() == 2) {
                   /* toolbar.setBackgroundColor(ContextCompat.getColor(task.this,
                            android.R.color.darker_gray));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(task.this,
                            android.R.color.darker_gray)); */
                    textView.setText("Message");



                } else {
                  /*  toolbar.setBackgroundColor(ContextCompat.getColor(task.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(task.this,
                            R.color.colorPrimary));*/
                    textView.setText("Meassage");


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
