package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class JobRetrieve extends AppCompatActivity {

    ArrayList<Job> jobs = new ArrayList<Job>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_retrieve);

        Intent intent = getIntent();
        jobs = (ArrayList<Job>) intent.getSerializableExtra("jobs");


    }
}
