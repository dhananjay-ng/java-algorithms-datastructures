package problems.onRecursionAndDp;

import java.util.Arrays;

public class HENewLang {
    public static void main(String[] args) {
        String[] str = new String[26];
        str[0] = "1111111111111111111111111";
        str[1] = "1111111111111111111111111";
        str[2] = "1111111111111111111111111";
        str[3] = "1111111111111111111111111";
        str[4] = "1111111111111111111111111";
        str[5] = "1111111111111111111111111";
        str[6] = "1111111111111111111111111";
        str[7] = "1111111111111111111111111";
        str[8] = "1111111111111111111111111";
        str[9] = "1111111111111111111111111";
        str[10] = "1111111111111111111111111";
        str[11] = "1111111111111111111111111";
        str[12] = "1111111111111111111111111";
        str[13] = "1111111111111111111111111";
        str[14] = "1111111111111111111111111";
        str[15] = "1111111111111111111111111";
        str[16] = "1111111111111111111111111";
        str[17] = "1111111111111111111111111";
        str[18] = "1111111111111111111111111";
        str[19] = "1111111111111111111111111";
        str[20] = "1111111111111111111111111";
        str[21] = "1111111111111111111111111";
        str[22] = "1111111111111111111111111";
        str[23] = "1111111111111111111111111";
        str[24] = "1111111111111111111111111";
        str[25] = "1111111111111111111111111";
        System.out.println(solve(str, 10000));
    }

    private static int solve(String[] str, int n) {
        int cache[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            cache[i] = new int[26];
            Arrays.fill(cache[i], -1);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = ((res%1000000007) + (recurse(str, i, n, 1, cache, 0)%1000000007))%1000000007;
        }

        return res;
    }

    private static int recurse(String[] str, int start, int n, int k, int[][] cache, int m) {
        if (k == n) {
            return 1;
        }
        if (cache[m][start] != -1) {
            return cache[m][start];
        }
        cache[m][start] = 0;
        for (int j = 0; j < str[start].length(); j++) {
            if (str[start].charAt(j) == '1') {
                cache[m][start] = ((cache[m][start])%1000000007+(recurse(str, j, n, k + 1, cache, m+1))%1000000007);
            }
        }
        return cache[m][start];
    }
}
