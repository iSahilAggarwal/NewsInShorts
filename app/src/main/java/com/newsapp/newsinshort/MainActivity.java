package com.newsapp.newsinshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    TabItem mhome,mentertainment,mhealth,mscience,msports,mtech;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String api="8b9c8d8f0410466ea091f9c191809db0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhealth=findViewById(R.id.health);
        mhome=findViewById(R.id.home);
        mentertainment=findViewById(R.id.entertainment);
        mscience=findViewById(R.id.science);
        msports=findViewById(R.id.sports);
        mtech=findViewById(R.id.technology);

        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        tablayout=findViewById(R.id.include);

        pagerAdapter= new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

    }
}