package com.example.paulchidi.eaglesconnect;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.TextView;


public class SplashActivity extends Activity {
    protected TextView splashText;
    protected View splashLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation animateText = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splashtext);
        splashText = (TextView) findViewById(R.id.textView);
        splashText.startAnimation(animateText);
        splashLayout = findViewById(R.id.splashlayout);
        splashLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
                intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLogin);
            }


        });


    }


}


