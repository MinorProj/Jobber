package comorgsminorproj.httpsgithub.jobber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;

public class AddJobs extends AppCompatActivity {

    Button mlocation;
    String[] listitems;
    boolean[] checkitems;
    ArrayList<Integer> mUseritems =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jobs);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.designation);
        String[] array = getResources().getStringArray(R.array.designation_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        textView.setAdapter(adapter);

        mlocation=(Button)findViewById(R.id.location_id);
        listitems=getResources().getStringArray(R.array.Location);
        checkitems=new boolean[listitems.length];
        mlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(AddJobs.this);
                mbuilder.setTitle("Location");
                mbuilder.setMultiChoiceItems(listitems, checkitems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if(isChecked){
                            if(! mUseritems.contains(which)){
                                mUseritems.add(which);
                            }else{
                                mUseritems.remove(which);

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
                        for(int i=0;i< checkitems.length;i++){
                            checkitems[i]=false;
                            mUseritems.clear();

                        }

                    }
                });
                AlertDialog mDialog=mbuilder.create();
                mDialog.show();

            }
        });
    }
    }




