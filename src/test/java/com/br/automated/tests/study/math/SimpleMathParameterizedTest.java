package com.br.automated.tests.study.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in SimpleMath class with parameters")
class SimpleMathParameterizedTest {
    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @DisplayName("Test divisions with parameters")
    @ParameterizedTest
    @MethodSource("testDivisionInputParameters")
    void testDivision(double firstValue, double secondValue, double expected) {
        double actual = math.division(firstValue, secondValue);
        // Terceiro parametro - 2D - diz para considerar apenas 2 casas decimais
        // de actual - exemplo 5.90765 será considerado 5.90
        assertEquals(expected, actual, 2D, () -> firstValue + " / " + secondValue + " did not produce " + expected);
    }

    public static Stream<Arguments> testDivisionInputParameters() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

    /*
        Neste exemplo não é necessário informar o valor de MethodSource.
        Apenas cria-se um método retornando os parâmetros, com o mesmo nome deste
        método
     */
    @DisplayName("Test divisions with parameters and without MethodSource value")
    @ParameterizedTest
    @MethodSource
    void testDivisionWithoutMethodSourceValue(double firstValue, double secondValue, double expected) {
        double actual = math.division(firstValue, secondValue);
        // Terceiro parametro - 2D - diz para considerar apenas 2 casas decimais
        // de actual - exemplo 5.90765 será considerado 5.90
        assertEquals(expected, actual, 2D, () -> firstValue + " / " + secondValue + " did not produce " + expected);
    }

    public static Stream<Arguments> testDivisionWithoutMethodSourceValue() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

    @DisplayName("Test divisions with parameters and with CsvSource")
    @ParameterizedTest
    @CsvSource({
       "6.2, 2, 3.1",
       "71, 14, 5.07",
       "18.3, 3.1, 5.90"
    })
    void testDivisionWithoCsvSource(double firstValue, double secondValue, double expected) {
        double actual = math.division(firstValue, secondValue);
        // Terceiro parametro - 2D - diz para considerar apenas 2 casas decimais
        // de actual - exemplo 5.90765 será considerado 5.90
        assertEquals(expected, actual, 2D, () -> firstValue + " / " + secondValue + " did not produce " + expected);
    }

    @DisplayName("Test divisions with parameters and with CsvFileSource")
    @ParameterizedTest
    @CsvFileSource(resources = "/DivisionTest.csv")
    void testDivisionWithoCsvFileSource(double firstValue, double secondValue, double expected) {
        double actual = math.division(firstValue, secondValue);
        // Terceiro parametro - 2D - diz para considerar apenas 2 casas decimais
        // de actual - exemplo 5.90765 será considerado 5.90
        assertEquals(expected, actual, 2D, () -> firstValue + " / " + secondValue + " did not produce " + expected);
    }

    @DisplayName("Test Value Source")
    @ParameterizedTest
    @ValueSource(strings = {"Nome1", "Nome2", "Nome3"})
    void testValueSource(String name) {
        System.out.println(name);
        assertNotNull(name);
    }
}