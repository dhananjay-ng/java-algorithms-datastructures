package com.copp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
       
        InputReader ir=new InputReader(System.in);
        int n=ir.readInt();
        StringBuilder result=new StringBuilder();
        result.append(n).append("\n");
        System.out.println(result);
    }
}
