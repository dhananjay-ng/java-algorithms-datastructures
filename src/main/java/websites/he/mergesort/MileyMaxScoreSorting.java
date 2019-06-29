package websites.he.mergesort;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MileyMaxScoreSorting {
    public static void main(String args[])throws Exception
    {
       // Scanner in = new Scanner(new FileInputStream("C:\\Fieldglass\\COPP\\src\\main\\java\\websites\\he\\input.txt"));

       Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n = in.nextInt();
        int q = in.nextInt();
        int t[] = new int[n];
        int s[] = new int[n];

        for (int i=0;i<n;i++) {
            t[i] = in.nextInt();
        }

        for (int i=0;i<n;i++) {
            s[i] = in.nextInt();
        }
        Arrays.sort(t);
        for (int i=0;i<q;i++){
            int qi = in.nextInt();
            long timsum = 0;
            for (int j=0;j<qi;j++){
                timsum+=t[t.length-1-j];
            }
            out.println(timsum);
        }
        out.flush();
    }
}
