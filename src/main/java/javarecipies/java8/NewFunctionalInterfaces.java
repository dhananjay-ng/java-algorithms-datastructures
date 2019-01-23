package javarecipies.java8;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class NewFunctionalInterfaces {

    public static void main(String[] args) {
        Consumer<Object> printer = System.out::println;
        printer.accept("Dhananjay");

        DoubleConsumer doubleConsumer = System.out::println;
        doubleConsumer.accept(2.1d);

        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        List<String> list = listSupplier.get();
        list.add("Dhananjay");
        list.add("Nagargoje");
        printer.accept(list);

        BiFunction<Double, Double, Double> power = Math::pow;
        printer.accept(power.apply(2.0d, 3.0d));

        Predicate<Integer> isGreaterThan10 = x-> x>10;
        printer.accept(isGreaterThan10.test(9));

    }

}
