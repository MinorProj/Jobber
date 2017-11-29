package comorgsminorproj.httpsgithub.jobber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD:app/src/main/java/comorgsminorproj/httpsgithub/jobber/Splash.java
public class Splash extends Activity {
    private static int SPLASH_TIME_OUT = 2000;
=======
public class Front extends AppCompatActivity {
    private static  int  SPLASH_TIME_OUT=2000;
>>>>>>> jobber2 updated:app/src/main/java/comorgsminorproj/httpsgithub/jobber/Front.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/comorgsminorproj/httpsgithub/jobber/Splash.java
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

                }

            }


=======
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
>>>>>>> jobber2 updated:app/src/main/java/comorgsminorproj/httpsgithub/jobber/Front.java
