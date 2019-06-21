package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop3 extends AppCompatActivity {

    PDFView crop3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop3);
        crop3=(PDFView) findViewById(R.id.pdfCrop3);
        crop3.fromAsset("obaale.pdf").load();
    }
}
