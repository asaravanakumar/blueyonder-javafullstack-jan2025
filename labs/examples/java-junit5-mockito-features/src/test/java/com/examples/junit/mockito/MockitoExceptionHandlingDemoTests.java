package com.examples.junit.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoExceptionHandlingDemoTests {

    @Test
    void givenNonVoidReturnType_whenUsingWhenThen_thenExceptionIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
        when(dictMock.getMeaning(anyString())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"));
    }

    @Test
    void givenVoidReturnType_whenUsingDoThrow_thenExceptionIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
        doThrow(IllegalStateException.class).when(dictMock)
                .add(anyString(), anyString());

        assertThrows(IllegalStateException.class, () -> dictMock.add("word", "meaning"));
    }

    @Test
    void givenNonVoidReturnType_whenUsingWhenThenAndExeceptionAsNewObject_thenExceptionIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
        when(dictMock.getMeaning(anyString())).thenThrow(new NullPointerException("Error occurred"));

        assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"));
    }

    @Test
    void givenNonVoidReturnType_whenUsingDoThrowAndExeceptionAsNewObject_thenExceptionIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
        doThrow(new IllegalStateException("Error occurred")).when(dictMock)
                .add(anyString(), anyString());

        assertThrows(IllegalStateException.class, () -> dictMock.add("word", "meaning"));
    }

    @Test
    void givenSpyAndNonVoidReturnType_whenUsingWhenThen_thenExceptionIsThrown() {
        MyDictionary dict = new MyDictionary();
        MyDictionary spy = spy(dict);
        when(spy.getMeaning(anyString())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> spy.getMeaning("word"));
    }
}
