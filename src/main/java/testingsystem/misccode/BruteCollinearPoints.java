package testingsystem.misccode;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkDuplicatedEntries(points);
        ArrayList<LineSegment> foundSegments = new ArrayList<>();
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        Arrays.sort(points);

        for (int p = 0; p < pointsCopy.length - 3; p++) {
            for (int q = p + 1; q < pointsCopy.length - 2; q++) {
                for (int r = q + 1; r < pointsCopy.length - 1; r++) {
                    for (int s = r + 1; s < pointsCopy.length; s++) {
                        if (pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[r]) &&
                                pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[s])) {
                            foundSegments.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
                        }
                    }
                }
            }
        }

        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);

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
    public static void main(String[] args) {

    }
}

