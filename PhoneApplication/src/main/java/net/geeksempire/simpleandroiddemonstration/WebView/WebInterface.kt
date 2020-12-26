/*
 * Copyright © 2020 By Geeks Empire.
 *
 * Created by Elias Fazel on 8/3/20 12:27 AM
 * Last modified 8/2/20 11:11 PM
 *
 * Licensed Under MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.abanabsalan.aban.magazine.WebView

import android.webkit.JavascriptInterface
import net.geeksempire.simpleandroiddemonstration.WebView.InternalWebView

/**
 * Android
 **/
class WebInterface (private val context: InternalWebView) {

    /**
     *
     **/
    @JavascriptInterface
    fun getThemeColor() : Int {

        return 0
    }

}