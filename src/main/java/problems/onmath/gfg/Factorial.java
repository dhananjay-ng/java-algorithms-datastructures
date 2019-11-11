package problems.onmath.gfg;

import testingsystem.misccode.Reader2;

import java.io.IOException;

public class Factorial {
    public static long fact(int n) {
        if(n == 0) return 1;
        else return n*fact(n-1);
    }
    public static void main (String[] args) throws IOException
    {
        Reader2 in = new Reader2();
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            result.append(fact(in.nextInt()));
            if(t!=0) result.append("\n");


        }
        System.out.println(result);
    }
}
