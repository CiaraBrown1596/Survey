package com.example.survey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.survey.SurveyContract.*;
import com.example.survey.SurveyActivity.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SurveyDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Survey.db";
    public static final int DATABASE_VERSION = 1;
    private static final Context context = null;

    private SQLiteDatabase db;

    public SurveyDbHelper() {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT " +
                QuestionsTable.COLUMN_VERYPOOR + " INTEGER " +
                QuestionsTable.COLUMN_POOR + " INTEGER " +
                QuestionsTable.COLUMN_OKAY + " INTEGER " +
                QuestionsTable.COLUMN_GOOD + " INTEGER " +
                QuestionsTable.COLUMN_VERYGOOD + " INTEGER " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER " +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    //fills the questions for the user to answer.
    private void fillQuestionsTable() {
        Question q1 = new Question("How do you rate this service?", "1","2","3","4","5");
        addQuestion(q1);
        Question q2 = new Question("How do you rate the speed of the service?", "1","2","3","4","5");
        addQuestion(q2);
        Question q3 = new Question("How do you rate the quality of the service?", "1","2","3","4","5");
        addQuestion(q3);
    }
    //adds the questions to the list of questions
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_VERYPOOR, question.getVeryPoor());
        cv.put(QuestionsTable.COLUMN_POOR, question.getPoor());
        cv.put(QuestionsTable.COLUMN_OKAY, question.getOkay());
        cv.put(QuestionsTable.COLUMN_GOOD, question.getGood());
        cv.put(QuestionsTable.COLUMN_VERYGOOD, question.getVeryGood());
        cv.put(QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null,cv);

    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setVeryPoor(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_VERYPOOR)));
                question.setPoor(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_POOR)));
                question.setOkay(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OKAY)));
                question.setGood(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_GOOD)));
                question.setVeryGood(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_VERYGOOD)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
