package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class crop9 extends AppCompatActivity {

    PDFView crop9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop9);
        crop9=(PDFView) findViewById(R.id.pdfCrop9);
        crop9.fromAsset("oabc.pdf").load();
    }
}

