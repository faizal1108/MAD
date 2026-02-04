package com.example.asyncdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.btnDownload);

        btn.setOnClickListener(v ->
                new ImageDownloadTask().execute(
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSO55h5AOJ2bcNy18zRWPBPGHhTCq-2QSAwA&s")
        );
    }

    class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                InputStream in = new URL(urls[0]).openStream();
                return BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }
        }
    }
}
