package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    companion object {
        private const val URL = "https://www.tradingview.com/chart/8RmpOhKU"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)
        val firstWebView = findViewById<WebView>(R.id.web_view_first).apply {
            setup()
            loadUrl(URL)
        }
        findViewById<WebView>(R.id.web_view_second).apply {
            setup()
            loadUrl(URL)
        }
        findViewById<View>(R.id.button).apply {
            setOnClickListener { firstWebView.destroy() }
        }
    }

    private fun WebView.setup() {
        settings.javaScriptEnabled = true
        webChromeClient = WebChromeClient()
        webViewClient = WebViewClient()
    }
}
