package com.example.survey;
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

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public int getVeryPoor() {
        return veryPoor;
    }

    public Question setVeryPoor(int veryPoor) {
        this.veryPoor = veryPoor;
        return this;
    }

    public int getOkay() {
        return okay;
    }

    public Question setOkay(int okay) {
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

    public int getPoor() {
        return poor;
    }

    public Question setPoor(int poor) {
        this.poor = poor;
        return this;
    }
}
