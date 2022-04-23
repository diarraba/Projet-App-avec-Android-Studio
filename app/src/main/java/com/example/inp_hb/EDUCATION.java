package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;

public class EDUCATION extends AppCompatActivity {
    private WebView education;
    private ImageButton retour;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        progressBar = findViewById(R.id.progressBar);
        education= (WebView) findViewById(R.id.inpforum);
        progressBar.setMax(100);
        education.setWebViewClient(new WebViewClient());
        education.loadUrl("https://www.enseignement.gouv.ci/");
        progressBar.setProgress(0);
        education.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar.setProgress(newProgress);
                if (newProgress==100)
                    progressBar.setVisibility(View.INVISIBLE);
                else
                    progressBar.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
        WebSettings settings=education.getSettings();
        settings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed (){
        if (education.canGoBack()){
            education.goBack();
        } else{
            super.onBackPressed();
        }
    }
}