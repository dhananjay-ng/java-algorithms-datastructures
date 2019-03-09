package problems.onarray;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //Uses Previous rows data to generate next row
    public static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                tempRow.add(j - 1 >= 0 && j <i? res.get(i - 1).get(j - 1) + res.get(i - 1).get(j):1);
            }
            res.add(tempRow);
        }
        return res;
    }
}
