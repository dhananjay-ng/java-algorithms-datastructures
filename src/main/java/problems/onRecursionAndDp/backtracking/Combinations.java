package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;

public class Combinations {
    public static ArrayList<ArrayList<Integer>> solve(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ini = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            ini.add(i);
        }
        res.add(new ArrayList<>(ini));
        int size = ini.size();
        while (true) {
            while (ini.get(size - 1) != n) {
                int temp = ini.get(size - 1);
                temp++;
                ini.set(size - 1, temp);
                res.add(new ArrayList<>(ini));
            }
            int j = size - 1;
            while (j - 1 >= 0 && ini.get(j - 1) + 1 >= ini.get(j)) {
                j--;
            }
            if (j <= 0) break;
            else {
                ini.set(j - 1, ini.get(j - 1) + 1);
                while (j < size) {
                    ini.set(j, ini.get(j - 1) + 1);
                    j++;
                }
                res.add(new ArrayList<>(ini));
            }
        }
        return res;
    }

    /**
     * For every element, you have 2 options. You may either include the element in your subset or you will not include the element in your subset.
     * Make the call for both the cases.
     */
    public static ArrayList<ArrayList<Integer>> solverec(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        ArrayList<Integer> ini = new ArrayList<>();
        rechelper(res, ini, 1, k, n);
        return res;
    }

    private static void rechelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ini, int j, int k, int n) {
        if (ini.size() == k) {
            res.add(new ArrayList<>(ini));
            return;
        }
        for (int i = j; i <= n; i++) {
            ini.add(i);
            rechelper(res, ini, i + 1, k, n);
            ini.remove(ini.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(solverec(2, 4).toString());
    }

}
