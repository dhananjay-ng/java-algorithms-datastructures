package testingsystem.misccode;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CodingBlocks {
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

        public int nextInt() {
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

        public long nextLong() {
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

        public double nextDouble() {
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

        private byte read() {
            if (bufferPointer == bytesRead) {
                try {
                    fillBuffer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            byte c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }

        public void readIntArray(int a[], int n) {
            for (int i = 0; i < n; i++)
                a[i] = nextInt();

        }

        public void readLongArray(long a[], int n) {
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
        }

        public void readStringArray(String a[], int n) {
            for (int i = 0; i < n; i++)
                a[i] = readString();
        }

        public boolean isSpaceChar(byte c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static String stringWindow(String s1, String s2) {

        HashMap<Character, Integer> foundCharCount = new HashMap<>();
        HashMap<Character, Integer> neededCharCount = new HashMap<>();

//min positions of start and end index
        int startmin = 0;
        int endmin = Integer.MAX_VALUE;

// to hold current iteration
        int iter = 0;
        int curStart = -1;

        int curFoundLength = 0;
        int neededLength = 0 ;//= s2.length();
        for (int i = 0; i < s2.length(); i++) {
            if (!Character.isWhitespace(s2.charAt(i))) {
                neededLength++;
                foundCharCount.put(s2.charAt(i),0);
                if(neededCharCount.containsKey(s2.charAt(i))) {
                    neededCharCount.put(s2.charAt(i), neededCharCount.get(s2.charAt(i)) + 1);
                } else {
                    neededCharCount.put(s2.charAt(i),1);
                }
            }
        }

        for (int i = 0; i < s2.length(); i++) foundCharCount.put(s2.charAt(i),0);



        for (iter = 0; iter < s1.length(); iter++) {
            Character currentChar = s1.charAt(iter);
            if(foundCharCount.containsKey(currentChar) && !(curFoundLength == neededLength)) {
                if (curStart == -1) curStart = iter;
                foundCharCount.put(currentChar, foundCharCount.get(currentChar) +1);
                if (foundCharCount.get(currentChar) <= neededCharCount.get(currentChar)) {
                    curFoundLength++;
                }
            }
            if (curFoundLength == neededLength) {
                if (iter - curStart < endmin - startmin) {
                    startmin = curStart;
                    endmin = iter;
                }
                foundCharCount.put(s1.charAt(curStart), foundCharCount.get(s1.charAt(curStart)) -1);
                if(foundCharCount.get(s1.charAt(curStart)) < neededCharCount.get(s1.charAt(curStart))) {
                    curFoundLength--;
                }
                for(int i=curStart+1; i < s1.length();i++) {
                    if (foundCharCount.containsKey(s1.charAt(i))) {
                        curStart = i;
                        break;
                    }
                }

            }
            if ((curFoundLength == neededLength)) {
                iter--;
            }

        }

        if (startmin >=0 && startmin <=s1.length() && endmin >=0 && endmin<=s1.length()) {
            return s1.substring(startmin, endmin+1);
        } else {
            return "No string";
        }
    }
    public static void main(String[] args) throws IOException {
        Reader in = new Reader("src\\main\\java\\testingsystem\\misccode\\input.txt");
       // Reader reader = new Reader();
        String s1 = in.readLine();
        String s2 = in.readLine();
        System.out.println(stringWindow(s1, s2));

    }
}

