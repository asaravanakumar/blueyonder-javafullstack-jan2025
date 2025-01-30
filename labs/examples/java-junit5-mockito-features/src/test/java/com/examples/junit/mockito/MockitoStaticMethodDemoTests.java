package com.examples.junit.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoStaticMethodDemoTests {

    @Test
    public void whenMockStaticMethod_thenMockWorks() {

        MyDictionary myDict = new MyDictionary();

        // Mocks static methods
        mockStatic(MyDictionary.class);

        when(MyDictionary.getDictionaryName()).thenReturn("Training Dictionary");

        assertEquals("Training Dictionary", MyDictionary.getDictionaryName());
    }

    @Test
    public void whenMockStaticClass_thenMockWorks() {

        mockStatic(MyDictionary.DictionaryUtils.class);
        when(MyDictionary.DictionaryUtils.getDisplayName()).thenReturn("Testing Dictionary");

        assertEquals("Testing Dictionary", MyDictionary.DictionaryUtils.getDisplayName());
    }
}
