package comorgsminorproj.httpsgithub.jobber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.view.View;
import android.webkit.WebSettings;

import android.webkit.WebViewClient;

public class GovernmentJobs extends AppCompatActivity {
    WebView wb;
    public void onBackedPressed(){
        if(wb.canGoBack()){
            wb.goBack();
        }else{
            super.onBackPressed();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_jobs);

        wb=(WebView)findViewById(R.id.web_id);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setFocusable(true);
        wb.setFocusableInTouchMode(true);
        wb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wb.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wb.getSettings().setDomStorageEnabled(true);
        wb.getSettings().setDatabaseEnabled(true);
        wb.getSettings().setAppCacheEnabled(true);
        wb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wb.loadUrl("https://www.fresherslive.com/govt-jobs");
        wb.setWebViewClient(new WebViewClient());
    }
}
