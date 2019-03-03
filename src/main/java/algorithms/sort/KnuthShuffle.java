package algorithms.sort;

public class KnuthShuffle {

        public static void shuffleLeft(Object[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                // choose index uniformly in [0, i]
                int r = (int) (Math.random() * (i + 1));
                Object swap = a[r];
                a[r] = a[i];
                a[i] = swap;
            }
        }

        public static void shuffleRight(Object[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                // choose index uniformly in [i, n-1]
                int r = i + (int) (Math.random() * (n - i));
                Object swap = a[r];
                a[r] = a[i];
                a[i] = swap;
            }
        }

}
