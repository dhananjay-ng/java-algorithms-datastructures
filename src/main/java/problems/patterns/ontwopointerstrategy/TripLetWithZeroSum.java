package problems.patterns.ontwopointerstrategy;

import java.util.Arrays;

public class TripLetWithZeroSum {
    /**
     * Given an array A[] of N elements. The task is to complete the function which returns true if triplets exists in array A whose sum is zero else returns false.
     *
     * Input Format:
     * The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N, denoting the number of elements in array. The second line of each test case contains N space separated values of the array.
     *
     * Output:
     * For each test case, output will be 1 if triplet exists else 0.
     *
     * Your Task:
     * Your task is to complete the function findTriplets() which check if the triplet with sum 0 exists or not. This is of boolean type which returns either true of false.
     */
    public boolean findTriplets(int a[] , int n)
    {
        Arrays.sort(a);

        for(int i=0;i<a.length-2;i++) {
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = a[j]+a[k]+a[i];
                if(sum == 0) return true;
                else if(sum > 0) k--;
                else j++;
            }
        }
        return false;
    }
}
