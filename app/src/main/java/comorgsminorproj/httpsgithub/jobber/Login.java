package comorgsminorproj.httpsgithub.jobber;

/**
 * Created by MK on 03-10-2017.
 */

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText emailid;
    private  EditText passwd;
    private Button login;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    progressDialog = new ProgressDialog(this);
    mAuth = FirebaseAuth.getInstance();

    emailid = (EditText)findViewById(R.id.lemail);
    passwd = (EditText) findViewById(R.id.lpassword);
    login = (Button) findViewById(R.id.login);

    }

    private void loginUser(){

        String email = emailid.getText().toString().trim();
        String password = passwd.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password !", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging In ...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v == login)
            loginUser();
    }
}
