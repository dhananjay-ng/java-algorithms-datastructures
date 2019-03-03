package algorithms.util;

import java.util.Random;

public  class  RandomNumberGenerator {
    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    // don't instantiate
    private RandomNumberGenerator() { }

    /**
     * Sets the seed of the pseudo-random number generator.
     * This method enables you to produce the same sequence of "random"
     * number for each execution of the program.
     * Ordinarily, you should call this method at most once per program.
     *
     * @param s the seed
     */
    public static void setSeed(long s) {
        seed   = s;
        random = new Random(seed);
    }

    /**
     * Returns the seed of the pseudo-random number generator.
     *
     * @return the seed
     */
    public static long getSeed() {
        return seed;
    }

    /**
     * Returns a random real number uniformly in [0, 1).
     *
     * @return a random real number uniformly in [0, 1)
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * Returns a random integer uniformly in [0, n).
     *
     * @param n number of possible integers
     */
    public static int uniform(int n) {
        return random.nextInt(n);
    }

    public static int uniform(int x,int y){
        return x+uniform(y-x);
    }
   //to implement
    long a = 25214903917L;   // These Values for a and c are the actual values found
    long c = 11;            // in the implementation of java.util.Random(), see link
    long previous = 0;

    void rseed(long seed) {
        previous = seed;
    }

    long rand() {
        long r = a * previous + c;
        // Note: typically, one chooses only a couple of bits of this value, see link
        previous = r;
        return r;
    }
    public static void main(String[] args) {
        System.out.println(RandomNumberGenerator.uniform(1,10));
    }
}
