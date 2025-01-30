package com.examples.junit.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.examples.junit.service")
//@SelectClasses({AssertionTest.class, AssumptionTest.class, ExceptionHandlingTest.class})
public class AllUnitTest {}
