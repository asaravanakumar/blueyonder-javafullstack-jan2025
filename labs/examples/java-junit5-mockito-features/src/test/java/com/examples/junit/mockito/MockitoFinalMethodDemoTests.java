package com.examples.junit.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoFinalMethodDemoTests {

    @Test
    public void whenMockFinalMethod_thenMockWorks() {

        MyDictionary myDict = new MyDictionary();

        MyDictionary mock = mock(MyDictionary.class);
        when(mock.count()).thenReturn(1);

        assertEquals(1, mock.count());
    }

    @Test
    public void whenMockFinalClass_thenMockWorks() {

        FinalDictionary mock = mock(FinalDictionary.class);
        when(mock.size()).thenReturn(2);

        assertEquals(2, mock.size());
    }
}
