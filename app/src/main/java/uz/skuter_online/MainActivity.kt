package uz.skuter_online

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatDelegate
import uz.skuter_online.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = MyWebViewClient(binding.root.context,binding.progressBar,binding.error)

        binding.webView.loadUrl("https://skuter-online.uz/") // Load a web page
        binding.retry.setOnClickListener {
            binding.webView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
            binding.error.visibility = View.GONE
            binding.webView.reload()
        }




    }
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}