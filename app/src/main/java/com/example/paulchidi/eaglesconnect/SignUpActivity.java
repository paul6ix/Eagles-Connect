package com.example.paulchidi.eaglesconnect;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    protected EditText etUsername;
    protected EditText etEmail;
    protected EditText etPassword;
    protected Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail = (EditText) findViewById(R.id.editText_email);
        etUsername = (EditText) findViewById(R.id.editText_username);
        etPassword = (EditText) findViewById(R.id.editText_password);
        btnSignUp = (Button) findViewById(R.id.button_signUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();

            }
        });

    }

    public void signup() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            alertInfo();

        } else {
            ParseUser newUser = new ParseUser();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {
                        Intent intentLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                        intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentLogin);
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        builder.setMessage(e.getMessage())
                                .setTitle("Information")
                                .setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();


                    }
                }
            });
        }

    }

    public void alertInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(R.string.toast_signUp_msg)
                .setTitle("Information")
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
