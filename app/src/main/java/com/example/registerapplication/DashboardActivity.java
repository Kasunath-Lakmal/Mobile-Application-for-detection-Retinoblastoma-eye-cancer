package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    //declare the variable
  ImageView imgView , backArrow_imageView, camera_imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imgView = (ImageView)findViewById(R.id.upload_pic_id);
        camera_imageView = (ImageView)findViewById(R.id.camare_imgview_id);
        camera_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new  Intent(DashboardActivity.this , OpenCameraActivity.class);
                startActivity(i);
                finish();
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new  Intent(DashboardActivity.this , CheckYourEyesOneActivity.class);
                startActivity(i);
                finish();

            }
        });

        backArrow_imageView = (ImageView)findViewById(R.id.check_your_id);
        backArrow_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, DashboardOneActivity.class);
                startActivity(i);
                finish();
            }
        });

        // camera
      /*  camera_imageView = (ImageView)findViewById(R.id.imageView14);
        camera_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/




    }
}