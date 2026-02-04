package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSmall, btnMedium, btnLarge;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtView);
        btnSmall = findViewById(R.id.smallfont);
        btnMedium = findViewById(R.id.mediumfont);
        btnLarge = findViewById(R.id.largefont);

        // Event Listener + Event Handler
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(18);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(25);
            }
        });

        btnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(35);
            }
        });

        btnLarge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(
                        MainActivity.this,
                        "Large Button Long Clicked",
                        Toast.LENGTH_SHORT
                ).show();
                return true;
            }
        });
    }
}
