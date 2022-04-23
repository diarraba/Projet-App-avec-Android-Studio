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


public class inp extends AppCompatActivity {
    private WebView INP;
    private ImageButton retour;
    private ProgressBar progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inp);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        INP= (WebView) findViewById(R.id.INP);
        progressBar4 = findViewById(R.id.progressBar4);
        progressBar4.setMax(100);
        INP.setWebViewClient(new WebViewClient());
        INP.loadUrl("https://inphb.ci/2/vues/accueil/");
        progressBar4.setProgress(0);
        INP.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar4.setProgress(newProgress);
                if (newProgress==100)
                    progressBar4.setVisibility(View.INVISIBLE);
                else
                    progressBar4.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
        WebSettings settings=INP.getSettings();
        settings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed (){
        if (INP.canGoBack()){
            INP.goBack();
        } else{
            super.onBackPressed();
        }
    }
}