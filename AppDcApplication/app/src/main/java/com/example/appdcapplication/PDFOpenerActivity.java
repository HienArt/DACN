package com.example.appdcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpenerActivity extends AppCompatActivity {
    PDFView myPDFViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);

        myPDFViewer=(PDFView) findViewById(R.id.pdfViewer);

        String getItem = getIntent().getStringExtra("pdfFileName");
        if (getItem.equals("dummy")){
            myPDFViewer.fromAsset("dummy.pdf").load();
        }
        if (getItem.equals("exam")){
            myPDFViewer.fromAsset("exam.pdf").load();
        }
        if (getItem.equals("free")){
            myPDFViewer.fromAsset("free.pdf").load();
        }
        if (getItem.equals("pdf")){
            myPDFViewer.fromAsset("pdf.pdf").load();
        }
        if (getItem.equals("sample")){
            myPDFViewer.fromAsset("sample.pdf").load();
        }


    }
}
