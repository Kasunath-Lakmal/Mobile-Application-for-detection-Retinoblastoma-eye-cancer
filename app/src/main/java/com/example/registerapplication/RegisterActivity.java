package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    EditText RFname,REmail,RPhone,RPassword;
    Button Rbtn;
    TextView RTxtView;
    FirebaseAuth fAuth;
    ProgressBar R_prograssbar;
    DatabaseReference databaseArtists;
    //FirebaseDatabase fDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseArtists = FirebaseDatabase.getInstance().getReference("users");
        RFname = (EditText)findViewById(R.id.R_name_id);
        REmail = (EditText)findViewById(R.id.L_email_id);
        RPhone = (EditText)findViewById(R.id.R_phone_id);
        RPassword =(EditText) findViewById(R.id.L_password_id);
        RTxtView = (TextView)findViewById(R.id.L_login_text_id);

        fAuth = FirebaseAuth.getInstance();
        //fDb = FirebaseDatabase.getInstance();

        R_prograssbar =(ProgressBar) findViewById(R.id.L_progressBar_id);
        Rbtn = (Button)findViewById(R.id.register_btn_id);
        //Already register or not
        if(fAuth.getCurrentUser() != null)
        {
           startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            finish();
       }
        Rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = REmail.getText().toString().trim();
                final String password = RPassword.getText().toString().trim();
                final String fullname = RFname.getText().toString().trim();
                final String phonenumber = RPhone.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    REmail.setError("Email is Required!!");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    RPassword.setError("Password is Required!!");
                    return;
                }
                if(password.length() < 6)
                {
                    RPassword.setError("Password must be >= 6 characters");
                    return;
                }
                R_prograssbar.setVisibility(view.VISIBLE);
                //Register the user firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            String id = databaseArtists.push().getKey();
                            //User user = new User("id", "FullName", " EmailAddress","PhoneNumber");
                           // User user = new User(RFname , REmail, RPhone );
                           // User user = new User(id ,"RFname", "REmail"," RPhone");
                            User user = new User(id , fullname,email,phonenumber);
                            databaseArtists.child(id).setValue(user);
                            Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            R_prograssbar.setVisibility(View.GONE);

                            }
                    }
                });
            }
        });

        RTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}