package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;

public class inpforum extends AppCompatActivity {
    private WebView inpforum;
    private ImageButton retour;
    private ProgressBar progressBar7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpforum);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        inpforum= (WebView) findViewById(R.id.inpforum);
        inpforum.setWebViewClient(new WebViewClient());
        inpforum.loadUrl("https://xoyondo.com/mb/fYm7bc3sYwtEvuw");
        WebSettings settings=inpforum.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar7 = findViewById(R.id.progressBar7);
        progressBar7.setMax(100);
        progressBar7.setProgress(0);
        inpforum.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar7.setProgress(newProgress);
                if (newProgress==100)
                    progressBar7.setVisibility(View.INVISIBLE);
                else
                    progressBar7.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (inpforum.canGoBack()){
            inpforum.goBack();
        } else{
            super.onBackPressed();
        }
    }
}