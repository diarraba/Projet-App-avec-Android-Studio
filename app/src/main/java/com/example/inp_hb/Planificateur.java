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

public class Planificateur extends AppCompatActivity {
    private WebView plan;
    private ImageButton retour;
    private ProgressBar progressBar11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificateur);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        plan= (WebView) findViewById(R.id.plan);
        plan.setWebViewClient(new WebViewClient());
        plan.loadUrl("https://tasks.office.com/inphb.ci/fr-FR/Home/Planner/");
        WebSettings settings=plan.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar11 = findViewById(R.id.progressBar11);
        progressBar11.setMax(100);
        progressBar11.setProgress(0);
        plan.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar11.setProgress(newProgress);
                if (newProgress==100)
                    progressBar11.setVisibility(View.INVISIBLE);
                else
                    progressBar11.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (plan.canGoBack()){
            plan.goBack();
        } else{
            super.onBackPressed();
        }
    }
}