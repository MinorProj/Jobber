package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Find_Jobs extends  AppCompatActivity {

    public static final String URL = "http://35.200.252.187//elasticsearch/jobs/jobs/";
    public  final static String KEY = "jobs";
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
    String searchString;
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

    search.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            submit();
        }
    });

}

    private void submit() {

        qualification = qual.getSelectedItem().toString();
        cdesignation = cdesig.getSelectedItem().toString();
        loc = cloc.getSelectedItem().toString();
        type = ctype.getSelectedItem().toString();

        searchString = "*";
        searchString = searchString + " qualification:" + qualification;

        searchString = searchString + " loc:" + loc;

        searchString = searchString + " desg:" + cdesignation;

        searchString = searchString + " type:" + type;

      /*  if(mJobs.isEmpty()) {
            Snackbar s = Snackbar.make(fj,"No Job Found !",Snackbar.LENGTH_SHORT);
            s.show(); */
     //   }else{

         /*   Intent intent = new Intent(Find_Jobs.this,JobRetrieve.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY,mJobs);
            intent.putExtra(KEY,bundle);
            startActivity(intent);
        Log.d("Response","Going to JobRetrieve"); */
       // }


        Intent i = new Intent(this, JobRetrieve.class);

        i.putExtra(KEY,searchString); //Insert the Bundle object in the Intent' Extras

         startActivity(i); //Start Activity

    }

}

