package uz.skuter_online

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import uz.skuter_online.databinding.ActivityMainBinding


class MyWebViewClient(val progressBar: ProgressBar, val linearLayout: LinearLayout) : WebViewClient() {

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
}