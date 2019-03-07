package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixSpiralOrderTraversal {

    public static List<Integer>
    matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size() - 1;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        if (size < 0) return Collections.emptyList();
        if (size == 0) return squareMatrix.get(0);

        while (true) {
            for (int i = start; i <= size - 1; i++) {
                res.add(squareMatrix.get(start).get(i));
            }
            for (int i = start; i <= size - 1; i++) {
                res.add(squareMatrix.get(i).get(size));
            }
            for (int i = size; i >= start + 1; i--) {
                res.add(squareMatrix.get(size).get(i));
            }
            for (int i = size; i >= start + 1; i--) {
                res.add(squareMatrix.get(i).get(start));
            }
            start += 1;
            size -= 1;
            if (res.size() == (squareMatrix.size() * squareMatrix.size() - 1)) {
                res.add(squareMatrix.get(start).get(start));
                break;
            }

            if (res.size() == squareMatrix.size() * squareMatrix.size()) {
                break;
            }

        }
        return res;
    }
}
