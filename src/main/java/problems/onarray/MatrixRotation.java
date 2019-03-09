package problems.onarray;

import java.util.List;

public class MatrixRotation {

    //O(matrixSize^2) space O(mstrixSize^2)
    public static void rotateMatrixExtraSpace(List<List<Integer>> squareMatrix) {

        Integer[][] copyied = new Integer[squareMatrix.size()][squareMatrix.size()];

        for (int i=0,k=0;i<squareMatrix.size() && k<squareMatrix.size() ;i++,k++){
            for (int j=squareMatrix.size()-1,m=0;j>=0 && m<squareMatrix.size();j--,m++){
                copyied[k][m] = squareMatrix.get(j).get(i);
            }
        }

        for (int i=0;i<squareMatrix.size();i++)
            for (int j=0;j<squareMatrix.size();j++)
                squareMatrix.get(i).set(j,copyied[i][j]);

        return;
    }
}
