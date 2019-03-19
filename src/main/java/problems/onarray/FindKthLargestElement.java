package problems.onarray;

import java.util.Arrays;

public class FindKthLargestElement {

    //Time O(nlog(n)) // Quick Sort as int is primitive
    public static int findKthLargestSortingBased(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Time O(n*k)
    public static int findKthLargestBubbuleSortBased(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(findKthLargestBubbuleSortBased(arr, 3));
        System.out.println(findKthLargestSortingBased(arr, 3));
    }
}
