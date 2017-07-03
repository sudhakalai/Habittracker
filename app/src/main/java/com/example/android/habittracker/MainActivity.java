package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittracker.WalkingContract.WalkingEntry;

public class MainActivity extends AppCompatActivity {

    //global variable declaration
    private WalkingDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertWalkingData();
        readWalkingData();
    }

    // Inserts a value to the walking table
    public void insertWalkingData() {

        mDbHelper = new WalkingDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WalkingEntry.COLUMN_WALKING_DATE, "26-01-2017");
        values.put(WalkingEntry.COLUMN_WALKING_DISTANCE, "7");
        values.put(WalkingEntry.COLUMN_WALKING_TIME, "06:00");
        values.put(WalkingEntry.COLUMN_CALORIES, "200");

        long newRowId = db.insert(WalkingEntry.TABLE_NAME, null, values);

        //Log message is printed to the logcat
        if (newRowId == -1) {
            Log.v("MainActivity", "Error insert data into the table");
        } else {
            Log.v("MainActivity", "Successfully inserted data into the table");
        }
    }

    //Reads the line inserted by the insertWalkingData method
    public void readWalkingData() {
        mDbHelper = new WalkingDbHelper(this);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {WalkingEntry._ID, WalkingEntry.COLUMN_WALKING_DATE,
                WalkingEntry.COLUMN_WALKING_DISTANCE, WalkingEntry.COLUMN_WALKING_TIME, WalkingEntry.COLUMN_CALORIES};

        Cursor c = db.query(WalkingEntry.TABLE_NAME, projection, null, null, null, null, null);

        c.moveToNext();

        //Log message is printed to the logcat
        Log.v("MainActivity", "Cursor contents:\n" + c.getInt(c.getColumnIndex(WalkingEntry._ID))
                + " - " + c.getString(c.getColumnIndex(WalkingEntry.COLUMN_WALKING_DATE))
                + " - " + c.getString(c.getColumnIndex(WalkingEntry.COLUMN_WALKING_DISTANCE))
                + " - " + c.getString(c.getColumnIndex(WalkingEntry.COLUMN_WALKING_TIME))
                + " - " + c.getString(c.getColumnIndex(WalkingEntry.COLUMN_CALORIES)));

        c.close();
    }
}
