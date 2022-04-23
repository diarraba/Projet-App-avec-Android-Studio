package com.example.inp_hb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MonExcel extends AppCompatActivity {
    private WebView excel;
    private ImageButton retour;
    private ProgressBar progressBar13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_excel);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        excel= (WebView) findViewById(R.id.excel);
        excel.setWebViewClient(new WebViewClient());
        excel.loadUrl("https://www.office.com/launch/excel?auth=2");
        WebSettings settings=excel.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar13 = findViewById(R.id.progressBar13);
        progressBar13.setMax(100);
        progressBar13.setProgress(0);
        excel.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar13.setProgress(newProgress);
                if (newProgress==100)
                    progressBar13.setVisibility(View.INVISIBLE);
                else
                    progressBar13.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (excel.canGoBack()){
            excel.goBack();
        } else{
            super.onBackPressed();
        }
    }
}