package uz.skuter_online

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.skuter_online.databinding.FragmentHamkorlarBinding


class FragmentHamkorlar : Fragment() {


    private lateinit var binding:FragmentHamkorlarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHamkorlarBinding.inflate(layoutInflater)



        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = MyWebViewClient(binding.root.context,binding.progressBar,binding.error)

        binding.webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScmq7FtdOze96pzW_uwkwi7o4IQgKSdg_kRD_agooi0__xuyw/viewform") // Load a web page
        MyData.webView = binding.webView

        binding.retry.setOnClickListener {
            binding.webView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
            binding.error.visibility = View.GONE
            binding.webView.reload()
        }



        return binding.root
    }


}