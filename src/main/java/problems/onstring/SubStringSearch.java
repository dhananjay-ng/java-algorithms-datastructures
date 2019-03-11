package problems.onstring;

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

    public static void main(String[] args) {
        System.out.println(naiveSS("Hi this is me","is"));
    }
}
