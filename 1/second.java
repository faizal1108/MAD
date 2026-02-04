package com.example.message;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ Correct layout name
        setContentView(R.layout.acitvity_second);
    
        text1 = findViewById(R.id.text1);

        // ✅ Use same keys as MainActivity
        String message = getIntent().getStringExtra("message");
        String email = getIntent().getStringExtra("email");

        text1.setText(getString(R.string.display_message, message, email));
    }
}
