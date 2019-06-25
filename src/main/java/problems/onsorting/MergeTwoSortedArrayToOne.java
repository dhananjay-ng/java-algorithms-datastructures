package problems.onsorting;

public class MergeTwoSortedArrayToOne {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastPos = m + n - 1;
        m--;
        n--;
        while(m>=0 && n>=0) {
            if(nums1[m] >= nums2[n]) {
                nums1[lastPos] = nums1[m];
                m--;
            } else {
                nums1[lastPos] = nums2[n];
                n--;
            }
            lastPos--;
        }

        while(n >=0 ){
            nums1[lastPos] = nums2[n];
            n--;
            lastPos--;
        }
    }
}
