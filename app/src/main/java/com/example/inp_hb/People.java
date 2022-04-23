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


public class People extends AppCompatActivity {
    private WebView people;
    private ImageButton retour;
    private ProgressBar progressBar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        people= (WebView) findViewById(R.id.people1);
        people.setWebViewClient(new WebViewClient());
        people.loadUrl("https://abidjan.net/");
        WebSettings settings=people.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar6 = findViewById(R.id.progressBar6);
        progressBar6.setMax(100);
        progressBar6.setProgress(0);
        people.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar6.setProgress(newProgress);
                if (newProgress==100)
                    progressBar6.setVisibility(View.INVISIBLE);
                else
                    progressBar6.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (people.canGoBack()){
            people.goBack();
        } else{
            super.onBackPressed();
        }
    }
}