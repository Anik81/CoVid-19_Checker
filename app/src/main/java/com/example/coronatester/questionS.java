package com.example.coronatester;

public class questionS {
    public String qstn[] = {
            "Have you recently traveled to an area with known local spread of COVID-19?",
            "Have you came into close contact with someone who has a laborotary confirmed COVID-19 diagnosis in the past 14days?",
            "Do you have a fever(greater than 38.0C or 100.4F)?",
            "Do you have symptoms of Lower Respiratory illness such as Dry Cough, Shortness of Breathing or Sore Throat?",
            "Do you facing difficulty in Breathing?",
            "Are you a Health Worker?"
    };
    private String choices[][] = {
            {"YES", "NO" },
            {"YES", "NO" },
            {"YES", "NO" },
            {"YES", "NO" },
            {"YES", "NO" },
            {"YES", "NO" }
    };
    private String correct[] = {"YES", "YES", "YES", "YES", "YES", "YES" };

    public String getQuestion(int a) {
        String question = qstn[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = choices[a][0];
        return choice;

    }

    public String getChoice2(int a) {
        String choice = choices[a][1];
        return choice;

    }

    public String getCorrectAns(int a) {
        String answer = correct[a];
        return answer;

    }

}
