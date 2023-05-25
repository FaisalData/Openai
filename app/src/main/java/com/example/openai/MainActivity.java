package com.example.openai;

import static android.webkit.WebSettings.LOAD_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    WebView mywebview;

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