package algs4dg.basics.exercises11;

import edu.princeton.cs.algs4.StdOut;

public class ex5 {
    public static void main(String[] args) {
        double x,y;
        x=0.999999;
        y=0.111;

        StdOut.print(isBetweenOneAndTwo(x)&&isBetweenOneAndTwo(y));
    }
    static boolean  isBetweenOneAndTwo(double num){
        return num>0 &&num<1;
   }

}
