package problems.onsearching;

public class RealSquareRoot {
    public enum Order {
        SMALLER,
        EQUAL,
        LARGER
    }
    public static double squareRoot(double x) {
        double lo, hi ;
        if (x < 1.0d) {
            lo = x;
            hi = 1.0d;
        } else {
            lo =1.0d;
            hi = x;
        }
        while (compare(lo,hi) == Order.SMALLER) {
            double mid = lo + (hi - lo)*0.5d;
            double midSquare = mid*mid;
            if (compare(midSquare, x) == Order.EQUAL){
                return mid;
            }
            if(compare(midSquare, x) == Order.LARGER )
                hi = mid  ;
            else
                lo = mid ;
        }

        return hi;
    }

    public static Order compare(double a, double b) {
        final double EPSILON = 0.000001;
        double diff = (a-b)/Math.max(Math.abs(a), Math.abs(b));;
        return diff < -EPSILON ?  Order.SMALLER : (diff > EPSILON ? Order.LARGER : Order.EQUAL);

    }
}
