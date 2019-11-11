package problems.onRecursionAndDp;

public class FastPower {
    public double myPow(double x, int n) {
        boolean isNeg = n < 0;
        if (isNeg) n *= -1;
        double res = pow(x, n);
        if (isNeg) return (double) 1.0 / res;
        else return res;
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;

        double smallAns = pow(x, n / 2);
        smallAns *= smallAns;
        if (n % 2 != 0) return x * smallAns;

        return smallAns;

    }
}
