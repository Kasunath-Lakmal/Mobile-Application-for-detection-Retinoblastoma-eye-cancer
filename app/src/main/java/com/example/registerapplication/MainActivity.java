package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    //TextView nameText;
    Button loginButton;
    ProgressBar p_bar;
   // private FirebaseAuth mAuth;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
      //  mAuth = FirebaseAuth.getInstance();
       //nameText = (TextView)findViewById(R.id.textView_id);
        loginButton = (Button)findViewById(R.id.login_btn_id);
        p_bar = (ProgressBar)findViewById(R.id.progressBar_id_2) ;


        p_bar.setVisibility(View.VISIBLE);
       /* login_btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
*/
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}