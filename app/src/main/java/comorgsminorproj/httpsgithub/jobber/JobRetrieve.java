package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class JobRetrieve extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
private ArrayList<String> mDataset;


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

        mDataset=new ArrayList<>();
        for(int i=0;i<4;i++){
            mDataset.add("Jobs #" + i);


        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MainAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }




    }



}



