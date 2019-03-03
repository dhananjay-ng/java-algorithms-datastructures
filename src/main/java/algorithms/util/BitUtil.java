package algorithms.util;

import java.util.BitSet;

public class BitUtil {
    /***
     * Properties for numbers which are powers of 2, is that they have one and only one bit set in their binary representation.
     * If the number is neither zero nor a power of two, it will have 1 in more than one place. So if x is a power of 2 then x & (x-1)
     * will be 0.
     */
    public static boolean isPowerOfTwo(int x) {
        // x will check if x == 0 and !(x & (x - 1)) will check if x is a power of 2 or not
        return (x != 0 && (x & (x - 1)) == 0);
    }

    /****
     *the relationship between the bits of x and x-1. So as in x-1, the rightmost 1 and bits right to it are flipped,
     *then by performing x&(x-1), and storing it in x, will reduce x to a number containing number of ones(in its binary form)
     *less than the previous state of x, thus increasing the value of count in each iteration.
     */
    public static <T extends Number> short countOneInNumber(T _n) {
        short count = 0;
        long n = _n.longValue();
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    /***
     * To check if the ith bit is set or not (1 or not), we can use AND operator.
     * Let’s say we have a number N, and to check whether it’s ith bit is set or not,
     * we can AND it with the number 2 thepower i . The binary form of 2i contains only ith bit as set (or 1),
     * else every bit is 0 there. When we will AND it with N, and if the ith bit of N is set, then it will
     * return a non zero number (2i to be specific), else 0 will be returned.
     * Using Left shift operator, we can write 2i as 1 << i . Therefore:
     */
    private static boolean isIthBitSet(int n, int i) {
        return (n & (1 << i)) > 0;
    }

    public static void possibleBitSubsets(char A[], int N) {
        for (int i = 0; i < (1 << N); ++i) {
            for (int j = 0; j < N; ++j)
                if (isIthBitSet(i, j)) {//j is i here
                    System.out.print(A[j] + ",");
                }

            System.out.println();
        }
    }

    public static long largestPowerOfTwo(long n) {
        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);

        return (n + 1) >> 1;

    }

    public static String toBinaryString(int n) {

        StringBuilder res = new StringBuilder();
        //res= Integer.toBinaryString(n); or
        int displayMask = 1 << 31;
        for (int i = 1; i <= 32; i++) {
            res.append((n & displayMask) == 0 ? '0' : '1');
            n = n << 1;
            if (i % 8 == 0) res.append(' ');
        }

        return res.toString();
    }

    public static boolean isPrimeNumberSieveOfErasthanos(int n) {

        BitSet sieve = new BitSet(n + 1);

        for (int i = 2; i <= n; i++)
            sieve.set(i);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (sieve.get(i)) {
                for (int j = 2 * i; j <= n; j += i) {
                    sieve.clear(j);
                }
            }

        }
        return sieve.get(n);
    }

    /*
     The parity of (11010111) is the same as the parity of (1101) XORed with (0111), i.e., of (1010). This in turn is the same as
     the parity of (10) XORed with (10), i.e., of (00). The final result is the XOR of (0)
     with (0), i.e., 0.We can exploit this fact to use the CPU's word -level XOR instruction to process multiple bits at a time.
     */
    public static short parity(long n) {
        n ^= n >>> 32;
        n ^= n >>> 16;
        n ^= n >>> 8;
        n ^= n >>> 4;
        n ^= n >>> 2;
        n ^= n >>> 1;

        return (short) (n & 0x1);          //extract last result bit from 64bit number
    }
