package com.example.jay.cs377project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class viewReview extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    ReviewDBHelper reviewDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_review_list);
        listView = (ListView) findViewById(R.id.reviews_list_rl);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.review_layout_close);
        reviewDBHelper = new ReviewDBHelper(getApplicationContext());
        sqLiteDatabase = reviewDBHelper.getReadableDatabase();
        cursor = reviewDBHelper.getReviews(sqLiteDatabase);

        if(cursor.moveToFirst()){


            do{

                String title, category, rating, review;
                title = cursor.getString(0);
                category = cursor.getString(1);
                rating = cursor.getString(2);
                review = cursor.getString(3);
                DataProvider dataProvider = new DataProvider(title, category, rating, review);
                listDataAdapter.add(dataProvider);




            }while(cursor.moveToNext());
















        }



    }
}
