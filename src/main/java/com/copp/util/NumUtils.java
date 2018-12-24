package com.copp.util;

public class NumUtils {
    public static int getNumOfDigits(int num ){
        int count=1;
        while(num/10>0){
            count++;
            num/=10;
        }
        return count;
    }
}
