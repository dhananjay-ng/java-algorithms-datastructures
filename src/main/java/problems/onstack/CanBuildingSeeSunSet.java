package problems.onstack;

import java.util.*;

public class CanBuildingSeeSunSet {
    public static class Building {
        int id;
        int height;

        public Building(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }

    public static List<Integer>
    examineBuildingsWithSunset(Iterator<Integer> sequence) {
        Deque<Building> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int id = 0;
        while (sequence.hasNext()) {
            Integer curr = sequence.next();
            while (!stack.isEmpty() && stack.peek().height <= curr) {
                stack.removeFirst();
            }
            stack.addFirst(new Building(id++, curr));
        }
        while (!stack.isEmpty()) {
            res.add(stack.removeFirst().id);

        }
        return res;
    }

    public static void main(String[] args) {
        Integer height[] = {6, 1, 2};
        System.out.println(examineBuildingsWithSunset(Arrays.asList(height).iterator()));
    }
}
