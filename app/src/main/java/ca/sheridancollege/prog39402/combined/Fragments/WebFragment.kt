package ca.sheridancollege.prog39402.combined.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import ca.sheridancollege.prog39402.combined.R

class WebFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_web, container, false)
        var webView = view.findViewById<WebView>(R.id.webview)

        webView.setWebViewClient(WebViewClient())
        webView.loadUrl("https://www.publichealthontario.ca/")
        webView.settings.javaScriptEnabled = true
        webView.settings.allowContentAccess = true
        webView.settings.domStorageEnabled = true
        webView.settings.useWideViewPort = true
        return view
    }


}