//    public static short parity1(long n){
//        short x=0;
//        while (n!=0){
//            x^=n&1;         //^ is doing module kind op,
//            n>>>=1;
//        }
//        return x;
//    }
//    public static short parity2(long n){
//        short x=0;
//        while (n!=0){
//            x++;
//            n&=(n-1);       // replaces rightmost set bit to 0 or toggles bit till last set bit including it
//        }
//        return x;
//    }
//    public static short parity3(long n){
//        return (short)(countOneInNumber(n)% 2);
//    }
//    public static short parityByLookupTable(long x) {
//        final int W0RD_SIZE = 16;
//        final int BIT_MASK = 0xFFFF;
//        short[] precomputedParity = new short[65537];     //In real world scenario this is cache that you will need to intialize only once.
//        for (int i = 0; i < 65537; i++) {
//            precomputedParity[i] = parity(i);
//        }
//        return (short) (precomputedParity[(int) ((x >>> (3 * W0RD_SIZE)) & BIT_MASK)]
//                ^ precomputedParity[(int) ((x >>> (2 * W0RD_SIZE)) & BIT_MASK)]
//                ^ precomputedParity[(int) ((x >>> W0RD_SIZE) & BIT_MASK)]
//                ^ precomputedParity[(int) (x & BIT_MASK)]);
//    }

    public static <T extends Number> String isEvenOddNumber(T n) {
        return n.longValue() % 2 == 0 ? "EVEN" : "ODD";
    }

    public static long setIthBit(long number, short ithBit) {
        return number | (1 << ithBit);
    }

    public static long clearIthBit(long n, short i) {
        return n & ~(1 << i);
    }

    public static long toogleIthBit(long n, int i) {
        return n ^ (1 << i);
    }

    public static long leastSignificantBitThatIsOn(long n) {
        return n & (-n);
    }

    public static long swap(long a, int i, int j) {
        if (((a >>> i) & 1) != ((a >>> j) & 1)) {
            // return toogleIthBit(toogleIthBit(a,i),j); or
            return a ^ (1 << i | 1 << j);
        }
        return a;
    }

    public static long closestIntSameWeight(long n) {
        int j = 1;
        while (((n >> j) & 1) == (n & 1)) j++;

        return n ^ (1 << j | 1 << j - 1);
    }

    public static long multiply(long x, long y) {
        long res = 0;
        while (x != 0) {
// Examines each bit of x.
            if ((x & 1) != 0) {
                res = add(res, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return res;
    }

    public static long add(long res, long x) {
        long sum = 0, tempA = res, tempB = x, k = 1, carryIn = 0;
        while (tempA != 0 || tempB != 0) {
            long x1 = res & k;
            long x2 = x & k;
            long carryOut = (x1 & x2) | (x1 & carryIn) | (x2 & carryIn);
            sum |= (x1 ^ x2 ^ carryIn);
            carryIn = carryOut << 1;

            k <<= 1; //   mask to iterate through no doing role of i
            tempA >>>= 1;
            tempB >>>= 1;
        }

        return sum | carryIn;
    }

    /**
     * Return the low-order 32 bits of the double argument as an int.
     */
    private static int __LO(double x) {
        long transducer = Double.doubleToRawLongBits(x);
        return (int) transducer;
    }

    /**
     * Return a double with its low-order bits of the second argument
     * and the high-order bits of the first argument..
     */
    private static double __LO(double x, int low) {
        long transX = Double.doubleToRawLongBits(x);
        return Double.longBitsToDouble((transX & 0xFFFF_FFFF_0000_0000L) |
                (low & 0x0000_0000_FFFF_FFFFL));
    }

    /**
     * Return the high-order 32 bits of the double argument as an int.
     */
    private static int __HI(double x) {
        long transducer = Double.doubleToRawLongBits(x);
        return (int) (transducer >> 32);
    }

    /**
     * Return a double with its high-order bits of the second argument
     * and the low-order bits of the first argument..
     */
    private static double __HI(double x, int high) {
        long transX = Double.doubleToRawLongBits(x);
        return Double.longBitsToDouble((transX & 0x0000_0000_FFFF_FFFFL) |
                (((long) high)) << 32);
    }

    public static double pow(double x, double y) {
        final double INFINITY = Double.POSITIVE_INFINITY;

        double z;
        double r, s, t, u, v, w;
        int i, j, k, n;

        // y == zero: x**0 = 1
        if (y == 0.0)
            return 1.0;

        // +/-NaN return x + y to propagate NaN significands
        if (Double.isNaN(x) || Double.isNaN(y))
            return x + y;

        final double y_abs = Math.abs(y);
        double x_abs = Math.abs(x);
        // Special values of y
        if (y == 2.0) {
            return x * x;
        } else if (y == 0.5) {
            if (x >= -Double.MAX_VALUE) // Handle x == -infinity later
                return Math.sqrt(x + 0.0); // Add 0.0 to properly handle x == -0.0
        } else if (y_abs == 1.0) {        // y is  +/-1
            return (y == 1.0) ? x : 1.0 / x;
        } else if (y_abs == INFINITY) {       // y is +/-infinity
            if (x_abs == 1.0)
                return y - y;         // inf**+/-1 is NaN
            else if (x_abs > 1.0) // (|x| > 1)**+/-inf = inf, 0
                return (y >= 0) ? y : 0.0;
            else                       // (|x| < 1)**-/+inf = inf, 0
                return (y < 0) ? -y : 0.0;
        }

        final int hx = __HI(x);
        int ix = hx & 0x7fffffff;

        /*
         * When x < 0, determine if y is an odd integer:
         * y_is_int = 0       ... y is not an integer
         * y_is_int = 1       ... y is an odd int
         * y_is_int = 2       ... y is an even int
         */
        int y_is_int = 0;
        if (hx < 0) {
            if (y_abs >= 0x1.0p53)   // |y| >= 2^53 = 9.007199254740992E15
                y_is_int = 2; // y is an even integer since ulp(2^53) = 2.0
            else if (y_abs >= 1.0) { // |y| >= 1.0
                long y_abs_as_long = (long) y_abs;
                if (((double) y_abs_as_long) == y_abs) {
                    y_is_int = 2 - (int) (y_abs_as_long & 0x1L);
                }
            }
        }

        // Special value of x
        if (x_abs == 0.0 ||
                x_abs == INFINITY ||
                x_abs == 1.0) {
            z = x_abs;                 // x is +/-0, +/-inf, +/-1
            if (y < 0.0)
                z = 1.0 / z;     // z = (1/|x|)
            if (hx < 0) {
                if (((ix - 0x3ff00000) | y_is_int) == 0) {
                    z = (z - z) / (z - z); // (-1)**non-int is NaN
                } else if (y_is_int == 1)
                    z = -1.0 * z;             // (x < 0)**odd = -(|x|**odd)
            }
            return z;
        }

        n = (hx >> 31) + 1;

        // (x < 0)**(non-int) is NaN
        if ((n | y_is_int) == 0)
            return (x - x) / (x - x);

        s = 1.0; // s (sign of result -ve**odd) = -1 else = 1
        if ((n | (y_is_int - 1)) == 0)
            s = -1.0; // (-ve)**(odd int)

        double p_h, p_l, t1, t2;
        // |y| is huge
        if (y_abs > 0x1.00000_ffff_ffffp31) { // if |y| > ~2**31
            final double INV_LN2 = 0x1.7154_7652_b82fep0;   //  1.44269504088896338700e+00 = 1/ln2
            final double INV_LN2_H = 0x1.715476p0;            //  1.44269502162933349609e+00 = 24 bits of 1/ln2
            final double INV_LN2_L = 0x1.4ae0_bf85_ddf44p-26; //  1.92596299112661746887e-08 = 1/ln2 tail

            // Over/underflow if x is not close to one
            if (x_abs < 0x1.fffff_0000_0000p-1) // |x| < ~0.9999995231628418
                return (y < 0.0) ? s * INFINITY : s * 0.0;
            if (x_abs > 0x1.00000_ffff_ffffp0)         // |x| > ~1.0
                return (y > 0.0) ? s * INFINITY : s * 0.0;
            /*
             * now |1-x| is tiny <= 2**-20, sufficient to compute
             * log(x) by x - x^2/2 + x^3/3 - x^4/4
             */
            t = x_abs - 1.0;        // t has 20 trailing zeros
            w = (t * t) * (0.5 - t * (0.3333333333333333333333 - t * 0.25));
            u = INV_LN2_H * t;      // INV_LN2_H has 21 sig. bits
            v = t * INV_LN2_L - w * INV_LN2;
            t1 = u + v;
            t1 = __LO(t1, 0);
            t2 = v - (t1 - u);
        } else {
            final double CP = 0x1.ec70_9dc3_a03fdp-1;  //  9.61796693925975554329e-01 = 2/(3ln2)
            final double CP_H = 0x1.ec709ep-1;           //  9.61796700954437255859e-01 = (float)cp
            final double CP_L = -0x1.e2fe_0145_b01f5p-28; // -7.02846165095275826516e-09 = tail of CP_H

            double z_h, z_l, ss, s2, s_h, s_l, t_h, t_l;
            n = 0;
            // Take care of subnormal numbers
            if (ix < 0x00100000) {
                x_abs *= 0x1.0p53; // 2^53 = 9007199254740992.0
                n -= 53;
                ix = __HI(x_abs);
            }
            n += ((ix) >> 20) - 0x3ff;
            j = ix & 0x000fffff;
            // Determine interval
            ix = j | 0x3ff00000;          // Normalize ix
            if (j <= 0x3988E)
                k = 0;         // |x| <sqrt(3/2)
            else if (j < 0xBB67A)
                k = 1;         // |x| <sqrt(3)
            else {
                k = 0;
                n += 1;
                ix -= 0x00100000;
            }
            x_abs = __HI(x_abs, ix);

            // Compute ss = s_h + s_l = (x-1)/(x+1) or (x-1.5)/(x+1.5)

            final double BP[] = {1.0,
                    1.5};
            final double DP_H[] = {0.0,
                    0x1.2b80_34p-1};        // 5.84962487220764160156e-01
            final double DP_L[] = {0.0,
                    0x1.cfde_b43c_fd006p-27};// 1.35003920212974897128e-08

            // Poly coefs for (3/2)*(log(x)-2s-2/3*s**3
            final double L1 = 0x1.3333_3333_33303p-1;  //  5.99999999999994648725e-01
            final double L2 = 0x1.b6db_6db6_fabffp-2;  //  4.28571428578550184252e-01
            final double L3 = 0x1.5555_5518_f264dp-2;  //  3.33333329818377432918e-01
            final double L4 = 0x1.1746_0a91_d4101p-2;  //  2.72728123808534006489e-01
            final double L5 = 0x1.d864_a93c_9db65p-3;  //  2.30660745775561754067e-01
            final double L6 = 0x1.a7e2_84a4_54eefp-3;  //  2.06975017800338417784e-01
            u = x_abs - BP[k];               // BP[0]=1.0, BP[1]=1.5
            v = 1.0 / (x_abs + BP[k]);
            ss = u * v;
            s_h = ss;
            s_h = __LO(s_h, 0);
            // t_h=x_abs + BP[k] High
            t_h = 0.0;
            t_h = __HI(t_h, ((ix >> 1) | 0x20000000) + 0x00080000 + (k << 18));
            t_l = x_abs - (t_h - BP[k]);
            s_l = v * ((u - s_h * t_h) - s_h * t_l);
            // Compute log(x_abs)
            s2 = ss * ss;
            r = s2 * s2 * (L1 + s2 * (L2 + s2 * (L3 + s2 * (L4 + s2 * (L5 + s2 * L6)))));
            r += s_l * (s_h + ss);
            s2 = s_h * s_h;
            t_h = 3.0 + s2 + r;
            t_h = __LO(t_h, 0);
            t_l = r - ((t_h - 3.0) - s2);
            // u+v = ss*(1+...)
            u = s_h * t_h;
            v = s_l * t_h + t_l * ss;
            // 2/(3log2)*(ss + ...)
            p_h = u + v;
            p_h = __LO(p_h, 0);
            p_l = v - (p_h - u);
            z_h = CP_H * p_h;             // CP_H + CP_L = 2/(3*log2)
            z_l = CP_L * p_h + p_l * CP + DP_L[k];
            // log2(x_abs) = (ss + ..)*2/(3*log2) = n + DP_H + z_h + z_l
            t = (double) n;
            t1 = (((z_h + z_l) + DP_H[k]) + t);
            t1 = __LO(t1, 0);
            t2 = z_l - (((t1 - t) - DP_H[k]) - z_h);
        }

        // Split up y into (y1 + y2) and compute (y1 + y2) * (t1 + t2)
        double y1 = y;
        y1 = __LO(y1, 0);
        p_l = (y - y1) * t1 + y * t2;
        p_h = y1 * t1;
        z = p_l + p_h;
        j = __HI(z);
        i = __LO(z);
        if (j >= 0x40900000) {                           // z >= 1024
            if (((j - 0x40900000) | i) != 0)               // if z > 1024
                return s * INFINITY;                     // Overflow
            else {
                final double OVT = 8.0085662595372944372e-0017; // -(1024-log2(ovfl+.5ulp))
                if (p_l + OVT > z - p_h)
                    return s * INFINITY;   // Overflow
            }
        } else if ((j & 0x7fffffff) >= 0x4090cc00) {        // z <= -1075
            if (((j - 0xc090cc00) | i) != 0)           // z < -1075
                return s * 0.0;           // Underflow
            else {
                if (p_l <= z - p_h)
                    return s * 0.0;      // Underflow
            }
        }
        /*
         * Compute 2**(p_h+p_l)
         */
        // Poly coefs for (3/2)*(log(x)-2s-2/3*s**3
        final double P1 = 0x1.5555_5555_5553ep-3;  //  1.66666666666666019037e-01
        final double P2 = -0x1.6c16_c16b_ebd93p-9;  // -2.77777777770155933842e-03
        final double P3 = 0x1.1566_aaf2_5de2cp-14; //  6.61375632143793436117e-05
        final double P4 = -0x1.bbd4_1c5d_26bf1p-20; // -1.65339022054652515390e-06
        final double P5 = 0x1.6376_972b_ea4d0p-25; //  4.13813679705723846039e-08
        final double LG2 = 0x1.62e4_2fef_a39efp-1;  //  6.93147180559945286227e-01
        final double LG2_H = 0x1.62e43p-1;            //  6.93147182464599609375e-01
        final double LG2_L = -0x1.05c6_10ca_86c39p-29; // -1.90465429995776804525e-09
        i = j & 0x7fffffff;
        k = (i >> 20) - 0x3ff;
        n = 0;
        if (i > 0x3fe00000) {              // if |z| > 0.5, set n = [z + 0.5]
            n = j + (0x00100000 >> (k + 1));
            k = ((n & 0x7fffffff) >> 20) - 0x3ff;     // new k for n
            t = 0.0;
            t = __HI(t, (n & ~(0x000fffff >> k)));
            n = ((n & 0x000fffff) | 0x00100000) >> (20 - k);
            if (j < 0)
                n = -n;
            p_h -= t;
        }
        t = p_l + p_h;
        t = __LO(t, 0);
        u = t * LG2_H;
        v = (p_l - (t - p_h)) * LG2 + t * LG2_L;
        z = u + v;
        w = v - (z - u);
        t = z * z;
        t1 = z - t * (P1 + t * (P2 + t * (P3 + t * (P4 + t * P5))));
        r = (z * t1) / (t1 - 2.0) - (w + z * w);
        z = 1.0 - (r - z);
        j = __HI(z);
        j += (n << 20);
        if ((j >> 20) <= 0)
            z = Math.scalb(z, n); // subnormal output
        else {
            int z_hi = __HI(z);
            z_hi += (n << 20);
            z = __HI(z, z_hi);
        }
        return s * z;

    }

    public static long add1(long res, long x) {
        byte carry = 0;
        byte x1;
        byte x2;
        long sum = 0;
        int i;
        for (i = 0; i < 64; i++) {
            x1 = (byte) ((res >> i) & 1);
            x2 = (byte) ((x >> i) & 1);
            if (x1 == 1 && x2 == 1) {
                if (carry == 1) {
                    sum |= 1L << i;
                }
                carry = 1;
            } else {
                if (x1 == 1 || x2 == 1) {
                    if (carry == 0) {
                        sum |= 1L << i;
                    }
                } else {
                    if (carry == 1) {
                        sum |= 1L << i;
                        carry = 0;
                    }
                }
            }
            if ((x >> i) == 0) {
                break;
            }
        }

        return sum;
    }

    public static double powerWithBit(double x, int y) {
        double res = 1.0d;
        if (y < 0) {
            y *= -1;
            x = 1 / x;
        }
        while (y != 0) {
            if ((y & 1) == 1) {
                res *= x;
            }
            x *= x;
            y >>>= 1;
        }
        return res;
    }

    public static double power(double x, int y) {
        double res = 1.0d;
        if (y < 0) {
            x = 1 / x;
            y *= -1;
        }
        while (y != 0) {
            res *= x;
            y--;
        }
        return res;
    }

    public static long reverseDigits(int x) {
        long res = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            res = res * 10 + (xRemaining % 10);
            xRemaining /= 10;
        }
        return x < 0 ? -res : res;
    }

    public static int getNumberOfDigitsInNumber(long x) {
        return (int) Math.floor(Math.log10(x)) + 1;
    }

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) return false;

        int numOfDigits = (int) Math.floor(Math.log10(x)) + 1;
        while (x!=0 && numOfDigits!=1){
            int first=x%10;
            int last= (int)(x/Math.pow(10,numOfDigits-1))%10;
            if (first!=last) return false;

            x-=Math.pow(10,numOfDigits);
            x/=10;
            numOfDigits-=2;

        }

        return true;
    }

    public static boolean isPalindromeNumber1(int x) {
        int arr[] = new int[10];
        int i = 0;
        while (x != 0) {
            arr[i++] = x % 10;
            x /= 10;
        }
        i--;
        for (int j = 0; j < i; j++, i--) {
            if (arr[j] != arr[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(BitUtil.isPalindromeNumber(74447));
    }

    /*
    private void SampleTestCaseRun(){
     System.out.println(pow(3,3));
        System.out.println(reverseDigits(42));

     //System.out.println(BitUtil.multiply(38575,65043));
        System.out.println(BitUtil.add(377704701, 2131329024));

        System.out.println(swap(73,1,6));
        System.out.println(closestIntSameWeight(7));


        //parity Tester
        System.out.println(isEvenOddNumber(parity(Long.MAX_VALUE)));
        System.out.println(isEvenOddNumber(parity(6)));
        System.out.println(isEvenOddNumber(parity1(7)));
        System.out.println(isEvenOddNumber(parity1(6)));
        System.out.println(isEvenOddNumber(parity2(7)));
        System.out.println(isEvenOddNumber(parity2(6)));
        System.out.println(isEvenOddNumber(parity3(7)));
        System.out.println(isEvenOddNumber(parity3(6)));
        System.out.println(isEvenOddNumber(parityByLookupTable(Long.MAX_VALUE)));
        System.out.println(isEvenOddNumber(parityByLookupTable(6)));


        System.out.println(BitUtil.isPowerOfTwo(8));
        System.out.println(BitUtil.isPowerOfTwo(7));
        System.out.println(BitUtil.countOneInNumber(8));
        System.out.println(BitUtil.countOneInNumber(7));
        System.out.println(BitUtil.isIthBitSet(8, 3));
        System.out.println(BitUtil.isIthBitSet(7, 4));
        char A[]={'a','b','c'};
        BitUtil.possibleBitSubsets(A, 3);
        System.out.println(BitUtil.largestPowerOfTwo(16));
        System.out.println(BitUtil.toBinaryString(30));
        System.out.println(BitUtil.toBinaryString(30>>2));
        System.out.println(30>>2);
        System.out.println(BitUtil.toBinaryString(30>>3));
        System.out.println(30>>3);
        System.out.println(BitUtil.toBinaryString(30>>4));
        System.out.println(30>>4);
        System.out.println(BitUtil.toBinaryString(8<<2));
        System.out.println(8<<2);
        System.out.println(BitUtil.toBinaryString(8<<3));System.out.println(8<<3);
        System.out.println(BitUtil.toBinaryString(8<<4));System.out.println(8<<4);

        System.out.println(BitUtil.isPrimeNumberSieveOfErasthanos(2));
        System.out.println(BitUtil.isPrimeNumberSieveOfErasthanos(4));
        System.out.println(BitUtil.isPrimeNumberSieveOfErasthanos(3));
        System.out.println(BitUtil.isPrimeNumberSieveOfErasthanos(491));
        System.out.println(BitUtil.isPrimeNumberSieveOfErasthanos(947));
        System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE+" "+Long.MIN_VALUE);
        System.out.println(Float.MAX_VALUE+" "+Float.MIN_VALUE);
        System.out.println(Double.MAX_VALUE+" "+Double.MIN_VALUE);
        int  हिन्दी=10;
        System.out.println(हिन्दी);
        var x=10;
        var y="awaw";
        System.out.println(x);
        System.out.println(y);

    }
    */
}
