package com.example.vvnews_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        WebView webView = findViewById(R.id.webx);

        // loading http://www.google.com url in the WebView.
        webView.loadUrl("http://192.168.20.5:8000");
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });
        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());
    }
}