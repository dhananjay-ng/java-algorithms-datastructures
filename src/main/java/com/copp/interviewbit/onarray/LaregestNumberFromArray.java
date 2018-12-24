package com.copp.interviewbit.onarray;
import java.util.Arrays;
import java.util.Comparator;

public class LaregestNumberFromArray {
    public static String largestNumber(final int[] arr) {
        final String[] s =new String[arr.length];
        for (int i=0;i<arr.length;i++){
            s[i]= String.valueOf(arr[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1 + o2);
            }
        });

        StringBuilder res=new StringBuilder();
        for (String sp:s)
            res.append(sp);

        return res.toString();
    }



    // Driver method to test above
    public static void main(String args[])
    {
        int arr[] = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));


    }
}
