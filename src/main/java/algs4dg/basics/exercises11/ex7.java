package algs4dg.basics.exercises11;

import edu.princeton.cs.algs4.StdOut;

public class ex7 {

    public static void main(String[] args) {
        funcA();
        funcB();
        funcC();
    }

    private static void funcA() {
        double t = 9.0;

        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;

        StdOut.printf("%.5f\n", t);
    }

    private static void funcB() {
        int sum = 0;
       //how many times inner loop executes
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }

        StdOut.println(sum);
    }

    private static void funcC() {
        int sum = 0;
        //1 2 4 8 16 32 64 128 256 512
        for (int i = 1; i <= 999; i *= 2) {
            // this gives sum 1000 for each iteration so how many iterations.
            for (int j = 1; j <= 1000; j++) {
                sum++;
            }
        }

        StdOut.println(sum);
    }
}
