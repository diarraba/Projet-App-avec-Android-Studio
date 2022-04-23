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

public class MailInstitutionnelle extends AppCompatActivity {
    private WebView mail;
    private ImageButton retour;
    private ProgressBar progressBar12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_institutionnelle);
        this.retour= (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retour);
                finish();
            }
        });
        mail= (WebView) findViewById(R.id.mail);
        mail.setWebViewClient(new WebViewClient());
        mail.loadUrl("https://outlook.office.com/mail/");
        WebSettings settings=mail.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBar12 = findViewById(R.id.progressBar12);
        progressBar12.setMax(100);
        progressBar12.setProgress(0);
        mail.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view,int newProgress){
                progressBar12.setProgress(newProgress);
                if (newProgress==100)
                    progressBar12.setVisibility(View.INVISIBLE);
                else
                    progressBar12.setVisibility(View.VISIBLE);
                super.onProgressChanged(view,newProgress);
            }
        });
    }
    @Override
    public void onBackPressed (){
        if (mail.canGoBack()){
            mail.goBack();
        } else{
            super.onBackPressed();
        }
    }
}