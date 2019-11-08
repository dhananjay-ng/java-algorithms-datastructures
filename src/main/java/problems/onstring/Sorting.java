package problems.onstring;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> input = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            input.add(sc.next());
        }
        System.out.println(input.size());
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.startsWith(o2) || o2.startsWith(o1)) {
                    return o1.length() > o2.length() ? -1 : 1;
                }
                return o1.compareTo(o2);
            }
        });
        input.forEach(s -> System.out.println(s));
    }
}
