package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop10 extends AppCompatActivity {

    PDFView crop10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop10);
        crop10=(PDFView) findViewById(R.id.pdfCrop10);
        crop10.fromAsset("oxyz.pdf").load();
    }
}
