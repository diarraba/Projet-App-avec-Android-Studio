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

public class InfoEtud extends AppCompatActivity {
    private WebView infoetud;
    private ImageButton retour;
    private ProgressBar progressBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_etud);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        infoetud= (WebView) findViewById(R.id.inpforum);
        infoetud.setWebViewClient(new WebViewClient());
        infoetud.loadUrl("https://etudiant.ent.inphb.ci/");
        WebSettings settings=infoetud.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar3.setMax(100);
        progressBar3.setProgress(0);
        infoetud.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar3.setProgress(newProgress);
                if (newProgress==100)
                    progressBar3.setVisibility(View.INVISIBLE);
                else
                    progressBar3.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (infoetud.canGoBack()){
            infoetud.goBack();
        } else{
            super.onBackPressed();
        }
    }
}