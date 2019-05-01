package problems.onsearching;

import java.util.List;

public class SearchForMissingElement {

    /***
     * You are given an array of n integers, each between 0 and n - 1, inclusive. Exactly
     * one element appears twice, implying that exactly one number between 0 and n - 1
     * is missing from the array. How would you compute the duplicate and missing
     * numbers?
     * //space O(1) , time O(n)
     */
    public static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }
    }

    public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
        int missingXORDuplicate = 0;

        for (int i = 0; i < A.size(); i++)
            missingXORDuplicate ^= i ^ A.get(i);

        int onlyLsbSet = missingXORDuplicate & ~(missingXORDuplicate - 1);
        int missingOrDuplicateValue = 0;
        for (int i = 0; i < A.size(); i++) {
            if ((onlyLsbSet & i) != 0) {
                missingOrDuplicateValue ^= i;
            }
            if ((onlyLsbSet & A.get(i)) != 0) {
                missingOrDuplicateValue ^= A.get(i);
            }
        }

        //now missXorDub is either duplicate or missing element.
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == missingOrDuplicateValue)
                return new DuplicateAndMissing(missingOrDuplicateValue, missingOrDuplicateValue ^ missingXORDuplicate);
        }
        return new DuplicateAndMissing(missingOrDuplicateValue ^ missingXORDuplicate, missingOrDuplicateValue);
    }

}
