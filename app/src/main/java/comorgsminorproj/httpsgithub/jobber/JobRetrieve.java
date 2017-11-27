package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class JobRetrieve extends AppCompatActivity {

    private ArrayAdapter<Job> arrayAdapter;
    private int i;
    TextView t;
    ArrayList<Job> jobs = new ArrayList<Job>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_retrieve);

        Intent intent = getIntent();
        jobs = (ArrayList<Job>) intent.getSerializableExtra("jobs");


    }



}



