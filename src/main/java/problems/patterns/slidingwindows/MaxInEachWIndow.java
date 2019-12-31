package problems.patterns.slidingwindows;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class MaxInEachWIndow {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> maxInWindow = new LinkedList<>();
        ArrayList<Integer> result  =  new ArrayList<>();
        for (int i=0;i<A.size();i++) {
            if (maxInWindow.size() == 0) {
                maxInWindow.addLast(A.get(i));
            }
            else if (maxInWindow.size() >0 && maxInWindow.peekLast() < A.get(i)) {
                while (maxInWindow.size() >0 && maxInWindow.peekLast() < A.get(i)) {
                    maxInWindow.removeLast();
                }
                maxInWindow.addLast(A.get(i));
            } else {
                maxInWindow.addLast(A.get(i));
            }
            if (i >= B-1) {
                result.add(maxInWindow.peekFirst());
                if (A.get(i+1-B).equals(maxInWindow.peekFirst())) {
                    maxInWindow.removeFirst();
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> sample = Arrays.asList(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 );
        System.out.println(slidingMaximum(sample, 9));
    }

}
