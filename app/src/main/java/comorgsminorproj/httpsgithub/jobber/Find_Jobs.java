package comorgsminorproj.httpsgithub.jobber;

import android.content.Context;
import android.content.DialogInterface;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Find_Jobs extends  AppCompatActivity implements View.OnClickListener{

    public static final String URL = "http://35.200.252.187//elasticsearch/jobs/jobs/";

    Button cdesignation;
    Button clocation;
    Button ctype;
    Button search;
    Spinner qual;
    String qualification;
    String l,d,t;
    RelativeLayout fj;
    String[] listitems;
    boolean[] checkitems;
     String s3,s4;
    private DatabaseReference root;

    ArrayList<Job> mJobs;

    ArrayList<Integer> mUseritems = new ArrayList<>();
    //for Location
    final ArrayList<String> selected = new ArrayList<>();
    //for Designation
    ArrayList<Integer> cUseritems = new ArrayList<>();
    //
    final ArrayList<String> choose = new ArrayList<>();
    ArrayList<Integer> tUseritems = new ArrayList<>();
    final ArrayList<String> sel = new ArrayList<>();



@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_find__jobs);

    clocation = (Button) findViewById(R.id.loc);
    search = (Button) findViewById(R.id.search);
    ctype=(Button)findViewById(R.id.job);
    cdesignation=(Button)findViewById(R.id.desig);
    qual = (Spinner)findViewById(R.id.qual);
    fj = (RelativeLayout)findViewById(R.id.fj);

    root = FirebaseDatabase.getInstance().getReference();

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.qualification_array,android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    qual.setAdapter(adapter);

   clocation.setOnClickListener(this);
    search.setOnClickListener(this);
    cdesignation.setOnClickListener(this);
    ctype.setOnClickListener(this);
}
    private void location() {
        listitems = getResources().getStringArray(R.array.Location);
        checkitems = new boolean[listitems.length];


        AlertDialog.Builder mbuilder = new AlertDialog.Builder(Find_Jobs.this);
        mbuilder.setTitle("Location");
        mbuilder.setMultiChoiceItems(listitems, checkitems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    if (!mUseritems.contains(which)) {
                        mUseritems.add(which);
                        //selected.add(listitems[which]);
                        l=listitems[which];
                    } else {
                        mUseritems.remove(which);
                        selected.remove(which);
                    }
                }

            }
        });
        mbuilder.setCancelable(false);
        mbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = "";
                for (int i = 0; i < mUseritems.size(); i++) {
                    item = item + listitems[mUseritems.get(i)];
                    if (i != mUseritems.size() - 1) {
                        item = item + ";";
                    }
                }
            }
        });
        mbuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();


            }
        });
        mbuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                for (int i = 0; i < checkitems.length; i++) {
                    checkitems[i] = false;
                    mUseritems.clear();

                }

            }
        });
        AlertDialog mDialog = mbuilder.create();
        mDialog.show();
    }
    private void designation() {
        listitems = getResources().getStringArray(R.array.designation_array);
        checkitems = new boolean[listitems.length];


        AlertDialog.Builder mbuilder = new AlertDialog.Builder(Find_Jobs.this);
        mbuilder.setTitle("Designation");
        mbuilder.setMultiChoiceItems(listitems, checkitems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    if (!cUseritems.contains(which)) {
                        cUseritems.add(which);
                       // choose.add(listitems[which]);
                        d=listitems[which];
                    } else {
                        cUseritems.remove(which);
                        choose.remove(which);
                    }
                }

            }
        });
        mbuilder.setCancelable(false);
        mbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = "";
                for (int i = 0; i < cUseritems.size(); i++) {
                    item = item + listitems[cUseritems.get(i)];
                    if (i != cUseritems.size() - 1) {
                        item = item + ";";
                    }
                }
            }
        });
        mbuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();


            }
        });
        mbuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                for (int i = 0; i < checkitems.length; i++) {
                    checkitems[i] = false;
                    cUseritems.clear();

                }

            }
        });
        AlertDialog mDialog = mbuilder.create();
        mDialog.show();
    }
    private void jobtype() {
        listitems = getResources().getStringArray(R.array.type);
        checkitems = new boolean[listitems.length];


        AlertDialog.Builder mbuilder = new AlertDialog.Builder(Find_Jobs.this);
        mbuilder.setTitle("JobType");
        mbuilder.setMultiChoiceItems(listitems, checkitems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    if (!tUseritems.contains(which)) {
                        tUseritems.add(which);
                       // sel.add(listitems[which]);
                        t=listitems[which];
                    } else {
                        tUseritems.remove(which);
                       sel.remove(which);
                    }
                }

            }
        });
        mbuilder.setCancelable(false);
        mbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = "";
                for (int i = 0; i < tUseritems.size(); i++) {
                    item = item + listitems[tUseritems.get(i)];
                    if (i != tUseritems.size() - 1) {
                        item = item + ";";
                    }
                }
            }
        });
        mbuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();


            }
        });
        mbuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                for (int i = 0; i < checkitems.length; i++) {
                    checkitems[i] = false;
                    tUseritems.clear();

                }

            }
        });
        AlertDialog mDialog = mbuilder.create();
        mDialog.show();
    }


    private void submit() {

        mJobs = new ArrayList<Job>();
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        ElasticSearchAPI searchAPI = retrofit.create(ElasticSearchAPI.class);

        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", Credentials.basic("user","ZGZWT9obsr1Y"));

        String searchString = "*";
        searchString = searchString + " qualification:" + "undegraduate";
        searchString = searchString + " loc:" + "anupshahr";
        searchString = searchString + " desg:" + "web";
        searchString = searchString + " type:" + "internship";

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


    }



    @Override
    public void onClick(View v) {
        if(v == clocation)
            location();
        if(v == search)
            submit();
        if(v==ctype)
            jobtype();
        if(v==cdesignation)
            designation();
    }


}

