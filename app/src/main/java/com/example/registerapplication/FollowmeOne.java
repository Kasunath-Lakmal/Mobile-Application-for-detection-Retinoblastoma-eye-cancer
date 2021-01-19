package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FollowmeOne extends AppCompatActivity {


    ImageView btn_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followme_one);

        btn_one = (ImageView) findViewById(R.id.imageView12);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FollowmeOne.this, FollowmeTwo.class);
                startActivity(i);
                finish();
            }
        });
    }
}