package com.example.saarc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class video extends AppCompatActivity {
    private WebView webView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        webView= findViewById(R.id.webviewid2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String url2=getIntent().getStringExtra("url2");

        if (url2 != null) {
            // Log.d("URL", url);
            webView.loadUrl(url2);
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