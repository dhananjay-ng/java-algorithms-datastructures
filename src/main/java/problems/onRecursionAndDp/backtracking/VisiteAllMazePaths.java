package problems.onRecursionAndDp.backtracking;

public class VisiteAllMazePaths {
    public class Solution {
        int count;
        public int solve(int[][] A) {
            this.count = 0;
            for(int i=0;i<A.length;i++){
                for(int j=0;j<A[0].length;j++){
                    if(A[i][j]==1) {
                        solve(A, i, j, 0);
                        return this.count;
                    }
                }
            }
            return this.count;
        }

        public boolean solve(int [][] A, int x, int y, int visited) {
            if(x<0 || x>=A.length || y<0 || y> A[0].length || A[x][y] == -1 || A[x][y] == -2) return false;
            visited++;
            if(A[x][y] == 2) {
                if(visited == A.length*A[0].length) {
                    this.count++;
                }
                visited++;
                return false;
            }
            A[x][y] = -2;
            solve(A,x+1,y, visited);
            solve(A,x-1,y, visited);
            solve(A,x,y+1, visited);
            solve(A,x,y-1, visited);

            visited--;
            return false;
        }
    }

}
