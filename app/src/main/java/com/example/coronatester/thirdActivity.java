package com.example.coronatester;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView res = (TextView) findViewById(R.id.result1);
        int score = getIntent().getIntExtra("RansCount", 0);
        if (score >= 4) {
            res.setText("You are in High risk!! Please Go to the Nearest Hospital for Treatment");
        }
    }
}
