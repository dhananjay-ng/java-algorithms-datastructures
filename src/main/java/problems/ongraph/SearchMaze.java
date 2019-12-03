package problems.ongraph;


import java.util.ArrayList;
import java.util.List;

public class SearchMaze {
    /**
     * It is natural to apply graph models and algorithms to spatial problems. Consider a
     * black and white digitized image of a maze — white pixels represent open areas and
     * black spaces are walls. There are two special white pixels: one is designated the
     * entrance and the other is the exit. The goal in this problem is to find a way of getting
     * from the entrance to the exit, as illustrated in Figure 19.5 on the next page.
     * Given a 2D array of black and white entries representing a maze with designated
     * entrance and exit points, find a path from the entrance to the exit, if one exists.
     * Hint: Model the maze as a graph.
     */
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }
    }

    public enum Color {WHITE, BLACK}

    public static List<Coordinate> searchMaze(List<List<Color>> maze,
                                              Coordinate s, Coordinate e) {

        List<Coordinate> result = new ArrayList<>();
        result.add(s);
        maze.get(s.x).set(s.y, Color.BLACK);
        if (!search(maze, s, e, result)) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    final static int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean search(List<List<Color>> maze,
                                 Coordinate s, Coordinate e, List<Coordinate> res) {
        if (s.equals(e)) {
            return true;
        }
        for (int a[] : SHIFT) {
            Coordinate next = new Coordinate(s.x + a[0], s.y + a[1]);
            if (isFeasible(maze, next)) {
                maze.get(next.x).set(next.y, Color.BLACK);
                res.add(next);
                if (search(maze, next, e, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }


    public static boolean isFeasible(List<List<Color>> maze, Coordinate cur) {
        return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0
                && cur.y < maze.get(cur.x).size()
                && maze.get(cur.x).get(cur.y) == Color.WHITE;

    }

}
