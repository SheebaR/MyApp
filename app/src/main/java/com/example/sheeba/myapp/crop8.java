package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop8 extends AppCompatActivity {

    PDFView crop8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop8);
        crop8=(PDFView) findViewById(R.id.pdfCrop8);
        crop8.fromAsset("otomato.pdf").load();
    }
}
