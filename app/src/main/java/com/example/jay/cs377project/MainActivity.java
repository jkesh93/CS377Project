package com.example.jay.cs377project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addReview(View view){
        Intent intent = new Intent(this, addReview.class);
        startActivity(intent);
    }

    public void viewReview(View view){
        Intent intent = new Intent(this, viewReview.class);
        startActivity(intent);
    }
}
