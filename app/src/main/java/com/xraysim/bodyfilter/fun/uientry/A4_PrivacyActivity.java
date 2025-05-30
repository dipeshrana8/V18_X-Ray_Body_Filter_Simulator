package com.xraysim.bodyfilter.fun.uientry;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.xraysim.bodyfilter.fun.foundation.AdSettingsController;
import com.xraysim.bodyfilter.fun.databinding.ActivityPrivacyBinding;


public class A4_PrivacyActivity extends MainBaseActivity {

    private ActivityPrivacyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableEmbeddedAds = false;


        super.onCreate(savedInstanceState);

        binding = ActivityPrivacyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());


        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        binding.webView.setWebViewClient(new WebViewClient());

        String privacyUrl = AdSettingsController.getPrivacyPolicyUrl();
        if (!privacyUrl.isEmpty()) {
            binding.webView.loadUrl(privacyUrl);
        } else {
            binding.webView.loadData("<h2>No Privacy Policy URL available</h2>", "text/html", "UTF-8");
        }
    }

    @Override
    public void onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            handleBackNavigation();
        }
    }
}
