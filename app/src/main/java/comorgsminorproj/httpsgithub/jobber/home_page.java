package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class home_page extends AppCompatActivity implements View.OnClickListener{

<<<<<<< HEAD
public class home_page extends AppCompatActivity implements View.OnClickListener{

=======
>>>>>>> jobber2 updated
    Button mbutton;
    Button mgov;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mbutton=(Button)findViewById(R.id.find_jobs);

        mbutton.setOnClickListener(this);
        mgov=(Button)findViewById(R.id.gov_id);
        mgov.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if(v == mbutton)
        {
            finish();
            Intent i = new Intent(home_page.this,Find_Jobs.class);
            startActivity(i);

        }
        if (v==mgov)
        {
            finish();
            Intent j=new Intent(home_page.this,GovernmentJobs.class);
            startActivity(j);
        }

    }
}
