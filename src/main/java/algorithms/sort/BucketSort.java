package algorithms.sort;

import java.util.ArrayList;

public class BucketSort {
      public static void  sort(double aa[],int n){
        ArrayList<ArrayList<Double>> buckets=new ArrayList<>(n);
        buckets.ensureCapacity(n);
        for (int i=0;i<aa.length;i++){
            int bi=(int)(aa[i]*n);
            buckets.get(bi).add(aa[i]);
        }
    }

    public static void main(String[] args) {
        double arr[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        int n = arr.length/2;
        sort(arr, n);

        System.out.println("Sorted array is" );
        for (int i=0; i<n; i++)
            System.out.println(arr[i]);

    }
}
