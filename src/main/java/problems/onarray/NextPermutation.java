package problems.onarray;

import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List<Integer> nextPermutation(List<Integer> perm) {
        int i;
        for( i= perm.size()-2;i>=0;i--) {
            if (perm.get(i) < perm.get(i+1)) {
                break;
            }
        }
        if (i==-1) {
            return Collections.emptyList();
        }

        for (int j= perm.size()-1;j>i;j--) {
            if (perm.get(j)>perm.get(i)){
                Collections.swap(perm,i,j);
                break;
            }
        }
        Collections.reverse(perm.subList(i+1,perm.size()));


        return perm;
    }
}
