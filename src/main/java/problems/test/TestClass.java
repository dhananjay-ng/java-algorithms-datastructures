package problems.test;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Long.parseLong(arr_A[i_A]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_L = br.readLine().split(" ");
            long[] L = new long[Q];
            for (int i_L = 0; i_L < arr_L.length; i_L++) {
                L[i_L] = Long.parseLong(arr_L[i_L]);
            }
            String[] arr_R = br.readLine().split(" ");
            long[] R = new long[Q];
            for (int i_R = 0; i_R < arr_R.length; i_R++) {
                R[i_R] = Long.parseLong(arr_R[i_R]);
            }

            long[] out_ = solve(A, R, L);
            System.out.print(out_[0]);
            for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
                System.out.print(" " + out_[i_out_]);
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static long[] solve(long[] A, long[] R, long[] L) {
        int alength = A.length;
        int qlength = R.length;

        long[] result = new long[qlength];
        HashMap<String,Long> res = new HashMap<>();
        HashMap<Integer,Long> par = new HashMap<>();

        for (int queryIter = 0; queryIter < qlength; queryIter++) {
            long sum = 0l;
            long ri = R[queryIter];
            long li = L[queryIter];
            String key = Long.toString(ri) + Long.toString(li);

            if(res.containsKey(key)) {
                result[queryIter] = res.get(key);
                continue;
            }
            long inbet = (ri - li)+1;
            long parts = (inbet) / alength;
            long remain = (inbet) % alength;
            long arraySum = 0;
            if (parts > 0) {
                for (int i = 0;i< alength;i++) {
                    arraySum = ((A[i] % 1000000007) + (arraySum % 1000000007)) % 1000000007;
                }
                for (int i=1;i<=parts;i++) {
                    sum = ((arraySum) + (sum % 1000000007)) % 1000000007;
                }

            }

            for (long i = li; i <li+remain; i++) {
                int ai =(int) ((i - 1) % alength);
                sum = ((A[ai] % 1000000007) + (sum % 1000000007)) % 1000000007;
            }
            res.put(key,sum);
            result[queryIter] = sum;
        }

        return result;
    }
}