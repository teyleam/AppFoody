package com.aplication.appfoody.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aplication.appfoody.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    public String TAG = "lam";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}