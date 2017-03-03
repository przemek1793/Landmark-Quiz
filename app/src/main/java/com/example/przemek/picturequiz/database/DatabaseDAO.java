package com.example.przemek.picturequiz.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Przemek on 14.02.2017.
 */

public class DatabaseDAO
{
    private SQLiteDatabase database;
    private LandmarkDatabaseHandler dbHelper;
    private String[] allColumns = { LandmarkDatabaseHandler.COLUMN_ID,
            LandmarkDatabaseHandler.COLUMN_PICTURE,
            LandmarkDatabaseHandler.COLUMN_ANSWER1,
            LandmarkDatabaseHandler.COLUMN_ANSWER2,
            LandmarkDatabaseHandler.COLUMN_ANSWER3,
            LandmarkDatabaseHandler.COLUMN_ANSWER4,
            LandmarkDatabaseHandler.COLUMN_CORRECTANSWER};

    public DatabaseDAO(Context context) {
        dbHelper = new LandmarkDatabaseHandler(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}
