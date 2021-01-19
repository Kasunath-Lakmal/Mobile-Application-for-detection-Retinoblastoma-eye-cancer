package com.example.registerapplication;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    EditText nameEdit, ageEdit;
    CalendarView dateOfBirth;
    Member member;
    FirebaseDatabase database;
    DatabaseReference reference;
    RadioButton maleradiobutton, femaleradiobutton, yesradiobutton, noradiobutton;
    Button submitButton;
    FirebaseAuth fAuth;
    int i = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEdit = (EditText) findViewById(R.id.child_name_id);
        ageEdit = (EditText) findViewById(R.id.child_age_id);
        dateOfBirth = (CalendarView) findViewById(R.id.calender_id);
        maleradiobutton = (RadioButton) findViewById(R.id.rb_male);
        femaleradiobutton = (RadioButton) findViewById(R.id.rb_fmale);
        yesradiobutton = (RadioButton) findViewById(R.id.rb_yes);
        noradiobutton = (RadioButton) findViewById(R.id.rb_no);
        submitButton = (Button) findViewById(R.id.reg_submit_id);
        member = new Member();

        reference = FirebaseDatabase.getInstance().getReference("register");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot ) {
                if(snapshot.exists())
                {
                    i = (int)snapshot.getChildrenCount();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name = nameEdit.getText().toString().trim();
                final String Age = ageEdit.getText().toString().trim();
                final String G1 = maleradiobutton.getText().toString().trim();
                final String G2 = femaleradiobutton.getText().toString().trim();
                final String R1 = yesradiobutton.getText().toString().trim();
                final String R2 = noradiobutton.getText().toString().trim();
                member.setName(nameEdit.getText().toString());
                member.setAge(ageEdit.getText().toString());

                reference.child(String.valueOf(i + 1)).setValue(member);

               // if (TextUtils.isEmpty(Name)) {
               //     nameEdit.setError("Name is Required!!");
                //    return;
               // }
                if(TextUtils.isDigitsOnly(Name))
                {
                    nameEdit.setError("Name is String only");
                }
               // if (TextUtils.isEmpty(Age)) {
               //     ageEdit.setError("Age is Required!!");
               //     return;
              //  }

                if(TextUtils.isEmpty(Age))
                {
                    ageEdit.setError("Age is Number");
                    return;
                }
               // if (TextUtils.)


                if (maleradiobutton.isChecked()) {
                    member.setGender(G1);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else {
                    member.setGender(G2);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                }
                if (yesradiobutton.isChecked()) {
                    member.setRetina(R1);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else {
                    member.setRetina(R2);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                }

                Toast.makeText(ProfileActivity.this, "Profile Created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),DashboardOneActivity.class));

            }
        });
    }
}







