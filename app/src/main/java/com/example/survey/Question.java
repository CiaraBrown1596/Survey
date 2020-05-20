package com.example.survey;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// this class contains the information regarding the survey questions
public class Question {
    private String question;
    private int veryPoor;
    private int poor;
    private int okay;
    private int good;
    private int veryGood;
    private int answer;

    public Question() {
    }

    public Question(String question, int veryPoor, int poor, int okay, int good, int veryGood, int answer) {
        this.question = question;
        this.veryPoor = veryPoor;
        this.poor = poor;
        this.okay = okay;
        this.good = good;
        this.veryGood = veryGood;
        this.answer = answer;
    }

    public Question(String s, String s1, String s2, String s3, String s4, String s5) {
    }

    public Question(String question, String s, String s1, String s2, String s3, String s4, int radioGroup) {
    }

    public Question(String s, String s1, String s2, String s3, String s4, String s5, RadioButton mySelectedRadioButton) {
    }

    public Question(String s, String s1, String s2, String s3, String s4, String s5, RadioGroup mySelectedRadioButton) {
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getVeryPoor() {
        return veryPoor;
    }

    public Question setVeryPoor(String veryPoor) {
        this.veryPoor = veryPoor;
        return this;
    }

    public String getOkay() {
        return okay;
    }

    public Question setOkay(String okay) {
        this.okay = okay;
        return this;
    }

    public int getGood() {
        return good;
    }

    public Question setGood(int good) {
        this.good = good;
        return this;
    }

    public int getVeryGood() {
        return veryGood;
    }

    public Question setVeryGood(int veryGood) {
        this.veryGood = veryGood;
        return this;
    }

    public int getAnswer() {
        return answer;
    }

    public Question setAnswer(int answer) {
        this.answer = answer;
        return this;
    }

    public String getPoor() {
        return poor;
    }

    public Question setPoor(String poor) {
        this.poor = poor;
        return this;
    }
}
