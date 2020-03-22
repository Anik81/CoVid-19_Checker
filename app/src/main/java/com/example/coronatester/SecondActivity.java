package com.example.coronatester;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView question, noIndicator;
    //LinearLayout optionsContainer;
    Button next, ops1, ops2;

    String rightanswer;
    int ransCount=1;
    int quizCount=1;

    int count = 0;
    static final private int qstn_count=6;

    ArrayList<ArrayList<String>> quizArray= new ArrayList<>();

    String quizData[][]={
            //{"Question","Opt1","opt2"}
            {"Have you recently traveled to an area with known local spread of COVID-19?", "YES", "NO"},
            {"Have you came into close contact with someone who has a laborotary confirmed COVID-19 diagnosis in the past 14days?", "YES", "NO"},
            {"Do you have a fever(greater than 38.0C or 100.4F)?", "YES", "NO"},
            {"Do you have symptoms of Lower Respiratory illness such as Dry Cough, Shortness of Breathing or Sore Throat?", "YES", "NO"},
            {"Do you facing difficulty in Breathing?", "YES", "NO"},
            {"Are you a Health Worker?", "YES", "NO"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.no_indicator);
        next = findViewById(R.id.next_btn);
        ops1 = findViewById(R.id.opt1);
        ops2 = findViewById(R.id.opt2);

        for(int i=0;i<quizData.length;i++)
        {
            ArrayList<String> tmpArray= new ArrayList<>();
            tmpArray.add(quizData[i][0]);// Question
            tmpArray.add(quizData[i][1]);//Right Answer
            tmpArray.add(quizData[i][2]);//opt1

            //add tmpArray to quizArray
            quizArray.add(tmpArray);
        }
        showNextQuestion();
    }

    public void showNextQuestion(){
        noIndicator.setText(quizCount+"/6");

        Random random= new Random();
        int randomNum= random.nextInt(quizArray.size());

        ArrayList<String> quiz=quizArray.get(randomNum);

        //Set question and right answer
        question.setText(quiz.get(0));
        rightanswer=quiz.get(1);

        quiz.remove(0);
        //quizArray.remove(randomNum);
        quizArray.remove(0);

       //Collections.shuffle(quiz);

        ops1.setText(quiz.get(0));
        ops2.setText(quiz.get(1));
    }
    public void checkAnswer(View view){

        //Get  Pushed Button
        Button answerBtn=(Button)findViewById(view.getId());
        String btnText=answerBtn.getText().toString();
        String alertTitle;
        if(btnText.equals(rightanswer)){
            alertTitle="YES!!";
            ransCount++;
        }else{
            alertTitle="NO!!";
        }
        //Creating Dialog
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount==qstn_count)
                {
                    //Show Result
                    Intent intent=new Intent(getApplicationContext(),thirdActivity.class);
                    intent.putExtra("RansCount",ransCount);
                    startActivity(intent);
                }else{
                    quizCount++;
                    showNextQuestion();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}


