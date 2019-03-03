package problems.onarray;

import java.util.Collections;
import java.util.List;

public class DutchNationalFlagPartition {
    public enum Color { RED, WHITE, BLUE }


    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {

        Color pivot = A.get(pivotIndex);
        int smaller = 0, equal = 0, larger = A.size();
        while (equal < larger) {
            if (A.get(equal).ordinal()<pivot.ordinal()) {
                Collections.swap(A,smaller++,equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                equal++;
            } else {
                Collections.swap(A,equal,  --larger);
            }
        }

        return ;
    }
}
