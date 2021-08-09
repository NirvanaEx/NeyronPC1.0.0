package com.example.neyronpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.neyronpc.authorization_fragments.SingInFragment;

public class AuthorizationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        int AuthorizationFragment =  R.id.autorization_fragment_layout;

        SingInFragment singInFragment = new SingInFragment();
        getSupportFragmentManager().beginTransaction().add(AuthorizationFragment,singInFragment).commit();

    }
}