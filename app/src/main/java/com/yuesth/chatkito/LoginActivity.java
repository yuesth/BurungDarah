package com.yuesth.chatkito;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity  {

    Typeface typeface;
    TextView namaLogoLogin;
    EditText emailInput;
    EditText passwordInput;
    Button btnLogin;
    TextView goToSignUp;
    TextView forgotPassword;
    FirebaseAuth auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set fonts nama logo
        namaLogoLogin = (TextView) findViewById(R.id.namalogo_login);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/Pacifico-Regular.ttf");
        namaLogoLogin.setTypeface(typeface);

        //instanisasi elemen
        emailInput = (EditText) findViewById(R.id.email_login);
        passwordInput = (EditText) findViewById(R.id.password_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        goToSignUp = (TextView) findViewById(R.id.gotosignup_login);

        //instanisasi firebase authentication
        auth = FirebaseAuth.getInstance();

        //cek jika akun masih log in
        if(auth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

       goToSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
           }
       });

    }

    public void logIn(){
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


        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
