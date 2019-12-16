package javarecipies.java8;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;

public class LambdaDemo {
    public static void main(String args[]) {

        DoStuff ds1 = () -> System.out.println("I ran via lambda expression");
        DoStuff ds2 = new DoStuff() {
            public void work() {
                System.out.println("I ran via anonymous class");
            }
        };
        ds1.work();
        ds2.work();


        Comparator<Integer> descendingComparator = (i1, i2) -> {
            return i2 - i1;
        };
        PriorityQueue<Integer> q = new PriorityQueue<>(descendingComparator);

        // add integers to q in ascending order
        for(int i=0;i<=10;i++) {
            q.add(i);
        }

        // verify the numbers are printed in descending order
        for(int i=0;i<=10;i++) {
            System.out.println(q.poll());
        }

        RaiseToPower square = (x) -> {return x*x;};
        RaiseToPower cube = (x) -> {return x*x*x;};
        System.out.println(square.raiseToX(3));


        Function<Integer, Integer> power = (a) -> a*a;
        System.out.println(power.apply(3));
    }
}

// A functional interface
interface DoStuff {
    void work();
}
interface RaiseToPower {

    int raiseToX(int x);

}