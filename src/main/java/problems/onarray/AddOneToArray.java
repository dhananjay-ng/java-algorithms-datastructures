package problems.onarray;

import java.util.List;

public class AddOneToArray {
    /**
     * Write a program which takes as input an array of digits encoding a decimal number
     * D and updates the array to represent the number D + 1. For example, if the input
     * 65
     * is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
     * even if it is implemented in a language that has finite-precision arithmetic.
     */
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
