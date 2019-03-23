package problems.onqueue;

import java.util.Deque;
import java.util.LinkedList;

public class GenerateBinaryNumberTillN {
    public static void generateBinaryNumbers(int n){
        Deque<String> bnum = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            if(bnum.isEmpty()){
                bnum.addFirst("1");
            }
            String x = bnum.removeLast();
            sb.append(x);
            if(n!=0) sb.append(" ");
            bnum.addFirst(x+"0");
            bnum.addFirst(x+"1");

        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        generateBinaryNumbers(6);
    }
}
