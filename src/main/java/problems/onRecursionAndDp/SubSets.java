package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();

        subs.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            for (List l : subs) {
                List<Integer> subset = new ArrayList<>();
                subset.addAll(l);
                subset.add(nums[i]);
                temp.add(subset);
            }
            subs.addAll(temp);
            temp.clear();
        }
        return subs;
    }

    /**
     * recursive
     **/


    public static List<List<Integer>> subsetsrec(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        helper(0, nums, res, subs);

        return subs;
    }

    public static void helper(int i, int[] nums, List<Integer> res, List<List<Integer>> subs) {

        if (i == nums.length) {
            List<Integer> newa = new ArrayList<>();
            newa.addAll(res);
            if (res.size() > 0) {
                res.remove(res.size() - 1);
            }
            subs.add(newa);
            return;
        }

        res.add(nums[i]);

        helper(i + 1, nums, res, subs);
        helper(i + 1, nums, res, subs);

    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        subsetsrec(a).forEach(integers -> System.out.println(integers.toString()));
    }
}
