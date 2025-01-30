package com.examples.junit.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoSpyMockInjectionDemoTests {

    // Injecting a Mock Into a Spy
//    @Mock
//    Map<String, String> wordMap;
//
//    @Spy
//    MyDictionary spyDic = new MyDictionary();
//
//    // Mockito doesn’t support injecting mocks into spies, below test case will fail
//    @Test
//    public void whenUseInjectSpyMocksAnnotation_thenCorrect() {
//        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
//
//        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
//    }

    // Creating and injecting the Spy manually
    @Mock
    Map<String, String> wordMap;

    MyDictionary spyDic;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        spyDic = Mockito.spy(new MyDictionary(wordMap));
    }

    // Below test case will pass, as we are injecting the spy mock manually
    @Test
    public void whenUseInjectSpyMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
    }
}
