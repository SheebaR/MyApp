package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop1 extends AppCompatActivity {

    PDFView crop1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop1);
        crop1=(PDFView) findViewById(R.id.pdfCrop1);
        crop1.fromAsset("oadike.pdf").load();


    }
}
