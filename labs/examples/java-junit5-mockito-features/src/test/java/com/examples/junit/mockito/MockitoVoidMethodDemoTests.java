package com.examples.junit.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoVoidMethodDemoTests {
    @Test
    public void whenAddCalled_doNothing_thenVerified() {
        MyDictionary myDict = mock(MyDictionary.class);
        doNothing().when(myDict).add(anyString(), anyString());
        myDict.add("learn", "gain or acquire knowledge");

        verify(myDict, times(1)).add("learn", "gain or acquire knowledge");
    }

    @Test
    void whenAddCalled_thenVerified() {
        MyDictionary myDict = mock(MyDictionary.class);
        myDict.add("practice", "actual application or use");

        verify(myDict, times(1)).add("practice", "actual application or use");
    }

    @Test
    void givenNull_whenAddCalled_thenThrowsException() {
        MyDictionary myDict = mock(MyDictionary.class);

        assertThrows(Exception.class, () -> {
            doThrow().when(myDict).add(isA(String.class), isNull());
        });

        myDict.add("skill", "");
    }

    @Test
    void givenArgumentCaptor_whenAddCalled_thenValueCaptured() {
        MyDictionary myDict = mock(MyDictionary.class);

        ArgumentCaptor<String> valueCapture = ArgumentCaptor.forClass(String.class);
        doNothing().when(myDict).add(any(String.class), valueCapture.capture());

        myDict.add("skill", "the ability to do something well");

        assertEquals("the ability to do something well", valueCapture.getValue());
    }

    @Test
    void givenDoAnswer_whenAddCalled_thenAnswered() {
        MyDictionary myList = mock(MyDictionary.class);

        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals("train", arg0);
            assertEquals("teach a particular skill", arg1);
            return null;
        }).when(myList).add(any(String.class), any(String.class));

        myList.add("train", "teach a particular skill");
    }

    @Test
    void givenDoCallRealMethod_whenAddCalled_thenRealMethodCalled() {
        MyDictionary myDict = spy(MyDictionary.class);

        doCallRealMethod().when(myDict).add(any(String.class), any(String.class));
        myDict.add("impact", "have a strong effect on someone or something");

        verify(myDict, times(1)).add("impact", "have a strong effect on someone or something");
    }

}
