package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rpage extends AppCompatActivity implements View.OnClickListener{

    private Button addjob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpage);

        addjob = (Button) findViewById(R.id.add_id);

        addjob.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v == addjob) {
            Intent homeIntent = new Intent(Rpage.this, AddJobs.class);
            startActivity(homeIntent);
            finish();
        }
    }
}

