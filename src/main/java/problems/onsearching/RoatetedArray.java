package problems.onsearching;

public class RoatetedArray {
    static class Solution {

        public int searchasc(int[] a, int key, int l, int h) {
            // int l = 0;
            // int h = a.length-1;
            if (l >= 0 && h < a.length) {
                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if (a[m] == key) {
                        return m;
                    } else if (a[m] > key) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

            }
            return -1;
        }

        public int searchdesc(int[] a, int key, int l, int h) {
            // int l = 0;
            // int h = a.length-1;
            if (l >= 0 && h <= a.length) {
                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if (a[m] == key) {
                        return m;
                    } else if (a[m] > key) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                }

            }
            return -1;
        }

        public int piv(final int[] a, int key) {
            int l = 0;
            int h = a.length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if ((m > 0 && a[m - 1] < a[m]) && (m + 1 < a.length && a[m] > a[m + 1])) {
                    return m;
                } else if (a[m] >= a[l]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return -1;
        }

        public int search(final int[] a, int key) {
            int pivot = piv(a, key);
            int asc = searchdesc(a, key, 0, Math.max(0, pivot - 1));
            if (asc > 0) return asc;
            int desc = searchasc(a, key, Math.max(pivot, 0), a.length - 1);
            return Math.max(-1, desc);
        }


        public int pivEle(final int[] a) {
            int l = 0;
            int h = a.length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if ((m > 0 && a[m - 1] < a[m]) && (m + 1 < a.length && a[m] > a[m + 1])) {
                    return a[m];
                } else if (a[m] >= a[l]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return -1;
        }


        public int solve(int[] a) {
            if (a.length == 1) return a[0];
            int piv = pivEle(a);
            if (piv > 0) return piv;
            if (a[0] > a[1]) return a[0];
            return a[a.length - 1];

        }


        public int searchmat(int[][] a, int key) {
            int l = 0;
            int h = a.length - 1;
            if (l >= 0 && h < a.length) {
                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if( a[m][0] == key || (a[m][0] < key  && a[m][a[m].length-1] >=key)) {
                        return m;
                    } else if (a[m][0] > key) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

            }
            return Math.min(l,a.length-1);
        }

        public int searchmatrow(int[][] a, int key, int rowno) {
            int l = 0;
            int h = a[0].length - 1;
                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if (a[rowno][m] == key) {
                        return m;
                    } else if (a[rowno][m] > key) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

            return -1;
        }

        public int search2power(long key) {
            long l = 0;
            long h = 100000;
                while (l <= h) {
                    long m = l + (h - l) / 2;
                    long blocks = (m*(m+1))/2;
                    if (blocks == key) {
                        return (int)m;
                    } else if (blocks > key) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                return (int) (l*(l+1)/2 > key ? l-1:l);
        }

    }

    //2


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{3, 3, 11, 12, 14},
                {16, 17, 30, 34, 35},
                {45, 48, 49, 50, 52},
                {56, 59, 63, 63, 65},
                {67, 71, 72, 73, 79},
                {80, 84, 85, 85, 88},
                {88, 91, 92, 93, 94}};

//        System.out.println(solution.searchmat(m,94));
//        System.out.println(solution.searchmatrow(m,94,solution.searchmat(m, 94)));

        System.out.println(solution.search2power(1000000000));

    }
}
