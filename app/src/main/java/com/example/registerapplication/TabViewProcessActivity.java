package com.example.registerapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabViewProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_process);

        //get the viewpager and set it's pager adapter so that it c an be display item
        ViewPager vp = findViewById(R.id.viewpager);
        PagerAdapter pA = new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(pA);
        //give the tablayout the viewpager
        TabLayout tL = findViewById(R.id.sliding_tabs);
        tL.setupWithViewPager(vp);

    }
}