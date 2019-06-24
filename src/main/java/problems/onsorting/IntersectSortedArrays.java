package problems.onsorting;

import java.util.ArrayList;
import java.util.List;

/***
 * COMPUTE THE INTERSECTION OF TWO SORTED ARRAYS
 * A natural implementation for a search engine is to retrieve documents that match the
 * set of words in a query by maintaining an inverted index. Each page is assigned an
 * integer identifier, its document-ID . An inverted index is a mapping that takes a word
 * w and returns a sorted array of page-ids which contain w — the sort order could be,
 * for example, the page rank in descending order. When a query contains multiple
 * words, the search engine finds the sorted array for each word and then computes the
 * intersection of these arrays — these are the pages containing all the words in the query.
 * The most computationally intensive step of doing this is finding the intersection of
 * the sorted arrays.
 * Write a program which takes as input two sorted arrays, and returns a new array
 * containing elements that are present in both of the input arrays. The input arrays
 * may have duplicate entries, but the returned array should be free of duplicates. For
 * example, the input is (2, 3,3, 5, 5, 6, 7,7, 8, 12} and (5,5,6,8,8,9,10,10), your output
 * should be (5, 6, 8).
 */
public class IntersectSortedArrays {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                         List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.size() && j < B.size()) {
            if (B.get(j).equals(A.get(i)) && (res.isEmpty() || !res.get(res.size()-1).equals(A.get(i)))){
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)){
                i++;
            }
            else {
                j++;
            }

        }

        return res;
    }
}
