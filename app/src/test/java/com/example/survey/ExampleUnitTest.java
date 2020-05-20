package com.example.survey;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public static class AverageTest extends TestCase {
        public void testOneAverage() {
            // we expect the average of one element (with value 5) to be 5, the 0.01 is a delta because of imprecise floating-point operations
            double avg1 = AverageTest.avg(new double[]{5});
            assertEquals(5, avg1, 0.01);
        }

        private static double avg(double[] doubles) {
            return 0;
        }
    }


}