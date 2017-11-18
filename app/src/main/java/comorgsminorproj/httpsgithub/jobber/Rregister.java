package comorgsminorproj.httpsgithub.jobber;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import java.util.concurrent.Executor;

/**
 * Created by MK on 17-11-2017.
 */

public class Rregister extends Fragment {

    private EditText recruiter;
    private EditText rname;
    private EditText remail;
    private EditText rphone;
    private EditText rpassword;
    private EditText raddress;
    private Button rregister;

    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.r_register,container,false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        progressDialog = new ProgressDialog(getActivity());

        recruiter = (EditText) view.findViewById(R.id.recruiter);
        raddress = (EditText) view.findViewById(R.id.raddress);
        rphone = (EditText) view.findViewById(R.id.rphone);
        remail = (EditText) view.findViewById(R.id.remail);
        rname = (EditText) view.findViewById(R.id.rname);
        rpassword = (EditText) view.findViewById(R.id.rpassword);
        rregister = (Button) view.findViewById(R.id.rregister);

        rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rregister();
            }
        });

        return view;
    }

    private void rregister(){
        final String email = remail.getText().toString().trim();
        final String password = rpassword.getText().toString().trim();
        final String name = rname.getText().toString().trim();
        final String mobile = rphone.getText().toString();
        final String rec = recruiter.getText().toString().trim();
        final  String radd = raddress.getText().toString();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "Please enter email !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "Please enter password !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getActivity(), "Please enter HR Representative name !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(rec)) {
            Toast.makeText(getActivity(), "Please enter Recruiter name !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(radd)) {
            Toast.makeText(getActivity(), "Please enter Recruiter address !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(getActivity(), "Please enter HR Representative name !", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering Recruiter ...");
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
                                                    Toast.makeText(getActivity(), "Verification Email Sent", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                            }
                            writeRecruiter(rec,radd,mobile,email,name,password);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Unsuccessful. Please try again !", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

    private void writeRecruiter(String rec,String radd,String rphone,String remail,String rname,String rpassword)
    {
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            String userID = user.getUid();
            Rprofile rprofile = new Rprofile(rec,radd,rphone,remail,rname,rpassword);
            mDatabase.child("recruiter").child(userID).setValue(rprofile);
        }
    }


}
