package com.example.przemek.picturequiz.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.DatabaseReaderEntry;
import com.example.przemek.picturequiz.database.LandmarkDatabaseHandler;

public class ManMadeOnlyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_made_only);
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        String row[]=db.getRandomRow();
        TextView text=(TextView)findViewById(R.id.Picture);
        text.setText(row[2]);
    }
}
