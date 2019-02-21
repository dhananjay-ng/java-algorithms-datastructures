package com.ds.problems.onarray;

import java.util.List;

public class CanReachEndOfArray {
    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {

        int curMaxYouCanGo = 0;
        int max =0;
        for (int i=0; i<maxAdvanceSteps.size();i++) {
            curMaxYouCanGo  = i + maxAdvanceSteps.get(i);
            if (curMaxYouCanGo > max) {
                max = curMaxYouCanGo;
            }
            if (max >= maxAdvanceSteps.size()-1) {
                return true;
            }
            if (max == i) {
                return false;
            }

        }
        return true;
    }
}
