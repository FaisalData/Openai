package com.example.openai;

import static android.webkit.WebSettings.LOAD_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    WebView mywebview;

    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebview=findViewById(R.id.webview);

        mywebview.loadUrl("https://chat.openai.com/c/45f4e8c4-5bce-4c44-b5df-9a0350db3978");

        mywebview.setWebViewClient(new WebViewClient());
        mywebview.setWebChromeClient(new WebChromeClient());
        mywebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        WebSettings webSettings= mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(LOAD_DEFAULT);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setEnableSmoothTransition(true);
        webSettings.setSaveFormData(true);
        webSettings.setSaveFormData(true);
        webSettings.setSavePassword(true);
        webSettings.setUseWideViewPort(true);
        mywebview.copyBackForwardList();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        mywebview.getSettings().setUserAgentString(USER_AGENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webSettings.setSafeBrowsingEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mywebview.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        }else{
            mywebview.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }
    }

    //For back button press
    @Override
    public void onBackPressed() {
        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}