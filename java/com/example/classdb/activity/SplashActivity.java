package com.example.classdb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classdb.R;

public class SplashActivity extends AppCompatActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

//image will grow from 0.1f to 1f while rotating/alpha transitions the color from transparent to actual color
        iv = findViewById(R.id.iv);
        iv.animate()
                .rotation(360f)
                .scaleY(1f).scaleX(1f)
                .alpha(1f)
                .setDuration(2000);

//use thread to show logo for 2 seconds and then run the actual app
        Thread t = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            startActivity(new Intent(SplashActivity.this,AddStudentActivity.class));

                            finish();// we dont need to display first image again
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t.start();
    }
}