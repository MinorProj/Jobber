package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.delay;

public class JobRetrieve extends AppCompatActivity implements View.OnClickListener {

    public static final String URL = "http://35.200.252.187//elasticsearch/jobs/jobs/";
    public  final static String KEY = "jobs";
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
private ArrayList<String> mDataset;


    private ArrayAdapter<Job> arrayAdapter;
    private int i;
    TextView t;
    Button b;
    String s;
    ArrayList<Job> mJobs = new ArrayList<Job>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobr);


        Log.d("Response","In JobRetrieve");

        s= getIntent().getStringExtra(KEY);

        t = (TextView)findViewById(R.id.tv);
        b = (Button)findViewById(R.id.bt);

        Log.d("Response"," In JobRetrieve SearchString: "+s);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ElasticSearchAPI searchAPI = retrofit.create(ElasticSearchAPI.class);

        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", Credentials.basic("user","ZGZWT9obsr1Y"));

        Call<HitsObject> call = searchAPI.search(headerMap,"AND",s);

        call.enqueue(new Callback<HitsObject>() {
            @Override
            public void onResponse(Call<HitsObject> call, Response<HitsObject> response) {

                HitsList hitsList = new HitsList();
                String jsonResponse = "";

                try {
                    Log.d("Response","Server Response: "+response.toString());
                    if(response.isSuccessful()){
                        hitsList = response.body().getHits();
                    }else {
                        jsonResponse = response.errorBody().string();
                    }
                    Log.d("Response","hits: "+hitsList);

                    for (int i=0;i<hitsList.getJobIndex().size();i++){
                        Log.d("Response","data: "+hitsList.getJobIndex().get(i).getJob().toString());
                        mJobs.add(hitsList.getJobIndex().get(i).getJob());
                    }
                    Log.d("Response","***** In JobRetrieve *****\n");
                    Log.d("Response","Size: "+mJobs.size());
                    Log.d("Response","\nDesignation: "+mJobs.get(0).getDesg());
                    Log.d("Response","\nSalary: "+mJobs.get(0).getSalary());
                    Log.d("Response","\nLocation: "+mJobs.get(0).getLoc());
                    Log.d("Response","\nType: "+mJobs.get(0).getType());
                    Log.d("Response","Qualification: "+mJobs.get(0).getQualification());
                    Log.d("Response","\nJobID: "+mJobs.get(0).getJobID());

                }catch (NullPointerException e){
                    Log.e("Error","NullPointerException: "+e.getMessage());
                }catch (IndexOutOfBoundsException e){
                    Log.e("Error","IndexOutOfBoundsException: "+e.getMessage());
                }catch (IOException e){
                    Log.e("Error","IOException: "+e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<HitsObject> call, Throwable t) {
                Log.e("Failure","message : "+t.getMessage());
            }
        });

        b.setOnClickListener(this);
       /* mDataset=new ArrayList<>();
        for(int i=0;i<20;i++){
            mDataset.add("New Title #" + i);


        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MainAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);   */

    }


    @Override
    public void onClick(View v) {
        if(v == b){
            Log.d("Response","In JobRetrieve onClick size: "+mJobs.size());
                if(mJobs.size()!=0)
                t.setText(mJobs.get(0).getQualification());
            }
        }
    }






