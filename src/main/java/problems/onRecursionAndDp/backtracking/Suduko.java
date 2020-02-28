package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;

public class Suduko {
    public class Solution {
        public void solveSudoku(ArrayList<ArrayList<Character>> a) {
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++){
                    solve(a, i,j);
                }
            }
        }

        public boolean solve(ArrayList<ArrayList<Character>> a, int row, int col) {
            if(col >= 9){ col=0;row++;}
            if(row >= 9) return true;
            if(Character.isDigit(a.get(row).get(col))) {
                return solve(a, row, col+1);
            }

            for(int i=1;i<=9;i++) {
                if(isValid(a, row, col, (char)('0'+i))){
                    a.get(row).set(col, (char)('0'+i));
                    if(solve(a, row, col+1)) return true;
                }
            }
            a.get(row).set(col, '.');
            return false;
        }

        boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, Character x) {
            int rowst = (row/3)*3;
            int colst = (col/3)*3;
            for(int i=rowst;i<rowst+3;i++){
                for(int j=colst;j<colst+3;j++) {
                    if(a.get(i).get(j).equals(x)) return false;
                }
            }

            for(int j=0;j<9;j++){
                if(a.get(row).get(j).equals(x)) return false;
            }
            for(int i=0;i<9;i++){
                if(a.get(i).get(col).equals(x)) return false;
            }
            return true;
        }
    }

}
