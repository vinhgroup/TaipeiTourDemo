package com.example.demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebviewActivity : AppCompatActivity() {
    lateinit var mWebView : WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_webview)
        mWebView = findViewById(R.id.webview)
        var url = intent.getStringExtra("url")
        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()
        if (url != null) {
            mWebView.loadUrl(url)
        }

    }
}