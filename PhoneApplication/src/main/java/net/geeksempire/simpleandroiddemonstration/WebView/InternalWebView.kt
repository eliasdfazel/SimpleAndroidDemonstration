package net.geeksempire.simpleandroiddemonstration.WebView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.databinding.InternalWebViewBinding

class InternalWebView : AppCompatActivity() {

    lateinit var internalWebViewBinding: InternalWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        internalWebViewBinding = InternalWebViewBinding.inflate(layoutInflater)
        setContentView(internalWebViewBinding.root)

        internalWebViewBinding.internalBrowser.settings.javaScriptEnabled = true

        internalWebViewBinding.internalBrowser.loadUrl("https://Google.com")

    }

}