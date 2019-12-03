package problems.ongraph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class MatrixEnclosedRegions {

    public static void fillSurroundedRegions(List<List<Character>> board) {

        // Identifies the regions that are reachable via white path starting from
        // the first or last columns.
        for (int i = 0; i < board.size(); ++i) {
            markBoundaryRegion(i, 0, board);
            markBoundaryRegion(i, board.get(i).size() - 1, board);
        }
        // Identifies the regions that are reachable via white path starting from
        // the first or last rows.
        for (int j = 0; j < board.get(0).size(); ++j) {
            markBoundaryRegion(0, j, board);
            markBoundaryRegion(board.size() - 1, j, board);
        }

        // Marks the surrounded white regions as black.
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.get(i).size(); ++j) {
                board.get(i).set(j, board.get(i).get(j) != 'T' ? 'B' : 'W');
            }
        }
    }

    private static class Coordinate {
        public Integer x;
        public Integer y;

        public Coordinate(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void markBoundaryRegion(int i, int j,
                                           List<List<Character>> board) {
        Queue<Coordinate> q = new ArrayDeque<>();
        q.add(new Coordinate(i, j));
        // Uses BFS to traverse this region.
        while (!q.isEmpty()) {
            Coordinate curr = q.poll();
            if (curr.x >= 0 && curr.x < board.size() && curr.y >= 0 &&
                    curr.y < board.get(curr.x).size() &&
                    board.get(curr.x).get(curr.y) == 'W') {
                board.get(curr.x).set(curr.y, 'T');
                q.add(new Coordinate(curr.x - 1, curr.y));
                q.add(new Coordinate(curr.x + 1, curr.y));
                q.add(new Coordinate(curr.x, curr.y - 1));
                q.add(new Coordinate(curr.x, curr.y + 1));
            }
        }
    }
    /**
     * This problem is concerned with computing regions within a 2D grid that are enclosed.
     * See Figure 19.7 for an illustration of the problem.
     * Figure 19.7: Three of the four white squares in (a) are enclosed, i.e., there is no path from any of
     * them to the boundary that only passes through white squares, (b) shows the white squares that are not
     * enclosed.
     * The computational problem can be formalized using 2D arrays of Bs (blacks) and
     * Ws (whites). Figure 19.7(a) is encoded by
     * B B B B
     * W B W B
     * B W W B
     * '
     * B B B B
     * 359
     * Figure 19.7(b) on the previous page is encoded by
     * B B B B
     * W B B B
     * B B B B
     * '
     * B B B B
     * Let A be a 2D array whose entries are either WorB. Write a program that takes A,
     * and replaces all Ws that cannot reach the boundary with a B.
     *
     *
     *It is easier to focus on the inverse problem, namely identifying Ws that can
     * reach the boundary. The reason that the inverse is simpler is that if a W is adjacent
     * to a W that is can reach the boundary, then the first W can reach it too. The Ws on
     * the boundary are the initial set. Subsequently, we find Ws neighboring the boundary
     * Ws, and iteratively grow the set. Whenever we find a new W that can reach the
     * boundary, we need to record it, and at some stage search for new Ws from it. A queue
     * is a reasonable data structure to track Ws to be processed. The approach amounts to
     * breadth-first search starting with a set of vertices rather than a single vertex.
     */
}
