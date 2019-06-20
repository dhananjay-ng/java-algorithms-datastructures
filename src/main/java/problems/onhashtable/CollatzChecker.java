package problems.onhashtable;

import java.util.HashSet;

public class CollatzChecker {
    /**
     * The Collatz conjecture is the following: Take any natural number. If it is odd, triple
     * it and add one; if it is even, halve it. Repeat the process indefinitely. No matter what
     * number you begin with, you will eventually arrive at 1.
     * As an example, if we start with 11 we get the sequence 11,34,17,52,26,13,40,
     * 20,10,5,16,8,4,2,1. Despite intense efforts, the Collatz conjecture has not been
     * proved or disproved.
     * Suppose you were given the task of checking the Collatz conjecture for the first
     * billion integers. A direct approach would be to compute the convergence sequence
     * for each number in this set.
     * Test the Collatz conjecture for the first n positive integers.
     */
    public static boolean testCollatzConjecture(int n) {
        HashSet<Long> verified = new HashSet<>();
        for (int i = 3; i <= n; i++) {
            HashSet<Long> sequence = new HashSet<>();
            long testI = i;
            while (testI >= i) {
                if (!sequence.add(testI)) {
                    return false;
                } else if (testI % 2 != 0) {
                    if (!verified.add(testI)) {
                        //seen
                        break;
                    } else {
                        long newTestI = 3 * testI + 1;
                        if (newTestI < testI) {
                            throw new ArithmeticException("overfloew");
                        } else {
                            testI = newTestI;
                        }
                    }

                } else {
                    testI /= 2;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(testCollatzConjecture(10));
    }
}

/**
 * solution:
 * when you are checking conjecture sequenctially then,
 * during processing current sequece number , i.e mutiply by 3+1 or divide .. if
 * you get number that is seen earlier for same number then that implies this will keep
 * happening so return false.
 *
 * otherwise if you keep holding previsously seen number and if current number after processing is
 * present in that map then you can skip that number to.
 *
 * also when your number gets lesser than number under process then also we can stop as
 * we have already proved that conjectire holds for previous numbers.
 */

