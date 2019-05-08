package problems.onhashtable;

import java.util.*;

public class TopKWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> ee : map.entrySet()) {
            pq.add(ee);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        while (pq.isEmpty() == false) {
            res.add(0, pq.remove().getKey());
        }
        return res;

    }
}
