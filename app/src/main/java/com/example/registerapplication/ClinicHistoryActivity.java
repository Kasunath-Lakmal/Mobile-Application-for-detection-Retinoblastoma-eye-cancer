package com.example.registerapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ClinicHistoryActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back_imageView;
    private int notificationId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_history);

        // Set onClick Listener
        findViewById(R.id.setBtn).setOnClickListener(this);
        //findViewById(R.id.cancelBtn).setOnClickListener(this);

        back_imageView = (ImageView)findViewById(R.id.icure_clinic_imgeView);
        back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClinicHistoryActivity.this, IcureClinicHome.class);
                startActivity(i);
                finish();
            }
        });
    }


    @Override
    public void onClick(View view) {

        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);

        // Intent
        Intent intent = new Intent(ClinicHistoryActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("message", editText.getText().toString());

        // PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                ClinicHistoryActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        // AlarmManager
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        switch (view.getId()) {
            case R.id.setBtn:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                // Create time.
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                // Set Alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, pendingIntent);
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                break;

           /* case R.id.cancelBtn:
                alarmManager.cancel(pendingIntent);
                Toast.makeText(this, "Canceled.", Toast.LENGTH_SHORT).show();
                break;*/
        }

    }
}