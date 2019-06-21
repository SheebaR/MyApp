package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop5 extends AppCompatActivity {

    PDFView crop5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop5);
        crop5=(PDFView) findViewById(R.id.pdfCrop5);
        crop5.fromAsset("okabbu.pdf").load();
    }
}
