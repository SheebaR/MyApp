package com.example.sheeba.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class cropdisplay extends AppCompatActivity  {

    // private FirebaseAuth firebaseAuth;
    private  Button bt_crop1, bt_crop2, bt_crop3, bt_crop4, bt_crop5, bt_crop6, bt_crop7, bt_crop8, bt_crop9, bt_crop10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropdisplay);
        bt_crop1 = (Button) findViewById(R.id.crop1);
        bt_crop2 = (Button) findViewById(R.id.crop2);
        bt_crop3 = (Button) findViewById(R.id.crop3);
        bt_crop4 = (Button) findViewById(R.id.crop4);
        bt_crop5 = (Button) findViewById(R.id.crop5);
        bt_crop6 = (Button) findViewById(R.id.crop6);
        bt_crop7 = (Button) findViewById(R.id.crop7);
        bt_crop8 = (Button) findViewById(R.id.crop8);
        bt_crop9 = (Button) findViewById(R.id.crop9);
        bt_crop10 = (Button) findViewById(R.id.crop10);

        bt_crop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop1.class);
                startActivity(i);

            }
        });

        bt_crop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop2.class);
                startActivity(i2);
            }
        });
        bt_crop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop3.class);
                startActivity(i3);
            }
        });
        bt_crop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop4.class);
                startActivity(i4);
            }
        });
        bt_crop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop5.class);
                startActivity(i5);
            }
        });
        bt_crop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop6.class);
                startActivity(i6);
            }
        });
        bt_crop7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop7.class);
                startActivity(i7);
            }
        });
        bt_crop8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop8.class);
                startActivity(i8);
            }
        });
        bt_crop9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i9 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop9.class);
                startActivity(i9);
            }
        });
        bt_crop10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i10 = new Intent(cropdisplay.this, com.example.sheeba.myapp.crop10.class);
                startActivity(i10);
            }
        });
    }
}