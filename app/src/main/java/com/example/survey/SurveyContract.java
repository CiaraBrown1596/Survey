package com.example.survey;

import android.provider.BaseColumns;

public final class SurveyContract {

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "Survey Questions";
        public static final String COLUMN_QUESTION = "Questions";
        public static final String COLUMN_VERYPOOR = "Very Poor";
        public static final String COLUMN_POOR = "Poor";
        public static final String COLUMN_OKAY= "Okay";
        public static final String COLUMN_GOOD= "Good";
        public static final String COLUMN_VERYGOOD= "Very Good";
        public static final String COLUMN_ANSWER= "answer";
    }
}
