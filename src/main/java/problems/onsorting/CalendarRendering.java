package problems.onsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarRendering {
    /**
     * Write a program that takes a set of events, and determines the maximum number of
     * events that take place concurrently.
     */
    public static class Event {
        public int start, finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static class Endpoint implements Comparable<Endpoint> {
        public int time;
        public boolean isStart;

        Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Endpoint o) {
            if (this.time != o.time) {
                return time - o.time;
            }
            return isStart && !o.isStart ? -1 : !isStart && o.isStart ? 1 : 0;
        }
    }

    public static int findMaxSimultaneousEvents(List<Event> A) {

        List<Endpoint> endpoints = new ArrayList<>();
        for (Event e : A) {
            endpoints.add(new Endpoint(e.start, true));
            endpoints.add(new Endpoint(e.finish, false));
        }

        Collections.sort(endpoints);

        int gloablmax = 0;
        int curCount = 0;
        for (Endpoint e : endpoints) {
            if (e.isStart)
                curCount++;
            else
                curCount--;

            gloablmax = Math.max(gloablmax, curCount);
        }

        return gloablmax;
    }

}
