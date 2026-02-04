package com.example.sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*
 * This program demonstrates:
 * 1. Without Thread
 * 2. Thread using Extend Thread
 * 3. Thread using Runnable
 * 4. Thread without Handler
 * 5. Thread with Handler (UI update)
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button startButton;

    // Handler to update UI from background thread
    Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
    }

    // ==========================
    // 1️⃣ WITHOUT THREAD
    // ==========================
    // Runs on Main(UI) thread
    public void withoutThread(View view) {
        for (int i = 0; i < 5; i++) {
            Log.d(TAG, "Without Thread: " + i);
        }
        startButton.setText("Without Thread Done");
    }

    // ==========================
    // 2️⃣ THREAD USING EXTEND THREAD
    // ==========================
    public void startExtendThread(View view) {
        ExampleThread thread = new ExampleThread();
        thread.start();
    }

    class ExampleThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "Extend Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ==========================
    // 3️⃣ THREAD USING RUNNABLE
    // ==========================
    public void startRunnableThread(View view) {
        ExampleRunnable runnable = new ExampleRunnable();
        new Thread(runnable).start();
    }

    class ExampleRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "Runnable Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ==========================
    // 4️⃣ THREAD WITHOUT HANDLER
    // ==========================
    // UI update NOT allowed here
    public void threadWithoutHandler(View view) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "Thread without Handler: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // ==========================
    // 5️⃣ THREAD WITH HANDLER
    // ==========================
    // UI update allowed using Handler
    public void threadWithHandler(View view) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                if (i == 5) {
                    // Updating UI using Handler
                    mainHandler.post(() ->
                            startButton.setText("50% Completed"));
                }

                Log.d(TAG, "Thread with Handler: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Final UI update
            mainHandler.post(() ->
                    startButton.setText("Done"));
        }).start();
    }
}
