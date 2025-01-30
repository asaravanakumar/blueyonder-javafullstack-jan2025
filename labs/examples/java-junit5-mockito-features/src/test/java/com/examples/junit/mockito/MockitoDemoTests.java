package com.examples.junit.mockito;

import static org.junit.jupiter.api.Assertions.*;

import com.examples.junit.mockito.MyDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MockitoDemoTests {

    // Alternative to enable Mockito instead of MockitoExtension
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        System.out.println(mockList.size());

        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);

        System.out.println(mockList.size());
        assertEquals(100, mockList.size());

//        Mockito.when(mockList.size()).thenThrow(new RuntimeException());
//        System.out.println(mockList.size());
//        assertThrows(RuntimeException.class, () -> mockList.size());

    }

    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());

    }
}