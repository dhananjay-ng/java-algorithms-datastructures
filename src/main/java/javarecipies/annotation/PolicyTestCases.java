package javarecipies.annotation;

import java.io.IOException;

public class PolicyTestCases {
    @TestCase(willThrow = IOException.class)
    public static void TestCase1(){

    }

    public static void TestCase2(){

    }
}
