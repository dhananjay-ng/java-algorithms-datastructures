package problems.onRecursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int cache[][] = new int[numRows + 1][numRows + 1];

        for (int i = 0; i < numRows + 1; i++) {
            Arrays.fill(cache[i], -1);
        }

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                row.add(getNumFromPascalTriangle(i, j, cache));
            }
            res.add(row);
        }

        return res;
    }

    public List<Integer> getRow(int numRows) {
        numRows++;
        int cache[][] = new int[numRows + 1][numRows + 1];
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= numRows; i++) {
            Arrays.fill(cache[i], -1);
        }

        for (int i = numRows; i <= numRows; i++) {
            for (int j = 1; j <= i; j++) {
                row.add(getNumFromPascalTriangle(i, j, cache));
            }
        }
        return row;
    }

    public int getNumFromPascalTriangle(int i, int j, int[][] cache) {
        if (j == 1 || i == j) return 1;
        if (cache[i][j] == -1) {
            int res = getNumFromPascalTriangle(i - 1, j - 1, cache)
                    + getNumFromPascalTriangle(i - 1, j, cache);

            cache[i][j] = res;
        }

        return cache[i][j];
    }
}
