package com.example.przemek.picturequiz.database;

import android.provider.BaseColumns;

/**
 * Created by Przemek on 30.05.2017.
 */
public class HighscoreEntry {

    private HighscoreEntry() {}

    /* Inner class that defines the table contents */
    public static class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "Highscore";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_Score = "Score";
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + HighscoreEntry.DatabaseEntry.TABLE_NAME + " (" +
                    HighscoreEntry.DatabaseEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    HighscoreEntry.DatabaseEntry.COLUMN_NAME + " TEXT," +
                    HighscoreEntry.DatabaseEntry.COLUMN_Score + " INTEGER)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HighscoreEntry.DatabaseEntry.TABLE_NAME;
}

