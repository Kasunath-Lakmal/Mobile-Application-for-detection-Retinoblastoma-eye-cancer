package com.example.registerapplication;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText LEmail, LPassword;
    Button LoginButton;
    TextView LoginTextViewbtn,ForgotPwdbtn;
    ProgressBar Lprograssbar;
    FirebaseAuth LfAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        LEmail = (EditText)findViewById(R.id.L_email_id);
        LPassword = (EditText)findViewById(R.id.L_password_id);
        LoginTextViewbtn = (TextView)findViewById(R.id.L_login_text_id);
        Lprograssbar = (ProgressBar)findViewById(R.id.L_progressBar_id);
        LfAuth = FirebaseAuth.getInstance();
        LoginButton = (Button)findViewById(R.id.login_btn_id);
        ForgotPwdbtn = (TextView)findViewById(R.id.fogotpassword_id);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lemail = LEmail.getText().toString().trim();
                String lpassword = LPassword.getText().toString().trim();
                if(TextUtils.isEmpty(lemail))
                {
                    LEmail.setError("Email is Required!!");
                    return;
                }
                if(TextUtils.isEmpty(lpassword))
                {
                    LPassword.setError("Password is Required!!");
                    return;
                }
                if(lpassword.length() < 6)
                {
                    LPassword.setError("Password must be >= 6 characters");
                    return;
                }
                Lprograssbar.setVisibility(View.VISIBLE);
                //Authenticate the user
                LfAuth.signInWithEmailAndPassword(lemail,lpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this,"Logged in Succecuted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Error!!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           // Lprograssbar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });

        LoginTextViewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
        ForgotPwdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password??");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extrak the email and send reset link
                        String mail = resetMail.getText().toString();
                        LfAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this, "Reset Link Sent To Your Email" , Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Error!! Reset Link is Not Sent"+ e.getMessage() , Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog

                    }
                });
                passwordResetDialog.create().show();

            }
        });

    }
}