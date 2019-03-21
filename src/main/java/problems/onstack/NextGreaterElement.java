package problems.onstack;

import java.lang.reflect.Array;
import java.util.*;

public class NextGreaterElement {
    //O(m+n) //O(m+n)
    public static int[] nextGreaterElement(int[] n1, int[] n2) {
        Map<Integer,Integer> look = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<n2.length;i++){
            while(stack.isEmpty() == false && stack.peek()<n2[i]){
                look.put(stack.removeFirst(), n2[i]);
            }
            stack.addFirst(n2[i]);
        }

        for (int i=0;i<n1.length;i++) {
            n1[i] = look.getOrDefault(n1[i], -1);
        }
        return n1;
    }
    //problem@https://leetcode.com/problems/next-greater-element-i
    //O(n*m) time complexity , O(1) space.
    public static int[] nextGreaterElement1(int[] n1, int[] n2) {
        for(int i=0;i<n1.length;i++){
            int j=0;
            while(n2[j++]!=n1[i]);
            while(j < n2.length && n2[j++] <= n1[i]);
            if(j == n2.length)n1[i] = -1;else n1[i] = n2[j-1];
        }
        return n1;
    }

    public static void main(String[] args) {
        int[] n1 = {4, 1, 2};
        int[] n2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(n1,n2)));
    }
}
