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

public class AFaire extends AppCompatActivity {
    private WebView afaire;
    private ImageButton retour;
    private ProgressBar progressBar10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afaire);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        afaire= (WebView) findViewById(R.id.afaire);
        afaire.setWebViewClient(new WebViewClient());
        afaire.loadUrl("https://to-do.office.com/tasks/today?utm_source=applauncher");
        WebSettings settings=afaire.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar10 = findViewById(R.id.progressBar10);
        progressBar10.setMax(100);
        progressBar10.setProgress(0);
        afaire.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar10.setProgress(newProgress);
                if (newProgress==100)
                    progressBar10.setVisibility(View.INVISIBLE);
                else
                    progressBar10.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (afaire.canGoBack()){
            afaire.goBack();
        } else{
            super.onBackPressed();
        }
    }
}