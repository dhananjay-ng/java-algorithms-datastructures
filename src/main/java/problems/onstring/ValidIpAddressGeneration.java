package problems.onstring;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ValidIpAddressGeneration {

    public static List<String> getValidIpAddress(String s) {
        Set<String> res = new LinkedHashSet<>();
        int maxLength = s.length();
        for (int i=2;i>=0;i--){
            for (int j=2;j>=0;j--){
                for (int k=2;k>=0;k--){
                    for (int p=2;p>=0;p--){
                        if (i+j+k+p+4 > maxLength) continue;
                        try {


                        int one = Integer.valueOf(s.substring(0,i+1));
                        int two = Integer.valueOf(s.substring(i+1,i+j+2));
                        int three = Integer.valueOf(s.substring(i+j+2,i+j+k+3));
                        int four = Integer.valueOf(s.substring(i+j+k+3,i+j+k+p+4));
                        if (one>255 || two>255 || three>255 || four>255) continue;
                        else {
                            StringBuilder sb= new StringBuilder();
                            sb.append(one).append(".")
                                    .append(two).append(".")
                                    .append(three).append(".")
                                    .append(four);
                            if (sb.toString().length() != maxLength+3) continue;
                            res.add(sb.toString());
                        }
                        } catch (Exception e){

                        }
                    }
                }
            }
        }

        List<String> ress=new ArrayList<>();
        res.forEach(s1 -> ress.add(s1));
        return ress;
    }

    public static void main(String[] args) {
        List<String> res = getValidIpAddress("11000");
        res.forEach(s -> System.out.println(s));
    }
}
