package problems.onarray;

import testingsystem.misccode.Reader2;

import java.io.IOException;
import java.util.HashSet;

public class MissingAndDuplicateNumberInArray {
    public void missingAndDupInplace() throws IOException {

    }
        public void missingAndDupNaive() throws IOException {
        Reader2 in = new Reader2();
        StringBuilder result = new StringBuilder();
        int n = in.nextInt();
        int ans = Integer.MAX_VALUE;
        HashSet<Integer> inn = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ele = in.nextInt();
            if (inn.contains(ele)) {
                ans = Math.min(ans, ele);
            } else {
                inn.add(ele);
            }
        }
        int smallmissing = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (!inn.contains(i)) {
                smallmissing = Math.min(smallmissing, i);
            }

        }
        result.append(ans + " " + smallmissing).append("\n");

    }
}
