package javarecipies.comparator;

import java.util.Collection;
import java.util.Comparator;
/**
 * Created by apprentice on 7/13/2018.
 */

public class ComparetoExample {


    private static <T extends Object& Comparable<? super T>> T myMax(Collection<? extends T> collection){
   // private static <T extends Comparable<T>> T myMax(Collection<T> collection){
        T candidate= collection.iterator().next();
        for (T e:collection){
            if(candidate.compareTo(e)<0) candidate=e;
        }
         return candidate;
    }

    public static void main(String[] args) {
        Integer xoxo=2;

        System.out.println(xoxo.compareTo(3));

        System.out.println("Fruit Exaple:");
        Fruit ft=new Fruit("Mango",12);
        Apple ap=new Apple("Apple",13);
        Orange or=new Orange("Orange",12);

       System.out.println(ft.compareTo(ap));
        System.out.println(ft.compareTo(or));
        System.out.println(or.compareTo(ap));

        Comparator<Fruit> compt = (fruit, t1) -> fruit.getSize() > t1.getSize() ? 1 : fruit.getSize() < t1.getSize() ? -1 : 0;


        Comparator<Fruit> comptWithLambda=(Fruit fruit, Fruit t1) ->
                fruit.getSize()>t1.getSize()?  1:fruit.getSize()<t1.getSize()? -1: 0;


        System.out.println(compt.compare(ap,or));
        System.out.println(comptWithLambda.compare(ap,or));
    }
}
