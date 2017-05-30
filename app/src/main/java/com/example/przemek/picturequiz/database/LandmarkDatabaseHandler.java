package com.example.przemek.picturequiz.database;

import android.content.ContentValues;
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

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);

        //check whether database is empty
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " +DatabaseReaderEntry.DatabaseEntry.TABLE_NAME, null);
        if(cursor != null)
        {
            cursor.moveToFirst();
            int count = cursor.getInt(0);

            //if it's empty populate table
            if(!(count > 0)){
                ContentValues values = new ContentValues();
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_PICTURE, "http://i1-news.softpedia-static.com/images/news2/Thief-Steals-the-Keys-to-the-Tower-of-London-on-Guy-Fawkes-Night-2.jpg?1352724076");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER1, "Anglia");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER2, "Francja");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER3, "Hiszpania");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER4, "Polska");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_CORRECTANSWER, 1);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ALREADY_USED, 0);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_MAN_MADE, 1);
                db.insert(DatabaseReaderEntry.DatabaseEntry.TABLE_NAME, null, values);

                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_PICTURE, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Wawel2.jpg/1200px-Wawel2.jpg");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER1, "Hiszpania");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER2, "Albania");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER3, "Polska");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER4, "Francja");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_CORRECTANSWER, 3);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ALREADY_USED, 0);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_MAN_MADE, 1);
                db.insert(DatabaseReaderEntry.DatabaseEntry.TABLE_NAME, null, values);

                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_PICTURE, "https://www.niagarafallsstatepark.com/~/media/parks/niagara-falls/homepage/banner-niagara1.jpg");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER1, "Peru");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER2, "Brazylia");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER3, "Polska");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER4, "USA");
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_CORRECTANSWER, 4);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ALREADY_USED, 0);
                values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_MAN_MADE, 0);
                db.insert(DatabaseReaderEntry.DatabaseEntry.TABLE_NAME, null, values);
            }

        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void refresh() {
        SQLiteDatabase db  = this.getReadableDatabase();
        String strSQL = "UPDATE "+ DatabaseReaderEntry.DatabaseEntry.TABLE_NAME+" SET "+DatabaseReaderEntry.DatabaseEntry.COLUMN_ALREADY_USED+" = 0;";
        db.execSQL(strSQL);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String[] getRandomRow()
    {
        String selectQuery = "SELECT * FROM " + DatabaseReaderEntry.DatabaseEntry.TABLE_NAME + " WHERE ALREADY_USED=0 ORDER BY RANDOM();"; // select random row from database
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

    public String[] getRandomManMAdeRow()
    {
        String selectQuery = "SELECT * FROM " + DatabaseReaderEntry.DatabaseEntry.TABLE_NAME + " WHERE ALREADY_USED=0 AND "+DatabaseReaderEntry.DatabaseEntry.COLUMN_MAN_MADE+"=1 ORDER BY RANDOM();"; // select random row from database
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

    public void markAsUsed (String id)
    {
        String strSQL = "UPDATE "+ DatabaseReaderEntry.DatabaseEntry.TABLE_NAME+" SET "+DatabaseReaderEntry.DatabaseEntry.COLUMN_ALREADY_USED+" = 1 where "
                +DatabaseReaderEntry.DatabaseEntry.COLUMN_ID+ "="+id+ ";";
        this.getReadableDatabase().execSQL(strSQL);
    }

    public Boolean checkForUnusedQuestions ()
    {
        String selectQuery = "SELECT * FROM " + DatabaseReaderEntry.DatabaseEntry.TABLE_NAME + " WHERE ALREADY_USED=0 ORDER BY RANDOM();";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt>0;
    }

    public Boolean checkForUnusedManMAdeQuestions ()
    {
        String selectQuery = "SELECT * FROM " + DatabaseReaderEntry.DatabaseEntry.TABLE_NAME + " WHERE ALREADY_USED=0 AND "+DatabaseReaderEntry.DatabaseEntry.COLUMN_MAN_MADE+"=1 ORDER BY RANDOM();";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt>0;
    }
}
