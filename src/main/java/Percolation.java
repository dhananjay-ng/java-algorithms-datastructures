import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by apprentice on 7/22/2018.
 */

public class Percolation {
    private  int n;
    private int size,first,last;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean opened[];
    private int numberOfOpenSites;
    public Percolation(int n){
        this.n=n;
        numberOfOpenSites=0;
        size=n*n;
        first=size;
        last=size+1;
        opened=new boolean[size];
        weightedQuickUnionUF=new WeightedQuickUnionUF(size+2);
        if(n<2) return;
        for(int i=0;i<n;i++){
            weightedQuickUnionUF.union(first,i);
            weightedQuickUnionUF.union(last,size-1-i);
        }

    }        // create n-by-n grid, with all sites blocked


    public    void open(int row, int col) {
        int id=toSingleDimension(row,col);
        if(opened[id]){
            return;
        }
        else {
            opened[id]=true;
            numberOfOpenSites++;
        }
        if (n==1){
            weightedQuickUnionUF.union(id,first);
            weightedQuickUnionUF.union(id,last);
            return;
        }

        //connect top & bottom based on open state
        int top=id-n;
        int bottom=id+n;
        if(!(top<0)){
            linkSite(id,top);
        }
        if (bottom<first){
            linkSite(id,bottom);
        }
        //only right side
        int right=id+1;
        int left=id-1;

        if(col==1){
            linkSite(id,right);
            return;
        }
        if (col==n){
            linkSite(id,left);
            return;
        }
        //link both left right
        linkSite(id,right);
        linkSite(id,left);

    }   // open site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        return opened[toSingleDimension(row,col)];
    }

    public boolean isFull(int row, int col){
        if (isOpen(row,col))
                return weightedQuickUnionUF.connected(first, toSingleDimension(row, col));

        return false;

    }  // is site (row, col) full?

    public  int numberOfOpenSites()   {
        return numberOfOpenSites;
    }

    public boolean percolates()        {
        return weightedQuickUnionUF.connected(first,last);
    }

    private void linkSite(int id,int target){
        if(opened[target]){
            if (!weightedQuickUnionUF.connected(id, target)){
                weightedQuickUnionUF.union(id, target);
            }
        }
    }
    private int toSingleDimension(int i, int j) {
        if (i <= 0 || i > n)
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > n)
            throw new IndexOutOfBoundsException("column index j out of bounds");
        return (n * (i - 1)) + (j-1 );
    }
}
