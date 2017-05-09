package com.example.przemek.picturequiz.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.DatabaseReaderEntry;
import com.example.przemek.picturequiz.database.LandmarkDatabaseHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View view=findViewById(R.id.activity_main);

        //Testing whether database is working
        LandmarkDatabaseHandler DBhelper = new LandmarkDatabaseHandler(getApplicationContext());
        SQLiteDatabase db = DBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_PICTURE, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Avignon%2C_Palais_des_Papes_depuis_Tour_Philippe_le_Bel_by_JM_Rosier.jpg/1200px-Avignon%2C_Palais_des_Papes_depuis_Tour_Philippe_le_Bel_by_JM_Rosier.jpg");
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER1, "odp1");
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER2, "odp2");
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER3, "odp3");
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_ANSWER4, "odp4");
        values.put(DatabaseReaderEntry.DatabaseEntry.COLUMN_CORRECTANSWER, "dobra odpowiedz");
        long newRowId = db.insert(DatabaseReaderEntry.DatabaseEntry.TABLE_NAME, null, values);

        //setting buttons in linearview to the same height
        view.post(new Runnable() {
            @Override
            public void run() {
                Button leftbutton =(Button) findViewById(R.id.LeftButton);
                Button rightbutton =(Button) findViewById(R.id.RightButton);
                if (leftbutton.getHeight()>rightbutton.getHeight())
                {
                    rightbutton.setHeight(leftbutton.getHeight());
                }
                else
                {
                    leftbutton.setHeight(rightbutton.getHeight());
                }
            }
        });
    }

    public void manMadeOnly (View view)
    {
        Intent intent = new Intent(this, ManMadeOnlyActivity.class);
        startActivity(intent);
    }
}
