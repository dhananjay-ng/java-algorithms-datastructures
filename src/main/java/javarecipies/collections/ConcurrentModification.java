package javarecipies.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {
    public static void main(String[] args) {

        List<Integer> modify = new ArrayList<>();
        modify.add(1);
        modify.add(2);
        modify.add(3);


        Iterator<Integer> it = modify.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            System.out.println(x);
            if (x == 1){
               //below line will cause ConcurrentModificationException as we have modified collection
               //without telling iterator
               // modify.remove(2);

               //to avoid exeception use iterator remove
                it.remove();
            }
        }

        modify = new ArrayList<>();
        modify.add(1);
        modify.add(2);
        modify.add(3);

        modify.removeIf(integer -> integer == 2);
        System.out.println(modify.toString());
    }
}
