package com.example.jay.cs377project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jay on 9/28/2016.
 */

public class ReviewDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Reviews.db";
    private static final int DATABASE_VERSIONS = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ ReviewContract.ReviewInfo.TABLE_NAME + " ("
            + ReviewContract.ReviewInfo.REVIEW_TITLE + " TEXT," + ReviewContract.ReviewInfo.REVIEW_CATEGORY +
                    " TEXT," +  ReviewContract.ReviewInfo.REVIEW_RATING + " TEXT," + ReviewContract.ReviewInfo.REVIEW_REVIEW + " TEXT);";

    public ReviewDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSIONS);
        Log.e("DATABASE NOTIFICATION", "Super class exec successfully");

    }



    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE NOTIFICATION", " TABLE CREATED");
    }

    public void insertReview(String title, String category, String rating, String review, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ReviewContract.ReviewInfo.REVIEW_TITLE, title);
        contentValues.put(ReviewContract.ReviewInfo.REVIEW_CATEGORY, category);
        contentValues.put(ReviewContract.ReviewInfo.REVIEW_RATING, rating);
        contentValues.put(ReviewContract.ReviewInfo.REVIEW_REVIEW, review);

        db.insert(ReviewContract.ReviewInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE NOTIFICATION", " One Row has been added");
    }


    public Cursor getReviews(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {ReviewContract.ReviewInfo.REVIEW_TITLE, ReviewContract.ReviewInfo.REVIEW_CATEGORY, ReviewContract.ReviewInfo.REVIEW_RATING, ReviewContract.ReviewInfo.REVIEW_REVIEW};
        cursor = db.query(ReviewContract.ReviewInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
