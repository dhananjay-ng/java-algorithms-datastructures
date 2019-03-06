package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonUniformRandomGenerator {
    public static int nonuniformRandomNumberGeneration(List<Integer> values,
                                                       List<Double> probabilities) {


        List<Double> pp = new ArrayList<>();
        pp.add(0.0);
        for (Double p : probabilities) {
            pp.add(pp.get(pp.size() - 1) + p);
        }
        Double rk = Math.random();
        int it = Collections.binarySearch(pp, rk);
        if (it < 0) {
            return values.get(((Math.abs(it) - 1) - 1));
        } else {
            return values.get(it);
        }
    }
}
