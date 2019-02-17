package com.ds.problems.onarray;

import java.util.List;

public class AddOneToArray {
    public static List<Integer> plusOne(List<Integer> A) {
        int sumAi = 0;
        int carry = 1;
        for (int i = A.size() -1; i >= 0; i--) {
            sumAi = A.get(i)  + carry;
            carry = 0;
            if (sumAi > 9) {
                carry = 1;
                sumAi = 0;
            }
            A.set(i , sumAi);
        }
        if (carry == 1) {
            A.add(0, carry);
        }

        return A;
    }
}
