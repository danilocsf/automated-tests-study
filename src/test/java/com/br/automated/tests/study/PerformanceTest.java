package com.br.automated.tests.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PerformanceTest {

    @Test
    //@Timeout(1) -> Testa se o método será executado em até um segundo
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS) // -> Testa se o método será executado em até 15 ms
    @DisplayName("Testing performance")
    void testPerformance() {
        int[] numbers = {21, 32, 4, 5, 1};
        for (int i = 0; i < 1000000; i++) {
            numbers[0] = i;
        }
    }
}