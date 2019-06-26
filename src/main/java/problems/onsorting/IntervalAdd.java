package problems.onsorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalAdd {

    public static class Interval {
        public int left, right;

        public Interval(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Interval interval = (Interval) o;

            if (left != interval.left) {
                return false;
            }
            return right == interval.right;
        }

        @Override
        public String toString() {
            return "[" + left + ", " + right + "]";
        }
    }


    public static List<Interval> addInterval(List<Interval> disjointIntervals,
                                             Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < disjointIntervals.size() && newInterval.left > disjointIntervals.get(i).right) {
            result.add(disjointIntervals.get(i));
            i++;
        }
        int min = newInterval.left;
        int max = newInterval.right;
        while (i < disjointIntervals.size() && newInterval.right >= disjointIntervals.get(i).left) {
            min = Math.min(disjointIntervals.get(i).left, newInterval.left);
            max = Math.max(disjointIntervals.get(i).right, newInterval.right);
            newInterval = new Interval(min, max);
            i++;
        }

        result.add(new Interval(min, max));
        if (i < disjointIntervals.size()) {
            result.addAll(disjointIntervals.subList(i, disjointIntervals.size()));

        }


        return result;
    }
}
