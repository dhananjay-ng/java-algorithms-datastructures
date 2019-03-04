package problems.onarray;

import java.util.*;

public class RandomSubset {
    public static List<Integer> randomSubsetMapBased(int n, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        List<Integer> result = new ArrayList<>(k);
        Random rk = new Random();

        for (int i = 0; i < k; i++) {
            int rand = i + rk.nextInt(n - i);
            Integer pt1 = maps.get(i);
            Integer pt2 = maps.get(rand);

            if (pt1 == null && pt2 == null) {
                maps.put(i, rand);
                maps.put(rand, i);
            } else if (pt1 != null && pt2 == null) {
                maps.put(rand, pt1);
                maps.put(i, rand);
            } else if (pt1 == null && pt2 != null) {
                maps.put(i, pt2);
                maps.put(rand,i);
            } else {
                maps.put(i, pt2);
                maps.put(rand, pt1);
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(maps.get(i));
        }
        return result;
    }
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
