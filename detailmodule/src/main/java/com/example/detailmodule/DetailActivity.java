package com.example.detailmodule;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.provider.IDetailProvider;

@Route(path = IDetailProvider.DETAIL_ACTIVITY)
public class DetailActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//缓存模式，不加载缓存
        webSettings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient() {

        };
        webView.setWebViewClient(client);
        webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        webView.loadUrl(url);
        Log.i("zhouke","DetailActivity url:"+url);
    }
}
