package problems.onstring;

public class LookAndSay {
    public static String lookAndSay(int n) {
        if (n==0) return "";
        String res="1";
        n--;
        while (n-- >0){
            res = nextNumber(res);
        }
        return res;
    }

    public static String nextNumber(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char a = num.charAt(i);
            i++;
            count++;
            while (i < num.length() && a == num.charAt(i)) {
                count++;
                i++;
            }
            i--;
            sb.append(count).append(a);
            count = 0;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //1113213211
        System.out.println(lookAndSay(8));
    }
}
