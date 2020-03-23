package com.example.coronatester;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button strtBtn, extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strtBtn = findViewById(R.id.start);
        extra = findViewById(R.id.exit);
        strtBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent qstnIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(qstnIntent);
            }
        });

        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent extraIntent = new Intent(MainActivity.this, extraLinks.class);
                startActivity(extraIntent);
            }
        });
    }
}
