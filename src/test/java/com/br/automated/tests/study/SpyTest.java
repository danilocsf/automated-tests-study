package com.br.automated.tests.study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
When Mockito creates a mock, it does so from the Class of a Type,
not from an actual instance. The mock simply creates a bare-bones shell
instance of the Class, entirely instrumented to track interactions with it.

On the other hand, the spy will wrap an existing instance.
It will still behave in the same way as the normal instance;
the only difference is that it will also be instrumented to track all
the interactions with it.

As we can see below, adding an element into the mocked list doesn’t actually add anything;
it just calls the method with no other side effects.

A spy, on the other hand, will behave differently; it will actually call the real
implementation of the add method and add the element to the underlying list:
 */
public class SpyTest {

    @Test
    void testV1WithSpy() {
        // Given / Arrange
        List<String> mockArrayList = spy(ArrayList.class);

        // When / Act & Then / Assert
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Foo-Bar");

        assertEquals(5, mockArrayList.size());
    }
    @Test
    void testV1WithMock() {
        // Given / Arrange
        List<String> mockArrayList = mock(ArrayList.class);

        // When / Act & Then / Assert
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Foo-Bar");

        assertEquals(5, mockArrayList.size());
    }

    @Test
    void testV2WithSpy() {
        // Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        // When / Act & Then / Assert
        assertEquals(0, spyArrayList.size());

        spyArrayList.add("Foo-Bar");
        //Se fosse mock, aqui teria o valor 0
        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Foo-Bar");
        assertEquals(0, spyArrayList.size());
    }

    @Test
    void testV2WithMock() {
        // Given / Arrange
        List<String> spyArrayList = mock(ArrayList.class);

        // When / Act & Then / Assert
        assertEquals(0, spyArrayList.size());
        spyArrayList.add("Foo-Bar");

        //So fosse Spy, aqui teria o valor 1
        assertEquals(0, spyArrayList.size());

        spyArrayList.remove("Foo-Bar");
        assertEquals(0, spyArrayList.size());
    }

    @Test
    void testV3() {
        List<String> spyArrayList = spy(ArrayList.class);
        assertEquals(0, spyArrayList.size());
        when(spyArrayList.size()).thenReturn(5);
        assertEquals(5, spyArrayList.size());
    }

    @Test
    void testV4() {
        List<String> spyArrayList = spy(ArrayList.class);
        spyArrayList.add("Foo-Bar");

        verify(spyArrayList).add("Foo-Bar");
        // verify(spyArrayList, never()).remove("Foo-Bar");
        verify(spyArrayList, never()).remove(anyString());
        verify(spyArrayList, never()).clear();
    }
}