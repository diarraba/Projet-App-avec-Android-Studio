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

public class INPcommunity extends AppCompatActivity {
    private WebView community;
    private ImageButton retour;
    private ProgressBar progressBar8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpcommunity);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        community= (WebView) findViewById(R.id.community);
        community.setWebViewClient(new WebViewClient());
        community.loadUrl("https://web.yammer.com/main/feed");
        WebSettings settings=community.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar8 = findViewById(R.id.progressBar8);
        progressBar8.setMax(100);
        progressBar8.setProgress(0);
        community.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar8.setProgress(newProgress);
                if (newProgress==100)
                    progressBar8.setVisibility(View.INVISIBLE);
                else
                    progressBar8.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (community.canGoBack()){
            community.goBack();
        } else{
            super.onBackPressed();
        }
    }
}