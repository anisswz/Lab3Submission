package com.example.s72591_lab3_task2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Views from original Task 2 setup
    private EditText edtName;
    private Button btnHello;
    private TextView txtResult;

    // --- ADDITIONS FOR THE EXERCISE ---
    private Button btnCount;
    private TextView txtCount;
    private int clickCount = 0;
    // --- END OF ADDITIONS ---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI objects from original setup
        edtName = findViewById(R.id.edtName);
        btnHello = findViewById(R.id.btnHello);
        txtResult = findViewById(R.id.txtResult);

        // --- LINK UI OBJECTS FOR THE EXERCISE ---
        btnCount = findViewById(R.id.btnCount);
        txtCount = findViewById(R.id.txtCount);
        // --- END OF LINKING ---

        // Attach Java Event Listener from original setup
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter your name",
                            Toast.LENGTH_SHORT).show();
                } else {
                    txtResult.setText("Hello, " + name + "!");
                }
            }
        });

        // --- ATTACH LISTENER FOR THE EXERCISE ---
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // i. Increase clickCount by 1
                clickCount++;

                // ii. Update the TextView
                txtCount.setText("Clicks: " + clickCount);

                // iii. Show a Toast message when the count reaches 5
                if (clickCount == 5) {
                    Toast.makeText(MainActivity.this,
                            "You clicked 5 times!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}