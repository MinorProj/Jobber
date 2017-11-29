package comorgsminorproj.httpsgithub.jobber;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.view.View;
import android.webkit.WebSettings;

import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class GovernmentJobs extends AppCompatActivity {
    WebView wb;
   ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_jobs);
        progressBar=(ProgressBar)findViewById(R.id.progress_id);
        wb=(WebView)findViewById(R.id.web_id);
        wb.setWebViewClient(new myWebclient());
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("https://www.fresherslive.com/govt-jobs");

    }

    public class myWebclient  extends WebViewClient{

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if((keyCode==KeyEvent.KEYCODE_BACK)&& wb.canGoBack()){
            wb.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
