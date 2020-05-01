package com.example.l10t01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    EditText editTextWebPage;
    WebView webView;
    String webPage;
    String webPageTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webIkkuna);
        editTextWebPage = (EditText) findViewById(R.id.editTextWebPage);
        editTextWebPage.setText("");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
    }
    public void paivita(View view) {
        webView.setWebViewClient(new WebViewClient());
        webPage = editTextWebPage.getText().toString();
        webPageTotal = "http://" + webPage;
        System.out.println(webPageTotal);
        webView.loadUrl(webPageTotal);

        webPageTotal = webView.getUrl();

    }
    public void ShoutOut(View view) {
        webView.evaluateJavascript("javascript:shoutOut()", null);
    }
    public void Initialize(View view) {
        webView.loadUrl("file:///android_asset/index.html");
        webView.evaluateJavascript("javascript:initialize()", null);
    }

    public void seuraava(View view) {
        if (webView.canGoForward()) {
            webView.goForward();
        }
    }
    public void edellinen(View view) {
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }
}
