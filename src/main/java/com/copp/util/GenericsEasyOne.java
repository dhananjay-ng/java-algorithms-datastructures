package com.copp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsEasyOne{
    public static  <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }

    /* Varargs
     */
    public static <T> List<T> tooList(T... arr){

        List<T> list=new ArrayList<T>();
        for (T elt : arr) list.add(elt);

        return list;
    }
    public static void main(String dgn[]) {
        System.out.println("Generics : One");
        List<Integer> ints= Arrays.asList(1,2,3);
        for(int i:ints)
            System.out.print(i+" ");

        String[] a = {"amy", "Dj","MJ"};
        System.out.println(toList(a));
        System.out.println(tooList(1,2,3));


    }

}