package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static List<List<Integer>> subsetSum(List<Integer> nums, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsetsumrec(nums, sum, res,path, nums.size());

        return res;
    }

    private static void subsetsumrec(List<Integer> nums, int sum, List<List<Integer>> res, List<Integer> path, int i) {
        if (sum == 0) {
            res.add(path);
            path.remove(path.size()-1);
        }
        path.add(nums.get(i));
       // subsetsumrec(nums, res, sum-nums.get(i), );
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(5);
        nums.add(8);
        nums.add(4);
        nums.add(6);
        nums.add(11);
        subsetSum(nums, 13).forEach(integers -> {
            System.out.println(integers.toString());
        });
    }
}
