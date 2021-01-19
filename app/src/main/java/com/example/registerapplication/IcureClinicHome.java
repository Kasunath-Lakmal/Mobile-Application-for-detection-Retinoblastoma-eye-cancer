package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IcureClinicHome extends AppCompatActivity {

    Button btn_clinic_details , btn_clinic_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icure_clinic_home);

        btn_clinic_details = (Button)findViewById(R.id.Clinic_details_id);
        btn_clinic_history = (Button)findViewById(R.id.Clinic_history_id);

        btn_clinic_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IcureClinicHome.this, AddClinicDetailsActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_clinic_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IcureClinicHome.this, ClinicHistoryActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}