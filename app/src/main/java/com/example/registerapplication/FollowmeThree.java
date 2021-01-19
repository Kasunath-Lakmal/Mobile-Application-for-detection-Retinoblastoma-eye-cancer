package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class FollowmeThree extends AppCompatActivity {

    ImageView btn_one;
    ViewPager mViewPager;
    int[] images = {R.drawable.aa, R.drawable.ab, R.drawable.ac, R.drawable.af,R.drawable.ag};
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followme_three);

        btn_one = (ImageView)findViewById(R.id.imageView12) ;
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FollowmeThree.this, FollowmeOne .class);
                startActivity(i);
                finish();
            }
        });

        mViewPager = (ViewPager)findViewById(R.id.view_pager_id);


        mViewPagerAdapter = new ViewPagerAdapter(FollowmeThree.this, images);


        mViewPager.setAdapter(mViewPagerAdapter);

    }
}