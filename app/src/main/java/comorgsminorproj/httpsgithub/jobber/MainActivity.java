package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.candidatebt);
        bt2 = (Button) findViewById(R.id.recruiterbt);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == bt1){
            finish();
            startActivity(new Intent(MainActivity.this,Candidate.class));
        }
        if(v == bt2){
            finish();
            startActivity(new Intent(MainActivity.this,Recruiter.class));
        }
    }
}
