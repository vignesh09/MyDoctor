package com.simpleapps.vigneshr.mydoctor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.simpleapps.vigneshr.mydoctor.R.id.toolbar;

/**
 * Created by vigneshr on 8/15/2017.
 */

public class WebView_BookAppointment extends AppCompatActivity {

    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_bookappointment);

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());


                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
        CookieManager.getInstance().setCookie("https://www.practo.com/chennai/doctor/thamarai-gynecologist-obstetrician/558229/book","appDownloadBanne=hide;path=/");
                wv1.loadUrl("https://www.practo.com/chennai/doctor/thamarai-gynecologist-obstetrician/558229/book");
            }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}