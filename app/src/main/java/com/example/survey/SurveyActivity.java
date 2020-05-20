package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private RadioGroup myRadioGroup;

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private double answers;
    private RadioButton rb4;
    private RadioButton rb5;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private int score;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        textViewQuestion = findViewById(R.id.txtMain);
        rbGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioBtn1);
        rb2 = findViewById(R.id.radioBtn2);
        rb3 = findViewById(R.id.radioBtn3);
        rb4 = findViewById(R.id.radioBtn4);
        rb5 = findViewById(R.id.radioBtn5);
        buttonConfirmNext = findViewById(R.id.btn_Confirm);
        textColorDefaultRb = rb1.getTextColors();
        SurveyDbHelper dbHelper = new SurveyDbHelper();
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();

        //clicking confirm button stores answer
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() || rb5.isChecked()) {

                    } else {
                        Toast.makeText(SurveyActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    //moves the user onto the next question
    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getVeryPoor());
            rb2.setText(currentQuestion.getPoor());
            rb3.setText(currentQuestion.getOkay());
            rb4.setText(currentQuestion.getGood());
            rb5.setText(currentQuestion.getVeryGood());
            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");
        } else {
            finishSurvey();
        }
    }

    //finishes the survey
    private void finishSurvey() {
        finish();
    }

    // calculates the average score from the list on answers in the survey
    private double calculateAverage(List<Integer> answers) {
        Integer average = 0;
        if (!answers.isEmpty()) {
            for (Integer mark : answers) {
                average += mark;
            }
            return average.doubleValue() / answers.size();
        }
        return average;
    }

    //calcualte the max and min values
    public static int getMaxValue(int[] AnswerArray){
        int maxValue = AnswerArray[0];
        for(int i=1;i < AnswerArray.length;i++){
            if(AnswerArray[i] > maxValue){
                maxValue = AnswerArray[i];
            }
        }
        return maxValue;
    }
    public static int getMinValue(int[] AnswerArray){
        int minValue = AnswerArray[0];
        for(int i=1;i<AnswerArray.length;i++){
            if(AnswerArray[i] < minValue){
                minValue = AnswerArray[i];
            }

    // calculate the standard deviation
    public static double calculateStandardDev(double AnswerArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = AnswerArray.length;

        for(double num : AnswerArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: AnswerArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return (int) Math.sqrt(standardDeviation/length);
    }
}





}
