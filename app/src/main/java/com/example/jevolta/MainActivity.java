package com.example.jevolta;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.CancellationSignal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Object printWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.webView1);

/*
        String siteUrl = "https://gvolta.com/";
*/
        String siteUrl = "file:///android_asset/index.html";

        mWebView.loadUrl(siteUrl);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.setWebViewClient(new mWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Setting we View Client
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // initializing the printWeb Object
                printWeb =mWebView;
            }
        });   // Setting we View Client
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // initializing the printWeb Object
                printWeb =mWebView;
            }
        });

    }
    private class mWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

     /*       Toast.makeText(MainActivity.this, "Loading page...", Toast.LENGTH_SHORT).show();*/

        }

        @Override
        public void onPageFinished(WebView view, String url) {

          /*  Toast.makeText(MainActivity.this, "Loading finished", Toast.LENGTH_SHORT).show();*/

        }

    }

}
