package com.example.sheeba.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fertilizer extends AppCompatActivity {

    private Button btn_crop4, btn_crop5, btn_crop6 ,btn_crop7, btn_crop8,btn_crop9, btn_crop10 ,btn_crop11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);
        btn_crop4 = (Button) findViewById(R.id.crop1npk);
        btn_crop5 = (Button) findViewById(R.id.crop2npk);
        btn_crop6 = (Button) findViewById(R.id.crop3npk);
        btn_crop7 = (Button) findViewById(R.id.crop4npk);
        btn_crop8 = (Button) findViewById(R.id.crop5npk);
        btn_crop9 = (Button) findViewById(R.id.crop6npk);
        btn_crop10 = (Button) findViewById(R.id.crop7npk);
        btn_crop11 = (Button) findViewById(R.id.crop8npk);


        btn_crop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop1.class);
                startActivity(i);

            }
        });

        btn_crop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop2.class);
                startActivity(i2);
            }
        });
        btn_crop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(fertilizer.this, com.example.sheeba.myapp.nkpcrop3.class);
                startActivity(i3);
            }
        });
        btn_crop7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop4.class);
                startActivity(i4);
            }
        });
        btn_crop8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop5.class);
                startActivity(i5);
            }
        });
        btn_crop9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop6.class);
                startActivity(i6);
            }
        });
        btn_crop10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop7.class);
                startActivity(i7);
            }
        });
        btn_crop11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(fertilizer.this, com.example.sheeba.myapp.npkcrop8.class);
                startActivity(i8);
            }
        });

    }
}
