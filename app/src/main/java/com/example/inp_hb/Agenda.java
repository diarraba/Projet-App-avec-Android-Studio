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

public class Agenda extends AppCompatActivity {
    private WebView agenda;
    private ImageButton retour;
    private ProgressBar progressBar15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        agenda= (WebView) findViewById(R.id.agend);
        agenda.setWebViewClient(new WebViewClient());
        agenda.loadUrl("https://outlook.office.com/calendar/view/month");
        WebSettings settings=agenda.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar15 = findViewById(R.id.progressBar15);
        progressBar15.setMax(100);
        progressBar15.setProgress(0);
        agenda.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar15.setProgress(newProgress);
                if (newProgress==100)
                    progressBar15.setVisibility(View.INVISIBLE);
                else
                    progressBar15.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (agenda.canGoBack()){
            agenda.goBack();
        } else{
            super.onBackPressed();
        }
    }
}