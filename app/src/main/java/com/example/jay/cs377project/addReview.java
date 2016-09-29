package com.example.jay.cs377project;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addReview extends AppCompatActivity {
    EditText revTitle, revCat, revRat, revRev;
    Context context = this;
    ReviewDBHelper reviewDBHelper;
    SQLiteDatabase sqLiteDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        revTitle = (EditText) findViewById(R.id.title_AR);
        revCat = (EditText) findViewById(R.id.category_AR);
        revRat = (EditText) findViewById(R.id.rating_AR);
        revRev = (EditText) findViewById(R.id.review_AR);

    }

    public void insertReview(View view){

        String title = revTitle.getText().toString();
        String category = revCat.getText().toString();
        String rating = revRat.getText().toString();
        String review = revRev.getText().toString();


        reviewDBHelper = new ReviewDBHelper(context);
        sqLiteDatabase = reviewDBHelper.getWritableDatabase();
        reviewDBHelper.insertReview(title, category, rating, review, sqLiteDatabase);

        Toast.makeText(getBaseContext(), "Your review was added!", Toast.LENGTH_LONG).show();
        reviewDBHelper.close();

    }


    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
