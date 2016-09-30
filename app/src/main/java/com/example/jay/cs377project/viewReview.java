package com.example.jay.cs377project;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.LocaleDisplayNames;
import android.icu.util.ULocale;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Text;

import java.util.List;

public class viewReview extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    ReviewDBHelper reviewDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_review_list);
        listView = (ListView) findViewById(R.id.reviews_list_rl);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
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

        listView.setOnItemClickListener(new ItemList());

    }

    public void goToClose(View view){
        Intent intent = new Intent(this, data_cube.class);
        startActivity(intent);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showSortOptions(View view){
        AlertDialog.Builder showSortWindow = new AlertDialog.Builder(this);

        showSortWindow.setMessage("How would you like to sort this list?")
                .setNeutralButton("Category", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listView = (ListView) findViewById(R.id.reviews_list_rl);
                        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
                        listView.setAdapter(listDataAdapter);
                        reviewDBHelper = new ReviewDBHelper(getApplicationContext());
                        sqLiteDatabase = reviewDBHelper.getReadableDatabase();
                        cursor = reviewDBHelper.getReviewsSortByCategory(sqLiteDatabase);

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

                        listView.setOnItemClickListener(new ItemList());




                    }
                })
                .setPositiveButton("Rating", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listView = (ListView) findViewById(R.id.reviews_list_rl);
                        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
                        listView.setAdapter(listDataAdapter);
                        reviewDBHelper = new ReviewDBHelper(getApplicationContext());
                        sqLiteDatabase = reviewDBHelper.getReadableDatabase();
                        cursor = reviewDBHelper.getReviewsSortByRating(sqLiteDatabase);

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

                        listView.setOnItemClickListener(new ItemList());






                    }
                });


            showSortWindow.show();

        }






    public class ItemList implements AdapterView.OnItemClickListener  {


       TextView title, category, rating, review;
       String sTitle, sCategory, sRating, sReview;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Object  o = listView.getItemAtPosition(position);
            ViewGroup viewGroup = (ViewGroup) view;
            title = (TextView) viewGroup.findViewById(R.id.title_RL);
            category = (TextView) viewGroup.findViewById(R.id.category_RL);
            rating = (TextView) viewGroup.findViewById(R.id.rating_RL);
            review = (TextView) viewGroup.findViewById(R.id.review_RL);
            sTitle = title.getText().toString();
            sCategory = category.getText().toString();
            sRating = rating.getText().toString();
            sReview = review.getText().toString();

            setTitle(title.getText());
            setCategory(category.getText());
            setRating(rating.getText());
            setReview(review.getText());

            goToClose(listView);

        }


    }


    static CharSequence title, category, rating, review;

    public void setTitle(CharSequence title) {
        this.title = title;
    }

    public CharSequence getTitleCS() {
        return title;
    }

    public CharSequence getCategory() {
        return category;
    }

    public void setCategory(CharSequence category) {
        this.category = category;
    }

    public CharSequence getRating() {
        return rating;
    }

    public void setRating(CharSequence rating) {
        this.rating = rating;
    }

    public CharSequence getReview() {
        return review;
    }

    public void setReview(CharSequence review) {
        this.review = review;
    }
}
