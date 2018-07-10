package com.copp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericsEasyOne {
    public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }

    /* Varargs
     */
    public static <T> List<T> tooList(T... arr) {

        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);

        return list;
    }

    /*
       Wildcards and Subtype| Wildcards and supertype
     */
    public static <T> void copy1(List<T> dst, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static <T> void copy2(List<T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static <T> void copy3(List<? super T> dst, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static <T> void copy4(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }


    public static void main(String dgn[]) {
        System.out.println("Generics : One");
        List<Integer> ints = Arrays.asList(1, 2, 3);
        for (int i : ints)
            System.out.print(i + " ");

        String[] a = {"amy", "Dj", "MJ"};
        System.out.println(toList(a));
        System.out.println(tooList(1, 2, 3));


        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints1 = Arrays.asList(5, 6);
        List<Integer> intts2 = new ArrayList<Integer>();
        List<Number> inttn2 = new ArrayList<Number>();

        /*
            Wildcard subtype | Wildcard supertype
        */
        copy1(intts2, ints1);
        copy2(objs, ints1);
        copy3(inttn2, ints1);
        copy4(objs, ints1);


    }

}