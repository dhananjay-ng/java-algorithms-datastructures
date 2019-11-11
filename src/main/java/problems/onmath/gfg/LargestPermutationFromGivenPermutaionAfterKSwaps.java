package problems.onmath.gfg;

import testingsystem.misccode.Reader2;

import java.io.IOException;
import java.util.HashMap;

public class LargestPermutationFromGivenPermutaionAfterKSwaps {
    public static void largestPermutaionAfterKSwaps() throws IOException {
        // write your code here
        Reader2 in = new Reader2("src\\main\\java\\testingsystem\\misccode\\input.txt");
        // Reader in = new Reader();
        int n;
        n = in.nextInt();
        int k;
        k = in.nextInt();
        int[] input;
        input = new int[n];

        HashMap<Integer, Integer> permutation = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ele = in.nextInt();
            input[i] = ele;
            permutation.put(ele, i);
        }
        int l = n;
        int start = 0;
        while (n > 0 && k-- > 0 && l > 0) {
            int lastkapos = permutation.get(l);
            int lastkaval = input[lastkapos];

            if (lastkapos != start) {
                input[lastkapos] = input[start];
                input[start] = lastkaval;
                permutation.put(input[lastkapos], lastkapos);
                permutation.put(input[start], start);
            } else {
                k++;
            }

            start++;
            l--;
        }
        for (int i = 0; i < input.length; i++)
            System.out.print(input[i] + " ");

    }
}
