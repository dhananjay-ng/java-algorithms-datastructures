package algs4dg.stackqueue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.ResizingArrayQueue;

/*
 * Created by @apprentice on 10/14/2018.
 */
public class StackTest1 {
    public static void main(String[] args) {
        String test= StdIn.readLine();
        StdOut.println(test);
        Stack<Integer> stack= new Stack<>();

        stack.push(1);

        System.out.println(stack.pop());

    }

}
