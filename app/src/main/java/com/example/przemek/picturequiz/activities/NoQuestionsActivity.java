package com.example.przemek.picturequiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.LandmarkDatabaseHandler;

/**
 * Created by Przemek on 29.05.2017.
 */
public class NoQuestionsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_questions);
    }

    public void returnToMenu (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
