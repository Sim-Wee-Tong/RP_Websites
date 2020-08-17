package rp.edu.sg.c346.id19020438.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DisplayWeb extends AppCompatActivity {

    WebView wvURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_web);

        wvURL = findViewById(R.id.webViewRPWebsite);

        wvURL.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("WebPage URL");

        wvURL.getSettings().setJavaScriptEnabled(true);
        wvURL.getSettings().setAllowFileAccess(false);
        wvURL.getSettings().setBuiltInZoomControls(true);

        wvURL.loadUrl(url);
    }
}
