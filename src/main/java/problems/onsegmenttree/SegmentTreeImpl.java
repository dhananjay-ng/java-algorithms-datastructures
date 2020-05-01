package problems.onsegmenttree;

public class SegmentTreeImpl {

    public void build(int[] dest,int to, int from) {
        if (to < 0 || from <  0) return;
        for (int i=to;i<=from;i++){
            dest[i] = Math.min(dest[2*i+1],dest[2*i+2]);
        }
        build(dest,from-1, from-(to-from)/2);
    }

    public int[] buildSegmentTree(int[] src) {
        int n = src.length;
        int destSize = 2*n - 1 ;
        int segTree[] = new int[destSize];
        for (int i=n-1,j=destSize-1;i>0;i--,j--){
            segTree[j] = src[i];
        }
        build(segTree, segTree.length-n, segTree.length-n - (segTree.length-n)/2);
        return segTree;
    }

    public static void main(String[] args) {

    }
}
