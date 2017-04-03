package com.example.przemek.picturequiz.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.przemek.picturequiz.database.DatabaseReaderEntry.SQL_CREATE_ENTRIES;
import static com.example.przemek.picturequiz.database.DatabaseReaderEntry.SQL_DELETE_ENTRIES;

/**
 * Created by Przemek on 05.02.2017.
 */

public class LandmarkDatabaseHandler extends SQLiteOpenHelper
{

    // database constants
    private static String DB_NAME = "LandmarkDB";
    private static final int DB_VERSION = 1;

    public LandmarkDatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String[] getRandomRow() {

        final String TABLE_NAME = "QuestionTable";
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 1;"; // select random row from database
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String [] answer= new String[cursor.getColumnCount()];
        if(cursor.moveToFirst()){
            for (int j=0;j<cursor.getColumnCount();j++)
            {
                answer[j]=cursor.getString(j);
            }
        }
        cursor.close();
        return answer;
    }

}
