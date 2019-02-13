package testingsystem.misccode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CodeShef {


    public static void main(String[] args) throws IOException {
        try {
           // Scanner in = new Scanner(new File("src\\main\\java\\testingsystem\\misccode\\input.txt"));
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- >= 0) {
                int n = in.nextInt();
                long a = in.nextLong();
                long s = 1l;
                for (int i=0;i<=n;i++)
                    s=s*10;

                s*=5;



                System.out.println(s);
                System.out.flush();
                long b = in.nextLong();
                System.out.println(1);
                System.out.flush();
                long d = in.nextInt();
                System.out.println(s - a - b - 1 - d);
                System.out.flush();
                long x = in.nextLong();
                if (x == -1) System.exit(-1);
                }
        } catch (Exception e) {
            return;
        }
    }
}

