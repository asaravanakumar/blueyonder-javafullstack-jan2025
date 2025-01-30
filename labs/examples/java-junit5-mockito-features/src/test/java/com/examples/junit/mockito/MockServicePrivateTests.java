package com.examples.junit.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Field;

public class MockServicePrivateTests {
    private Person mockedPerson;

    @BeforeEach
    public void setUp(){
        mockedPerson = mock(Person.class);
    }

    @Test
    void givenNameChangedWithReflection_whenGetName_thenReturnName() throws Exception {
        Class<?> mockServiceClass = Class.forName("com.examples.junit.mockito.MockService");
        MockService mockService = (MockService) mockServiceClass.getDeclaredConstructor().newInstance();
        Field field = mockServiceClass.getDeclaredField("person");
        field.setAccessible(true);
        field.set(mockService, mockedPerson);

        when(mockedPerson.getName()).thenReturn("Nathan");

        assertEquals("Nathan", mockService.getName());
    }

    @Test
    void givenNameChangedWithReflectionUtils_whenGetName_thenReturnName() throws Exception {
        MockService mockService = new MockService();
        Field field = ReflectionUtils
                .findFields(MockService.class, f -> f.getName().equals("person"),
                        ReflectionUtils.HierarchyTraversalMode.TOP_DOWN)
                .get(0);

        field.setAccessible(true);
        field.set(mockService, mockedPerson);

        when(mockedPerson.getName()).thenReturn("Nathan");

        assertEquals("Nathan", mockService.getName());
    }


}
