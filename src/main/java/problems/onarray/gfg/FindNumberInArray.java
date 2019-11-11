package problems.onarray.gfg;

import testingsystem.misccode.Reader2;

import java.io.IOException;

public class FindNumberInArray {

    public static void main (String[] args) throws IOException {
        Reader2 in = new Reader2("C:\\Fieldglass\\COPP\\src\\main\\java\\testingsystem\\misccode\\input.txt");
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i=0;i<n;i++)
                a[i] = in.nextInt();

            int search = in.nextInt();
            boolean found = false;
            for (int i=0;i<n;i++){
                if (a[i] == search){
                    result.append(i);
                    found = true;
                    if (t!=0) result.append("\n");
                    break;
                }
            }
            if (!found) {
                result.append(-1);
                if (t!=0) result.append("\n");
            }

        }
        System.out.println(result);
    }
}
