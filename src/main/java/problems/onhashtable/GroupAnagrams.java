package problems.onhashtable;

import java.util.*;

public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ana = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String ss = new String(cs);
            if (!ana.containsKey(ss)) {
                ana.put(ss, new ArrayList<>());
            }
            ana.get(ss).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> ee : ana.entrySet()) {
            res.add(ee.getValue());
        }
        //or
        /*for (List<String> ee : ana.values()) {
            res.add(ee);
        }*/
        return res;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }

}
