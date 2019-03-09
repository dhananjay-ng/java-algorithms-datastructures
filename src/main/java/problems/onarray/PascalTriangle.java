package problems.onarray;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //Uses Previous rows data to generate next row
    public static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows <= 0) {
            return res;
        }
        List<Integer> tempRow = new ArrayList<>();
        tempRow.add(1);
        res.add(tempRow);
        for (int i = 2; i <= numRows; i++) {
            tempRow = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j - 1 >= 0 && j <= res.get(i - 2).size() - 1) {
                    tempRow.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                } else {
                    tempRow.add(1);
                }

            }
            res.add(tempRow);

        }
        return res;
    }
}
