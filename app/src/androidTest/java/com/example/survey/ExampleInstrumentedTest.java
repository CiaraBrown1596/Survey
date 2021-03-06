package com.example.survey;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.espresso.action.ViewActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.survey", appContext.getPackageName());
    }
    //test to see if start button works correctly.
    public void user_can_start_Survey(){
        onView(withId(R.id.btnStart)).perform(ViewActions.click());
    }

    //test for database creation.
    public void testCreateDB(){
        SurveyDbHelper surveyDbHelper = new SurveyDbHelper();
        SQLiteDatabase db = surveyDbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();
    }
}
