package problems.onmath.gfg;

import java.util.ArrayList;

public class PrimeSum {
    /**
     * Prime Sum
     * Asked in:
     * Epic systems
     * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
     *
     * NOTE A solution will always exist. read Goldbach’s conjecture
     *
     * Example:
     *
     *
     * Input : 4
     * Output: 2 + 2 = 4
     *
     * If there are more than one solutions possible, return the lexicographically smaller solution.
     *
     * If [a, b] is one solution with a <= b,
     * and [c,d] is another solution with c <= d, then
     *
     * [a, b] < [c, d]
     *
     * If a < c OR a==c AND b < d.

     */
    public ArrayList<Integer> primesum(int A) {
        int sqrt  = A+1;
        boolean a[] = new boolean[sqrt];
        a[0]=true;a[1]=true;
        a[2]=false;a[3]=false;
        for(int i=2;i<sqrt;i++){
            if(a[i] == false){
                int mul=2;
                for(int j=i*mul;j<=A;){
                    a[j] = true;
                    mul++;
                    j=i*mul;
                }
            }
        }
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(a[i] == false && a[A-i] == false){
                res.add(i);
                res.add(A-i);
                break;
            }
        }
        return res;
    }
}
