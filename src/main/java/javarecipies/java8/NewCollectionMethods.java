package javarecipies.java8;

import java.util.*;
import java.util.function.Consumer;

public class NewCollectionMethods {

     public static void main(String[] args) {
         Map<Integer, ArrayList<Integer>> map1 = new HashMap<>();
         Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
         ArrayList<Integer> l1 = new ArrayList<>();
         ArrayList<Integer> l2 = new ArrayList<>();
         l1.add(1);
         l1.add(2);
         l1.add(3);

         l2.add(4);
         l2.add(5);
         l2.add(6);

         map1.putIfAbsent(1, l1);
         map2.putIfAbsent(1, l2);

         Consumer<Object> cout = System.out::println;
         cout.accept(map1);
         cout.accept(map2);

         cout.accept("Merging map2 into map1");

         map2.forEach((key2, val2) -> {
             map1.merge(key2, val2, (oldval, newvalue) -> {
                 oldval.addAll(newvalue);
                 return oldval;
             });
         });

         cout.accept(map1);


     }

}
