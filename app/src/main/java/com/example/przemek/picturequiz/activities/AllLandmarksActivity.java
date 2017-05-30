package com.example.przemek.picturequiz.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.LandmarkDatabaseHandler;

import java.io.InputStream;
import java.net.URL;

public class AllLandmarksActivity extends AppCompatActivity {

    int correctAnswer=0;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        showRandomRow();
        score=getIntent().getExtras().getInt("score");
        TextView scoretext=(TextView)findViewById(R.id.score);
        scoretext.setText(String.valueOf(score));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void showRandomRow ()
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        String row[]=db.getRandomRow();
        correctAnswer=Integer.parseInt(row[8]);
        new GetImageFromURL().execute(row[1]);
        TextView answer1=(TextView)findViewById(R.id.Answer1);
        answer1.setText(row[2]);
        TextView answer2=(TextView)findViewById(R.id.Answer2);
        answer2.setText(row[3]);
        TextView answer3=(TextView)findViewById(R.id.Answer3);
        answer3.setText(row[4]);
        TextView answer4=(TextView)findViewById(R.id.Answer4);
        answer4.setText(row[5]);
        db.markAsUsed(row[0]);
    }

    class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... url) {
            try {
                InputStream is = (InputStream) new URL(url[0]).getContent();
                Bitmap image = BitmapFactory.decodeStream(is);
                return image;
            } catch (Exception e) {
                return null;
            }
        }

        protected void onPostExecute(Bitmap image) {
            ImageView picture=(ImageView)findViewById(R.id.Picture);
            picture.setImageBitmap(image);
        }
    }

    /**
     * make background red or green depending on correctness of answer, wait a moment and go to the next question
     * @param view
     */
    public void answer1 (View view)
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        if (db.checkForUnusedQuestions())
        {
            final Intent intent = new Intent(this, AllLandmarksActivity.class);
            TextView answer=(TextView)findViewById(R.id.Answer1);
            if (correctAnswer==1)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
        else
        {
            final Intent intent = new Intent(this, NoQuestionsActivity.class); //will lead to "u finished all questions screen"
            TextView answer=(TextView)findViewById(R.id.Answer1);
            if (correctAnswer==1)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
    }

    public void answer2 (View view)
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        if (db.checkForUnusedQuestions())
        {
            final Intent intent = new Intent(this, AllLandmarksActivity.class);
            TextView answer=(TextView)findViewById(R.id.Answer2);
            if (correctAnswer==2)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
        else
        {
            final Intent intent = new Intent(this, NoQuestionsActivity.class); //will lead to "u finished all questions screen"
            TextView answer=(TextView)findViewById(R.id.Answer2);
            if (correctAnswer==2)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
    }

    public void answer3 (View view)
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        if (db.checkForUnusedQuestions())
        {
            final Intent intent = new Intent(this, AllLandmarksActivity.class);
            TextView answer=(TextView)findViewById(R.id.Answer3);
            if (correctAnswer==3)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
        else
        {
            final Intent intent = new Intent(this, NoQuestionsActivity.class); //will lead to "u finished all questions screen"
            TextView answer=(TextView)findViewById(R.id.Answer3);
            if (correctAnswer==3)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
    }

    public void answer4 (View view)
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        if (db.checkForUnusedQuestions())
        {
            final Intent intent = new Intent(this, AllLandmarksActivity.class);
            TextView answer=(TextView)findViewById(R.id.Answer4);
            if (correctAnswer==4)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
        else
        {
            final Intent intent = new Intent(this, NoQuestionsActivity.class); //will lead to "u finished all questions screen"
            TextView answer=(TextView)findViewById(R.id.Answer4);
            if (correctAnswer==4)
            {
                score++;
                intent.putExtra("score",score);
                TextView scoretext=(TextView)findViewById(R.id.score);
                scoretext.setText(String.valueOf(score));
                answer.setBackgroundResource(R.drawable.button_border_correct);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
            else
            {
                intent.putExtra("score",score);
                answer.setBackgroundResource(R.drawable.button_border_incorrect);
                answer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
    }
}
