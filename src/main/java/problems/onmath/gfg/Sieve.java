package problems.onmath.gfg;

import java.util.ArrayList;

public class Sieve {
    public static ArrayList<Integer> sieve(int A) {
        boolean a[] = new boolean[A+1];
        a[0]=true;
        a[1]=true;
        a[2]=false;
        a[3]=false;
        a[5]=false;
        a[7]=false;
        for(int i=2;i<=Math.sqrt(A);i++){
            if(a[i] == false) {
                int mul=2;
                for(int j=i*mul;j<=A;mul++){
                    a[j]=true;
                    j=i*mul;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(a[i] == false) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sieve(10));
    }
}
