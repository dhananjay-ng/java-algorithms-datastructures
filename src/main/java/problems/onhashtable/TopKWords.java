package problems.onhashtable;

import java.util.*;

public class TopKWords {
    //using bucketing bucket sort
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if(words==null || words.length==0) return result;
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(String key : map.keySet()){
            if(max < map.get(key))
                max = map.get(key);
        }

        List<String>[] buckets =  new ArrayList[max+1];
        for(String word : map.keySet()){
            int count = map.get(word);
            if(buckets[count]==null)
                buckets[count] = new ArrayList<String>();
            buckets[count].add(word);
        }

        for(int i=buckets.length-1;i>=0;i--){
            int j=0;
            if(buckets[i]!=null){
                Collections.sort(buckets[i]);
            }else continue;
            while(buckets[i]!=null && k>0 && j<buckets[i].size()){
                result.add(buckets[i].get(j));
                j++;
                k--;
            }
            if(k==0) break;
        }

        return result;
    }


    public List<String> topKFrequent1(String[] words, int k) {
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
