package com.br.automated.tests.study.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in SimpleMath class")
class SimpleMathTest {
    SimpleMath math;

    @BeforeAll
    static void setup(){

    }

    @AfterAll
    static void cleanup(){

    }

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod(){

    }

    /*
        Como nomear testes:
        test[System Under Test]_[Condition or Stage Change]_[Expected Result]
     */
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo(){
       //Given / Arrange
        double firstValue = 6.2D;
        double secondValue = 2D;
        double expected = 8.2D;
        //When / Act
        double actual = math.sum(firstValue, secondValue);
        //Then / Assert
        assertEquals(expected, actual,  () -> firstValue +" + "+secondValue+" did not produce "+expected);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction_When_SixDotTwoIsSubtractedByTwo_ShouldReturnFourDotTwo(){
        
        double firstValue = 6.2D;
        double secondValue = 2D;
        double expected = 4.2D;
        double actual = math.subtraction(firstValue, secondValue);
        assertEquals(expected, actual,  () -> firstValue +" - "+secondValue+" did not produce "+expected);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication_When_SixDotTwoIsMultipliedByTwo_ShouldReturnTwelveDotFour(){
        
        double firstValue = 6.2D;
        double secondValue = 2D;
        double expected = 12.4D;
        double actual = math.multiplication(firstValue, secondValue);
        assertEquals(expected, actual,  () -> firstValue +" * "+secondValue+" did not produce "+expected);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision_When_SixDotTwoIsDividedByTwo_ShouldReturnThreeDotOne(){
        
        double firstValue = 6.2D;
        double secondValue = 2D;
        double expected = 3.1D;
        double actual = math.division(firstValue, secondValue);
        assertEquals(expected, actual,  () -> firstValue +" / "+secondValue+" did not produce "+expected);
    }

    @Test
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

    @Test
    @DisplayName("Test (6.2 +2)/ 2 = 4.1")
    void testMean_When_SixDotTwoIsAddedByTwo_ShouldReturnFourDotOne(){
        
        double firstValue = 6.2D;
        double secondValue = 2D;
        double expected = 4.1;
        double actual = math.mean(firstValue, secondValue);
        assertEquals(expected, actual,    () -> "(" + firstValue + "+" + secondValue + ")/2" +
                " did not produce " + expected);
    }

    @Test
    @DisplayName("Test Square Root of 81 = 9")
    void testSquareRoot_When_ValueIsEightyOne_Then_ShouldReturnNine() {
        
        double number = 81D;
        double expected = 9D;
        Double actual = math.squareRoot(number);
        assertEquals(expected, actual,
                () -> "Square Root of " + number +
                        " did not produce " + expected + "!");
    }

}