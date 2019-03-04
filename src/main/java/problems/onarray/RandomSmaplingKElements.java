package problems.onarray;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSmaplingKElements {
    public static void randomSampling(int k, List<Integer> A) {
        Random ra = new Random();
        for (int i=0;i<k;i++){
            Collections.swap(A,i,i+ra.nextInt(A.size()-i));
        }
    }
}
