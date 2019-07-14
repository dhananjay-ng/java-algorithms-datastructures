package javarecipies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class OnePager {
    void inc(int a[]){
        a[0]=2;
    }
    public static void main(String[] args) {
        int a[] = {1};
        OnePager p =new OnePager();
        p.inc(a);
        System.out.println(a[0]);


//    int m=0x000F;
//     int v=0x2222;
//        System.out.println(v&m);

        Float f = new Float("3");
        System.out.println(f.intValue()+f.floatValue()+f.doubleValue());
    }

}
