package com.example.saarc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class map extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        webView= findViewById(R.id.webviewid1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String url1=getIntent().getStringExtra("url1");

        if (url1 != null) {
            // Log.d("URL", url);
            webView.loadUrl(url1);
        }
    }

    public  void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
            super.onBackPressed();
    }
}