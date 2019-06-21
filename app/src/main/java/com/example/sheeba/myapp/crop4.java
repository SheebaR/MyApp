package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop4 extends AppCompatActivity {

    PDFView crop4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop4);
        crop4=(PDFView) findViewById(R.id.pdfCrop4);
        crop4.fromAsset("otengu.pdf").load();
    }
}
