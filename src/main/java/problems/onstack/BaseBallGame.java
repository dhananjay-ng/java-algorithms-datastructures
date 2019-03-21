package problems.onstack;
import java.util.Deque;
import java.util.LinkedList;

public class BaseBallGame {
    public static int calPoints(String[] ops) {
        int currentSpace = -1;
        Deque<Integer> bb = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int one = Integer.parseInt(ops[i-1]);
                int two = Integer.parseInt(ops[i-2]);
                ops[i] = Integer.toString(one + two);
            } else if (ops[i].equals("D")) {
                ops[i] = Integer.toString(Integer.parseInt(ops[i-1])*2);
            } else if (ops[i].equals("C")) {
                ops[i] = "";
                currentSpace = i;
            } else {
                if (currentSpace!=-1){
                    ops[currentSpace] = ops[i];
                }
                bb.addFirst(Integer.parseInt(ops[i]));
            }
        }
        int total = 0;
        while (!bb.isEmpty()) {
            total += bb.removeFirst();
        }
        return total;
    }

    public static int calPoints1(String[] ops) {
        Deque<Integer> bb = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int one = bb.removeFirst();
                int two = bb.peek();
                bb.addFirst(one);
                bb.addFirst(one + two);
            } else if (ops[i].equals("D")) {
                bb.addFirst(bb.peek() * 2);
            } else if (ops[i].equals("C")) {
                bb.removeFirst();
            } else {
                bb.addFirst(Integer.parseInt(ops[i]));
            }
        }
        int total = 0;
        while (!bb.isEmpty()) {
            total += bb.removeFirst();
        }
        return total;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }
}
