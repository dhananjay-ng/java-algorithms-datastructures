package problems.onbitmanipulation;

import java.util.Arrays;

public class MinXorInArray {
    public static int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXorValue=Integer.MAX_VALUE;

        for(int i=0;i<A.length-1;i++){
            if((A[i]^A[i+1])<minXorValue){
                minXorValue=A[i]^A[i+1];
            }
        }
        return minXorValue;
    }
    public static long swap(long a, int i, int j) {
        if (((a >>> i) & 1) != ((a >>> j) & 1)) {
            // return toogleIthBit(toogleIthBit(a,i),j); or
            return a ^ (1 << i | 1 << j);
        }
        return a;
    }
    public static long reverse(long a) {
      for (int i=0,j=31;i<j;i++,j--){
          if (((a >>> i) & 1) != ((a >>> j) & 1)) {
               a ^= (1l << i | 1l << j);
          }
      }
      return a;
    }
    public static int singleNumber(final int[] A) {
        int res=A[0]^A[1];

        for (int i=2;i<A.length;i++){
            res^=A[i];
        }
        return res;
    }

    public static int divide(int A, int B) {
       int power=32;
       int Bpower=B<<32;
       int q=0;

       while(A>B){
           while (Bpower>A){
             Bpower>>>=1;
             power--;
           }
           A-=Bpower;
           q+=1L<<power;
       }

        return q;
    }
    public static int difference(int a,int b) {
        int count=0;
        while (a!=0||b!=0){
            if(((a&1)^(b&1))!=0){
                count++;
            }
            a>>>=1;
            b>>>=1;
        }
    return count;
    }
    public static int cntBits(int[] A) {
        int count=0;
        for (int i=0;i<A.length;i++){
            for (int j=i+1;j<A.length;j++){
                if (i==j)continue;
                int val=0;
                int a=A[i];
                int b=A[j];
                while (a!=0||b!=0){
                    if(((a&1)^(b&1))!=0){
                        val++;
                    }
                    a>>>=1;
                    b>>>=1;
                }
                count+=(val*2);
            }
        }
        return count;
    }
    public static int cntBitss(int[] A) {
        int count=0;
        for (int i=0;i<31;i++){
            int msk=1<<i;
            int numOne=0;
            int numZero=0;
            for (int j=0;j<A.length;j++){
                if((A[j]&msk)>0){
                    numOne++;
                }else {
                    numZero++;
                }
            }
            count+=(numOne*numZero*2);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a={1,3,5};
        System.out.println(cntBitss(a));

    }



}
