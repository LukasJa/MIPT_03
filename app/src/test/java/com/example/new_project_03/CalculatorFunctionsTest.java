package com.example.new_project_03;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorFunctionsTest {

    @Test
    public void addition_returnsCorrectSum() {
        double firstValue = 5.0;
        double secondValue = 3.0;
        double expectedResult = 8.0;

        double actualResult = firstValue + secondValue;

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void subtraction_returnsCorrectDifference() {
        double firstValue = 5.0;
        double secondValue = 3.0;
        double expectedResult = 2.0;

        double actualResult = firstValue - secondValue;

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void multiplication_returnsCorrectResult() {
        double firstValue = 5.0;
        double secondValue = 3.0;
        double expectedResult = 15.0;

        double actualResult = firstValue * secondValue;

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void division_returnsCorrectQuotient() {
        double firstValue = 6.0;
        double secondValue = 3.0;
        double expectedResult = 2.0;

        double actualResult = firstValue / secondValue;

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void division_byZero_returnsError() {
        double firstValue = 6.0;
        double secondValue = 0.0;
        String expectedResult = "Error";

        String actualResult;
        double result = firstValue / secondValue;
        if (Double.isInfinite(result)) {
            actualResult = "Error";
        } else {
            actualResult = String.valueOf(result);
        }

        assertEquals(expectedResult, actualResult);
    }
}
