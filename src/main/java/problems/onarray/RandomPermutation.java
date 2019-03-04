package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomPermutation {
    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i=0;i<n;i++) res.add(i);
        Random rk = new Random();
        for (int i = 0; i < n; i++){
            Collections.swap(res,i,i+rk.nextInt(n-i));
        }
        return res;
    }
}
