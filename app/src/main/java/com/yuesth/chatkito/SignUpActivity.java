package com.yuesth.chatkito;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity {

    Typeface typeface1;
    TextView namaLogoSignUp;
    EditText usernameInput;
    EditText emailInput;
    EditText passwordInput;
    Button btnSignUp;
    TextView goToLogIn;
    TextView forgotPassword;
    FirebaseAuth auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Set fonts nama logo
        namaLogoSignUp = (TextView) findViewById(R.id.namalogo_signup);
        typeface1 = Typeface.createFromAsset(getAssets(),"fonts/Pacifico-Regular.ttf");
        namaLogoSignUp.setTypeface(typeface1);

        //instanisasi elemen
        usernameInput = (EditText) findViewById(R.id.username_signup);
        emailInput = (EditText) findViewById(R.id.email_signup);
        passwordInput = (EditText) findViewById(R.id.password_signup);
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        goToLogIn = (TextView) findViewById(R.id.gotologin_sigup);

        //instanisasi firebase authentication
        auth = FirebaseAuth.getInstance();

        //cek jika akun masih log in
        if(auth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });

        goToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }

    public void SignUp(){
        String username  =usernameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        progressDialog.setMessage("Log In Please wait...");
        progressDialog.show();

        //Checking with email problem
        if(TextUtils.isEmpty(email)){
            progressDialog.dismiss();
            emailInput.setError("Email is required");
            emailInput.requestFocus();
//            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
//            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            progressDialog.dismiss();
            emailInput.setError("Please enter a valid email");
            emailInput.requestFocus();
        }

        //checking with password problem
        if(TextUtils.isEmpty(password)) {
            progressDialog.dismiss();
            passwordInput.setError("Please enter correct password");
            passwordInput.requestFocus();
        }

        if(password.length() <6) {
            progressDialog.dismiss();
            passwordInput.setError("enter password more than 6 characters");
            passwordInput.requestFocus();
        }


        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    userProfile();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void userProfile(){
        FirebaseUser user = auth.getCurrentUser();
        if(user != null){
            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(usernameInput.getText().toString()
                                                            .trim()).build();
            user.updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Profile terdaftar!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
