package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;

public class ArraySum {
    public static int solver(ArrayList<Integer> A) {
        Collections.sort(A);
        int cur=0;
        int remain=0;
        while (cur<=A.size()-1){
            while (cur+1<A.size()&& A.get(cur)==A.get(cur+1))
                cur++;

            if (cur==A.size())
                break;

            remain=A.size()-1-cur;
            if(A.get(cur)==remain)
                return 1;
            cur++;
        }

        return -1;
    }


    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int start=0;
        while (start<A.size()-1 && A.get(start)==0)
            A.remove(start);

        int cur = A.size();
        cur--;

        int hatcha=1;
        while (cur>=0){
            int sum=A.get(cur)+1;
            A.set(cur,sum%10);
            hatcha= sum/10;
            if (hatcha==0)
                break;
        }
        if (hatcha==1)
            A.add(0,1);

        return A;
    }

    public static void main(String[] args) {

        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(0);


        System.out.println(solver(aa));
    }
}
/*
#my first solution
 public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int cur = A.size();
        cur--;

        int start=0;
        for (int a:A){
            if(a==0){
                start++;
            }else
                break;
        }

        if (start==A.size()){
            start=cur;
        }
        int hatcha=0;
        while (cur>=start){
            if(A.get(cur)==9){
                A.set(cur,0);
                hatcha=1;
                cur--;
            }else if(A.get(cur)<9){
                A.set(cur,A.get(cur)+1);
                hatcha=0;
                break;
            }
        }
        if (hatcha==1 && start!=0){
            A.set(start-1,1);
            start--;
        }else if (hatcha==1){
            ArrayList<Integer> B=new ArrayList<>();
            B.add(0,1);
            B.addAll(A);
            return B;
        }
        if (start!=0){
            int j=0;
            for(int k=start;k<A.size();k++,j++){
                A.set(j,A.get(k));
            }
            int n= A.size();
            n--;
            while (n>=j){
                A.remove(n);
                n--;
            }
        }
        return A;
    }
 */