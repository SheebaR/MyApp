package com.example.sheeba.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity  {



    private  Button btn_crop1, btn_crop2, btn_crop3, btn_crop4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btn_crop1 = (Button) findViewById(R.id.btndisplayCrop);
        btn_crop2 = (Button) findViewById(R.id.btnfertilizer);
        btn_crop3 = (Button) findViewById(R.id.btnvideo);
        btn_crop4 =(Button) findViewById(R.id.Logut);

        btn_crop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, com.example.sheeba.myapp.cropdisplay.class);
                startActivity(i);

            }
        });

        btn_crop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(ProfileActivity.this, com.example.sheeba.myapp.fertilizer.class);
                startActivity(i2);
            }
        });
        btn_crop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(ProfileActivity.this, com.example.sheeba.myapp.video.class);
                startActivity(i3);
            }
        });
        btn_crop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}