package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop7 extends AppCompatActivity {

    PDFView crop7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop7);
        crop7=(PDFView) findViewById(R.id.pdfCrop7);
        crop7.fromAsset("oragi1.pdf").load();
    }
}
