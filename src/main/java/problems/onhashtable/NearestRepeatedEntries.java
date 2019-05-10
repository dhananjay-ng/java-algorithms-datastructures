package problems.onhashtable;

import java.util.HashMap;
import java.util.List;
public class NearestRepeatedEntries {
    public static int findNearestRepetition(List<String> paragraph) {
        HashMap<String, Integer> lookup = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < paragraph.size(); i++) {
            if (lookup.containsKey(paragraph.get(i))) {
                min = Math.min(i - lookup.get(paragraph.get(i)), min);
            }
            lookup.put(paragraph.get(i), i);

        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

}
