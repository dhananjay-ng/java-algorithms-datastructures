package problems.onstack;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxApiMaxCountImpl {
    static class MaxWithCount {
        Integer maxElement;
        Integer count;

        MaxWithCount(Integer element, Integer maxElement) {
            this.maxElement = element;
            this.count = maxElement;
        }
    }

    public static class Stack {
        Deque<MaxWithCount> stackWithMaxCount = new LinkedList<>();
        Deque<Integer> stackOfElement = new LinkedList<>();

        public boolean empty() {
            return stackOfElement.isEmpty();
        }

        public Integer max() {
            if (empty()) {
                throw new IllegalStateException("max(): called on empty stack");
            }
            return stackWithMaxCount.peek().maxElement;
        }

        public Integer pop() {
            if (empty()) {
                throw new IllegalStateException("pop(): called on empty stack");
            }
            Integer poppedElement = stackOfElement.removeFirst();
            if (poppedElement.equals(stackWithMaxCount.peek().maxElement)) {
                stackWithMaxCount.peek().count -= 1;
                if (stackWithMaxCount.peek().count == 0) {
                    stackWithMaxCount.removeFirst();
                }
            }
            return poppedElement;
        }

        public void push(Integer x) {
            if (!stackWithMaxCount.isEmpty()) {
                if (Integer.compare(x, max()) == 0) {
                    stackWithMaxCount.peek().count += 1;
                } else if (Integer.compare(x, max()) > 0) {
                    stackWithMaxCount.addFirst(new MaxWithCount(x,1));
                }

            } else {
                stackWithMaxCount.addFirst(new MaxWithCount(x, 1));
            }
            stackOfElement.addFirst(x);
        }

    }

    public static void main(String[] args) {
        Stack maxApiEnabled = new Stack();
        maxApiEnabled.push(9);
        maxApiEnabled.push(9);
        maxApiEnabled.push(10);
        maxApiEnabled.push(8);
        maxApiEnabled.push(1);
        System.out.println(maxApiEnabled.max());
        maxApiEnabled.pop();
        System.out.println(maxApiEnabled.max());
        maxApiEnabled.pop();
        System.out.println(maxApiEnabled.max());
        maxApiEnabled.pop();
        System.out.println(maxApiEnabled.max());
        maxApiEnabled.pop();
        System.out.println(maxApiEnabled.max());
        maxApiEnabled.pop();
    }
}
