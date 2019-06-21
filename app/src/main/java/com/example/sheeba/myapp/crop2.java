package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop2 extends AppCompatActivity {

    PDFView crop2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop2);
        crop2=(PDFView) findViewById(R.id.pdfCrop2);
        crop2.fromAsset("oatti.pdf").load();

    }
}
