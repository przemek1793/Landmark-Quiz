package com.example.przemek.picturequiz.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.DatabaseEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view=findViewById(R.id.activity_main);

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
