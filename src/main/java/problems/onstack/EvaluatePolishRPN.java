package problems.onstack;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluatePolishRPN {
    //Postfix eval
    public static int eval(String expression) {
        Deque<Integer> deque = new LinkedList<>();
        String str[] = expression.split(",");
        for (String token : str) {
            if ("+".equals(token)){
                deque.addFirst(deque.removeFirst() + deque.removeFirst());
            } else if ("-".equals(token)){
                deque.addFirst(-deque.removeFirst() + deque.removeFirst());
            } else if ("*".equals(token)){
                deque.addFirst(deque.removeFirst() * deque.removeFirst());

            } else if ("/".equals(token)) {
                Integer first = deque.removeFirst();
                deque.addFirst(deque.removeFirst() / first);

            } else {
                deque.addFirst(Integer.valueOf(token));
            }
        }
        return deque.removeFirst();
    }
    //Postfix eval
    public static int prefixEval(String expression) {
        Deque<Integer> deque = new LinkedList<>();
        String str[] = expression.split(",");
        for (int i=str.length-1; i>=0;i--) {
            String token = str[i];
            if ("+".equals(token)){
                deque.addFirst(deque.removeFirst() + deque.removeFirst());
            } else if ("-".equals(token)){
                deque.addFirst(-deque.removeFirst() + deque.removeFirst());
            } else if ("*".equals(token)){
                deque.addFirst(deque.removeFirst() * deque.removeFirst());

            } else if ("/".equals(token)) {
                Integer first = deque.removeFirst();
                deque.addFirst(deque.removeFirst() / first);

            } else {
                deque.addFirst(Integer.valueOf(token));
            }
        }
        return deque.removeFirst();
    }


    public static void main(String[] args) {
        System.out.println(eval("2,4,5,+,*"));
        System.out.println(prefixEval("*,2,+,4,5"));
    }
}
