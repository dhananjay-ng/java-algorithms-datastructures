package problems.onhashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {
    LinkedHashMap<Integer, Integer> isbs;

    LRUCacheWithLinkedHashMap(final int capacity) {
        isbs = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer key) {
        return isbs.getOrDefault(key, -1);
    }

    public void insert(Integer key, Integer value) {
        isbs.putIfAbsent(key, value);
    }

    public Boolean erase(Object key) {
        return isbs.remove(key) != null;
    }

}

