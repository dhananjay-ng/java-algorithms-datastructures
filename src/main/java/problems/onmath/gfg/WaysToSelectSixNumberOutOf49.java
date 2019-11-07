package problems.onmath.gfg;

public class WaysToSelectSixNumberOutOf49 {
    public static void main(String[] args) {
        int n = 49;
        for (int i = 0; i < n - 5; i++) {
            for (int j = i + 1; j < n-4; j++) {
                for (int k = j+1; k < n-3; k++) {
                    for (int l = k+1; l < n -2; l++) {
                        for (int m = l+1; m < n-1; m++) {
                            for (int o = m+1; o < n ; o++) {
                                System.out.println(i +","+j+","+k+","+l+","+m+","+o);
                            }
                        }
                    }
                }
            }

        }
    }
}
