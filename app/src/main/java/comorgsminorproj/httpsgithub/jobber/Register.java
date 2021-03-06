package comorgsminorproj.httpsgithub.jobber;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends Fragment implements View.OnClickListener {

    private EditText uname;
    private EditText uemail;
    private EditText umobile;
    private EditText upassword;
    private Button uregister;

    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register,container,false);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        progressDialog = new ProgressDialog(getActivity());

        uname = (EditText) view.findViewById(R.id.name);
        uemail = (EditText) view.findViewById(R.id.email);
        umobile = (EditText) view.findViewById(R.id.mobile);
        upassword = (EditText) view.findViewById(R.id.password);
        uregister = (Button) view.findViewById(R.id.register);

        uregister.setOnClickListener(this);


        return view;
    }

    private void register() {

        final String email = uemail.getText().toString().trim();
        String password = upassword.getText().toString().trim();
        final String name = uname.getText().toString().trim();
        final String mobile = umobile.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "Please enter email !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "Please enter password !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getActivity(), "Please enter your name !", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User ...");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user != null) {
                                user.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(getActivity(), "Email Sent", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                            }
                            writeUser(name,email,mobile);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Unsuccessful. Please try again !", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

    private void writeUser(String name,String email,String mobile)
    {
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            String userID = user.getUid();
            Users uInfo = new Users(name, email, mobile);
            mDatabase.child("users").child(userID).setValue(uInfo);
        }
    }

    @Override
    public void onClick(View v) {
        if(v == uregister)
            register();

    }


}
