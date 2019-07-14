package testingsystem.misccode;

import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) throws IOException {
        Reader in = new Reader("src\\main\\java\\testingsystem\\misccode\\input.txt");
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] f = new int[n];
            int[] s = new int[m];
            for(int i = 0;i<n;i++){
                f[i]=in.nextInt();
            }
            for(int i = 0;i<m;i++){
                s[i]=in.nextInt();
            }
            int i=0,j=0;
            while(i<n && j<m){
                if(f[i]<=s[j]) {
                    result.append(f[i++]).append(" ");
                } else{
                    result.append(s[j++]).append(" ");
                }
            }
            while(i<n){
                result.append(f[i++]).append(" ");
            }
            while(j<m){
                result.append(s[j++]).append(" ");
            }
            result.append("\n");

        }
        System.out.println(result.toString());
    }
}