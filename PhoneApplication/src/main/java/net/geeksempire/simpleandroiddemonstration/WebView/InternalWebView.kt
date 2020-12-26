package net.geeksempire.simpleandroiddemonstration.WebView

import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.abanabsalan.aban.magazine.WebView.WebInterface
import net.geeksempire.simpleandroiddemonstration.databinding.InternalWebViewBinding
import java.io.File

class InternalWebView : AppCompatActivity() {

    lateinit var internalWebViewBinding: InternalWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        internalWebViewBinding = InternalWebViewBinding.inflate(layoutInflater)
        setContentView(internalWebViewBinding.root)

        val linkToLoad = "https://GeeksEmpire.net"

        internalWebViewBinding.internalBrowser.settings.javaScriptEnabled = true

        internalWebViewBinding.internalBrowser.settings.builtInZoomControls = true
        internalWebViewBinding.internalBrowser.settings.displayZoomControls = false
        internalWebViewBinding.internalBrowser.settings.setSupportZoom(true)

        internalWebViewBinding.internalBrowser.settings.useWideViewPort = true
        internalWebViewBinding.internalBrowser.settings.loadWithOverviewMode = true
        internalWebViewBinding.internalBrowser.setInitialScale(0)

        internalWebViewBinding.internalBrowser.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        internalWebViewBinding.internalBrowser.settings.setAppCacheEnabled(true)
        internalWebViewBinding.internalBrowser.settings.setAppCachePath(getFileStreamPath("").path
                + "${File.separator}cache${File.separator}")

        internalWebViewBinding.internalBrowser.webViewClient = BuiltInWebViewClient()
        internalWebViewBinding.internalBrowser.webChromeClient = BuiltInChromeWebViewClient()

        internalWebViewBinding.internalBrowser.addJavascriptInterface(
            WebInterface(this@InternalWebView),
            "Android")/* This Label Is Use To Connect With Codes In Javascript */

        internalWebViewBinding.internalBrowser.loadUrl(linkToLoad)

    }

    inner class BuiltInWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            if (request != null) {
                view?.loadUrl(request.url.toString())
            }

            return false
        }

        override fun onPageStarted(webView: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(webView, url, favicon)

        }

        override fun onPageFinished(webView: WebView?, url: String?) {
            super.onPageFinished(webView, url)

        }

    }

    inner class BuiltInChromeWebViewClient : WebChromeClient() {

    }

}