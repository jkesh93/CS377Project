package com.example.jay.cs377project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Jay on 9/29/2016.
 */

public class data_cube_adapter extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_cube);
        viewReview viewreview = new viewReview();
        TextView dc_title, dc_category, dc_rating, dc_review;

        dc_title = (TextView) findViewById(R.id.title_data_cube);
        dc_category = (TextView) findViewById(R.id.category_data_cube);
        dc_rating = (TextView) findViewById(R.id.rating_data_cube);
        dc_review = (TextView) findViewById(R.id.review_data_cube);

        dc_title.setText(viewreview.getRTitle());
        dc_category.setText(viewreview.getCategory());
        dc_rating.setText(viewreview.getRating());
        dc_review.setText(viewreview.getReview());
    }





}
