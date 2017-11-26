package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.net.URL;

public class home_page extends AppCompatActivity implements View.OnClickListener{

    Button mbutton;
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
        setContentView(R.layout.activity_home_page);

        mbutton=(Button)findViewById(R.id.find_jobs);

        mbutton.setOnClickListener(this);
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



    @Override
    public void onClick(View v) {
        if(v == mbutton)
        {
            finish();
            Intent i = new Intent(home_page.this,Find_Jobs.class);
            startActivity(i);

        }
    }
}
