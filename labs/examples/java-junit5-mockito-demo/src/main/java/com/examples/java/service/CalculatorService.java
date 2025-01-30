package com.examples.java.service;

import com.examples.java.dao.CalculatorDao;

public class CalculatorService {

    CalculatorDao calcDao = new CalculatorDao();

    public int add(int a, int b) {
        return calcDao.add(a,b);
    }

    public int subtract(int a, int b) {
        return calcDao.subtract(a,b);
    }

    public int multiply(int a, int b) {
        return calcDao.multiply(a,b);
    }

    public int divide(int a, int b) {
        return calcDao.divide(a,b);
    }
}
