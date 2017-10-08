package comorgsminorproj.httpsgithub.jobber;

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
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity  implements View.OnClickListener {

    private EditText uname;
    private EditText uemail;
    private EditText umobile;
    private EditText upassword;
    private Button uregister;

    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        uname = (EditText) findViewById(R.id.name);
        uemail = (EditText) findViewById(R.id.email);
        umobile = (EditText) findViewById(R.id.mobile);
        upassword = (EditText) findViewById(R.id.password);
        uregister = (Button) findViewById(R.id.register);

        uregister.setOnClickListener(this);
    }
        private void register() {

            String email = uemail.getText().toString().trim();
            String password = upassword.getText().toString().trim();
            String name = uname.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email !", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter your password !", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Please enter your name !", Toast.LENGTH_SHORT).show();
                return;
            }

            progressDialog.setMessage("Registering User ...");
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                user.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(Register.this, "Verification Email Sent", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(Register.this, "Unsuccessful. Please try again !", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
        }



    @Override
    public void onClick(View v) {
                if(v == uregister)
                    register();
    }


}
