package com.examples.java.service;

import com.examples.java.dao.CalculatorDao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// STEP 1 - Add mockito dependency
// STEP 2 - Enable Mockito and JUnit Integration
@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    // STEP 3 - Mock the target class
    @Mock
    CalculatorDao calcDao;

    // STEP 4 - Inject mock objects into client
    @InjectMocks
    CalculatorService calc = new CalculatorService();

    @BeforeAll
    public static void initialize() {
        System.out.println("BeforeAll called...");
    }

    @BeforeEach
    public void createCalcInstance() {
        System.out.println("BeforeEach called...");
    }

    @Test
    public void shouldReturnPositiveValue_WhenAddTwoPositiveValues() {
        // STEP 4 - Mock logic
        Mockito.when(calcDao.add(10,20)).thenReturn(30);

        int out = calc.add(10,20); // 40
        assertEquals(30, out);
    }

    @Test
    public void shouldReturnNegativeValue_WhenAddTwoNegativeValues() {
        Mockito.when(calcDao.add(-10,-20)).thenReturn(-30);

        int out = calc.add(-10,-20);
        assertEquals(-30, out);
    }

    @Test
    public void shouldReturnPositiveValue_WhenSubtractFromBiggerToSmallerValue() {
        Mockito.when(calcDao.subtract(20,10)).thenReturn(10);

        int out = calc.subtract(20,10);
        assertEquals(10, out);
    }

    @Test
    public void shouldReturnNegativeValue_WhenSubtractFromSmallerToBiggerValue() {
        Mockito.when(calcDao.subtract(10,20)).thenReturn(-10);

        int out = calc.subtract(10,20);
        assertEquals(-10, out);
    }

    @Test
    public void shouldReturnNegativeValue_WhenSubtractFromBiggerToSmallerNegValues() {
        Mockito.when(calcDao.subtract(-30,-20)).thenReturn(-10);

        int out = calc.subtract(-30,-20);
        assertEquals(-10, out);
    }

    @Test
    public void shouldReturnPositiveValue_WhenSubtractFromSmallerToBiggerNegValues() {
        Mockito.when(calcDao.subtract(-20,-30)).thenReturn(10);

        int out = calc.subtract(-20,-30);
        assertEquals(10, out);
    }

    @Test
    public void shouldThrowException_WhenDivideByZero() {
        Mockito.when(calcDao.divide(10,0)).thenThrow(new ArithmeticException("Can't divide by zero"));

//        int out = calc.divide(10,0);
//        assertEquals(0, out);
        Throwable ex = assertThrows(ArithmeticException.class, () -> calc.divide(10,0));
        assertEquals("Can't divide by zero", ex.getMessage());
    }

    @AfterEach
    public void cleanCalcInstance() {
        System.out.println("AfterEach called..");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("AfterAll called..");

    }
}
