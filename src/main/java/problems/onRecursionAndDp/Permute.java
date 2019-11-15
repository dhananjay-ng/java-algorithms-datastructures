package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(res, 0, nums);
        return res;
    }

    public static void permuteHelper(List<List<Integer>> res, int i, int[] nums) {
        if (i == nums.length) {
            List<Integer> newRow = new ArrayList<>();
            for (int i1 = 0; i1 < nums.length; i1++) {
                newRow.add(nums[i1]);
            }
            res.add(newRow);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(res, i + 1, nums);
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        permute(a).forEach(integers -> System.out.println(integers.toString()));
    }
}
