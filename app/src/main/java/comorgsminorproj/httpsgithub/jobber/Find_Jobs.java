package comorgsminorproj.httpsgithub.jobber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Find_Jobs extends  AppCompatActivity implements Serializable{

    public static final String URL = "http://35.200.252.187//elasticsearch/jobs/jobs/";

    Spinner cdesig;
    Spinner cloc;
    Spinner ctype;
    Button search;
    Spinner qual;
    String qualification;
    String cdesignation;
    String loc;
    String type;
    RelativeLayout fj;

    private DatabaseReference root;

    ArrayList<Job> mJobs;




@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_find__jobs);

    ctype = (Spinner) findViewById(R.id.ctype);
    cdesig = (Spinner) findViewById(R.id.cdesig);
    cloc = (Spinner) findViewById(R.id.cloc);
    search = (Button) findViewById(R.id.search);

    qual = (Spinner) findViewById(R.id.qual);
    fj = (RelativeLayout) findViewById(R.id.fj);

    root = FirebaseDatabase.getInstance().getReference();

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.qualification_array, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    qual.setAdapter(adapter);

    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
            R.array.Location, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    cloc.setAdapter(adapter1);

    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
            R.array.designation_array, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    cdesig.setAdapter(adapter2);

    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
            R.array.type, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    ctype.setAdapter(adapter3);

    View.OnClickListener v = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == search)
                submit();
        }
    };




}

    private void submit() {

        qualification = qual.getSelectedItem().toString();
        cdesignation = cdesig.getSelectedItem().toString();
        loc = cloc.getSelectedItem().toString();
        type = ctype.getSelectedItem().toString();

        mJobs = new ArrayList<Job>();
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        ElasticSearchAPI searchAPI = retrofit.create(ElasticSearchAPI.class);

        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", Credentials.basic("user","ZGZWT9obsr1Y"));

        String searchString = "*";
        searchString = searchString + " qualification:" + qualification;

        searchString = searchString + " loc:" + loc;

        searchString = searchString + " desg:" + cdesignation;

        searchString = searchString + " type:" + type;

        Call<HitsObject> call = searchAPI.search(headerMap,"AND",searchString);

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
                    Log.d("Response","Salary: "+mJobs.get(0).salary);

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
        Intent i= new Intent(this,JobRetrieve.class);
        i.putExtra("jobs",mJobs);
        startActivity(i);


    }



}

