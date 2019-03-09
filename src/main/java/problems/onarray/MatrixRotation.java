package problems.onarray;

import java.util.List;

public class MatrixRotation {


    public static void rotateMatrix2(List<List<Integer>> squareMatrix) {

        final int matrixSize = squareMatrix.size() - 1;
        for (int i = 0; i < (squareMatrix.size() / 2); i++) {
            for (int j = i; j < matrixSize - i; j++) {
                int temp1 = squareMatrix.get(i).get(j);
                int temp2 = squareMatrix.get(j).get(matrixSize - i);
                int temp3 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp4 = squareMatrix.get(matrixSize - j).get(i);

                squareMatrix.get(j).set(matrixSize - i, temp1);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp2);
                squareMatrix.get(matrixSize - j).set(i, temp3);
                squareMatrix.get(i).set(j, temp4);
            }
        }
    }
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
                        thirdLi = li + curShift + incrIndx,
                        thirdRi = ri + curShift - incrIndx,
                        fourthLi = li + curShift,
                        fourthRi = ri - incrIndx,

                        firstEle = squareMatrix.get(li).get(ri),
                        secondEle = squareMatrix.get(secondLi).get(secondRi),
                        thirdEle = squareMatrix.get(thirdLi).get(thirdRi),
                        fourthEle = squareMatrix.get(fourthLi).get(fourthRi);

                squareMatrix.get(secondLi).set(secondRi, firstEle);
                squareMatrix.get(thirdLi).set(thirdRi, secondEle);
                squareMatrix.get(fourthLi).set(fourthRi, thirdEle);
                squareMatrix.get(li).set(ri, firstEle);

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
