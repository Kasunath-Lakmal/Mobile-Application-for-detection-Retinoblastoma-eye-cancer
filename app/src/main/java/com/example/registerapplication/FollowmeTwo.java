package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FollowmeTwo extends AppCompatActivity {

    ImageView btnOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followme_two);
        btnOne = (ImageView)findViewById(R.id.imageView12);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FollowmeTwo.this, Followme_four.class);
                startActivity(i);
                finish();
            }
        });
    }
}