package problems.onheaps;

import java.util.*;

public class KNearestStarsToGivenStars {
    //k smallest element in huge huge amount of data.

    public static class Star implements Comparable<Star> {
        private double x, y, z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star that) {
            return Double.compare(this.distance(), that.distance());
        }

        @Override
        public String toString() {
            return String.valueOf(distance());
        }
    }

    public static List<Star> findClosestKStars(Iterator<Star> stars, int k) {
        //max heap
        PriorityQueue<Star> kCloseStars = new PriorityQueue<>(k, Comparator.reverseOrder());
        while (stars.hasNext()) {
            Star in = stars.next();
            if (kCloseStars.size() == k) {
                if (kCloseStars.peek().distance() > in.distance()) {
                    kCloseStars.remove();
                    kCloseStars.add(in);
                }
            } else {
                kCloseStars.add(in);
            }
        }

        return new ArrayList<>(kCloseStars);
    }

}
