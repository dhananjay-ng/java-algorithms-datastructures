package problems.onarray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StreamSampling {
    public static List<Integer> onlineRandomSample(Iterator<Integer> stream,
                                                   int k) {
        List<Integer> result = new ArrayList<>(k);
        Random rk = new Random();
        for (int i = 0; stream.hasNext() && i < k; ++i) {
            result.add(stream.next());
        }
        int numberSoFar = k;
        while (stream.hasNext()) {
            Integer x = stream.next();
            int n = rk.nextInt(++numberSoFar);
            if (n < k) {
                result.set(n, x);
            }
        }
        return result;
    }
}
