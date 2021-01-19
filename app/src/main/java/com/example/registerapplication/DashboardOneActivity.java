package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardOneActivity extends AppCompatActivity {

    private Button btn ;
    ImageView imgViewone , checkYourEye , icure_Clinic_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_one);

     /*   btn = (Button)findViewById(R.id.button_id);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardOneActivity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        });*/

        checkYourEye = (ImageView)findViewById(R.id.check_your_eyes_id);
        checkYourEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardOneActivity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        });

        imgViewone = (ImageView)findViewById(R.id.imageView4);
        imgViewone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardOneActivity.this, ProfileActivity.class);
                startActivity(i);
                finish();
            }
        });

        icure_Clinic_img = (ImageView)findViewById(R.id.imageView8);
        icure_Clinic_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(DashboardOneActivity.this, IcureClinicHome.class);
                startActivity(i);
                finish();

            }
        });




    }
}