package com.example.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Message sender");
        }

        EditText message = findViewById(R.id.message);
        EditText email = findViewById(R.id.email);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ✅ Get user input correctly
                String mes = message.getText().toString();
                String mail = email.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", mes);
                intent.putExtra("email", mail);
                startActivity(intent);
            }
        });
    }
}
