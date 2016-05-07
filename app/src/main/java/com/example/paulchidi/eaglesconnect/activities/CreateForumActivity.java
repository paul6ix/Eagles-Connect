package com.example.paulchidi.eaglesconnect.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulchidi.eaglesconnect.R;

public class CreateForumActivity extends AppCompatActivity {
    Button btnCreate;
    Button btnCancel;
    EditText etForumName;
    EditText etAboutforum;
    EditText etForumEmail;
    EditText etForumWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_forum);
        btnCreate = (Button) findViewById(R.id.button_create_f);
        btnCancel = (Button) findViewById(R.id.button_cancel);
        etForumName = (EditText) findViewById(R.id.editText_forum_name);
        etAboutforum = (EditText) findViewById(R.id.editText_about_forum);
        etForumEmail = (EditText) findViewById(R.id.editText_email);
        etForumWebsite = (EditText) findViewById(R.id.editText_forum_website);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String forumName = etForumName.getText().toString();
                String Aboutforum = etAboutforum.getText().toString();
                String forumEmail = etAboutforum.getText().toString();
                String forumWeb = etAboutforum.getText().toString();
                if (forumName.isEmpty() || Aboutforum.isEmpty() || forumEmail.isEmpty() || forumWeb.isEmpty()) {
                    alertInfo();


                } else {
                    Toast.makeText(CreateForumActivity.this, "Your Forum " + forumName + " has been created", Toast.LENGTH_LONG).show();
                    finish();

                }
            }
        });
btnCancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
    }
    public void alertInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateForumActivity.this);
        builder.setMessage(R.string.toast_signUp_msg)
                .setTitle("Information")
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
