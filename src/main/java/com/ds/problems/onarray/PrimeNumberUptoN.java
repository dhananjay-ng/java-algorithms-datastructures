package com.ds.problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumberUptoN {

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
