package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class home_page extends AppCompatActivity implements View.OnClickListener{

    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mbutton=(Button)findViewById(R.id.find_jobs);

        mbutton.setOnClickListener(this);
    }

    public void open(View view){
        Intent browerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fresherslive.com/govt-jobs"));
        startActivity(browerIntent);
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
