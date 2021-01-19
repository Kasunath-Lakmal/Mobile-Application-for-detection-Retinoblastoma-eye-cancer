package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckStatusActivity extends AppCompatActivity {
    ImageView img_view1;
    Button morebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);


        img_view1 =(ImageView)findViewById(R.id.checkingImgView_id);
        morebtn = (Button)findViewById(R.id.more_btn_id);
        img_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CheckStatusActivity.this, CheckYourEyesOneActivity.class);
                startActivity(i);
                finish();
            }
        });
        morebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CheckStatusActivity.this, TabViewProcessActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}