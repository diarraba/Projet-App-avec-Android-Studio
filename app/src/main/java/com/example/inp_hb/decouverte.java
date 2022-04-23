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


public class decouverte extends AppCompatActivity {
    private WebView decouverte;
    private ImageButton retour;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decouverte);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        decouverte= (WebView) findViewById(R.id.inpspaceadm);
        decouverte.setWebViewClient(new WebViewClient());
        decouverte.loadUrl("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal");
        WebSettings settings=decouverte.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setMax(100);
        progressBar2.setProgress(0);
        decouverte.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar2.setProgress(newProgress);
                if (newProgress==100)
                    progressBar2.setVisibility(View.INVISIBLE);
                else
                    progressBar2.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (decouverte.canGoBack()){
            decouverte.goBack();
        } else{
            super.onBackPressed();
        }
    }
}