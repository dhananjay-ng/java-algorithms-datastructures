package algorithms.sort;

public class CountSort {
    public static void countSort(char arr[]) {
        int count[] = new int[26];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 97]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        char output[] = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[--count[arr[i] - 97]] = arr[i];
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        char[] arr = {'d', 'h', 'a', 'n', 'a', 'n', 'j', 'a', 'y'};
        System.out.println(arr);
        countSort(arr);
        System.out.println(arr);
    }
}
