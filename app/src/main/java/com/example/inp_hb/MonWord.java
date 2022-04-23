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

public class MonWord extends AppCompatActivity {
    private WebView word;
    private ImageButton retour;
    private ProgressBar progressBar9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_word);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        word= (WebView) findViewById(R.id.word);
        word.setWebViewClient(new WebViewClient());
        word.loadUrl("https://www.office.com/launch/word?auth=2");
        WebSettings settings=word.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar9 = findViewById(R.id.progressBar9);
        progressBar9.setMax(100);
        progressBar9.setProgress(0);
        word.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar9.setProgress(newProgress);
                if (newProgress==100)
                    progressBar9.setVisibility(View.INVISIBLE);
                else
                    progressBar9.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (word.canGoBack()){
            word.goBack();
        } else{
            super.onBackPressed();
        }
    }
}