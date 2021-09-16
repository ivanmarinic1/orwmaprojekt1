package com.example.orwmaprojekt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener {

    String userName;
    String userPassword;
    /* Define the UI elements */
    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;
    private Button btnExit;
    private int counter = 5;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /* Bind the XML views to Java Code Elements */
        eName = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.buttonLogin);
        eAttemptsInfo = findViewById(R.id.tvAttempts);
        btnExit = findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(this);
        eLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View view) {
        String name = eName.getText().toString();
        String password = ePassword.getText().toString();
        switch (view.getId()) {
            case R.id.buttonLogin:
                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                } else {
                    mAuth.signInWithEmailAndPassword(name, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent(login.this, pocetna.class));
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }
                break;
            case R.id.buttonExit:
                finish();
                break;
        }
    }
}





/* Validate the credentials */
