package problems.onRecursionAndDp.backtracking;

import java.util.ArrayList;

public class PalindriomSequcne {
    public static class Solution {
        ArrayList<ArrayList<String>> res ;
        public ArrayList<ArrayList<String>> partition(String a) {
            res = new ArrayList<>();
            func(a, 0, 0, new ArrayList<>());
            return res;
        }

        public void func(String a, int parst, int curi, ArrayList<String> step) {
            if(curi == a.length()-1){
                if(ispalindrom(a, parst, curi)) {
                    step.add(a.substring(parst, curi+1));
                    res.add(new ArrayList<>(step));
                    step.remove(step.size()-1);
                }
                return;
            }
            if(ispalindrom(a, parst, curi)) {
                step.add(a.substring(parst, curi+1));
                func(a, curi+1, curi+1, step);
                step.remove(step.size()-1);
            }
            func(a, parst, curi+1, step);
        }
        private boolean ispalindrom(String str, int st, int en) {
            while(st<=en){
                if(str.charAt(st)!=str.charAt(en)) return false;
                st++;
                en--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution
                 = new Solution();
      //  solution.partition("cccaacbcaabb");
        solution.partition("aabac").stream().forEach(strings -> System.out.println(strings));
    }

}
