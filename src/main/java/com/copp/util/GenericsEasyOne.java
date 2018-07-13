package com.copp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toSet;

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


    /*
        Get & Put Principle
     */
    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }
    public static void main(String dgn[]) {
        System.out.println("Generics : One");
        List<Integer> ints = Arrays.asList(1, 2, 3);
        for (int i : ints)
            System.out.print(i + " ");

        String[] a = {"amy", "Dj", "MJ"};
        System.out.println(toList(a));
        System.out.println(tooList(1, 2, 3));


        List<Object> objs = Arrays.asList(2, 3.14, "four");
        List<Integer> ints1 = Arrays.asList(5, 6);
        List<Integer> intts2 = new ArrayList<Integer>();
        List<Number> inttn2 = new ArrayList<Number>();

        /*
            Wildcard subtype | Wildcard supertype
        */
//        copy1(intts2, ints1);
//        copy2(objs, ints1);
//        copy3(inttn2, ints1);
//        copy4(objs, ints1);

        //GET Princi
        List<Integer> ints2 = Arrays.asList(1,2,3);
         sum(ints2);
        List<Double> doubles = Arrays.asList(2.78,3.14);
         sum(doubles);
        List<Number> nums = Arrays.asList(1,2,2.78,3.14);
         sum(nums);

        // PUT principle When  <? Super T>
        List<Integer> ints3 = new ArrayList<Integer>();
        count(ints3, 5);
        List<Number> nums3 = new ArrayList<Number>();
        count(nums3, 5); nums3.add(5.0);
        List<Object> objs3 = new ArrayList<Object>();
        count(objs3, 5); objs3.add("five");

        System.out.println(
                nums.stream()
                    .filter(e -> e.intValue() > 1)
                    .map(e-> e.intValue()*2).collect(toSet())
        );

        nums.forEach(number -> {
            number=number.doubleValue()*2;
            System.out.println(number);}
        );


    }


}