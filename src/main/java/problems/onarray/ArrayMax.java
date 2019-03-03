package problems.onarray;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayMax {
    public static int maxArrAdhoc(ArrayList<Integer> A) {
        int n = A.size();
        int maxSum = 0;
        int tempSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempSum = Math.abs(A.get(i) - A.get(j)) + Math.abs((i + 1) - (j + 1));
                if (tempSum > maxSum) {
                    System.out.println(i + 1 + " " + (j + 1));
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;

    }


    public static int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            if (A.get(i) + (i + 1) > max1)
                max1 = A.get(i) + (i + 1);

            if (A.get(i) + (i + 1) < min1)
                min1 = A.get(i) + (i + 1);

            if (A.get(i) - (i + 1) > max2)
                max2 = A.get(i) - (i + 1);

            if (A.get(i) - (i + 1) < min2)
                min2 = A.get(i) - (i + 1);
        }


        return Math.max((max1 - min1), (max2 - min2));
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> indx = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        indx.push(0);
        for (int i = 1; i < n; i++) {
            findSpecialValue(A, indx, left, i);
        }
        indx.clear();
        right[n - 1] = 0;
        indx.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            findSpecialValue(A, indx, right, i);
        }
        long product = 0, res = 0;
        for (int i = 0; i < A.size(); i++) {
            res = (long) left[i] * (long) right[i];
            if (product < res) {
                product = res;
            }
        }
        return (int) (product % 1000000007);

    }

    private static void findSpecialValue(ArrayList<Integer> A, Stack<Integer> indx, int[] left, int i) {
        while (!indx.empty()) {
            if (A.get(indx.peek()) > A.get(i)) {
                left[i] = indx.peek();
                indx.push(i);
                break;
            } else {
                indx.pop();
            }
        }
        if (indx.empty()) {
            left[i] = 0;
            indx.push(i);
        }
    }

    public static int[] maxset(int[] A) {
        long maxSum = 0;
        int start = -1, end = -1;
        for (int i = 0; i < A.length; i++) {
            int partStart = -1, partEnd = -1;
            long parSum = 0;
            partStart = i;
            while (i < A.length && A[i] >= 0) {
                parSum += A[i];
                i++;
            }
            partEnd = i - 1;
            if (partEnd < partStart)
                continue;


            if (parSum == maxSum) {
                if ((end - start) > (partEnd - partStart)) {
                    continue;
                } else if ((end - partEnd) == (partEnd - partStart)) {
                    if (partStart < start) {
                        end = partEnd;
                        start = partStart;
                    }
                } else {
                    end = partEnd;
                    start = partStart;
                }
            }
            if (parSum > maxSum) {
                maxSum = parSum;
                end = partEnd;
                start = partStart;
            }
        }
        if (start == -1 && end == -1) {
            return new int[0];
        } else if (start == end) {
            int res[] = new int[1];
            res[0] = A[start];
            return res;
        } else {
            int[] res = new int[(end - start) + 1];
            for (int j = 0, i = start; i <= end; i++, j++) {
                res[j] = A[i];
            }
            return res;
        }

    }

    public static int solve(String[] A) {
        double a[] = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = Double.parseDouble(A[i]);
        }
        double f = a[0], s = a[1], t = a[2];

        for (int i = 3; i < a.length; i++) {
            //if sum within range return 1
            if (1 < f + s + t && f + s + t < 2) {
                return 1;
            } else if (f + s + t > 2) { //else if sum >2 then replace max element with current array element
                if (f > s && f > t)
                    f = a[i];
                else if (s > f && s > t)
                    s = a[i];
                else t = a[i];
            } else {          //then sum must be less than 1 then replace min with current element
                if (f < s && f < t)
                    f = a[i];
                else if (s < f && s < t)
                    s = a[i];
                else
                    t = a[i];
            }

        }
        if (f + s + t > 1 && f + s + t < 2)
            return 1;

        return 0;
    }


    public static int[] flip(String A) {
        int[] res = new int[2];
        int num[] = new int[A.length()];
        char nums[] = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if (nums[i] == '0')
                num[i] = 1;
            else num[i] = -1;
        }
        int maxSum = 0, cumilative = 0, left = 0, maxRight = -1, maxLeft = 0;
        for (int i = 0; i < num.length; i++) {
            cumilative += num[i];
            if (cumilative < 0) {
                cumilative = 0;
                left = i + 1;
            } else if (cumilative > maxSum) {
                maxLeft = left + 1;
                maxSum = cumilative;
                maxRight = i + 1;
            }
        }
        if (maxRight > -1) {
            res[0] = maxLeft;
            res[1] = maxRight;
        }

        return res;
    }

    //pascals triangle
    public static int[][] printPascal(int A) {
        int prerow[] = new int[A];
        int currow[] = new int[A];
        int res[][] = new int[A][];
        int curRowNum = 1;

        for (int j = 0; j < A; j++) {
            for (int i = 0; i < curRowNum; i++) {
                if (prerow[i] == 0) {
                    currow[i] = 1;
                    break;
                } else {
                    if (i - 1 >= 0) {
                        currow[i] = prerow[i] + prerow[i - 1];
                    } else {
                        currow[i] = 1;
                    }
                }
            }
            res[j] = new int[curRowNum];
            for (int i = 0; i < curRowNum; i++) {
                prerow[i] = currow[i];
                res[j][i] = currow[i];
            }
            curRowNum++;

        }
        return res;

    }

    //pascals triangle
    public static int[] printPascalKth(int A) {
        int prerow[] = new int[A + 1];
        int currow[] = new int[A + 1];
        int curRowNum = 1;

        for (int j = 0; j <= A; j++) {
            for (int i = 0; i < curRowNum; i++) {
                if (prerow[i] == 0) {
                    currow[i] = 1;
                    break;
                } else {
                    if (i - 1 >= 0) {
                        currow[i] = prerow[i] + prerow[i - 1];
                    } else {
                        currow[i] = 1;
                    }
                }
            }

            for (int i = 0; i < curRowNum; i++) {
                prerow[i] = currow[i];
            }
            curRowNum++;

        }
        return currow;

    }

    public static int[][] diagonalArray(int a[][]) {
        if (a.length <=0) {
            return new int[0][0];
        }

        int res[][]= new int[a.length*2-1][];
        int pli[] = new int[a.length];
        int pri[] = new int[a.length];
        int cli[] = new int[a.length];
        int cri[] = new int[a.length];

        boolean stop = false;
            pri[0] = 0;
            pli[0] = 0;
            res[0] = new int[1];
            res[0][0] = a[0][0];
            int currentResIndex = 1;
            int pcount = 1;
            while (true && currentResIndex<res.length) {
                int ccount = 0;

                for (int i = 0; i < pcount; i++) {
                    if (pli[i] + 1 < a.length) {
                        cli[ccount] = pli[i] + 1;
                        cri[ccount] = pri[i];
                        ccount++;
                    }
                }
                if (pri[pcount-1]+1<a.length){
                    cli[ccount]=pli[pcount-1];
                    cri[ccount]=pri[pcount-1]+1;
                    ccount++;
                }
                res[currentResIndex]=new int[ccount];
                for (int i=0;i<ccount;i++){
                    res[currentResIndex][i]=a[cri[i]][cli[i]];
                    pri[i]=cri[i];
                    pli[i]=cli[i];
                }
                currentResIndex++;
                pcount=ccount;
                if (pcount==1){
                    break;
                }

            }

        return res;

    }

    public static void main(String[] args) {

//        int a[][] = {};
//        int b[][];
//        b = diagonalArray(a);


        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(5);
        aa.add(9);
        aa.add(6);
        aa.add(8);
        aa.add(6);

        ArrayList<Integer> bb = new ArrayList<>();
        bb=aa;
        aa.clear();


        /*printPascal(5);
        printPascalKth(3);
*/

        /*String s="0111000100010";

        System.out.println(flip(s)[0]);
        System.out.println(flip(s)[1]);
*/
       /* String[] a = {"2.673662", "2.419159", "0.573816", "2.454376", "0.403605", "2.503658", "0.806191"};
        System.out.println(solve(a));
        */
       /*

        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(5);
        aa.add(9);
        aa.add(6);
        aa.add(8);
        aa.add(6);
        aa.add(4);
        aa.add(6);
        aa.add(9);
        aa.add(5);
        aa.add(4);
        aa.add(9);
        int arr[] = {   1967513926, 1540383426, -1303455736, -521595368};
        int ssa[]=maxset(arr);
       */
/* System.out.println(maxArr(aa));
        System.out.println(maxArrAdhoc(aa));
       */


    }
}
