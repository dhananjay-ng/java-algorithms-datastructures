package problems.onmath.gfg;

import java.util.ArrayList;

public class Allfactors {
    public static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        for(int i = 1;i<=Math.sqrt(A);i++) {
            if(A%i == 0) {
                res.add(i);

                other.add(A/i);
            }
        }
        if(other.size() > 0){
            if(other.get(other.size()-1)!=res.get(res.size()-1)) {
                res.add(other.size()-1);
            }
            for(int i=other.size()-2;i>=0;i--)
                res.add(other.get(i));

        }
        return res;
    }

    public static void main(String[] args) {
        allFactors(85463);
    }
}
