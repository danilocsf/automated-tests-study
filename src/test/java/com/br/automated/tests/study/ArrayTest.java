package com.br.automated.tests.study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    @DisplayName("Testing if arrays are equals")
    void testArray() {
        int[] numbers = {21, 32, 4, 5 ,1};
        int[] expected = {1, 4, 5, 21, 32};
        Arrays.sort(numbers);
        assertArrayEquals(numbers, expected, () -> "Arrays are not equals");
    }
}