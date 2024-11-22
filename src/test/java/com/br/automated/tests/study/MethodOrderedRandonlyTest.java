package com.br.automated.tests.study;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/*
    Por padrão, os métodos são executados por ordem crescente de nomes
    Ao utilizar a anotação @TestMethodOrder(MethodOrderer.Random.class), os métodos serão executados
    aleatoriamente. Isso é útil para garantir que nenhum teste dependa do outro.

    Ao utilizar @Order na classe, é determinada a ordem em que essa classe será executada.
    Para tanto, é necessário que tenha-se a seguinte configurção num arquivo junit-platform.properties:
    junit.jupiter.testclass.order.default=org.junit.jupiter.api.ClassOrderer$OrderAnnotation
 */
@Order(2)
@TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderedRandonlyTest {

    @Test
    @DisplayName("Testing B")
    void testB() {
        System.out.println("B");
    }

    @Test
    @DisplayName("Testing C")
    void testC() {
        System.out.println("C");
    }

    @Test
    @DisplayName("Testing A")
    void testA() {
        System.out.println("A");
    }
}