package testingsystem.misccode;

import java.util.Arrays;

public class FastCollinearPoints {
    LineSegment[] segments ;
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        checkDuplicatedEntries(points);
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        for (int i = 0;i < pointsCopy.length -3;i++){
            double slopes [] = new double[points.length - i -1];
            for (int j = i + 1,k=0; j < pointsCopy.length;j++) {
                slopes[k++] = pointsCopy[i].slopeTo(pointsCopy[j]);
            }

        }

    }

    // the number of line segments
    public int numberOfSegments()  {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments()  {
        return Arrays.copyOf(segments, numberOfSegments());
    }

    private void checkDuplicatedEntries(Point[] points) {

        if (points == null) {
            throw new IllegalArgumentException("Duplicated entries in given points.");
        }
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null) throw new IllegalArgumentException("Duplicated entries in given points.");
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0 ) {
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }
}
