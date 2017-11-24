package comorgsminorproj.httpsgithub.jobber;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Find_Jobs extends  AppCompatActivity implements View.OnClickListener{

    Button cdesignation;
    Button clocation;
    Button ctype;
    Button search;
    String[] listitems;
    boolean[] checkitems;
    ArrayList<Integer> mUseritems = new ArrayList<>();
    final ArrayList<String> selected = new ArrayList<>();
    ArrayList<Integer> cUseritems = new ArrayList<>();
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

   clocation.setOnClickListener(this);
    search.setOnClickListener(this);
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
                        selected.add(listitems[which]);
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
                        choose.add(listitems[which]);
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
                    mUseritems.clear();

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
                        sel.add(listitems[which]);
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

        Find f = new Find(choose,sel,selected);


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

