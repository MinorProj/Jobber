package comorgsminorproj.httpsgithub.jobber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AddJobs extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jobs);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.designation);
        String[] array = getResources().getStringArray(R.array.designation_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        textView.setAdapter(adapter);
    }



}
