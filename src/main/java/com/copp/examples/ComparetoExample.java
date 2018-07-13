package com.copp.examples;

import java.util.*;
/**
 * Created by apprentice on 7/13/2018.
 */

public class ComparetoExample {

    private static <T extends Comparable<T>> T myMax(Collection<T> collection){
        T candidate= collection.iterator().next();
        for (T e:collection){
            if(candidate.compareTo(e)<0) candidate=e;
        }
         return candidate;
    }

    public static void main(String[] args) {
        Integer xoxo=new Integer(2);

        System.out.println(xoxo.compareTo(2));

    }
}
