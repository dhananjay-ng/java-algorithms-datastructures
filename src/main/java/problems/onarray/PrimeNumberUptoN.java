package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumberUptoN {
    /**
     * A natural number is called a prime if it is bigger than 1 and has no divisors other than
     * 1 and itself.
     * Write a program that takes an integer argument and returns all the primes between 1
     * and that integer. For example, if the input is 18, you should return (2, 3, 5, 7, 11,13, 17).
     */
    // Given n, return all primes up to and including n.
    public static List<Integer> generatePrimesFast(int n) {
        int size = (int) Math.floor(0.5 * ( n - 3)) + 1;
        List<Boolean> isPrime  = new ArrayList<>(Collections.nCopies(size, true));
        List<Integer> primes = new ArrayList<>();

        if (n < 2) {
            return Collections.emptyList();
        }

        primes.add(2);

        // from now on i is value of 2i + 3
        for (long i = 0; i < size; i++) {
            if (isPrime.get((int)i)) {
                int p = (((int) i * 2) + 3);
                primes.add(p);
                // sieving needs to start from ( 2 * i + 3)^2 which is 4*i^2 + 12i + 9 (for normal space) but for use i = 2i+3 so p2
                //starts from 2 * i * i + 6 * i + 3
                for (long j = ((2 * i * i) + (6 * i) +3); j < size & j > 0 ; j += p ) {
                    isPrime.set((int) j, false);
                }
            }
        }
        return primes;
    }
    // Uses Space O(n) otherwise good
    public static List<Integer> generatePrimes(int n) {
        List<Boolean> isPrime  = new ArrayList<>(Collections.nCopies(n + 1, true));
        List<Integer> primes = new ArrayList<>();
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i)) {
                primes.add(i);
                for (int j = i + i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }
}
