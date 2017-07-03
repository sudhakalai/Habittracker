package com.example.android.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.WalkingContract.WalkingEntry;

/**
 * Created by Sudha on 30-Jun-17.
 */

public class WalkingDbHelper extends SQLiteOpenHelper {

    //Global variable declaration
    public static String DATABASE_NAME ="WalkingTracker.db";
    public static int DATABASE_VERSION = 1;


    //Constructor declaration
    public WalkingDbHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creates the walking table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_QUERY = "CREATE TABLE "+ WalkingEntry.TABLE_NAME+"( "
                +WalkingEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT , "
                +WalkingEntry.COLUMN_WALKING_DATE +" TEXT NOT NULL , "
                +WalkingEntry.COLUMN_WALKING_DISTANCE + " TEXT NOT NULL , "
                +WalkingEntry.COLUMN_WALKING_TIME + " TEXT , "
                +WalkingEntry.COLUMN_CALORIES + " TEXT)";

        db.execSQL(SQL_CREATE_QUERY);

    }

    //Overriding the OnUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
