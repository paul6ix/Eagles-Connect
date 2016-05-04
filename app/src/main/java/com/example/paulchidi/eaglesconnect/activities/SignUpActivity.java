package com.example.paulchidi.eaglesconnect.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.paulchidi.eaglesconnect.EagleKinvey;
import com.example.paulchidi.eaglesconnect.R;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;

public class SignUpActivity extends AppCompatActivity {
    protected EditText etUsername;
    protected EditText etEmail;
    protected EditText etPassword;
    protected EditText etPhone;
    protected EditText etBirthday;
    protected EditText etGradYear;
    protected Button btnSignUp;
    protected Client EagleUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EagleUser = ((EagleKinvey) getApplication()).getmKinveyClient();

        etEmail = (EditText) findViewById(R.id.editText_email);
        etUsername = (EditText) findViewById(R.id.editText_username);
        etPassword = (EditText) findViewById(R.id.editText_password);
        etPhone = (EditText) findViewById(R.id.editText_phone);
        etBirthday = (EditText) findViewById(R.id.editText_birthday);
        etGradYear = (EditText) findViewById(R.id.editText_gradyear);
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
        String password = etPassword.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();
        final String birthday = etPhone.getText().toString().trim();
        final String gradyear = etGradYear.getText().toString().trim();


        final String email = etEmail.getText().toString().trim();
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty() || birthday.isEmpty() || gradyear.isEmpty()) {
            alertInfo();
        } else {


            EagleUser.user().create(username, password, new KinveyUserCallback() {
                @Override
                public void onSuccess(User user) {
                    user.put("Email address", email);
                    user.put("Phone", phone);
                    user.put("Birthday", birthday);
                    user.put("gradyear", gradyear);
                    Intent intentLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                    intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentLogin);
                    EagleUser.user().logout().execute();

                }

                @Override
                public void onFailure(Throwable throwable) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(R.string.toast_signUp_msg)
                .setTitle("Information")
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
