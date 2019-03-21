package problems.onstack;


import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                T[stack.peek()] = i - stack.removeFirst();
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty())
            T[stack.removeFirst()] = 0;
        return T;
    }

    public static int[] dailyTemperaturesFaster(int[] T) {
        int n = T.length, next = 0;
        int[] t = new int[n], result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            next = i + 1;
            while (next < n && T[next] <= T[i]) next = t[next]; // Find the next warmer hitboundary
            t[i] = next;
            if (next != n) result[i] = next - i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }
}
