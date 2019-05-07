package problems.onhashtable;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    Deque<Integer> deque = new LinkedList<>();
    HashMap<Integer, Integer> isbns;
    int capacity;

    LRUCache(final int capacity) {
        isbns = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public Integer lookup(Integer key) {
        if (isbns.containsKey(key)) {
            deque.remove(key);
            deque.addLast(key);
            return isbns.get(key);
        }
        return -1;
    }

    public void insert(Integer key, Integer value) {
        if (isbns.containsKey(key)) {
            deque.remove(key);
            deque.addLast(key);
        } else {
            if (deque.size() == capacity) {
                isbns.remove(deque.removeFirst());
            }
            deque.addLast(key);
            isbns.put(key, value);

        }
    }

    public Boolean erase(Object key) {
        if (isbns.containsKey(key)) {
            deque.remove(key);
            isbns.remove(key);
            return true;
        }
        return false;
    }

}
