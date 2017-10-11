package comorgsminorproj.httpsgithub.jobber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Resume extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        mAuth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.btLogout);
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Login.class));
        }

        logout.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == logout){
            mAuth.signOut();
            finish();
            startActivity(new Intent(this,Login.class));
        }
    }
}