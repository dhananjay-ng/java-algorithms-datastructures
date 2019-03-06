package problems.onarray;

import java.util.Arrays;
import java.util.List;

public class isValidSudoko {
    // Check if a partially filled matrix has any conflicts.
    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        boolean a[]= new boolean[10];
        //check rows for duplicate
        for (int i=0;i<partialAssignment.size();i++){
            Arrays.fill(a,false);
            for (int j=0;j<partialAssignment.size();j++){
                if (a[partialAssignment.get(i).get(j)] == true) {
                    return false;
                }
                if (partialAssignment.get(i).get(j)!=0)
                    a[partialAssignment.get(i).get(j)] = true;
            }
        }

        for (int i=0;i<partialAssignment.size();i++){
            Arrays.fill(a,false);
            for (int j=0;j<partialAssignment.size();j++){
                if (a[partialAssignment.get(j).get(i)] == true) {
                    return false;
                }
                if (partialAssignment.get(j).get(i)!=0)
                    a[partialAssignment.get(j).get(i)] = true;
            }
        }

        int colEnd=2;
        int colStart=0;
        int rowEnd=2;
        int rowStart=0;
        while (true) {
            Arrays.fill(a,false);

            for (int i=colStart;i<=colEnd;i++){
                for (int j=rowStart;j<=rowEnd;j++){
                    if (a[partialAssignment.get(i).get(j)] == true) {
                        return false;
                    }
                    if (partialAssignment.get(i).get(j)!=0)
                        a[partialAssignment.get(i).get(j)] = true;

                }
            }
            if (colEnd+3<partialAssignment.size()){
                colEnd+=3;
                colStart+=3;
            } else {
                colEnd=2;
                colStart=0;
                rowStart+=3;
                rowEnd+=3;
            }

            if (rowEnd>partialAssignment.size()){
                return true;
            }
        }
    }

}
