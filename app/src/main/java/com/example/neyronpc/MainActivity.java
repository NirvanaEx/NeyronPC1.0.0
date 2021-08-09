package com.example.neyronpc;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent authorization = new Intent(MainActivity.this, AuthorizationActivity.class);
                startActivity(authorization);
                finish();
            }
        },1);

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager()
                .popBackStack();
    }
}