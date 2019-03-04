package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSubset {
    public static List<Integer> randomSubset(int n, int k) {
        List<Integer> result = new ArrayList<>(n);
        for (int i=0;i<n;i++)
            result.add(i);

        Random rk = new Random();
        for (int i=0;i<k;i++){
            Collections.swap(result,i,i+rk.nextInt(n-i));
        }
        return result.subList(0,k);
    }
}
