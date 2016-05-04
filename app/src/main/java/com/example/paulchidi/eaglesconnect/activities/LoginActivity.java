package com.example.paulchidi.eaglesconnect.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.paulchidi.eaglesconnect.EagleKinvey;
import com.example.paulchidi.eaglesconnect.R;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;

public class LoginActivity extends AppCompatActivity {
    protected TextView etSignup_link;
    protected EditText etUsername;
    protected EditText etPassword;
    protected Button btnLogin;
    protected Client mKinveyClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mKinveyClient = ((EagleKinvey) getApplication()).getmKinveyClient();

        //Declaration
        etUsername = (EditText) findViewById(R.id.editText_username);
        etPassword = (EditText) findViewById(R.id.editText_password);
        btnLogin = (Button) findViewById(R.id.button_login);


        etSignup_link = (TextView) findViewById(R.id.textView_signup_link);
        etSignup_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);


            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });

    }

    public void login() {


        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();


        if (username.isEmpty() || password.isEmpty()) {
            alertInfo();
        } else {
            mKinveyClient.user().login(username, password, new KinveyUserCallback() {
                @Override
                public void onSuccess(User user) {
                        Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentMain);

                }

                @Override
                public void onFailure(Throwable throwable) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(throwable.getMessage())
                                .setTitle("Information")
                                .setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();

                }
            });
        }


    }


    public void alertInfo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(R.string.toast_login_msg)
                .setTitle("Information")
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
