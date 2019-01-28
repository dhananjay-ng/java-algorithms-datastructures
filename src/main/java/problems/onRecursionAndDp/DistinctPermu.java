package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DistinctPermu {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        res = new ArrayList<>();
        Collections.sort(A);
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (!freq.containsKey(A.get(i))) {
                freq.put(A.get(i), 0);
            }
            freq.put(A.get(i), freq.get(A.get(i)) + 1);
        }
        permu(A, new ArrayList<>(), freq);
        return res;
    }

    public static void permu(ArrayList<Integer> A, ArrayList<Integer> perm, Map<Integer, Integer> freq) {
        if (perm.size() == A.size()) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                perm.add(entry.getKey());
                System.out.println(perm.toString());
                freq.put(entry.getKey(), entry.getValue() - 1);
                permu(A, perm, freq);
                freq.put(entry.getKey(), entry.getValue() + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        permute(a);
        System.out.println(res.toString());
    }
}
