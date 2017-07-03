package com.example.android.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Sudha on 30-Jun-17.
 */

public final class WalkingContract {

    private WalkingContract(){}

    //Column values

    public static abstract class WalkingEntry implements BaseColumns {

        public static String _ID = "_id";
        public static String COLUMN_WALKING_DATE = "date";
        public static String COLUMN_WALKING_DISTANCE = "distance";
        public static String COLUMN_WALKING_TIME = "time";
        public static String COLUMN_CALORIES = "calories";
        public static String TABLE_NAME = "walking";
    }
}
