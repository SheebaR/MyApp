package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop6 extends AppCompatActivity {

    PDFView crop6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop6);
        crop6=(PDFView) findViewById(R.id.pdfCrop6);
        crop6.fromAsset("opaddy.pdf").load();
    }
}
