package algs4dg.percolation; /**
 * Created by @apprentice on 7/24/2018.
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
   private int Tum;
    private double meanu,stddevu;
    private double countOpenSiteArray[];
    //The constructor should throw a java.lang.IllegalArgumentException if either n ≤ 0 or trials ≤ 0.
    public PercolationStats(int N, int T)  {
        Tum=T;
        if (N <= 0){
            throw new IllegalArgumentException();
        }
        if (T <= 0){
            throw new IllegalArgumentException();
        }
        countOpenSiteArray=new double[T];
        for (int i=0;i<T;i++){ //trials
            Percolation perc=new Percolation(N);
            int count=0; //open sites
            while (!perc.percolates()){ //till not percolates
                int k=StdRandom.uniform(1,N+1);
                int l=StdRandom.uniform(1,N+1);
                while(perc.isOpen(k,l)){
                     k=StdRandom.uniform(1,N+1);
                     l=StdRandom.uniform(1,N+1);
                }
                perc.open(k,l);
                count++;

            }
            countOpenSiteArray[i]=(double)count/((double) N* (double) N);;
        }
        meanu=StdStats.mean(countOpenSiteArray);
        stddevu=StdStats.stddev(countOpenSiteArray);

    }
    public double mean() {

        return meanu;

    }
    public double stddev()  {

        return stddevu;
    }
    public double confidenceLo(){

        return meanu-(1.96*stddevu/Math.sqrt(Tum));

    }
    public double confidenceHi()  {

        return meanu+(1.96*stddevu/Math.sqrt(Tum));
    }

    public static void main(String[] args){
        PercolationStats testPer = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean   = " + testPer.mean());
        StdOut.println("stddev = " + testPer.stddev());
        StdOut.println("95% confidence interval = [" + testPer.confidenceLo() + ", " + testPer.confidenceHi()+"]");
    }
}
