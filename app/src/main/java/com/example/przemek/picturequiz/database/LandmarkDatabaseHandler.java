package com.example.przemek.picturequiz.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Przemek on 05.02.2017.
 */

public class LandmarkDatabaseHandler extends SQLiteOpenHelper
{

    // database constants
    private static String DB_NAME = "LandmarkDB";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase LandmarkDB;
    private static final String TABLE_COMMENTS = "QuestionTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PICTURE = "PICTURE";
    public static final String COLUMN_ANSWER1 = "ANSWER1";
    public static final String COLUMN_ANSWER2 = "ANSWER2";
    public static final String COLUMN_ANSWER3 = "ANSWER3";
    public static final String COLUMN_ANSWER4 = "ANSWER4";
    public static final String COLUMN_CORRECTANSWER = "CORRECT_ANSWER";

    //database creation statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_PICTURE
            + " text not null, " + COLUMN_ANSWER1
            + " text not null, " + COLUMN_ANSWER2
            + " text not null, " + COLUMN_ANSWER3
            + " text not null, " + COLUMN_ANSWER4
            + " text not null, " + COLUMN_CORRECTANSWER
            + " text not null);";

    public LandmarkDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(LandmarkDatabaseHandler.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }
}
