package problems.onstack;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxApiCacheImpl {
    static class ElementWithCachedMax {
        Integer element;
        Integer maxElement;

        ElementWithCachedMax(Integer element, Integer maxElement) {
            this.element = element;
            this.maxElement = maxElement;
        }
    }

    public static class Stack {
        Deque<ElementWithCachedMax> elementWithCachedMaxes = new LinkedList<>();

        public boolean empty() {
            return elementWithCachedMaxes.isEmpty();
        }

        public Integer max() {
            if (empty()) {
                throw new IllegalStateException("max(): called on empty stack");
            }
            return elementWithCachedMaxes.peek().maxElement;
        }

        public Integer pop() {
            if (empty()) {
                throw new IllegalStateException("pop(): called on empty stack");
            }
            return elementWithCachedMaxes.removeFirst().element;
        }

        public void push(Integer x) {
            elementWithCachedMaxes.addFirst(new ElementWithCachedMax(x, Math.max(x, empty() ? x : max())));
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
