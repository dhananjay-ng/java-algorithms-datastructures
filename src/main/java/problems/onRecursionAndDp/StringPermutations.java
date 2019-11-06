package problems.onRecursionAndDp;

import java.io.*;
import java.util.Arrays;

public class StringPermutations {
    /**
     * Given a string S. The task is to print all permutations of a given string.
     * <p>
     * Input:
     * The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.
     * <p>
     * Output:
     * For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
     * <p>
     * Constraints:
     * 1 ≤ T ≤ 10
     * 1 ≤ size of string ≤ 5
     * <p>
     * Example:
     * Input:
     * 2
     * ABC
     * ABSG
     * <p>
     * Output:
     * ABC ACB BAC BCA CAB CBA
     * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
     * <p>
     * Explanation:
     * Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
     */
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String readLine(int length) throws IOException {
            byte[] buf = new byte[length]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void ignore(int n) throws IOException {
            while (n-- > 0) read();
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Reader in = new Reader();
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {

            String s = in.readLine();
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            printAllPermu("", new String(ss), out);
            out.write("\n");

        }
        out.flush();

    }

    private static void printAllPermu(String prefix, String suffix, BufferedWriter out) throws IOException {
        if (suffix.length() == 0) {
            out.write(prefix + " ");
        }
        for (int i = 0; i < suffix.length(); i++) {
            printAllPermu(prefix + suffix.charAt(i),
                    suffix.substring(0, i) +
                            ((i + 1) < suffix.length() ? suffix.substring(i + 1, suffix.length()) : "")
                    , out);
        }
    }
}