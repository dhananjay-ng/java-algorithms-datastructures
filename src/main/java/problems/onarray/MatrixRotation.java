package problems.onarray;

import java.util.List;

public class MatrixRotation {

    //Time O(n^2) , Space : inPlace
    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        int shift = squareMatrix.size() - 1;
        int startli = 0;
        int startri = 0;
        while (shift > 0) {
            int li = startli;
            int ri = startri;
            int incrIndx = 0;
            for (int curShift = shift; curShift > 0; curShift--) {

                int secondLi = li + incrIndx,
                        secondRi = ri + curShift,
                        thirdLi  = li + curShift + incrIndx,
                        thirdRi  = ri + curShift - incrIndx,
                        fourthLi = li + curShift,
                        fourthRi = ri - incrIndx;


                int previous = squareMatrix.get(li).get(ri);
                int next = squareMatrix.get(secondLi).get(secondRi);


                squareMatrix.get(secondLi).set(secondRi, previous);
                previous = next;

                next = squareMatrix.get(thirdLi).get(thirdRi);
                squareMatrix.get(thirdLi).set(thirdRi, previous);

                previous = next;
                next = squareMatrix.get(fourthLi).get(fourthRi);

                squareMatrix.get(fourthLi).set(fourthRi, previous);

                squareMatrix.get(li).set(ri, next);

                ri++;
                incrIndx++;
            }
            shift -= 2;
            startli++;
            startri++;
        }

    }

    //O(matrixSize^2) space O(mstrixSize^2)
    public static void rotateMatrixExtraSpace(List<List<Integer>> squareMatrix) {

        Integer[][] copyied = new Integer[squareMatrix.size()][squareMatrix.size()];

        for (int i = 0, k = 0; i < squareMatrix.size() && k < squareMatrix.size(); i++, k++) {
            for (int j = squareMatrix.size() - 1, m = 0; j >= 0 && m < squareMatrix.size(); j--, m++) {
                copyied[k][m] = squareMatrix.get(j).get(i);
            }
        }

        for (int i = 0; i < squareMatrix.size(); i++)
            for (int j = 0; j < squareMatrix.size(); j++)
                squareMatrix.get(i).set(j, copyied[i][j]);

        return;
    }
}
