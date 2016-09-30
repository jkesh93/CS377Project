package com.example.jay.cs377project;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class data_cube extends AppCompatActivity {
    TextView dcTitle, dcCat, dcRat, dcRev;
    viewReview viewReview = new viewReview();
    ReviewDBHelper reviewDBHelper;
    SQLiteDatabase sqLiteDatabase;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_cube);

        dcTitle = (TextView) findViewById(R.id.title_data_cube);
        dcCat = (TextView) findViewById(R.id.category_data_cube);
        dcRat = (TextView) findViewById(R.id.rating_data_cube);
        dcRev = (TextView) findViewById(R.id.review_data_cube);

        dcTitle.setText(viewReview.getTitleCS());
        dcCat.setText(viewReview.getCategory());
        dcRat.setText(viewReview.getRating());
        dcRev.setText(viewReview.getReview());





    }


    public void deleteRow(View view){
        Intent intent = new Intent(this, viewReview.class);
        intent.putExtra("KEY", dcTitle.getText().toString());
        startActivity(intent);
    }
}
