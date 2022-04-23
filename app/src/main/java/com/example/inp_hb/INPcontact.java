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

public class INPcontact extends AppCompatActivity {
    private WebView contact;
    private ImageButton retour;
    private ProgressBar progressBar16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpcontact);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        contact= (WebView) findViewById(R.id.contact);
        contact.setWebViewClient(new WebViewClient());
        contact.loadUrl("https://outlook.office.com/people/");
        WebSettings settings=contact.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar16 = findViewById(R.id.progressBar16);
        progressBar16.setMax(100);
        progressBar16.setProgress(0);
        contact.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar16.setProgress(newProgress);
                if (newProgress==100)
                    progressBar16.setVisibility(View.INVISIBLE);
                else
                    progressBar16.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (contact.canGoBack()){
            contact.goBack();
        } else{
            super.onBackPressed();
        }
    }
}