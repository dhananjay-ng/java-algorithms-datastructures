package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IBSubset {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

        res.add(new ArrayList<>());

        for (int i = 0; i < A.size(); i++) {
            for (List l : res) {
                ArrayList<Integer> subset = new ArrayList<>();
                subset.addAll(l);
                subset.add(A.get(i));
                temp.add(subset);
            }
            res.addAll(temp);
            temp.clear();
        }

        Collections.sort(res, (o1, o2) -> compare(o1,o2));

        return res;
    }

    private static int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        if (o1.isEmpty()) return -1;
        if (o2.isEmpty()) return 1;
        int small = o1.size();
        small = o2.size() > small ? small : o2.size();
        for (int i=0;i<small;i++) {
            if(o1.get(i)!=o2.get(i)) {
                return o1.get(i) - o2.get(i);
            }
        }
        if(o1.size() > o2.size()) return 1;
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(15);
        a.add(20);
        a.add(12);
        a.add(19);
        a.add(4);

        System.out.println(subsets(a).toString());
    }
}
