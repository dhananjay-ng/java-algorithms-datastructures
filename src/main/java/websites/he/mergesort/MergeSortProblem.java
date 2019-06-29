package websites.he.mergesort;

import java.io.FileInputStream;
import java.util.Scanner;

public class MergeSortProblem {
    /**
     * Given a set of strings print the set sorted according to their size. If the size of the strings are equal, must maintain the original order of the set.
     *
     * Input :
     *
     * The first line of input has an integer T that indicates the number of sets of strings, each set may contain between 1 and 50 inclusive elements, and each of the strings of the set may contain between 1 and 50 inclusive characters('a' to 'z').
     *
     * Output:
     *
     * The output should contain the set of input strings ordered by the length of strings.A blank space must be printed between two words.
     *
     * SAMPLE INPUT
     * 3
     * ab cd e j asd ljffg df
     * a a b b c c
     * xy yx zxy zx xzy xxx
     * SAMPLE OUTPUT
     * e j ab cd df asd ljffg
     * a a b b c c
     * xy yx zx zxy xzy xxx
     */

    public static void merge(String[] src, String dist[], int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k<=hi; k++) {
            if (i > mid) dist[k] = src[j++];
            else if (j > hi) dist[k] = src[i++];
            else if (less(src[i], src[j])) dist[k] = src[i++];
            else dist[k] = src[j++];
        }
    }

    private static boolean less(String s, String s1) {
        if (s.length() <= s1.length()) {
            return true;
        }
        return false;
    }

    public static void sort(String[] src, String dest[], int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo)/2;
        sort(dest, src, lo, mid);
        sort(dest, src, mid+1, hi);
        merge(src, dest, lo,mid,hi);

    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(new FileInputStream("C:\\Fieldglass\\COPP\\src\\main\\java\\websites\\he\\input.txt"));

        int t = s.nextInt();
        StringBuilder res = new StringBuilder();
        s.nextLine();
        while (t-- > 0) {
            String[] dest = s.nextLine().split(" ");
            String[] src = dest.clone();
            sort(src, dest, 0, src.length-1);
            for (int i=0;i<dest.length;i++) {
                res.append(" ").append(dest[i]);
            }
            res.append("\n");
        }
        System.out.println(res.toString());
    }

}

