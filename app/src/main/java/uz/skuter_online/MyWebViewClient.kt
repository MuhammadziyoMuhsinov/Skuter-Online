package uz.skuter_online

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import uz.skuter_online.databinding.ActivityMainBinding


class MyWebViewClient(val context: Context, val progressBar: FrameLayout, val linearLayout: LinearLayout) : WebViewClient() {

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        // This method is called when the WebView starts loading a new page
        // You can show a loading indicator or perform any other actions here

        progressBar.visibility = View.VISIBLE
        linearLayout.visibility = View.INVISIBLE

    }

    override fun onPageFinished(view: WebView?, url: String?) {
        // This method is called when the WebView finishes loading a page
        // You can hide the loading indicator or perform any other post-loading actions here

        progressBar.visibility = View.GONE

    }

    override fun onReceivedError(
        view: WebView?,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        view?.visibility = View.GONE
        linearLayout.visibility = View.VISIBLE

    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (url != null && url.startsWith("https://t.me")) {
            try {
                val telegramIntent = Intent(Intent.ACTION_VIEW)
                telegramIntent.data = Uri.parse(url)
                context.startActivity(telegramIntent)
                return true
            } catch (e: ActivityNotFoundException) {
                // Handle Telegram not installed
                return false
            }
        }
        return false
    }

}