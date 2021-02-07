package com.example.m2dayanand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.tablayout);
        tabLayout=findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setTag("Home"));
        tabLayout.addTab(tabLayout.newTab().setTag("Contact"));
        tabLayout.addTab(tabLayout.newTab().setTag("Chat"));
       /* Mypageadpter mypageadpter=new Mypageadpter(this,
                getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(mypageadpter);*/
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
