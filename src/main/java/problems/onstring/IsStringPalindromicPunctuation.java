package problems.onstring;

public class IsStringPalindromicPunctuation {
    public static boolean isPalindrome(String s) {
        for (int li=0,ri=s.length()-1;li<ri;){
            if (!Character.isLetterOrDigit(s.charAt(li))){
                li++;continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(ri))){
                ri--;continue;
            }
            if (Character.toUpperCase(s.charAt(li))!=Character.toUpperCase(s.charAt(ri))){
                return false;
            } li++;
            ri--;
        }

        return true;
    }
}
