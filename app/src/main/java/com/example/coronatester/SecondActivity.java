package com.example.coronatester;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView question, noIndicator;
    Button next, ops1, ops2;

    Random r;
    private questionS mq = new questionS();
    private String mAnswer;
    private int mScore = 0, noI = 1, qstnN = 0;
    private int mQuesLength = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.no_indicator);
        next = findViewById(R.id.next_btn);
        ops1 = findViewById(R.id.opt1);
        ops2 = findViewById(R.id.opt2);

        noIndicator.setText(noI + "/6");
        updateQstn();

        ops1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ops1.getText() == mAnswer) {
                    mScore++;
                    updateQstn();
                    noI++;
                    noIndicator.setText(noI + "/6");
                    if (noI == 6) {
                        gameOver();
                    }
                } else {
                    noI++;
                    updateQstn();
                    noIndicator.setText(noI + "/6");
                    if (noI == 6) {
                        gameOver();
                    }
                }
            }
        });

        ops2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ops2.getText() == mAnswer) {
                    mScore++;
                    updateQstn();
                    noI++;
                    noIndicator.setText(noI + "/6");
                    if (noI == 6) {
                        gameOver();
                    }
                } else {
                    noI++;
                    updateQstn();
                    noIndicator.setText(noI + "/6");
                    if (noI == 6) {
                        gameOver();
                    }
                }
            }
        });


    }

    private void updateQstn() {
        question.setText(mq.getQuestion(qstnN));
        ops1.setText(mq.getChoice1(qstnN));
        ops2.setText(mq.getChoice2(qstnN));

        mAnswer = mq.getCorrectAns(qstnN);
        qstnN++;

    }

    private void gameOver() {
        if (mScore > 2 && mScore <= 4) {
            AlertDialog.Builder alertD = new AlertDialog.Builder(SecondActivity.this);
            alertD.setMessage("You Are at 60% risk of  Affected by COVID-19. Please Go to Nearest Hospital for Diagnosis").setCancelable(false)

                    .setPositiveButton("Test again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    });
            AlertDialog alertDialog = alertD.create();
            alertDialog.show();

        } else if (mScore <= 2) {
            AlertDialog.Builder alertD = new AlertDialog.Builder(SecondActivity.this);
            alertD.setMessage("You Are Safe but Please maintain HOME QURANTINE").setCancelable(false)

                    .setPositiveButton("Test again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    });
            AlertDialog alertDialog = alertD.create();
            alertDialog.show();
        } else if (mScore > 4) {
            AlertDialog.Builder alertD = new AlertDialog.Builder(SecondActivity.this);
            alertD.setMessage("You Are at High Risk of affected by COVID-19. Please Visit The Nearest Hospital For Treatment").setCancelable(false)

                    .setPositiveButton("Test again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    });
            AlertDialog alertDialog = alertD.create();
            alertDialog.show();
        }
    }
}


