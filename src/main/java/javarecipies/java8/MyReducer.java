package javarecipies.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MyReducer {
    static <T> T reduce(List<T> values, T identity, BinaryOperator<T> binaryOperator) {
        T result = identity;
        for (T value : values) {
            result = binaryOperator.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryOperator<Integer> adder = (integer, integer2) -> integer + integer2;
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(reduce(integers, 0, adder));

    }
}
