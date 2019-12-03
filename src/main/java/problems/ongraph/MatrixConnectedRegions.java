package problems.ongraph;

import java.util.List;


public class MatrixConnectedRegions {

    final static int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public static void flipColor(int x, int y, List<List<Boolean>> image) {
        boolean currentColor = image.get(x).get(y);
        paint(image, currentColor, x, y);
        return;
    }

    private static void paint(List<List<Boolean>> image, boolean currentColor, int x, int y) {

        image.get(x).set(y, !currentColor);
        for (int a[] : SHIFT) {
            if (isFeasible(image, x + a[0], y + a[1], currentColor)) {
                paint(image, currentColor, x + a[0], y + a[1]);
            }
        }
    }

    public static boolean isFeasible(List<List<Boolean>> image, int x, int y, boolean currentColor) {
        return x >= 0 && x < image.size() && y >= 0
                && y < image.get(x).size()
                && image.get(x).get(y) == currentColor;

    }


}
