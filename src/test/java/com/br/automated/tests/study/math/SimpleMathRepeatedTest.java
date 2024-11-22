package com.br.automated.tests.study.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test RepeatedTest")
class SimpleMathRepeatedTest {
    SimpleMath math;

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    //Executa 3 vezes o método abaixo
    @RepeatedTest(3)
    @DisplayName("Test 6.2 / 0 should return Arithmetic Exception")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(){
        //Given
        double firstValue = 6.2D;
        double secondValue = 0D;
        var expectedMessage = "Impossible to divide by zero!";
        //When & Then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () ->
                math.division(firstValue, secondValue),
                () -> "Division by zero should throw an ArithmeticException");
        assertEquals(expectedMessage, actual.getMessage());
    }

    //Tanto RepetitionInfo quanto TestInfo são opcionais
    @RepeatedTest(3)
    @DisplayName("Test 6.2 / 0 should return Arithmetic Exception - RepetitionInfo and TestInfo")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException2(
            RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("Total of repetitions: "+repetitionInfo.getTotalRepetitions());
        System.out.println("Current repetition: "+repetitionInfo.getCurrentRepetition());
        System.out.println("Test class: " + testInfo.getTestClass().get().getName());
        System.out.println("Test Method: " + testInfo.getTestMethod().get().getName());
        System.out.println("Tags: " + testInfo.getTags());
        System.out.println("Display Name: " + testInfo.getDisplayName());
        //Given
        double firstValue = 6.2D;
        double secondValue = 0D;
        var expectedMessage = "Impossible to divide by zero!";
        //When & Then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () ->
                        math.division(firstValue, secondValue),
                () -> "Division by zero should throw an ArithmeticException");
        assertEquals(expectedMessage, actual.getMessage());
    }

    //Tanto RepetitionInfo quanto TestInfo são opcionais
    @RepeatedTest(value = 3, name = "{displayName}. Repetition "
            + "{currentRepetition} of {totalRepetitions}!")
    @DisplayName("Test 6.2 / 0 should return Arithmetic Exception - RepetitionInfo and TestInfo")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException3(
            RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("Total of repetitions: "+repetitionInfo.getTotalRepetitions());
        System.out.println("Current repetition: "+repetitionInfo.getCurrentRepetition());
        System.out.println("Test class: " + testInfo.getTestClass().get().getName());
        System.out.println("Test Method: " + testInfo.getTestMethod().get().getName());
        System.out.println("Tags: " + testInfo.getTags());
        System.out.println("Display Name: " + testInfo.getDisplayName());
        //Given
        double firstValue = 6.2D;
        double secondValue = 0D;
        var expectedMessage = "Impossible to divide by zero!";
        //When & Then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () ->
                        math.division(firstValue, secondValue),
                () -> "Division by zero should throw an ArithmeticException");
        assertEquals(expectedMessage, actual.getMessage());
    }


}