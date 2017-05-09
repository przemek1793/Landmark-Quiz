package com.example.przemek.picturequiz.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.przemek.picturequiz.R;
import com.example.przemek.picturequiz.database.DatabaseReaderEntry;
import com.example.przemek.picturequiz.database.LandmarkDatabaseHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ManMadeOnlyActivity extends AppCompatActivity {

    String correctAnswer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_made_only);
        showRandomRow();
    }

    protected void showRandomRow ()
    {
        LandmarkDatabaseHandler db = new LandmarkDatabaseHandler(getApplicationContext());
        String row[]=db.getRandomRow();
        correctAnswer=row[0];
        new GetImageFromURL().execute(row[1]);
        TextView answer1=(TextView)findViewById(R.id.Answer1);
        answer1.setText(row[2]);
        TextView answer2=(TextView)findViewById(R.id.Answer2);
        answer2.setText(row[3]);
        TextView answer3=(TextView)findViewById(R.id.Answer3);
        answer3.setText(row[4]);
        TextView answer4=(TextView)findViewById(R.id.Answer4);
        answer4.setText(row[5]);
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
}
