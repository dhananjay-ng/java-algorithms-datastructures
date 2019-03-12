package problems.onstring;

import algorithms.string.BoyerMoore;
import algorithms.string.KMP;

public class SubStringSearch {
    public static int naiveSS(String t, String s){
        if (s.length()==0) return 0;
        for (int i=0;i<t.length();i++){
            int count=0;
            for (int j=0;j<s.length();j++){
                if (i+j<t.length()&& s.charAt(j)==t.charAt(i+j)){
                    count++;
                }
                if (s.length()==count) return i;
            }
        }
        return -1;
    }
    public static int naiveOneLoop(String t, String s) {
        int i, j;
        for (i = 0, j = 0; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) j++;
            else { i -= j; j=0;}                //explicit backup
        }
        if (j == s.length()) return i - j;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(naiveSS("Hi this is me","is"));

        //Using KMP
        System.out.println(KMP.search("Hi this is me","is"));

        //Boyer Moore
        System.out.println(BoyerMoore.search("Hi this is me","is"));
    }
}
