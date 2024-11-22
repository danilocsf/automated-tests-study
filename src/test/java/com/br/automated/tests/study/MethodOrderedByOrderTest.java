package com.br.automated.tests.study;

import org.junit.jupiter.api.*;

/*
    Por padrão, os métodos são executados por ordem crescente de nomes
    Ao utilizar a anotação @TestMethodOrder(MethodOrderer.OrderAnnotation.class), os métodos serão executados
    de acordo com a configuração de @Order.
    Se repetir o valor de Order, prevalecerá a ordem alfabética.
    Muito utilizado em testes de integração onde o resultado de uma execução pode depender de outra.

    Ao utilizar @Order na classe, é determinada a ordem em que essa classe será executada.
    Para tanto, é necessário que tenha-se a seguinte configurção num arquivo junit-platform.properties:
    junit.jupiter.testclass.order.default=org.junit.jupiter.api.ClassOrderer$OrderAnnotation
 */

@Order(1)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrderTest {

    @Test
    @Order(3)
    @DisplayName("Testing B")
    void testB() {
        System.out.println("B");
    }

    @Test
    @Order(1)
    @DisplayName("Testing C")
    void testC() {
        System.out.println("C");
    }

    @Test
    @Order(2)
    @DisplayName("Testing A")
    void testA() {
        System.out.println("A");
    }
}