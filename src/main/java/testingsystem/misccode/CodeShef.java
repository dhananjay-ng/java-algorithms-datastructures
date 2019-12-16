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
                String c = in.next();
                HashSet<Character> seen = new HashSet<>();
                int length = 0;
                for (int i=0;i<c.length();i++) {
                    if (seen.contains(c.charAt(i))) {
                        length = c.length() - i;
                        break;
                    }
                    seen.add(c.charAt(i));
                }
                System.out.println(length);
            }
        } catch (Exception e) {
            return;
        }
    }
}

