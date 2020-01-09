package problems.onmath.gfg;

import testingsystem.misccode.Reader2;

import java.io.IOException;

public class IsPrime {
    //To DO: fermats method, miller rabin method, solovay straseen method
    public int isPrime(int A) {
        if(A == 1) return 0;
        for(int i=2;i<=Math.sqrt(A);i++){
            if(A%i == 0) return 0;
        }
        return 1;
    }
    //easy one
    public static void main (String[] args) throws IOException {
        Reader2 in = new Reader2("src\\main\\java\\testingsystem\\misccode\\input.txt");
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            boolean isprime = true;
            for (int i=2;i<=Math.sqrt(n);i++){
                if (n % i == 0) {
                    isprime = false;
                    result.append("No").append("\n");
                    break;
                }
            }
            if(isprime) {
                result.append("Yes").append("\n");
            }
        }
        System.out.println(result);
    }
}
