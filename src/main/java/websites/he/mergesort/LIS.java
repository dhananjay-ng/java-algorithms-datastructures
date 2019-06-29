package websites.he.mergesort;

import java.io.*;
import java.util.*;


public class LIS {
    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    private static PrintWriter pw;
    private static long mod=(long)1e9+7;

    public static void main(String[] args) throws FileNotFoundException {
        InputReader(new FileInputStream("C:\\Fieldglass\\COPP\\src\\main\\java\\websites\\he\\input.txt"));
        pw = new PrintWriter(System.out);
        new Thread(null ,new Runnable(){
            public void run(){
                try{
                    solve();//This is solution method
                    pw.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"1",1<<26).start();
    }

    public static void solve() {
         final long m = 1000000007;

        int t=nextInt();
        while(t-- > 0){
            int n = nextInt();
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i = 0; i<n;i++){
                int p = nextInt();
                int q = nextInt();
                pairs.add(new Pair(p,1));
                pairs.add(new Pair(q,2));
            }
            Collections.sort(pairs);
            //bomb at first:
            long maxDistruction = n*a;

            //bomb at last:
            long countOfBettle = maxDistruction;
            for (int i=0;i<pairs.size();i++){
                if (pairs.get(i).y == 1) {
                    countOfBettle +=(b-a);
                } else {
                    countOfBettle +=(c-b);
                }
                maxDistruction = Math.max(maxDistruction, countOfBettle);
            }

            pw.println(maxDistruction);
        }

    }

    public static void InputReader(InputStream stream1) {
        stream = stream1;
    }

    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private static boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    private static int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    private static int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private static String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    private static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    private static int[][] next2dArray(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = nextInt();
            }
        }
        return arr;
    }
    private static char[][] nextCharArray(int n,int m){
        char [][]c=new char[n][m];
        for(int i=0;i<n;i++){
            String s=nextLine();
            for(int j=0;j<s.length();j++){
                c[i][j]=s.charAt(j);
            }
        }
        return c;
    }

    private static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private static void pArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    private static void pArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    private static void pArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    private static boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    private interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }


}
class Pair implements Comparable<Pair>{

    int x,y;
    Pair(int x,int y){

        this.x=x;
        this.y=y;

    }
    @Override
    public int compareTo(Pair o) {

//        if (this.x!=o.x){
//            return this.x - o.x;
//        } else {
//            if (this.y!= o.y){
//                return this.y -o.y;
//            } else {
//                return 0;
//            }
//        }
        if (this.x == o.x) {
            if (this.y == 1) return -1;
        }
        return this.x - o.x;

    }
    public int hashCode() {
        //int hu = (int) (x ^ (x >>> 32));
        //int hv = (int) (y ^ (y >>> 32));
        //int hw = (int) (mass ^ (mass >>> 32));
        //return 31 * hu + hv ;
        return 0;
    }
    public boolean equals(Pair other) {
        return x == other.x && y == other.y;
    }
}
