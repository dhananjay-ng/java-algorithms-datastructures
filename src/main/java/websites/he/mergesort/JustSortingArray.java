package websites.he.mergesort;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class JustSortingArray {

    public static void main(String args[])throws Exception
    {
        Scanner in = new Scanner(new FileInputStream("C:\\Fieldglass\\COPP\\src\\main\\java\\websites\\he\\input.txt"));

        //Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int [n];
            for (int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            String ans ="YES";
            boolean again = true;

            for( int i = 0 ;i < n && again ; i++ ) {
    /*storing current element whose left side is checked for its
             correct position .*/

                int temp = arr[ i ];
                int j = i;

       /* check whether the adjacent element in left side is greater or
            less than the current element. */

                while(  j > 0  && temp < arr[ j -1] && again) {
                    if (arr[j-1] - 1 >= temp + 1){
                        arr[ j ] = arr[ j-1]-1;
                        j= j - 1;
                        temp++;

                    } else {
                        ans = "NO";
                        again= false;
                        break;
                    }
                    // moving the left side element to one position forward.

                }
                // moving current element to its  correct position.
                arr[ j ] = temp;
            }

            if ("NO".equals(ans)) {
                out.println("NO");
            } else {
                out.println("YES");
                for (int i=0;i<n;i++){
                    out.print(arr[i]+" ");
                }
                out.print("\n");
            }
        }
        out.flush();
    }
}
