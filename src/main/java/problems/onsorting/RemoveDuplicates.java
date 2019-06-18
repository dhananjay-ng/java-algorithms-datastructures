package problems.onsorting;

import java.util.Collections;
import java.util.List;

public class RemoveDuplicates {
    /**
     * Design an efficient algorithm for removing all first-name duplicates from an array. For
     * example, if the input is ((Ian, Botham), (David, Gower), (Ian, Bell), (Ian, Chappell)),
     * one result could be ((Ian, Bell), (David, Gower)); ((David, Gower), (Ian, Botham))
     * would also be acceptable.
     */

    public static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String first, String last) {
            firstName = first;
            lastName = last;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Name)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Name name = (Name) obj;
            return firstName.equals(name.firstName) && lastName.equals(name.lastName);
        }

        @Override
        public String toString() {
            return firstName;
        }

        @Override
        public int compareTo(Name name) {
            int cmpFirst = firstName.compareTo(name.firstName);
            if (cmpFirst != 0) {
                return cmpFirst;
            }
            return lastName.compareTo(name.lastName);
        }
    }

    public static void eliminateDuplicate(List<Name> names) {
        Collections.sort(names);
        int lastSeen = 0;

        for (int i = 1; i < names.size(); i++) {
            if (!names.get(i).firstName.equals(names.get(lastSeen).firstName)) {
                names.set(++lastSeen, names.get(i));
            }
        }
        names.subList(++lastSeen, names.size()).clear();
        return;
    }
}
