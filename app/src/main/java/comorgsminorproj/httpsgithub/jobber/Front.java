package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Front extends AppCompatActivity {
    private static  int  SPLASH_TIME_OUT=2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent i=new Intent(Front.this,MainActivity.class);
                startActivity(i);
            }

            },SPLASH_TIME_OUT);

        }
}
