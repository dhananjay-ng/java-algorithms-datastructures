package problems.onsorting;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int lastPos = A.length - 1;
        List<Integer> res = new ArrayList<>();
        while(lastPos > 0) {
            int max = A[lastPos];
            int maxIndx = lastPos;
            boolean isSorted = true;
            for(int i = 0; i < lastPos; i++) {
                if(A[i] > max) {
                    maxIndx = i;
                    max = A[i];
                }
                if(A[i] > A[i+1]) {
                    isSorted = false;
                }
            }
            if(isSorted) {
                return res;
            }
            if(maxIndx == lastPos){
                lastPos--;
                continue;
            }
            else{
                if(maxIndx != 0) {
                    reverse(A, maxIndx);
                    res.add(maxIndx+1);
                }
                reverse(A, lastPos);
                res.add(lastPos+1);
                lastPos--;
            }
        }
        return res;

    }
    public static void reverse(int[] A, int lastPos){
        int start = 0;
        while(start < lastPos) {
            int temp = A[start];
            A[start] = A[lastPos];
            A[lastPos] = temp;

            start++;
            lastPos--;
        }
    }
}
