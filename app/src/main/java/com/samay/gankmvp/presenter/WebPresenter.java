package com.samay.gankmvp.presenter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.samay.gankmvp.view.WebView;

/**
 * Created by baobao on 16/7/17.
 */

public class WebPresenter implements BasePresenter<WebView> {

    private WebView mView;

    public WebPresenter(WebView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    public void setUpWebView(android.webkit.WebView webView){
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        webView.setWebViewClient(new LoveClient());
    }

    public void loadUrl(android.webkit.WebView webView,String url){
        webView.loadUrl(url);
    }

    private class LoveClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            if (TextUtils.isEmpty(url)){
                return true;
            }
            if(Uri.parse(url).getHost().equals("github.com")){
                return false;
            }
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mView.showRefresh();
        }

        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            super.onPageFinished(view, url);
            mView.hideRefresh();
        }

        @Override
        public void onReceivedError(android.webkit.WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            mView.hideRefresh();
            mView.showLoadErrorMessage(description);
        }
    }
}
