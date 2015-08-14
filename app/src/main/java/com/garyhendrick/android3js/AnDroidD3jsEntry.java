package com.garyhendrick.android3js;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class AnDroidD3jsEntry extends AppCompatActivity implements View.OnClickListener {
    final static String TRACEFILE_JAVA = "AnDroiD3js.javabutton";
    final static String TRACEFILE_JS = "AnDroiD3js.jsbutton";

    private WebView webView;
    private Button javafnButton, jsfnButton;
    private JsHandler _jsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_droid_d3js_entry);
        javafnButton = (Button)findViewById(R.id.javafnButton);
        javafnButton.setOnClickListener(this);
        jsfnButton = (Button)findViewById(R.id.jsfnButton);
        jsfnButton.setOnClickListener(this);
        initWebView();
    }

    /**
     * Function initializes  webview & does the necessary settings for webview
     */
    private void initWebView(){

        webView = (WebView)findViewById(R.id.webViewer);
        //Tell the WebView to enable javascript execution.
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.parseColor("#808080"));

        //Set whether the DOM storage API is enabled.
        webView.getSettings().setDomStorageEnabled(true);

        //setBuiltInZoomControls = false, removes +/- controls on screen
        webView.getSettings().setBuiltInZoomControls(false);

        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);

        webView.getSettings().setAppCacheMaxSize(1024 * 8);
        webView.getSettings().setAppCacheEnabled(true);

        _jsHandler = new JsHandler(this, webView);
        webView.addJavascriptInterface(_jsHandler, "JsHandler");

        webView.getSettings().setUseWideViewPort(false);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
                //Toast.makeText(TableContentsWithDisplay.this, "url "+url, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //Toast.makeText(TableContentsWithDisplay.this, "Width " + view.getWidth() +" *** " + "Height " + view.getHeight(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                super.onReceivedSslError(view, handler, error);
                //Toast.makeText(TableContentsWithDisplay.this, "error "+error, Toast.LENGTH_SHORT).show();

            }
        });

        // these settings speed up page load into the webview
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.requestFocus(View.FOCUS_DOWN);
        // load the main.html file that kept in assets folder
        webView.loadUrl("file:///android_asset/main.html");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jsfnButton:
                Debug.startMethodTracing(TRACEFILE_JS);
                _jsHandler.javaFnCall("Hey, Im calling from Java to JS, kiss my ass");
                Debug.stopMethodTracing();
                break;
            case R.id.javafnButton:
                Debug.startMethodTracing(TRACEFILE_JAVA);
                _jsHandler.javaFnCall("Hey, Im calling from Java to Java, kiss my ass");
                Debug.stopMethodTracing();
                break;
            default:
                break;
        }
    }
}
