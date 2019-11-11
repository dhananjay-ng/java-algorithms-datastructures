package problems.onstring.gfg;

import testingsystem.misccode.Reader2;

import java.io.IOException;

public class PossibleNumberStringsStartAndEndWithOne {
    public static void main(String[] args) throws IOException {
        Reader2 in = new Reader2("src\\main\\java\\testingsystem\\misccode\\input.txt");
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int strlen = in.nextInt();
            String s = in.readLine(strlen);
            int count = 0;
            for (int i=0;i<s.length();i++){
                if (s.charAt(i) == '1') count++;
            }
            count--;
            int posibilities = count * (count + 1) / 2;
            result.append(posibilities > 0 ? posibilities : 0);
            if (t != 0) result.append("\n");
        }
        System.out.println(result);
    }
}
