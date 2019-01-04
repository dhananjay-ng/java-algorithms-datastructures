package com.copp.primitives;

public class BitUtil {
    /***
     * Properties for numbers which are powers of 2, is that they have one and only one bit set in their binary representation.
     * If the number is neither zero nor a power of two, it will have 1 in more than one place. So if x is a power of 2 then x & (x-1)
     * will be 0.
     */
    public static boolean isPowerOfTwo(int x) {
        // x will check if x == 0 and !(x & (x - 1)) will check if x is a power of 2 or not
        return (x != 0 && (x & (x - 1)) == 0);
    }

    /****
     *the relationship between the bits of x and x-1. So as in x-1, the rightmost 1 and bits right to it are flipped,
     *then by performing x&(x-1), and storing it in x, will reduce x to a number containing number of ones(in its binary form)
     *less than the previous state of x, thus increasing the value of count in each iteration.
     */
    public static int countOneInNumber(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /***
     * To check if the ith bit is set or not (1 or not), we can use AND operator.
     * Let’s say we have a number N, and to check whether it’s ith bit is set or not,
     * we can AND it with the number 2 thepower i . The binary form of 2i contains only ith bit as set (or 1),
     * else every bit is 0 there. When we will AND it with N, and if the ith bit of N is set, then it will
     * return a non zero number (2i to be specific), else 0 will be returned.
     * Using Left shift operator, we can write 2i as 1 << i . Therefore:
     */
    public static boolean isIthBitSet(int n, int i) {
        return (n & (1 << i)) > 0;
    }

    public static void possibleBitSubsets(char A[], int N) {
        for (int i = 0; i < (1 << N); ++i) {
            for (int j = 0; j < N; ++j)
                if (isIthBitSet(i, j)) {//j is i here
                    System.out.print(A[j] + ",");
                }

            System.out.println();
        }
    }

    public static long largestPowerOfTwo(long n){
        n|=(n>>1);
        n|=(n>>2);
        n|=(n>>4);
        n|=(n>>8);

        return (n+1)>>1;

    }
    public static void main(String[] args) {
//        System.out.println(BitUtil.isPowerOfTwo(8));
//        System.out.println(BitUtil.isPowerOfTwo(7));
//        System.out.println(BitUtil.countOneInNumber(8));
//        System.out.println(BitUtil.countOneInNumber(7));
//        System.out.println(BitUtil.isIthBitSet(8, 3));
//        System.out.println(BitUtil.isIthBitSet(7, 4));
//        char A[]={'a','b','c'};
//        BitUtil.possibleBitSubsets(A, 3);
        System.out.println(BitUtil.largestPowerOfTwo(16));


    }
}
