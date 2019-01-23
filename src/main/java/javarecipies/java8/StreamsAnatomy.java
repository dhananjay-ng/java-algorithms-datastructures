package javarecipies.java8;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAnatomy {
    public static void main(String[] args) {
        List<Integer> profits = Arrays.asList(4,5,2,6,4,7,8,3,45,6,345,3324,576,2342,33);

        //find first three max profits
        List<Integer> maxThree = profits.stream()//stream source is collection
                                    .sorted(Comparator.reverseOrder()) //intermidiate stateful operation
                                    .limit(3)
                                    .collect(Collectors.toList()); //termainal operation

        System.out.println(maxThree);
    }
}
