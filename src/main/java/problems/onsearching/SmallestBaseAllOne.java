package problems.onsearching;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestBaseAllOne {
    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (isInside(A, B, C, D, E, F)
                || isInside(A, B, C, D, G, H)
                || isInside(A, B, C, D, E, H)
                || isInside(A, B, C, D, G, F))== true ? 1 : 0;
    }

    public static boolean isInside(int x1, int y1, int x2, int y2, int x, int y){
        return ((x >= x1 && x <= x2) && ( y >= y1 && y <= y2));
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

        System.out.println(solve(12,47,39,72, 8,3,47,55));
    }

}
