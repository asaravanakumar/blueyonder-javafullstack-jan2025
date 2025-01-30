package com.examples.junit.mockito;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoPrivateMethodDemoTests {

    @Test
    void whenMockPrivateField_withReflection_thenMockWorks() throws Exception {
        Class<?> myDictClass = Class.forName("com.examples.junit.mockito.MyDictionary");
        MyDictionary myDict = (MyDictionary) myDictClass.getDeclaredConstructor().newInstance();
        Field field = myDictClass.getDeclaredField("wordMap");
        field.setAccessible(true);

        field.set(myDict, Map.of("Hi","Hello"));
        assertEquals("Hello", myDict.getMeaning("Hi"));
    }

    @Test
    void whenMockPrivateMethod_withReflection_thenMockWorks() throws Exception {
        Class<?> myDictClass = Class.forName("com.examples.junit.mockito.MyDictionary");
        MyDictionary myDict = (MyDictionary) myDictClass.getDeclaredConstructor().newInstance();
        Method method = myDictClass.getDeclaredMethod("getName");
        method.setAccessible(true);

        String name = (String) method.invoke(myDict);
//        System.out.println(name);
        assertEquals("Testing Dictionary", name);
    }


}
