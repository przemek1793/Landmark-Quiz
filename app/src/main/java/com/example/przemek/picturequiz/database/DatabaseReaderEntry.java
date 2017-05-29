package com.example.przemek.picturequiz.database;

import android.provider.BaseColumns;

/**
 * Created by Przemek on 05.02.2017.
 */

public final class DatabaseReaderEntry {

    private DatabaseReaderEntry() {}

    /* Inner class that defines the table contents */
    public static class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "QuestionTable";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PICTURE = "PICTURE";
        public static final String COLUMN_ANSWER1 = "ANSWER1";
        public static final String COLUMN_ANSWER2 = "ANSWER2";
        public static final String COLUMN_ANSWER3 = "ANSWER3";
        public static final String COLUMN_ANSWER4 = "ANSWER4";
        public static final String COLUMN_CORRECTANSWER = "CORRECT_ANSWER";
        public static final String COLUMN_ALREADY_USED = "ALREADY_USED";
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseEntry.TABLE_NAME + " (" +
                    DatabaseEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    DatabaseEntry.COLUMN_PICTURE + " TEXT," +
                    DatabaseEntry.COLUMN_ANSWER1 + " TEXT," +
                    DatabaseEntry.COLUMN_ANSWER2 + " TEXT," +
                    DatabaseEntry.COLUMN_ANSWER3 + " TEXT," +
                    DatabaseEntry.COLUMN_ANSWER4 + " TEXT," +
                    DatabaseEntry.COLUMN_ALREADY_USED + " INTEGER," +
                    DatabaseEntry.COLUMN_CORRECTANSWER + " INTEGER)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseEntry.TABLE_NAME;
}