package problems.onarray;


import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> keys = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (keys.containsKey(target-nums[i])){
                res[0] = keys.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            keys.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]  res ={2, 7, 11, 15};
        res = twoSum(res,9);
        System.out.println(res[0]+" "+res[1]);
    }
}
